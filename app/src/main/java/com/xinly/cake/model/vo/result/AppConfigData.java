package com.xinly.cake.model.vo.result;

import com.xinly.cake.model.vo.bean.VersionBean;

import java.util.List;

/**
 * Created by zm on 2019-11-25.
 */
public class AppConfigData {
    //版本信息
    private VersionBean version;
    //钱包设置
    private AppSettingsData setting;

    private StatisBean statis;

    public StatisBean getStatis() {
        return statis;
    }

    public void setStatis(StatisBean statis) {
        this.statis = statis;
    }

    public AppSettingsData getSetting() {
        return setting;
    }

    public void setSetting(AppSettingsData setting) {
        this.setting = setting;
    }

    public VersionBean getVersion() {
        return version;
    }

    public void setVersion(VersionBean version) {
        this.version = version;
    }


    public static class StatisBean {
        double invite;
        String mine;
        double power;

        public double getInvite() {
            return invite;
        }

        public void setInvite(double invite) {
            this.invite = invite;
        }

        public String getMine() {
            return mine;
        }

        public void setMine(String mine) {
            this.mine = mine;
        }

        public double getPower() {
            return power;
        }

        public void setPower(double power) {
            this.power = power;
        }
    }
}
