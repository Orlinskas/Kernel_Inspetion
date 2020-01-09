package com.orlinskas.kernel_inspection.mvvm.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.orlinskas.kernel_inspection.R
import com.orlinskas.kernel_inspection.enums.ConnectionStatus
import com.orlinskas.kernel_inspection.mvvm.vievmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel


public class MainView: AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.connectionStatuLiveData.observe(this, Observer {
            when(it) {
                ConnectionStatus.CONNECT_DONE -> setIconOn()
                ConnectionStatus.CONNECT_FALT -> setIconOff()
            }
        })



    }

    private fun setIconOff() {
        activity_main_iv_connection_status_off.visibility = View.VISIBLE
        activity_main_iv_connection_status_on.visibility = View.INVISIBLE
    }

    private fun setIconOn() {
        activity_main_iv_connection_status_off.visibility = View.INVISIBLE
        activity_main_iv_connection_status_on.visibility = View.VISIBLE
    }
}