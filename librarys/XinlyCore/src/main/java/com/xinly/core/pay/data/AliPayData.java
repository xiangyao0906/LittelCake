package com.xinly.core.pay.data;

import android.text.TextUtils;
import com.xinly.core.pay.PayData;
import com.xinly.core.pay.inf.IPayData;

/**
 * Created by zm on 2018/10/24.
 */
public class AliPayData implements IPayData<AliPayData> {
    public String sign;

    public AliPayData(PayData payData) {
        initPayData(payData);
    }

    /**
     *
     * @param payData
     */
    private void initPayData(PayData payData) {
        this.sign = payData.getSign();
    }

    @Override
    public AliPayData getPayData() {
        return this;
    }

    @Override
    public boolean checkPayData() {
        if (TextUtils.isEmpty(sign)){
            return false;
        }
        return true;
    }
}
