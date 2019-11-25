package com.exchange.webapp.dataconsumption.controller;


import com.exchange.webapp.dataconsumption.service.DataConsumptionService;
import com.exchange.webapp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 数据消费Controller
 */
@Controller
@RequestMapping("/consumption")
public class DataConsumptionController {

    @Autowired
    private DataConsumptionService dataConsumptionService;

    //删除
    @RequestMapping("/delconsumption")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public R delpageContact(
            @RequestParam("user_id") String user_id){
        try{
            dataConsumptionService.delpageContact(user_id);
        }catch(Exception e){
            return R.error(-1, "删除有误！");
        }
        return R.ok();
    }

}
