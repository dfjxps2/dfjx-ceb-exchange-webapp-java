package com.exchange.webapp.dataproduction.controller;


import com.exchange.webapp.dataproduction.bean.DataProduction;
import com.exchange.webapp.dataproduction.service.DataProductionService;
import com.sun.tools.javac.util.Assert;
import com.webapp.support.json.JsonSupport;
import com.webapp.support.jsonp.JsonResult;
import com.webapp.support.page.PageResult;
import org.apache.http.util.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 数据生产Controller
 */
@Controller
@RequestMapping("/production")
public class DataProductionController {

    @Autowired
    private DataProductionService dataProductionService;


    //数据生产管理列表
    @RequestMapping("/dataproductionList")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String dataproductionList(
            @RequestParam("currPage") int currPage,
            @RequestParam("pageSize")int pageSize,
            @RequestParam("prj_cd")String prj_cd,
            @RequestParam("prod_nm")String prod_nm
    ){
        PageResult pageResult = null;
        String jsonResult = "";
        try{
            pageResult = dataProductionService.dataproductionList(currPage,pageSize,prj_cd,prod_nm);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "查询数据消费管理列表有误", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "查询数据消费管理列表成功", null, pageResult);
    }



    //查看
    @RequestMapping("/dataproductionselect")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String dataproductionselect(
            @RequestParam("prod_id") String prod_id){
        List<DataProduction> contactPageDatas;
        String jsonResult = "";
        if ("".equals(prod_id)){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "生产计划ID为空", null, "error");
        }
        try{
            contactPageDatas = dataProductionService.dataproductionselect(prod_id);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "数据查看失败", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "数据查看成功", null, contactPageDatas);
    }


    //查看数据消费方
    @RequestMapping("/dataproductionselectxff")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String dataproductionselectxff(
            @RequestParam("prod_id") String prod_id){
        List<DataProduction> contactPageDatas;
        String jsonResult = "";
        try{
            contactPageDatas = dataProductionService.dataproductionselectxff(prod_id);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "数据消费方查看失败", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "数据消费方查看成功", null, contactPageDatas);
    }


    //新增生产
    @RequestMapping("/insertdataproduction")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String insertdataproduction(
            @RequestParam("prod_nm") String prod_nm,
            @RequestParam("dat_cd")String dat_cd,
            @RequestParam("prj_cd")String prj_cd,
            @RequestParam("create_cron")String create_cron,
            @RequestParam("upload_cron")String upload_cron,
            @RequestParam("storage_path")String storage_path,
            @RequestParam("flag")String flag){
        String jsonResult = "";
        if(!prod_nm.isEmpty() && !dat_cd.isEmpty() && !prj_cd.isEmpty() && !create_cron.isEmpty() && !upload_cron.isEmpty() && !storage_path.isEmpty() ){
            try{
                //String data  = "* 0/1 7-23 * * ?";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                CronExpression cronExpression = new CronExpression(create_cron);
                boolean resCron = cronExpression.isSatisfiedBy(simpleDateFormat.parse("2018-04-27 16:00:00"));
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请使用正确的cron表达式", null, "error");
            }
            try{
                //String data  = "* 0/1 7-23 * * ?";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                CronExpression cronExpression = new CronExpression(upload_cron);
                boolean resCron = cronExpression.isSatisfiedBy(simpleDateFormat.parse("2018-04-27 16:00:00"));
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请使用正确的cron表达式", null, "error");
            }


            int ss = 0;
            ss =   dataProductionService.yanzhengpath(storage_path);
            if(ss == 0){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "存储路径有误！", null, "error");
            }
            try{
                dataProductionService.insertdataproduction(prod_nm,dat_cd,prj_cd,create_cron,upload_cron,storage_path,flag);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "新增数据消费失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "新增数据消费成功", null, "success");
    }


    //修改
    @RequestMapping("/updatedataproduction")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String updatedataproduction(
            @RequestParam("prod_id") int prod_id,
            @RequestParam("prod_nm") String prod_nm,
            @RequestParam("dat_cd")String dat_cd,
            @RequestParam("prj_cd")String prj_cd,
            @RequestParam("create_cron")String create_cron,
            @RequestParam("upload_cron")String upload_cron,
            @RequestParam("storage_path")String storage_path,
            @RequestParam("flag")String flag){
        String jsonResult = "";
        if(!prod_nm.isEmpty() && !dat_cd.isEmpty() && !prj_cd.isEmpty() && !create_cron.isEmpty() && !upload_cron.isEmpty() && !storage_path.isEmpty()){
            try{
                //String data  = "* 0/1 7-23 * * ?";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                CronExpression cronExpression = new CronExpression(create_cron);
                boolean resCron = cronExpression.isSatisfiedBy(simpleDateFormat.parse("2018-04-27 16:00:00"));
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请使用正确的cron表达式", null, "error");
            }
            try{
                //String data  = "* 0/1 7-23 * * ?";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                CronExpression cronExpression = new CronExpression(upload_cron);
                boolean resCron = cronExpression.isSatisfiedBy(simpleDateFormat.parse("2018-04-27 16:00:00"));
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请使用正确的cron表达式", null, "error");
            }


            int ss = 0;
            ss =   dataProductionService.yanzhengpath(storage_path);
            if(ss == 0){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "存储路径有误！", null, "error");
            }
            try{
                dataProductionService.updatedataproduction(prod_id,prod_nm,dat_cd,prj_cd,create_cron,upload_cron,storage_path,flag);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "数据消费修改失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "数据消费修改成功", null, "success");
    }



    //修改状态
    @RequestMapping("/delproduction")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String delproduction(
            @RequestParam("prod_id") int prod_id,
            @RequestParam("flag")int flag
            ){
        String jsonResult = "";

        try{
            dataProductionService.delproduction(prod_id,flag);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "修改失败", null, "error");
        }
        return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "修改成功", null, "success");
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
