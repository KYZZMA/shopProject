package com.example.shopProject.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "client_product")
public class Client_Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "clientid")
    private int clientId;
    @Column(name = "productid")
    private int productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }
    public int getProductId() {
        return productId;
    }


}
