package com.orlinskas.kernel_inspection.iteractor

import com.orlinskas.kernel_inspection.exeption.Failure
import com.orlinskas.kernel_inspection.functional.Either
import com.orlinskas.kernel_inspection.model.Card
import com.orlinskas.kernel_inspection.model.Driver
import com.orlinskas.kernel_inspection.model.Trailer
import com.orlinskas.kernel_inspection.model.Vehicle
import com.orlinskas.kernel_inspection.repository.CardRepository

class CreateCardUseCase(private val repository: CardRepository): BaseUseCase<Card, CreateCardUseCase.CreateCardData>() {

    data class CreateCardData(val vehicle: Vehicle, val driver: Driver, val trailer: Trailer)

    override suspend fun run(params: CreateCardData): Either<Failure, Card> {
        val card = Card(params.vehicle, params.trailer, params.driver)

        try {
            repository.insert(card)
            val insertCard = try {
                repository.find(card.id)
            } catch (e: Exception) {
                return Either.Left(Failure(0, e.message.toString()))
            }
            return Either.Right(insertCard)
        } catch (e: Exception) {
            return Either.Left(Failure(0, e.message.toString()))
        }
    }
}