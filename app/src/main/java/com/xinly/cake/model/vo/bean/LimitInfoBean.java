package com.xinly.cake.model.vo.bean;

/**
 * @author xiangyao
 * @create 2019-11-28 15:04
 */
public class LimitInfoBean {
    /**
     * min : 0.01
     * tax : 5.0E-4
     * num : 0
     * daily : 100
     * remain : 100
     */

    private double min;
    private double tax;
    private double num;
    private double daily;
    private double remain;

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {

        this.tax = tax;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public double getDaily() {
        return daily;
    }

    public void setDaily(double daily) {
        this.daily = daily;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }
}
