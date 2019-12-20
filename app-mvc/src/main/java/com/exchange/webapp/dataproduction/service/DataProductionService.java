package com.exchange.webapp.dataproduction.service;

import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
import com.exchange.webapp.dataproduction.bean.DataProduction;
import com.webapp.support.page.PageResult;

import java.util.List;


public interface DataProductionService {
    PageResult dataproductionList(int currPage, int pageSize, String prj_cd, String prod_nm);

    List<DataProduction> dataproductionselect(String prod_id);

    void delproduction(int prod_id,int flag);

    void insertdataproduction(String prod_nm, String dat_cd, String prj_cd, String create_cron, String upload_cron, String storage_path, String flag);

    void updatedataproduction(int prod_id, String prod_nm, String dat_cd, String prj_cd, String create_cron, String upload_cron, String storage_path, String flag);

    int yanzhengpath(String storage_path);

    List<DataProduction> dataproductionselectxff(String prod_id);

    List<AppProjectManagement> dataProductionprojrctlist();
}
