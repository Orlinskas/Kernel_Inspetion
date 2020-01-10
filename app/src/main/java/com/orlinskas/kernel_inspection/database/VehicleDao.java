package com.orlinskas.kernel_inspection.database;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.orlinskas.kernel_inspection.mvvm.model.Vehicle;

import java.sql.SQLException;
import java.util.Collection;

public class VehicleDao extends BaseDaoImpl<Vehicle, Integer> {

    VehicleDao(ConnectionSource connectionSource, Class<Vehicle> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public Collection<Vehicle> getAllVehicles() throws SQLException{
        return this.queryForAll();
    }

    public Vehicle findFrom(int id) throws SQLException {
        return this.queryForId(id);
    }
}
