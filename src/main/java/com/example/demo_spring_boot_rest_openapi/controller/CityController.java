package com.example.demo_spring_boot_rest_openapi.controller;

import com.example.demo_spring_boot_rest_openapi.dao.CityRepository;
import com.example.demo_spring_boot_rest_openapi.exception.ResourceNotFoundException;
import com.example.demo_spring_boot_rest_openapi.persistence.City;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /**
     * @deprecated Prefer paginated version
     */
    @GetMapping("/unpaginated")
    @Deprecated
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping
    public Page<City> getAllCitiesPaginated(Pageable pageable) {
        return cityRepository.findAll(pageable);
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
