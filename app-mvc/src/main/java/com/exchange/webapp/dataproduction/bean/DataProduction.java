package com.exchange.webapp.dataproduction.bean;

public class DataProduction {

    private int          prod_id;  //'数据生产ID',
    private String       dat_cd;   // '数据集标识',
    private String       prj_cd;//'项目标识',
    private String       prod_nm; // '数据生产名称',
    private String       create_cron; // '数据文件生成时间',
    private String       upload_cron; // '上传任务时间',
    private String       storage_path; // '存储路径',
    private String       create_time; //'创建时间',
    private String       update_time; // '最后修改时间',
    private int          flag;  // 是否启用

    private  String xfnm ; //消费项目
    private  String scnm ; //生产项目
    private String cons_nm;

    public String getCons_nm() {
        return cons_nm;
    }

    public void setCons_nm(String cons_nm) {
        this.cons_nm = cons_nm;
    }

    private String person_nm;
    private String dat_nm;

    public String getDat_nm() {
        return dat_nm;
    }

    public void setDat_nm(String dat_nm) {
        this.dat_nm = dat_nm;
    }

    public String getPerson_nm() {
        return person_nm;
    }

    public void setPerson_nm(String person_nm) {
        this.person_nm = person_nm;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getDat_cd() {
        return dat_cd;
    }

    public void setDat_cd(String dat_cd) {
        this.dat_cd = dat_cd;
    }

    public String getPrj_cd() {
        return prj_cd;
    }

    public void setPrj_cd(String prj_cd) {
        this.prj_cd = prj_cd;
    }

    public String getProd_nm() {
        return prod_nm;
    }

    public void setProd_nm(String prod_nm) {
        this.prod_nm = prod_nm;
    }

    public String getCreate_cron() {
        return create_cron;
    }

    public void setCreate_cron(String create_cron) {
        this.create_cron = create_cron;
    }

    public String getUpload_cron() {
        return upload_cron;
    }

    public void setUpload_cron(String upload_cron) {
        this.upload_cron = upload_cron;
    }

    public String getStorage_path() {
        return storage_path;
    }

    public void setStorage_path(String storage_path) {
        this.storage_path = storage_path;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getXfnm() {
        return xfnm;
    }

    public void setXfnm(String xfnm) {
        this.xfnm = xfnm;
    }

    public String getScnm() {
        return scnm;
    }

    public void setScnm(String scnm) {
        this.scnm = scnm;
    }
}
