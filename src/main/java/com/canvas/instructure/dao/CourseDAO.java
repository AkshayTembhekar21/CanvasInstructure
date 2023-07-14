package com.canvas.instructure.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.canvas.instructure.entity.Account;
import com.canvas.instructure.entity.Course;

@Repository
public class CourseDAO {
    
    @Autowired
    SessionFactory factory;

    private static final Logger logger = LoggerFactory.getLogger(CourseDAO.class);

    @Transactional
    public void saveCourses(List<Course> courses){
        Session session = factory.openSession();
        try {   
            String hql = "FROM Course course WHERE course.courseID = :columnValue";
            for(Course course: courses){
                logger.debug("Inside saveCourses - DAO - Fectching the saved Course object.");
                Course dbCourse = session.createQuery(hql, Course.class)
                        .setParameter("columnValue", course.getCourseID())
                        .uniqueResult();
                String accountQuery = "FROM Account acc WHERE acc.accountID = :columnValue";
                Account account = session.createQuery(accountQuery, Account.class)
                            .setParameter("columnValue", course.getAccID())
                            .uniqueResult();
                if(dbCourse == null){
                    logger.info("Creating a new Course Object");
                    course.setAccount(account);
                    session.save(course);
                    logger.info("Course having courseID: "+course.getCourseID()+" has been saved");
                }else{
                    if(dbCourse.updateCourse(course)){
                        logger.info("Updating the Course object with new values");
                        if(account != null){
                            dbCourse.setAccount(account);
                        }
                        session.update(dbCourse);
                        logger.info("Course having courseID: "+course.getCourseID()+" has been updated");
                    }
                }
            }
		} catch (DataAccessException ex) {
			logger.error("Saving/Updating Course and Enrollments ", ex.getMessage());
		}
    }

}
