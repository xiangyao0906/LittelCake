package com.xinly.cake.model.vo.bean;

/**
 * 版本信息实体类
 * <p>
 * Created by zm on 2019-11-25.
 */
public class VersionBean {

    private String title;
    private String version;
    private String url;
    private String content;
    private long createTime;
    private boolean isForce;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public boolean isIsForce() {
        return isForce;
    }

    public void setIsForce(boolean isForce) {
        this.isForce = isForce;
    }

    public int getVersionCode() {
        return Integer.valueOf(version.replace(".",""));
    }
}
