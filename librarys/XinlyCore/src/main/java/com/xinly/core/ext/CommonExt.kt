package com.xinly.core.ext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.res.Resources
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.dovar.dtoast.DToast
import com.trello.rxlifecycle3.LifecycleProvider
import com.xinly.core.R
import com.xinly.core.XinlyCore
import com.xinly.core.data.protocol.BaseResp
import com.xinly.core.rx.BaseFunc
import com.xinly.core.rx.BaseFunc1
import com.xinly.core.rx.BaseFuncBoolean
import com.xinly.core.rx.BaseSubscriber
import com.xinly.core.utils.GlideUtils
import com.xinly.core.widgets.DefaultTextWatcher
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

//Kotlin通用扩展
//Created by zm on 2019/3/24.

/**
 * 扩展Observable执行
 */
fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribe(subscriber)
}

/**
 * 扩展数据转换
 */
fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

/**
 * 扩展数据转换
 * 没有code message
 */
fun <T> Observable<T>.withOutCode(): Observable<T> {
    return this
}

/**
 * 扩展数据处理
 */
fun <T> Observable<BaseResp<T>>.handleResult(): Observable<BaseResp<T>> {
    return this.flatMap(BaseFunc1())
}

/**
* 扩展Boolean类型数据转换
*/
fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

/**
 * 扩展点击事件
 */
fun View.onClick(listener: View.OnClickListener): View {
    setOnClickListener(listener)
    return this
}

/**
 * 扩展点击事件，参数为方法
 */
fun View.onClick(method:() -> Unit): View {
    setOnClickListener{
        method()
    }
    return this
}

/**
 * 扩展Button可用性
 */
fun Button.enable(et:EditText, method:() -> Boolean) {
    val btn = this
    et.addTextChangedListener(object: DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}

/**
 * 扩展View的显示与隐藏
 */
fun View.setVisible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

/**
 * ImageView加载网络图片
 */
fun ImageView.loadUrl(url: String) {
    GlideUtils.loadImage(context, url, this)
}

/**
 * 扩展String的copy到系统剪贴板功能
 */
fun String.copy(): Boolean {
    val link = this
    val clipData = ClipData.newPlainText("text", link)
    // 复制
    val cm = XinlyCore.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    // 将文本内容放到系统剪贴板里。
    cm.setPrimaryClip(clipData)
    return true
}

/**
 * 扩展String的toastShow方法
 * 默认显示
 */
fun String.show() {
    val toast = DToast.make(XinlyCore.context)
    val tvText = toast.view.findViewById<TextView>(R.id.tv_content_default)
    tvText?.text = this
    toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 30).show()
}

/**
 * 扩展String的toastShow方法
 * 居中显示
 */
fun String.showAtCenter() {
    val toastRoot = View.inflate(XinlyCore.context, R.layout.layout_toast_center, null)
    val tvText = toastRoot.findViewById<TextView>(R.id.tv_content)
    tvText?.text = this
    DToast.make(XinlyCore.context).setView(toastRoot).setGravity(Gravity.CENTER, 0, 0).show()


}
/**
 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
 */
fun Int.dp2px():Int{
    return (0.5f + this * Resources.getSystem().displayMetrics.density).toInt()
}