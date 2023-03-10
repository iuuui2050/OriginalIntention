package com.iuuui.domain.system;

import com.iuuui.annotation.auto.AutoTime;
import com.iuuui.annotation.auto.AutoUserId;
import com.iuuui.base.BaseModel;
import java.util.Date;

/**
 * 部门表
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public class SysDept extends BaseModel {

	/**
	 * 部门id
	 */
	private Long id;

	/**
	 * 父部门id
	 */
	private Long parentId;

	/**
	 * 部门名称
	 */
	private String name;

	/**
	 * 标识
	 */
	private String code;

	/**
	 * 部门负责人
	 */
	private Long leaderUserId;

	/**
	 * 部门状态
	 */
	private Boolean status;

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
	 * 更新者
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public Long getLeaderUserId() {
		return leaderUserId;
	}

	public void setLeaderUserId(Long leaderUserId) {
		this.leaderUserId = leaderUserId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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
