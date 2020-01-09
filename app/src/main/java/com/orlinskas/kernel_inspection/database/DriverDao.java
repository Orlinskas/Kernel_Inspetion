package com.orlinskas.kernel_inspection.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.orlinskas.kernel_inspection.model.Driver;

import java.util.List;

@Dao
public interface DriverDao {
    @Query("SELECT * FROM driver WHERE id == :id")
    Driver find(long id);

    @Query("SELECT * FROM driver")
    List<Driver> findAll();

    @Insert
    void insert(Driver driver);

    @Delete
    void delete(Driver driver);

    @Update
    void update(Driver driver);
}