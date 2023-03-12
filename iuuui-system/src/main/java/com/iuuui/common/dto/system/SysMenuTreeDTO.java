package com.iuuui.common.dto.system;

import java.util.Date;
import java.util.List;

/**
 * @author iuuui
 * @time 20230311 1606
 */
public class SysMenuTreeDTO {

    private Long id;

    private String name;

    private Long parentId;

    private Boolean isExternalLink;

    private String routerPath;

    private String routerParam;

    private String componentPath;

    private Integer type;

    private Boolean status;

    private String permissionCode;

    private String icon;

    private String remark;

    private Integer sort;

    private Long createUserId;

    private Date createTime;

    private Long updateUserId;

    private Date updateTime;

    private List<SysMenuTreeDTO> childList;


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

    public Boolean getExternalLink() {
        return isExternalLink;
    }

    public void setExternalLink(Boolean externalLink) {
        isExternalLink = externalLink;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<SysMenuTreeDTO> getChildList() {
        return childList;
    }

    public void setChildList(List<SysMenuTreeDTO> childList) {
        this.childList = childList;
    }
}
