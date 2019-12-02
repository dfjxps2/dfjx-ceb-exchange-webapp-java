package com.exchange.webapp.dataconsumption.service;

import com.exchange.webapp.dataconsumption.bean.DataConsumption;
import com.webapp.support.page.PageResult;

import java.util.List;

public interface DataConsumptionService {
    void delpageContact(String user_id);

    PageResult dataconsumptionList(int currPage, int pageSize, String yyxm, String gjz);

    List<DataConsumption> dataconsumptionselect(String user_id);

    void insertdataconsumption(String user_name, String mobile_phone, String email);

    void updatedataconsumption(String user_id, String user_name, String mobile_phone, String email);
}
