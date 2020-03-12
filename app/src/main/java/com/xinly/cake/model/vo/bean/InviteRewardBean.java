package com.xinly.cake.model.vo.bean;

/**
 * Created by zm on 2019-11-28.
 */
public class InviteRewardBean {

    private String rid; //RID
    private int tier; //层级
    private double reward; //奖励
    private long time; //时间

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
