package com.canvas.instructure.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account implements Serializable{
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    @Column(name="account_id")
    private int accountID;

    @Column(name="name")
    private String name;

    @Column(name="workflow_state")
    private String workflowState;

    @Column(name="parent_account_id")
    private int parentAccountID;

    @Column(name="root_account_id")
    private int rootAccountID;

    @Column(name="uuid")
    private String uuid;

    @Column(name="default_storage_quota_mb")
    private int defaultStorageQuotaMb;

    @Column(name="default_user_storage_quota_mb")
    private int defaultUserStorageQuotaMb;

    @Column(name="default_group_storage_quota_mb")
    private int defaultGroupStorageQuotaMb;

    @Column(name="default_time_zone")
    private String defaultTimeZone;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<Course> courses;

    public Account() {
    }

    public Account(int accountID, String name, String workflowState, int parentAccountID, int rootAccountID,
            String uuid, int defaultStorageQuotaMb, int defaultUserStorageQuotaMb, int defaultGroupStorageQuotaMb,
            String defaultTimeZone) {
        this.accountID = accountID;
        this.name = name;
        this.workflowState = workflowState;
        this.parentAccountID = parentAccountID;
        this.rootAccountID = rootAccountID;
        this.uuid = uuid;
        this.defaultStorageQuotaMb = defaultStorageQuotaMb;
        this.defaultUserStorageQuotaMb = defaultUserStorageQuotaMb;
        this.defaultGroupStorageQuotaMb = defaultGroupStorageQuotaMb;
        this.defaultTimeZone = defaultTimeZone;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getAccountID() {
        return accountID;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
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

    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        if(this.courses == null)
            this.courses = new ArrayList<>();

        this.courses.add(course);
        course.setAccount(this);
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", accountID=" + accountID + ", name=" + name + ", workflowState=" + workflowState
                + ", parentAccountID=" + parentAccountID + ", rootAccountID=" + rootAccountID + ", uuid=" + uuid
                + ", defaultStorageQuotaMb=" + defaultStorageQuotaMb + ", defaultUserStorageQuotaMb="
                + defaultUserStorageQuotaMb + ", defaultGroupStorageQuotaMb=" + defaultGroupStorageQuotaMb
                + ", defaultTimeZone=" + defaultTimeZone + "]";
    }

    public boolean updateAccount(Account account){
        boolean isChangeDetected = false;
        if(account.getAccountID() != this.getAccountID()){
            this.setAccountID(account.getAccountID());
            isChangeDetected = true;
        }
        if(!account.getName().equals( this.getName())){
            this.setName(account.getName());
            isChangeDetected = true;
        }
        if(!account.getWorkflowState().equals( this.getWorkflowState())){
            this.setWorkflowState(account.getWorkflowState());
            isChangeDetected = true;
        }
        if(account.getParentAccountID() != this.getParentAccountID()){
            this.setParentAccountID(account.getParentAccountID());
            isChangeDetected = true;
        }
        if(account.getRootAccountID() != this.getRootAccountID()){
            this.setRootAccountID(account.getRootAccountID());
            isChangeDetected = true;
        }
        if(!account.getUuid().equals( this.getUuid())){
            this.setUuid(account.getUuid());
            isChangeDetected = true;
        }
        if(account.getDefaultStorageQuotaMb() != this.getDefaultStorageQuotaMb()){
            this.setDefaultStorageQuotaMb(account.getDefaultStorageQuotaMb());
            isChangeDetected = true;
        }
        if(account.getDefaultUserStorageQuotaMb() != this.getDefaultUserStorageQuotaMb()){
            this.setDefaultUserStorageQuotaMb(account.getDefaultUserStorageQuotaMb());
            isChangeDetected = true;
        }
        if(account.getDefaultGroupStorageQuotaMb() != this.getDefaultGroupStorageQuotaMb()){
            this.setDefaultGroupStorageQuotaMb(account.getDefaultGroupStorageQuotaMb());
            isChangeDetected = true;
        }
        if(!account.getDefaultTimeZone().equals( this.getDefaultTimeZone())){
            this.setDefaultTimeZone(account.getDefaultTimeZone());
            isChangeDetected = true;
        }
        return isChangeDetected;
    }
}
