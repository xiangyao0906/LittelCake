package com.xinly.core.binding.viewadpater.view

import android.annotation.SuppressLint
import android.view.View
import androidx.databinding.BindingAdapter
import com.jakewharton.rxbinding2.view.RxView
import com.xinly.core.binding.command.BindingCommand
import java.util.concurrent.TimeUnit

/**
 * Created by zm on 2019/1/5.
 */
object ViewAdapter {
    // 防重复点击间隔(秒)
    private const val CLICK_INTERVAL: Long = 1

    /**
     * requireAll 是意思是是否需要绑定全部参数, false为否
     * View的onClick事件绑定
     * onClickCommand 绑定的命令,
     * isThrottleFirst 是否开启防止过快点击
     */
    @SuppressLint("CheckResult")
    @BindingAdapter(value = ["onClickCommand", "isThrottleFirst"], requireAll = false)
    @JvmStatic
    fun onClickCommand(view: View, clickCommand: BindingCommand<Nothing>, isThrottleFirst: Boolean) {
        if (isThrottleFirst) {
            RxView.clicks(view)
                    .subscribe {
                        clickCommand.execute()
                    }
        }else {
            RxView.clicks(view)
                    .throttleFirst(CLICK_INTERVAL, TimeUnit.SECONDS)
                    .subscribe {
                        clickCommand.execute()
                    }
        }
    }

    /**
     * view的onLongClick事件绑定
     */
    @SuppressLint("CheckResult")
    @JvmStatic
    @BindingAdapter(value = ["onLongClickCommand"], requireAll = false)
    fun onLongClickCommand(view: View, clickCommand: BindingCommand<Nothing>) {
        RxView.longClicks(view)
                .subscribe{
                    clickCommand.execute()
                }
    }
}