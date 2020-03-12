package com.xinly.core.net

import android.content.Context
import android.widget.Toast
import com.xinly.core.R
import com.xinly.core.XinlyCore
import com.xinly.core.ext.yes
import com.xinly.core.net.exception.ApiException
import com.xinly.core.net.exception.ExceptionEngine
import com.xinly.core.net.view.DialogHelper
import com.xinly.core.rx.BaseSubscriber
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

/**
 * Created by zm on 2019-06-19.
 */
abstract class RxSubscriberHelper<T>(context: Context?, protected val isShowLoad: Boolean) : BaseSubscriber<T>() {

    /**
     * 错误是否弹出错误toast
     */
    protected var isShowMessage = true
    /**
     * 是否自动拦截权限类错误
     */
    protected var isCheckPermission = true

    private var context: WeakReference<Context>? = context?.let { WeakReference(context) }


    override fun onComplete() {
        isShowLoad.yes {
            onDismissLoad()
        }
    }

    override fun onSubscribe(d: Disposable) {
        isShowLoad.yes {
            onShowLoading()
        }
    }

    override fun onNext(t: T) {
        _onNext(t)
    }

    override fun onError(e: Throwable) {
        val apiException = ExceptionEngine.handleException(e)
        if (isCheckPermission && apiException.code == ExceptionEngine.ERROR.PERMISSION_ERROR) {
            onPermissionError(apiException)
        } else {
            isShowMessage.yes {
                onShowMessage(apiException)
            }
            _onError(apiException)
        }
    }

    abstract fun _onNext(t: T)

    open fun _onError(apiException: ApiException) {
        isShowLoad.yes {
            onDismissLoad()
        }
    }

    /**
     * 显示加载loading
     */
    private fun onShowLoading() {
        context?.get()?.let {
            DialogHelper.instance.showLoadingDialog(it)
        }
    }

    /**
     * 关闭加载
     */
    protected fun onDismissLoad() {
        DialogHelper.instance.dismissLoading()
    }

    /**
     * 权限失效会自动登出, V1版本权限失效主要依据为 401 {@link ExceptionEngine#handleException(Throwable)}
     * 所有需要验证权限的接口，Authorization token 缺失或校验失败都将触发401 {@link }
     *
     * @param apiException
     */
    open fun onPermissionError(apiException: ApiException) {

    }

    /**
     * Y
     * 任何类型的错误都会弹出Toast,重写方式修改
     *
     * @param apiException
     */
    open fun onShowMessage(apiException: ApiException) {
        Toast.makeText(
            XinlyCore.context,
            apiException.msg ?: XinlyCore.context.getString(R.string.common_net_error_default),
            Toast.LENGTH_SHORT
        ).show()
    }
}