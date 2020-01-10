package com.orlinskas.kernel_inspection.iteractor

import com.orlinskas.kernel_inspection.exeption.Failure
import com.orlinskas.kernel_inspection.functional.Either
import com.orlinskas.kernel_inspection.mvvm.model.Card
import com.orlinskas.kernel_inspection.mvvm.model.LockingDevise

public class InspectCardUseCase: BaseUseCase<InspectCardUseCase.InspectResult, Card>() {

    override suspend fun run(params: Card): Either<Failure, InspectResult> {
        return Either.Right(InspectResult(params.vehicle.trailer.lockingDevises))
    }

    data class InspectResult(val devises: Collection<LockingDevise>)
}