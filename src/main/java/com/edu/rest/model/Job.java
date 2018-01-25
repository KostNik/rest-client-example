
package com.edu.rest.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Job implements Serializable {

    private final static long serialVersionUID = 5457725703623012747L;

    private String title;
    private String company;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
