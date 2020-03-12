package com.xinly.cake.model.vo.bean;


/**
 * @author xiangyao
 * @create 2019-12-03 16:31
 */
public class BitResultBean {


    private String txid;
    private boolean success;
    private double ratio;

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

}
