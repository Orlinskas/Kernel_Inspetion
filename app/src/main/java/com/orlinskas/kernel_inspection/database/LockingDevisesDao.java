package com.orlinskas.kernel_inspection.database;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.orlinskas.kernel_inspection.mvvm.model.LockingDevise;

import java.sql.SQLException;
import java.util.Collection;

public class LockingDevisesDao extends BaseDaoImpl<LockingDevise, Integer> {

    LockingDevisesDao(ConnectionSource connectionSource, Class<LockingDevise> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public Collection<LockingDevise> getAllCards() throws SQLException{
        return this.queryForAll();
    }

    public LockingDevise findFrom(int id) throws SQLException {
        return this.queryForId(id);
    }
}