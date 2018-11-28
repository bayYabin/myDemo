package com.qkc.mstation.common.model;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Dreampie
 * @date 2015-07-06
 * @what api 返回结果集
 */
public class ApiResult implements Serializable {
  private int code;//状态码
  private String message;//结果信息
  private Object data;//结果数据

  public ApiResult() {
  }

  public ApiResult(ApiCode apiCode) {
    this(apiCode.getCode(), apiCode.getMessage());
  }


  private ApiResult(int code, String message) {
    this.code = code;
    this.message = message;
  }

  private ApiResult(ApiCode apiCode, Object data) {
    this(apiCode.getCode(), apiCode.getMessage());
    this.data = data;
  }

  public static ApiResult ok() {
    return new ApiResult(ApiCode.OK);
  }

  public static ApiResult ok(Object value) {
    return new ApiResult(ApiCode.OK, value);
  }

  public static ApiResult ok(Map<String, Object> data) {
    return new ApiResult(ApiCode.OK, data);
  }

  public static ApiResult error(ApiCode code) {
    return new ApiResult(code);
  }

  public static ApiResult error(ApiCode code, Object value) {
    return new ApiResult(code, value);
  }


  public static ApiResult error(ApiCode code, Map<String, Object> data) {
    return new ApiResult(code, data);
  }

  public int getCode() {
    return code;
  }

  public ApiResult setCode(int code) {
    this.code = code;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public ApiResult setMessage(String message) {
    this.message = message;
    return this;
  }

  public Object getData() {
    return data;
  }

  public ApiResult setData(Map<String, Object> data) {
    this.data = data;
    return this;
  }
}
