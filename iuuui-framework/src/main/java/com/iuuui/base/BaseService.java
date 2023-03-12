package com.iuuui.base;


import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author iuuui
 * @since 2023/02/16 1643
 */
public interface BaseService<T> {

    int createM(T model);

    int deleteM(Object id);

    int updateM(T model);

    T getByIdM(Object id);

    T findByIdM(Object id);

    Long countM(T model);

    List<T> selectM(T model);

    T selectOne(T model);

    List<T> selectByPageM(@Param("model") T model, @Param("start") int start, @Param("count") int count);

    int createOrUpdate(T model);

    int deleteAllM(List<T> list);

    int deleteM(List<Object> ids);

}
