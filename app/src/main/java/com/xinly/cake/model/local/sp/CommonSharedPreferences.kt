package com.xinly.cake.model.local.sp

import com.xinly.cake.model.vo.result.AppSettingsData
import com.xinly.cake.util.PrefsUtils

/**
 * Created by zm on 2019-07-23.
 */
class CommonSharedPreferences private constructor(){

    companion object {
        val instance: CommonSharedPreferences by lazy(LazyThreadSafetyMode.SYNCHRONIZED){ CommonSharedPreferences() }

        //更新应用配置
        private const val CONFIG_DATA = "config_data"
    }

    /**
     * 更新应用配置数据
     */
    fun updateConfigData(data: AppSettingsData)  {
        PrefsUtils.putObject(CONFIG_DATA, data)
    }

    /**
     * 获取应用配置数据
     */
    fun getConfigData(): AppSettingsData? {
        return PrefsUtils.getObject(CONFIG_DATA, AppSettingsData::class.java)
    }
}