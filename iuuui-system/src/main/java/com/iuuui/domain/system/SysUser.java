package com.iuuui.domain.system;

import com.iuuui.annotation.auto.AutoTime;
import com.iuuui.annotation.auto.AutoUserId;
import com.iuuui.base.BaseModel;
import java.util.Date;

/**
 * 用户表
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public class SysUser extends BaseModel {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 手机号区号
	 */
	private String telCode;

	/**
	 * 手机号
	 */
	private String tel;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 简介
	 */
	private String introduction;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 关联部门
	 */
	private Long deptId;

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
	 * 修改人
	 */
	@AutoUserId(force = true)
	private Long updateUserId;

	/**
	 * 修改时间
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTelCode() {
		return telCode;
	}

	public void setTelCode(String telCode) {
		this.telCode = telCode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
}
