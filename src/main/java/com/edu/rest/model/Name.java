
package com.edu.rest.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Name implements Serializable {

    private final static long serialVersionUID = 2300086525973455526L;

    private String title;
    private String first;
    private String last;

    private Map<String, Object> additionalProperties = new HashMap<>();

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
