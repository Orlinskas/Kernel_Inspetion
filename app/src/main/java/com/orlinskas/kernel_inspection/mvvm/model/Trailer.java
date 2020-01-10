package com.orlinskas.kernel_inspection.mvvm.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

@DatabaseTable(tableName = "trailers")
public class Trailer {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(unique = true, canBeNull = false)
    private String registrationNumber;
    @ForeignCollectionField
    private Collection<LockingDevises> lockingDevises;
    @ForeignCollectionField
    private Collection<Long> arrivalTimesMillis;

    public Trailer() {
    }

    public Trailer(String registrationNumber, Collection<LockingDevises> lockingDevises, Collection<Long> arrivalTimesMillis) {
        this.registrationNumber = registrationNumber;
        this.lockingDevises = lockingDevises;
        this.arrivalTimesMillis = arrivalTimesMillis;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Collection<LockingDevises> getLockingDevises() {
        return lockingDevises;
    }

    public Collection<Long> getArrivalTimesMillis() {
        return arrivalTimesMillis;
    }

    public int getId() {
        return id;
    }
}
