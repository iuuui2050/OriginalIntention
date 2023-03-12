package com.iuuui;

import com.iuuui.common.param.system.SysRoleSearchParam;
import com.iuuui.domain.system.SysDept;
import com.iuuui.util.ReflectUtil;
import com.iuuui.util.annotation.AutoUtil;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author iuuui
 * @time 20230310 0053
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(ReflectUtil.toMap(new SysRoleSearchParam(), true));
    }
}
