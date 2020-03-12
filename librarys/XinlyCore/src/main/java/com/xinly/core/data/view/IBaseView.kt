package com.xinly.core.data.view

/**
 * Created by zm on 2019/3/24.
 */
interface IBaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text:String)
}