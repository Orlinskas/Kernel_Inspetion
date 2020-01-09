package com.orlinskas.kernel_inspection.model;

import com.orlinskas.kernel_inspection.enums.LockingDevisesStatus;

public class LockingDevises {
    private String checkMark;
    private String carrier;
    private Enum<LockingDevisesStatus> status;

    public LockingDevises(String checkMark, String carrier, Enum<LockingDevisesStatus> status) {
        this.checkMark = checkMark;
        this.carrier = carrier;
        this.status = status;
    }

    public String getCheckMark() {
        return checkMark;
    }

    public String getCarrier() {
        return carrier;
    }

    public Enum<LockingDevisesStatus> getStatus() {
        return status;
    }
}
