package com.orlinskas.kernel_inspection.model;

import androidx.room.Entity;

import java.util.List;

@Entity
class Trailer {
    private String registrationNumber;
    private List<LockingDevises> lockingDevises;
    private List<Long> arrivalTimesMillis;

    Trailer(String registrationNumber, List<LockingDevises> lockingDevises, List<Long> arrivalTimesMillis) {
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
