package com.exchange.webapp.contact.controller;


import com.exchange.webapp.contact.bean.ContactUser;
import com.exchange.webapp.contact.service.ContactService;
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
        try{
             pageResult = contactService.pageContact(currPage,pageSize);
        }catch(Exception e){
            return JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "获取联系人管理列表失败", null, "error");
        }
        return JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "获取联系人管理列表成功", null, pageResult);
    }


    //联系人查看
    @RequestMapping("/pageContactselect")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String pageContactselect(
            @RequestParam("person_id") int person_id){
        List<ContactUser> contactPageDatas = null;
        try{
            contactPageDatas = contactService.pageContactselect(person_id);
        }catch(Exception e){
            return JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "查询联系人失败", null, "error");
        }
        return JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "查询联系人成功", null, contactPageDatas);

    }


    //联系人下拉框  （应用管理新增）
    @RequestMapping("/pageContactsxiala")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String pageContactsxiala(){
        List<ContactUser> contactPageDatas = null;
        String jsonResult = "";
        try{
            contactPageDatas = contactService.pageContactsxiala();
        }catch(Exception e){
            return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "失败", null, "error");
        }
        return   JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "成功", null, contactPageDatas);

    }


    //新增联系人
    @RequestMapping("/insertpageContact")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
        public String insertpageContact(
            @RequestParam("person_nm") String person_nm,
            @RequestParam("person_tel")String person_tel,
            @RequestParam("person_email")String person_email){
        if(!person_nm.isEmpty() && !person_tel.isEmpty() ){
            try{
                contactService.insertpageContact(person_nm,person_tel,person_email);
            }catch(Exception e){
                return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "新增联系人失败", null, "error");
            }
        }else{
            return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "新增联系人成功", null, "success");

    }



    //修改联系人
    @RequestMapping("/updatepageContact")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String updatepageContact(
            @RequestParam("person_id") int person_id,
            @RequestParam("person_nm") String person_nm,
            @RequestParam("person_tel")String person_tel,
            @RequestParam("person_email")String person_email){
        if(!person_nm.isEmpty() && !person_tel.isEmpty() ){
            try{
                contactService.updatepageContact(person_id,person_nm,person_tel,person_email);
            }catch(Exception e){
                return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "修改联系人失败", null, "error");
            }
        }else{
            return   JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return   JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "修改联系人成功", null, "success");
    }



    //删除联系人
    @RequestMapping("/delpageContact")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String delpageContact(
            @RequestParam("person_id") int person_id){
        try{
                contactService.delpageContact(person_id);
            }catch(Exception e){
                return   JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "删除联系人失败", null, "error");
            }
        return  JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "删除联系人成功", null, "success");
    }

}
