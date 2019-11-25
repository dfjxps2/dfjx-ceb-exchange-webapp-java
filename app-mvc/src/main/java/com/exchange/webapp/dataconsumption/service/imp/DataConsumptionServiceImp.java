package com.exchange.webapp.dataconsumption.service.imp;

import com.exchange.webapp.contact.service.imp.ContactServiceImp;
import com.exchange.webapp.dataconsumption.dao.DataConsumptionDao;
import com.exchange.webapp.dataconsumption.service.DataConsumptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("dataConsumptionService")
public class DataConsumptionServiceImp implements DataConsumptionService {

    private Logger logger = LoggerFactory.getLogger(DataConsumptionServiceImp.class);

    @Autowired
    private DataConsumptionDao dataConsumptionDao;


    @Override
    public void delpageContact(String user_id) {
        dataConsumptionDao.delpageContact(user_id);
    }
}
