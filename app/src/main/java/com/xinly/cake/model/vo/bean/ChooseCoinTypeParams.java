package com.xinly.cake.model.vo.bean;

import java.io.Serializable;

/**
 * @author xiangyao
 * @create 2019-11-27 17:41
 */
public class ChooseCoinTypeParams implements Serializable {
    private int type;//0充币 1提币
    private String chooseName;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getChooseName() {
        return chooseName;
    }

    public void setChooseName(String chooseName) {
        this.chooseName = chooseName;
    }

    public ChooseCoinTypeParams(int type) {
        this.type = type;
    }
}
