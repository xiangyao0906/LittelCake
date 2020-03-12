package com.xinly.core.utils

/**
 * MaterialDialog工具类
 * <p>
 * Created by zm on 2019/3/28.
 */
class MaterialDialogUtils private constructor(){
    companion object {
        val instance: MaterialDialogUtils by lazy(LazyThreadSafetyMode.SYNCHRONIZED){ MaterialDialogUtils() }
    }

}