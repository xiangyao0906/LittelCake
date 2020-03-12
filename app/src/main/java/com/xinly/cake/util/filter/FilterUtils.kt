package com.xinly.wallet.util.filter

import android.text.InputFilter
import android.widget.EditText
import java.util.regex.Pattern

/**
 * Created by zm on 2019-07-31.
 */
object FilterUtils {

    /**
     * 给EditFilter设置过滤器
     * @param editText
     * @param filter
     */
    fun setFilter(editText: EditText, filter: InputFilter) {
        val filters: Array<InputFilter> = arrayOf(filter)
        editText.filters = filters
    }

    private fun match(regex: String, str: String): Boolean {
        if (str.isEmpty()) return false
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(str)
        return matcher.matches()
    }

    /**
     * 输入时,监听电话号码格式
     * @param phoneNumber
     * @return
     */
    fun isInputPhoneFormat(phoneNumber: String): Boolean {
        val regular = "^1[0-9]{0,10}$"
        return match(regular, phoneNumber)
    }

    /**
     * 输入时，是否仅字母或数字组合
     */
    fun isInputOnlyLetterOrNumberFormat(content: String): Boolean{
        val regular = "^[a-zA-Z0-9]{0,20}$"
        return match(regular, content)
    }

    /**
     * 输入时，是否仅数字组合
     */
    fun isInputOnlyNumberFormat(content: String): Boolean{
        val regular = "^[0-9]{6,30}$"
        return match(regular, content)
    }

    /**
     * 输入时,监听金额格式
     * @param money
     * @return
     */
    fun isInputMoneyFormat(money: String):Boolean {
        val regular = "^((^[1-9]\\d*)|^0)(\\.\\d{0,6}){0,1}$"
        return match(regular, money)
    }
    /*
    * 判断是否为邮箱
    * **/
    fun isEmail(content: String):Boolean{
        val rex="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+\$"
        return match(rex,content)
    }
}