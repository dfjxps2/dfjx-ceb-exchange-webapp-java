package com.exchange.webapp.dataproduction.dao;

import com.exchange.webapp.dataproduction.bean.DataProduction;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DataProductionDao {


    @Select("<script>SELECT\n" +
            "\ta.prod_id,\n" +
            "\ta.prod_nm,\n" +
            "  a.storage_path,\n" +
            "  a.create_cron,\n" +
            "  a.upload_cron,\n" +
            "  a.create_time,\n" +
            "  a.update_time,\n" +
            "  b.prj_nm scnm,\n" +
            "\tc.dat_nm,\n" +
            "  d.person_nm,\n" +
            "  \ta.flag\n" +
            " FROM  " +
            "\ttb_product a\n" +
            "LEFT JOIN tb_project b ON a.prj_cd = b.prj_cd\n" +
            "LEFT JOIN tb_data c ON c.dat_cd = a.dat_cd\n" +
            "LEFT JOIN tb_person d ON d.person_id = b.person_id" +
            "\t   where  1 = 1" +
            "<if test = \"prj_cd != null and prj_cd != ''\"> AND a.prj_cd = #{prj_cd} </if>" +
            "<if test = \"prod_nm != null and prod_nm != ''\">AND a.prod_nm like concat('%', #{prod_nm},'%')  or   a.prod_nm like concat('%', #{prod_nm},'%')</if>" +
            "</script>")
    Page<DataProduction> dataproductionList(@Param("currPage") int currPage, @Param("pageSize") int pageSize, @Param("prj_cd")String prj_cd, @Param("prod_nm")String prod_nm);


    @Select("SELECT MAX(prod_id)+1 FROM tb_product")
    int countuser();

    @Insert("INSERT INTO tb_product (\n" +
            "\tprod_id,\n" +
            "\tprod_nm,\n" +
            "\tdat_cd,\n" +
            "\tprj_cd,\n" +
            "\tcreate_cron,\n" +
            "\tupload_cron,\n" +
            "\tstorage_path,\n" +
            "\tcreate_time,\n" +
            "\tflag\n" +
            ") values(#{prod_id},#{prod_nm},#{dat_cd},#{prj_cd},#{create_cron},#{upload_cron},#{storage_path},NOW(),#{flag})")
    void insertdataproduction(@Param("prod_id")int prod_id, @Param("prod_nm")String prod_nm, @Param("dat_cd")String dat_cd, @Param("prj_cd")String prj_cd,@Param("create_cron") String create_cron,@Param("upload_cron") String upload_cron, @Param("storage_path")String storage_path,@Param("flag") String flag);

    @Update("UPDATE tb_product SET  prod_nm =#{prod_nm},dat_cd=#{dat_cd},prj_cd=#{prj_cd}, upload_cron =#{upload_cron},create_cron=#{create_cron},storage_path =#{storage_path},update_time =NOW(),flag = #{flag} WHERE prod_id =#{prod_id}")
    void updatedataproduction(@Param("prod_id")int prod_id, @Param("prod_nm")String prod_nm, @Param("dat_cd")String dat_cd, @Param("prj_cd")String prj_cd,@Param("create_cron") String create_cron,@Param("upload_cron") String upload_cron, @Param("storage_path")String storage_path,@Param("flag") String flag);

    @Update("UPDATE tb_product SET  flag =#{flag}  WHERE prod_id =#{prod_id}")
    void delproduction(@Param("prod_id")int prod_id,@Param("flag")int flag);


    @Select("<script>SELECT\n" +
            "\ta.prod_nm,\n" +
            "  b.prj_nm scnm,\n" +
            "\tc.dat_nm,\n" +
            "  a.create_cron,\n" +
            "\ta.upload_cron,\n" +
            "\ta.storage_path,\n" +
            "  d.person_nm,\n" +
            "\ta.create_time,\n" +
            "\ta.update_time,\n" +
            "\ta.flag\n" +
            "FROM\n" +
            "\ttb_product a\n" +
            "LEFT JOIN tb_project b ON a.prj_cd = b.prj_cd\n" +
            "LEFT JOIN tb_data c ON c.dat_cd = a.dat_cd\n" +
            "LEFT JOIN tb_person d ON d.person_id = b.person_id\n" +
            "WHERE\n" +
            "\t 1 = 1" +
            "<if test = \"prod_id != null and prod_id != ''\"> AND a.prod_id = #{prod_id} </if>" +
            "</script>")
    List<DataProduction> dataproductionselect(@Param("prod_id") String prod_id);


    @Select("SELECT COUNT(1) FROM tb_agent WHERE workdir  like concat('%', #{storage_path},'%')")
    int yanzhengpath(@Param("storage_path") String storage_path);

    @Select("<script>SELECT\n" +
            "\ta.prod_id,\n" +
            "\ta.prod_nm,\n" +
            "\ta.upload_cron,\n" +
            "\te.cons_nm,\n" +
            "\tb.prj_nm xfnm,\n" +
            "\tf.prj_nm scnm\n" +
            "FROM\n" +
            "\ttb_product a\n" +
            "LEFT JOIN tb_project b ON a.prj_cd = b.prj_cd\n" +
            "LEFT JOIN tb_data c ON c.dat_cd = a.dat_cd\n" +
            "LEFT JOIN tb_consume e ON e.prj_cd = c.prj_cd\n" +
            "LEFT JOIN tb_project f ON f.prj_cd = c.prj_cd\n" +
            "   WHERE \n" +
            "\t 1 = 1  " +
            "<if test = \"prod_id != null and prod_id != ''\"> AND a.prod_id = #{prod_id} </if>" +
            "</script>")
    List<DataProduction> dataproductionselectxff(@Param("prod_id")String prod_id);
}