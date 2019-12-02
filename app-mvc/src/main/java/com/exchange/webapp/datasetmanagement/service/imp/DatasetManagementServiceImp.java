package com.exchange.webapp.datasetmanagement.service.imp;


import com.exchange.webapp.dataconsumption.service.imp.DataConsumptionServiceImp;
import com.exchange.webapp.datasetmanagement.bean.DatasetManagement;
import com.exchange.webapp.datasetmanagement.dao.DatasetManagementDao;
import com.exchange.webapp.datasetmanagement.service.DatasetManagementService;
import com.github.pagehelper.Page;
import com.webapp.support.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("datasetManagementService")
public class DatasetManagementServiceImp  implements DatasetManagementService {

    private Logger logger = LoggerFactory.getLogger(DataConsumptionServiceImp.class);

    @Autowired
    private DatasetManagementDao datasetManagementDao;

    @Override
    public PageResult datamanagementList(int currPage, int pageSize, String yyxm, String gjz) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<DatasetManagement> contactPageDatas = datasetManagementDao.datamanagementList(currPage, pageSize,yyxm,gjz);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public List<DatasetManagement> datamanagementselect(String user_id) {
        return  datasetManagementDao.datamanagementselect(user_id);
    }

    @Override
    public void insertmanagement(String user_name, String mobile_phone, String email) {
        int  uuid = datasetManagementDao.countuser();
        datasetManagementDao.insertmanagement(uuid,user_name,mobile_phone,email);
    }

    @Override
    public void updatemanagement(String user_id, String user_name, String mobile_phone, String email) {
        datasetManagementDao.updatemanagement(user_id,user_name,mobile_phone,email);
    }

    @Override
    public void delmanagement(String user_id) {
        datasetManagementDao.delmanagement(user_id);
    }
}
