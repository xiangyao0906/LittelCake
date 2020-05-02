package com.xinly.cake.component.data

import com.xinly.core.XinlyCore
import com.xinly.core.utils.DeviceUtil
import java.util.*
import kotlin.collections.HashMap

object QueryMapHelper {
    //设备信息
    private val equip: EquipData

    init {
        equip = EquipData()
    }

    class EquipData {
        //uuid
        val uuid: String = DeviceUtil.getIMEI(XinlyCore.context)

        //size
        val size =
            "${DeviceUtil.deviceWidth(XinlyCore.context)}X${DeviceUtil.deviceHeight(XinlyCore.context)}"

        //os version
        private val version: String = DeviceUtil.getBuildVersion()

        //phone brand
        val name: String = DeviceUtil.getPhoneBrand()

        //model
        val model: String = DeviceUtil.getPhoneModel()
    }

    fun homeQueryMap(): HashMap<String, String> {
        val params = HashMap<String, String>()
        params["udid"] ="6d5d5b69afb1499abc16aba3888d01f061b25296"
        params["vc"] = "591"
        params["vn"] = "6.2.1"
        params["size"] = equip.size
        params["deviceModel"] = equip.model
        params["first_channel"] =
            "eyepetizer_${equip.name.toLowerCase(Locale.getDefault())}_market"
        params["last_channel"] =
            "eyepetizer_${equip.name.toLowerCase(Locale.getDefault())}_market"
        params["system_version_code"] = "28"
        return params

    }


}