package com.orlinskas.kernel_inspection.repository

import com.orlinskas.kernel_inspection.database.Database
import com.orlinskas.kernel_inspection.mvvm.model.Vehicle

class VehicleRepository(private val database: Database) {

    fun find(id: Int): Vehicle {
        return database.vehicleDAO.findFrom(id)
    }

    fun findAll(): Collection<Vehicle> {
        return database.vehicleDAO.allVehicles
    }

    fun insert(vehicle: Vehicle) {
        database.vehicleDAO.create(vehicle)
    }

    fun update(vehicle: Vehicle) {
        database.vehicleDAO.update(vehicle)
    }

    fun delete(vehicle: Vehicle) {
        database.vehicleDAO.delete(vehicle)
    }
}