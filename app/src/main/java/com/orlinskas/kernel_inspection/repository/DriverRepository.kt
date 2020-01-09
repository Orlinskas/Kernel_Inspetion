package com.orlinskas.kernel_inspection.repository

import com.orlinskas.kernel_inspection.database.DriverDatabase
import com.orlinskas.kernel_inspection.model.Driver

class DriverRepository (private val database: DriverDatabase) {

    fun find(id: Long): Driver {
        return database.driverDao().find(id)
    }

    fun findAll(): List<Driver> {
        return database.driverDao().findAll()
    }

    fun insert(driver: Driver) {
        database.driverDao().insert(driver)
    }

    fun update(driver: Driver) {
        database.driverDao().update(driver)
    }

    fun delete(driver: Driver) {
        database.driverDao().delete(driver)
    }
}