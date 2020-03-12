package com.xinly.cake.model.vo.bean;

import java.io.Serializable;

/**
 * @author xiangyao
 * @create 2019-12-02 11:12
 */
public class RadUpLoadBean implements Serializable {
    private String title;
    private String content;
    private String receiveAddress;
    private String walletAddress;
    private String venusQrCode;
    private String marsQrCode;
    private int rid;

    //
    private int blockHeight;
    private int price;
    private boolean isSelected;
    private long id;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }



    public String getVenusQrCode() {
        return venusQrCode;
    }

    public void setVenusQrCode(String venusQrCode) {
        this.venusQrCode = venusQrCode;
    }

    public String getMarsQrCode() {
        return marsQrCode;
    }

    public void setMarsQrCode(String marsQrCode) {
        this.marsQrCode = marsQrCode;
    }

    public int getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(int blockHeight) {
        this.blockHeight = blockHeight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
