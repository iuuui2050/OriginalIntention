package com.iuuui.common.param.system;

/**
 * @author iuuui
 * @time 20230311 1552
 */
public class SysMenuFormParam {

    private Long id;

    private String name;

    private Long parentId;

    private Boolean isExternalLink;

    private String routerPath;

    private String routerParam;

    private String componentPath;

    private Integer type;

    private String permissionCode;

    private String icon;

    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getIsExternalLink() {
        return isExternalLink;
    }

    public void setIsExternalLink(Boolean isExternalLink) {
        this.isExternalLink = isExternalLink;
    }

    public String getRouterPath() {
        return routerPath;
    }

    public void setRouterPath(String routerPath) {
        this.routerPath = routerPath;
    }

    public String getRouterParam() {
        return routerParam;
    }

    public void setRouterParam(String routerParam) {
        this.routerParam = routerParam;
    }

    public String getComponentPath() {
        return componentPath;
    }

    public void setComponentPath(String componentPath) {
        this.componentPath = componentPath;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
