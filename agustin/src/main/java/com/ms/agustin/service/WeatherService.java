package com.ms.agustin.service;

import com.ms.agustin.DTO.WeatherDTO;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    public WeatherDTO get(Long id) {
        return new WeatherDTO(1l, "asd");
    }

    public WeatherDTO save(WeatherDTO weather){
        return weather;
    }

    public WeatherDTO update(Long id, WeatherDTO weather){
        return weather;
    }

    public void delete(Long weather){
        //return weather;
    }

}
