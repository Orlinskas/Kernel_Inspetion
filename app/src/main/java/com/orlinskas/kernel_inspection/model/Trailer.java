package com.orlinskas.kernel_inspection.model;

import androidx.room.Entity;

import java.util.List;

@Entity
class Trailer {
    private String registrationNumber;
    private List<LockingDevises> lockingDevises;
    private List<Long> arrivalTimesMillis;


}
