package com.iuuui.generator.core;

/**
 * @author iuuui
 * @since 2023/02/17 0900
 */
public class GeneratorInfo {

    // 生成项目 mapper.xml 路径
    private String xmlPath;

    // 生成项目 dao 路径
    private String daoPath;

    private String daoPackage;

    // 生成项目 model 路径
    private String modelPath;

    private String modelPackage;

    // 生成项目 service 路径
    private String servicePath;

    private String servicePackage;

    // 生成项目 serviceImpl 路径
    private String serviceImplPath;

    private String serviceImplPackage;

    // 启用层
    private boolean xmlEnable;

    private boolean daoEnable;

    private boolean modelEnable;

    private boolean serviceEnable;

    private boolean serviceImplEnable;

    // 要生成的表
    private String table;

    // 编写人员
    private String author;

    // 数据
    private String dataUrl;

    private String userName;

    private String password;

    //
    private String tablePre;

    public String getXmlPath() {
        return xmlPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public String getDaoPath() {
        return daoPath;
    }

    public void setDaoPath(String daoPath) {
        this.daoPath = daoPath;
    }

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTablePre() {
        return tablePre;
    }

    public void setTablePre(String tablePre) {
        this.tablePre = tablePre;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public boolean isXmlEnable() {
        return xmlEnable;
    }

    public void setXmlEnable(boolean xmlEnable) {
        this.xmlEnable = xmlEnable;
    }

    public boolean isDaoEnable() {
        return daoEnable;
    }

    public void setDaoEnable(boolean daoEnable) {
        this.daoEnable = daoEnable;
    }

    public boolean isModelEnable() {
        return modelEnable;
    }

    public void setModelEnable(boolean modelEnable) {
        this.modelEnable = modelEnable;
    }

    public boolean isServiceEnable() {
        return serviceEnable;
    }

    public void setServiceEnable(boolean serviceEnable) {
        this.serviceEnable = serviceEnable;
    }

    public String getServicePath() {
        return servicePath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getServiceImplPath() {
        return serviceImplPath;
    }

    public void setServiceImplPath(String serviceImplPath) {
        this.serviceImplPath = serviceImplPath;
    }

    public String getServiceImplPackage() {
        return serviceImplPackage;
    }

    public void setServiceImplPackage(String serviceImplPackage) {
        this.serviceImplPackage = serviceImplPackage;
    }

    public boolean isServiceImplEnable() {
        return serviceImplEnable;
    }

    public void setServiceImplEnable(boolean serviceImplEnable) {
        this.serviceImplEnable = serviceImplEnable;
    }


}
