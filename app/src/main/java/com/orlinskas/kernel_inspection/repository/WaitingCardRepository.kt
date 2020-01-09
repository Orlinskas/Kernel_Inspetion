package com.orlinskas.kernel_inspection.repository

import com.orlinskas.kernel_inspection.database.WaitingCardDatabase
import com.orlinskas.kernel_inspection.model.WaitingCard

class WaitingCardRepository(private val database: WaitingCardDatabase) {

    fun find(id: Long): WaitingCard {
        return database.waitingCardDao().find(id)
    }

    fun findAll(): List<WaitingCard> {
        return database.waitingCardDao().findAll()
    }

    fun insert(waitingCard: WaitingCard) {
        database.waitingCardDao().insert(waitingCard)
    }

    fun update(waitingCard: WaitingCard) {
        database.waitingCardDao().update(waitingCard)
    }

    fun delete(waitingCard: WaitingCard) {
        database.waitingCardDao().delete(waitingCard)
    }
}