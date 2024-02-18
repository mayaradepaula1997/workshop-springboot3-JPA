package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.rmi.server.UID;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table (name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat (shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd 'T' HH:mm:ss 'Z'",timezone = "GMY")
    private Instant moment;

    @ManyToOne //Para instruir o JPA para transforma isso em UMA CHAVA ESTRANGEIRA (implementar o relacionamento entre ORDER  e USER
    @JoinColumn (name = "client_id")
    private User client;  //associação com a classe USER

    public Order (){

    }
    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}