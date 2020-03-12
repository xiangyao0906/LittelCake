package com.xinly.cake.module.main

import android.app.Application
import com.xinly.cake.module.video.VideoDetailsActivity
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
}