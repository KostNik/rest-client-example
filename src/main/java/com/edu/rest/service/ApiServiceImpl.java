package com.edu.rest.service;

import com.edu.rest.model.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserData receiveUserData(Integer limit) {
        ResponseEntity<UserData> entity = restTemplate.getForEntity("http://apifaketory.com/api/user?limit={limit}", UserData.class, limit);
        return entity.getBody();
    }
}
