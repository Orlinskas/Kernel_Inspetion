package com.orlinskas.kernel_inspection.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.orlinskas.kernel_inspection.model.WaitingCard;

@Database(entities = WaitingCard.class, version = 1, exportSchema = false)
public abstract class WaitingCardDatabase extends RoomDatabase {
    public abstract WaitingCardDao waitingCardDao();
}
