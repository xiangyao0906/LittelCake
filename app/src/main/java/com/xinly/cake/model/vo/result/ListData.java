package com.xinly.cake.model.vo.result;

import java.util.ArrayList;

/**
 * Created by zm on 2019-11-26.
 */
public class ListData<T> {

    private ArrayList<T> list;

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }
}
