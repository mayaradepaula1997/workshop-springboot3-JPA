package com.educandoweb.course.resource;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // para fala que essa classe é um recurso web, implementado por um controlador rest
@RequestMapping (value = "/users") // nome para o recurso
public class UserResource {

    @GetMapping
    public ResponseEntity <User> findAllc(){  //<User> O tipo da minha resposta, vai ser minha classe "User"
        User u =  new User(1L,"Maria","maria@gmail.com" ,"9999999", "12345"); //importa a classe
        return ResponseEntity.ok().body(u); // ResponseEntity.ok retorna a resposta com sucesso no HTTP
    }                                       //body(u) corpo da resposta, que foi instanciado a classe "User" / "u"


}
