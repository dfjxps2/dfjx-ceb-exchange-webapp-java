package com.exchange.webapp.datasetmanagement.service;

import com.exchange.webapp.datasetmanagement.bean.DatasetManagement;
import com.webapp.support.page.PageResult;

import java.util.List;

public interface DatasetManagementService {
   PageResult datamanagementList(int currPage, int pageSize, String prj_cd, String bsornm);

    void insertmanagement(String dat_cd, String prj_cd, String dat_nm, String file_regexp, String dat_desc);

    void updatemanagement(String dat_cd, String prj_cd, String dat_nm, String file_regexp, String dat_desc);

    void delmanagement(String dat_cd,int flag);

    List<DatasetManagement> datamanagementselectlist();

    int selectkeymanagement(String dat_cd);
}
