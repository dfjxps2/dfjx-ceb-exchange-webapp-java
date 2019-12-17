package com.exchange.webapp.monitor.service.imp;

import com.exchange.webapp.dataconsumption.service.imp.DataConsumptionServiceImp;
import com.exchange.webapp.monitor.bean.LogStatus;
import com.exchange.webapp.monitor.bean.TransportLog;
import com.exchange.webapp.monitor.dao.LoggingDao;
import com.exchange.webapp.monitor.service.LoggingService;
import com.github.pagehelper.Page;
import com.webapp.support.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("loggingService")
public class LoggingServiceImp implements LoggingService {


    private Logger logger = LoggerFactory.getLogger(DataConsumptionServiceImp.class);


    @Autowired
    private LoggingDao loggingDao;


    @Override
    public PageResult transportLogList(int currPage, int pageSize, String prj_cd, String mode, String guanjianzi, String status) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<TransportLog> contactPageDatas = loggingDao.transportLogList(currPage,pageSize,prj_cd,mode,guanjianzi,status);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public PageResult transportLogstatusList(int currPage, int pageSize, String guanjianzi) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        //传输方式 0上传
        Page<LogStatus> susu = loggingDao.transportLogstatussusuList(currPage,pageSize,guanjianzi);
        //传输方式 1下载
        Page<LogStatus> erer = loggingDao.transportLogstatusererList(currPage,pageSize,guanjianzi);
        for (int i=0; i<susu.size() ;i++){
            for (int f=0; f<erer.size() ;f++){
               if(susu.get(i).getFile_nm().equals(erer.get(f).getFile_nm())){
                   susu.get(i).setStatusxiazai(erer.get(f).getStatus());
                   susu.get(i).setXfnm(erer.get(f).getXfnm());
               };
            }
        }
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(susu);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public PageResult selectlogList(int currPage, int pageSize, String file_nm) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<TransportLog> contactPageDatas = loggingDao.selectlogList(currPage,pageSize,file_nm);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }
}
