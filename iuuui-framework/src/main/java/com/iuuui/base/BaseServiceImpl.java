package com.iuuui.base;


import com.iuuui.util.ObjectUtil;

import java.util.List;

/**
 * @author iuuui
 * @since 2023/02/16 1643
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    public abstract BaseDao<T> getBaseDao();

    public int createM(T model) {
        int n = this.getBaseDao().createM(model);
        return n;
    }

    public int deleteM(Object id) {
        int n = this.getBaseDao().deleteM(id);
        return n;
    }

    public int updateM(T model) {
        int n = this.getBaseDao().updateM(model);
        return n;
    }

    public T getByIdM(Object id) {
        T model = this.getBaseDao().getByIdM(id);
        return model;
    }

    public Long countM(T model) {
        Long n = this.getBaseDao().countM(model);
        return n;
    }

    public List<T> selectM(T model) {
        List<T> list = this.getBaseDao().selectM(model);
        return list;
    }

    public T selectOne(T model) {
        List<T> list = this.getBaseDao().selectByPageM(model, 0, 1);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<T> selectByPageM(T model, int start, int count) {
        List<T> list = this.getBaseDao().selectByPageM(model, start, count);
        return list;
    }

    public int createOrUpdate(T model) {
        Object id = ObjectUtil.getId(model);
        if (id == null || id.equals(""))
            return this.createM(model);
        return this.updateM(model);
    }

    public int deleteAllM(List<T> list) {
        int n = 0;
        for (T model : list) {
            n += this.deleteM(ObjectUtil.getId(model));
        }
        return n;
    }

    public int deleteM(List<Object> ids) {
        int n = 0;
        for (Object id : ids) {
            n += this.deleteM(id);
        }
        return n;
    }
}
