package com.xinly.cake.module.video.openeyes.main

import android.app.Application
import android.util.Log
import com.xinly.cake.api.OpenApi
import com.xinly.cake.component.net.XinlyRxSubscriberHelper
import com.xinly.cake.model.vo.bean.HotStraetgyEntity
import com.xinly.cake.model.vo.result.ListData
import com.xinly.core.binding.command.BindingAction
import com.xinly.core.binding.command.BindingCommand
import com.xinly.core.viewmodel.BaseViewModel

class OpenEyesViewModel(application: Application):BaseViewModel(application) {


    //event

    val request=BindingCommand<Nothing>(object :BindingAction{
        override fun call() {
            getHomeData()
        }
    })


    fun getHomeData(){

        OpenApi()
            .getHomeData(object :XinlyRxSubscriberHelper<HotStraetgyEntity>(){
                override fun _onNext(t: HotStraetgyEntity) {


                    t.itemList[0].data.itemList[0].type


                }
            },lifecycleProvider)


    }
}