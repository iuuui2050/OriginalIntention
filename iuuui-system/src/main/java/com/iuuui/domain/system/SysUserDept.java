package com.iuuui.domain.system;

import com.iuuui.base.BaseModel;
import java.util.Date;

/**
 * 用户部门关联表
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public class SysUserDept extends BaseModel {

	/**
	 * 
	 */
	private Long id;

	/**
	 * 关联用户
	 */
	private Long userId;

	/**
	 * 关联部门
	 */
	private Long deptId;

	/**
	 * 创建人
	 */
	private Long createUserId;

	/**
	 * 创建时间
	 */
	private Date createTime;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
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

}
