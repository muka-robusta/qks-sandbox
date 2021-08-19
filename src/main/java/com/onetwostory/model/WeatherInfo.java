package com.onetwostory.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WeatherInfo {
    
    private Integer id;

    private Double longitude;
    private Double latitude;

    private String main;
    private String description;

    private String place;
}
