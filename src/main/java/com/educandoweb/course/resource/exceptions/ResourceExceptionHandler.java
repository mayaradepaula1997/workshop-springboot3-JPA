package com.educandoweb.course.resource.exceptions;

import com.educandoweb.course.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

//Classe que vamos fazer o tratamento manualmete nossos erros

@ControllerAdvice //interceptar as exceções que acontecerem, pas que exxe obj possa executar um possivel tratamento
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound (ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resouce not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(), error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}



//<StandardError>: tipo da resposta
//(ResourceNotFoundException: recebe como argumento a exeção do tipo personalizado "e"
//String error = "Resouce not found": status da resposta que deu essa exceção "404"
//@ExceptionHandler(ResourceNotFoundException.class):estou falando que esse ,etodo vai interceptar qualquer exeçaõ do tipo
//que foi lançada e vai fazer o tratemnto que tiver dentro do método.