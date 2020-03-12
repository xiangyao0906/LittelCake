package com.xinly.cake.model.constans

import com.xinly.cake.BuildConfig


/**
 * Created by zm on 2019-06-27.
 */
object Constans {
    /**********************-Config START-*********************/
    // md5盐
//    const val MD5_SALT = BuildConfig.MD5_SALT
    //SP表名
    const val TABLE_PREFS = "rec_wallet"
    //公钥
    const val RSA_ECB_PKCS1PADDING = "RSA/ECB/PKCS1Padding"
    const val PUBLIC_KEY =
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCa0SRuag+i9QFfEiExGmoREPwenokbqek7hKyGVgA8t8iVWoJK+iAofn05PbHDDMX8HXZmpcCc8GKoo3/J073s0aL0KE66ElWfExcevb8hfvzDU8fnEdZCLPY+m6TQyP0/1EY+GnS2F2apDlZs3uawl+eind9O6ERUKIQ2gSkrkwIDAQAB"
    /*********************-Config END-************************/

    //SP键名
    //是否显示余额
    const val SP_SHOW_BALANCE = "showBalance"
    //是否开启指纹认证
    const val SP_IS_OPEN_FINGERPRINT = "isOpenFingerprint"
    //语言 zh简体中文 enEnglish
    const val SP_SETTINGS_LANGUAGE = ""
    //货币 0CNY 1USD
    const val SP_SETTINGS_CURRENCY = "currencyFlag"

    // Params key
    const val EXTRAS_KEY_MNEMONIC = "mnemonic"
    const val EXTRAS_KEY_WALLET_ID = "walletId"
    const val EXTRAS_KEY_WALLET_PASSWORD = "walletPwd"
    const val EXTRAS_KEY_IS_EDIT = "isEdit"
    const val EXTRAS_KEY_DATA = "data"
    const val EXTRAS_KEY_IS_AUTHENTICATION = "isAuthentication"
    const val EXTRAS_KEY_TYPE = "type"
    const val EXTRAS_KEY_RID = "rid"
    const val EXTRAS_KEY_MESSAGE_ID = "messageId"
    const val EXTRAS_KEY_ADDRESS = "address"
    const val EXTRAS_KEY_AMOUT = "amount"
    const val EXTRAS_KEY_ASSET_NAME = "assetName"
    const val EXTRAS_KEY_TITLE = "title"
    const val EXTRAS_KEY_MODULE = "module"
    const val EXTRAS_KEY_APP_URL = "appUrl"

    //bus action
    //地址更新
    const val BUS_ACTION_ADDRESS_UPDATE = "address_update"
    //账户更新
    const val BUS_ACTION_ACCOUNT_UPDATE = "account_update"
    //账户删除
    const val BUS_ACTION_ACCOUNT_DELETE = "account_delete"
    //扫码成功
    const val BUS_ACTION_SCAN_SUCCESS = "scan_success"
    //扫码入口-首页
    const val BUS_ACTION_SCAN_TYPE_HOME = "type_home"
    //扫码入口-转账
    const val BUS_ACTION_SCAN_TYPE_TRANSFER = "type_transfer"
    //扫码入口-rid
    const val BUS_ACTION_SCAN_TYPE_CREATE_RID = "type_create_rid"
    //扫码入口-添加地址
    const val BUS_ACTION_SCAN_TYPE_ADD_ADDRESS = "type_add_address"
    //扫码入口-提币地址
    const val BUS_ACTION_SCAN_TYPE_WITHDRAW_COIN = "type_withdraw_coin"
    //扫码失败
    const val BUS_ACTION_SCAN_ERROR = "scan_error"
    //余额是否显示
    const val BUS_ACTION_BALANCE_IS_SHOW = "balance_is_show"
    //钱包更新
    const val BUS_ACTION_WALLET_UPDATE = "wallet_update"
    //转账成功
    const val BUS_ACTION_TRANSFER_SUCCESS = "transfer_success"
    //地址选择
    const val BUS_ACTION_SELECT_ADDRESS = "select_address"
    //账户切换
    const val BUS_ACTION_SWITCH_ACCOUNT = "switch_account"
    //指纹验证成功
    const val BUS_ACTION_FINGERPRINT_SUCCESS = "fingerprint_success"
    //密码验证成功
    const val BUS_ACTION_PWD_VERIFY_SUCCESS = "pwd_verify_success"
    //是否登录验证
    const val BUS_ACTION_IS_LOGIN_VERIFY = "fingerprint_success"
    //rid创建成功
    const val BUS_ACTION_RID_CREATE_SUCCESS = "fingerprint_success"
    //提币扫描添加地址
    const val BUS_ACTION_WITH_DRAW_SUCCESS = "with_draw_success"

    //sup coin type
    const val BTC = "BTC"
    const val ETH = "ETH"
    const val REC = "REC"


    const val ASSET_RECHARGE = "recharge"
    const val ASSET_WITHDRAW = "withdraw"
    const val ASSET_EXCHANGE = "exchange"

    const val RECHARGE = 0
    const val WITHDRAW = 1

    //Rad 筛选
    const val AD_FILTER_TYPE_GOING = 0
    const val AD_FILTER_TYPE_END = 1
    const val AD_FILTER_TYPE_DRAFT = 2
    const val AD_FILTER_TYPE_COLLATION = 3
    const val AD_FILTER_TYPE_CHOOSE = 4
    const val QR_CODE_PRFIX="invite:"
}