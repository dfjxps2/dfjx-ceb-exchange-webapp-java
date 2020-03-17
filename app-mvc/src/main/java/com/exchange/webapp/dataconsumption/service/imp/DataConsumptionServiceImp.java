package com.exchange.webapp.dataconsumption.service.imp;

import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
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
    public void delpageContact(int cons_id, int flag) {
        dataConsumptionDao.delpageContact(cons_id,flag);
    }

    @Override
    public PageResult dataconsumptionList(int currPage, int pageSize, String prj_cd, String cons_nm) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<DataConsumption> contactPageDatas = dataConsumptionDao.dataconsumptionList(currPage, pageSize,prj_cd,cons_nm);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }


    @Override
    public void insertdataconsumption(String cons_nm, String prj_cd, String dat_cd, String download_cron, String storage_path, String cons_desc, String flag) {
        if ("".equals(flag) || flag == null){
            flag = "1";
        }
        int  cons_id = dataConsumptionDao.countuser();
        dataConsumptionDao.insertdataconsumption(cons_id,cons_nm,prj_cd,dat_cd,download_cron,storage_path,cons_desc,flag);
    }

    @Override
    public void updatedataconsumption(int cons_id, String cons_nm, String prj_cd, String dat_cd, String download_cron, String storage_path, String cons_desc, String flag) {
        if ("".equals(flag) || flag == null){
            flag = "1";
        }
        dataConsumptionDao.updatedataconsumption(cons_id,cons_nm,prj_cd,dat_cd,download_cron,storage_path,cons_desc,flag);

    }

    @Override
    public int yanzhengpath(String storage_path) {
        return dataConsumptionDao.yanzhengpath(storage_path);
    }

    @Override
    public List<AppProjectManagement> dataConsumptionprojectlist() {
        return dataConsumptionDao.dataConsumptionprojectlist();
    }

    @Override
    public int selectmaxconsid() {
        return dataConsumptionDao.selectmaxconsid();
    }


}
