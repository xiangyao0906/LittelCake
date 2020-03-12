package com.xinly.cake.model.vo.bean

import android.graphics.drawable.Drawable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.xinly.cake.BR

/**
 * Created by zm on 2019-06-30.
 */
 class ToolBarData: BaseObservable(){
    @Bindable
    var titleText: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.titleText)
        }
    @Bindable
    var rightText: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.rightText)
        }
    @Bindable
    var rightImg: Drawable? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.rightImg)
        }
    @Bindable
    var subImg: Drawable? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.subImg)
        }
    @Bindable
    var dark: Boolean = true
        set(value) {
            field = value
            notifyPropertyChanged(BR.dark)
        }
}