package com.educandoweb.course.service.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID=1L;

    public ResourceNotFoundException(Object id) { //passar o id que não foi encontrado
        super ("Resource not found id " + id);

    }
}
