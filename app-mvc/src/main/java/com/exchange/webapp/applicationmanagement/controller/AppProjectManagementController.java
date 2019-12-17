package com.exchange.webapp.applicationmanagement.controller;

import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
import com.exchange.webapp.applicationmanagement.service.AppProjectManagementService;
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
 * tb_project管理Controller
 */
@Controller
@RequestMapping("/consumption")
public class AppProjectManagementController {

    @Autowired
    private AppProjectManagementService appProjectManagementService;

    //tb_project应用管理列表
    @RequestMapping("/apmanagementList")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String apmanagementList(
            @RequestParam("currPage") int currPage,
            @RequestParam("pageSize")int pageSize
    ){
        PageResult pageResult = null;
        String jsonResult = "";
        try{
            pageResult = appProjectManagementService.apmanagementList(currPage,pageSize);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "查询应用管理列表有误", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "查询应用管理列表成功", null, pageResult);
    }



    //查看
    @RequestMapping("/apmanagementselect")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String apmanagementselect(
            @RequestParam("prj_cd") String prj_cd){
        List<AppProjectManagement> contactPageDatas;
        String jsonResult = "";
        try{
            contactPageDatas = appProjectManagementService.apmanagementselect(prj_cd);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "应用管理查看失败", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "应用管理查看成功", null, contactPageDatas);
    }


    //数据集项目下拉
    @RequestMapping("/apmanagementselectlist")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String apmanagementselectlist(){
        List<AppProjectManagement> contactPageDatas;
        String jsonResult = "";
        try{
            contactPageDatas = appProjectManagementService.apmanagementselectlist();
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "应用管理查看失败", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "应用管理查看成功", null, contactPageDatas);
    }



    //新增
    @RequestMapping("/insertapmanagement")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String insertAPManagement(
            @RequestParam("prj_cd") String prj_cd,
            @RequestParam("person_id")int person_id,
            @RequestParam("prj_nm")String prj_nm,
            @RequestParam("prj_desc")String prj_desc){
        String jsonResult = "";

        if(!prj_cd.isEmpty() && !prj_nm.isEmpty()){
            try{
                appProjectManagementService.insertapmanagement(prj_cd,person_id,prj_nm,prj_desc);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "新增应用管理失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "新增应用管理成功", null, "success");
    }


    //修改
    @RequestMapping("/updateapmanagement")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String updateapmanagement(
            @RequestParam("prj_cd") String prj_cd,
            @RequestParam("person_id")int person_id,
            @RequestParam("prj_nm")String prj_nm,
            @RequestParam("prj_desc")String prj_desc){
        String jsonResult = "";

        if( !prj_nm.isEmpty()  && !prj_cd.isEmpty()){
            try{
                appProjectManagementService.updateapmanagement(person_id,prj_nm,prj_desc,prj_cd);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "应用管理修改失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "应用管理修改成功", null, "success");
    }



    //删除
    @RequestMapping("/delapmanagement")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String delapmanagement(
            @RequestParam("prj_cd") String prj_cd){
        String jsonResult = "";

        try{
            appProjectManagementService.delapmanagement(prj_cd);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "删除失败", null, "error");
        }
        return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "删除成功", null, "error");
    }
}
