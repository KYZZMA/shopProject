package com.example.shopProject.entity;

;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "clientid")
    private int clientId;
    @Column(name = "clientname")
    private String clientName;
    @Column(name = "clientcheck")
    private float clientCheck;

    @ManyToMany
    @JoinTable(name = "client_product",
            joinColumns = @JoinColumn(name = "clientid", referencedColumnName = "clientId"),
            inverseJoinColumns = @JoinColumn(name = "productid", referencedColumnName = "productId")
    )
    private Set<Product> products;




    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public float getClientCheck() {
        return clientCheck;
    }

    public void setClientCheck(float clientCheck) {
        this.clientCheck = clientCheck;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
