package com.exchange.webapp.datasetmanagement.bean;

public class DatasetManagement {

    private String dat_cd;    //数据集标识
    private String prj_cd;    //项目标识
    private String dat_nm;    //数据集名称
    private String file_regexp;   //文件名命名规则
    private String dat_desc;   //数据集说明
    private String create_time;   //创建时间
    private String update_time;   //最后更新时间
    private int  flag;        //是否启用
    private String  person_nm;
    private  String prj_nm;//项目名称


    public String getPerson_nm() {
        return person_nm;
    }

    public void setPerson_nm(String person_nm) {
        this.person_nm = person_nm;
    }

    public String getPrj_nm() {
        return prj_nm;
    }

    public void setPrj_nm(String prj_nm) {
        this.prj_nm = prj_nm;
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

    public String getDat_nm() {
        return dat_nm;
    }

    public void setDat_nm(String dat_nm) {
        this.dat_nm = dat_nm;
    }

    public String getFile_regexp() {
        return file_regexp;
    }

    public void setFile_regexp(String file_regexp) {
        this.file_regexp = file_regexp;
    }

    public String getDat_desc() {
        return dat_desc;
    }

    public void setDat_desc(String dat_desc) {
        this.dat_desc = dat_desc;
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
