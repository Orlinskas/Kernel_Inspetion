package com.orlinskas.kernel_inspection.database;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.orlinskas.kernel_inspection.mvvm.model.Trailer;

import java.sql.SQLException;
import java.util.Collection;

public class TrailerDao extends BaseDaoImpl<Trailer, Integer> {

    TrailerDao(ConnectionSource connectionSource, Class<Trailer> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public Collection<Trailer> getAllCards() throws SQLException{
        return this.queryForAll();
    }

    public Trailer findFrom(int id) throws SQLException {
        return this.queryForId(id);
    }
}