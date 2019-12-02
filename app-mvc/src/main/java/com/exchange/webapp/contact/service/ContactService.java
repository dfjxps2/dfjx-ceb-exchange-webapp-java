package com.exchange.webapp.contact.service;

import com.exchange.webapp.contact.bean.ContactUser;
import com.webapp.support.page.PageResult;

import java.util.List;

public interface ContactService {

    PageResult pageContact(int currPage,int pageSize);

    void insertpageContact(String user_name, String mobile_phone, String email);

    void updatepageContact(String user_id, String user_name, String mobile_phone, String email);

    void delpageContact(String user_id);

    List<ContactUser> pageContactselect(String user_id);
}
