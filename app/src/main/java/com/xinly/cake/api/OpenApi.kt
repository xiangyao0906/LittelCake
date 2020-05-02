package com.xinly.cake.api

import com.trello.rxlifecycle3.LifecycleProvider
import com.xinly.cake.component.data.QueryMapHelper
import com.xinly.cake.component.net.XinlyRequestManager
import com.xinly.cake.component.net.XinlyRxSubscriberHelper
import com.xinly.cake.model.constans.UrlConstans
import com.xinly.cake.model.vo.bean.HotStraetgyEntity
import com.xinly.core.ext.execute
import com.xinly.core.ext.withOutCode
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

class OpenApi {

    private val api: Api

    init {
        api = XinlyRequestManager.getRequest(Api::class.java)
    }

    private interface Api {

        @GET(UrlConstans.HOME_DATA)
        fun getHomeData(@QueryMap map: Map<String, String>): Observable<HotStraetgyEntity>
    }


    fun getHomeData(
        subscriberHelper: XinlyRxSubscriberHelper<HotStraetgyEntity>,
        lifecycleProvider: LifecycleProvider<*>
    ) {
        api
            .getHomeData(QueryMapHelper.homeQueryMap())
            .withOutCode().execute(subscriberHelper, lifecycleProvider)

    }

}