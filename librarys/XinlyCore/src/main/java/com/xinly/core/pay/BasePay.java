package com.xinly.core.pay;


import com.xinly.core.pay.inf.IPay;
import com.xinly.core.pay.inf.IPayData;

/**
 * Created by zm on 2018/10/24.
 */
public abstract class BasePay<T> implements IPay<T> {
    protected PayCallback mPayCallback;
    protected IPayData<T> mPayData;


    @Override
    public void setPayData(IPayData<T> payData) {
        this.mPayData = payData;
    }

    @Override
    public void setPayCallback(PayCallback callback) {
        this.mPayCallback = callback;
    }

    @Override
    public void pay() {

    }
}
