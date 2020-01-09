package com.orlinskas.kernel_inspection.model;

import androidx.room.Entity;

@Entity
public class WaitingCard {
    private Vehicle vehicle;
    private Trailer trailer;
    private Driver driver;

    public WaitingCard(Vehicle vehicle, Trailer trailer, Driver driver) {
        this.vehicle = vehicle;
        this.trailer = trailer;
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public Driver getDriver() {
        return driver;
    }
}
