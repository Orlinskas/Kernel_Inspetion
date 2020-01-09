package com.orlinskas.kernel_inspection

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.orlinskas.kernel_inspection.database.CardDatabase
import com.orlinskas.kernel_inspection.database.DriverDatabase
import com.orlinskas.kernel_inspection.database.VehicleDatabase
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

        single { provideVehicleDatabase(applicationContext) }
        single { provideDriverDatabase(applicationContext) }
        single { provideCardDatabase(applicationContext) }

    }

    private fun provideVehicleDatabase(context: Context): VehicleDatabase {
        return Room.databaseBuilder(context, VehicleDatabase::class.java, "vehicles").build()
    }

    private fun provideDriverDatabase(context: Context): DriverDatabase {
        return Room.databaseBuilder(context, DriverDatabase::class.java, "drivers").build()
    }

    private fun provideCardDatabase(context: Context): CardDatabase {
        return Room.databaseBuilder(context, CardDatabase::class.java, "cards").build()
    }
}