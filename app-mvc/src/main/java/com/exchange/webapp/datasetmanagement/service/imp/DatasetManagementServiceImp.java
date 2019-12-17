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
    public PageResult datamanagementList(int currPage, int pageSize, String prj_cd, String bsornm) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<DatasetManagement> contactPageDatas = datasetManagementDao.datamanagementList(currPage, pageSize,prj_cd,bsornm);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }


    @Override
    public void insertmanagement(String dat_cd, String prj_cd, String dat_nm, String file_regexp, String dat_desc) {
        datasetManagementDao.insertmanagement(dat_cd,prj_cd,dat_nm,file_regexp,dat_desc);
    }

    @Override
    public void updatemanagement(String dat_cd, String prj_cd, String dat_nm, String file_regexp, String dat_desc) {
        datasetManagementDao.updatemanagement(dat_cd,prj_cd,dat_nm,file_regexp,dat_desc);
    }

    @Override
    public void delmanagement(String dat_cd,int flag) {
        datasetManagementDao.delmanagement(dat_cd,flag);
    }

    @Override
    public List<DatasetManagement> datamanagementselectlist() {
        return datasetManagementDao.datamanagementselectlist();
    }

    @Override
    public int selectkeymanagement(String dat_cd) {
        return datasetManagementDao.selectkeymanagement(dat_cd);
    }
}
