package com.educandoweb.course.config;


//Classe TestConfig vai ter uma dependência com a classe UserRepository

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration //Para fala que essa classe é uma configuração

@Profile("test") //Para fala que essa classe é especifica para o perfil teste

public class TestConfig implements CommandLineRunner { //Para inserir os dados no banco de dados

    @Autowired //Resolve a dependencia de objetos
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception { //run: Tudo que estiver dentro desse método, vai ser executado
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2)); //saveAll: Salvar no banco de dados


    }
}
