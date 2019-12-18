package com.exchange.webapp.monitor.bean;

public class Tbserver {



    private  int   id;//'ID',
    private String   server1; //'服务器1',
    private String  status1; //'运行状态1',
    private String  server2; //'服务器2',
    private String     status2; // '运行状态2',
    private String      total; // '总存储空间',
    private String     used; // '已使用空间',
    private String    free; //'剩余空间'


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServer1() {
        return server1;
    }

    public void setServer1(String server1) {
        this.server1 = server1;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getServer2() {
        return server2;
    }

    public void setServer2(String server2) {
        this.server2 = server2;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }
}
