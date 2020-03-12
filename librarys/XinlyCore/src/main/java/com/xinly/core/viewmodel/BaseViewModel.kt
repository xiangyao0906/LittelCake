package com.xinly.core.viewmodel

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.hwangjr.rxbus.RxBus
import com.trello.rxlifecycle3.LifecycleProvider
import com.xinly.core.bus.event.SingleLiveEvent
import java.lang.ref.WeakReference

/**
 * ViewModel基类
 * <p>
 * Created by zm on 2019/3/27.
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application), IBaseViewModel {
    lateinit var lifecycleProvider: LifecycleProvider<*>
    lateinit var context: WeakReference<Context>
    private set
    val uc: UIChangeLiveData by lazy { UIChangeLiveData() }

    /**
     * 注入RxLifecycle生命周期
     * @param lifecycleProvider
     */
    fun injectLifecycleProvider(lifecycleProvider: LifecycleProvider<*>) {
        this.lifecycleProvider = lifecycleProvider
    }

    /**
     * 注入context
     * @param context
     */
    fun injectContext(context: Context) {
        this.context = WeakReference(context)
    }

    /**
     * 跳转页面
     * @param clz 所跳转的目的的Activity
     * @param bundle 跳转所携带的信息
     */
    fun startActivity(clz: Class<*>, bundle:Bundle?=null) {
        val params = HashMap<String, Any>()
        params[ParameterField.CLASS] = clz
        bundle?.let {
            params[ParameterField.BUNDLE] = bundle
        }
        uc.startActivityEvent.postValue(params)
    }

    /**
     * 关闭界面
     */
    fun finish() {
        uc.finishEvent.call()
    }

    /**
     * 返回上一层
     */
    fun onBackPressed() {
        uc.onBackPressedEvent.call()
    }

    override fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        // empty
    }

    override fun onCreate() {
        // empty
    }

    override fun onDestroy() {
        // empty
    }

    override fun onStart() {
        // empty
    }

    override fun onStop() {
        // empty
    }

    override fun onResume() {
        // empty
    }

    override fun onPause() {
        // empty
    }

    override fun registerRxBus() {
        RxBus.get().register(this)
    }

    override fun removeRxBus() {
        RxBus.get().unregister(this)
    }

    class UIChangeLiveData : SingleLiveEvent<Nothing>() {
        //跳转页面
        val startActivityEvent: SingleLiveEvent<Map<String, Any>> by lazy { SingleLiveEvent<Map<String, Any>>() }
        //关闭界面
        val finishEvent: SingleLiveEvent<Nothing> by lazy { SingleLiveEvent<Nothing>() }
        //关闭上一层
        val onBackPressedEvent: SingleLiveEvent<Nothing> by lazy { SingleLiveEvent<Nothing>() }
    }

    class ParameterField{
        companion object {
            const val CLASS = "CLASS"
            const val BUNDLE = "BUNDLE"
        }
    }
}