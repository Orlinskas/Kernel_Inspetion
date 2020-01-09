package com.orlinskas.kernel_inspection.model;

public class Driver {
    private String firstName;
    private String lastName;
    private long personalCode;

    public Driver(String firstName, String lastName, String dob, long personalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
