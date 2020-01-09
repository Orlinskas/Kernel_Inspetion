package com.orlinskas.kernel_inspection.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Driver {
    @PrimaryKey
    private long id;
    private String photoUrl;
    private String firstName;
    private String lastName;
    private long personalCode;

    public Driver(String firstName, String lastName, String dob, String photoUrl, long personalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoUrl = photoUrl;
        this.id = id;
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

    public long getId() {
        return id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
