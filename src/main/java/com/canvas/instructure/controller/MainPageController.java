package com.canvas.instructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.canvas.instructure.service.AccountsService;
import com.canvas.instructure.service.CourseService;

@Controller
public class MainPageController {
    @Autowired
    private AccountsService accountsService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/sync")
    public String sync(){
        accountsService.saveAccounts();
        courseService.saveCourses();
        return "MainPage";
    }
    
}
