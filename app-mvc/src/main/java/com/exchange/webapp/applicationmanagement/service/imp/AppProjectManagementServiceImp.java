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
    public PageResult apmanagementList(int currPage, int pageSize) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<AppProjectManagement> contactPageDatas = appProjectManagementDao.apmanagementList(currPage, pageSize);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public List<AppProjectManagement> apmanagementselect(String prj_cd) {
        return  appProjectManagementDao.apmanagementselect(prj_cd);
    }

    @Override
    public void insertapmanagement(String prj_cd,int person_id, String prj_nm, String prj_desc){
        appProjectManagementDao.insertapmanagement(prj_cd,person_id,prj_nm,prj_desc);
    }

    @Override
    public void updateapmanagement(int person_id, String prj_nm, String prj_desc,String prj_cd) {
        appProjectManagementDao.updateapmanagement(person_id,prj_nm,prj_desc,prj_cd);
    }

    @Override
    public void delapmanagement(String prj_cd) {
        appProjectManagementDao.delapmanagement(prj_cd);

    }

    @Override
    public List<AppProjectManagement> apmanagementselectlist() {
        return appProjectManagementDao.apmanagementselectlist();
    }

    @Override
    public int selectprj_cd(String prj_cd) {
        return appProjectManagementDao.selectprj_cd(prj_cd);
    }
}
