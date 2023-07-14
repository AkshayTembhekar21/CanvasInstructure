package com.canvas.instructure.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("account_id")
    private int accountID;
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("start_at")
    private String startsAt;
    @JsonProperty("grading_standard_id")
    private int gradingStandardID;
    @JsonProperty("is_public")
    private boolean isPublic;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("course_code")
    private String courseCode;
    @JsonProperty("default_view")
    private String defaultView;
    @JsonProperty("root_account_id")
    private int rootAccountID;
    @JsonProperty("enrollment_term_id")
    private int enrollmentTermId;
    @JsonProperty("license")
    private String license;
    @JsonProperty("end_at")
    private String endAt;
    @JsonProperty("public_syllabus")
    private boolean isPublicSyllabus;
    @JsonProperty("public_syllabus_to_auth")
    private boolean isPublicSyllabusToAuth;
    @JsonProperty("storage_quota_mb")
    private int storageQuotaMb;
    @JsonProperty("is_public_to_auth_users")
    private boolean isPublicToAuthUsers;
    @JsonProperty("apply_assignment_group_weights")
    private boolean isApplyAssignmentGroupWeights;
    @JsonProperty("time_zone")
    private String timeZone;
    @JsonProperty("blueprint")
    private boolean blueprint;
    @JsonProperty("sis_course_id")
    private int sisCourseId;
    @JsonProperty("sis_import_id")
    private int sisImportId;
    @JsonProperty("integration_id")
    private int integrationId;
    @JsonProperty("hide_final_grades")
    private boolean hideFinalGrades;
    @JsonProperty("workflow_state")
    private String workflowState;
    @JsonProperty("restrict_enrollments_to_course_dates")
    private boolean restrictEnrollmentsToCourseDates;
    private List<EnrollmentDTO> enrollments;
    
    public CourseDTO() {
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

    public int getAccountID() {
        return accountID;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
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

    public int getEnrollmentTermId() {
        return enrollmentTermId;
    }
    public void setEnrollmentTermId(int enrollmentTermId) {
        this.enrollmentTermId = enrollmentTermId;
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

    public boolean getIsPublicToAuthUsers() {
        return isPublicToAuthUsers;
    }
    public void setIsPublicToAuthUsers(boolean isPublicToAuthUsers) {
        this.isPublicToAuthUsers = isPublicToAuthUsers;
    }

    public boolean getIsApplyAssignmentGroupWeights() {
        return isApplyAssignmentGroupWeights;
    }
    public void setIsApplyAssignmentGroupWeights(boolean isApplyAssignmentGroupWeights) {
        this.isApplyAssignmentGroupWeights = isApplyAssignmentGroupWeights;
    }

    public String getTimeZone() {
        return timeZone;
    }
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isBlueprint() {
        return blueprint;
    }
    public void setBlueprint(boolean blueprint) {
        this.blueprint = blueprint;
    }

    public int getSisCourseId() {
        return sisCourseId;
    }
    public void setSisCourseId(int sisCourseId) {
        this.sisCourseId = sisCourseId;
    }

    public int getSisImportId() {
        return sisImportId;
    }
    public void setSisImportId(int sisImportId) {
        this.sisImportId = sisImportId;
    }

    public int getIntegrationId() {
        return integrationId;
    }
    public void setIntegrationId(int integrationId) {
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

    public boolean getRestrictEnrollmentsToCourseDates() {
        return restrictEnrollmentsToCourseDates;
    }
    public void setRestrictEnrollmentsToCourseDates(boolean restrictEnrollmentsToCourseDates) {
        this.restrictEnrollmentsToCourseDates = restrictEnrollmentsToCourseDates;
    }

    public List<EnrollmentDTO> getEnrollments() {
        return enrollments;
    }
    public void setEnrollments(List<EnrollmentDTO> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "CourseDTO [id=" + id + ", name=" + name + ", accountID=" + accountID + ", uuid=" + uuid + ", startsAt="
                + startsAt + ", gradingStandardID=" + gradingStandardID + ", isPublic=" + isPublic + ", createdAt="
                + createdAt + ", courseCode=" + courseCode + ", defaultView=" + defaultView + ", rootAccountID="
                + rootAccountID + ", enrollmentTermId=" + enrollmentTermId + ", license=" + license + ", endAt=" + endAt
                + ", isPublicSyllabus=" + isPublicSyllabus + ", isPublicSyllabusToAuth=" + isPublicSyllabusToAuth
                + ", storageQuotaMb=" + storageQuotaMb + ", isPublicToAuthUsers=" + isPublicToAuthUsers
                + ", isApplyAssignmentGroupWeights=" + isApplyAssignmentGroupWeights + ", timeZone=" + timeZone
                + ", blueprint=" + blueprint + ", sisCourseId=" + sisCourseId + ", sisImportId=" + sisImportId
                + ", integrationId=" + integrationId + ", hideFinalGrades=" + hideFinalGrades + ", workflowState="
                + workflowState + ", restrictEnrollmentsToCourseDates=" + restrictEnrollmentsToCourseDates
                + ", enrollments=" + enrollments + "]";
    }    
}
