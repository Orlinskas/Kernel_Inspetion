package com.orlinskas.kernel_inspection.mvvm.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

@DatabaseTable
public class Trailer {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(unique = true, canBeNull = false)
    private String registrationNumber;
    @ForeignCollectionField(eager = true)
    private Collection<LockingDevise> lockingDevises;

    public Trailer() {
    }

    public Trailer(String registrationNumber, Collection<LockingDevise> lockingDevises) {
        this.registrationNumber = registrationNumber;
        this.lockingDevises = lockingDevises;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Collection<LockingDevise> getLockingDevises() {
        return lockingDevises;
    }

    public int getId() {
        return id;
    }
}
