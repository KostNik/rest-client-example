package com.edu.rest.service;

import com.edu.rest.model.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;


@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserData receiveUserData(Integer limit) {
        UriComponents components = UriComponentsBuilder.fromHttpUrl(apiUrl).queryParam("limit", limit).build();
        ResponseEntity<UserData> entity = restTemplate.getForEntity(components.toString(), UserData.class);
        return entity.getBody();
    }

    @Override
    public Mono<UserData> receiveUserData(Mono<Integer> limit) {
        return WebClient.create(apiUrl)
                .method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder.queryParam("limit", limit.block()).build())
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(UserData.class);
    }
}
