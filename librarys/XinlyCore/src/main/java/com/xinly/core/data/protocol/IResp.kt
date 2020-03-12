package com.xinly.core.data.protocol

/**
 * 返回数据基类必须实现
 * 提供结果判断和通用消息返回
 * <p>
 * Created by zm on 2019/3/24.
 */
interface IResp {
    /**
     * 状态码
     */
    fun getICode(): Int

    /**
     * 消息
     */
    fun getMsg(): String

    /**
     * 是否成功
     */
    fun isSuccess(): Boolean
}