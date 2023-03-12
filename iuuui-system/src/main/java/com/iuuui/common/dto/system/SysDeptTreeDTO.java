package com.iuuui.common.dto.system;


import java.util.Date;
import java.util.List;

/**
 * @author iuuui
 * @time 20230311 0112
 */
public class SysDeptTreeDTO {

    private Long id;

    private Long parentId;

    private String name;

    private String code;

    // 负责人
    private Long leaderUserId;
    private String leaderUserName;
    private String leaderTelCode;
    private String leaderTel;
    private String leaderAvatar;

    private Boolean status;

    private Long createUserId;

    private Date createTime;

    private Long updateUserId;

    private Date updateTime;

    private List<SysDeptTreeDTO> childList;


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

    public String getLeaderUserName() {
        return leaderUserName;
    }

    public void setLeaderUserName(String leaderUserName) {
        this.leaderUserName = leaderUserName;
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

    public List<SysDeptTreeDTO> getChildList() {
        return childList;
    }

    public void setChildList(List<SysDeptTreeDTO> childList) {
        this.childList = childList;
    }

    public String getLeaderTelCode() {
        return leaderTelCode;
    }

    public void setLeaderTelCode(String leaderTelCode) {
        this.leaderTelCode = leaderTelCode;
    }

    public String getLeaderTel() {
        return leaderTel;
    }

    public void setLeaderTel(String leaderTel) {
        this.leaderTel = leaderTel;
    }

    public String getLeaderAvatar() {
        return leaderAvatar;
    }

    public void setLeaderAvatar(String leaderAvatar) {
        this.leaderAvatar = leaderAvatar;
    }
}
