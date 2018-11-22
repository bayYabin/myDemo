package com.qkc.mstation.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by qukoucai001 on 2018/11/22.
 */
public class MsRoom implements Serializable {
    private Long id;

    private Integer sourceId;

    private String roomName;

    private Integer roomType;

    private Integer roomContentType;

    private Date startTime;

    private Date endTime;

    private Integer passwordRequired;

    private String studentPwd;

    private String teacherPwd;

    private String assistantPwd;

    private String patrolPwd;

    private Integer videoType;

    private Integer videoFramerate;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private Long teacherId;

    private String roomThirdId;

    private String kcxUserId;

    private Integer roomCup;

    private Long homeworkTemplateId;

    private Long courseId;

    private Integer isEnd;

    private Long templateId;

    private Integer roomMark;

    private Integer classHour;

    private static final long serialVersionUID = 1L;

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

    public Integer getRoomContentType() {
        return roomContentType;
    }

    public void setRoomContentType(Integer roomContentType) {
        this.roomContentType = roomContentType;
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

    public String getKcxUserId() {
        return kcxUserId;
    }

    public void setKcxUserId(String kcxUserId) {
        this.kcxUserId = kcxUserId == null ? null : kcxUserId.trim();
    }

    public Integer getRoomCup() {
        return roomCup;
    }

    public void setRoomCup(Integer roomCup) {
        this.roomCup = roomCup;
    }

    public Long getHomeworkTemplateId() {
        return homeworkTemplateId;
    }

    public void setHomeworkTemplateId(Long homeworkTemplateId) {
        this.homeworkTemplateId = homeworkTemplateId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public Integer getRoomMark() {
        return roomMark;
    }

    public void setRoomMark(Integer roomMark) {
        this.roomMark = roomMark;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }
}
