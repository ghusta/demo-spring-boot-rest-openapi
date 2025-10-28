package com.example.demo_spring_boot_rest_openapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * This provides a converter that automatically transforms every PageImpl object to PagedModel.
 * <p>
 * See <a href="https://bootify.io/spring-boot/pagination-in-spring-boot-rest-api.html#configuration-and-usage-of-pagedmodel">Configuration and usage of PagedModel</a>
 *
 * @see org.springframework.data.web.PagedModel
 */
@Configuration
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class JacksonConfig {

}
