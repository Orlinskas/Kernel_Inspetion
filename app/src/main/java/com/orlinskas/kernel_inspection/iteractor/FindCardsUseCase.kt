package com.orlinskas.kernel_inspection.iteractor

import com.orlinskas.kernel_inspection.exeption.Failure
import com.orlinskas.kernel_inspection.functional.Either
import com.orlinskas.kernel_inspection.mvvm.model.Card
import com.orlinskas.kernel_inspection.repository.CardRepository

public class FindCardsUseCase(private val repository: CardRepository): BaseUseCase<Collection<Card>, BaseUseCase.NULL>() {

    override suspend fun run(params: NULL): Either<Failure, Collection<Card>> {
        return try {
            val data = repository.findAll()
            Either.Right(data)
        } catch (e: Exception) {
            Either.Left(Failure(0, e.message.toString()))
        }
    }
}