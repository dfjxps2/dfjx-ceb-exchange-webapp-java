package com.exchange.webapp.dataconsumption.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface DataConsumptionDao {

    @Delete("")
    void delpageContact(@Param("USER_ID") String user_id);
}
