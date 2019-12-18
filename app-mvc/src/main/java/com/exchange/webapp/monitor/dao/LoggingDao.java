package com.exchange.webapp.monitor.dao;

import com.exchange.webapp.monitor.bean.LogStatus;
import com.exchange.webapp.monitor.bean.TransportLog;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoggingDao {

/*
    @Select("<script> " +
            " select \n" +
            "  a.dat_cd,\n" +
            "  a.file_nm,\n" +
            "  MAX(a.dt) dt,\n" +
            "  a.mode,\n" +
            "  a.size,\n" +
            "  a.md5,\n" +
            "  a.rate,\n" +
            "  a.status," +
            "  b.dat_nm,\n" +
            "  c.prj_nm scnm,\n" +
            "  e.prj_nm xfnm\n" +
            "  FROM\n" +
            "\t  tb_log  a\n" +
            "LEFT JOIN tb_data b ON a.dat_cd = b.dat_cd\n" +
            "LEFT JOIN tb_project c ON b.prj_cd = c.prj_cd\n" +
            "LEFT JOIN tb_consume d ON d.dat_cd = b.dat_cd\n" +
            "LEFT JOIN tb_project e ON e.prj_cd = d.prj_cd\n" +
            "\t  where 1=1   " +
            "<if test = \"prj_cd != null and prj_cd != ''\"> AND c.prj_cd = #{prj_cd} </if>" +
            "<if test = \"mode != null and mode != ''\"> AND a.mode = #{mode} </if>" +
            "<if test = \"status != null and status != ''\"> AND a.status = #{status} </if>" +
            "<if test = \"guanjianzi != null and guanjianzi != ''\">AND a.file_nm like concat('%', #{guanjianzi},'%')  or   b.dat_nm like concat('%', #{guanjianzi},'%') </if>" +
            "  GROUP BY a.file_nm  order by a.dt  desc   </script>")*/


    @Select("<script>SELECT\n" +
            "\ta.id,\n" +
            "  a.dat_cd,\n" +
            "  a.file_nm,\n" +
            "  MAX(a.dt) dt,\n" +
            "  a.mode,\n" +
            "  a.size,\n" +
            "  a.md5,\n" +
            "  a.rate,\n" +
            "  a.status,\n" +
            "  b.dat_nm,\n" +
            "  c.prj_nm scnm,\n" +
            "  e.prj_nm xfnm\n" +
            "FROM\n" +
            "\ttb_log a\n" +
            "LEFT JOIN tb_data b ON a.dat_cd = b.dat_cd\n" +
            "LEFT JOIN tb_project c ON b.prj_cd = c.prj_cd\n" +
            "LEFT JOIN tb_consume d ON d.dat_cd = b.dat_cd\n" +
            "LEFT JOIN tb_project e ON e.prj_cd = d.prj_cd\n" +
            "\twhere 1=1   " +
            "<if test = \"prj_cd != null and prj_cd != ''\"> AND c.prj_cd = #{prj_cd} </if>" +
            "<if test = \"mode != null and mode != ''\"> AND a.mode = #{mode} </if>" +
            "<if test = \"status != null and status != ''\"> AND a.status = #{status} </if>" +
            "<if test = \"guanjianzi != null and guanjianzi != ''\">AND a.file_nm like concat('%', #{guanjianzi},'%')  or   b.dat_nm like concat('%', #{guanjianzi},'%') </if>" +
            " GROUP BY a.file_nm,a.id,a.dat_cd,a.dt,a.mode,a.size,a.md5,a.rate,a.status,b.dat_nm,scnm,xfnm\n" +
            "   order by a.dt desc </script>")
    Page<TransportLog> transportLogList(@Param("currPage") int currPage, @Param("pageSize")int pageSize,@Param("prj_cd") String prj_cd, @Param("mode")String mode, @Param("guanjianzi")String guanjianzi, @Param("status")String status);

  /*  GROUP BY a.file_nm  order by a.dt  desc*/
 /*   @Select("<script>select *\n" +
            "from \n" +
            "(\n" +
            "   SELECT\n" +
            "\ta.file_nm,\n" +
            "  a.dt,\n" +
            "  a.status,\n" +
            "  b.dat_nm,\n" +
            "  c.prj_nm scnm,\n" +
            "  e.prj_nm xfnm" +
            "  FROM\n" +
            "\ttb_log a\n" +
            "LEFT JOIN tb_data b ON a.dat_cd = b.dat_cd\n" +
            "LEFT JOIN tb_project c ON b.prj_cd = c.prj_cd\n" +
            "LEFT JOIN tb_consume d ON d.dat_cd = b.dat_cd\n" +
            "LEFT JOIN tb_project e ON e.prj_cd = d.prj_cd\n" +
            "\twhere  a.mode = 0  and TO_DAYS(a.dt)=TO_DAYS(now()) " +
            "<if test = \"prj_cd != null and prj_cd != ''\"> AND c.prj_cd = #{prj_cd} </if>" +
            "<if test = \"guanjianzi != null and guanjianzi != ''\">AND a.file_nm like concat('%', #{guanjianzi},'%')  or   b.dat_nm like concat('%', #{guanjianzi},'%')</if>" +
            " GROUP BY a.file_nm  \n" +
            ") t order by t.dt desc </script>")*/

    @Select("<script>" +
            "select\n" +
            "a.file_nm,\n" +
            "a.dt,\n" +
            "a.status,\n" +
            "b.dat_nm,\n" +
            "c.prj_nm  scnm\n" +
            " from \n" +
            "tb_log a INNER join \n" +
            "(select max(f.dt) maxdt,file_nm from tb_log  f where  f.mode = 0 and TO_DAYS(f.dt)=TO_DAYS(now()) group by file_nm) maxtmp on a.dt=maxtmp.maxdt and a.file_nm=maxtmp.file_nm\n" +
            "LEFT JOIN tb_data b ON a.dat_cd = b.dat_cd\n" +
            "LEFT JOIN tb_project c ON b.prj_cd = c.prj_cd\n" +
            "  where 1=1 " +
            "<if test = \"guanjianzi != null and guanjianzi != ''\">AND a.file_nm like concat('%', #{guanjianzi},'%')  or   b.dat_nm like concat('%', #{guanjianzi},'%')</if>" +
            "  order by a.dt desc</script>")
    Page<LogStatus> transportLogstatussusuList(@Param("currPage")int currPage,@Param("pageSize")int pageSize, @Param("guanjianzi")String guanjianzi);


    @Select("<script>" +
            "select\n" +
            "a.file_nm,\n" +
            "a.dt,\n" +
            "a.status,\n" +
            "b.dat_nm,\n" +
            "c.prj_nm xfnm\n" +
            " from \n" +
            "tb_log a INNER join \n" +
            "(select max(f.dt) maxdt,file_nm from tb_log  f where  f.mode = 1 and TO_DAYS(f.dt)=TO_DAYS(now()) group by file_nm) maxtmp on a.dt=maxtmp.maxdt and a.file_nm=maxtmp.file_nm\n" +
            "LEFT JOIN tb_data b ON a.dat_cd = b.dat_cd\n" +
            "LEFT JOIN tb_project c ON b.prj_cd = c.prj_cd\n" +
            "  where 1=1 " +
            "<if test = \"guanjianzi != null and guanjianzi != ''\">AND a.file_nm like concat('%', #{guanjianzi},'%')  or   b.dat_nm like concat('%', #{guanjianzi},'%')</if>" +
            "   order by a.dt desc</script>")
    Page<LogStatus> transportLogstatusererList(@Param("currPage")int currPage,@Param("pageSize")int pageSize, @Param("guanjianzi")String guanjianzi);



    @Select("<script> SELECT\n" +
            "\ta.*,\n" +
            "  b.dat_nm,\n" +
            "  c.prj_nm scnm,\n" +
            "  e.prj_nm xfnm\n" +
            "  FROM\n" +
            "\ttb_log a\n" +
            "LEFT JOIN tb_data b ON a.dat_cd = b.dat_cd\n" +
            "LEFT JOIN tb_project c ON b.prj_cd = c.prj_cd\n" +
            "LEFT JOIN tb_consume d ON d.dat_cd = b.dat_cd\n" +
            "LEFT JOIN tb_project e ON e.prj_cd = d.prj_cd\n" +
            "\t  where 1=1   " +
            "<if test = \"file_nm != null and file_nm != ''\">AND a.file_nm like concat('%', #{file_nm},'%')</if>" +
            "    order by a.dt desc</script>")
    Page<TransportLog> selectlogList(@Param("currPage")int currPage,@Param("pageSize") int pageSize,@Param("file_nm") String file_nm);
}
