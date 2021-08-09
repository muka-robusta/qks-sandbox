package com.onetwostory.configs;

import lombok.Data;
import lombok.ToString;

import java.util.Base64;

@Data
public class Base64Value {

    private String value;

    public Base64Value(String base64) {
        this.value = new String(Base64.getDecoder().decode(base64));
    }
}
