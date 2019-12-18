package com.exchange.webapp.sysparametercfg.bean;

public class SysParameterCfg {

    private int       id;//参数ID',
    private String      aes_key;//参数加解密key',
    private String     secret_key;//secret key',
    private int        heart_freq;//心跳周期',
    private int         file_backup;//文件有效期',
    private int        tran_timeout;//'传输超时时长',
    private int        limit_rate;//'限速速率',
    private int        retries;//自动重试次数',
    private String     create_time;//创建时间',
    private String     update_time;//修改时间
    private String log_backup;

    public String getLog_backup() {
        return log_backup;
    }

    public void setLog_backup(String log_backup) {
        this.log_backup = log_backup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAes_key() {
        return aes_key;
    }

    public void setAes_key(String aes_key) {
        this.aes_key = aes_key;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public int getHeart_freq() {
        return heart_freq;
    }

    public void setHeart_freq(int heart_freq) {
        this.heart_freq = heart_freq;
    }

    public int getFile_backup() {
        return file_backup;
    }

    public void setFile_backup(int file_backup) {
        this.file_backup = file_backup;
    }

    public int getTran_timeout() {
        return tran_timeout;
    }

    public void setTran_timeout(int tran_timeout) {
        this.tran_timeout = tran_timeout;
    }

    public int getLimit_rate() {
        return limit_rate;
    }

    public void setLimit_rate(int limit_rate) {
        this.limit_rate = limit_rate;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
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
}
