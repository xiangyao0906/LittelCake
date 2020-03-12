package com.xinly.core.data.protocol

import com.xinly.core.data.BaseResultCode

/**
 * 返回数据基类
 * <p>
 * Created by zm on 2019/3/24.
 */
data class BaseResp<out T>(val code:Int, val message:String, val data:T): IResp {
    override fun getICode(): Int {
        return code
    }

    override fun getMsg(): String {
        return message
    }

    override fun isSuccess(): Boolean {
        return code == BaseResultCode.SUCCESS
    }
}