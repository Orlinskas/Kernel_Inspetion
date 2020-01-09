package com.orlinskas.kernel_inspection.model;

class LockingDevises {
    private String checkMark;
    private String carrier;
    private boolean status;

    public LockingDevises(String checkMark, String carrier, boolean status) {
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

    public boolean isStatus() {
        return status;
    }
}
