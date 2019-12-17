package com.exchange.webapp.monitor.bean;

public class TransportLog {

    private String dat_nm;
    private String scnm;
    private String xfnm;
    private int       id; //id',
    private String        dat_cd; //数据集标识',
    private String        dt; //'时间',
    private String       file_nm; //数据文件名',
    private int        mode; //传输方式 0上传 1下载',
    private int        size; //文件大小',
    private String        md5;//'文件MD5',
    private int        rate; //传输速率',
    private int        status; //'状态 0失败/1成功',


    public String getDat_nm() {
        return dat_nm;
    }

    public void setDat_nm(String dat_nm) {
        this.dat_nm = dat_nm;
    }

    public String getScnm() {
        return scnm;
    }

    public void setScnm(String scnm) {
        this.scnm = scnm;
    }

    public String getXfnm() {
        return xfnm;
    }

    public void setXfnm(String xfnm) {
        this.xfnm = xfnm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDat_cd() {
        return dat_cd;
    }

    public void setDat_cd(String dat_cd) {
        this.dat_cd = dat_cd;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getFile_nm() {
        return file_nm;
    }

    public void setFile_nm(String file_nm) {
        this.file_nm = file_nm;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransportLog{" +
                "dat_nm='" + dat_nm + '\'' +
                ", scnm='" + scnm + '\'' +
                ", xfnm='" + xfnm + '\'' +
                ", id=" + id +
                ", dat_cd='" + dat_cd + '\'' +
                ", dt='" + dt + '\'' +
                ", file_nm='" + file_nm + '\'' +
                ", mode=" + mode +
                ", size=" + size +
                ", md5='" + md5 + '\'' +
                ", rate=" + rate +
                ", status=" + status +
                '}';
    }
}
