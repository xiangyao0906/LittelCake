package com.xinly.core.net.exception

import com.xinly.core.ext.yes

/**
 * Created by zm on 2019-06-20.
 */
class ApiException(cause: Throwable?, var code: Int, var msg: String?)
    : Exception(msg, cause) {

    var any: Any?=null

    init {
        (cause != null && cause is ServerException).yes {
            any = (cause as ServerException).any
        }
    }
}