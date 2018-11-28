package com.qkc.mstation.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MsRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "---------------------->>>>MsRoom{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", roomName='" + roomName + '\'' +
                ", roomType=" + roomType +
                ", isOperated=" + isOperated +
                ", roomContentType=" + roomContentType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", passwordRequired=" + passwordRequired +
                ", studentPwd='" + studentPwd + '\'' +
                ", teacherPwd='" + teacherPwd + '\'' +
                ", assistantPwd='" + assistantPwd + '\'' +
                ", patrolPwd='" + patrolPwd + '\'' +
                ", videoType=" + videoType +
                ", videoFramerate=" + videoFramerate +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", teacherId=" + teacherId +
                ", roomThirdId='" + roomThirdId + '\'' +
                ", kcxUserId='" + kcxUserId + '\'' +
                ", studengEntryUrl='" + studengEntryUrl + '\'' +
                ", teacherEntryUrl='" + teacherEntryUrl + '\'' +
                ", studentUrl='" + studentUrl + '\'' +
                ", teacherUrl='" + teacherUrl + '\'' +
                ", status='" + status + '\'' +
                ", ids=" + Arrays.toString(ids) +
                ", innerTime=" + innerTime +
                ", outerTime=" + outerTime +
                ", presentTime=" + presentTime +
                ", time01=" + time01 +
                ", time02=" + time02 +
                ", stuList=" + stuList +
                ", teacherName='" + teacherName + '\'' +
                ", roomCup=" + roomCup +
                ", homeworkId=" + homeworkId +
                ", homeworkTemplateId=" + homeworkTemplateId +
                ", studentName='" + studentName + '\'' +
                ", homeworkTime=" + homeworkTime +
                ", studentId=" + studentId +
                ", commentTime=" + commentTime +
                ", homeworkCups=" + homeworkCups +
                ", commentContent='" + commentContent + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teacherIds=" + teacherIds +
                ", stuIds=" + stuIds +
                ", templateId=" + templateId +
                ", isEnd=" + isEnd +
                ", roomMark=" + roomMark +
                ", classId=" + classId +
                ", time='" + time + '\'' +
                ", classType='" + classType + '\'' +
                ", className='" + className + '\'' +
                ", realStartTime=" + realStartTime +
                ", realEndTime=" + realEndTime +
                ", lateDuration='" + lateDuration + '\'' +
                ", leaveEarlyDuration='" + leaveEarlyDuration + '\'' +
                ", classStatus='" + classStatus + '\'' +
                ", note='" + note + '\'' +
                ", operateAccount='" + operateAccount + '\'' +
                ", msStartAndEnd=" + msStartAndEnd +
                ", msRealStartTime=" + msRealStartTime +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", kcxUserList=" + kcxUserList +
                ", qkcUserList=" + qkcUserList +
                '}'+"<<<------------------------------";
    }

    /**
     * 主键
     */
    private Long id;

    /**
     * 合作方(拓课云:1)
     */


    private Integer sourceId;
    private Integer roomStatus;
    private Integer isEvaluated;

    public Integer getIsEvaluated() {
        return isEvaluated;
    }

    public void setIsEvaluated(Integer isEvaluated) {
        this.isEvaluated = isEvaluated;
    }

    public Integer getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(Integer teacherType) {
        this.teacherType = teacherType;
    }

    private Integer teacherType;

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    private KcxUser kcxUser;

    public KcxUser getKcxUser() {
        return kcxUser;
    }

    public void setKcxUser(KcxUser kcxUser) {
        this.kcxUser = kcxUser;
    }

    public String getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }

    /**
     * 课堂名称
     */
    private String roomName;

    /**
     * 房间类型(1:一对一)
     */
    private Integer roomType;

    public Long getRealStartTime() {
        return realStartTime;
    }

    public void setRealStartTime(Long realStartTime) {
        this.realStartTime = realStartTime;
    }

    public Long getRealEndTime() {
        return realEndTime;
    }

    public void setRealEndTime(Long realEndTime) {
        this.realEndTime = realEndTime;
    }

    /**
     * 是否已经操作过

     * @return
     */
    public Integer getIsOperated() {
        return isOperated;
    }

    public void setIsOperated(Integer isOperated) {
        this.isOperated = isOperated;
    }

    private Integer isOperated;

    /**
     * 课堂内容类型(1-试听课,2-正式课)
     */
    private Integer roomContentType;

    /**
     * 课堂开始时间
     */
    private Date startTime;

    /**
     * 课堂结束时间
     */
    private Date endTime;

    /**
     * 是否需要密码
     */
    private Integer passwordRequired;

    /**
     * 学生密码
     */
    private String studentPwd;

    /**
     * 老师密码
     */
    private String teacherPwd;

    /**
     * 助教密码
     */
    private String assistantPwd;

    /**
     * 巡课密码
     */
    private String patrolPwd;

    /**
     * 视频分辨率
     */
    private Integer videoType;

    /**
     *视频帧率
     */
    private Integer videoFramerate;

    /**
     * 删除状态(0-未删除，1-删除)
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 老师的id
     */
    private Long teacherId;

    /**
     * 第三方的课堂号
     */
    private String roomThirdId;

    /**
     * 学员Id
     */
    private String kcxUserId;

    /**
     * 学生端直接进入地址
     */
    private String studengEntryUrl;

    /**
     * 教师端直接进入地址
     */
    private String teacherEntryUrl;

    /**
     * 学生端地址
     */
    private String studentUrl;

    /**
     * 老师端地址
     */
    private String teacherUrl;

    /**
     * 课堂状态(开课前-1,开课中-2,上课后-3)
     */
    private String status;

    private Long[] ids;
    /**
     * 查询的时间   用于CMS查询七天内、
     */
    private Date innerTime;
    /**
     * 七天外
     */
    private Date outerTime;
    /**
     * 当前时间
     */
    private Date presentTime;
    /**
     * 判断今天课唐用
     */
    private Date time01;
    /**
     * 判断今天课堂用
     */
    private Date time02;
    /**
     * 存放课堂中对应的学员的名字
     */
    private List<String> stuList;
    /**
     * 关联老师的名字
     */
    private String teacherName;

    /**
     * 上课课堂获取的奖杯数
     */
    private Integer roomCup;

    /**
     * 作业Id
     */
    private Long homeworkId;

    /**
     * 作业模版Id
     */
    private Long homeworkTemplateId;

    /**
     * 学员姓名
     */
    private String studentName;

    /**
     * 作业时间
     */
    private Date homeworkTime;

    /**
     * 学生Id
     */
    private Long studentId;

    /**
     * 点评时间
     */
    private Date commentTime;

    /**
     * 该点评的奖杯数
     */
    private Integer homeworkCups;

    /**
     * 点评内容
     */
    private String commentContent;
    /**
     * 关联课程的id
     */
    private Long courseId;
    /**
     * 课程的名字 （展示用）
     */
    private String courseName;
    /**
     * 根据老师查询的时候使用   老师的id集合
     */
    private List<Long> teacherIds;
    /**
     * 根据学员查询时使用  房间id的集合
     */
    private List<Long> stuIds;
    /**
     * 课堂模板id
     */
    private Long templateId;
    /**
     * 该课堂是否结束  0：未结束   1：结束
     */
    private Integer isEnd;
    /**
     * 课程进行状态  1：已上   2：未上    3：异常结束
     */
    private Integer roomMark;
    private Integer classId;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 时间戳用于比较
     */
    private String time;

    private String classType;
    private String className;

    private Long realStartTime;
    private Long realEndTime;
    private String lateDuration;
    private String leaveEarlyDuration;
    private String classStatus;
    private String note;
    private String operateAccount;

    private List<MsStartAndEnd> msStartAndEnd;
    private List<MsRealStartTime> msRealStartTime;

    private Integer classHour;//一堂课所占课时

    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public List<MsStartAndEnd> getMsStartAndEnd() {
        return msStartAndEnd;
    }

    public void setMsStartAndEnd(List<MsStartAndEnd> msStartAndEnd) {
        this.msStartAndEnd = msStartAndEnd;
    }

    public List<MsRealStartTime> getMsRealStartTime() {
        return msRealStartTime;
    }

    public void setMsRealStartTime(List<MsRealStartTime> msRealStartTime) {
        this.msRealStartTime = msRealStartTime;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    private String teacherPhone;

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }


    private String studentPhone;

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }




    public String getLateDuration() {
        return lateDuration;
    }

    public void setLateDuration(String lateDuration) {
        this.lateDuration = lateDuration;
    }

    public String getLeaveEarlyDuration() {
        return leaveEarlyDuration;
    }

    public void setLeaveEarlyDuration(String leaveEarlyDuration) {
        this.leaveEarlyDuration = leaveEarlyDuration;
    }



    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOperateAccount() {
        return operateAccount;
    }

    public void setOperateAccount(String operateAccount) {
        this.operateAccount = operateAccount;
    }




    private List<KcxUser> kcxUserList;
    private List<QkcUser> qkcUserList;

    public List<QkcUser> getQkcUserList() {
        return qkcUserList;
    }

    public void setQkcUserList(List<QkcUser> qkcUserList) {
        this.qkcUserList = qkcUserList;
    }

    public List<KcxUser> getKcxUserList() {
        return kcxUserList;
    }

    public void setKcxUserList(List<KcxUser> kcxUserList) {
        this.kcxUserList = kcxUserList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getRoomMark() {
        return roomMark;
    }

    public void setRoomMark(Integer roomMark) {
        this.roomMark = roomMark;
    }

    public Integer getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Integer isEnd) {
        this.isEnd = isEnd;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public List<Long> getStuIds() {
        return stuIds;
    }

    public void setStuIds(List<Long> stuIds) {
        this.stuIds = stuIds;
    }

    public List<Long> getTeacherIds() {
        return teacherIds;
    }

    public void setTeacherIds(List<Long> teacherIds) {
        this.teacherIds = teacherIds;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getHomeworkCups() {
        return homeworkCups;
    }

    public void setHomeworkCups(Integer homeworkCups) {
        this.homeworkCups = homeworkCups;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getHomeworkTime() {
        return homeworkTime;
    }

    public void setHomeworkTime(Date homeworkTime) {
        this.homeworkTime = homeworkTime;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getTime01() {
        return time01;
    }

    public void setTime01(Date time01) {
        this.time01 = time01;
    }

    public Date getTime02() {
        return time02;
    }

    public void setTime02(Date time02) {
        this.time02 = time02;
    }

    public Date getPresentTime() {
        return presentTime;
    }

    public void setPresentTime(Date presentTime) {
        this.presentTime = presentTime;
    }

    public Date getInnerTime() {
        return innerTime;
    }

    public void setInnerTime(Date innerTime) {
        this.innerTime = innerTime;
    }

    public Date getOuterTime() {
        return outerTime;
    }

    public void setOuterTime(Date outerTime) {
        this.outerTime = outerTime;
    }

    public List<String> getStuList() {
        return stuList;
    }

    public void setStuList(List<String> stuList) {
        this.stuList = stuList;
    }

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudengEntryUrl() {
        return studengEntryUrl;
    }

    public void setStudengEntryUrl(String studengEntryUrl) {
        this.studengEntryUrl = studengEntryUrl;
    }

    public String getStudentUrl() {
        return "demo.talk-cloud.net/"+getRoomThirdId()+"/10821/"+getPasswordRequired()+"/2";
    }

    public void setStudentUrl(String studentUrl) {
        this.studentUrl = studentUrl;
    }

    public String getTeacherUrl() {
        return "demo.talk-cloud.net/"+getRoomThirdId()+"/10821/1/0";
    }

    public void setTeacherUrl(String teacherUrl) {
        this.teacherUrl = teacherUrl;
    }

    public String getKcxUserId() {
        return kcxUserId;
    }

    public void setKcxUserId(String kcxUserId) {
        this.kcxUserId = kcxUserId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPasswordRequired() {
        return passwordRequired;
    }

    public void setPasswordRequired(Integer passwordRequired) {
        this.passwordRequired = passwordRequired;
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd == null ? null : studentPwd.trim();
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd == null ? null : teacherPwd.trim();
    }

    public String getAssistantPwd() {
        return assistantPwd;
    }

    public void setAssistantPwd(String assistantPwd) {
        this.assistantPwd = assistantPwd == null ? null : assistantPwd.trim();
    }

    public String getPatrolPwd() {
        return patrolPwd;
    }

    public void setPatrolPwd(String patrolPwd) {
        this.patrolPwd = patrolPwd == null ? null : patrolPwd.trim();
    }

    public Integer getVideoType() {
        return videoType;
    }

    public void setVideoType(Integer videoType) {
        this.videoType = videoType;
    }

    public Integer getVideoFramerate() {
        return videoFramerate;
    }

    public void setVideoFramerate(Integer videoFramerate) {
        this.videoFramerate = videoFramerate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getRoomThirdId() {
        return roomThirdId;
    }

    public void setRoomThirdId(String roomThirdId) {
        this.roomThirdId = roomThirdId == null ? null : roomThirdId.trim();
    }

    public Integer getRoomContentType() {
        return roomContentType;
    }

    public void setRoomContentType(Integer roomContentType) {
        this.roomContentType = roomContentType;
    }

    public String getTeacherEntryUrl() {
        return teacherEntryUrl;
    }

    public void setTeacherEntryUrl(String teacherEntryUrl) {
        this.teacherEntryUrl = teacherEntryUrl;
    }

    public Integer getRoomCup() {
        return roomCup;
    }

    public void setRoomCup(Integer roomCup) {
        this.roomCup = roomCup;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Long getHomeworkTemplateId() {
        return homeworkTemplateId;
    }

    public void setHomeworkTemplateId(Long homeworkTemplateId) {
        this.homeworkTemplateId = homeworkTemplateId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}