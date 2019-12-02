package com.exchange.webapp.dataproduction.service.imp;

import com.exchange.webapp.dataconsumption.service.imp.DataConsumptionServiceImp;
import com.exchange.webapp.dataproduction.bean.DataProduction;
import com.exchange.webapp.dataproduction.dao.DataProductionDao;
import com.github.pagehelper.Page;
import com.webapp.support.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.exchange.webapp.dataproduction.service.DataProductionService;

import java.util.List;

@Service("dataProductionService")
public class DataProductionServiceImp implements DataProductionService {

    private Logger logger = LoggerFactory.getLogger(DataConsumptionServiceImp.class);


    @Autowired
    private DataProductionDao dataProductionDao;


    @Override
    public PageResult dataproductionList(int currPage, int pageSize, String yyxm, String gjz) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<DataProduction> contactPageDatas = dataProductionDao.dataproductionList(currPage, pageSize,yyxm,gjz);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public List<DataProduction> dataproductionselect(String user_id) {
        return  dataProductionDao.dataproductionselect(user_id);
    }

    @Override
    public void insertdataproduction(String user_name, String mobile_phone, String email) {
        int  uuid = dataProductionDao.countuser();
        dataProductionDao.insertdataproduction(uuid,user_name,mobile_phone,email);
    }

    @Override
    public void updatedataproduction(String user_id, String user_name, String mobile_phone, String email) {
        dataProductionDao.updatedataproduction(user_id,user_name,mobile_phone,email);
    }

    @Override
    public void delproduction(String user_id) {
        dataProductionDao.delproduction(user_id);

    }
}
