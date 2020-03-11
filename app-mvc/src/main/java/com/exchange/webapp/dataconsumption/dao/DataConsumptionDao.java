package com.exchange.webapp.dataconsumption.dao;

import com.exchange.webapp.applicationmanagement.bean.AppProjectManagement;
import com.exchange.webapp.dataconsumption.bean.DataConsumption;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface DataConsumptionDao {

    @Select("<script>SELECT\n" +
            "\ta.cons_id,\n" +
            "\ta.cons_nm,\n" +
            "\ta.dat_cd,\n" +
            "\tb.dat_nm,\n" +
            "\ta.prj_cd,\n" +
            "\tc.prj_nm xfnm,\n"+
            "\te.prj_nm scnm,\n" +
            "\td.person_nm,\n" +
            "\ta.download_cron,\n" +
            "\ta.storage_path,\n" +
            "\ta.cons_desc,\n" +
            "\ta.create_time,\n" +
            "\ta.update_time,\n" +
            "\ta.flag\n" +
            "  FROM\n" +
            "\ttb_consume a\n" +
            "LEFT JOIN tb_data b ON a.dat_cd = b.dat_cd\n" +
            "LEFT JOIN tb_project c ON a.prj_cd = c.prj_cd\n" +
            "LEFT JOIN tb_project e ON e.prj_cd = b.prj_cd\n" +
            "LEFT JOIN tb_person d ON d.person_id = c.person_id\n" +
            "  WHERE\n" +
            "\t  1 = 1" +
            "<if test = \"prj_cd != null and prj_cd != ''\"> AND a.prj_cd = #{prj_cd} </if>" +
            "<if test = \"cons_nm != null and cons_nm != ''\"> AND a.cons_nm like concat('%', #{cons_nm},'%')  or   a.cons_nm like concat('%', #{cons_nm},'%')</if>" +
            "</script>")
    Page<DataConsumption> dataconsumptionList(@Param("currPage") int currPage, @Param("pageSize") int pageSize, @Param("prj_cd")String prj_cd, @Param("cons_nm")String cons_nm);


    @Select("SELECT MAX(cons_id)+1 FROM tb_consume")
    int countuser();

    @Insert("INSERT INTO tb_consume (cons_id,cons_nm,prj_cd,dat_cd,download_cron,storage_path,cons_desc,create_time,update_time,flag) VALUES(#{cons_id},#{cons_nm},#{prj_cd},#{dat_cd},#{download_cron},#{storage_path},#{cons_desc},NOW(),NOW(),#{flag})")
    void insertdataconsumption(@Param("cons_id")int cons_id, @Param("cons_nm")String cons_nm,@Param("prj_cd") String prj_cd, @Param("dat_cd")String dat_cd, @Param("download_cron")String download_cron, @Param("storage_path")String storage_path, @Param("cons_desc")String cons_desc, @Param("flag")String flag);


    @Update("UPDATE tb_consume SET  cons_nm =#{cons_nm},prj_cd=#{prj_cd},dat_cd=#{dat_cd},download_cron=#{download_cron},storage_path=#{storage_path},cons_desc=#{cons_desc},update_time =NOW(),flag = #{flag} WHERE cons_id =#{cons_id}")
    void updatedataconsumption(@Param("cons_id") int cons_id,@Param("cons_nm") String cons_nm, @Param("prj_cd")String prj_cd, @Param("dat_cd")String dat_cd, @Param("download_cron")String download_cron, @Param("storage_path")String storage_path,@Param("cons_desc") String cons_desc, @Param("flag")String flag);

    @Update("UPDATE tb_consume SET  flag =#{flag} WHERE cons_id =#{cons_id}")
    void delpageContact(@Param("cons_id") int cons_id,@Param("flag") int flag);



    @Select("SELECT COUNT(1) FROM tb_agent WHERE workdir  like concat('%', #{storage_path},'%')")
    int yanzhengpath(@Param("storage_path")String storage_path);

    @Select("SELECT\n" +
            "\tprj_cd,\n" +
            "\tprj_nm\n" +
            " FROM\n" +
            " tb_project \n" +
            " GROUP BY\n" +
            "\tprj_cd\n")
    List<AppProjectManagement> dataConsumptionprojectlist();
}
