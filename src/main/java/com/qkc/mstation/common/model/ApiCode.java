package com.qkc.mstation.common.model;

import java.io.Serializable;

/**
 * @author Dreampie
 * @date 2015-07-06
 * @what 编码和信息
 */
public enum ApiCode implements Serializable {

  GET_IDENCODE_ERROR(4001,"获取验证码错误"),
  USER_IS_FROZEN(4002,"您的账号存在异常，已被冻结；重新启用请联系客服"),
  IDENCODE_ERROR(4003,"验证码错误"),


  HOMEWORK_HAS_BEEN_COMMENTED(4101,"该作业已经点评过了，请不要重复点评"),

  INTERFACE_PARAMETER_EXISTS(510001, "这个地址参数已经有了! ( ⊙ o ⊙ )"),

  PWD_ERROR(438,"账号或密码错误"),
  NAME_ISHAVE(439,"该用户已存在"),
  NO_REGISTER(440,"您还没有注册，请注册后再来登录"),
  IS_RELEVANCY(441,"该房间已关联老师"),
  NO_HOMEWORK(442,"该房间未关联作业模板"),
  IS_HAVEWORK(443,"该房间已提交作业，请不要重复提交"),
  NO_STUDENT(444,"对不起该学员不在该课堂中"),
  NOT_CONFORM(445,"所传信息和查询信息不符合"),
  NOT_UPDATE(446,"该条数据不能修改"),
  HAVE_HOMEWORK(447,"该房间已关联作业模板"),
  NOT_NULL(448,"所传信息为空"),
  NO_PWDEQUL(449,"新密码不能和旧密码相同"),
  RELE_HOMEWORK(450,"该课程已关联作业模板"),
  IS_COURSEWARE(451,"该课程已关联该课件"),
  NOT_COURSEWARE(452,"该课件不存在"),
  NO_COURSEWARE(453,"该课程未关联该课件"),
  IS_HAVACOURSE(454,"该课堂已关联课程"),
  NO_HAVACOURSE(455,"该课堂未关联课程"),
  NO_ROOM(456,"该课堂不存在"),
  IS_RELECOURSE(457,"该课件已被课程关联"),
  NO_ADDCOURSE(458,"该类型课程已存在"),
  CODE_IS_NULL(459,"未取到图片验证码"),
  CODE_ERROR(460,"图片验证码错误"),
  CRM_ERROR(461,"连接CRM错误"),
  CRM_ADD(462,"新增客户错误"),
  QIAN_ERR(463,"签名错误"),
  PITCH_ERR(464,"批量修改错误"),
  NO_TEMPLATE(465,"该房间没有课堂模板，暂时不能顺延"),
  ERR_POSTPONE(466,"顺延失败"),
  OLD_TEMPLATE(467,"该课堂模板为旧模板，暂时不能用该功能顺延"),
  ERR_START(468,"起始课节超过总课节，请重新输入"),
  WX_ERROR(469,"微信获取openID失败"),
  TICKET_ERROR(470,"获取ticket错误"),
  DUPLICATION_ERROR(471,"所传数据有异常或重复"),
  APPLY_REST_FILE(472,"今日有课,休息申请失败"),
  EDIT_TEACHER_FILE(473,"编辑老师失败"),
  RELVE_FILE(474,"关联老师失败"),
  TEACHER_NULL(475,"老师为空"),
  TIME_NULL(476,"预约时间已被占用，建议您换一个预约时间"),
  COURSEBAG_ID_NULL(477,"课程包id为空"),
  ROOM_NULL(478,"课堂为空"),
  PAST_APPONITED_FAIL(479,"已过课程不能预约"),
  CLASS_HOUR_FAIL(480,"您的课时数量为0，无法完成预约"),
  ROOM_CREATE_FAIL(481,"新建课堂失败"),
  APPONITED_FAIL(483,"约课失败"),
  TIME_CANCAL_FAIL(484,"24小时之内课程不能取消"),
  CANCAL_FAIL(485,"取消约课失败"),
  ROOM_DELETE_FAIL(486,"Room主表删除失败"),
  USER_ROOM_DELETE_FAIL(487,"UserRoom从表删除失败"),
  PERSON_OVER_TAKE(488,"人数超过规定的人数"),
  TOMORROW_ALLOWED(489,"只能预约明天的课"),
  YOU_ARE_RESTED(490,"本周你已经选择休息了"),
  REST_APPLY_FAIL(491,"休息申请失败"),
  TEACHER_OCCUPATION(492,"老师空闲时间占用"),
  EDIT_FAIL(493,"编辑课堂失败"),
  ROOM_EMPTY(494,"要修改且没上的房间为空"),
  TIME_FORMATE_ERROR(495,"开始时间需要小于结束时间"),
  LESS_THAN_FIVE_MIN(602,"开始时间少于5分钟"),
  USER_NUM_ERRRO(606,"关联学生数量异常"),
  UN_APPED(605,"该堂课未关联学生"),
  USER_NULL(604,"用户为空"),
  MORE_THAN_ONE(603,"多于一条"),
  EVAL_TEMPLATE_NULL(608,"评价模板为空"),
  NOT_EVAL_YET(609,"尚未评价"),
  EVAL_EDIT_FAIL(601,"评价模板编辑失败"),
  EVAL_CREATE_FAIL(600,"评价模板添加失败"),
  EVAL_DEL_FAIL(607,"评价模板删除失败"),
  RELATE_EVAL_FAIL(608,"关联课程评价模板失败"),
  COURSE_NULL(609,"课程为空"),
  COURSE_RELATED_EVAL(610,"课程已经关联过评价模板了"),
  EVAL_RELATED(611,"该模板已经关联过课程了"),


