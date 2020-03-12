package com.xinly.core.data.protocol

import okhttp3.RequestBody

/**
 * Created by zm on 2019-06-26.
 */
interface IReq<T> {
    fun toRequestBody(): RequestBody
}