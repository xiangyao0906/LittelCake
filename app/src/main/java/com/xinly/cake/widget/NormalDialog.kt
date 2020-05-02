package com.xinly.cake.widget

import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.WindowManager
import com.xinly.cake.R
import kotlinx.android.synthetic.main.dialog_normal.view.*
import me.jessyan.autosize.utils.ScreenUtils

/**
 * Created by zm on 2019-07-29.
 */
class NormalDialog(private val context: Context) {

    private var dialog: Dialog? = null
    private var rootView: View? = null

    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    fun showDialog(title: CharSequence = "", msg: CharSequence = "", titleRes: Int = 0, msgRes: Int = 0) : NormalDialog {
        dialog = Dialog(context, R.style.BottomViewTheme_Default)
        //加载布局
        rootView = View.inflate(context, R.layout.dialog_normal, null).apply {
            //设置标题
            if (title.isNotEmpty()) {
                dialogTitle.visibility = View.VISIBLE
                dialogTitle.text = title
            }
            if (titleRes != 0) {
                dialogTitle.visibility = View.VISIBLE
                dialogTitle.setText(titleRes)
            }
            //设置消息内容
            if (msg.isNotEmpty()) {
                dialogMessage.visibility = View.VISIBLE
                dialogMessage.text = msg
            }
            if(msgRes != 0) {
                dialogMessage.visibility = View.VISIBLE
                dialogMessage.setText(msgRes)
            }
        }
        //获取dialog实例
        dialog?.apply {
            window?.requestFeature(1)
            setContentView(rootView!!)
            val p: WindowManager.LayoutParams = window!!.attributes
            p.width = (ScreenUtils.getScreenSize(context)[0]*0.85).toInt()
            window?.attributes = p
        }
        //显示
        dialog?.show()
        return this
    }

    /**
     * 取消事件
     */
    fun onCancelClickListener(text: CharSequence = "", textRes: Int = 0, clickListener: View.OnClickListener?=null): NormalDialog {
        rootView?.apply {
            dialogCancel.visibility = View.VISIBLE
            if(text.isNotEmpty()) {
                dialogCancel.text = text
            }
            if (textRes != 0) {
                dialogCancel.setText(textRes)
            }
            //取消事件
            dialogCancel.setOnClickListener {
                dialog?.dismiss()
                clickListener?.onClick(it)
            }
        }
        return this
    }

    /**
     * 确认事件
     */
    fun onConfirmClickListener(text: CharSequence = "", textRes: Int = 0, clickListener: View.OnClickListener?=null): NormalDialog {
        rootView?.apply {
            ivLine.visibility = View.VISIBLE
            dialogConfirm.visibility = View.VISIBLE
            if(text.isNotEmpty()) {
                dialogConfirm.text = text
            }
            if (textRes != 0) {
                dialogConfirm.setText(textRes)
            }
            //取消事件
            dialogConfirm.setOnClickListener {
                dialog?.dismiss()
                clickListener?.onClick(it)
            }
        }
        return this
    }

}