package com.exchange.webapp.dataconsumption.dao;

import com.exchange.webapp.contact.bean.ContactUser;
import com.exchange.webapp.dataconsumption.bean.DataConsumption;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DataConsumptionDao {

    @Select("SELECT * FROM USER")
    Page<DataConsumption> dataconsumptionList(@Param("pageSize") int pageSize, @Param("pageNum") int pageNum, @Param("yyxm")String yyxm, @Param("gjz")String gjz);

    @Select("SELECT MAX(user_id)+1 FROM USER")
    int countuser();

    @Insert("INSERT INTO USER (user_id,user_name,mobile_phone,email,reg_date) VALUES(#{uuid},#{user_name},#{mobile_phone},#{email},NOW())")
    void insertdataconsumption(@Param("uuid")int uuid,@Param("user_name") String user_name,@Param("mobile_phone") String mobile_phone,@Param("email") String email);


    @Update("UPDATE USER SET  user_name =#{user_name},mobile_phone=#{mobile_phone},email=#{email},last_login_time =NOW() WHERE user_id =#{user_id}")
    void updatedataconsumption(@Param("user_id")String user_id,@Param("user_name") String user_name, @Param("mobile_phone")String mobile_phone,@Param("email") String email);

    @Delete("DELETE FROM USER WHERE user_id =#{user_id}")
    void delpageContact(String user_id);


    @Select("select * from user where user_id = #{user_id}")
    List<DataConsumption> dataconsumptionselect(@Param("user_id") String user_id);

}
