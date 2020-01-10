package com.orlinskas.kernel_inspection.mvvm.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.orlinskas.kernel_inspection.enums.LockingDevisesStatus;

@DatabaseTable
public class LockingDevise {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String checkMark;
    @DatabaseField
    private String carrier;
    @DatabaseField
    private LockingDevisesStatus status;
    @DatabaseField(foreign = true)
    protected Trailer trailer;

    public LockingDevise() {
    }

    public LockingDevise(String checkMark, String carrier, LockingDevisesStatus status) {
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

    public LockingDevisesStatus getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
}
