package com.xinly.cake.base

import android.os.Bundle
import android.util.Log
import androidx.databinding.ViewDataBinding
import com.gyf.immersionbar.ImmersionBar
import com.xinly.cake.R
import com.xinly.core.ui.activity.BaseActivity
import com.xinly.core.viewmodel.BaseViewModel

/**
 * Created by zm on 2019-07-16.
 */
abstract class BaseMVVMActivity<V : ViewDataBinding, VM : BaseViewModel> : BaseActivity<V, VM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(!javaClass.simpleName.equals("VideoDetailsActivity")){
            setStatusBar()
        }
        Log.e("activity=>", javaClass.simpleName)
    }

    open fun setStatusBar() {
        ImmersionBar.with(this)
            .statusBarColor(R.color.cc)
            .statusBarDarkFont(false)
            .fitsSystemWindows(true)
            .init()
    }
}