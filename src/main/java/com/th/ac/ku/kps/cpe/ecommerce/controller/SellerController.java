package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read.OrderReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete.ProductDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete.ProductDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read.ProductReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update.ProductUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update.ProductUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.create.ShipOfShopCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.delete.ShipOfShopDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.read.ShipOfShopReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.create.ShipOfShopCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.delete.ShipOfShopDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.update.ShipOfShopUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.update.ShipOfShopUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.repository.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.*;
import com.th.ac.ku.kps.cpe.ecommerce.service.SellerServiceImpl;
import com.th.ac.ku.kps.cpe.ecommerce.unity.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/ecom/api/eshop")
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

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/shop/create")
    public ShopCreateResponse createShop(@RequestBody ShopCreateRequest restRequest) {
        Common.LoggerInfo(restRequest);
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);
        return sellerService.shopCreateResponse(restRequest);
    }

    @PostMapping("/shop/update")
    public ShopUpdateResponse updateShop(@RequestBody ShopUpdateRequest restRequest) {
        Common.LoggerInfo(restRequest);
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);
        return sellerService.shopUpdateResponse(restRequest);

    }

    // ================================ Start Implement ========================================

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public ProductCreateResponse createProduct(@RequestHeader String token, @RequestBody ProductCreateRequest restRequest) {
        Common.LoggerInfo(restRequest);
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);
        return sellerService.productCreateResponse(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/product")
    public ProductReadResponse readAllProduct(@RequestHeader("token") String token) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);
        return sellerService.productReadAllResponse(token);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    public ProductReadResponse readProduct(@RequestHeader("token") String token, @PathVariable("id") int id) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);
        return sellerService.productReadResponse(token, id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/product")
    public ProductUpdateResponse updateProduct(@RequestHeader String token, @RequestBody ProductUpdateRequest restRequest) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);
        return sellerService.productUpdateResponse(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/product")
    public ProductDeleteResponse deleteProduct(@RequestHeader String token, @RequestBody ProductDeleteRequest restRequest) {
        Common.LoggerInfo(restRequest);
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);
        return sellerService.productDeleteResponse(token, restRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/shipofshop")
    public ShipOfShopReadResponse readShipOfShop (@RequestHeader String token){
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);
        return sellerService.shipofshopReadResponse(token);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/shipofshop")
    public ShipOfShopCreateResponse createShipOfShop (@RequestHeader String token, @RequestBody ShipOfShopCreateRequest restRequest){
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);
        return sellerService.shipofshopCreateResponse(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/shipofshop")
    public ShipOfShopUpdateResponse updateShipOfShop (@RequestHeader String token, @RequestBody ShipOfShopUpdateRequest restRequest){
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);
        return sellerService.shipofshopUpdateResponse(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/shipofshop")
    public ShipOfShopDeleteResponse deleteShipOfShop (@RequestHeader String token, @RequestBody ShipOfShopDeleteRequest restRequest){
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);
        return sellerService.shipofshopDeleteResponse(token, restRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orderforseller")
    public OrderReadResponse readAllOrderForSellerResponse(@RequestHeader("token") String token){
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository);

        return sellerService.readAllOrderForSellerResponse(token);
    }
}
