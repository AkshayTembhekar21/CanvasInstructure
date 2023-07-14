package com.canvas.instructure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.canvas.instructure.dao.CourseDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

    public static String accessToken;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam String code) {
        String apiUrl = "https://3.231.151.15/login/oauth2/token"; 
        String clientId = "10000000000011"; 
        String clientSecret = "ZxcGR8hyHWonq28dwVqtDhWPKGGX4PYAAElF8meGZrZJCGEN4knsO7W22c6dJZvs"; 
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "authorization_code"); 
        requestBody.add("client_id", clientId); 
        requestBody.add("client_secret", clientSecret); 
        requestBody.add("redirect_uri", "http://localhost:8080/welcome"); 
        requestBody.add("code", code); 

        // Create a RestTemplate instance 
        RestTemplate restTemplate = new RestTemplate(); 
        String url2 = "http://3.231.151.15/login/oauth2/token?grant_type=authorization_code&client_secret=ZxcGR8hyHWonq28dwVqtDhWPKGGX4PYAAElF8meGZrZJCGEN4knsO7W22c6dJZvs&client_id=10000000000011&redirect_uri=http://localhost:8080/welcome&code="+code;
        String urlOut = restTemplate.postForObject(url2, null, String.class);

        ObjectMapper mapper = new ObjectMapper();
        String accessToken = "";
        try {
            accessToken = mapper.readTree(urlOut).get("access_token").asText();
            HomeController.accessToken = accessToken;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return "index";
        }
        return "MainPage";
    }
    
}
