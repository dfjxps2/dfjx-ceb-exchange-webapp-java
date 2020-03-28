package com.exchange.webapp.contact.dao;

import com.exchange.webapp.contact.bean.ContactUser;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IContactDao {

    @Select("select person_id,person_nm,person_tel,person_email,create_time,update_time from tb_person")
    Page<ContactUser> pageContact(@Param("currPage") int currPage, @Param("pageSize") int pageSize);


    @Insert("INSERT INTO tb_person (person_nm,person_tel,person_email,create_time,update_time) VALUES(#{person_nm},#{person_tel},#{person_email},NOW(),NOW())")
    void insertpageContact(@Param("person_nm") String person_nm,@Param("person_tel") String person_tel,@Param("person_email") String person_email);


    @Update("UPDATE tb_person SET  person_nm =#{person_nm},person_tel=#{person_tel},person_email=#{person_email},update_time =NOW() WHERE person_id =#{person_id}")
    void updatepageContact(@Param("person_id")int person_id,@Param("person_nm") String person_nm, @Param("person_tel")String person_tel,@Param("person_email") String person_email);

    @Delete("DELETE FROM tb_person WHERE person_id =#{person_id}")
    void delpageContact(@Param("person_id")int person_id);


    @Select("select * from tb_person where person_id = #{person_id}")
    List<ContactUser> pageContactselect(@Param("person_id") int person_id);

    @Select("select person_id,person_nm from tb_person")
    List<ContactUser> pageContactsxiala();
}
