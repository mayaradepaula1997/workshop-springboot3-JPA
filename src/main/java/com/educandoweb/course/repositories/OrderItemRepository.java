package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    //Capaz de instanciar um objeto "UserRepository" que vai ter varias operaçoes para trabalhar com a classe "User"
}
