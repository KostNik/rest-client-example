package com.edu.rest.service;

import com.edu.rest.model.UserData;
import reactor.core.publisher.Mono;

public interface ApiService {

    UserData receiveUserData(Integer limit);

    Mono<UserData> receiveUserData(Mono<Integer> limit);

}
