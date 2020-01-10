package com.orlinskas.kernel_inspection.repository

import com.orlinskas.kernel_inspection.database.Database
import com.orlinskas.kernel_inspection.mvvm.model.Card

class CardRepository(private val database: Database) {

    fun find(id: Int): Card {
        return database.cardDAO.findFrom(id)
    }

    fun findAll(): Collection<Card> {
        return database.cardDAO.allCards
    }

    fun insert(card: Card) {
        database.cardDAO.create(card)
    }

    fun update(card: Card) {
        database.cardDAO.update(card)
    }

    fun delete(card: Card) {
        database.cardDAO.delete(card)
    }
}