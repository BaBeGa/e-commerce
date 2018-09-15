package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.*;
import com.th.ac.ku.kps.cpe.ecommerce.service.SellerServiceImpl;
import com.th.ac.ku.kps.cpe.ecommerce.unity.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mado/api/v1")
public class SellerController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShopRepository shopRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/shop/create")
    public ShopCreateResponse createShop(@RequestBody ShopCreateRequest restRequest) {
        Common.LoggerInfo(restRequest);
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository);
        return sellerService.shopCreateResponse(restRequest);
    }
}
