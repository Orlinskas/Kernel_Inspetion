package com.orlinskas.kernel_inspection.mvvm.vievmodel

import androidx.lifecycle.MutableLiveData
import com.orlinskas.kernel_inspection.exeption.Failure
import com.orlinskas.kernel_inspection.iteractor.BaseUseCase
import com.orlinskas.kernel_inspection.iteractor.FindCardsUseCase
import com.orlinskas.kernel_inspection.mvvm.BaseViewModel
import com.orlinskas.kernel_inspection.mvvm.model.Card

public class CardListViewModel (private val findCardsUseCase: FindCardsUseCase) : BaseViewModel() {

    val cardsLiveData: MutableLiveData<List<Card>> = MutableLiveData()
    val failureLiveData: MutableLiveData<Failure> = this.failure

    fun findCards() {
        findCardsUseCase(params = BaseUseCase.NULL()) {
            it.either(::handleFindFailure, ::handleFindSuccess)
        }
    }

    private fun handleFindSuccess(list: List<Card>) {
        cardsLiveData.postValue(list)
    }

    private fun handleFindFailure(failure: Failure) {
        this.failureLiveData.postValue(failure)
    }

}