package com.exchange.webapp.monitor.service.imp;


import com.exchange.webapp.contact.service.imp.ContactServiceImp;
import com.exchange.webapp.monitor.bean.Tbagent;
import com.exchange.webapp.monitor.bean.Tbserver;
import com.exchange.webapp.monitor.dao.MmontorDao;
import com.exchange.webapp.monitor.service.MonitorService;
import com.github.pagehelper.Page;
import com.webapp.support.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("monitorService")
public class MonitorServiceImp  implements MonitorService {

    private Logger logger = LoggerFactory.getLogger(ContactServiceImp.class);

    @Autowired
    private MmontorDao mmontorDao;


    @Override
    public PageResult selectTbagentList(int currPage, int pageSize) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<Tbagent> contactPageDatas = mmontorDao.selectTbagentList(currPage, pageSize);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public List<Tbserver> tbserverselect() {
        return mmontorDao.tbserverselect();
    }
}
