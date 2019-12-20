package com.exchange.webapp.datasetmanagement.controller;


import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
import com.exchange.webapp.datasetmanagement.bean.DatasetManagement;
import com.exchange.webapp.datasetmanagement.service.DatasetManagementService;
import com.webapp.support.json.JsonSupport;
import com.webapp.support.jsonp.JsonResult;
import com.webapp.support.page.PageResult;
import org.apache.commons.collections.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller
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
            @RequestParam("prj_cd")String prj_cd,
            @RequestParam("bsornm")String bsornm
    ){
        PageResult pageResult = null;
        String jsonResult = "";
        try{
            pageResult = datasetManagementService.datamanagementList(currPage,pageSize,prj_cd,bsornm);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "查询数据消费管理列表有误", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "查询数据消费管理列表成功", null, pageResult);
    }



    //数据集下拉
    @RequestMapping("/datamanagementselectlist")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String datamanagementselectlist(){
        List<DatasetManagement> contactPageDatas;
        String jsonResult = "";
        try{
            contactPageDatas = datasetManagementService.datamanagementselectlist();
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "数据集查看失败", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "数据集查看成功", null, contactPageDatas);
    }


    //数据集项目下拉
    @RequestMapping("/datamanagementprojectlist")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String datamanagementprojectlist(){
        List<AppProjectManagement> contactPageDatas;
        String jsonResult = "";
        try{
            contactPageDatas = datasetManagementService.datamanagementprojectlist();
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "项目列表失败", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "成功", null, contactPageDatas);
    }


    //新增
    @RequestMapping("/insertmanagement")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String insertmanagement(
            @RequestParam("dat_cd") String dat_cd,
            @RequestParam("prj_cd")String prj_cd,
            @RequestParam("dat_nm")String dat_nm,
            @RequestParam("file_regexp")String file_regexp,
            @RequestParam("dat_desc")String dat_desc){
        String jsonResult = "";
        boolean ss = false;
        ss =  valid(file_regexp);
        if (ss == false){return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "文件名命名规则无效", null, "error"); }
        if(!dat_cd.isEmpty() && !prj_cd.isEmpty() && !dat_nm.isEmpty()  && !file_regexp.isEmpty()){
            int  i=0;
             i =   datasetManagementService.selectkeymanagement(dat_cd);
            if(i != 0){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "数据集标识已存在", null, "error");
            }
            try{
                datasetManagementService.insertmanagement(dat_cd,prj_cd,dat_nm,file_regexp,dat_desc);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "新增数据集失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "新增数据集成功", null, "success");
    }


    //修改
    @RequestMapping("/updatemanagement")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String updatemanagement(
            @RequestParam("dat_cd") String dat_cd,
            @RequestParam("prj_cd")String prj_cd,
            @RequestParam("dat_nm")String dat_nm,
            @RequestParam("file_regexp")String file_regexp,
            @RequestParam("dat_desc")String dat_desc){
        String jsonResult = "";
       // try{Window.RegExp('abc)')}catch(e){alert(e)}
        boolean ss = false;
        ss =  valid(file_regexp);
        if (ss == false){return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "文件名命名规则无效", null, "error"); }
        if(!dat_cd.isEmpty() && !prj_cd.isEmpty() && !dat_nm.isEmpty()  && !file_regexp.isEmpty()){
            try{
                datasetManagementService.updatemanagement(dat_cd,prj_cd,dat_nm,file_regexp,dat_desc);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "数据集修改失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "数据集修改成功", null, "success");
    }



    //修改状态
    @RequestMapping("/delmanagement")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String delmanagement(
            @RequestParam("dat_cd") String dat_cd,
            @RequestParam("flag") int flag
    ){
        String jsonResult = "";

        try{
            datasetManagementService.delmanagement(dat_cd,flag);
        }catch(Exception e){
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "删除失败", null, "error");
        }
        return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "删除成功", null, "success");
    }

    //验证表达式是否有效
    public static boolean valid(String expression) {
        //定义一个栈数据结构
        ArrayStack stack = new ArrayStack(expression.length());
        //将符号按对应关系放到map里面，方便后面根据开始 符号取对应的结束符号
        Map<String, String> map = new HashMap<>();
        map.put("{", "}");
        map.put("[", "]");
        map.put("(", ")");
        char[] exp = expression.toCharArray();
        for (int i = 0; i < exp.length; i++) {
            if(exp[i] == '{' || exp[i] == '[' || exp[i] == '(') { //如果是开始符号，则压入栈
                stack.push(exp[i]); }
            if(exp[i] == '}' || exp[i] == ']' || exp[i] == ')') { //如果是结束符号，则判断当前栈顶元素和该结束符号是否是对应关系
                String c = String.valueOf(stack.pop());
                if(exp[i] != map.get(c).toCharArray()[0]) {
                    return false; }
            }
        }
        return true;
    }



   /* public static void main(String[] args) {
        String s = "{}(([{}])){}{}";
        System.out.println(valid(s));
    }
*/
  /*  String expression = "...";
    ScriptEngineManager mgr = new ScriptEngineManager();*/




}
