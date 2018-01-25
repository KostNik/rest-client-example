
package com.edu.rest.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Billing implements Serializable {

    private final static long serialVersionUID = -2285956924281394105L;

    private Card card;

    private Map<String, Object> additionalProperties = new HashMap<>();


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
