package com.xinly.wallet.model.constans

/**
 * api url
 * Created by zm on 2019-11-25.
 */
object UrlConstans {
    //service api
    //应用启用获取
    const val SERVICE_APP_CONFIG = "api/service/app/config"
    //帮组中心
    const val SERVICE_CONFIG_HELP_LIST = "api/service/config/help/list"
    //获取最新版本
    const val SERVICE_CONFIG_VERSION_NEW = "api/service/config/version/new"

    //wallet api
    //钱包私钥同步
    const val API_WALLET_BASE_SYNC = "api/wallet/base/sync"
    //RID受邀开通
    const val API_WALLET_BASE_RID_INVITE = "api/wallet/base/rid/invite"
    //成为源点
    const val API_WALLET_BASE_RID_ORIGIN = "api/wallet/base/rid/origin"
    //消息列表
    const val API_WALLET_BASE_MESSAGE_LIST = "api/wallet/base/message/list"
    //消息详情
    const val API_WALLET_BASE_MESSAGE_INFO = "api/wallet/base/message/info"
    //全部已读
    const val API_WALLET_BASE_MESSAGE_READ = "api/wallet/base/message/read"
    //获取REC资产详情
    const val API_WALLET_BASE_REC_DETAIL = "api/wallet/base/rec/detail"
    //REC转账交易
    const val API_WALLET_BASE_REC_TRANSFER = "api/wallet/base/rec/transfer"
    //跨链资产转账
    const val API_WALLET_BASE_CHAIN_TRANSFER = "api/wallet/base/chain/transfer"
    //获取邀请奖励明细
    const val API_WALLET_INVITE_REWARD = "api/wallet/invite/reward"
    //获取赛季排行
    const val API_WALLET_INVITE_RANK = "api/wallet/invite/rank"
    //获取挖矿记录
    const val API_WALLET_MINE_LOG = "api/wallet/mine/log"
    //获取当前算力
    const val API_WALLET_MINE_POWER_INFO = "api/wallet/mine/power/info"
    //获取节点记录
    const val API_WALLET_MINE_POWER_LOG = "api/wallet/mine/power/log"
    //获取REC记录详情
    const val API_WALLET_BASE_REC_LOG = "api/wallet/base/rec/log"
    //获取裂变相关
    const val API_WALLET_MINE_FISSION = "api/wallet/mine/fission"
    //获取钱包信息列表
    const val API_WALLET_BASE_ASSETS_LIST = "api/wallet/base/assets/list"
    //使用钱包信息
    const val API_WALLET_BASE_ASSETS_USED = "api/wallet/base/assets/used"

    //对撞信息获取
    const val API_WALLET_COLLISION = "api/wallet/clash/info"
    //获取跨连资产
    const val API_ASSET_LIST = "api/wallet/base/chain/list"
    //获取跨连资产交易记录
    const val API_ASSET_TRADE_RECORD_LIST = "api/wallet/base/chain/detail"
    //获取资产交易记录的详情
    const val API_ASSET_TRADE_RECORDE_DETAILS = "api/wallet/base/chain/log"
    //获取币种的充值地址
    const val GET_RECHAR_ADDRESS = "api/wallet/base/chain/recharge"
    //获取提币限制
    const val GET_CHAIN_LIMIT_INFO = "api/wallet/base/chain/quota"
    //跨连资产提币
    const val WITH_DRAW = "api/wallet/base/chain/withdraw"
    //对撞
    const val COLLISION_PUT = "api/wallet/clash/push"
    //对撞记录
    const val COLLISION_HISTORY = "api/wallet/clash/log"
    //广播列表
    const val RAD_BROADCAST = "api/wallet/rad/list"
    //区块链列表
    const val BLOCK_LIST = "api/wallet/rad/block"
    //我的区块链列表
    const val MY_BLOCK_LIST = "api/wallet/rad/log/march"
    //广播参与竞价信息
    const val BLOCK_INFO = "api/wallet/rad/info"
    //获取已经结束的竞价列表
    const val BLOCK_END = "api/wallet/rad/log/end"
    //提交竞价
    const val PULL_BLOCK_PRICE = "api/wallet/rad/bidding"
    //获取交易对
    const val GET_EXCHANGE_RATE_INFO = "api/wallet/exchange/symbol"
    //获取兑换历史
    const val EXCHANGE_HISTORY = "api/wallet/exchange/history"
    //取消定点杆
    const val EXCHANGE_CANCEL =  "api/wallet/exchange/cancel"
    //创建兑换订单
    const val CREAT_EXCHANGE_ORDER="api/wallet/exchange/add"
    //兑换大厅
    const val EXCHANGE_HALL="api/wallet/exchange/hall"
    //获取交易详情
    const val GET_ORDER_INFO="api/wallet/exchange/info"
    //支付交易订单
    const val PAY_ORDER="api/wallet/exchange/convert"
    //获取行情列白哦
    const val GET_QUOTES_INFO="api/wallet/exchange/list"
}