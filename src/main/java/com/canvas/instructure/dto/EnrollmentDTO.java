package com.canvas.instructure.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnrollmentDTO {

    private String type;
    private String role;
    @JsonProperty("role_id")
    private int roleId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("enrollment_state")
    private String enrollmentState;
    
    public EnrollmentDTO() {
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEnrollmentState() {
        return enrollmentState;
    }
    public void setEnrollmentState(String enrollmentState) {
        this.enrollmentState = enrollmentState;
    }

    @Override
    public String toString() {
        return "EnrollmentDTO [type=" + type + ", role=" + role + ", roleId=" + roleId + ", userId=" + userId
                + ", enrollmentState=" + enrollmentState + "]";
    }    
}
