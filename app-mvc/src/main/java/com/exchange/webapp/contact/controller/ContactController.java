package com.exchange.webapp.contact.controller;


import com.exchange.webapp.contact.bean.ContactUser;
import com.exchange.webapp.contact.service.ContactService;
import com.exchange.webapp.util.R;
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
    public R pageContact(
            @RequestParam("currPage") String currPage,
            @RequestParam("pageSize")String pageSize){
        PageResult pageResult = null;
        try{
             pageResult = contactService.pageContact(currPage,pageSize);
        }catch(Exception e){
            return R.error(-1, "查询联系人管理列表有误！");
        }

        return R.ok("List",pageResult);
    }


    //联系人查看
    @RequestMapping("/pageContactselect")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public R pageContactselect(
            @RequestParam("user_id") String user_id){
        List<ContactUser> contactPageDatas;
        try{
            contactPageDatas = contactService.pageContactselect(user_id);
        }catch(Exception e){
            return R.error(-1, "查询联系人有误！");
        }

        return R.ok().put("List",contactPageDatas);
    }


    //新增联系人
    @RequestMapping("/insertpageContact")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
        public R insertpageContact(
            @RequestParam("user_name") String user_name,
            @RequestParam("mobile_phone")String mobile_phone,
            @RequestParam("email")String email){
        if(!user_name.isEmpty() && !mobile_phone.isEmpty() && !email.isEmpty()){
            try{
                contactService.insertpageContact(user_name,mobile_phone,email);
            }catch(Exception e){
                return R.error(-1, "新增联系人有误！");
            }
        }else{
            return  R.error(-1,"请确认必填项是否填写内容！");
        }
        return R.ok();
    }


    //修改联系人
    @RequestMapping("/updatepageContact")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public R updatepageContact(
            @RequestParam("user_id") String user_id,
            @RequestParam("user_name") String user_name,
            @RequestParam("mobile_phone")String mobile_phone,
            @RequestParam("email")String email){
        if(!user_name.isEmpty() && !mobile_phone.isEmpty() && !email.isEmpty()){
            try{
                contactService.updatepageContact(user_id,user_name,mobile_phone,email);
            }catch(Exception e){
                return R.error(-1, "修改联系人有误！");
            }
        }else{
            return  R.error(-1,"请确认必填项是否填写内容！");
        }
        return R.ok();
    }



    //删除联系人
    @RequestMapping("/delpageContact")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public R delpageContact(
            @RequestParam("user_id") String user_id){
            try{
                contactService.delpageContact(user_id);
            }catch(Exception e){
                return R.error(-1, "删除联系人有误！");
            }
        return R.ok();
    }

}
