package com.xinly.cake.model.vo.bean;

import java.io.Serializable;

/**
 * @author xiangyao
 * @create 2019-11-26 16:17
 */
public class LogBean implements Serializable {
    /**
     * id : 1
     * num : 836680.7183733
     * status : 0
     * time : 1574756098793
     */

    private int id;
    private double num;
    private int status;
    private long time;
    private int tradeType;
    private String address;
    private String url;
    private int type;
    private String txid;

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTradeType() {
        return tradeType;
    }

    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
