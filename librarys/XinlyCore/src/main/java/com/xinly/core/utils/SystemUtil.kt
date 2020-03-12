package com.xinly.core.utils

import com.xinly.core.BuildConfig

/**
 * Created by zm on 2019-06-26.
 */
object SystemUtil {

    /**
     * 是否支持log输出
     */
    private var isDeveloperLog = false

    @JvmStatic
    fun isCanLog(): Boolean {
        return BuildConfig.DEBUG or isDeveloperLog
    }

    fun updateDeveloperLogControl(b : Boolean) {
        isDeveloperLog = b
    }
}