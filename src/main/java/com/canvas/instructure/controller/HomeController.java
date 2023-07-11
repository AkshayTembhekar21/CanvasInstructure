package com.canvas.instructure.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/welcome")
    public String home1(@RequestParam String code) {
        System.out.println("code - "+code);
        String apiUrl = "https://3.231.151.15/login/oauth2/token"; 
        String clientId = "10000000000011"; 
        String clientSecret = "ZxcGR8hyHWonq28dwVqtDhWPKGGX4PYAAElF8meGZrZJCGEN4knsO7W22c6dJZvs"; 
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "authorization_code"); 
        requestBody.add("client_id", clientId); 
        requestBody.add("client_secret", clientSecret); 
        requestBody.add("redirect_uri", "http://localhost:8080/welcome"); 
        requestBody.add("code", code); 

        //HttpHeaders headers = new HttpHeaders(); 
        //HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody); 

        // Create a RestTemplate instance 
        RestTemplate restTemplate = new RestTemplate(); 
        String url2 = "http://3.231.151.15/login/oauth2/token?grant_type=authorization_code&client_secret=ZxcGR8hyHWonq28dwVqtDhWPKGGX4PYAAElF8meGZrZJCGEN4knsO7W22c6dJZvs&client_id=10000000000011&redirect_uri=http://localhost:8080/welcome&code="+code;
       // System.out.println(apiUrl);
        String urlOut = restTemplate.postForObject(url2, null, String.class);
        //System.out.println("response - "+ urlOut);

        ObjectMapper mapper = new ObjectMapper();
        String accessToken = "";
        try {
            accessToken = mapper.readTree(urlOut).get("access_token").asText();
            System.out.println("finishLine accessToken" + accessToken);
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
            //return "/error";
            return "index";
        }
        

        String accountsUrl = "https://3.231.151.15/api/v1/accounts";
        HttpHeaders headers = new HttpHeaders();
        List<String> includeParams = Arrays.asList("lti_guid", "registration_settings", "services");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(accountsUrl)
                .queryParam("access_token", accessToken);
                //.queryParam("include[]", includeParams);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        String apiEndpoint = builder.toUriString();
        System.out.println(apiEndpoint);
        try{
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(accountsUrl, String.class, headers);
            System.out.println("1st try");
            System.out.println("response1 - "+ responseEntity);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return "index";
    }
    
}
