package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderitem.OrderItemSellerUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderitem.OrderItemSellerUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.read.OrderForSellerReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.update.OrderSellerUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.update.OrderSellerUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete.ProductDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete.ProductDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read.ProductReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update.ProductUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update.ProductUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.create.PromotionCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.create.PromotionCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.delete.PromotionDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.delete.PromotionDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.read.PromotionReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.update.PromotionUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.update.PromotionUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.create.ProductDeliveryCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.delete.ProductDeliveryDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.read.ProductDeliveryReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.create.ProductDeliveryCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.delete.ProductDeliveryDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.update.ProductDeliveryUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.update.ProductDeliveryUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.statistics.StatisticsResponse;
import com.th.ac.ku.kps.cpe.ecommerce.repository.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.service.SellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private ProductDeliveryRepository shipofshopRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private TypeShippingRepository typeShippingRepository;
    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @Autowired
    private RatingProductRepository ratingProductRepository;
    @Autowired
    private RatingProductPicRepository ratingProductPicRepository;
    @Autowired
    private ConfigRepository configRepository;
    @Autowired
    private UserBalanceRepository userBalanceRepository;

    // ================================ Start Implement ========================================

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public ProductCreateResponse createProduct(@RequestHeader String token, @RequestBody ProductCreateRequest restRequest) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.productCreateResponse(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/product")
    public ProductReadResponse readAllProduct(@RequestHeader String token) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.productReadAllResponse(token);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    public ProductReadResponse readProduct(@RequestHeader String token, @PathVariable("id") int id) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.productReadResponse(token, id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/product")
    public ProductUpdateResponse updateProduct(@RequestHeader String token, @RequestBody ProductUpdateRequest restRequest) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.productUpdateResponse(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
    public ProductDeleteResponse deleteProduct(@RequestHeader String token, @PathVariable int id) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.productDeleteResponse(token, id, "product");
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/product/variation/{id}")
    public ProductDeleteResponse deleteProductVariation(@RequestHeader String token, @PathVariable int id) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.productDeleteResponse(token, id, "variation");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product/delivery/{id}")
    public ProductDeliveryReadResponse readProductDelivery(@RequestHeader String token, @PathVariable("id") int id){
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.productDeliveryReadByIdProduct(token, id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/product/delivery")
    public ProductDeliveryCreateResponse createProductDelivery(@RequestHeader String token, @RequestBody ProductDeliveryCreateRequest restRequest){
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.productDeliveryCreate(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/product/delivery")
    public ProductDeliveryUpdateResponse updateProductDelivery(@RequestHeader String token, @RequestBody ProductDeliveryUpdateRequest restRequest){
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.productDeliveryUpdate(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/product/delivery")
    public ProductDeliveryDeleteResponse deleteProductDelivery(@RequestHeader String token, @RequestBody ProductDeliveryDeleteRequest restRequest){
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.productDeliveryDelete(token, restRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orderforseller")
    public OrderForSellerReadResponse readAllOrderForSellerResponse(@RequestHeader String token) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.readAllOrderForSellerResponse(token);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/orderforseller/{id}")
    public OrderForSellerReadResponse readOrderForSellerResponse(@RequestHeader String token, @PathVariable("id") int id) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.readOrderForSellerResponse(token, id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/orderforseller")
    public OrderSellerUpdateResponse updateOrderForSellerResponse(@RequestHeader String token, @RequestBody OrderSellerUpdateRequest restRequest) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.updateOrderForSellerResponse(token, restRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/promotion")
    public PromotionReadResponse readPromotion(@RequestHeader String token) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.readPromotion(token);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/promotion")
    public PromotionCreateResponse createPromotion(@RequestHeader String token, @RequestBody PromotionCreateRequest restRequest) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.createPromotion(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/promotion")
    public PromotionUpdateResponse updatePromotion(@RequestHeader String token, @RequestBody PromotionUpdateRequest restRequest) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.updatePromotion(token, restRequest);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/promotion")
    public PromotionDeleteResponse deletePromotion(@RequestHeader String token, @RequestBody PromotionDeleteRequest restRequest) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.deletePromotion(token, restRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/statistics/{day_1}/{month_1}/{year_1}/{day_2}/{month_2}/{year_2}")
    public StatisticsResponse readStatistics(@RequestHeader String token,
                                             @PathVariable("day_1") Integer day_1,
                                             @PathVariable("month_1") Integer month_1,
                                             @PathVariable("year_1") Integer year_1,
                                             @PathVariable("day_2") Integer day_2,
                                             @PathVariable("month_2") Integer month_2,
                                             @PathVariable("year_2") Integer year_2) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.readStatistics(token, day_1, month_1, year_1, day_2, month_2, year_2);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/statistics/{id_product}")
    public ResponseEntity<?> readStatustics(@RequestHeader String token, @PathVariable("id_product") Integer id_product) {
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.readStatistics(token, id_product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orderitemseller")
    public OrderItemSellerUpdateResponse orderItemSellerUpdate(@RequestHeader String token, @RequestBody OrderItemSellerUpdateRequest restRequest){
        SellerServiceImpl sellerService = new SellerServiceImpl(shopRepository, productRepository,userRepository,shopHasProductRepository, catagoryRepository, productVariationRepository, productPicRepository, productHasPromoRepository, shipofshopRepository, orderRepository, orderItemRepository, typeShippingRepository, deliveryAddressRepository, orderHistoryRepository, ratingProductRepository, ratingProductPicRepository, configRepository, userBalanceRepository);
        return sellerService.orderItemSellerUpdate(token, restRequest);
    }
}
