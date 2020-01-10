package com.orlinskas.kernel_inspection.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.orlinskas.kernel_inspection.mvvm.model.Card;
import com.orlinskas.kernel_inspection.mvvm.model.Driver;
import com.orlinskas.kernel_inspection.mvvm.model.Vehicle;

import java.sql.SQLException;

public class Database extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME ="kernel_database.db";
    private static final int DATABASE_VERSION = 1;

    private CardDao cardDao = null;
    private VehicleDao vehicleDao = null;
    private DriverDao driverDao = null;

    public Database(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource){
        try
        {
            TableUtils.createTable(connectionSource, CardDao.class);
            TableUtils.createTable(connectionSource, VehicleDao.class);
            TableUtils.createTable(connectionSource, DriverDao.class);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer, int newVer){
        try{
            TableUtils.dropTable(connectionSource, CardDao.class, true);
            TableUtils.dropTable(connectionSource, VehicleDao.class, true);
            TableUtils.dropTable(connectionSource, DriverDao.class, true);
            onCreate(db, connectionSource);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public CardDao getCardDAO() throws SQLException {
        if(cardDao == null) {
            cardDao = new CardDao(getConnectionSource(), Card.class);
        }
        return cardDao;
    }

    public VehicleDao getVehicleDAO() throws SQLException {
        if(vehicleDao == null) {
            vehicleDao = new VehicleDao(getConnectionSource(), Vehicle.class);
        }
        return vehicleDao;
    }

    public DriverDao getDriverDao() throws SQLException {
        if(driverDao == null) {
            driverDao = new DriverDao(getConnectionSource(), Driver.class);
        }
        return driverDao;
    }

    @Override
    public void close(){
        super.close();
        cardDao = null;
        vehicleDao = null;
        driverDao = null;
    }
}
