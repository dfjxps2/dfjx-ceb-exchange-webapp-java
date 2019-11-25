package com.exchange.webapp.contact.dao;

import com.exchange.webapp.contact.bean.ContactUser;
import com.github.pagehelper.Page;
import com.webapp.support.page.PageResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IContactDao {

    @Select("SELECT * FROM USER")
    Page<ContactUser> pageContact(@Param("pageSize") String pageSize, @Param("pageNum") String pageNum);

    @Select("SELECT MAX(user_id)+1 FROM USER")
    int countuser();

    @Insert("INSERT INTO USER (user_id,user_name,mobile_phone,email,reg_date) VALUES(#{uuid},#{user_name},#{mobile_phone},#{email},NOW())")
    void insertpageContact(@Param("uuid")int uuid,@Param("user_name") String user_name,@Param("mobile_phone") String mobile_phone,@Param("email") String email);


    @Update("UPDATE USER SET  user_name =#{user_name},mobile_phone=#{mobile_phone},email=#{email},last_login_time =NOW() WHERE user_id =#{user_id}")
    void updatepageContact(@Param("user_id")String user_id,@Param("user_name") String user_name, @Param("mobile_phone")String mobile_phone,@Param("email") String email);

    @Delete("DELETE FROM USER WHERE user_id =#{user_id}")
    void delpageContact(String user_id);


    @Select("select * from user where user_id = #{user_id}")
    List<ContactUser> pageContactselect(@Param("user_id") String user_id);
}
