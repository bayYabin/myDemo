package com.qkc.mstation.controller;


import com.qkc.mstation.common.model.ApiResult;
import com.qkc.mstation.common.model.Page;
import com.qkc.mstation.dto.MsAppointmentDto;
import com.qkc.mstation.dto.MsAppointmentPlus;
import com.qkc.mstation.dto.QkcTeacherDto;
import com.qkc.mstation.pojo.MsAppointment;
import com.qkc.mstation.pojo.QkcTeacher;

import com.qkc.mstation.service.MsAppointmentService;
import com.qkc.mstation.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.qkc.mstation.util.DateUtil.getStartEndWeek;


/**
 * Created by qukoucai001 on 2018/10/20.
 */


@RestController
@RequestMapping("/appointment")
public class ApppointmentController {

    private static final Logger logger = LoggerFactory.getLogger(ApppointmentController.class);

    @Autowired
    private MsAppointmentService msAppointmentService;





    /**
     * 分页查询约课列表
     *
     * @param teacherName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ApiResult findListByConditions(
            @RequestParam(value = "teacherName", required = false) String teacherName,
            @RequestParam(value = "teacherPhone", required = false) String teacherPhone,
            @RequestParam(value = "startTime", required = false) Long startTime,
            @RequestParam(value = "endTime", required = false) Long endTime,
            @RequestParam(value = "exportAll", required = false) Boolean exportAll,
            @RequestParam(value = "freePeriods[]", required = false) Long[] freePeriods,
            @RequestParam(value = "appointedPeriods[]", required = false) Long[] appointedPeriods,
            Integer pageNo, Integer pageSize) throws ParseException {
        logger.info("分页查询约课列表接口开始调用,参数-->teacherName:" + teacherName +
                ",teacherPhone:" + teacherPhone +
                ",startTime:" + startTime
                + ",endTime:" + endTime +
                ",exportAll:" + exportAll +
                ",freePeriods:" + freePeriods +
                ",appointedPeriods:" + appointedPeriods);
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        Date start = new Date();
        if (startTime != null) {
            logger.info("开始时间时间戳:" + startTime);
            start.setTime(startTime - startTime % (24 * 3600 * 1000) - 8 * 3600 * 1000 + 24 * 3600 * 1000 - 1 * 24 * 3600 * 1000);
            logger.info("处理后的开始时间:" + start);
        } else {
            start = null;
        }

        Date end = new Date();
        if (endTime != null) {
            logger.info("结束时间时间戳:" + endTime);
            end.setTime(endTime - endTime % (24 * 3600 * 1000) - 8 * 3600 * 1000 + 24 * 3600 * 1000);
            logger.info("处理后的结束时间:" + end);
        } else {
            end = null;
        }

        logger.info("调用查询接口findListByConditions，参数-->teacherName:" + teacherName + ",teacherPhone:" + teacherPhone);
        List<QkcTeacher> qkcTeacherList = msAppointmentService.findListByConditions(teacherName, teacherPhone);

        logger.info("调用查询接口findListByConditions成功，返回值数量:" + qkcTeacherList.size() + "个");


        List<QkcTeacher> dateNull = new ArrayList<>();


        Set<MsAppointmentPlus> set = new HashSet<>();
        for (QkcTeacher teacher : qkcTeacherList) {
            if (teacher.getDate() != null) {
                MsAppointmentPlus temp = new MsAppointmentPlus(teacher.getMsAppointment());
                temp.setId(Integer.parseInt(teacher.getId() + ""));
                temp.setName(teacher.getTeacherName());
                temp.setDate(teacher.getDate());
                temp.setPhone(teacher.getPhone());
                temp.setTeacherType(teacher.getTeacherType());
                temp.setMsAppointment(teacher.getMsAppointment());
                set.add(temp);
            } else {
                dateNull.add(teacher);
            }

        }
        List<QkcTeacher> qkcTeacherList_ = new ArrayList<>();
        for (MsAppointmentPlus msAppointment : set) {
            QkcTeacher teacher = new QkcTeacher();
            teacher.setDate(msAppointment.getDate());
            teacher.setId(Long.parseLong(msAppointment.getId() + ""));
            teacher.setTeacherName(msAppointment.getName());
            teacher.setPhone(msAppointment.getPhone());
            teacher.setTeacherType(msAppointment.getTeacherType());
            teacher.setMsAppointment(msAppointment.getMsAppointment());
            qkcTeacherList_.add(teacher);
        }

        qkcTeacherList_.addAll(dateNull);
        qkcTeacherList.clear();
        qkcTeacherList.addAll(qkcTeacherList_);


        //获取两周的开始时间
        Date weekStart = getStartEndWeek().get("startTime");

        //用于操作的列表
        List<QkcTeacher> qkcTeacherListOperated = new ArrayList<>();
        qkcTeacherListOperated.addAll(qkcTeacherList);
        //将全职老师虚拟为两周的记录
        Iterator<QkcTeacher> qkcTeacher = qkcTeacherListOperated.iterator();
        Set<Long> addedTeacherIds = new HashSet<>();
        while (qkcTeacher.hasNext()) {
            QkcTeacher teacher = qkcTeacher.next();
            List<QkcTeacher> fullVirtualList = new ArrayList<>();
            if (teacher.getTeacherType() == 2) {
                if (teacher.getDate() == null) {
                    //没有约课成功记录
                    for (int i = 0; i < 14; i++) {
                        QkcTeacher virtualTeacher = new QkcTeacher();
                        Date date = new Date();
                        Long dayUnit = 1 * 24 * 3600 * 1000L;
                        date.setTime(weekStart.getTime() + dayUnit * i);
                        virtualTeacher.setDate(date);
                        virtualTeacher.setId(teacher.getId());
                        virtualTeacher.setTeacherName(teacher.getTeacherName());
                        virtualTeacher.setTeacherType(teacher.getTeacherType());
                        virtualTeacher.setPhone(teacher.getPhone());
                        fullVirtualList.add(virtualTeacher);
                    }
                    qkcTeacher.remove();
                    qkcTeacherList.addAll(fullVirtualList);
                } else {
                    //有约课成功记录
                    if (!addedTeacherIds.contains(teacher.getId())) {
                        for (int i = 0; i < 14; i++) {
                            QkcTeacher virtualTeacher = new QkcTeacher();
                            Date date = new Date();
                            Long dayUnit = 1 * 24 * 3600 * 1000L;
                            date.setTime(weekStart.getTime() + dayUnit * i);
                            virtualTeacher.setDate(date);
                            virtualTeacher.setId(teacher.getId());
                            virtualTeacher.setTeacherName(teacher.getTeacherName());
                            virtualTeacher.setTeacherType(teacher.getTeacherType());
                            virtualTeacher.setPhone(teacher.getPhone());
                            if (!teacherIsIn(virtualTeacher, qkcTeacherList)) {
                                fullVirtualList.add(virtualTeacher);
                            }
                        }
                        qkcTeacherList.addAll(fullVirtualList);
                    }
                    addedTeacherIds.add(teacher.getId());

                }

            }
        }


        //将date为空的老师删除
        Iterator<QkcTeacher> dateIsNull = qkcTeacherList.iterator();
        while (dateIsNull.hasNext()) {
            QkcTeacher temp = dateIsNull.next();
            if (temp.getDate() == null) {
                dateIsNull.remove();
                continue;
            }
            logger.info("调用查询接口findListByConditions成功，返回值-->id:" + temp.getId() +
                    ",TeacherName:" + temp.getTeacherName() +
                    ",Phone:" + temp.getPhone() +
                    ",TeacherType:" + temp.getTeacherType());

        }


        for (QkcTeacher teacher : qkcTeacherList) {
            if (teacher.getDate() == null) {
                logger.info("(默认为全职老师)老师约课信息为null,老师信息:" + teacher);
                //全职虚拟
                Date dayBeginning = new Date();
                dayBeginning.setTime(DateUtil.dayBeginning());
                teacher.setDate(dayBeginning);
                //虚拟出来的全职老师空闲时间
                logger.info("老师约课信息为null,虚拟信息开始");
                List<MsAppointment> virtalDay = DateUtil.getDailyRawAppointment(dayBeginning, 1);
                logger.info("虚拟的信息数量:" + virtalDay.size() + "个");

                for (MsAppointment temp : virtalDay) {
                    logger.info("虚拟的信息-->Status:" + temp.getStatus() +
                            ",Date:" + temp.getDate() +
                            ",StartTim:" + temp.getStartTime());
                }
                logger.info("老师约课信息为null,虚拟信息结束");
                teacher.setMsAppointments(virtalDay);
            } else {
                logger.info("老师约课信息不为null,老师信息-->id:" + teacher.getId() +
                        ",TeacherName:" + teacher.getTeacherName() +
                        ",Phone:" + teacher.getPhone());
                //兼职或者全职，均有数据
                Integer teacherId = Integer.parseInt(teacher.getId() + "");
                //查询出来的数据
                logger.info("调用查询接口selectByTeacherIdAndDate-->date:" + teacher.getDate() + ",teacherId:" + teacherId);
                List<MsAppointment> msAppointments = msAppointmentService.selectByTeacherIdAndDate(teacher.getDate(), teacherId);
                logger.info("调用查询接口selectByTeacherIdAndDate,结果数量:" + msAppointments.size() + "个");

                for (MsAppointment temp : msAppointments) {
                    logger.info("调用查询接口selectByTeacherIdAndDate,结果-->id:" + temp.getId() +
                            ",TeacherId:" + temp.getTeacherId() +
                            ",Status:" + temp.getStatus() +
                            ",TeacherType:" + temp.getTeacherType() +
                            ",Date:" + temp.getDate() +
                            ",StartTime:" + temp.getStartTime());
                }
                if (msAppointments.size() > 0 && msAppointments.get(0).getStatus() - 3 == 0) {
                    logger.info("休的记录");
                    continue;
                }
                teacher.setMsAppointments(msAppointments);
            }


//
            List<MsAppointment> dailyTrue = teacher.getMsAppointments();
            List<MsAppointment> dailyRaw_ = null;
            Set<MsAppointment> msAppointmentSet = new HashSet<>();
            if (dailyTrue != null && dailyTrue.size() > 0) {
                for (MsAppointment msAppointment : dailyTrue) {


                    if (msAppointment.getStartTime() == null) {
                        logger.info("<-->" + msAppointment);
                        return null;
                    }


                    Long startTime_ = msAppointment.getStartTime().getTime();


                    if (startTime_ >= 3600000 && startTime_ <= (45000000 + 3600 * 1000)) {
                        msAppointmentSet.add(msAppointment);
                    }

                }
            }


            if (teacher.getTeacherType().equals(1)) {
                Date date = teacher.getDate();
                dailyRaw_ = DateUtil.getDailyRawAppointment(date, 0);
            } else if (teacher.getTeacherType().equals(2)) {
                Date date = new Date();
                if (teacher.getDate() == null) {
                    date.setTime(DateUtil.dayBeginning());
                } else {
                    date.setTime(teacher.getDate().getTime());
                }

                dailyRaw_ = DateUtil.getDailyRawAppointment(date, 1);
            }

            for (MsAppointment msAppointment : dailyRaw_) {
                msAppointmentSet.add(msAppointment);
            }
            dailyRaw_.clear();
            for (MsAppointment msAppointment : msAppointmentSet) {
                dailyRaw_.add(msAppointment);
            }
            Collections.sort(dailyRaw_);
            teacher.setMsAppointments(dailyRaw_);
        }


        List<QkcTeacherDto> teacherDtos = new ArrayList<>();
        for (QkcTeacher day : qkcTeacherList) {
            List<MsAppointment> msAppointments = day.getMsAppointments();
            List<Long> free = new ArrayList<>();
            List<Long> appointed = new ArrayList<>();


            try {
                for (MsAppointment msAppointment : msAppointments) {
                    if (msAppointment == null) {
                        continue;
                    }
                    if (msAppointment.getStatus() != null && msAppointment.getStatus() == 1) {
                        free.add(msAppointment.getStartTime().getTime());
                    }
                    if (msAppointment.getStatus() != null && msAppointment.getStatus() == 2) {
                        appointed.add(msAppointment.getStartTime().getTime());
                    }
                }
            } catch (NullPointerException n) {
                logger.info("---->day:" + day);
                logger.info("---->msAppointments:" + msAppointments);
            }


            day.setFreePeriods(free);
            day.setAppointedPeriods(appointed);
            QkcTeacherDto qkcTeacherDto = new QkcTeacherDto();
            qkcTeacherDto.setId(day.getId());
            qkcTeacherDto.setTeacherType(day.getTeacherType());
            qkcTeacherDto.setDate(day.getDate());
            qkcTeacherDto.setFreePeriods(day.getFreePeriods());
            qkcTeacherDto.setAppointedPeriods(day.getAppointedPeriods());
            qkcTeacherDto.setTeacherName(day.getTeacherName());
            qkcTeacherDto.setTeacherPhone(day.getPhone());
            teacherDtos.add(qkcTeacherDto);
        }


        //帅选条件
        Iterator<QkcTeacherDto> it_ = teacherDtos.iterator();
        while (it_.hasNext()) {
            QkcTeacherDto teacherDto = it_.next();
//            boolean freeBoo=false;
//            boolean AppedBoo=false;
            int count = 0;
            List<Long> freeList = teacherDto.getFreePeriods();
            List<Long> appedList = teacherDto.getAppointedPeriods();
            if (freePeriods != null) {
                free:
                for (Long free : freePeriods) {
                    for (Long longNum : freeList) {
                        if (longNum.equals(free)) {
//                            freeBoo=true;
                            count++;
                            logger.info("--freePeriods-->" + teacherDto);
                            break free;
                        }
                    }
                }
            }
            if (appointedPeriods != null) {
                apped:
                for (Long apped : appointedPeriods) {
                    for (Long longNum : appedList) {
                        if (longNum.equals(apped)) {
//                            AppedBoo=true;
                            count++;
                            logger.info("--appointedPeriods-->" + teacherDto);
                            break apped;
                        }
                    }
                }
            }

            if ((appointedPeriods != null || freePeriods != null) && count == 0) {
//                if(!AppedBoo){
//                    if(!freeBoo){
                it_.remove();
                logger.info("时间段去除");
//                    }
//                }
            }
            count = 0;

        }


        if (start != null && end != null) {
//            start.setTime(startTime);
            Iterator<QkcTeacherDto> it = teacherDtos.iterator();
            while (it.hasNext()) {
                QkcTeacherDto teacherDto = it.next();
                logger.info("date-->" + teacherDto.getDate());
                if (teacherDto.getDate().getTime() >= start.getTime() &&
                        teacherDto.getDate().getTime() < end.getTime()) {
                    logger.info("日期搜索时保留的值" + teacherDto);
                } else {
                    it.remove();
                }
            }
        }


        //全部导出开始时间
        Date exportStart_ = new Date();
        //全部导出结束时间
        Date exportEnd_ = new Date();
        if (exportAll != null && exportAll) {
            Map<String, Date> map = getStartEndWeek();
            exportStart_.setTime(map.get("startTime").getTime());
            exportEnd_.setTime(map.get("endTime").getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            logger.info("-startTime:" + sdf.format(map.get("startTime")));
            logger.info("-endTime:" + sdf.format(map.get("endTime")));
            Iterator<QkcTeacherDto> it = teacherDtos.iterator();
            while (it.hasNext()) {
                QkcTeacherDto teacherDto = it.next();
                if (teacherDto.getDate().getTime() >= exportStart_.getTime() &&
                        teacherDto.getDate().getTime() < exportEnd_.getTime()) {
                } else {
                    it.remove();
                }
            }

        } else {
            exportStart_ = null;
            exportEnd_ = null;
        }


        //分页处理
        List<QkcTeacherDto> qkcTeachersResult = teacherDtos;
        List<QkcTeacherDto> qkcTeachersFront = new ArrayList<>();
        if (qkcTeachersResult.size() == 0) {
            Page<QkcTeacherDto> front = new Page<>();
            front.setCount(qkcTeachersResult.size());
            front.setNum(pageNo);
            front.setSize(pageSize);
            front.setList(qkcTeachersFront);
            return ApiResult.ok(front);
        }
        int size = qkcTeachersResult.size();
        int mod = size % pageSize;

        if (mod == 0) {
            pageNo = pageNo > ((size - mod) / pageSize) ? (size - mod) / pageSize : pageNo;
            for (int i = pageSize * (pageNo - 1); i < pageSize * (pageNo - 1) + pageSize; i++) {
                qkcTeachersFront.add(qkcTeachersResult.get(i));
            }
        } else {
            if (pageNo > ((size - mod) / pageSize)) {

                pageNo = ((size - mod) / pageSize) + 1;
                for (int i = 0; i < mod; i++) {
                    qkcTeachersFront.add(qkcTeachersResult.get(size - i - 1));
                }

            } else {
                for (int i = pageSize * (pageNo - 1); i < pageSize * (pageNo - 1) + pageSize; i++) {
                    qkcTeachersFront.add(qkcTeachersResult.get(i));
                }
            }
        }
        Page<QkcTeacherDto> front = new Page<>();
        front.setCount(qkcTeachersResult.size());
        front.setNum(pageNo);
        front.setSize(pageSize);
        front.setList(qkcTeachersFront);
        return ApiResult.ok(front);
    }







    /**
     * 判断老师是否在某个列表中
     * @param qkcTeacher
     * @param qkcTeachers
     * @return
     */
    static boolean teacherIsIn(QkcTeacher qkcTeacher, List<QkcTeacher> qkcTeachers){
        boolean flag=false;
        for(QkcTeacher temp: qkcTeachers){
            if(temp.getDate()==null){
                continue;
            }
            if(temp.getDate().getTime()-qkcTeacher.getDate().getTime()==0&&
                    temp.getId()-qkcTeacher.getId()==0){
                flag=true;
                break;
            }
        }
        return flag;
    }




}
