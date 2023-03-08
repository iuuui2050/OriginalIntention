package com.iuuui.generator.core;

import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseModel;
import com.iuuui.base.BaseService;
import com.iuuui.base.BaseServiceImpl;


/**
 * @author iuuui
 * @since 2023/02/17 0900
 */
public class GeneratorConfig {

    private static final String driver = "com.mysql.jdbc.Driver";


    public static void execute(GeneratorInfo info){
        StructureUtil mpg = new StructureUtil();

        GlobalConfig gc = new GlobalConfig();
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setOpen(false);
        gc.setAuthor(info.getAuthor());
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // dataSource
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName(driver);
        dsc.setUsername(info.getUserName());
        dsc.setPassword(info.getPassword());
        dsc.setUrl(info.getDataUrl());
        mpg.setDataSource(dsc);

        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[]{info.getTablePre()});
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(info.getTable().split(","));
        mpg.setStrategy(strategy);
        mpg.setGeneratorInfo(info);

        mpg.execute();
    }

}
