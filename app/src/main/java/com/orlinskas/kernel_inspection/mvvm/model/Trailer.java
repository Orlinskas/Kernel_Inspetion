package com.orlinskas.kernel_inspection.mvvm.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = "trailers")
public class Trailer {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(unique = true, canBeNull = false)
    private String registrationNumber;
    @DatabaseField(foreign = true)
    private List<LockingDevises> lockingDevises;
    @DatabaseField(foreign = true)
    private List<Long> arrivalTimesMillis;

    public Trailer() {
    }

    public Trailer(String registrationNumber, List<LockingDevises> lockingDevises, List<Long> arrivalTimesMillis) {
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

    public int getId() {
        return id;
    }
}
