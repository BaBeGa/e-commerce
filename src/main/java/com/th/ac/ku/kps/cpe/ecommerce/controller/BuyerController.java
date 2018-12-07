package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.exception.TokenNotFoundException;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read.OrderReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.repository.*;
import com.th.ac.ku.kps.cpe.ecommerce.service.BuyerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@CrossOrigin
@RequestMapping(path = "/ecom/api/eshop")
public class BuyerController implements Serializable {

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
    @Autowired
    private ProductVariationRepository productVariationRepository;
    @Autowired
    private ProductPicRepository productPicRepository;
    @Autowired
    private ProductHasPromoRepository productHasPromoRepository;
    @Autowired
    private ShipOfShopRepository shipofshopRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ShipOfShopRepository shipOfShopRepository;
    @Autowired
    private OrderPaymentRepository orderPaymentRepository;
    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;
    @Autowired
    private TypeShippingRepository typeShippingRepository;
    @Autowired
    private ConfigRepository configRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/order")
    public OrderReadResponse orderReadAllResponse(@RequestHeader (required = false) String token) {
        if (token == null || token.isEmpty()) {
            throw new TokenNotFoundException("Token can't be null");
        }
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository);
        return buyerService.orderReadAllResponse(token);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/order/{id}")
    public OrderReadResponse orderReadResponse(@RequestHeader (required = false) String token, @PathVariable("id") int id) {
        if (token == null || token.isEmpty()) {
            throw new TokenNotFoundException("Token can't be null");
        }
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository);
        return buyerService.orderReadResponse(token, id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/order")
    public OrderCreateResponse orderCreateResponse(@RequestHeader (required = false) String token, @RequestBody OrderCreateRequest restRequest) {
        if(token == null || token.isEmpty()) {
            throw new TokenNotFoundException("Token can't be null");
        }
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository);
        return buyerService.orderCreateResponse(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/order")
    public OrderUpdateResponse orderUpdateResponse(@RequestHeader (required = false) String token, @RequestBody OrderUpdateRequest restRequest) {
        if(token == null || token.isEmpty()) {
            throw new TokenNotFoundException("Token can't be null");
        }
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository);
        return buyerService.orderUpdateResponse(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/order")
    public OrderDeleteResponse orderDeleteResponse(@RequestHeader (required = false) String token, @RequestBody OrderDeleteRequest restRequest) {
        if(token == null || token.isEmpty()) {
            throw new TokenNotFoundException("Token can't be null");
        }
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository);
        return buyerService.orderDeleteResponse(token, restRequest);
    }
}