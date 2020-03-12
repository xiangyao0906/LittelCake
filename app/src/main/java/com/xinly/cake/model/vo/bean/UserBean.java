package com.xinly.cake.model.vo.bean;

/**
 * Created by zm on 2019-11-04.
 */
public class UserBean implements Cloneable{

    public String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserBean clone() throws CloneNotSupportedException {
        return (UserBean)super.clone();
    }

    public UserBean updateSelf(UserBean userBean) {
        return this;
    }
}
