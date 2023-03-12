package com.iuuui.domain.system;

import com.iuuui.annotation.auto.AutoTime;
import com.iuuui.annotation.auto.AutoUserId;
import com.iuuui.base.BaseModel;
import java.util.Date;

/**
 * 角色表
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public class SysRole extends BaseModel {

	/**
	 * 角色ID
	 */
	private Long id;

	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 角色权限字符串
	 */
	private String code;

	/**
	 * 数据范围（SysRoleDataScopeEnum）
	 */
	private Integer dataScope;

	/**
	 * 角色状态
	 */
	private Boolean status;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 创建者
	 */
	@AutoUserId
	private Long createUserId;

	/**
	 * 创建时间
	 */
	@AutoTime
	private Date createTime;

	/**
	 * 更新人
	 */
	@AutoUserId(force = true)
	private Long updateUserId;

	/**
	 * 更新时间
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getDataScope() {
		return dataScope;
	}

	public void setDataScope(Integer dataScope) {
		this.dataScope = dataScope;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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
