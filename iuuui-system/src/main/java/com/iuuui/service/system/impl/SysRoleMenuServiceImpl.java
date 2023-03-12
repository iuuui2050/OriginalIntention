package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.domain.system.SysRoleMenu;
import com.iuuui.service.system.SysRoleMenuService;
import com.iuuui.dao.system.SysRoleMenuDao;
import com.iuuui.util.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author iuuui
 * @since 2023-03-11 15:25
 */
@Service
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenu> implements SysRoleMenuService {

    final SysRoleMenuDao dao;

    public SysRoleMenuServiceImpl(SysRoleMenuDao dao) {
        this.dao = dao;
    }

    @Override
    public BaseDao<SysRoleMenu> getBaseDao() {
        return dao;
    }

    @Override
    public void save(Long roleId, List<Long> menuIds) {
        Assert.notNull(roleId, "roleId argument must not be null");
        List<SysRoleMenu> roleMenus = this.findByRoleId(roleId);
        // del
        for (SysRoleMenu roleMenu : roleMenus) {
            if (!menuIds.contains(roleMenu.getMenuId()))
                super.deleteM(roleMenu.getId());
        }
        // add
        for (Long menuId : menuIds) {
            boolean add = true;
            for (SysRoleMenu roleMenu : roleMenus) {
                if (roleMenu.getMenuId().equals(menuId)) {
                    add = false;
                }
            }
            if (add) {
                this.create(roleId, menuId);
            }
        }
    }

    private void create(Long roleId, Long menuId) {
        SysRoleMenu query = new SysRoleMenu();
        query.setRoleId(roleId);
        query.setMenuId(menuId);
        super.createM(query);
    }

    @Override
    public List<Long> findMenuIds(Long roleId) {
        List<SysRoleMenu> roleMenus = this.findByRoleId(roleId);
        if (CollectionUtils.isEmpty(roleMenus))
            return CollectionUtils.newList();
        return roleMenus.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
    }

    @Override
    public List<Long> findRoleIds(Long menuId) {
        Assert.notNull(menuId, "menuId argument must not be null");
        List<SysRoleMenu> roleMenus = this.findByMenuId(menuId);
        if (CollectionUtils.isEmpty(roleMenus))
            return CollectionUtils.newList();
        return roleMenus.stream().map(SysRoleMenu::getRoleId).collect(Collectors.toList());
    }

    @Override
    public List<SysRoleMenu> findByRoleId(Long roleId) {
        Assert.notNull(roleId, "roleId argument must not be null");
        SysRoleMenu query = new SysRoleMenu();
        query.setRoleId(roleId);
        return super.selectM(query);
    }

    @Override
    public List<SysRoleMenu> findByMenuId(Long menuId) {
        Assert.notNull(menuId, "menuId argument must not be null");
        SysRoleMenu query = new SysRoleMenu();
        query.setMenuId(menuId);
        return super.selectM(query);
    }
}