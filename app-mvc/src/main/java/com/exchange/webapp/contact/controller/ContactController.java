package com.exchange.webapp.contact.controller;


import com.exchange.webapp.contact.service.ContactService;
import com.webapp.support.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 联系人Controller
 */
@Controller
@RequestMapping("contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("pageContact")
    @ResponseBody
    @CrossOrigin(allowCredentials="true")
    public PageResult pageContact(
            @RequestParam("pageSize") String pageSize,
            @RequestParam("pageNumber")String pageNumber){

        PageResult pageResult = contactService.pageContact(pageSize,pageNumber);

        return pageResult;
    }

}
