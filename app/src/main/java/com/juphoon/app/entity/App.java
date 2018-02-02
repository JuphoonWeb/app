package com.juphoon.app.entity;

import java.io.Serializable;
import java.util.Date;

public class App implements Serializable {
    private Integer id;

    private String appName;

    private Integer appType;

    private String appId;

    private String versionName;

    private String versionCode;

    private String updateInstructions;

    private String downloadFileUrl;

    private String downloadPageUrl;

    private Integer mandatoryUpdate;

    private Date createTime;

    private Date changeTime;

    private String fileSize;

    private Integer appEnablePassword;

    private String appPassword;

    private String logUrl;

    private String downloadPageUrlSuffix;

    private static final long serialVersionUID = 1L;

    public App(Integer id, String appName, Integer appType, String appId, String versionName, String versionCode, String updateInstructions, String downloadFileUrl, String downloadPageUrl, Integer mandatoryUpdate, Date createTime, Date changeTime, String fileSize, Integer appEnablePassword, String appPassword, String logUrl, String downloadPageUrlSuffix) {
        this.id = id;
        this.appName = appName;
        this.appType = appType;
        this.appId = appId;
        this.versionName = versionName;
        this.versionCode = versionCode;
        this.updateInstructions = updateInstructions;
        this.downloadFileUrl = downloadFileUrl;
        this.downloadPageUrl = downloadPageUrl;
        this.mandatoryUpdate = mandatoryUpdate;
        this.createTime = createTime;
        this.changeTime = changeTime;
        this.fileSize = fileSize;
        this.appEnablePassword = appEnablePassword;
        this.appPassword = appPassword;
        this.logUrl = logUrl;
        this.downloadPageUrlSuffix = downloadPageUrlSuffix;
    }

    public App() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode == null ? null : versionCode.trim();
    }

    public String getUpdateInstructions() {
        return updateInstructions;
    }

    public void setUpdateInstructions(String updateInstructions) {
        this.updateInstructions = updateInstructions == null ? null : updateInstructions.trim();
    }

    public String getDownloadFileUrl() {
        return downloadFileUrl;
    }

    public void setDownloadFileUrl(String downloadFileUrl) {
        this.downloadFileUrl = downloadFileUrl == null ? null : downloadFileUrl.trim();
    }

    public String getDownloadPageUrl() {
        return downloadPageUrl;
    }

    public void setDownloadPageUrl(String downloadPageUrl) {
        this.downloadPageUrl = downloadPageUrl == null ? null : downloadPageUrl.trim();
    }

    public Integer getMandatoryUpdate() {
        return mandatoryUpdate;
    }

    public void setMandatoryUpdate(Integer mandatoryUpdate) {
        this.mandatoryUpdate = mandatoryUpdate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    public Integer getAppEnablePassword() {
        return appEnablePassword;
    }

    public void setAppEnablePassword(Integer appEnablePassword) {
        this.appEnablePassword = appEnablePassword;
    }

    public String getAppPassword() {
        return appPassword;
    }

    public void setAppPassword(String appPassword) {
        this.appPassword = appPassword == null ? null : appPassword.trim();
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl == null ? null : logUrl.trim();
    }

    public String getDownloadPageUrlSuffix() {
        return downloadPageUrlSuffix;
    }

    public void setDownloadPageUrlSuffix(String downloadPageUrlSuffix) {
        this.downloadPageUrlSuffix = downloadPageUrlSuffix == null ? null : downloadPageUrlSuffix.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        App other = (App) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
            && (this.getAppType() == null ? other.getAppType() == null : this.getAppType().equals(other.getAppType()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getVersionName() == null ? other.getVersionName() == null : this.getVersionName().equals(other.getVersionName()))
            && (this.getVersionCode() == null ? other.getVersionCode() == null : this.getVersionCode().equals(other.getVersionCode()))
            && (this.getUpdateInstructions() == null ? other.getUpdateInstructions() == null : this.getUpdateInstructions().equals(other.getUpdateInstructions()))
            && (this.getDownloadFileUrl() == null ? other.getDownloadFileUrl() == null : this.getDownloadFileUrl().equals(other.getDownloadFileUrl()))
            && (this.getDownloadPageUrl() == null ? other.getDownloadPageUrl() == null : this.getDownloadPageUrl().equals(other.getDownloadPageUrl()))
            && (this.getMandatoryUpdate() == null ? other.getMandatoryUpdate() == null : this.getMandatoryUpdate().equals(other.getMandatoryUpdate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getChangeTime() == null ? other.getChangeTime() == null : this.getChangeTime().equals(other.getChangeTime()))
            && (this.getFileSize() == null ? other.getFileSize() == null : this.getFileSize().equals(other.getFileSize()))
            && (this.getAppEnablePassword() == null ? other.getAppEnablePassword() == null : this.getAppEnablePassword().equals(other.getAppEnablePassword()))
            && (this.getAppPassword() == null ? other.getAppPassword() == null : this.getAppPassword().equals(other.getAppPassword()))
            && (this.getLogUrl() == null ? other.getLogUrl() == null : this.getLogUrl().equals(other.getLogUrl()))
            && (this.getDownloadPageUrlSuffix() == null ? other.getDownloadPageUrlSuffix() == null : this.getDownloadPageUrlSuffix().equals(other.getDownloadPageUrlSuffix()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getAppType() == null) ? 0 : getAppType().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getVersionName() == null) ? 0 : getVersionName().hashCode());
        result = prime * result + ((getVersionCode() == null) ? 0 : getVersionCode().hashCode());
        result = prime * result + ((getUpdateInstructions() == null) ? 0 : getUpdateInstructions().hashCode());
        result = prime * result + ((getDownloadFileUrl() == null) ? 0 : getDownloadFileUrl().hashCode());
        result = prime * result + ((getDownloadPageUrl() == null) ? 0 : getDownloadPageUrl().hashCode());
        result = prime * result + ((getMandatoryUpdate() == null) ? 0 : getMandatoryUpdate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getChangeTime() == null) ? 0 : getChangeTime().hashCode());
        result = prime * result + ((getFileSize() == null) ? 0 : getFileSize().hashCode());
        result = prime * result + ((getAppEnablePassword() == null) ? 0 : getAppEnablePassword().hashCode());
        result = prime * result + ((getAppPassword() == null) ? 0 : getAppPassword().hashCode());
        result = prime * result + ((getLogUrl() == null) ? 0 : getLogUrl().hashCode());
        result = prime * result + ((getDownloadPageUrlSuffix() == null) ? 0 : getDownloadPageUrlSuffix().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appName=").append(appName);
        sb.append(", appType=").append(appType);
        sb.append(", appId=").append(appId);
        sb.append(", versionName=").append(versionName);
        sb.append(", versionCode=").append(versionCode);
        sb.append(", updateInstructions=").append(updateInstructions);
        sb.append(", downloadFileUrl=").append(downloadFileUrl);
        sb.append(", downloadPageUrl=").append(downloadPageUrl);
        sb.append(", mandatoryUpdate=").append(mandatoryUpdate);
        sb.append(", createTime=").append(createTime);
        sb.append(", changeTime=").append(changeTime);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", appEnablePassword=").append(appEnablePassword);
        sb.append(", appPassword=").append(appPassword);
        sb.append(", logUrl=").append(logUrl);
        sb.append(", downloadPageUrlSuffix=").append(downloadPageUrlSuffix);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


}