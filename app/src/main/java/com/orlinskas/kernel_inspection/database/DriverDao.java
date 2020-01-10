package com.orlinskas.kernel_inspection.database;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.orlinskas.kernel_inspection.mvvm.model.Driver;

import java.sql.SQLException;
import java.util.Collection;

public class DriverDao extends BaseDaoImpl<Driver, Integer> {

    DriverDao(ConnectionSource connectionSource, Class<Driver> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public Collection<Driver> getAllDrivers() throws SQLException{
        return this.queryForAll();
    }

    public Driver findFrom(int id) throws SQLException {
        return this.queryForId(id);
    }
}