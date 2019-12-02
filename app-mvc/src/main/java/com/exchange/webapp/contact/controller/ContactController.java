package com.exchange.webapp.contact.controller;


import com.exchange.webapp.contact.bean.ContactUser;
import com.exchange.webapp.contact.service.ContactService;
import com.exchange.webapp.util.R;
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
 * 联系人Controller
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;


    //联系人管理列表
    @RequestMapping("/pageContact")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String pageContact(
            @RequestParam("currPage") int currPage,
            @RequestParam("pageSize")int pageSize){
        PageResult pageResult = null;
        String jsonResult = "";
        try{
             pageResult = contactService.pageContact(currPage,pageSize);
        }catch(Exception e){
            jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "获取联系人管理列表失败", null, "error");
        }
         jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "获取联系人管理列表成功", null, pageResult);
        return jsonResult;

    }


    //联系人查看
    @RequestMapping("/pageContactselect")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String pageContactselect(
            @RequestParam("user_id") String user_id){
        List<ContactUser> contactPageDatas = null;
        String jsonResult = "";
        try{
            contactPageDatas = contactService.pageContactselect(user_id);
        }catch(Exception e){
            jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "查询联系人失败", null, "error");
        }
        jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "查询联系人成功", null, contactPageDatas);

        return jsonResult;
    }


    //新增联系人
    @RequestMapping("/insertpageContact")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
        public String insertpageContact(
            @RequestParam("user_name") String user_name,
            @RequestParam("mobile_phone")String mobile_phone,
            @RequestParam("email")String email){
        String jsonResult = "";
        if(!user_name.isEmpty() && !mobile_phone.isEmpty() && !email.isEmpty()){
            try{
                contactService.insertpageContact(user_name,mobile_phone,email);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "新增联系人失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "新增联系人成功", null, "success");

    }


    //修改联系人
    @RequestMapping("/updatepageContact")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String updatepageContact(
            @RequestParam("user_id") String user_id,
            @RequestParam("user_name") String user_name,
            @RequestParam("mobile_phone")String mobile_phone,
            @RequestParam("email")String email){
        String jsonResult = "";
        if(!user_name.isEmpty() && !mobile_phone.isEmpty() && !email.isEmpty()){
            try{
                contactService.updatepageContact(user_id,user_name,mobile_phone,email);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "修改联系人失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "修改联系人成功", null, "success");
    }



    //删除联系人
    @RequestMapping("/delpageContact")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String delpageContact(
            @RequestParam("user_id") String user_id){
        String jsonResult = "";
        try{
                contactService.delpageContact(user_id);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "删除联系人失败", null, "error");
            }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "删除联系人成功", null, "success");
    }

}
