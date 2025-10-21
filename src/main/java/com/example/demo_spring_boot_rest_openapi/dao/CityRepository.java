package com.example.demo_spring_boot_rest_openapi.dao;

import com.example.demo_spring_boot_rest_openapi.persistence.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findByCountryCode(String code);

}
