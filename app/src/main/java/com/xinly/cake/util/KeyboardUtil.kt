package com.xinly.wallet.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * 键盘管理
 * <p>
 * Created by zm on 2019-08-06.
 */
object KeyboardUtil {

    fun openSoftKeyboard(et: View?) {
        if (et != null) {
            et.isFocusable = true
            et.isFocusableInTouchMode = true
            val inputManager = et.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            et.requestFocus()
            inputManager.showSoftInput(et, 0)
        }

    }

    /**
     * 键盘是否弹出
     * @param et
     * @return
     */
    fun isActive(et: EditText?): Boolean {
        if (et != null) {
            val inputMethodManager = et.context.getSystemService("input_method") as InputMethodManager
            return inputMethodManager.isActive(et)
        }
        return false
    }

    fun closeSoftKeyboard(context: Context?) {
        if (context != null && context is Activity && context.currentFocus != null) {
            try {
                val e = context.currentFocus
                val imm = e!!.context.getSystemService("input_method") as InputMethodManager
                e.clearFocus()
                imm.hideSoftInputFromWindow(e.windowToken, 0)
            } catch (var3: Exception) {
                var3.printStackTrace()
            }

        }
    }

    fun closeSoftKeyboard(view: View?) {
        if (view != null && view.windowToken != null) {
            val imm = view.context.getSystemService("input_method") as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    /**
     * show or hide soft input
     * @param activity
     */
    fun showSoftInput(activity: Activity) {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    fun isSoftInputOpen(activity: Activity): Boolean {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return imm.isActive
    }
}