package com.educandoweb.course.entities.pk;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

//VAI TER UMA REFERENCIA PARA "PRODUCT" E UMA REFRERENCIA PARA "ORDER"
//ESSA CLASSE EM ESPECIAL NÃO TEM CONSTRUTORES

@Embeddable //por ser um classe auxiliar de chave composta
public class OrderItemPK implements Serializable {
    private static final Long serialVersionUID = 1L;


    @ManyToOne
    @JoinColumn(name = "order_id") //nome da chave estrangeira
    private Order order;  //referencia ao pedido/order

    @ManyToOne
    @JoinColumn(name = "product_id") //nome da chave estrangeira
    private Product product;  // referencia ao produto/product

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    //Comparar tanto o Product quanto o Order, porque os dois juntos que identificam o Item
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemPK that)) return false;
        return Objects.equals(getOrder(), that.getOrder()) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder(), getProduct());
    }
}
