package com.xinly.cake.model.vo.bean;


public class CollisionRadioBean {

    private int ratio;
    private double totalBtc;
    private double totalRec;
    private double remainRec;
    private int progress;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public double getTotalBtc() {
        return totalBtc;
    }

    public void setTotalBtc(double totalBtc) {
        this.totalBtc = totalBtc;
    }

    public double getTotalRec() {
        return totalRec;
    }

    public void setTotalRec(double totalRec) {
        this.totalRec = totalRec;
    }

    public double getRemainRec() {
        return remainRec;
    }

    public void setRemainRec(double remainRec) {
        this.remainRec = remainRec;
    }
}
