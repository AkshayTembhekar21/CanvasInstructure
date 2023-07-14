package com.canvas.instructure.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.canvas.instructure.controller.HomeController;
import com.canvas.instructure.conversion.Conversions;
import com.canvas.instructure.dao.CourseDAO;
import com.canvas.instructure.dto.CourseDTO;
import com.canvas.instructure.entity.Account;
import com.canvas.instructure.entity.Course;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CourseService {
    
    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private Conversions conversions;

    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);

    public void saveCourses(){
        String courseUrl = "http://3.231.151.15/api/v1/courses";
        String accessToken = HomeController.accessToken;
        RestTemplate restTemplate = new RestTemplate(); 

        HttpHeaders headers = new HttpHeaders();
        UriComponentsBuilder courseBuilder = UriComponentsBuilder.fromHttpUrl(courseUrl)
                .queryParam("access_token", accessToken);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        String apiEndpoint = courseBuilder.toUriString();
        List<Course> courses = new ArrayList<>();
        try{
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiEndpoint, String.class, headers);
            String responseBody = responseEntity.getBody();
            logger.info("courses from canvas - ",responseBody);
            
            ObjectMapper objectMapper = new ObjectMapper();
            CourseDTO[] courseDTO = objectMapper.readValue(responseBody, CourseDTO[].class);
            for(CourseDTO dto : courseDTO){
                logger.debug("Converting Course DTO to Course Entity");
                Course course = conversions.toCourseDAO(dto);
                courses.add(course);
            }
        }catch(Exception ex){
            logger.error("http://3.231.151.15/api/v1/courses", ex.getMessage());
        }

        if(!courses.isEmpty()){
            logger.info("Courses are not empty: Saving Courses.");
            courseDAO.saveCourses(courses);
        }
    }
}
