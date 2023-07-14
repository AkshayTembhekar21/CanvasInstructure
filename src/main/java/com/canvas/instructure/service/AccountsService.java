package com.canvas.instructure.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.canvas.instructure.controller.HomeController;
import com.canvas.instructure.conversion.Conversions;
import com.canvas.instructure.dao.AccountDAO;
import com.canvas.instructure.dto.AccountDTO;
import com.canvas.instructure.entity.Account;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccountsService {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private Conversions conversions;

    private static final Logger logger = LoggerFactory.getLogger(AccountsService.class);

    public void saveAccounts(){
        String accountsUrl = "http://3.231.151.15/api/v1/accounts";
        String accessToken = HomeController.accessToken;
        RestTemplate restTemplate = new RestTemplate(); 

        HttpHeaders headers = new HttpHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(accountsUrl)
                .queryParam("access_token", accessToken);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        String apiEndpoint = builder.toUriString();
        List<Account> accounts = new ArrayList<>();
        try{
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiEndpoint, String.class, headers);
            String responseBody = responseEntity.getBody();
            logger.info("accounts from canvas - ",responseBody);
            
            ObjectMapper objectMapper = new ObjectMapper();
            AccountDTO[] accountDTO = objectMapper.readValue(responseBody, AccountDTO[].class);

            for(AccountDTO dto : accountDTO){
                logger.debug("Converting Account DTO to Account Entity");
                Account account = conversions.toDAO(dto);
                accounts.add(account);
            }
        }catch(Exception ex){
            logger.error("http://3.231.151.15/api/v1/accounts", ex.getMessage());
        }
        
        if(!accounts.isEmpty()){
            logger.info("Accounts are not empty: Saving Accounts.");
            accountDAO.saveAccounts(accounts);
        }
    }
    
}
