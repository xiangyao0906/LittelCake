package com.xinly.wallet.util.filter

import android.text.InputFilter
import android.text.Spanned

/**
 * Created by zm on 2019-07-31.
 */
class EditAmountFilter: InputFilter {

    override fun filter(source: CharSequence?, start: Int, end: Int, dest: Spanned?, dstart: Int, dend: Int): CharSequence {
        if (source.isNullOrEmpty()) {
            return ""
        }
        val sb = StringBuilder()
        sb.append(dest?.subSequence(0, dstart)).append(source).
            append(dest?.subSequence(dend, dest.length))
        return if (!FilterUtils.isInputMoneyFormat(sb.toString())) "" else source
    }
}