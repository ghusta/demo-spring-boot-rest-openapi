package com.example.demo_spring_boot_rest_openapi.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {

    @Id
    @Size(max = 3)
    @Column(name = "code", nullable = false, length = 3)
    private String code;

    @NotNull
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @NotNull
    @Column(name = "continent", nullable = false, length = Integer.MAX_VALUE)
    private String continent;

    @NotNull
    @Column(name = "region", nullable = false, length = Integer.MAX_VALUE)
    private String region;

    @NotNull
    @Column(name = "surface_area", nullable = false)
    private Float surfaceArea;

    @Column(name = "indep_year")
    private Short indepYear;

    @NotNull
    @Column(name = "population", nullable = false)
    private Integer population;

    @Column(name = "life_expectancy")
    private Float lifeExpectancy;

    @Column(name = "gnp", precision = 10, scale = 2)
    private BigDecimal gnp;

    @Column(name = "gnp_old", precision = 10, scale = 2)
    private BigDecimal gnpOld;

    @NotNull
    @Column(name = "local_name", nullable = false, length = Integer.MAX_VALUE)
    private String localName;

    @NotNull
    @Column(name = "government_form", nullable = false, length = Integer.MAX_VALUE)
    private String governmentForm;

    @Column(name = "head_of_state", length = Integer.MAX_VALUE)
    private String headOfState;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "capital")
    private City capital;

    @Size(max = 2)
    @NotNull
    @Column(name = "code2", nullable = false, length = 2)
    private String code2;

}