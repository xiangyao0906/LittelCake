package com.xinly.cake.model.vo.bean;

/**
 * @author xiangyao
 * @create 2019-12-02 09:36
 */
public class RadBean {
    /**
     * blockHeight : 9000
     * content :
     * price : 50
     * status : true
     * id : 20
     */
    private int id;
    private int blockHeight;
    private int price;
    private String content;
    private long planTime;
    private boolean status;
    private int exhibitionNum;
    private boolean isSelected;
    private int lastPrice;
    private boolean isBidding;

    public boolean isBidding() {
        return isBidding;
    }

    public void setBidding(boolean bidding) {
        isBidding = bidding;
    }

    public int getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(int lastPrice) {
        this.lastPrice = lastPrice;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getExhibitionNum() {
        return exhibitionNum;
    }

    public void setExhibitionNum(int exhibitionNum) {
        this.exhibitionNum = exhibitionNum;
    }



    public long getPlanTime() {
        return planTime;
    }

    public void setPlanTime(long planTime) {
        this.planTime = planTime;
    }

    public int getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(int blockHeight) {
        this.blockHeight = blockHeight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
