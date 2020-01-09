package com.orlinskas.kernel_inspection.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.orlinskas.kernel_inspection.model.Card;

@Database(entities = Card.class, version = 1, exportSchema = false)
public abstract class CardDatabase extends RoomDatabase {
    public abstract CardDao waitingCardDao();
}
