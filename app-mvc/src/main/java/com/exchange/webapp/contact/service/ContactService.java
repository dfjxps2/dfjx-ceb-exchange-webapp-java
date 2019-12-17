package com.exchange.webapp.contact.service;

import com.exchange.webapp.contact.bean.ContactUser;
import com.webapp.support.page.PageResult;

import java.util.List;

public interface ContactService {

    PageResult pageContact(int currPage,int pageSize);

    void insertpageContact(String person_nm, String person_tel, String person_email);

    void updatepageContact(int person_id, String person_nm, String person_tel, String person_email);

    void delpageContact(int person_id);

    List<ContactUser> pageContactselect(int person_id);

    List<ContactUser> pageContactsxiala();
}
