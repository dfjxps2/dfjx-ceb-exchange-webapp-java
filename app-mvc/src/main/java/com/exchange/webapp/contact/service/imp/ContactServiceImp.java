package com.exchange.webapp.contact.service.imp;

import com.exchange.webapp.contact.bean.ContactUser;
import com.exchange.webapp.contact.dao.IContactDao;
import com.exchange.webapp.contact.service.ContactService;
import com.github.pagehelper.Page;
import com.webapp.support.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
public class ContactServiceImp implements ContactService {

    private Logger logger = LoggerFactory.getLogger(ContactServiceImp.class);

    @Autowired
    private IContactDao contactDao;

    @Override
    public PageResult pageContact(int currPage,int pageSize){
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<ContactUser> contactPageDatas = contactDao.pageContact(currPage, pageSize);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
      //  logger.info("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public void insertpageContact( String person_nm, String person_tel, String person_email) {
          int  person_id = contactDao.countuser();
        contactDao.insertpageContact(person_id,person_nm,person_tel,person_email);
    }

    @Override
    public void updatepageContact(int person_id, String person_nm, String person_tel, String person_email) {
        contactDao.updatepageContact(person_id,person_nm,person_tel,person_email);
    }

    @Override
    public void delpageContact(int person_id) {
        contactDao.delpageContact(person_id);
    }

    @Override
    public List<ContactUser> pageContactselect(int person_id) {
        return contactDao.pageContactselect(person_id);
    }

    @Override
    public List<ContactUser> pageContactsxiala() {
        return contactDao.pageContactsxiala();
    }


}
