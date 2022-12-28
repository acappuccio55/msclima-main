package com.ms.agustin.DTO;

import com.ms.agustin.controller.WeatherController;

public class WeatherDTO {

    private Long id;
    private String city;

    public WeatherDTO() {

    }

    public WeatherDTO(Long id, String city) {
        this.id = id;
        this.city = city;
    }
}
