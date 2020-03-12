package com.xinly.core.ui.activity

/**
 * Created by zm on 2019/3/27.
 */
interface IBaseActivity {
    /**
     * 初始化界面传递参数
     */
    fun initParam()

    /**
     * 初始化数据
     */
    fun initData()
    /**
     * 初始化界面观察者监听
     */
    fun initViewObservable()
}