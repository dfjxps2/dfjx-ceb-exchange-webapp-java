package com.exchange.webapp.dataconsumption.bean;

public class DataConsumption {


    private int   cons_id;
    private String  cons_nm;
    private String dat_nm;
    private String xfnm;
    private String scnm;
    private String person_nm;
    private String download_cron;
    private String  storage_path;
    private String  cons_desc;
    private String  create_time;
    private String  update_time;
    private int      flag;
    private String prj_cd;
    private String dat_cd;


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

    public int getCons_id() {
        return cons_id;
    }

    public void setCons_id(int cons_id) {
        this.cons_id = cons_id;
    }

    public String getCons_nm() {
        return cons_nm;
    }

    public void setCons_nm(String cons_nm) {
        this.cons_nm = cons_nm;
    }

    public String getDat_nm() {
        return dat_nm;
    }

    public void setDat_nm(String dat_nm) {
        this.dat_nm = dat_nm;
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

    public String getPerson_nm() {
        return person_nm;
    }

    public void setPerson_nm(String person_nm) {
        this.person_nm = person_nm;
    }

    public String getDownload_cron() {
        return download_cron;
    }

    public void setDownload_cron(String download_cron) {
        this.download_cron = download_cron;
    }

    public String getStorage_path() {
        return storage_path;
    }

    public void setStorage_path(String storage_path) {
        this.storage_path = storage_path;
    }

    public String getCons_desc() {
        return cons_desc;
    }

    public void setCons_desc(String cons_desc) {
        this.cons_desc = cons_desc;
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
}
