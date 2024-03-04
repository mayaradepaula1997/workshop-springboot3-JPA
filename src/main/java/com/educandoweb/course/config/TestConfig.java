package com.educandoweb.course.config;


//Classe TestConfig vai ter uma dependência com a classe UserRepository

import com.educandoweb.course.entities.*;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration //Para fala que essa classe é uma configuração

@Profile("test") //Para fala que essa classe é especifica para o perfil teste

public class TestConfig implements CommandLineRunner { //Para inserir os dados no banco de dados

    @Autowired
    private CategoryRepository categoryRepository; //Importa /Inejeção a dependencia

    @Autowired
    private ProductRepository productRepository; //Importa/Injeção a dependencia

    @Autowired //Importa/Injeção a dependencia
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository; //Importa/Injeção a dependencia

    @Autowired
    private OrderItemRepository orderItemRepository; //Importa/Injeção a dependencia



    @Override
    public void run(String... args) throws Exception { //run: Tudo que estiver dentro desse método, vai ser executado

        Category cat1 = new Category(null, "Electronics"); //Instanciar os objetos
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");



        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3)); //Salvar os objetos
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));


        //Associar os Produtos (Product) com as Categorias (Category)
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        //Salvar os produtos com as associações
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));


        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");



        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);


        userRepository.saveAll(Arrays.asList(u1,u2)); //saveAll: Salvar no banco de dados
        //ASSOCIAÇÕES ENTRE OBJETOS (MODELO RELACIONAL)
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

      orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));



    }
}
