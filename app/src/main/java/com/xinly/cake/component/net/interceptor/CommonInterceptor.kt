package com.xinly.pcvd.component.net.interceptor

import com.xinly.cake.model.constans.Constans
import com.xinly.cake.util.PrefsUtils
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by zm on 2019-06-27.
 */
class CommonInterceptor: Interceptor {

    companion object {
        private const val LANGUAGE = "language"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest: Request = chain.request()

        /**
         * 公共参数
         */
        val authorizedUrlBuilder: HttpUrl.Builder = oldRequest.url()
            .newBuilder()
            .scheme(oldRequest.url().scheme())
            .host(oldRequest.url().host())

        /**
         * 新的请求
         */
        val requestBuilder: Request.Builder = oldRequest.newBuilder()
            .method(oldRequest.method(), oldRequest.body())
            .url(authorizedUrlBuilder.build())


        return chain.proceed(requestBuilder.build())
    }

}