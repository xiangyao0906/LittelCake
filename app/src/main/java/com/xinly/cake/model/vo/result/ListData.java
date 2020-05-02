package com.xinly.cake.model.vo.result;

import java.util.ArrayList;

/**
 * Created by zm on 2019-11-26.
 */
public class ListData<T> {

    private ArrayList<T> itemList;

    public ArrayList<T> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<T> itemList) {
        this.itemList = itemList;
    }
}
