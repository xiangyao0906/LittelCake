package com.xinly.cake.model.vo.bean;

import com.google.gson.Gson;

/**
 * Created by zm on 2019-08-19.
 */
public class VersionData {
    private String url;
    private String updateMessage;
    private int versionCode;

    private VersionData(Builder builder) {
        url = builder.url;
        updateMessage = builder.updateMessage;
        versionCode = builder.versionCode;
    }

    public static final class Builder {
        private String url;
        private String updateMessage;
        private int versionCode;

        public Builder() {
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public Builder updateMessage(String val) {
            updateMessage = val;
            return this;
        }

        public Builder versionCode(int val) {
            versionCode = val;
            return this;
        }

        public VersionData build() {
            return new VersionData(this);
        }
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
