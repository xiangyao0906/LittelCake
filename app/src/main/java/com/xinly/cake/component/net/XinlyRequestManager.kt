package com.xinly.cake.component.net

import com.xinly.cake.util.HostUtil
import com.xinly.core.net.RequestManager

/**
 * Created by zm on 2019-06-27.
 */
object XinlyRequestManager: RequestManager() {

    @Suppress("UNCHECKED_CAST")
    fun <T: Any> getRequest(clazz: Class<T>): T {
        var t: T? = sRequestManager[clazz] as? T
        if (t == null) {
            t = XinlyRetrofitClient.createApi(clazz, HostUtil.HOST_URL)
            sRequestManager[clazz] = t
        }
        return t
    }
}