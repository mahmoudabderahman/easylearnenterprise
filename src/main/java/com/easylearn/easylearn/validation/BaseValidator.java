/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Base Validator class is where the code responsible for implementing the validation implemented.
 */
package com.easylearn.easylearn.validation;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.Optional;

@Log4j2
@Component
@Transactional
public abstract class BaseValidator<T> {
    @Autowired
    private EntityManager entityManager;
    private Class<T> clazz;
    private static final String ENTITY_EXISTENCE_VALIDATION_MESSAGE = "The %s with Id: [%s] doesn't exist";

    protected BaseValidator(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * validateExistence method, which is responsible for checking if this entity
     * with this primary key value exists.
     *
     * @param primaryKey
     * @return the entity if it exists and error message if not.
     */
    public T validateExistence(Object primaryKey) {
        log.info(" *** VALIDATING {} EXISTENCE *** ", clazz.getSimpleName());
        return Optional.ofNullable(entityManager.find(clazz, primaryKey))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format(ENTITY_EXISTENCE_VALIDATION_MESSAGE, clazz.getSimpleName(), primaryKey)));
    }
}

