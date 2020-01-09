package com.orlinskas.kernel_inspection.repository

import com.orlinskas.kernel_inspection.database.CardDatabase
import com.orlinskas.kernel_inspection.mvvm.model.Card

class CardRepository(private val database: CardDatabase) {

    fun find(id: Long): Card {
        return database.waitingCardDao().find(id)
    }

    fun findAll(): List<Card> {
        return database.waitingCardDao().findAll()
    }

    fun insert(card: Card) {
        database.waitingCardDao().insert(card)
    }

    fun update(card: Card) {
        database.waitingCardDao().update(card)
    }

    fun delete(card: Card) {
        database.waitingCardDao().delete(card)
    }
}