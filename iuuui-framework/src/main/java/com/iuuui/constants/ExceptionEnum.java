package com.iuuui.constants;

/**
 * @author iuuui
 * @time 20230227 2131
 */
public enum ExceptionEnum {

    DATA_EXCEPTION("data_exception", "data exception"), // 数据异常
    DATA_DOES_NOT_EXIST_EXCEPTION("data_does_not_exist_exception", "data does not exist exception"), // 数据不存在
    DATA_ALREADY_EXIST_EXCEPTION("data_already_exist_exception", "data already exist exception"), // 数据已存在
    PARAMETER_EXCEPTION("parameter_exception", "parameter exception"), // 参数异常
    PARAMETER_EMPTY_EXCEPTION("parameter_empty_exception", "parameter empty exception"); // 参数空异常

    private String code;
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
