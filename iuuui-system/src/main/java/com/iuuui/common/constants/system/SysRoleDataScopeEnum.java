package com.iuuui.common.constants.system;

/**
 * @author iuuui
 * @time 20230312 1751
 */
public enum SysRoleDataScopeEnum {

    ALL(1, "全部数据权限"),
    CUSTOM(2, "自定义数据权限"),
    DEPT(3, "本部门数据权限"),
    DEPT_AND_DOWN(4, "本部门及部门以下所有部门数据"),
    SELF(5, "只能看自己");

    private Integer code;
    private String des;

    SysRoleDataScopeEnum(Integer code, String des) {
        this.code = code;
        this.des = des;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
