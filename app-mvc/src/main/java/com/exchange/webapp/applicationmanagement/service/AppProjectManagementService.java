package com.exchange.webapp.applicationmanagement.service;

import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
import com.webapp.support.page.PageResult;

import java.util.List;

public interface AppProjectManagementService {
    PageResult apmanagementList(int currPage, int pageSize, String yyxm, String gjz);

    List<AppProjectManagement> apmanagementselect(String user_id);

    void insertapmanagement(String user_name, String mobile_phone, String email);

    void updateapmanagement(String user_id, String user_name, String mobile_phone, String email);

    void delapmanagement(String user_id);
}
