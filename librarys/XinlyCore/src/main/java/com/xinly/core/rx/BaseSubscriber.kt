package com.xinly.core.rx

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Rx订阅者默认实现
 * <p>
 * Created by zm on 2019/3/24.
 */
abstract class BaseSubscriber<T>: Observer<T> {

    override fun onSubscribe(d: Disposable) {
    }

    override fun onComplete() {
    }

    override fun onNext(t: T) {

    }

    override fun onError(e: Throwable) {

    }
}