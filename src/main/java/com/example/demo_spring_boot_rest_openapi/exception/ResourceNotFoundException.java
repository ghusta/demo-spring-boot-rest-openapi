package com.example.demo_spring_boot_rest_openapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Support for {@link org.springframework.http.ProblemDetail}.
 *
 * @see org.springframework.web.ErrorResponseException
 * @see ResponseStatusException
 * @see org.springframework.web.servlet.resource.NoResourceFoundException
 */
public class ResourceNotFoundException extends ResponseStatusException {

    public ResourceNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }

}
