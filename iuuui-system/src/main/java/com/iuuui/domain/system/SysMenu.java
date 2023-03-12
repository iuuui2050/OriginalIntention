package com.iuuui.domain.system;

import com.iuuui.annotation.auto.AutoTime;
import com.iuuui.annotation.auto.AutoUserId;
import com.iuuui.base.BaseModel;

import java.util.Date;

/**
 * 
 * @author iuuui
 * @since 2023-03-11 15:50
 */
public class SysMenu extends BaseModel {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 关联父级
	 */
	private Long parentId;

	/**
	 * 是否外链
	 */
	private Boolean isExternalLink;

	/**
	 * 路由地址
	 */
	private String routerPath;

	/**
	 * 路由参数
	 */
	private String routerParam;

	/**
	 * 组件路径
	 */
	private String componentPath;

	/**
	 * 菜单类型(1.目录、2.菜单、3.按钮)
	 */
	private Integer type;

	/**
	 * 状态(true.正常、false.停用)
	 */
	private Boolean status;

	/**
	 * 权限标识
	 */
	private String permissionCode;

	/**
	 * 菜单图标
	 */
	private String icon;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 创建人
	 */
	@AutoUserId
	private Long createUserId;

	/**
	 * 创建时间
	 */
	@AutoTime
	private Date createTime;

	/**
	 * 最后更新人
	 */
	@AutoUserId(force = true)
	private Long updateUserId;

	/**
	 * 最后更新时间
	 */
	@AutoTime(force = true)
	private Date updateTime;



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

}
