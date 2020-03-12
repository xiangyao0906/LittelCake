package com.xinly.cake.model.vo.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zm on 2020-02-11.
 */
public class UnSpentUtxo implements Serializable {
    @SerializedName("txid")
    private String hash;//交易hash
    @SerializedName("n")
    private long txN;
    @SerializedName("amount")
    private double value;//金额
    private int height;//区块高度
    private String script = "76a914357337f2b939f6bc174592772b2ebad5e2e60a8988ac";//hex

    public long getTxN() {
        return txN;
    }

    public void setTxN(long txN) {
        this.txN = txN;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
