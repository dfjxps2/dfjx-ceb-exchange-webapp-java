package com.exchange.webapp.datasetmanagement.controller;


import com.exchange.webapp.datasetmanagement.bean.DatasetManagement;
import com.exchange.webapp.datasetmanagement.service.DatasetManagementService;
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
 * 数据集管理Controller
 */
@Controller
@RequestMapping("/management")
public class DatasetManagementController {

    @Autowired
    private DatasetManagementService datasetManagementService;

    //数据集管理列表
    @RequestMapping("/datamanagementList")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String datamanagementList(
            @RequestParam("currPage") int currPage,
            @RequestParam("pageSize")int pageSize,
            @RequestParam("yyxm")String yyxm,
            @RequestParam("gjz")String gjz
    ){
        PageResult pageResult = null;
        String jsonResult = "";
        try{
            pageResult = datasetManagementService.datamanagementList(currPage,pageSize,yyxm,gjz);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "查询数据消费管理列表有误", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "查询数据消费管理列表成功", null, pageResult);
    }



    //查看
    @RequestMapping("/datamanagementselect")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String datamanagementselect(
            @RequestParam("user_id") String user_id){
        List<DatasetManagement> contactPageDatas;
        String jsonResult = "";
        try{
            contactPageDatas = datasetManagementService.datamanagementselect(user_id);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "数据消费查看失败", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "数据消费查看成功", null, contactPageDatas);
    }


    //新增
    @RequestMapping("/insertmanagement")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String insertmanagement(
            @RequestParam("user_name") String user_name,
            @RequestParam("mobile_phone")String mobile_phone,
            @RequestParam("email")String email){
        String jsonResult = "";

        if(!user_name.isEmpty() && !mobile_phone.isEmpty() && !email.isEmpty()){
            try{
                datasetManagementService.insertmanagement(user_name,mobile_phone,email);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "新增数据消费失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "新增数据消费成功", null, "success");
    }


    //修改
    @RequestMapping("/updatemanagement")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String updatemanagement(
            @RequestParam("user_id") String user_id,
            @RequestParam("user_name") String user_name,
            @RequestParam("mobile_phone")String mobile_phone,
            @RequestParam("email")String email){
        String jsonResult = "";

        if(!user_name.isEmpty() && !mobile_phone.isEmpty() && !email.isEmpty()){
            try{
                datasetManagementService.updatemanagement(user_id,user_name,mobile_phone,email);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "数据消费修改失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "数据消费修改成功", null, "success");
    }



    //删除
    @RequestMapping("/delmanagement")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String delmanagement(
            @RequestParam("user_id") String user_id){
        String jsonResult = "";

        try{
            datasetManagementService.delmanagement(user_id);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "删除失败", null, "error");
        }
        return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "删除成功", null, "error");
    }

}
