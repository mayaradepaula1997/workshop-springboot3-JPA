package com.educandoweb.course.service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List <User> findAll(){
        return repository.findAll();
    }

    public User findById (Long id){
        Optional <User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // orElseThrow: tentar dar o "get", senão tiver o usuario vai lançar a exeção
    }
    public User insert (User obj){
        return repository.save(obj);
    }
    public void delete(Long id){
        try {
            if(!repository.existsById(id)) throw new ResourceNotFoundException(id);
            repository.deleteById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }
    public User update (Long id, User obj) {   //User: retorna o usuario atualizado
        try {
            User entity = repository.getReferenceById(id);   //repository.getReferenceById instancia o usuario, sendo que não vai no banco de dados
            updateData(entity, obj);   //pegar esse objeto "entity" atualizar e atualizar o objeto "obj" com os dados que vieram do "(User obj)"
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) { //implementar o "updateData", atualizar os dados do "entity" com base no que chegou no "obj"
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
