package com.exchange.webapp.monitor.bean;

public class Tbagent {


    private String     agent; //'agent',
    private String     prj_cd;//'项目标识',
    private String     ip; //'ip地址',
    private int        agent_status; //'agent运行状态',
    private int        sftp_status; // 'SFTP检查',
    private int        last_heart;// '最后心跳间隔',
    private String     version; //'运行版本',
    private String     start_time; // '本次启动时间',
    private String     workdir; //'路径',
    private String prj_nm;
    private String public_key;

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public String getPrj_nm() {
        return prj_nm;
    }

    public void setPrj_nm(String prj_nm) {
        this.prj_nm = prj_nm;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getPrj_cd() {
        return prj_cd;
    }

    public void setPrj_cd(String prj_cd) {
        this.prj_cd = prj_cd;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getAgent_status() {
        return agent_status;
    }

    public void setAgent_status(int agent_status) {
        this.agent_status = agent_status;
    }

    public int getSftp_status() {
        return sftp_status;
    }

    public void setSftp_status(int sftp_status) {
        this.sftp_status = sftp_status;
    }

    public int getLast_heart() {
        return last_heart;
    }

    public void setLast_heart(int last_heart) {
        this.last_heart = last_heart;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getWorkdir() {
        return workdir;
    }

    public void setWorkdir(String workdir) {
        this.workdir = workdir;
    }
}
