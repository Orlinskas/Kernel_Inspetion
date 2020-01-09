package com.orlinskas.kernel_inspection.mvvm.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.orlinskas.kernel_inspection.mvvm.vievmodel.Trailer;

import java.util.List;

@Entity
public class Vehicle {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String manufacturer;
    private Trailer trailer;
    private Driver driver;
    private String registrationNumber;
    private List<Long> arrivalTimeMillis;

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

    public long getId() {
        return id;
    }
}
