package com.xinly.cake.model.vo.bean;

/**
 * @author xiangyao
 * @create 2019-11-26 13:56
 */
public class CurrencyBean {
    /**
     * type : CNY
     * ratio : 7.0353
     * tag : ￥
     */

    private String type;
    private double ratio;
    private String tag;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
