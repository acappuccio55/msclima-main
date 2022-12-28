package com.ms.agustin.controller;

import com.ms.agustin.DTO.WeatherDTO;
import com.ms.agustin.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService service;

    @Autowired
    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeatherDTO> get(@PathVariable Long id) {
        WeatherDTO response = service.get(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WeatherDTO> save(@RequestBody WeatherDTO country) {
        WeatherDTO response = service.save(country);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<WeatherDTO> update(@PathVariable Long id, @RequestBody WeatherDTO country) {
        WeatherDTO response = service.update(id, country);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}