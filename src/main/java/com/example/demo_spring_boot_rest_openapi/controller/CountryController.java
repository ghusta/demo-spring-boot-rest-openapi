package com.example.demo_spring_boot_rest_openapi.controller;

import com.example.demo_spring_boot_rest_openapi.dao.CountryRepository;
import com.example.demo_spring_boot_rest_openapi.exception.ResourceNotFoundException;
import com.example.demo_spring_boot_rest_openapi.persistence.Country;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@Tag(name = "country")
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countryRepository.findById(code)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
