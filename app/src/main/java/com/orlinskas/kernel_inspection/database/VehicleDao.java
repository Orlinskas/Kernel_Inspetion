package com.orlinskas.kernel_inspection.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.orlinskas.kernel_inspection.model.Vehicle;
import com.orlinskas.notebook.mvvm.model.Notification;

import java.util.List;

@Dao
public interface VehicleDao {
    @Query("SELECT * FROM vehicle")
    List<Vehicle> findAll();

    @Query("SELECT * FROM notification WHERE start_date_millis > :currentDateMillis AND deleted_at IS 0")
    List<Notification> findActual(long currentDateMillis);

    @Insert
    void insertAll(Notification... notifications);

    @Delete
    void delete(Notification notification);

    @Update
    void update(Notification notification);
}
