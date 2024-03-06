package com.educandoweb.course.resource;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController // para fala que essa classe é um recurso web, implementado por um controlador rest
@RequestMapping (value = "/users") // nome para o recurso
public class UserResource {

    @Autowired // dependencia com o SERVICE
    private UserService service;

    @GetMapping
    public ResponseEntity <List<User>> findAll (){
        List <User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping (value = "/{id}")    //aceitar um id dentro da URL
    public ResponseEntity <User> findById (@PathVariable Long id){   //para o spring aceitar o Id e consideralo como parametro, que vai chegar da URL
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);  //ResponseEntity.ok - indica que teve sucesso
                                              //body - Corpo da requisição

    }
    @PostMapping
    public ResponseEntity<User> insert (@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ //@PathVariable conhecer como uma variavel da URL
        service.delete(id); //deletei
        return ResponseEntity.noContent().build(); //noContent() retorna uma resposta vazia e o cogido HTTP 204
    }


    @PutMapping (value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){ //recebe um objeto com os dados do usuario para atualizar "(@RequestBody User obj)"
        obj=service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }


}
