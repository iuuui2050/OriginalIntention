package com.iuuui.base;


import com.iuuui.constants.ExceptionEnum;
import com.iuuui.exception.BusinessException;
import com.iuuui.util.ObjectUtil;
import com.iuuui.util.ReflectUtil;
import com.iuuui.util.annotation.AutoUtil;

import java.util.List;

/**
 * @author iuuui
 * @since 2023/02/16 1643
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    public abstract BaseDao<T> getBaseDao();

    @Override
    public int createM(T model) {
        AutoUtil.set(model);
        int n = this.getBaseDao().createM(model);
        return n;
    }

    @Override
    public int deleteM(Object id) {
        int n = this.getBaseDao().deleteM(id);
        return n;
    }

    @Override
    public int updateM(T model) {
        AutoUtil.set(model);
        int n = this.getBaseDao().updateM(model);
        return n;
    }

    @Override
    public T getByIdM(Object id) {
        T model = this.getBaseDao().getByIdM(id);
        return model;
    }

    @Override
    public T findByIdM(Object id) {
        T model = this.getByIdM(id);
        if (model == null) throw new BusinessException(ExceptionEnum.NO_DATA);
        return model;
    }

    @Override
    public Long countM(T model) {
        Long n = this.getBaseDao().countM(model);
        return n;
    }

    @Override
    public List<T> selectM(T model) {
        List<T> list = this.getBaseDao().selectM(model);
        return list;
    }

    @Override
    public T selectOne(T model) {
        List<T> list = this.getBaseDao().selectByPageM(model, 0, 1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<T> selectByPageM(T model, int start, int count) {
        List<T> list = this.getBaseDao().selectByPageM(model, start, count);
        return list;
    }

    @Override
    public int createOrUpdate(T model) {
        Object id = ReflectUtil.getId(model);
        if (id == null || id.equals(""))
            return this.createM(model);
        return this.updateM(model);
    }

    @Override
    public int deleteAllM(List<T> list) {
        int n = 0;
        for (T model : list) {
            n += this.deleteM(ReflectUtil.getId(model));
        }
        return n;
    }

    @Override
    public int deleteM(List<Object> ids) {
        int n = 0;
        for (Object id : ids) {
            n += this.deleteM(id);
        }
        return n;
    }
}
