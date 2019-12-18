package com.exchange.webapp.monitor.dao;

import com.exchange.webapp.monitor.bean.Tbagent;
import com.exchange.webapp.monitor.bean.Tbserver;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MmontorDao {

    @Select("SELECT\n" +
            "\ta.agent,\n" +
            "\ta.prj_cd,\n" +
            "\tb.prj_nm,\n" +
            "\ta.ip,\n" +
            "\ta.public_key,\n" +
            "\ta.agent_status,\n" +
            "\ta.sftp_status,\n" +
            "\ta.last_heart,\n" +
            "\ta.version,\n" +
            "\ta.start_time,\n" +
            "\ta.workdir\n" +
            "FROM\n" +
            "\ttb_agent a\n" +
            "LEFT JOIN tb_project b ON a.prj_cd = b.prj_cd")
    Page<Tbagent> selectTbagentList(@Param("currPage") int currPage, @Param("pageSize") int pageSize);

    @Select("SELECT * FROM  tb_server")
    List<Tbserver> tbserverselect();
}
