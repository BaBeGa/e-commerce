package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read.ProductReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.repository.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.*;
import com.th.ac.ku.kps.cpe.ecommerce.service.SellerServiceImpl;
import com.th.ac.ku.kps.cpe.ecommerce.unity.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/ecom")
public class SellerController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShopHasProductRepository shopHasProductRepository;
    @Autowired
    private CatagoryRepository catagoryRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/shop/create")
    public ShopCreateResponse createShop(@RequestBody ShopCreateRequest restRequest) {
        Common.LoggerInfo(restRequest);
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository);
        return sellerService.shopCreateResponse(restRequest);
    }

    @PostMapping("/shop/update")
    public ShopUpdateResponse updateShop(@RequestBody ShopUpdateRequest restRequest) {
        Common.LoggerInfo(restRequest);
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository);
        return sellerService.shopUpdateResponse(restRequest);

    }

    @PostMapping("/product")
    public ProductCreateResponse createProduct(@RequestBody ProductCreateRequest restRequest) {
        Common.LoggerInfo(restRequest);
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository);
        return sellerService.productCreateResponse(restRequest);
    }

    // ================================ Start Implement ========================================

    @GetMapping("/product")
    public ProductReadResponse readAllProduct(@RequestHeader("token") String token) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository);
        return sellerService.productReadAllResponse(token);
    }


    @GetMapping("/product/{id}")
    public ProductReadResponse readProduct(@RequestHeader("token") String token, @PathVariable("id") int id) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository);
        return sellerService.productReadResponse(token, id);
    }
}
