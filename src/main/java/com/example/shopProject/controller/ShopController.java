package com.example.shopProject.controller;

import com.example.shopProject.entity.Client;
import com.example.shopProject.entity.Client_Product;
import com.example.shopProject.entity.Product;
import com.example.shopProject.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping("/getAllClients")
    public List<Object[]> getAllClients(){
        return shopService.getAllClients();
    }

    @GetMapping("/getAllProduct")
    public List<Product> getAllProducts(){
        return shopService.getAllProduct();
    }

    @PostMapping("/buyProduct")
    public Object buyProduct(@RequestBody Client_Product client_product) {
        return shopService.buyProduct(client_product);
    }
    @GetMapping("/findClient/{id}")
    public Client index(@PathVariable int id){
        return shopService.index(id);
    }

    @PutMapping("/refillCheck")
    public Client refillCheck(@RequestParam int clientId,@RequestParam float sum){
        return shopService.refillCheck(clientId, sum);
    }
    @PutMapping("/refillProduct")
    public Product refillProduct(@RequestParam int productId,@RequestParam int count){
        return shopService.refillProduct(productId, count);
    }
}
