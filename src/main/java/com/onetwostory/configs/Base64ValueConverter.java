package com.onetwostory.configs;


import org.eclipse.microprofile.config.spi.Converter;

public class Base64ValueConverter implements Converter<Base64Value> {

    @Override
    public Base64Value convert(String text) {
        return new Base64Value(text);
    }

}
