package com.exchange.webapp.dataproduction.service;

import com.exchange.webapp.dataproduction.bean.DataProduction;
import com.webapp.support.page.PageResult;

import java.util.List;


public interface DataProductionService {

    PageResult dataproductionList(int currPage, int pageSize, String yyxm, String gjz);

    List<DataProduction> dataproductionselect(String user_id);

    void insertdataproduction(String user_name, String mobile_phone, String email);

    void updatedataproduction(String user_id, String user_name, String mobile_phone, String email);

    void delproduction(String user_id);
}
