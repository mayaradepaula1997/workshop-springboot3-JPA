package com.educandoweb.course.entities;

import com.educandoweb.course.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable  {
    private static final long serialVersionUID = 1L;

    @EmbeddedId //por ser um id composto
    private OrderItemPK id;  //identificador que é correnpondente a CHAVE ESTRANGEIRA
    private Integer quantity;
    private Double price;

    public OrderItem (){

    }
    //Atribuir Order e Product no OrderItem
    public OrderItem( Order order, Product product,Integer quantity, Double price) {  //Instanciando com pedido,produto,quantidade e preço
        super ();
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder(){
        return id.getOrder();
    }
    public  void setOrder (Order order){
        id.setOrder(order);
    }

    public Order getProduct(){
        return id.getOrder();
    }
    public  void setProduct (Order order){
        id.setOrder(order);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
