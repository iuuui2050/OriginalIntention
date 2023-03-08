package com.iuuui.generator;


import com.iuuui.generator.core.GeneratorConfig;
import com.iuuui.generator.core.GeneratorInfo;

/**
 * @author iuuui
 * @since 2023/02/17 1020
 */
public class GeneratorUtil {

    public static void main(String[] args) {
        GeneratorInfo info = new GeneratorInfo();
        info.setTablePre("");
        info.setDataUrl("jdbc:mysql://localhost:3306/iuuui_db?useunicode=true&characterEncoding=utf-8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull");
        info.setUserName("root");
        info.setPassword("root");

        String path = "D:\\code\\OriginalIntention";

        String model = "system";

        // 包之前的路径
        info.setXmlPath(path + "\\iuuui-system\\src\\main\\resources\\mapper\\" + model);
        info.setDaoPath(path + "\\iuuui-system\\src\\main\\java");
        info.setModelPath(path + "\\iuuui-system\\src\\main\\java");
        info.setServicePath(path + "\\iuuui-system\\src\\main\\java");
        info.setServiceImplPath(path + "\\iuuui-system\\src\\main\\java");

        // 是否启用生成
        info.setXmlEnable(true);
        info.setDaoEnable(true);
        info.setModelEnable(true);
        info.setServiceEnable(true);
        info.setServiceImplEnable(true);

        String packagePath = "com.iuuui";

        // 所属包
        info.setDaoPackage(packagePath + ".dao." + model);
        info.setModelPackage(packagePath + ".domain." + model);
        info.setServicePackage(packagePath + ".service." + model);
        info.setServiceImplPackage(packagePath + ".service." + model + ".impl");

        info.setAuthor("iuuui");
        info.setTable("sys_user,sys_role,sys_dept,sys_user_password,sys_user_role,sys_user_dept");


        GeneratorConfig.execute(info);
    }

}
