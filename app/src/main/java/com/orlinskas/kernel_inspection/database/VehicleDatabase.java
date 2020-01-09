package com.orlinskas.kernel_inspection.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.orlinskas.kernel_inspection.mvvm.vievmodel.Vehicle;

@Database(entities = {Vehicle.class}, version = 1, exportSchema = false)
public abstract class VehicleDatabase extends RoomDatabase {
    public abstract VehicleDao vehicleDao();
}
