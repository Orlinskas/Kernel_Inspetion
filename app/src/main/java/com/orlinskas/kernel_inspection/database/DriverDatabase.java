package com.orlinskas.kernel_inspection.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.orlinskas.kernel_inspection.mvvm.model.Driver;

@Database(entities = {Driver.class}, version = 1, exportSchema = false)
public abstract class DriverDatabase extends RoomDatabase {
    public abstract DriverDao driverDao();
}
