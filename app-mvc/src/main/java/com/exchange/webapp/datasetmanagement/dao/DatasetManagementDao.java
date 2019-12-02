package com.exchange.webapp.datasetmanagement.dao;

import com.exchange.webapp.datasetmanagement.bean.DatasetManagement;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DatasetManagementDao {


    @Select("SELECT * FROM USER")
    Page<DatasetManagement> datamanagementList(@Param("currPage") int currPage, @Param("pageSize") int pageSize, @Param("yyxm")String yyxm, @Param("gjz")String gjz);

    @Select("SELECT MAX(user_id)+1 FROM USER")
    int countuser();

    @Insert("INSERT INTO USER (user_id,user_name,mobile_phone,email,reg_date) VALUES(#{uuid},#{user_name},#{mobile_phone},#{email},NOW())")
    void insertmanagement(@Param("uuid")int uuid,@Param("user_name") String user_name,@Param("mobile_phone") String mobile_phone,@Param("email") String email);


    @Update("UPDATE USER SET  user_name =#{user_name},mobile_phone=#{mobile_phone},email=#{email},last_login_time =NOW() WHERE user_id =#{user_id}")
    void updatemanagement(@Param("user_id")String user_id,@Param("user_name") String user_name, @Param("mobile_phone")String mobile_phone,@Param("email") String email);

    @Delete("DELETE FROM USER WHERE user_id =#{user_id}")
    void delmanagement(String user_id);


    @Select("select * from user where user_id = #{user_id}")
    List<DatasetManagement> datamanagementselect(@Param("user_id") String user_id);
}
