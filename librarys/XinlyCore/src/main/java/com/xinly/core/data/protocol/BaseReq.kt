package com.xinly.core.data.protocol

import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * Created by zm on 2019-06-27.
 */
abstract class BaseReq<T>(protected val data: T) : IReq<T> {

    override fun toRequestBody(): RequestBody {
        val json: String = Gson().toJson(this)
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
    }
}