package com.orlinskas.kernel_inspection.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.orlinskas.kernel_inspection.mvvm.model.Vehicle;

import java.util.List;

@Dao
public interface VehicleDao {
    @Query("SELECT * FROM driver WHERE id == :id")
    Vehicle find(long id);

    @Query("SELECT * FROM vehicle")
    List<Vehicle> findAll();

    @Insert
    void insert(Vehicle vehicle);

    @Delete
    void delete(Vehicle vehicle);

    @Update
    void update(Vehicle vehicle);
}
