package com.example.shopProject.serviceImpl;

import com.example.shopProject.entity.Client;
import com.example.shopProject.entity.Client_Product;
import com.example.shopProject.entity.Product;
import com.example.shopProject.service.ShopService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class ShopServiceImpl implements ShopService {


    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Client saveUser(Client client) {
        return null;
    }

    @Override
    @Transactional
    public List<Object[]> getAllClients() {

        String jpql = "SELECT c.clientName, p.productName, COUNT(cp.productId) " +
                "FROM Client c " +
                "join Client_Product cp on cp.clientId = c.clientId " +
                "join Product p on cp.productId = p.productId " +
                "GROUP BY c.clientName, p.productName";


        List<Object[]> allResults = entityManager.createQuery(jpql).getResultList();

        return allResults;

    }

    @Override
    @Transactional
    public Client index(int idClient) {
        Client client = entityManager.find(Client.class, idClient);
        return client;
    }


    public Product indexProduct(int idProduct) {
        Product product = entityManager.find(Product.class, idProduct);
        return product;
    }

    @Override
    @Transactional
    public Client refillCheck(int clientId ,float sum) {

        Client client = index(clientId);

        float checkNow = client.getClientCheck();
        client.setClientCheck(checkNow + sum);

        return client;
    }

    @Override
    @Transactional
    public Product refillProduct(int productId, int count) {

        Product product = indexProduct(productId);

        int countNow = product.getCountProduct();
        product.setCountProduct(countNow + count);

        return product;
    }


    @Override
    @Transactional
    public Object buyProduct(Client_Product client_product) {

        int clientId = client_product.getClientId();
        Client client = index(clientId);
        float checkNow = client.getClientCheck();

        int productId = client_product.getProductId();
        Product product = indexProduct(productId);
        float checkProductNow = product.getPriceProduct();
        int countProduct = product.getCountProduct();

        if (countProduct > 0){
            if (checkNow >= checkProductNow) {
                client.setClientCheck(checkNow - checkProductNow);
                entityManager.persist(client_product);
                product.setCountProduct(countProduct-1);
                return client;
            } else {
                return "недостаточно средств на счете";
            }
        }else {
            return "товар закончился";
        }
    }

    @Override
    @Transactional
    public List<Product> getAllProduct() {

        String jpql = "SELECT p FROM Product p";
        List<Product> allResults = entityManager.createQuery(jpql).getResultList();
        return allResults;
    }
}
