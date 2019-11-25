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
    public PageResult pageContact(String pageSize, String pageNum) {
        logger.debug("当前页码:{},页面条数:{}",pageNum,pageSize);
        Page<ContactUser> contactPageDatas = contactDao.pageContact(pageSize, pageNum);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
      //  logger.info("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public void insertpageContact( String user_name, String mobile_phone, String email) {
          int  uuid = contactDao.countuser();
        contactDao.insertpageContact(uuid,user_name,mobile_phone,email);
    }

    @Override
    public void updatepageContact(String user_id, String user_name, String mobile_phone, String email) {
        contactDao.updatepageContact(user_id,user_name,mobile_phone,email);
    }

    @Override
    public void delpageContact(String user_id) {
        contactDao.delpageContact(user_id);
    }

    @Override
    public List<ContactUser> pageContactselect(String user_id) {
        return contactDao.pageContactselect(user_id);
    }


}
