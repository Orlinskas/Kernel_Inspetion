package com.orlinskas.kernel_inspection.mvvm.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.orlinskas.kernel_inspection.enums.LockingDevisesStatus;

@DatabaseTable(tableName = "locking devises")
public class LockingDevises {
    @DatabaseField
    private String checkMark;
    @DatabaseField
    private String carrier;
    @DatabaseField
    private Enum<LockingDevisesStatus> status;

    public LockingDevises() {
    }

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
