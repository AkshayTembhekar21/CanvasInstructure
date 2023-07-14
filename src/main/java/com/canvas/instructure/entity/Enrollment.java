package com.canvas.instructure.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Enrollment implements Serializable{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    @Column(name="type")
    private String type;

    @Column(name="role_id")
    private int roleID;

    @Column(name="user_id")
    private int userID;

    @Column(name="enrollment_state")
    private String enrollmentState;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="course_id", referencedColumnName = "course_id")
    private Course course;

    public Enrollment() {
    }

    public Enrollment(String type, int roleID, int userID, String enrollmentState, Course course) {
        this.type = type;
        this.roleID = roleID;
        this.userID = userID;
        this.enrollmentState = enrollmentState;
        this.course = course;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getRoleID() {
        return roleID;
    }
    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEnrollmentState() {
        return enrollmentState;
    }
    public void setEnrollmentState(String enrollmentState) {
        this.enrollmentState = enrollmentState;
    }

    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enrollment [id=" + id + ", type=" + type + ", roleID=" + roleID + ", userID=" + userID
                + ", enrollmentState=" + enrollmentState + "]";
    }
}
