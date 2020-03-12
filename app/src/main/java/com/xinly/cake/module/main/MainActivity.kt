package com.xinly.cake.module.main

import android.os.Bundle
import com.xinly.cake.BR
import com.xinly.cake.R
import com.xinly.cake.base.BaseMVVMActivity
import com.xinly.cake.databinding.MainViewBinding

class MainActivity : BaseMVVMActivity<MainViewBinding,MainViewModel>() {

    override fun initContentViewId(savedInstanceState: Bundle?): Int =R.layout.activity_main

    override fun initVariableId(): Int =BR.viewModel
}
