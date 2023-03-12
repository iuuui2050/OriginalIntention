package com.iuuui.common.constants.system;

/**
 * @author iuuui
 * @time 20230311 1618
 */
public enum SysMenuTypeEnum {

    DIRECTORY(1, "目录"),
    MENU(2, "菜单"),
    BUTTON(3, "按钮");

    private Integer type;
    private String des;

    SysMenuTypeEnum(Integer type, String des) {
        this.type = type;
        this.des = des;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
