package com.xinly.cake.model.vo.bean;

/**
 * @author xiangyao
 * @create 2019-12-09 09:52
 */
public class QuetesBean {


    private String symbolFrom;
    private String symbolTo;
    private double num;
    private double price;
    private String range;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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


    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
