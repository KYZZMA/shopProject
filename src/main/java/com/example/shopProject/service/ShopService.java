package com.example.shopProject.service;

import com.example.shopProject.entity.Client;
import com.example.shopProject.entity.Client_Product;
import com.example.shopProject.entity.Product;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public interface ShopService {

    public Client saveUser(Client client);

    public List<Object[]> getAllClients();

    public Object buyProduct(Client_Product client_product);

    public Client index(int idClient);

    public Client refillCheck(int clientId, float sum);

    public Product refillProduct(int productId, int count);

    public List<Product> getAllProduct();
}
