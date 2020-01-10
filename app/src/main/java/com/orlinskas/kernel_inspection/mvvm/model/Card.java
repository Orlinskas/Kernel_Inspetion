package com.orlinskas.kernel_inspection.mvvm.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "cards")
public class Card {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true)
    private Vehicle vehicle;
    @DatabaseField(foreign = true)
    private Trailer trailer;
    @DatabaseField(foreign = true)
    private Driver driver;

    public Card() {
    }

    public Card(Vehicle vehicle, Trailer trailer, Driver driver) {
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

    public int getId() {
        return id;
    }
}
