package com.iuuui.constants;

/**
 * @author iuuui
 * @time 20230227 2131
 */
public enum ExceptionEnum {

    DATA("", "数据异常"),
    NO_DATA("", "数据不存在"),
    ALREADY_DATA("", "数据已存在", "存在相同[%s]"),
    PARAM("", "参数异常"),
    NULL_PARAM("", "参数空异常", "[%s]不能为空");

    private String code;
    private String message;
    private String messageArgs;

    ExceptionEnum(String code, String message, String messageArgs) {
        this.code = code;
        this.message = message;
        this.messageArgs = messageArgs;
    }

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

    public String getMessageArgs() {
        return messageArgs;
    }

    public void setMessageArgs(String messageArgs) {
        this.messageArgs = messageArgs;
    }
}
