package com.edu.rest.controller;

import com.edu.rest.model.UserData;
import com.edu.rest.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserController {


    private ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String indexPage() {
        return "index";
    }

    @PostMapping("/users/base")
    public String formPost(Model model, ServerWebExchange serverWebExchange) {
        serverWebExchange.getFormData()
                .map(map -> map.getFirst("limit"))
                .map(Integer::parseInt)
                .map(apiService::receiveUserData)
                .map(UserData::getData)
                .subscribe(data -> model.addAttribute("users", data));
        return "userList";
    }

    @PostMapping("/users/react")
    public String formPostReact(Model model, ServerWebExchange serverWebExchange) {
        serverWebExchange.getFormData()
                .map(map -> map.getFirst("limit"))
                .map(Integer::parseInt)
                .map(Mono::just)
                .map(apiService::receiveUserData)
                .map(userDataMono -> userDataMono.flatMapIterable(UserData::getData))
                .subscribe(data -> model.addAttribute("users", data));
        return "userList";
    }

}
