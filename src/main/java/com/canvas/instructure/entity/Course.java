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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Course implements Serializable{
 
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    @Transient
    private int accID;

    @Column(name="name")
    private String name;

    @Column(name="course_id")
    private int courseID;

    @Column(name="uuid")
    private String uuid;

    @Column(name="start_at")
    private String startsAt;

    @Column(name="grading_standard_id")
    private int gradingStandardID;

    @Column(name="is_public")
    private boolean isPublic;

    @Column(name="created_at")
    private String createdAt;

    @Column(name="course_code")
    private String courseCode;

    @Column(name="default_view")
    private String defaultView;

    @Column(name="root_account_id")
    private int rootAccountID;

    @Column(name="enrollment_term_id")
    private int enrollmentTermID;

    @Column(name="license")
    private String license;

    @Column(name="end_at")
    private String endAt;

    @Column(name="public_syllabus")
    private boolean isPublicSyllabus;

    @Column(name="public_syllabus_to_auth")
    private boolean isPublicSyllabusToAuth;

    @Column(name="storage_quota_mb")
    private int storageQuotaMb;

    @Column(name="is_public_to_auth_users")
    private boolean isPublicToAuthUsers;

    @Column(name="apply_assignment_group_weights")
    private boolean applyAssignmentGroupWeights;

    @Column(name="time_zone")
    private String timeZone;

    @Column(name="blueprint")
    private boolean isBlueprint;

    @Column(name="sis_course_id")
    private String sisCourseId;

    @Column(name="sis_import_id")
    private String sisImportId;

    @Column(name="integration_id")
    private String integrationId;

    @Column(name="hide_final_grades")
    private boolean hideFinalGrades;

    @Column(name="workflow_state")
    private String workflowState;

    @Column(name="restrict_enrollments_to_course_dates")
    private boolean restrictEnrollmentsToCourseDates;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="account_id", referencedColumnName = "account_id")
    private Account account;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;

    public Course() {
    }

    public Course(String name, int courseID, String uuid, String startsAt, int gradingStandardID, boolean isPublic, String createdAt,
            String courseCode, String defaultView, int rootAccountID, int enrollmentTermID, String license,
            String endAt, boolean isPublicSyllabus, boolean isPublicSyllabusToAuth, int storageQuotaMb,
            boolean isPublicToAuthUsers, boolean applyAssignmentGroupWeights, String timeZone, boolean isBlueprint,
            String sisCourseId, String sisImportId, String integrationId, boolean hideFinalGrades, String workflowState,
            boolean restrictEnrollmentsToCourseDates, boolean accountID, Account account) {
        this.name = name;
        this.courseID = courseID;
        this.uuid = uuid;
        this.startsAt = startsAt;
        this.gradingStandardID = gradingStandardID;
        this.isPublic = isPublic;
        this.createdAt = createdAt;
        this.courseCode = courseCode;
        this.defaultView = defaultView;
        this.rootAccountID = rootAccountID;
        this.enrollmentTermID = enrollmentTermID;
        this.license = license;
        this.endAt = endAt;
        this.isPublicSyllabus = isPublicSyllabus;
        this.isPublicSyllabusToAuth = isPublicSyllabusToAuth;
        this.storageQuotaMb = storageQuotaMb;
        this.isPublicToAuthUsers = isPublicToAuthUsers;
        this.applyAssignmentGroupWeights = applyAssignmentGroupWeights;
        this.timeZone = timeZone;
        this.isBlueprint = isBlueprint;
        this.sisCourseId = sisCourseId;
        this.sisImportId = sisImportId;
        this.integrationId = integrationId;
        this.hideFinalGrades = hideFinalGrades;
        this.workflowState = workflowState;
        this.restrictEnrollmentsToCourseDates = restrictEnrollmentsToCourseDates;
        this.account = account;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getAccID() {
        return accID;
    }
    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCourseID() {
        return courseID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStartsAt() {
        return startsAt;
    }
    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public int getGradingStandardID() {
        return gradingStandardID;
    }
    public void setGradingStandardID(int gradingStandardID) {
        this.gradingStandardID = gradingStandardID;
    }

    public boolean isPublic() {
        return isPublic;
    }
    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDefaultView() {
        return defaultView;
    }
    public void setDefaultView(String defaultView) {
        this.defaultView = defaultView;
    }

    public int getRootAccountID() {
        return rootAccountID;
    }
    public void setRootAccountID(int rootAccountID) {
        this.rootAccountID = rootAccountID;
    }

    public int getEnrollmentTermID() {
        return enrollmentTermID;
    }
    public void setEnrollmentTermID(int enrollmentTermID) {
        this.enrollmentTermID = enrollmentTermID;
    }

    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }

    public String getEndAt() {
        return endAt;
    }
    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public boolean isPublicSyllabus() {
        return isPublicSyllabus;
    }
    public void setPublicSyllabus(boolean isPublicSyllabus) {
        this.isPublicSyllabus = isPublicSyllabus;
    }

    public boolean isPublicSyllabusToAuth() {
        return isPublicSyllabusToAuth;
    }
    public void setPublicSyllabusToAuth(boolean isPublicSyllabusToAuth) {
        this.isPublicSyllabusToAuth = isPublicSyllabusToAuth;
    }

    public int getStorageQuotaMb() {
        return storageQuotaMb;
    }
    public void setStorageQuotaMb(int storageQuotaMb) {
        this.storageQuotaMb = storageQuotaMb;
    }

    public boolean isPublicToAuthUsers() {
        return isPublicToAuthUsers;
    }
    public void setPublicToAuthUsers(boolean isPublicToAuthUsers) {
        this.isPublicToAuthUsers = isPublicToAuthUsers;
    }

    public boolean isApplyAssignmentGroupWeights() {
        return applyAssignmentGroupWeights;
    }
    public void setApplyAssignmentGroupWeights(boolean applyAssignmentGroupWeights) {
        this.applyAssignmentGroupWeights = applyAssignmentGroupWeights;
    }

    public String getTimeZone() {
        return timeZone;
    }
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isBlueprint() {
        return isBlueprint;
    }
    public void setBlueprint(boolean isBlueprint) {
        this.isBlueprint = isBlueprint;
    }

    public String getSisCourseId() {
        return sisCourseId;
    }
    public void setSisCourseId(String sisCourseId) {
        this.sisCourseId = sisCourseId;
    }

    public String getSisImportId() {
        return sisImportId;
    }
    public void setSisImportId(String sisImportId) {
        this.sisImportId = sisImportId;
    }

    public String getIntegrationId() {
        return integrationId;
    }
    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public boolean isHideFinalGrades() {
        return hideFinalGrades;
    }
    public void setHideFinalGrades(boolean hideFinalGrades) {
        this.hideFinalGrades = hideFinalGrades;
    }

    public String getWorkflowState() {
        return workflowState;
    }
    public void setWorkflowState(String workflowState) {
        this.workflowState = workflowState;
    }

    public boolean isRestrictEnrollmentsToCourseDates() {
        return restrictEnrollmentsToCourseDates;
    }
    public void setRestrictEnrollmentsToCourseDates(boolean restrictEnrollmentsToCourseDates) {
        this.restrictEnrollmentsToCourseDates = restrictEnrollmentsToCourseDates;
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void addEnrollment(Enrollment enrollment){
        if(this.enrollments == null)
            this.enrollments = new ArrayList<>();

        this.enrollments.add(enrollment);
        enrollment.setCourse(this);
    }

    public boolean updateCourse(Course course){
        boolean isChanged=false;
        if(this.name != null && !this.name.equals(course.getName())){
            isChanged = true;
            this.name = course.getName();
        }
        if(this.courseID != course.getCourseID()){
            isChanged = true;
            this.courseID = course.getCourseID();
        }
        if(this.uuid != null && !this.uuid.equals(course.getUuid())){
            isChanged = true;
            this.uuid = course.getUuid();
        }
        if(this.startsAt != null && !this.startsAt.equals(course.getStartsAt())){
            isChanged = true;
            this.startsAt = course.getStartsAt();
        }
        if(this.gradingStandardID != course.getGradingStandardID()){
            isChanged = true;
            this.gradingStandardID = course.getGradingStandardID();
        }
        if(this.isPublic != course.isPublic()){
            isChanged = true;
            this.isPublic = course.isPublic();
        }
        if(this.createdAt != null && !this.createdAt.equals(course.getCreatedAt())){
            isChanged = true;
            this.createdAt = course.getCreatedAt();
        }
        if(this.courseCode != null && !this.courseCode.equals(course.getCourseCode())){
            isChanged = true;
            this.courseCode = course.getCourseCode();
        }
        if(this.defaultView != null && !this.defaultView.equals(course.getDefaultView())){
            isChanged = true;
            this.defaultView = course.getDefaultView();
        }
        if(this.rootAccountID != course.getRootAccountID()){
            isChanged = true;
            this.rootAccountID = course.getRootAccountID();
        }
        if(this.enrollmentTermID != course.getEnrollmentTermID()){
            isChanged = true;
            this.enrollmentTermID = course.getEnrollmentTermID();
        }
        if(this.license != null && !this.license.equals(course.getLicense())){
            isChanged = true;
            this.license = course.getLicense();
        }
        if(this.endAt != null && !this.endAt.equals(course.getEndAt())){
            isChanged = true;
            this.endAt = course.getEndAt();
        }
        if(this.isPublicSyllabus != course.isPublicSyllabus()){
            isChanged = true;
            this.isPublicSyllabus = course.isPublicSyllabus();
        }
        if(this.isPublicSyllabusToAuth != course.isPublicSyllabusToAuth()){
            isChanged = true;
            this.isPublicSyllabusToAuth = course.isPublicSyllabusToAuth();
        }
        if(this.storageQuotaMb != course.getStorageQuotaMb()){
            isChanged = true;
            this.storageQuotaMb = course.getStorageQuotaMb();
        }
        if(this.isPublicToAuthUsers != course.isPublicToAuthUsers()){
            isChanged = true;
            this.isPublicToAuthUsers = course.isPublicToAuthUsers();
        }
        if(this.applyAssignmentGroupWeights != course.isApplyAssignmentGroupWeights()){
            isChanged = true;
            this.applyAssignmentGroupWeights = course.isApplyAssignmentGroupWeights();
        }
        if(this.timeZone != null && !this.timeZone.equals(course.getTimeZone())){
            isChanged = true;
            this.timeZone = course.getTimeZone();
        }
        if(this.isBlueprint != course.isBlueprint()){
            isChanged = true;
            this.isBlueprint = course.isBlueprint();
        }
        if(this.sisCourseId != null && !this.sisCourseId.equals(course.getSisCourseId())){
            isChanged = true;
            this.sisCourseId = course.getSisCourseId();
        }
        if(this.sisImportId != null && !this.sisImportId.equals(course.getSisCourseId())){
            isChanged = true;
            this.sisImportId = course.getSisImportId();
        }
        if(this.integrationId != null && !this.integrationId.equals(course.getIntegrationId())){
            isChanged = true;
            this.integrationId = course.getIntegrationId();
        }
        if(this.hideFinalGrades != course.isHideFinalGrades()){
            isChanged = true;
            this.hideFinalGrades = course.isHideFinalGrades();
        }
        if(this.workflowState != null && !this.workflowState.equals(course.getWorkflowState())){
            isChanged = true;
            this.workflowState = course.getWorkflowState();
        }
        if(this.restrictEnrollmentsToCourseDates != course.isRestrictEnrollmentsToCourseDates()){
            isChanged = true;
            this.restrictEnrollmentsToCourseDates = course.isRestrictEnrollmentsToCourseDates();
        }
        List<Enrollment> enrollments = course.getEnrollments();
        if(this.getEnrollments() != null && enrollments != null && this.getEnrollments().size() != enrollments.size()){
            isChanged = true;
        }
        return isChanged;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", courseID=" + courseID + ", uuid=" + uuid + ", startsAt="
                + startsAt + ", gradingStandardID=" + gradingStandardID + ", isPublic=" + isPublic + ", createdAt="
                + createdAt + ", courseCode=" + courseCode + ", defaultView=" + defaultView + ", rootAccountID="
                + rootAccountID + ", enrollmentTermID=" + enrollmentTermID + ", license=" + license + ", endAt=" + endAt
                + ", isPublicSyllabus=" + isPublicSyllabus + ", isPublicSyllabusToAuth=" + isPublicSyllabusToAuth
                + ", storageQuotaMb=" + storageQuotaMb + ", isPublicToAuthUsers=" + isPublicToAuthUsers
                + ", applyAssignmentGroupWeights=" + applyAssignmentGroupWeights + ", timeZone=" + timeZone
                + ", isBlueprint=" + isBlueprint + ", sisCourseId=" + sisCourseId + ", sisImportId=" + sisImportId
                + ", integrationId=" + integrationId + ", hideFinalGrades=" + hideFinalGrades + ", workflowState="
                + workflowState + ", restrictEnrollmentsToCourseDates=" + restrictEnrollmentsToCourseDates
                + ", account=" + account + "]";
    }    
}
