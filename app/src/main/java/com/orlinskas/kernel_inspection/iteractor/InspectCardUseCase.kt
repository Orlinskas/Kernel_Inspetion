package com.orlinskas.kernel_inspection.iteractor

import com.orlinskas.kernel_inspection.exeption.Failure
import com.orlinskas.kernel_inspection.functional.Either
import com.orlinskas.kernel_inspection.functional.InspectResult
import com.orlinskas.kernel_inspection.mvvm.model.Card

public class InspectCardUseCase: BaseUseCase<InspectResult, Card>() {

    override suspend fun run(params: Card): Either<Failure, InspectResult> {
        return Either.Right(InspectResult(params.trailer.lockingDevises))
    }
}