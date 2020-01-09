package com.orlinskas.kernel_inspection.iteractor

import com.orlinskas.kernel_inspection.exeption.Failure
import com.orlinskas.kernel_inspection.functional.Either
import kotlinx.coroutines.*

abstract class BaseUseCase<out Type, in Params> where Type: Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        val scope = CoroutineScope(Dispatchers.IO + Job())
        val job = scope.async { run(params) }
        scope.launch(Dispatchers.Main) { onResult(job.await()) }
    }

    class NULL
}