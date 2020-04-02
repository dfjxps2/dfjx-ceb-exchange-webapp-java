package com.exchange.webapp.monitor.controller;


import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
import com.exchange.webapp.monitor.service.LoggingService;
import com.webapp.support.json.JsonSupport;
import com.webapp.support.jsonp.JsonResult;
import com.webapp.support.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 日志Controller
 */
@Controller
@RequestMapping("/log")
public class LoggingController {

    @Autowired
    private LoggingService loggingService;

    //TransportLog列表
    @RequestMapping("/transportLogList")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String transportLogList(
            @RequestParam("currPage") int currPage,
            @RequestParam("pageSize")int pageSize,
            @RequestParam("prj_cd")String prj_cd,  //项目标识
            @RequestParam("mode")String mode,  //传输方式
            @RequestParam("guanjianzi")String guanjianzi,  //关键字
            @RequestParam("status")String status  //运行状态
    ){
        PageResult pageResult = null;
        try{
            pageResult = loggingService.transportLogList(currPage,pageSize,prj_cd,mode,guanjianzi,status);
        }catch(Exception e){
            return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "transportLog列表有误", null, e);
        }
        return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "transportLog列表成功", null, pageResult);
    }


    //transportLogstatusList列表
    @RequestMapping("/transportLogstatusList")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String transportLogstatusList(
            @RequestParam("currPage") int currPage,
            @RequestParam("pageSize")int pageSize,
            @RequestParam("guanjianzi")String guanjianzi  //关键字
    ){
        PageResult pageResult = null;
        try{
            pageResult = loggingService.transportLogstatusList(currPage,pageSize,guanjianzi);
        }catch(Exception e){
            return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "transportLogstatusList列表有误", null, "error");
        }
        return   JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "transportLogstatusList列表成功", null, pageResult);
    }


    //日志首页项目下拉
    @RequestMapping("/datamanagementprojectlist")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String datamanagementprojectlist(){
        List<AppProjectManagement> contactPageDatas;
        try{
            contactPageDatas = loggingService.datamanagementprojectlist();
        }catch(Exception e){
            return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "日志首页项目下拉失败", null, "error");
        }
        return   JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "日志首页项目下拉成功", null, contactPageDatas);
    }



    //查看日志;
    @RequestMapping("/selectlogList")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String selectlogList(
            @RequestParam("currPage") int currPage,
            @RequestParam("pageSize")int pageSize,
            @RequestParam("file_nm")String file_nm  //关键字
    ){
        PageResult pageResult = null;
        try{
            pageResult = loggingService.selectlogList(currPage,pageSize,file_nm);
        }catch(Exception e){
            return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "查看日志有误", null, "error");
        }
        return  JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "查看日志成功", null, pageResult);
    }



}
