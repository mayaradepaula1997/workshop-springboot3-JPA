package com.educandoweb.course.resource;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.CategoryService;
import com.educandoweb.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // para fala que essa classe é um recurso web, implementado por um controlador rest
@RequestMapping (value = "/categories") // nome para o recurso
public class CategoryResource {

    @Autowired // dependencia com o SERVICE
    private CategoryService service;

    @GetMapping
    public ResponseEntity <List<Category>> findAll (){
        List <Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping (value = "/{id}")    //aceitar um id dentro da URL
    public ResponseEntity <Category> findById (@PathVariable Long id){   //para o spring aceitar o Id e consideralo como parametro, que vai chegar da URL
       Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);  //ResponseEntity.ok - indica que teve sucesso
                                              //body - Corpo da requisição

    }


}
