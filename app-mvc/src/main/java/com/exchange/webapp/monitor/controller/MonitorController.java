package com.exchange.webapp.monitor.controller;


import com.exchange.webapp.monitor.bean.Tbserver;
import com.exchange.webapp.monitor.service.MonitorService;
import com.webapp.support.httpClient.HttpClientSupport;
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
 * 监控Controller
 */
@Controller
@RequestMapping("/monitor")
public class MonitorController {


    @Autowired
    private MonitorService monitorService;

    //Tbagent列表
    @RequestMapping("/selectTbagentList")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String selectTbagentList(
            @RequestParam("currPage") int currPage,
            @RequestParam("pageSize")int pageSize
    ){
        PageResult pageResult = null;
        String jsonResult = "";
        try{
            pageResult = monitorService.selectTbagentList(currPage,pageSize);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "Tbagent列表有误", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "Tbagent列表成功", null, pageResult);
    }


    //Tbserver
    @RequestMapping("/tbserverselect")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String tbserverselect(){
        List<Tbserver> pageDatas = null;
        String jsonResult = "";
        try{
          String   pythonHost = "http://192.168.175.140:8010/server/status";
          HttpClientSupport httpClientSupport = HttpClientSupport.getInstance(pythonHost);
          pageDatas = monitorService.tbserverselect();
        }catch(Exception e){
            jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "失败", null, "error");
        }
        jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "成功", null, pageDatas);

        return jsonResult;
    }






}
