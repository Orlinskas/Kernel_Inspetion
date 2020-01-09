package com.orlinskas.kernel_inspection.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import com.orlinskas.kernel_inspection.enums.ConnectionStatus

class NetworkChangeReceiver(private val connectionStatusData:
                            MutableLiveData<Enum<ConnectionStatus>>) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE" == intent.action) {
            val status = getConnectivityStatus(context)
            connectionStatusData.postValue(status)
        }
    }

    private fun getConnectivityStatus(context: Context): Enum<ConnectionStatus> {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        if (null != activeNetwork) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI || activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
                return ConnectionStatus.CONNECT_DONE
        }
        return ConnectionStatus.CONNECT_FALT
    }
}