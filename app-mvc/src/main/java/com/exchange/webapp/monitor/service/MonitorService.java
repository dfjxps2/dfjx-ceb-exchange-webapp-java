package com.exchange.webapp.monitor.service;

import com.exchange.webapp.monitor.bean.Tbserver;
import com.webapp.support.page.PageResult;

import java.util.List;

public interface MonitorService {
    PageResult selectTbagentList(int currPage, int pageSize);

    List<Tbserver> tbserverselect();
}
