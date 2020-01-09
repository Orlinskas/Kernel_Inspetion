package com.orlinskas.kernel_inspection.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Card {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @NonNull
    private Vehicle vehicle;
    @NonNull
    private Trailer trailer;
    @NonNull
    private Driver driver;

    public Card(@NotNull Vehicle vehicle, @NotNull Trailer trailer, @NotNull Driver driver) {
        this.vehicle = vehicle;
        this.trailer = trailer;
        this.driver = driver;
    }

    @NotNull
    public Vehicle getVehicle() {
        return vehicle;
    }

    @NotNull
    public Trailer getTrailer() {
        return trailer;
    }

    @NotNull
    public Driver getDriver() {
        return driver;
    }

    public long getId() {
        return id;
    }
}
