package com.xinly.mcn.widgets.bottomview

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import com.xinly.cake.R
import com.xinly.core.utils.DeviceUtil

/**
 * 底部弹出框
 * <p>
 * Created by zm on 2019-07-10.
 */
open class BaseBottomView(protected val context: Context, private val theme: Int
                          , resource: Int = 0, protected var rootView: View? = null) {

    private var bv: Dialog? = null
    private var animationStyle: Int = 0
    protected var dismissListener: DialogInterface.OnDismissListener? = null

    init {
        if (resource != 0) {
            rootView = View.inflate(context, resource, null)
        }
        setAnimation(R.style.BottomToTopAnim)
    }


    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    fun showBottomView(canceledOnTouchOutside: Boolean, gravity: Int = 80, limitHeight: Boolean = false) {
        if (isShow()) return
        if (this.bv == null) {
            if (theme == 0) {
                this.bv = Dialog(this.context)
            } else {
                this.bv = Dialog(this.context, this.theme)
            }
            bv!!.apply {
                setOnDismissListener {
                    dismissListener?.onDismiss(it)
                }
                setCanceledOnTouchOutside(canceledOnTouchOutside)
                window!!.requestFeature(1)
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                setContentView(this@BaseBottomView.rootView!!)
                val p: WindowManager.LayoutParams = window!!.attributes
                if (gravity == Gravity.CENTER) {
                    p.width = (DeviceUtil.deviceWidth(context) * 0.75).toInt()
                }else {
                    p.width = DeviceUtil.deviceWidth(context) * 1
                }
                if (limitHeight) {
                    p.height = DeviceUtil.deviceWidth(context) * 5 / 4
                }
                p.gravity = gravity
                if (this@BaseBottomView.animationStyle != 0) {
                    window!!.setWindowAnimations(this@BaseBottomView.animationStyle)
                }
                window!!.attributes = p
            }
        }
        bv?.show()
    }

    open fun dismissBottomView() {
        bv?.dismiss()
    }

    private fun isShow(): Boolean {
        return bv?.isShowing ?: false
    }

    protected fun setAnimation(animationStyle: Int): BaseBottomView {
        this.animationStyle = animationStyle
        return this
    }
}