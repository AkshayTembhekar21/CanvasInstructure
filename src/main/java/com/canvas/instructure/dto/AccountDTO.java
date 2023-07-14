package com.canvas.instructure.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("workflow_state")
    private String workflowState;
    @JsonProperty("parent_account_id")
    private int parentAccountID;
    @JsonProperty("root_account_id")
    private int rootAccountID;
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("default_storage_quota_mb")
    private int defaultStorageQuotaMb;
    @JsonProperty("default_user_storage_quota_mb")
    private int defaultUserStorageQuotaMb;
    @JsonProperty("default_group_storage_quota_mb")
    private int defaultGroupStorageQuotaMb;
    @JsonProperty("default_time_zone")
    private String defaultTimeZone;

    public AccountDTO() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getWorkflowState() {
        return workflowState;
    }
    public void setWorkflowState(String workflowState) {
        this.workflowState = workflowState;
    }

    public int getParentAccountID() {
        return parentAccountID;
    }
    public void setParentAccountID(int parentAccountID) {
        this.parentAccountID = parentAccountID;
    }

    public int getRootAccountID() {
        return rootAccountID;
    }
    public void setRootAccountID(int rootAccountID) {
        this.rootAccountID = rootAccountID;
    }

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getDefaultStorageQuotaMb() {
        return defaultStorageQuotaMb;
    }
    public void setDefaultStorageQuotaMb(int defaultStorageQuotaMb) {
        this.defaultStorageQuotaMb = defaultStorageQuotaMb;
    }

    public int getDefaultUserStorageQuotaMb() {
        return defaultUserStorageQuotaMb;
    }
    public void setDefaultUserStorageQuotaMb(int defaultUserStorageQuotaMb) {
        this.defaultUserStorageQuotaMb = defaultUserStorageQuotaMb;
    }

    public int getDefaultGroupStorageQuotaMb() {
        return defaultGroupStorageQuotaMb;
    }
    public void setDefaultGroupStorageQuotaMb(int defaultGroupStorageQuotaMb) {
        this.defaultGroupStorageQuotaMb = defaultGroupStorageQuotaMb;
    }

    public String getDefaultTimeZone() {
        return defaultTimeZone;
    }
    public void setDefaultTimeZone(String defaultTimeZone) {
        this.defaultTimeZone = defaultTimeZone;
    }

    @Override
    public String toString() {
        return "AccountDTO [id=" + id + ", name=" + name + ", workflowState=" + workflowState + ", parentAccountID="
                + parentAccountID + ", rootAccountID=" + rootAccountID + ", uuid=" + uuid + ", defaultStorageQuotaMb="
                + defaultStorageQuotaMb + ", defaultUserStorageQuotaMb=" + defaultUserStorageQuotaMb
                + ", defaultGroupStorageQuotaMb=" + defaultGroupStorageQuotaMb + ", defaultTimeZone=" + defaultTimeZone
                + "]";
    }
}
