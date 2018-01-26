package com.edu.rest.controller;

import com.edu.rest.model.UserData;
import com.edu.rest.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

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

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange) {
        serverWebExchange.getFormData()
                .map(map -> map.get("limit").get(0))
                .map(Integer::parseInt)
                .map(apiService::receiveUserData)
                .map(UserData::getData)
                .subscribe(data -> model.addAttribute("users", data));
        return "userList";
    }

}
