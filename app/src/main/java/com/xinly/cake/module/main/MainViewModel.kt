package com.xinly.cake.module.main

import android.app.Application
import com.xinly.cake.module.record.RecordActivity
import com.xinly.cake.module.video.VideoDetailsActivity
import com.xinly.cake.module.video.openeyes.main.OpenEyesActivity
import com.xinly.cake.module.wight.EditTextActivity
import com.xinly.core.binding.command.BindingAction
import com.xinly.core.binding.command.BindingCommand
import com.xinly.core.viewmodel.BaseViewModel

class MainViewModel(application: Application):BaseViewModel(application) {

    //event
    val videoLangch = BindingCommand<Nothing>(object :BindingAction{
        override fun call() {
            startActivity(VideoDetailsActivity::class.java)
        }
    })

    val openEyesLangch = BindingCommand<Nothing>(object :BindingAction{
        override fun call() {
            startActivity(OpenEyesActivity::class.java)
        }
    })

    val recordLangch = BindingCommand<Nothing>(object :BindingAction{
        override fun call() {
            startActivity(RecordActivity::class.java)
        }
    })
    val editeLangch = BindingCommand<Nothing>(object :BindingAction{
        override fun call() {
            startActivity(EditTextActivity::class.java)
        }
    })
}