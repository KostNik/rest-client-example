
package com.edu.rest.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Card implements Serializable {

    private final static long serialVersionUID = 5379011050782310635L;
    
    private String         type;
    private String         iban;
    private String         swift;
    private String         number;
    private ExpirationDate expirationDate;

    private Map<String, Object> additionalProperties = new HashMap<>();

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
