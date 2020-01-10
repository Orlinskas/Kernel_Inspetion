package com.orlinskas.kernel_inspection.mvvm.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

@DatabaseTable(tableName = "vehicles")
public class Vehicle {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String manufacturer;
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Trailer trailer;
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Driver driver;
    @DatabaseField(canBeNull = false, unique = true)
    private String registrationNumber;

    public Vehicle() {
    }

    public Vehicle(String manufacturer, Trailer trailer, Driver driver, String registrationNumber, Collection<Long> arrivalTimeMillis) {
        this.manufacturer = manufacturer;
        this.trailer = trailer;
        this.driver = driver;
        this.registrationNumber = registrationNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public int getId() {
        return id;
    }
}
