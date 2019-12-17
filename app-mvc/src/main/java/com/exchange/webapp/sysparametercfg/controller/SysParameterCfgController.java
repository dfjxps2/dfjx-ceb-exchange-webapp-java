package com.exchange.webapp.sysparametercfg.controller;


import com.exchange.webapp.contact.bean.ContactUser;
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
 * 系统参数配置Controller
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
        String jsonResult = "";
        try{
            pageDatas = sysParameterCfgService.parameterse();
        }catch(Exception e){
            jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "失败", null, "error");
        }
        jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "成功", null, pageDatas);

        return jsonResult;
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
        String jsonResult = "";
        if(!aes_key.isEmpty() && !secret_key.isEmpty() ){
            try{
                sysParameterCfgService.updateparameter(id,aes_key,secret_key,heart_freq,file_backup,tran_timeout,limit_rate,log_backup,retries);
            }catch(Exception e){
                return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "修改联系人失败", null, "error");
            }
        }else{
            return   jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.FAILD, "请确认必填项是否填写内容", null, "error");
        }
        return  jsonResult = JsonSupport.makeJsonResultStr(JsonResult.RESULT.SUCCESS, "修改联系人成功", null, "success");
    }

}
