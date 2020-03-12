package com.xinly.wallet.model.constans

import androidx.annotation.StringDef

/**
 * 币种类型
 * <p>
 * Created by zm on 2019-08-02.
 */

class CoinType {
   companion object {
       const val BTC = "BTC"
       const val ETH = "ETH"
       const val REC = "REC"
   }

    @StringDef(BTC, ETH, REC)
    @Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
    @Retention(AnnotationRetention.SOURCE)
    annotation class CoinType
}
