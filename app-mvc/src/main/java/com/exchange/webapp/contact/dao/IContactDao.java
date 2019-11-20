package com.exchange.webapp.contact.dao;

import com.exchange.webapp.contact.bean.ContactUser;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IContactDao {

    @Select("select * from user")
    Page<ContactUser> pageContact(@Param("pageSize") String pageSize, @Param("pageNum") String pageNum);
}
