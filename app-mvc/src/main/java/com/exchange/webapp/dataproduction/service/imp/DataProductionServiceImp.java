package com.exchange.webapp.dataproduction.service.imp;

import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
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
    public PageResult dataproductionList(int currPage, int pageSize, String prj_cd, String prod_nm){
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<DataProduction> contactPageDatas = dataProductionDao.dataproductionList(currPage, pageSize,prj_cd,prod_nm);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public List<DataProduction> dataproductionselect(String prod_id) {
        return  dataProductionDao.dataproductionselect(prod_id);
    }

    @Override
    public void insertdataproduction(String prod_nm, String dat_cd, String prj_cd, String create_cron, String upload_cron, String storage_path, String flag) {
        if ("".equals(flag) || flag == null){
             flag = "1";
        }
        int  prod_id = dataProductionDao.countuser();
        dataProductionDao.insertdataproduction(prod_id,prod_nm,dat_cd,prj_cd,create_cron,upload_cron,storage_path,flag);
    }

    @Override
    public void updatedataproduction(int prod_id, String prod_nm, String dat_cd, String prj_cd, String create_cron, String upload_cron, String storage_path, String flag) {
        if ("".equals(flag) || flag == null){
            flag = "1";
        }
        dataProductionDao.updatedataproduction(prod_id,prod_nm,dat_cd,prj_cd,create_cron,upload_cron,storage_path,flag);
    }

    @Override
    public int yanzhengpath(String storage_path) {
       int ss =  dataProductionDao.yanzhengpath(storage_path);
       return  ss;
    }

    @Override
    public List<DataProduction> dataproductionselectxff(String prod_id) {
        return dataProductionDao.dataproductionselectxff(prod_id);
    }

    @Override
    public List<AppProjectManagement> dataProductionprojrctlist() {
        return dataProductionDao.dataProductionprojrctlist();
    }

    @Override
    public void delproduction(int prod_id,int flag) {
        dataProductionDao.delproduction(prod_id,flag);
    }


}
