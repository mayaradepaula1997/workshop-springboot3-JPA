package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

    //Capaz de instanciar um objeto "UserRepository" que vai ter varias operaçoes para trabalhar com a classe "User"
}
