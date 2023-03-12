package com.iuuui.domain.system;

import com.iuuui.base.BaseModel;

/**
 * 
 * @author iuuui
 * @since 2023-03-11 15:25
 */
public class SysRoleMenu extends BaseModel {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 关联角色ID
	 */
	private Long roleId;

	/**
	 * 关联菜单ID
	 */
	private Long menuId;



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

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

}
