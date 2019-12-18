package com.exchange.webapp.applicationmanagement.dao;

import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AppProjectManagementDao {


    @Select("SELECT  t.prj_cd,p.person_nm,t.person_id,t.prj_nm,t.prj_desc,t.create_time,t.update_time from tb_project  t LEFT JOIN  tb_person  p on t.person_id = p.person_id")
    Page<AppProjectManagement> apmanagementList(@Param("currPage") int currPage, @Param("pageSize") int pageSize);

    @Insert("INSERT INTO tb_project (prj_cd,person_id,prj_nm,prj_desc,create_time,update_time) VALUES(#{prj_cd},#{person_id},#{prj_nm},#{prj_desc},NOW(),NOW())")
    void insertapmanagement(@Param("prj_cd") String prj_cd,@Param("person_id") int person_id,@Param("prj_nm") String prj_nm,@Param("prj_desc") String prj_desc);

    @Update("UPDATE tb_project SET  person_id=#{person_id},prj_nm =#{prj_nm},prj_desc=#{prj_desc},update_time =NOW() WHERE prj_cd =#{prj_cd}")
    void updateapmanagement(@Param("person_id")int person_id,@Param("prj_nm") String prj_nm, @Param("prj_desc")String prj_desc,@Param("prj_cd")String prj_cd);

    @Delete(value = "DELETE FROM tb_project WHERE prj_cd =#{prj_cd}")
    void delapmanagement(@Param("prj_cd") String prj_cd);


    @Select("SELECT\n" +
            "\tt.prj_cd,\n" +
            "\tp.person_nm,\n" +
            "\tt.prj_nm,\n" +
            "\tt.prj_desc,\n" +
            "\tt.create_time,\n" +
            "\tt.update_time\n" +
            "FROM\n" +
            "\ttb_project t\n" +
            "LEFT JOIN tb_person p ON p.person_id = t.person_id   WHERE  prj_cd = #{prj_cd}")
    List<AppProjectManagement> apmanagementselect(@Param("prj_cd") String prj_cd);


    @Select("select prj_cd,prj_nm from tb_project")
    List<AppProjectManagement> apmanagementselectlist();
}
