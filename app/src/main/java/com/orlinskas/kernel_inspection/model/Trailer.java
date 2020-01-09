package com.orlinskas.kernel_inspection.model;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Trailer {
    @NonNull
    private String registrationNumber;
    private List<LockingDevises> lockingDevises;
    private List<Long> arrivalTimesMillis;

    Trailer(@NotNull String registrationNumber, List<LockingDevises> lockingDevises, List<Long> arrivalTimesMillis) {
        this.registrationNumber = registrationNumber;
        this.lockingDevises = lockingDevises;
        this.arrivalTimesMillis = arrivalTimesMillis;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public List<LockingDevises> getLockingDevises() {
        return lockingDevises;
    }

    public List<Long> getArrivalTimesMillis() {
        return arrivalTimesMillis;
    }
}
