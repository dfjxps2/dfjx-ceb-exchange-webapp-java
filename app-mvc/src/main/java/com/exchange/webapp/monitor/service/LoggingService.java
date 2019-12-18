package com.exchange.webapp.monitor.service;

import com.webapp.support.page.PageResult;

public interface LoggingService {


    PageResult transportLogList(int currPage, int pageSize, String prj_cd, String mode, String guanjianzi, String status);


    PageResult transportLogstatusList(int currPage, int pageSize, String guanjianzi);

    PageResult selectlogList(int currPage, int pageSize, String file_nm);
}
