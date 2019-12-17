package com.exchange.webapp.datasetmanagement.dao;

import com.exchange.webapp.datasetmanagement.bean.DatasetManagement;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DatasetManagementDao {


    @Select("<script>SELECT \n" +
            "   a.dat_cd,\n" +
            "   a.dat_nm,\n" +
            "   b.prj_nm,\n" +
            "   c.person_nm,\n" +
            "   a.file_regexp,\n" +
            "   a.dat_desc,\n" +
            "   a.create_time,\n" +
            "   a.update_time,\n"+
            "   a.flag\n"+
            "  FROM  \n" +
            "   tb_data  a  \n" +
            "  LEFT JOIN  tb_project  b  on  a.prj_cd = b.prj_cd\n" +
            "  LEFT JOIN  tb_person   c  on  b.person_id = c.person_id\n" +
            "WHERE 1=1   " +
            "<if test = \"prj_cd != null and prj_cd != ''\"> AND a.prj_cd = #{prj_cd} </if>" +
            "<if test = \"bsornm != null and bsornm != ''\">AND a.dat_cd like concat('%', #{bsornm},'%')  or   a.dat_nm like concat('%', #{bsornm},'%')</if>" +
            "</script>")
    Page<DatasetManagement> datamanagementList(@Param("currPage") int currPage, @Param("pageSize") int pageSize, @Param("prj_cd")String prj_cd, @Param("bsornm")String bsornm);


    @Insert("INSERT INTO tb_data (dat_cd,prj_cd,dat_nm,file_regexp,dat_desc,create_time,update_time,flag) VALUES(#{dat_cd},#{prj_cd},#{dat_nm},#{file_regexp},#{dat_desc},NOW(),NOW(),1)")
    void insertmanagement(@Param("dat_cd") String dat_cd, @Param("prj_cd")String prj_cd, @Param("dat_nm")String dat_nm, @Param("file_regexp")String file_regexp, @Param("dat_desc")String dat_desc);


    @Update("UPDATE tb_data SET  prj_cd =#{prj_cd},dat_nm=#{dat_nm},file_regexp=#{file_regexp},dat_desc = #{dat_desc},update_time =NOW()   WHERE dat_cd =#{dat_cd}")
    void updatemanagement(@Param("dat_cd") String dat_cd,@Param("prj_cd")  String prj_cd,@Param("dat_nm")  String dat_nm,@Param("file_regexp")  String file_regexp,@Param("dat_desc")  String dat_desc);

    @Update("UPDATE tb_data SET  flag =#{flag} WHERE dat_cd =#{dat_cd}")
    void delmanagement(@Param("dat_cd") String dat_cd,@Param("flag")int flag);


    @Select("select * from tb_data where dat_cd = #{dat_cd}")
    List<DatasetManagement> datamanagementselect(@Param("dat_cd") String dat_cd);

    @Select("select dat_cd,dat_nm from tb_data")
    List<DatasetManagement> datamanagementselectlist();


    @Select("select count(1) from tb_data where dat_cd = #{dat_cd} ")
    int selectkeymanagement(@Param("dat_cd") String dat_cd);
}
