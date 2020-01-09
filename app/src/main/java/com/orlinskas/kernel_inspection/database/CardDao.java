package com.orlinskas.kernel_inspection.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.orlinskas.kernel_inspection.model.Card;

;import java.util.List;

@Dao
public interface CardDao {
    @Query("SELECT * FROM driver WHERE id == :id")
    Card find(long id);

    @Query("SELECT * FROM Card")
    List<Card> findAll();

    @Insert
    void insert(Card card);

    @Delete
    void delete(Card card);

    @Update
    void update(Card card);
}
