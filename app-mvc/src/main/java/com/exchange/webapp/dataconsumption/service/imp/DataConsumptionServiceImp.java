package com.exchange.webapp.dataconsumption.service.imp;

import com.exchange.webapp.contact.bean.ContactUser;
import com.exchange.webapp.dataconsumption.bean.DataConsumption;
import com.exchange.webapp.dataconsumption.dao.DataConsumptionDao;
import com.exchange.webapp.dataconsumption.service.DataConsumptionService;
import com.github.pagehelper.Page;
import com.webapp.support.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("dataConsumptionService")
public class DataConsumptionServiceImp implements DataConsumptionService {

    private Logger logger = LoggerFactory.getLogger(DataConsumptionServiceImp.class);

    @Autowired
    private DataConsumptionDao dataConsumptionDao;


    @Override
    public void delpageContact(String user_id) {
        dataConsumptionDao.delpageContact(user_id);
    }


    @Override
    public PageResult dataconsumptionList(int pageSize, int pageNum,String yyxm,String gjz) {
        logger.debug("当前页码:{},页面条数:{}",pageNum,pageSize);
        Page<DataConsumption> contactPageDatas = dataConsumptionDao.dataconsumptionList(pageSize, pageNum,yyxm,gjz);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public List<DataConsumption> dataconsumptionselect(String user_id) {
        return  dataConsumptionDao.dataconsumptionselect(user_id);
    }

    @Override
    public void insertdataconsumption(String user_name, String mobile_phone, String email) {
        int  uuid = dataConsumptionDao.countuser();
        dataConsumptionDao.insertdataconsumption(uuid,user_name,mobile_phone,email);
    }

    @Override
    public void updatedataconsumption(String user_id, String user_name, String mobile_phone, String email) {
        dataConsumptionDao.updatedataconsumption(user_id,user_name,mobile_phone,email);
    }


}
