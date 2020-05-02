package com.xinly.cake.component.data

import android.util.Base64
import com.google.gson.Gson
import com.xinly.core.XinlyCore
import com.xinly.core.data.protocol.BaseReq
import com.xinly.core.utils.DeviceUtil
import com.xinly.core.utils.EncryptUtils
import com.xinly.core.utils.NetWorkUtils
import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * Created by zm on 2019-06-26.
 */
class BaseRequestBody<T>(data: T) : BaseReq<T>(data){
    //设备信息
    private val equip: EquipData
    init {
        equip = EquipData()
    }
    class EquipData{
        //uuid
        val uuid: String = DeviceUtil.getIMEI(XinlyCore.context)
        //size
        val size="${DeviceUtil.deviceWidth(XinlyCore.context)}X${DeviceUtil.deviceHeight(XinlyCore.context)}"
        //os version
        private val version: String = DeviceUtil.getBuildVersion()
        //phone brand
         val name: String = DeviceUtil.getPhoneBrand()
        //model
        val model :String =DeviceUtil.getPhoneModel()
    }

    override fun toRequestBody(): RequestBody {
        val params = HashMap<String, Any>()
//        params["udid"] = "fa53872206ed42e3857755c2756ab683fc22d64a"
        params["udid"] = equip.uuid
        params["vc"] = "591"
        params["vn"] = "621"
        params["size"] = equip.size
        params["deviceModel"] = equip.name
        params["first_channel"] = "eyepetizer_zhihuiyun_market"
        params["last_channel"] = "eyepetizer_zhihuiyun_market"
        params["system_version_code"] = "19"
        val json: String = Gson().toJson(params)
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
    }
}