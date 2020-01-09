package com.orlinskas.kernel_inspection.repository

import com.orlinskas.kernel_inspection.database.VehicleDatabase
import com.orlinskas.kernel_inspection.mvvm.model.Vehicle

class VehicleRepository(private val database: VehicleDatabase) {

    fun find(id: Long): Vehicle {
        return database.vehicleDao().find(id)
    }

    fun findAll(): List<Vehicle> {
        return database.vehicleDao().findAll()
    }

    fun insert(vehicle: Vehicle) {
        database.vehicleDao().insert(vehicle)
    }

    fun update(vehicle: Vehicle) {
        database.vehicleDao().update(vehicle)
    }

    fun delete(vehicle: Vehicle) {
        database.vehicleDao().delete(vehicle)
    }
}