
package com.edu.rest.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class ExpirationDate implements Serializable {

    private final static long serialVersionUID = 4528100964720031416L;
    
    private String  date;
    private Integer timezoneType;
    private String  timezone;
    
    private Map<String, Object> additionalProperties = new HashMap<>();


    private void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
