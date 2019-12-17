package com.exchange.webapp.contact.bean;

public class ContactUser {
    private String person_id;
    private String person_nm;
    private String person_tel;
    private String person_email;
    private String create_time;
    private String update_time;


    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getPerson_nm() {
        return person_nm;
    }

    public void setPerson_nm(String person_nm) {
        this.person_nm = person_nm;
    }

    public String getPerson_tel() {
        return person_tel;
    }

    public void setPerson_tel(String person_tel) {
        this.person_tel = person_tel;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
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
        return "ContactUser{" +
                "person_id='" + person_id + '\'' +
                ", person_nm='" + person_nm + '\'' +
                ", person_tel='" + person_tel + '\'' +
                ", person_email='" + person_email + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
