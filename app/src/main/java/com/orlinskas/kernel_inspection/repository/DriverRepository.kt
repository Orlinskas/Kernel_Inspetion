package com.orlinskas.kernel_inspection.repository

import com.orlinskas.kernel_inspection.database.Database
import com.orlinskas.kernel_inspection.mvvm.model.Driver

class DriverRepository (private val database: Database) {

    fun find(id: Int): Driver {
        return database.driverDao.findFrom(id)
    }

    fun findAll(): Collection<Driver> {
        return database.driverDao.allDrivers
    }

    fun insert(driver: Driver) {
        database.driverDao.create(driver)
    }

    fun update(driver: Driver) {
        database.driverDao.update(driver)
    }

    fun delete(driver: Driver) {
        database.driverDao.delete(driver)
    }
}