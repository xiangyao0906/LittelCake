package com.xinly.wallet.util

/**
 * Created by zm on 2019-11-22.
 */
/**
 * 扩展String的限制位数方法
 */
fun String.limit(scale: Int): String {
    return if(this.length <= scale) {
        this
    }else {
        "${this.take(scale)}..."
    }
}