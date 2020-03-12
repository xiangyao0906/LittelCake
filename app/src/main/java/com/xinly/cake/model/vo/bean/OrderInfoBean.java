package com.xinly.cake.model.vo.bean;

/**
 * @author xiangyao
 * @create 2019-12-07 15:06
 */
public class OrderInfoBean {


    private String orderId;
    private String symbolFrom;
    private String symbolTo;
    private double sellNum;
    private double buyNum;
    private double exchangeRate;
    private long createTime;
    private int status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSymbolFrom() {
        return symbolFrom;
    }

    public void setSymbolFrom(String symbolFrom) {
        this.symbolFrom = symbolFrom;
    }

    public String getSymbolTo() {
        return symbolTo;
    }

    public void setSymbolTo(String symbolTo) {
        this.symbolTo = symbolTo;
    }

    public double getSellNum() {
        return sellNum;
    }

    public void setSellNum(double sellNum) {
        this.sellNum = sellNum;
    }

    public double getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(double buyNum) {
        this.buyNum = buyNum;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
