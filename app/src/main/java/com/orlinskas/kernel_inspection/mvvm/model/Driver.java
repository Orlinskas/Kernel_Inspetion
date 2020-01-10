package com.orlinskas.kernel_inspection.mvvm.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "drivers")
public class Driver {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String photoUrl;
    @DatabaseField
    private String firstName;
    @DatabaseField
    private String lastName;
    @DatabaseField(canBeNull = false, unique = true)
    private long personalCode;

    public Driver() {
    }

    public Driver(String firstName, String lastName, String photoUrl, long personalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoUrl = photoUrl;
        this.personalCode = personalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPersonalCode() {
        return personalCode;
    }

    public int getId() {
        return id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
