package com.orlinskas.kernel_inspection.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.orlinskas.kernel_inspection.mvvm.model.Card;
import com.orlinskas.kernel_inspection.mvvm.model.Driver;
import com.orlinskas.kernel_inspection.mvvm.model.LockingDevise;
import com.orlinskas.kernel_inspection.mvvm.model.Trailer;
import com.orlinskas.kernel_inspection.mvvm.model.Vehicle;

import java.sql.SQLException;

public class Database extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME ="kernel_database.db";
    private static final int DATABASE_VERSION = 1;

    private CardDao cardDao = null;
    private VehicleDao vehicleDao = null;
    private DriverDao driverDao = null;
    private LockingDevisesDao lockingDevisesDao = null;
    private TrailerDao trailerDao = null;

    public Database(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource){
        try
        {
            TableUtils.createTable(connectionSource, LockingDevise.class);
            TableUtils.createTable(connectionSource, Trailer.class);
            TableUtils.createTable(connectionSource, Driver.class);
            TableUtils.createTable(connectionSource, Vehicle.class);
            TableUtils.createTable(connectionSource, Card.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer, int newVer){
        try{
            TableUtils.dropTable(connectionSource, LockingDevise.class, true);
            TableUtils.dropTable(connectionSource, Trailer.class, true);
            TableUtils.dropTable(connectionSource, Driver.class, true);
            TableUtils.dropTable(connectionSource, Vehicle.class, true);
            TableUtils.dropTable(connectionSource, Card.class, true);
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

    public LockingDevisesDao getLockingDevisesDao() throws SQLException {
        if(lockingDevisesDao == null) {
            lockingDevisesDao = new LockingDevisesDao(getConnectionSource(), LockingDevise.class);
        }
        return lockingDevisesDao;
    }

    public TrailerDao getTrailerDao() throws SQLException {
        if(trailerDao == null) {
            trailerDao = new TrailerDao(getConnectionSource(), Trailer.class);
        }
        return trailerDao;
    }

    @Override
    public void close(){
        super.close();
        cardDao = null;
        vehicleDao = null;
        driverDao = null;
        lockingDevisesDao = null;
        trailerDao = null;
    }
}
