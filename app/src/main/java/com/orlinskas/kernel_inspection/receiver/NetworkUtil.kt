package com.orlinskas.kernel_inspection.receiver

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.TYPE_WIFI
import com.orlinskas.kernel_inspection.enums.ConnectionStatus

public class NetworkUtil(private val context: Context) {

    fun getConnectivityStatus(): Enum<ConnectionStatus> {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        if (null != activeNetwork) {
            if (activeNetwork.type == TYPE_WIFI || activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
                return ConnectionStatus.CONNECT_DONE
        }
        return ConnectionStatus.CONNECT_FALT
    }
}