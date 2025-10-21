package com.example.demo_spring_boot_rest_openapi.controller;

import com.example.demo_spring_boot_rest_openapi.dao.CityRepository;
import com.example.demo_spring_boot_rest_openapi.exception.ResourceNotFoundException;
import com.example.demo_spring_boot_rest_openapi.persistence.City;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@Tag(name = "city")
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Integer id) {
        return cityRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/country/{code}")
    public List<City> getCitiesByCountryCode(@PathVariable String code) {
        return cityRepository.findByCountryCode(code.toUpperCase());
    }

}
