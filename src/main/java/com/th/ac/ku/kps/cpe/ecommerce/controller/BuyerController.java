package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.create.FavoriteProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.create.FavoriteProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.delete.FavoriteProductDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.delete.FavoriteProductDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.read.FavoriteProductReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read.OrderReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderhistory.OrderHistoryReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderitem.OrderItemUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderitem.OrderItemUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.create.RatingProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.create.RatingProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.read.RatingProductReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingshop.create.RatingShopCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.repository.*;
import com.th.ac.ku.kps.cpe.ecommerce.service.BuyerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @Autowired
    private RatingProductRepository ratingProductRepository;
    @Autowired
    private FavoriteProductRepository favoriteProductRepository;
    @Autowired
    private RatingProductPicRepository ratingProductPicRepository;
    @Autowired
    private TypePaymentRepository typePaymentRepository;
    @Autowired
    private RatingShopRepository ratingShopRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/order")
    public OrderReadResponse orderReadAllResponse(@RequestHeader String token) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository, favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.orderReadAllResponse(token);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/order/{id}")
    public OrderReadResponse orderReadResponse(@RequestHeader String token, @PathVariable("id") int id) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository, favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.orderReadResponse(token, id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/order")
    public OrderCreateResponse orderCreateResponse(@RequestHeader String token, @RequestBody OrderCreateRequest restRequest) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.orderCreateResponse(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/order")
    public OrderUpdateResponse orderUpdateResponse(@RequestHeader String token, @RequestBody OrderUpdateRequest restRequest) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.orderUpdateResponse(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/order")
    public OrderDeleteResponse orderDeleteResponse(@RequestHeader String token, @RequestBody OrderDeleteRequest restRequest) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.orderDeleteResponse(token, restRequest);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orderitem")
    public OrderItemUpdateResponse orderItemUpdateResponse(@RequestHeader String token, @RequestBody OrderItemUpdateRequest restRequest) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.orderItemUpdateResponse(token, restRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orderhistory")
    public OrderHistoryReadResponse orderHistoryReadResponse(@RequestHeader String token) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.orderHistoryReadAllResponse(token);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/orderhistory/{id}")
    public OrderHistoryReadResponse orderHistoryReadResponse(@RequestHeader String token, @PathVariable("id") int id) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.orderHistoryReadResponse(token, id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rating/product/{id}")
    public RatingProductReadResponse ratingProductReadByIdRatingProductResponse(@RequestHeader String token, @PathVariable("id") int id) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.ratingProductReadByIdOrderHistory(token, id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/rating/product")
    public RatingProductCreateResponse ratingProductCreateResponse(@RequestHeader String token, @RequestBody RatingProductCreateRequest restRequest) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.ratingProductCreate(token, restRequest);
    }
    // PUT DELETE

    @RequestMapping(method = RequestMethod.GET, value = "/favorite")
    public FavoriteProductReadResponse favoriteProductReadResponse(@RequestHeader String token) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.favoriteProductRead(token);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/favorite")
    public FavoriteProductCreateResponse favoriteProductCreateResponse(@RequestHeader String token, @RequestBody FavoriteProductCreateRequest restRequest) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.favoriteProductCreate(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/favorite")
    public FavoriteProductDeleteResponse favoriteProductDeleteResponse(@RequestHeader String token,@RequestBody FavoriteProductDeleteRequest restRequest) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.favoriteProductDelete(token, restRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rating/shop/{id}")
    public ResponseEntity<?> ratingShopReadResponse(@RequestHeader String token, @PathVariable("id") int id) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.ratingShopReadByIdOrderHistory(token, id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/rating/shop/")
    public ResponseEntity<?> ratingShopCreateResponse(@RequestHeader String token, @Valid @RequestBody RatingShopCreateRequest restRequest) {
        BuyerServiceImpl buyerService = new BuyerServiceImpl(orderRepository,userRepository, orderItemRepository, productVariationRepository, productRepository, shipOfShopRepository, orderPaymentRepository, deliveryAddressRepository, typeShippingRepository, configRepository, shopHasProductRepository, shopRepository, productPicRepository, orderHistoryRepository, ratingProductRepository,  favoriteProductRepository, ratingProductPicRepository, typePaymentRepository, ratingShopRepository);
        return buyerService.ratingShopCreate(token, restRequest);
    }
}