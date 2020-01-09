package com.orlinskas.kernel_inspection.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.orlinskas.kernel_inspection.model.WaitingCard;

;import java.util.List;

@Dao
public interface WaitingCardDao {
    @Query("SELECT * FROM driver WHERE id == :id")
    WaitingCard find(long id);

    @Query("SELECT * FROM waitingcard")
    List<WaitingCard> findAll();

    @Insert
    void insert(WaitingCard waitingCard);

    @Delete
    void delete(WaitingCard waitingCard);

    @Update
    void update(WaitingCard waitingCard);
}
