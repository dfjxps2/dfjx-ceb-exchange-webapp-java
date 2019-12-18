package com.exchange.webapp.sysparametercfg.service;

import com.exchange.webapp.sysparametercfg.bean.SysParameterCfg;

import java.util.List;

public interface SysParameterCfgService {
    List<SysParameterCfg> parameterse();

    void updateparameter(int id, String aes_key, String secret_key, int heart_freq, int file_backup, int tran_timeout, int limit_rate, int  log_backup,int retries);
}
