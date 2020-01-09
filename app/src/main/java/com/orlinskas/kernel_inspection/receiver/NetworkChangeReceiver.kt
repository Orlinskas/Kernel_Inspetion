package com.orlinskas.kernel_inspection.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import com.orlinskas.kernel_inspection.enums.ConnectionStatus

class NetworkChangeReceiver(private val util: NetworkUtil,
                            private val connectionStatusData:
                            MutableLiveData<Enum<ConnectionStatus>>) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE" == intent.action) {
            val status = util.getConnectivityStatus()
            connectionStatusData.postValue(status)
        }
    }
}