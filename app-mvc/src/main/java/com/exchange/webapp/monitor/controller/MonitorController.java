package com.exchange.webapp.monitor.controller;


import com.exchange.webapp.monitor.bean.Tbserver;
import com.exchange.webapp.monitor.service.MonitorService;
import com.exchange.webapp.util.UrlPython;
import com.webapp.support.httpClient.HttpClientSupport;
import com.webapp.support.json.JsonSupport;
import com.webapp.support.jsonp.JsonResult;
import com.webapp.support.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        try{
            pageResult = monitorService.selectTbagentList(currPage,pageSize);
        }catch(Exception e){
            return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "Tbagent列表有误", null, "error");
        }
        return   JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "Tbagent列表成功", null, pageResult);
    }


    //Tbserver
    @RequestMapping("/tbserverselect")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String tbserverselect(){
        List<Tbserver> pageDatas = null;
        try{
            Map<String,Object> params = new HashMap();
            String pythonHost = UrlPython.PYTHONHOST;
            HttpClientSupport httpClientSupport = HttpClientSupport.getInstance(pythonHost);
            httpClientSupport.sendRequest("/server/status",params, RequestMethod.POST,true);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
          pageDatas = monitorService.tbserverselect();
        }catch(Exception e){
            e.printStackTrace();
          return   JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "Tbserver失败", null, "error");
        }
        return   JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "Tbserver成功", null, pageDatas);

    }






}