  BAD_REQUEST(400, "请求错误"),
  UNAUTHORIZED(401, "未认证"),
  FORBIDDEN(403, "没有权限访问"),
  NOT_FOUND(404, "请求资源不存在"),
  MOBILE_NOT_FOUND(406, "移动端不可见"),
  IOS_NOT_FOUND(407, "IOS端不可见"),
  ALL_NOT_FOUND(408, "已下架"),

  TOO_MANY_REQUESTS(429, "请求次数超过限制"),
  UNPROCESSABLE_ENTITY(422, "请求参数错误"),
  DEVICETYPE_ERROR(422001, "deviceType不合法"),
  COMMON_HEADER_UDID_MISSING(422002, "udid缺失"),
  COMMON_HEADER_DEVICETYPE_MISSING(422003, "deviceType缺失"),
  COMMON_HEADER_APPVERSION_MISSING(422004, "appVersion缺失"),
  COMMON_HEADER_MARKET_MISSING(422005, "market缺失"),
  COMMON_HEADER_RESOLUTION_MISSING(422006, "resolution缺失"),
  NO_JC_CHANNEL_ERROR(423, "主站分类id不存在"),
  INTERNAL_SERVER_ERROR(500, "服务器错误"),
  MD5_SIGN_ERROR(500001, "MD5加密错误"),
  SERVICE_UNAVAILABLE(503, "接口不存在或无效"),
  THIRD_SERVER_ERROR(504, "第三方服务器错误"),
  OK(200, "OK"),
  PARTNER_DATA_EXIT(6001, "数据已存在"),
  LOAD_IMAGE_DATA_EXIT(7000, "图包数据已存在");









  private int code;
  private String message;

  private ApiCode(int code, String messasge) {
    this.code = code;
    this.message = messasge;
  }

  public static ApiCode codeOf(int code) {
    for (ApiCode apiCode : values()) {
      if (apiCode.code == code) {
        return apiCode;
      }
    }
    throw new IllegalArgumentException("Invalid HTTP Status code : " + code);
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
