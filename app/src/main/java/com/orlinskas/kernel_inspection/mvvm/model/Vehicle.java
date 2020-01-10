package com.orlinskas.kernel_inspection.mvvm.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = "vehicles")
public class Vehicle {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String manufacturer;
    @DatabaseField(foreign = true)
    private Trailer trailer;
    @DatabaseField(foreign = true)
    private Driver driver;
    @DatabaseField(canBeNull = false, unique = true)
    private String registrationNumber;
    @DatabaseField(foreign = true)
    private List<Long> arrivalTimeMillis;

    public Vehicle() {
    }

    public Vehicle(String manufacturer, Trailer trailer, Driver driver, String registrationNumber, List<Long> arrivalTimeMillis) {
        this.manufacturer = manufacturer;
        this.trailer = trailer;
        this.driver = driver;
        this.registrationNumber = registrationNumber;
        this.arrivalTimeMillis = arrivalTimeMillis;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public List<Long> getArrivalTimeMillis() {
        return arrivalTimeMillis;
    }

    public void setArrivalTimeMillis(List<Long> arrivalTimeMillis) {
        this.arrivalTimeMillis = arrivalTimeMillis;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public int getId() {
        return id;
    }
}
