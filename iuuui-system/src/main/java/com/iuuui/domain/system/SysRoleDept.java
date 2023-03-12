package com.iuuui.domain.system;

import com.iuuui.base.BaseModel;

/**
 * 角色关联部门表(数据权限)
 * @author iuuui
 * @since 2023-03-12 14:27
 */
public class SysRoleDept extends BaseModel {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 关联角色
	 */
	private Long roleId;

	/**
	 * 关联部门
	 */
	private Long deptId;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

}
