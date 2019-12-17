package com.exchange.webapp.applicationmanagement.bean;

public class AppProjectManagement {


    private String prj_cd;
    private int person_id;
    private String person_nm;
    private String prj_nm;
    private String prj_desc;
    private String create_time;
    private String update_time;


    public String getPerson_nm() {
        return person_nm;
    }

    public void setPerson_nm(String person_nm) {
        this.person_nm = person_nm;
    }

    public String getPrj_cd() {
        return prj_cd;
    }

    public void setPrj_cd(String prj_cd) {
        this.prj_cd = prj_cd;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPrj_nm() {
        return prj_nm;
    }

    public void setPrj_nm(String prj_nm) {
        this.prj_nm = prj_nm;
    }

    public String getPrj_desc() {
        return prj_desc;
    }

    public void setPrj_desc(String prj_desc) {
        this.prj_desc = prj_desc;
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

    @Override
    public String toString() {
        return "AppProjectManagement{" +
                "prj_cd='" + prj_cd + '\'' +
                ", person_id=" + person_id +
                ", prj_nm='" + prj_nm + '\'' +
                ", prj_desc='" + prj_desc + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
