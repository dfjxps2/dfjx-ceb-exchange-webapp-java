package com.exchange.webapp.applicationmanagement.service;

import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
import com.webapp.support.page.PageResult;

import java.util.List;

public interface AppProjectManagementService {
    PageResult apmanagementList(int currPage, int pageSize);

    List<AppProjectManagement> apmanagementselect(String prj_cd);

    void insertapmanagement(String prj_cd,int person_id, String prj_nm, String prj_desc);

    void updateapmanagement(int person_id, String prj_nm, String prj_desc,String prj_cd);

    void delapmanagement(String prj_cd);

    List<AppProjectManagement> apmanagementselectlist();
}
