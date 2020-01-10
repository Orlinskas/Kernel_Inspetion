package com.orlinskas.kernel_inspection.database;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.orlinskas.kernel_inspection.mvvm.model.Card;

import java.sql.SQLException;
import java.util.Collection;

public class CardDao extends BaseDaoImpl<Card, Integer> {

    protected CardDao(ConnectionSource connectionSource, Class<Card> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public Collection<Card> getAllCards() throws SQLException{
        return this.queryForAll();
    }
}
