package com.exchange.webapp.applicationmanagement.service.imp;


import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
import com.exchange.webapp.applicationmanagement.dao.AppProjectManagementDao;
import com.exchange.webapp.applicationmanagement.service.AppProjectManagementService;
import com.exchange.webapp.dataconsumption.service.imp.DataConsumptionServiceImp;
import com.exchange.webapp.dataproduction.bean.DataProduction;
import com.github.pagehelper.Page;
import com.webapp.support.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appProjectManagementService")
public class AppProjectManagementServiceImp  implements AppProjectManagementService {

    private Logger logger = LoggerFactory.getLogger(DataConsumptionServiceImp.class);

    @Autowired
    private AppProjectManagementDao appProjectManagementDao;


    @Override
    public PageResult apmanagementList(int currPage, int pageSize, String yyxm, String gjz) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<AppProjectManagement> contactPageDatas = appProjectManagementDao.apmanagementList(currPage, pageSize,yyxm,gjz);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public List<AppProjectManagement> apmanagementselect(String user_id) {
        return  appProjectManagementDao.apmanagementselect(user_id);
    }

    @Override
    public void insertapmanagement(String user_name, String mobile_phone, String email) {
        int  uuid = appProjectManagementDao.countuser();
        appProjectManagementDao.insertapmanagement(uuid,user_name,mobile_phone,email);
    }

    @Override
    public void updateapmanagement(String user_id, String user_name, String mobile_phone, String email) {
        appProjectManagementDao.updateapmanagement(user_id,user_name,mobile_phone,email);
    }

    @Override
    public void delapmanagement(String user_id) {
        appProjectManagementDao.delapmanagement(user_id);

    }
}
