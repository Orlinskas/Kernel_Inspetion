package com.orlinskas.kernel_inspection.mvvm.vievmodel

import android.content.Context
import android.content.IntentFilter
import androidx.lifecycle.MutableLiveData
import com.orlinskas.kernel_inspection.enums.ConnectionStatus
import com.orlinskas.kernel_inspection.mvvm.BaseViewModel
import com.orlinskas.kernel_inspection.receiver.NetworkChangeReceiver

public class MainViewModel(private val context: Context): BaseViewModel() {
    val connectionStatuLiveData: MutableLiveData<Enum<ConnectionStatus>> = MutableLiveData()

    init {
        registerReceiver()
    }

    private fun registerReceiver() {
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED")

        context.registerReceiver(NetworkChangeReceiver(connectionStatuLiveData), intentFilter)
    }

    override fun onCleared() {
        super.onCleared()
        context.unregisterReceiver(NetworkChangeReceiver(connectionStatuLiveData))
    }
}