package com.iuuui.generator.core;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class StructureUtil {

    private static final Log logger = LogFactory.getLog(StructureUtil.class);

    protected ConfigBuilder config;

    protected InjectionConfig injectionConfig;
    /**
     * 动态配置
     */
    private GeneratorInfo  generatorInfo;
    /**
     * 数据源配置
     */
    private DataSourceConfig dataSource;
    /**
     * 数据库表配置
     */
    private StrategyConfig strategy;
    /**
     * 包 相关配置
     */
    private PackageConfig packageInfo;
    /**
     * 模板 相关配置
     */
    private TemplateConfig template;
    /**
     * 全局 相关配置
     */
    private GlobalConfig globalConfig;
    /**
     * velocity引擎
     */
    private VelocityEngine engine;

    /**
     * 生成代码
     */
    public void execute() {
        initConfig();
        Map<String, VelocityContext> ctxData = analyzeData(config);
        for (Map.Entry<String, VelocityContext> ctx : ctxData.entrySet()) {
            batchOutput(ctx.getKey(), ctx.getValue());
        }
        System.out.println("=====>> 代码生成完成！");
    }

    /**
     * 开放表信息、预留子类重写
     *
     * @param config 配置信息
     * @return
     */
    protected List<TableInfo> getAllTableInfoList(ConfigBuilder config) {
        return config.getTableInfoList();
    }

    /**
     * 分析数据
     *
     * @param config 总配置信息
     * @return 解析数据结果集
     */
    private Map<String, VelocityContext> analyzeData(ConfigBuilder config) {
        List<TableInfo> tableList = this.getAllTableInfoList(config);
        Map<String, String> packageInfo = config.getPackageInfo();
        Map<String, VelocityContext> ctxData = new HashMap<>();
        String superEntityClass = getSuperClassName(config.getSuperEntityClass());
        String superMapperClass = getSuperClassName(config.getSuperMapperClass());
        String superServiceClass = getSuperClassName(config.getSuperServiceClass());
        String superServiceImplClass = getSuperClassName(config.getSuperServiceImplClass());
        String superControllerClass = getSuperClassName(config.getSuperControllerClass());
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        VelocityContext ctx;
        for (TableInfo tableInfo : tableList) {
            ctx = new VelocityContext();
            if (null != injectionConfig) {
                /**
                 * 注入自定义配置
                 */
                injectionConfig.initMap();
                ctx.put("cfg", injectionConfig.getMap());
            }
            // Boolean类型is前缀处理
            if (config.getStrategyConfig().isEntityBooleanColumnRemoveIsPrefix()) {
                for (TableField field : tableInfo.getFields()) {
                    if (field.getPropertyType().equalsIgnoreCase("boolean")) {
                        if (field.getPropertyName().startsWith("is")) {
                            field.setPropertyName(config.getStrategyConfig(),
                                    StringUtils.removePrefixAfterPrefixToLower(field.getPropertyName(), 2));
                        }
                    }
                }
            }
            // RequestMapping 连字符风格 user-info
            if (config.getStrategyConfig().isControllerMappingHyphenStyle()) {
                ctx.put("controllerMappingHyphenStyle", config.getStrategyConfig().isControllerMappingHyphenStyle());
                ctx.put("controllerMappingHyphen", StringUtils.camelToHyphen(tableInfo.getEntityPath()));
            }

            ctx.put("restControllerStyle", config.getStrategyConfig().isRestControllerStyle());
            ctx.put("package", packageInfo);
            ctx.put("author", config.getGlobalConfig().getAuthor());
            ctx.put("logicDeleteFieldName", config.getStrategyConfig().getLogicDeleteFieldName());
            ctx.put("versionFieldName", config.getStrategyConfig().getVersionFieldName());
            ctx.put("activeRecord", config.getGlobalConfig().isActiveRecord());
            ctx.put("date", date);
            ctx.put("table", tableInfo);
            ctx.put("enableCache", config.getGlobalConfig().isEnableCache());
            ctx.put("baseResultMap", config.getGlobalConfig().isBaseResultMap());
            ctx.put("baseColumnList", config.getGlobalConfig().isBaseColumnList());
            ctx.put("entity", tableInfo.getEntityName());
            ctx.put("entityColumnConstant", config.getStrategyConfig().isEntityColumnConstant());
            ctx.put("entityBuilderModel", config.getStrategyConfig().isEntityBuilderModel());
            ctx.put("entityLombokModel", config.getStrategyConfig().isEntityLombokModel());
            ctx.put("entityBooleanColumnRemoveIsPrefix", config.getStrategyConfig().isEntityBooleanColumnRemoveIsPrefix());
            ctx.put("superEntityClass", superEntityClass);
            ctx.put("superMapperClassPackage", config.getSuperMapperClass());
            ctx.put("superMapperClass", superMapperClass);
            ctx.put("superServiceClassPackage", config.getSuperServiceClass());
            ctx.put("superServiceClass", superServiceClass);
            ctx.put("superServiceImplClassPackage", config.getSuperServiceImplClass());
            ctx.put("superServiceImplClass", superServiceImplClass);
            ctx.put("superControllerClassPackage", config.getSuperControllerClass());
            ctx.put("superControllerClass", superControllerClass);

            ctx.put("daoClass", generatorInfo.getDaoPackage() +"."+ tableInfo.getEntityName() +"Dao");
            ctx.put("daoPackage", generatorInfo.getDaoPackage());

            ctx.put("modelClass", generatorInfo.getModelPackage() +"." + tableInfo.getEntityName());
            ctx.put("modelPackage", generatorInfo.getModelPackage());

            ctx.put("serviceClass", generatorInfo.getServicePackage() + "." + tableInfo.getEntityName() + "Service");
            ctx.put("servicePackage", generatorInfo.getServicePackage());

            ctx.put("serviceImplClass", generatorInfo.getServiceImplPackage() + "." + tableInfo.getEntityName() + "ServiceImpl");
            ctx.put("serviceImplPackage", generatorInfo.getServiceImplPackage());
            ctxData.put(tableInfo.getEntityName(), ctx);
        }
        return ctxData;
    }

    /**
     * 获取类名
     *
     * @param classPath
     * @return
     */
    private String getSuperClassName(String classPath) {
        if (StringUtils.isEmpty(classPath))
            return null;
        return classPath.substring(classPath.lastIndexOf(".") + 1);
    }


    /**
     * 合成上下文与模板
     *
     * @param context vm上下文
     */
    private void batchOutput(String entityName, VelocityContext context) {
        try {
            TableInfo tableInfo = (TableInfo) context.get("table");
            TemplateConfig template = config.getTemplate();

            boolean model = generatorInfo.isModelEnable();
            boolean dao = generatorInfo.isDaoEnable();
            boolean xml = generatorInfo.isXmlEnable();
            boolean service = generatorInfo.isServiceEnable();
            boolean serviceImpl = generatorInfo.isServiceImplEnable();

            String entityPackage = generatorInfo.getModelPackage().replace(".", "\\");
            String daoPackage = generatorInfo.getDaoPackage().replace(".", "\\");
            String servicePackage = generatorInfo.getServicePackage().replace(".", "\\");
            String serviceImplPackage = generatorInfo.getServiceImplPackage().replace(".", "\\");

            String modelFile = checkFile(checkFile(getGeneratorInfo().getModelPath(), entityPackage), tableInfo.getEntityName() + ConstVal.JAVA_SUFFIX);
            String daoFile = checkFile(checkFile(getGeneratorInfo().getDaoPath(), daoPackage), tableInfo.getMapperName() + ConstVal.JAVA_SUFFIX);
            String xmlFile = checkFile(getGeneratorInfo().getXmlPath(),  tableInfo.getXmlName() + ConstVal.XML_SUFFIX);
            String serviceFile = checkFile(checkFile(getGeneratorInfo().getServicePath(), servicePackage), tableInfo.getServiceName() + ConstVal.JAVA_SUFFIX);
            String serviceImplFile = checkFile(checkFile(getGeneratorInfo().getServiceImplPath(), serviceImplPackage), tableInfo.getServiceImplName() + ConstVal.JAVA_SUFFIX);

            if (model && isCreate(modelFile)) {
                vmToFile(context, template.getEntity(), modelFile);
            }
            if (dao && isCreate(daoFile)) {
                vmToFile(context, template.getMapper(), daoFile);
            }
            if (xml && isCreate(xmlFile)) {
                vmToFile(context, template.getXml(), xmlFile);
            }
            if (service && isCreate(serviceFile)) {
                vmToFile(context, template.getService(), serviceFile);
            }
            if (serviceImpl && isCreate(serviceImplFile)) {
                vmToFile(context, template.getServiceImpl(), serviceImplFile);
            }

            if (injectionConfig != null) {
                List<FileOutConfig> focList = injectionConfig.getFileOutConfigList();
                if (CollectionUtils.isNotEmpty(focList)) {
                    for (FileOutConfig foc : focList) {
                        vmToFile(context, foc.getTemplatePath(), foc.outputFile(tableInfo));
                    }
                }
            }

        } catch (IOException e) {
            logger.error("无法创建文件，请检查配置信息！", e);
        }
    }

    /**
     * 将模板转化成为文件
     *
     * @param context      内容对象
     * @param templatePath 模板文件
     * @param outputFile   文件生成的目录
     */
    private void vmToFile(VelocityContext context, String templatePath, String outputFile) throws IOException {
        if (StringUtils.isEmpty(templatePath)) {
            return;
        }
        VelocityEngine velocity = getVelocityEngine();
        Template template = velocity.getTemplate(templatePath, ConstVal.UTF8);
        File file = new File(outputFile);
        if (!file.getParentFile().exists()) {
            // 如果文件所在的目录不存在，则创建目录
            if (!file.getParentFile().mkdirs()) {
                logger.debug("创建文件所在的目录失败!");
                return;
            }
        }
        FileOutputStream fos = new FileOutputStream(outputFile);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, ConstVal.UTF8));
        template.merge(context, writer);
        writer.close();
    }

    /**
     * 设置模版引擎，主要指向获取模版路径
     */
    private VelocityEngine getVelocityEngine() {
        if (engine == null) {
            Properties p = new Properties();
            p.setProperty(ConstVal.VM_LOADPATH_KEY, ConstVal.VM_LOADPATH_VALUE);
            p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "");
            p.setProperty(Velocity.ENCODING_DEFAULT, ConstVal.UTF8);
            p.setProperty(Velocity.INPUT_ENCODING, ConstVal.UTF8);
            p.setProperty(Velocity.OUTPUT_ENCODING, ConstVal.UTF8);
            p.setProperty("file.resource.loader.unicode", "true");
            engine = new VelocityEngine(p);
        }
        return engine;
    }

    /**
     * 检测文件是否存在
     *
     * @return 是否
     */
    private boolean isCreate(String filePath) {
        File file = new File(filePath);
        return !file.exists() || config.getGlobalConfig().isFileOverride();
    }

    private String checkFile(String previous, String split){
        if (previous.endsWith("\\") || previous.endsWith("/")){
            return previous + split;
        }
        return previous + File.separator + split;

    }

    // ==================================  相关配置  ==================================

    /**
     * 初始化配置
     */
    protected void initConfig() {
        if (null == config) {
            config = new ConfigBuilder(packageInfo, dataSource, strategy, template, globalConfig);
            if (null != injectionConfig) {
                injectionConfig.setConfig(config);
            }
            config.getTemplate().setEntity("/templates/model.java.vm");
            config.getTemplate().setMapper("/templates/dao.java.vm");
        }
    }

    public DataSourceConfig getDataSource() {
        return dataSource;
    }

    public StructureUtil setDataSource(DataSourceConfig dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    public StrategyConfig getStrategy() {
        return strategy;
    }

    public StructureUtil setStrategy(StrategyConfig strategy) {
        this.strategy = strategy;
        return this;
    }

    public PackageConfig getPackageInfo() {
        return packageInfo;
    }

    public StructureUtil setPackageInfo(PackageConfig packageInfo) {
        this.packageInfo = packageInfo;
        return this;
    }

    public TemplateConfig getTemplate() {
        return template;
    }

    public StructureUtil setTemplate(TemplateConfig template) {
        this.template = template;
        return this;
    }

    public ConfigBuilder getConfig() {
        return config;
    }

    public StructureUtil setConfig(ConfigBuilder config) {
        this.config = config;
        return this;
    }

    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }

    public StructureUtil setGlobalConfig(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
        return this;
    }

    public InjectionConfig getCfg() {
        return injectionConfig;
    }

    public StructureUtil setCfg(InjectionConfig injectionConfig) {
        this.injectionConfig = injectionConfig;
        return this;
    }

    public GeneratorInfo getGeneratorInfo() {
        return generatorInfo;
    }

    public void setGeneratorInfo(GeneratorInfo generatorInfo) {
        this.generatorInfo = generatorInfo;
    }
}