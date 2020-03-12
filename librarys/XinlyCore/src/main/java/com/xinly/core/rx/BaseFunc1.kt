package com.xinly.core.rx

import com.xinly.core.data.protocol.BaseResp
import com.xinly.core.net.exception.ApiException
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.Function

/**
 * 通用数据类型转换封装
 * <p>
 * Created by zm on 2019/3/24.
 */
class BaseFunc1<T>: Function<BaseResp<T>, ObservableSource<BaseResp<T>>>{
    override fun apply(t: BaseResp<T>): ObservableSource<BaseResp<T>> {
        if (t.isSuccess()) {
            return Observable.just(t)
        }
        return Observable.error(ApiException(null, t.code, t.message))
    }

}