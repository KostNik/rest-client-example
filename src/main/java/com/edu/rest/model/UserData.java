package com.edu.rest.model;

import lombok.Data;

import java.util.List;

@Data
public class UserData {

    private final static long serialVersionUID = 2625239660183063316L;

    private List<User> data;

}
