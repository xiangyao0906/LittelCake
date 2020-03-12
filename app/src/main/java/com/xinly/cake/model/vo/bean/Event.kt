package com.xinly.wallet.model.vo.bean

/**
 * Created by zm on 2019-11-19.
 */
object Event {
    class MessageEvent
    /**
     * 扫码成功
     */
    data class ScanMessageEvent(val content: String)
    /**
     * 钱包
     */
    data class WalletMessageEvent(val walletId: Long)
}