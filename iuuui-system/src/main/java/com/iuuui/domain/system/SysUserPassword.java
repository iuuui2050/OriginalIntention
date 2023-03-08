package com.iuuui.domain.system;

import com.iuuui.base.BaseModel;

/**
 * 用户密码表
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public class SysUserPassword extends BaseModel {

	/**
	 * 
	 */
	private Long id;

	/**
	 * 关联的用户
	 */
	private Long userId;

	/**
	 * 加密后的密码
	 */
	private String password;

	/**
	 * 加密盐值
	 */
	private String salt;



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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
