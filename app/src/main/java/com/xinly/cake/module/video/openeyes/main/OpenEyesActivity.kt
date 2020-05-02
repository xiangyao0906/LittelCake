package com.xinly.cake.module.video.openeyes.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.gyf.immersionbar.ImmersionBar
import com.xinly.cake.BR
import com.xinly.cake.R
import com.xinly.cake.base.BaseMVVMActivity
import com.xinly.cake.databinding.OpenEyesViewBinding
import kotlinx.android.synthetic.main.activity_open_eyes.*

class OpenEyesActivity : BaseMVVMActivity<OpenEyesViewBinding, OpenEyesViewModel>() {

    override fun initContentViewId(savedInstanceState: Bundle?): Int = R.layout.activity_open_eyes

    override fun initVariableId(): Int = BR.viewModel

    override fun setStatusBar() {

        ImmersionBar.with(this@OpenEyesActivity)
            .statusBarColor(R.color.orange)
            .statusBarDarkFont(false)
            .fitsSystemWindows(true)
            .init()
    }

    override fun initData() {
        super.initData()

        bottom_navigation_bar
            .addItem(
                BottomNavigationItem(
                    R.drawable.icon_one,
                    "Nearby"
                ).setActiveColorResource(R.color.orange)
            )
            .addItem(
                BottomNavigationItem(
                    R.drawable.icon_two,
                    "Find"
                ).setActiveColorResource(R.color.teal)
            )
            .addItem(
                BottomNavigationItem(
                    R.drawable.icon_three,
                    "Categories"
                ).setActiveColorResource(R.color.blue)
            )
            .addItem(
                BottomNavigationItem(
                    R.drawable.ic_four,
                    "Categories"
                ).setActiveColorResource(R.color.red)
            )
            .setFirstSelectedPosition(0)
            .initialise()





        bottom_navigation_bar.setTabSelectedListener(object :
            BottomNavigationBar.SimpleOnTabSelectedListener() {
            override fun onTabSelected(position: Int) {
                super.onTabSelected(position)
                when (position) {
                    0 -> {
                        ImmersionBar.with(this@OpenEyesActivity)
                            .statusBarColor(R.color.orange)
                            .statusBarDarkFont(false)
                            .fitsSystemWindows(true)
                            .init()
                    }
                    1 -> {
                        ImmersionBar.with(this@OpenEyesActivity)
                            .statusBarColor(R.color.teal)
                            .statusBarDarkFont(false)
                            .fitsSystemWindows(true)
                            .init()
                    }
                    2 -> {
                        ImmersionBar.with(this@OpenEyesActivity)
                            .statusBarColor(R.color.blue)
                            .statusBarDarkFont(false)
                            .fitsSystemWindows(true)
                            .init()
                    }
                    3 -> {
                        ImmersionBar.with(this@OpenEyesActivity)
                            .statusBarColor(R.color.red)
                            .statusBarDarkFont(false)
                            .fitsSystemWindows(true)
                            .init()
                    }
                }

            }
        })


        viewModel?.getHomeData()
    }

}
