package com.exchange.webapp.sysparametercfg.dao;

import com.exchange.webapp.sysparametercfg.bean.SysParameterCfg;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysParameterCfgDao {

    @Select("SELECT * FROM  tb_config")
    List<SysParameterCfg> parameterse();


    @Update("UPDATE tb_config SET  aes_key =#{aes_key},secret_key=#{secret_key},heart_freq=#{heart_freq},file_backup=#{file_backup},tran_timeout=#{tran_timeout},limit_rate=#{limit_rate},log_backup =#{log_backup},retries =#{retries} WHERE id =#{id}")
    void updateparameter(@Param("id") int id,@Param("aes_key")  String aes_key, @Param("secret_key") String secret_key, @Param("heart_freq") int heart_freq,@Param("file_backup")  int file_backup, @Param("tran_timeout") int tran_timeout,@Param("limit_rate")  int limit_rate,@Param("log_backup") int log_backup,@Param("retries")  int retries);
}
