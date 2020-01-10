package com.orlinskas.kernel_inspection

import android.app.Application
import android.content.Context
import com.j256.ormlite.android.apptools.OpenHelperManager
import com.orlinskas.kernel_inspection.database.Database
import com.orlinskas.kernel_inspection.iteractor.CreateCardUseCase
import com.orlinskas.kernel_inspection.iteractor.FindCardsUseCase
import com.orlinskas.kernel_inspection.iteractor.InspectCardUseCase
import com.orlinskas.kernel_inspection.mvvm.vievmodel.CardListViewModel
import com.orlinskas.kernel_inspection.mvvm.vievmodel.MainViewModel
import com.orlinskas.kernel_inspection.repository.CardRepository
import com.orlinskas.kernel_inspection.repository.DriverRepository
import com.orlinskas.kernel_inspection.repository.VehicleRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(mainModule))
        }

    }

    private val mainModule = module {
        viewModel { MainViewModel(applicationContext) }
        viewModel { CardListViewModel(get()) }

        single { CreateCardUseCase(get()) }
        single { FindCardsUseCase(get()) }
        single { InspectCardUseCase() }

        single { VehicleRepository(get()) }
        single { DriverRepository(get()) }
        single { CardRepository(get()) }

        single { provideDatabase(applicationContext) }
    }

    private fun provideDatabase(context: Context): Database {
        return OpenHelperManager.getHelper(context, Database::class.java)
    }
}