package com.exchange.webapp.sysparametercfg.controller;


import com.exchange.webapp.sysparametercfg.bean.SysParameterCfg;
import com.exchange.webapp.sysparametercfg.service.SysParameterCfgService;
import com.webapp.support.json.JsonSupport;
import com.webapp.support.jsonp.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 配置Controller
 */
@Controller
@RequestMapping("/parameter")
public class SysParameterCfgController {

    @Autowired
    private SysParameterCfgService sysParameterCfgService;

    //系统参数配置
    @RequestMapping("/parameterselect")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String parameterse(){
        List<SysParameterCfg> pageDatas = null;
        try{
            pageDatas = sysParameterCfgService.parameterse();
        }catch(Exception e){
            return JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "失败", null, "error");
        }
        return JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "成功", null, pageDatas);
    }



    @RequestMapping("/updateparameter")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public String updateparameter(
            @RequestParam("id") int id,
            @RequestParam("aes_key") String aes_key,
            @RequestParam("secret_key") String secret_key,
            @RequestParam("heart_freq") int heart_freq,
            @RequestParam("file_backup") int file_backup,
            @RequestParam("tran_timeout")int tran_timeout,
            @RequestParam("limit_rate")int limit_rate,
            @RequestParam("log_backup")int log_backup,
            @RequestParam("retries")int retries){
        if("0".equals(String.valueOf(id)) || "null".equals(id)  || id <= 0){
                   return     JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "参数ID输入类型有误", null, "error"); }
        if("0".equals(String.valueOf(heart_freq)) || "null".equals(heart_freq)  || heart_freq <= 0){
                    return     JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "心跳周期输入类型有误", null, "error"); }
        if("0".equals(String.valueOf(file_backup)) || "null".equals(file_backup)  || file_backup <= 0){
                    return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "文件有效期输入类型有误", null, "error"); }
        if("0".equals(String.valueOf(tran_timeout)) || "null".equals(tran_timeout)  || tran_timeout <= 0){
                    return   JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "传输超时时长输入类型有误", null, "error"); }
        if("0".equals(String.valueOf(limit_rate)) || "null".equals(limit_rate)  || limit_rate <= 0){
                    return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "限速速率输入类型有误", null, "error"); }
        if("0".equals(String.valueOf(log_backup)) || "null".equals(log_backup)  || log_backup <= 0){
                    return     JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "日志保存周期数输入类型有误", null, "error"); }
        if("0".equals(String.valueOf(retries)) || "null".equals(retries)  || retries <= 0){
                    return     JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "自动重试次数输入类型有误", null, "error"); }
        if(!aes_key.isEmpty() && !secret_key.isEmpty() ){
            try{
                sysParameterCfgService.updateparameter(id,aes_key,secret_key,heart_freq,file_backup,tran_timeout,limit_rate,log_backup,retries);
            }catch(Exception e){
                return    JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "修改联系人失败", null, "error");
            }
        }else{
            return     JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "修改联系人成功", null, "success");
    }

}
