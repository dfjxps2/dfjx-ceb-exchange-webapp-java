package com.exchange.webapp.dataconsumption.service;

import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
import com.exchange.webapp.dataconsumption.bean.DataConsumption;
import com.webapp.support.page.PageResult;

import java.util.List;

public interface DataConsumptionService {
    void delpageContact(int cons_id,int flag);

    PageResult dataconsumptionList(int currPage, int pageSize, String prj_cd, String cons_nm);


    void insertdataconsumption(String cons_nm, String prj_cd, String dat_cd, String download_cron, String storage_path, String cons_desc, String flag);

    void updatedataconsumption(int cons_id, String cons_nm, String prj_cd, String dat_cd, String download_cron, String storage_path, String cons_desc, String flag);

    int yanzhengpath(String storage_path);

    List<AppProjectManagement> dataConsumptionprojectlist();
}
