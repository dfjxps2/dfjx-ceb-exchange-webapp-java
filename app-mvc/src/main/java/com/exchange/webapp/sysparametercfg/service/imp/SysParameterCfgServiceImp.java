package com.exchange.webapp.sysparametercfg.service.imp;

import com.exchange.webapp.contact.service.imp.ContactServiceImp;
import com.exchange.webapp.sysparametercfg.bean.SysParameterCfg;
import com.exchange.webapp.sysparametercfg.dao.SysParameterCfgDao;
import com.exchange.webapp.sysparametercfg.service.SysParameterCfgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysParameterCfgService")
public class SysParameterCfgServiceImp implements SysParameterCfgService {

    private Logger logger = LoggerFactory.getLogger(ContactServiceImp.class);

    @Autowired
    private SysParameterCfgDao sysParameterCfgDao;

    @Override
        public List<SysParameterCfg> parameterse() {
        return sysParameterCfgDao.parameterse();
    }

    @Override
    public void updateparameter(int id, String aes_key, String secret_key, int heart_freq, int file_backup, int tran_timeout, int limit_rate, int log_backup ,int retries) {
         sysParameterCfgDao.updateparameter(id,aes_key,secret_key,heart_freq,file_backup,tran_timeout,limit_rate,log_backup,retries);
    }
}
