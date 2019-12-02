package com.exchange.webapp.datasetmanagement.service;

import com.exchange.webapp.datasetmanagement.bean.DatasetManagement;
import com.webapp.support.page.PageResult;

import java.util.List;

public interface DatasetManagementService {
    PageResult datamanagementList(int currPage, int pageSize, String yyxm, String gjz);

    List<DatasetManagement> datamanagementselect(String user_id);

    void insertmanagement(String user_name, String mobile_phone, String email);

    void updatemanagement(String user_id, String user_name, String mobile_phone, String email);

    void delmanagement(String user_id);
}
