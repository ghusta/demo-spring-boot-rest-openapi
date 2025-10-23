package com.example.demo_spring_boot_rest_openapi.dao;

import com.example.demo_spring_boot_rest_openapi.persistence.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {

}
