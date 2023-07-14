package com.canvas.instructure.conversion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.canvas.instructure.dto.AccountDTO;
import com.canvas.instructure.dto.CourseDTO;
import com.canvas.instructure.dto.EnrollmentDTO;
import com.canvas.instructure.entity.Account;
import com.canvas.instructure.entity.Course;
import com.canvas.instructure.entity.Enrollment;

@Component
public class Conversions {
    
    public Account toDAO(AccountDTO accountDTO){
        
        Account account = new Account();
        account.setAccountID(accountDTO.getId());
        account.setName(accountDTO.getName());
        account.setWorkflowState(accountDTO.getWorkflowState());
        account.setParentAccountID(accountDTO.getParentAccountID());
        account.setRootAccountID(accountDTO.getRootAccountID());
        account.setUuid(accountDTO.getUuid());
        account.setDefaultStorageQuotaMb(accountDTO.getDefaultStorageQuotaMb());
        account.setDefaultUserStorageQuotaMb(accountDTO.getDefaultUserStorageQuotaMb());
        account.setDefaultGroupStorageQuotaMb(accountDTO.getDefaultGroupStorageQuotaMb());
        account.setDefaultTimeZone(accountDTO.getDefaultTimeZone());
        return account;
    }

    public Course toCourseDAO(CourseDTO courseDTO){
        
        Course course = new Course();
        course.setAccID(courseDTO.getAccountID());
        course.setCourseID(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setUuid(courseDTO.getUuid());
        course.setStartsAt(courseDTO.getStartsAt());
        course.setGradingStandardID(courseDTO.getGradingStandardID());
        course.setPublic(courseDTO.isPublic());
        course.setCreatedAt(courseDTO.getCreatedAt());
        course.setCourseCode(courseDTO.getCourseCode());
        course.setDefaultView(courseDTO.getDefaultView());
        course.setRootAccountID(courseDTO.getRootAccountID());
        course.setEnrollmentTermID(courseDTO.getEnrollmentTermId());
        course.setLicense(courseDTO.getLicense());
        course.setEndAt(courseDTO.getEndAt());
        course.setPublicSyllabus(courseDTO.isPublicSyllabus());
        course.setPublicSyllabusToAuth(courseDTO.getIsPublicToAuthUsers());
        course.setStorageQuotaMb(courseDTO.getStorageQuotaMb());
        course.setPublicToAuthUsers(courseDTO.getIsPublicToAuthUsers());
        course.setApplyAssignmentGroupWeights(courseDTO.getIsApplyAssignmentGroupWeights());
        course.setTimeZone(courseDTO.getTimeZone());
        course.setBlueprint(courseDTO.isBlueprint());
        course.setSisCourseId(Integer.toString(courseDTO.getSisCourseId()));
        course.setSisImportId(Integer.toString(courseDTO.getSisImportId()));
        course.setIntegrationId(Integer.toString(courseDTO.getIntegrationId()));
        course.setHideFinalGrades(courseDTO.isHideFinalGrades());
        course.setWorkflowState(courseDTO.getWorkflowState());
        course.setRestrictEnrollmentsToCourseDates(courseDTO.getRestrictEnrollmentsToCourseDates());
        List<Enrollment>  enrollments = toEnrollmentDAO(courseDTO.getEnrollments(), course);
        course.setEnrollments(enrollments);
        return course;
    }

    public static List<Enrollment> toEnrollmentDAO(List<EnrollmentDTO> enrollmentDTOs, Course course){
        List<Enrollment> enrollments = new ArrayList<>();
        for(EnrollmentDTO dto : enrollmentDTOs){
            Enrollment enrollment = new Enrollment();
            enrollment.setType(dto.getType());
            enrollment.setRoleID(dto.getRoleId());
            enrollment.setUserID(dto.getUserId());
            enrollment.setEnrollmentState(dto.getEnrollmentState());
            enrollment.setCourse(course);
            enrollments.add(enrollment); 
        }
        return enrollments;
    }

}
