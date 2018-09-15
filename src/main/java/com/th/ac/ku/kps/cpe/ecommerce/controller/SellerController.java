package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.ProductEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<ProductEntity> getAllUsers() {
        return productRepository.findAll();
    }
}
