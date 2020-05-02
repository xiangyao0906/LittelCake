package com.xinly.cake.module.wight

import android.app.Application
import androidx.databinding.ObservableField
import com.xinly.core.binding.command.BindingAction
import com.xinly.core.binding.command.BindingCommand
import com.xinly.core.ext.showAtCenter
import com.xinly.wallet.base.BaseToolBarViewModel
import com.xinly.wallet.util.BigDecimalUtils

class EditTextViewModel(application: Application):BaseToolBarViewModel(application) {
    override fun onCreate() {
        super.onCreate()
        toolBarData.titleText="测试"
    }
    val num by lazy { ObservableField<Double>() }
    val showError by lazy { ObservableField<Boolean>(false) }



    val hahAction:BindingCommand<Nothing> = BindingCommand(object :BindingAction{
        override fun call() {
            showError.set(!showError.get()!!)
        }
    })
}