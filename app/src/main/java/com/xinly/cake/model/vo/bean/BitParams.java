package com.xinly.cake.model.vo.bean;

import java.io.Serializable;

/**
 * @author xiangyao
 * @create 2019-12-03 17:28
 */
public class BitParams implements Serializable {
    private int tierRatio;
    private double refundWallet;
    private double refundPool;
    private double refundFreeze;

    public BitParams(int tierRatio, double refundWallet, double refundPool, double refundFreeze) {
        this.tierRatio = tierRatio;
        this.refundWallet = refundWallet;
        this.refundPool = refundPool;
        this.refundFreeze = refundFreeze;
    }

    public int getTierRatio() {
        return tierRatio;
    }

    public void setTierRatio(int tierRatio) {
        this.tierRatio = tierRatio;
    }

    public double getRefundWallet() {
        return refundWallet;
    }

    public void setRefundWallet(double refundWallet) {
        this.refundWallet = refundWallet;
    }

    public double getRefundPool() {
        return refundPool;
    }

    public void setRefundPool(double refundPool) {
        this.refundPool = refundPool;
    }

    public double getRefundFreeze() {
        return refundFreeze;
    }

    public void setRefundFreeze(double refundFreeze) {
        this.refundFreeze = refundFreeze;
    }
}
