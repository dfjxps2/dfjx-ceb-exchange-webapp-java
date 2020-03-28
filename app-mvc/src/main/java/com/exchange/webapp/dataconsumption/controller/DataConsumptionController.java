package com.exchange.webapp.dataconsumption.controller;


import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
import com.exchange.webapp.dataconsumption.service.DataConsumptionService;
import com.exchange.webapp.dataproduction.controller.CronExpression;
import com.exchange.webapp.util.UrlPython;
import com.webapp.support.httpClient.HttpClientSupport;
import com.webapp.support.json.JsonSupport;
import com.webapp.support.jsonp.JsonResult;
import com.webapp.support.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 数据消费Controller
 */
@Controller
@RequestMapping("/consumption")
public class DataConsumptionController {

    @Autowired
    private DataConsumptionService dataConsumptionService;




    //数据消费管理列表
    @RequestMapping("/dataconsumptionList")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String dataconsumptionList(
            @RequestParam("currPage") int currPage,
            @RequestParam("pageSize")int pageSize,
            @RequestParam("prj_cd")String prj_cd,
            @RequestParam("cons_nm")String cons_nm
            ){
        PageResult pageResult = null;
        String jsonResult = "";
        try{
            pageResult = dataConsumptionService.dataconsumptionList(currPage,pageSize,prj_cd,cons_nm);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "查询数据消费管理列表有误", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "查询数据消费管理列表成功", null, pageResult);
    }



    //新增
    @RequestMapping("/insertdataconsumption")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String insertdataconsumption(
            @RequestParam("cons_nm") String cons_nm,
            @RequestParam("prj_cd")String prj_cd,
            @RequestParam("dat_cd")String dat_cd,
            @RequestParam("download_cron")String download_cron,
            @RequestParam("storage_path")String storage_path,
            @RequestParam("cons_desc")String cons_desc,
            @RequestParam("flag")String flag){
        String jsonResult = "";


        if(!cons_nm.isEmpty() && !prj_cd.isEmpty() && !dat_cd.isEmpty() && !download_cron.isEmpty() && !storage_path.isEmpty() ){
            try{
                //String download_cron  = "* 0/1 7-23 * * ?";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                CronExpression cronExpression = new CronExpression(download_cron);
                boolean resCron = cronExpression.isSatisfiedBy(simpleDateFormat.parse("2018-04-27 16:00:00"));
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请使用正确的cron表达式", null, "error");
            }
           /* int ss = 0;
            ss =   dataConsumptionService.yanzhengpath(storage_path);
            if(ss == 0){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "存储路径有误！", null, "error");
            }*/
            try{
                dataConsumptionService.insertdataconsumption(cons_nm,prj_cd,dat_cd,download_cron,storage_path,cons_desc,flag);
                int maxconsid = dataConsumptionService.selectmaxconsid();
                Map<String,Object> params = new HashMap();
                String pythonHost = UrlPython.PYTHONHOST;
                HttpClientSupport httpClientSupport = HttpClientSupport.getInstance(pythonHost);
                params.put("id",maxconsid);
                httpClientSupport.sendRequest("/config/consume/update",params, RequestMethod.POST,true);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "新增数据消费失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "新增数据消费成功", null, "success");
    }


    //修改
    @RequestMapping("/updatedataconsumption")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String updatedataconsumption(
            @RequestParam("cons_id") int cons_id,
            @RequestParam("cons_nm") String cons_nm,
            @RequestParam("prj_cd")String prj_cd,
            @RequestParam("dat_cd")String dat_cd,
            @RequestParam("download_cron")String download_cron,
            @RequestParam("storage_path")String storage_path,
            @RequestParam("cons_desc")String cons_desc,
            @RequestParam("flag")String flag){
        String jsonResult = "";

        if(!cons_nm.isEmpty() && !prj_cd.isEmpty() && !dat_cd.isEmpty() && !download_cron.isEmpty() && !storage_path.isEmpty()){
            try{
                //String download_cron  = "* 0/1 7-23 * * ?";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                CronExpression cronExpression = new CronExpression(download_cron);
                boolean resCron = cronExpression.isSatisfiedBy(simpleDateFormat.parse("2018-04-27 16:00:00"));
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请使用正确的cron表达式", null, "error");
            }
          /*  int ss = 0;
            ss =   dataConsumptionService.yanzhengpath(storage_path);
            if(ss == 0){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "存储路径有误！", null, "error");
            }*/
            try{
                dataConsumptionService.updatedataconsumption(cons_id,cons_nm,prj_cd,dat_cd,download_cron,storage_path,cons_desc,flag);
                Map<String,Object> params = new HashMap();
                String pythonHost = UrlPython.PYTHONHOST;
                HttpClientSupport httpClientSupport = HttpClientSupport.getInstance(pythonHost);
                params.put("id",cons_id);
                httpClientSupport.sendRequest("/config/consume/update",params, RequestMethod.POST,true);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "数据消费修改失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "数据消费修改成功", null, "success");
    }



    //修改状态
    @RequestMapping("/delconsumption")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String delpageContact(
            @RequestParam("cons_id") int cons_id,
            @RequestParam("flag")int flag){
        String jsonResult = "";

        try{
            dataConsumptionService.delpageContact(cons_id,flag);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "失败", null, "error");
        }
        return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "成功", null, "success");
    }


    //数据消费项目下拉
    @RequestMapping("/dataConsumptionprojectlist")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String dataConsumptionprojectlist(){
        List<AppProjectManagement> contactPageDatas;
        String jsonResult = "";
        try{
            contactPageDatas = dataConsumptionService.dataConsumptionprojectlist();
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "数据消费项目下拉失败", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "数据消费项目下拉成功", null, contactPageDatas);
    }




    @RequestMapping("/cron")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public static String cron(String data) throws Exception {
        String jsonResult = "";
        try{
            //String data  = "* 0/1 7-23 * * ?";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            CronExpression cronExpression = new CronExpression(data);

            boolean resCron = cronExpression.isSatisfiedBy(simpleDateFormat.parse("2018-04-27 16:00:00"));
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请使用正确的cron表达式", null, "error");
        }
        return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "cron表达式正确", null, "success");

    }

}
