
package com.edu.rest.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class User implements Serializable {

    private final static long serialVersionUID = 2625239660183063316L;

    private Job      job;
    private Name     name;
    private Login    login;
    private String   email;
    private String   phone;
    private String   gender;
    private Billing  billing;
    private String   language;
    private String   currency;
    private Location location;

    private Map<String, Object> additionalProperties = new HashMap<>();

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
