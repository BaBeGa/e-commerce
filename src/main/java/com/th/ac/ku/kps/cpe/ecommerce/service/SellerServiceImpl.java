package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.UserEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderItemStatus;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderStatus;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.read.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.update.OrderSellerUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.update.OrderSellerUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductPicEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete.ProductDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete.ProductDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update.ProductUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update.ProductUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.create.PromotionCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.create.PromotionCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.delete.PromotionDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.delete.PromotionDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.read.PromotionProductReadBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.read.PromotionProductVariationReadBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.read.PromotionReadBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.read.PromotionReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.update.PromotionUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.update.PromotionUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.read.ProductDeliveryReadBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.read.ProductDeliveryReadDataBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.read.ProductDeliveryReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.create.ProductDeliveryCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.create.ProductDeliveryCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.delete.ProductDeliveryDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.delete.ProductDeliveryDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.update.ProductDeliveryUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.update.ProductDeliveryUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.statistics.StatisticsBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.statistics.StatisticsOrderHistoryBodyResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.statistics.StatisticsResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.create.TrackingRestRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.create.TrackingRestRequestBody;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.create.TrackingCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.read.TrackingReadResponseParam;
import com.th.ac.ku.kps.cpe.ecommerce.repository.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductVariationEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.unity.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.th.ac.ku.kps.cpe.ecommerce.controller.UploadAndDownloadController.UPLOAD_FOLDER;

@Service
@Configurable
public class SellerServiceImpl implements SellerService{
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ShopHasProductRepository shopHasProductRepository;
    private final CatagoryRepository catagoryRepository;
    private final ProductVariationRepository productVariationRepository;
    private final ProductPicRepository productPicRepository;
    private final ProductHasPromoRepository productHasPromoRepository;
    private final ProductDeliveryRepository productDeliveryRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final TypeShippingRepository typeShippingRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final OrderHistoryRepository orderHistoryRepository;
    private final RatingProductRepository ratingProductRepository;
    private final RatingProductPicRepository ratingProductPicRepository;
    private final ConfigRepository configRepository;

    @Autowired
    public SellerServiceImpl(ShopRepository shopRepository, ProductRepository productRepository, UserRepository userRepository, ShopHasProductRepository shopHasProductRepository, CatagoryRepository catagoryRepository, ProductVariationRepository productVariationRepository, ProductPicRepository productPicRepository, ProductHasPromoRepository productHasPromoRepository, ProductDeliveryRepository productDeliveryRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository, TypeShippingRepository typeShippingRepository, DeliveryAddressRepository deliveryAddressRepository, OrderHistoryRepository orderHistoryRepository, RatingProductRepository ratingProductRepository, RatingProductPicRepository ratingProductPicRepository, ConfigRepository configRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.shopHasProductRepository = shopHasProductRepository;
        this.catagoryRepository = catagoryRepository;
        this.productVariationRepository = productVariationRepository;
        this.productPicRepository = productPicRepository;
        this.productHasPromoRepository = productHasPromoRepository;
        this.productDeliveryRepository = productDeliveryRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.typeShippingRepository = typeShippingRepository;
        this.deliveryAddressRepository = deliveryAddressRepository;
        this.orderHistoryRepository = orderHistoryRepository;
        this.ratingProductRepository = ratingProductRepository;
        this.ratingProductPicRepository = ratingProductPicRepository;
        this.configRepository = configRepository;
    }

    @Override
    public ProductCreateResponse productCreateResponse(String token,ProductCreateRequest restRequest) {
        ProductCreateResponse response = new ProductCreateResponse();
        List<UserEntity> user = (List<UserEntity>) userRepository.findAllByToken(Collections.singleton(token));
        if (user.size() == 0) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        List<ShopEntity> shop = (List<ShopEntity>) shopRepository.findAllByIdUser(Collections.singleton(user.get(0).getIdUser()));
        if (shop.size() == 0) {
            response.setStatus(404);
            response.setMsg("Shop doesn't open!");
            return response;
        }
        ShopHasProductEntity shopHasProductEntity = new ShopHasProductEntity();


        ProductEntity productEntity;
        Date date = new Date();
        Timestamp timeNow = new Timestamp(date.getTime());
        if(restRequest.getBody().getProduct_variation() != null) {
            try {
                productRepository.save(restRequest.getBody().getCatagory(),
                        restRequest.getBody().getName_product(),
                        restRequest.getBody().getDescription(),
                        restRequest.getBody().getCondition(),
                        timeNow);
                productEntity = productRepository.getLastId();
                shopHasProductEntity.setIdProduct(productEntity.getIdProduct());
                shopHasProductEntity.setIdShop(shop.get(0).getIdShop());
                shopHasProductRepository.save(shopHasProductEntity);

            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(406);
                response.setMsg("Can't save product");
                return response;
            }

            for (int i = 0; i < restRequest.getBody().getProduct_variation().size(); i++) {
                ProductVariationEntity productVariationEntity = new ProductVariationEntity();
                productVariationEntity.setIdProduct(productEntity.getIdProduct());
                productVariationEntity.setName(restRequest.getBody().getProduct_variation().get(i).getName());
                productVariationEntity.setPrice(restRequest.getBody().getProduct_variation().get(i).getPrice());
                productVariationEntity.setStock(restRequest.getBody().getProduct_variation().get(i).getStock());
                try {
                    productVariationRepository.save(productVariationEntity);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    response.setStatus(406);
                    response.setMsg("Can't save variation");
                    return response;
                }
            }
            response.setStatus(201);
            response.setMsg("Created Product And Product variation");
        }
        else  {
            response.setStatus(400);
            response.setMsg("Product variation has required");
        }
        return response;
    }

    @Override
    public ProductReadResponse productReadAllResponse(String token) {
        ProductReadResponse response = new ProductReadResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        ShopEntity shop = shopRepository.findByIdUser(user.getIdUser());
        if (shop == null) {
            response.setStatus(404);
            response.setMsg("Shop doesn't open!");
            return response;
        }
        List<ShopHasProductEntity> shopHasProduct = shopHasProductRepository.findAllByIdShop(shop.getIdShop());

        ProductReadBodyResponse bodyResponse = new ProductReadBodyResponse();

        List<ProductReadProductBodyResponse> productBodyResponseList = new ArrayList<>();
        for (int i = 0; i < shopHasProduct.size(); i++) {
            ProductEntity product = productRepository.findByIdProduct(shopHasProduct.get(i).getIdProduct());
            CatagoryEntity catagory = catagoryRepository.findByIdCatagory(product.getCatagory());

            ProductReadProductBodyResponse productBodyResponse = new ProductReadProductBodyResponse();
            productBodyResponse.setId_product(product.getIdProduct());
            productBodyResponse.setName_product(product.getNameProduct());
            productBodyResponse.setDescription(product.getDescription());
            ProductReadCatagoryProductBodyResponse catagoryProductBodyResponse = new ProductReadCatagoryProductBodyResponse();
            catagoryProductBodyResponse.setId_category(catagory.getIdCatagory());
            catagoryProductBodyResponse.setName_category(catagory.getNameCatagory());
            productBodyResponse.setCatagory(catagoryProductBodyResponse);
            productBodyResponse.setCondition(product.getCondition());
            productBodyResponse.setCreated_at(product.getCreatedAt());

            List<ProductPicEntity> productPic = productPicRepository.findAllByIdProduct(product.getIdProduct());
            List<ProductReadProductpicProductBodyResponse> productpicProductBodyResponseList = new ArrayList<>();
            for (int j = 0; j < productPic.size(); j++) {
                ProductReadProductpicProductBodyResponse productpicProductBodyResponse = new ProductReadProductpicProductBodyResponse();
                productpicProductBodyResponse.setPic_product(productPic.get(j).getPicProduct());
                productpicProductBodyResponseList.add(productpicProductBodyResponse);
            }
            productBodyResponse.setProduct_pic(productpicProductBodyResponseList);

            List<ProductVariationEntity> productVariationList = productVariationRepository.findAllByIdProduct(product.getIdProduct());
            List<ProductReadVariationProductBodyResponse> variationProductBodyResponseList = new ArrayList<>();
            for (int j = 0; j < productVariationList.size(); j++) {
                ProductReadVariationProductBodyResponse variationProductBodyResponse = new ProductReadVariationProductBodyResponse();
                variationProductBodyResponse.setId_variation(productVariationList.get(j).getIdVariation());
                variationProductBodyResponse.setName(productVariationList.get(j).getName());
                variationProductBodyResponse.setPrice(productVariationList.get(j).getPrice());
                variationProductBodyResponse.setStock(productVariationList.get(j).getStock());

                List<ProductHasPromoEntity> productHasPromoList = productHasPromoRepository.findAllByIdProductVariation(productVariationList.get(j).getIdVariation());
                if (productHasPromoList.size() != 0) {
                    ProductReadPromotionVariationProductBodyResponse promotionVariationProductBodyResponse = new ProductReadPromotionVariationProductBodyResponse();
                    promotionVariationProductBodyResponse.setId_product_has_promo(productHasPromoList.get(0).getIdProductHasPromo());
                    promotionVariationProductBodyResponse.setId_promo_type(productHasPromoList.get(0).getIdPromoType());
                    promotionVariationProductBodyResponse.setNew_price(productHasPromoList.get(0).getNewPrice());
                    promotionVariationProductBodyResponse.setTime_start(productHasPromoList.get(0).getTimeStart());
                    promotionVariationProductBodyResponse.setTime_end(productHasPromoList.get(0).getTimeEnd());
                    variationProductBodyResponse.setPromotion(promotionVariationProductBodyResponse);
                }
                variationProductBodyResponseList.add(variationProductBodyResponse);
            }
            productBodyResponse.setProduct_variation(variationProductBodyResponseList);
            productBodyResponse.setMean_rating(product.getMean());
            productBodyResponse.setCount_rating(product.getCount());
            productBodyResponseList.add(productBodyResponse);
        }
        bodyResponse.setProduct(productBodyResponseList);
        response.setBody(bodyResponse);
        response.setStatus(200);
        response.setMsg("successful");
        return response;
    }

    @Override
    public ProductReadResponse productReadResponse(String token, int id_product) {
        ProductReadResponse response = new ProductReadResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        ShopEntity shop = shopRepository.findByIdUser(user.getIdUser());
        if (shop == null) {
            response.setStatus(404);
            response.setMsg("Shop doesn't open!");
            return response;
        }
        List<ShopHasProductEntity> shopHasProduct = shopHasProductRepository.findAllByIdShop(shop.getIdShop());

        ProductReadBodyResponse bodyResponse = new ProductReadBodyResponse();

        List<ProductReadProductBodyResponse> productBodyResponseList = new ArrayList<>();
        for (int i = 0; i < shopHasProduct.size(); i++) {
            if (shopHasProduct.get(i).getIdProduct() == id_product) {
                ProductEntity product = productRepository.findByIdProduct(shopHasProduct.get(i).getIdProduct());
                CatagoryEntity catagory = catagoryRepository.findByIdCatagory(product.getCatagory());

                ProductReadProductBodyResponse productBodyResponse = new ProductReadProductBodyResponse();
                productBodyResponse.setId_product(product.getIdProduct());
                productBodyResponse.setName_product(product.getNameProduct());
                productBodyResponse.setDescription(product.getDescription());
                ProductReadCatagoryProductBodyResponse catagoryProductBodyResponse = new ProductReadCatagoryProductBodyResponse();
                catagoryProductBodyResponse.setId_category(catagory.getIdCatagory());
                catagoryProductBodyResponse.setName_category(catagory.getNameCatagory());
                productBodyResponse.setCatagory(catagoryProductBodyResponse);
                productBodyResponse.setCondition(product.getCondition());
                productBodyResponse.setCreated_at(product.getCreatedAt());

                List<ProductPicEntity> productPic = productPicRepository.findAllByIdProduct(product.getIdProduct());
                List<ProductReadProductpicProductBodyResponse> productpicProductBodyResponseList = new ArrayList<>();
                for (int j = 0; j < productPic.size(); j++) {
                    ProductReadProductpicProductBodyResponse productpicProductBodyResponse = new ProductReadProductpicProductBodyResponse();
                    productpicProductBodyResponse.setPic_product(productPic.get(j).getPicProduct());
                    productpicProductBodyResponseList.add(productpicProductBodyResponse);
                }
                productBodyResponse.setProduct_pic(productpicProductBodyResponseList);

                List<ProductVariationEntity> productVariationList = productVariationRepository.findAllByIdProduct(product.getIdProduct());
                List<ProductReadVariationProductBodyResponse> variationProductBodyResponseList = new ArrayList<>();
                for (int j = 0; j < productVariationList.size(); j++) {
                    ProductReadVariationProductBodyResponse variationProductBodyResponse = new ProductReadVariationProductBodyResponse();
                    variationProductBodyResponse.setId_variation(productVariationList.get(j).getIdVariation());
                    variationProductBodyResponse.setName(productVariationList.get(j).getName());
                    variationProductBodyResponse.setPrice(productVariationList.get(j).getPrice());
                    variationProductBodyResponse.setStock(productVariationList.get(j).getStock());

                    List<ProductHasPromoEntity> productHasPromoList = productHasPromoRepository.findAllByIdProductVariation(productVariationList.get(j).getIdVariation());
                    if (productHasPromoList.size() != 0) {
                        ProductReadPromotionVariationProductBodyResponse promotionVariationProductBodyResponse = new ProductReadPromotionVariationProductBodyResponse();
                        promotionVariationProductBodyResponse.setId_product_has_promo(productHasPromoList.get(0).getIdProductHasPromo());
                        promotionVariationProductBodyResponse.setId_promo_type(productHasPromoList.get(0).getIdPromoType());
                        promotionVariationProductBodyResponse.setNew_price(productHasPromoList.get(0).getNewPrice());
                        promotionVariationProductBodyResponse.setTime_start(productHasPromoList.get(0).getTimeStart());
                        promotionVariationProductBodyResponse.setTime_end(productHasPromoList.get(0).getTimeEnd());
                        variationProductBodyResponse.setPromotion(promotionVariationProductBodyResponse);
                    }
                    variationProductBodyResponseList.add(variationProductBodyResponse);
                }
                productBodyResponse.setProduct_variation(variationProductBodyResponseList);

                List<ProductReadProductDeliveryBodyResponse> productDeliveryResponseList = new ArrayList<>();
                List<ProductDeliveryEntity> productDelivery = productDeliveryRepository.findAllByIdProduct(product.getIdProduct());
                for (ProductDeliveryEntity aProductDelivery : productDelivery) {
                    ProductReadProductDeliveryBodyResponse productDeliveryResponse = new ProductReadProductDeliveryBodyResponse();
                    productDeliveryResponse.setId_ship(aProductDelivery.getIdShip());
                    TypeShippingEntity typeShipping = typeShippingRepository.findByIdType(aProductDelivery.getIdType());
                    productDeliveryResponse.setName_ship(typeShipping.getNameShip());
                    productDeliveryResponse.setPrice(aProductDelivery.getPrice());
                    productDeliveryResponse.setTime_ship(aProductDelivery.getTimeShip());
                    productDeliveryResponseList.add(productDeliveryResponse);
                }

                productBodyResponse.setProduct_delivery(productDeliveryResponseList);
                productBodyResponse.setMean_rating(product.getMean());
                productBodyResponse.setCount_rating(product.getCount());

                List<ProductReadRatingProductBodyResponse> ratingResponseList = new ArrayList<>();
                List<OrderHistoryEntity> orderHistoryList = orderHistoryRepository.findAllByIdProduct(product.getIdProduct());
                for (int j = 0,countRating = 0; j < orderHistoryList.size(); j++) {
                    ProductReadRatingProductBodyResponse ratingResponse = new ProductReadRatingProductBodyResponse();
                    RatingProductEntity ratingProduct = ratingProductRepository.findByIdOrderHistory(orderHistoryList.get(j).getIdOrderHistory());
                    if (ratingProduct == null)
                        continue;
                    countRating++;
                    ratingResponse.setId_order_history(ratingProduct.getIdOrderHistory());
                    ratingResponse.setId_rating_product(ratingProduct.getIdRatingProduct());
                    ratingResponse.setId_user(orderHistoryList.get(j).getIdBuyer());
                    ratingResponse.setUsername(orderHistoryList.get(j).getUsernameBuyer());
                    ratingResponse.setRating(ratingProduct.getRating());
                    ratingResponse.setContent(ratingProduct.getContent());
                    ratingResponse.setRated_date(ratingProduct.getRatedDate());
                    ratingResponseList.add(ratingResponse);
                    List<RatingProductPicEntity> ratingProductPicList = ratingProductPicRepository.findAllByIdRatingProduct(ratingProduct.getIdRatingProduct());
                    List<String> picList = new ArrayList<>();
                    for (int k = 0; k < ratingProductPicList.size(); k++) {
                        picList.add(ratingProductPicList.get(k).getContentPic());
                    }
                    String[] picArr = new String[picList.size()];
                    picArr = picList.toArray(picArr);
                    ratingResponse.setRating_product_pic(picArr);
                    if (countRating >= 3) break;
                }
                productBodyResponse.setRating_product(ratingResponseList);
                productBodyResponseList.add(productBodyResponse);
            }
            bodyResponse.setProduct(productBodyResponseList);
        }
        response.setBody(bodyResponse);
        response.setStatus(200);
        response.setMsg("Successful");
        return response;
    }

    @Override
    public ProductUpdateResponse productUpdateResponse(String token, ProductUpdateRequest restRequest) {
        ProductUpdateResponse response = new ProductUpdateResponse();
        List<UserEntity> user = (List<UserEntity>) userRepository.findAllByToken(Collections.singleton(token));
        if (user.size() == 0) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        List<ShopEntity> shop = (List<ShopEntity>) shopRepository.findAllByIdUser(Collections.singleton(user.get(0).getIdUser()));
        if (shop.size() == 0) {
            response.setStatus(404);
            response.setMsg("Shop doesn't open!");
            return response;
        }
        List<ProductEntity> productEntity = (List<ProductEntity>) productRepository.findAllById(Collections.singleton(restRequest.getBody().getId_product()));
        Common.LoggerInfo(productEntity);

        if (productEntity.size() != 0) {
            if (restRequest.getBody().getCatagory() != null)
                productEntity.get(0).setCatagory(restRequest.getBody().getCatagory());
            if (restRequest.getBody().getName_product() != null)
                productEntity.get(0).setNameProduct(restRequest.getBody().getName_product());
            if (restRequest.getBody().getDescription() != null)
                productEntity.get(0).setDescription(restRequest.getBody().getDescription());
            if (restRequest.getBody().getCondition() != null)
                productEntity.get(0).setCondition(restRequest.getBody().getCondition());


            try {
                productRepository.save(productEntity.get(0));
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(406);
                response.setMsg("Can't save product");
                return response;
            }
        }

        if(restRequest.getBody().getProduct_variation() != null) {
            for (int i = 0; i < restRequest.getBody().getProduct_variation().size(); i++) {
                if (restRequest.getBody().getProduct_variation().get(i).getId_variation() == null) {
                    ProductVariationEntity productVariationEntity = new ProductVariationEntity();
                    productVariationEntity.setIdProduct(productEntity.get(0).getIdProduct());
                    productVariationEntity.setName(restRequest.getBody().getProduct_variation().get(i).getName());
                    productVariationEntity.setPrice(restRequest.getBody().getProduct_variation().get(i).getPrice());
                    productVariationEntity.setStock(restRequest.getBody().getProduct_variation().get(i).getStock());
                    try {
                        productVariationRepository.save(productVariationEntity);
                    } catch (Exception e) {
                        e.printStackTrace();
                        response.setStatus(406);
                        response.setMsg("Can't add variation. Exception : " + e.toString());
                        return response;
                    }
                }
                else {
                    List<ProductVariationEntity> productVariationEntity = (List<ProductVariationEntity>) productVariationRepository.findAllById(Collections.singleton(restRequest.getBody().getProduct_variation().get(i).getId_variation()));
                    productVariationEntity.get(0).setIdVariation(restRequest.getBody().getProduct_variation().get(i).getId_variation());
                    if (restRequest.getBody().getProduct_variation().get(i).getName() != null) {
                        productVariationEntity.get(0).setName(restRequest.getBody().getProduct_variation().get(i).getName());
                    }
                    if (restRequest.getBody().getProduct_variation().get(i).getPrice() != null) {
                        productVariationEntity.get(0).setPrice(restRequest.getBody().getProduct_variation().get(i).getPrice());
                    }
                    if (restRequest.getBody().getProduct_variation().get(i).getStock() != null) {
                        productVariationEntity.get(0).setStock(restRequest.getBody().getProduct_variation().get(i).getStock());
                    }
                    try {
                        productVariationRepository.save(productVariationEntity.get(0));
                    } catch (Exception e) {
                        e.printStackTrace();
                        response.setStatus(406);
                        response.setMsg("Can't update variation Exception : " + e.toString());
                        return response;
                    }
                }

            }
        }
        response.setStatus(200);
        response.setMsg("Updated");

        return response;
    }

    @Override
    public ProductDeleteResponse productDeleteResponse(String token, ProductDeleteRequest restRequest) {
        ProductDeleteResponse response = new ProductDeleteResponse();
        List<UserEntity> user = (List<UserEntity>) userRepository.findAllByToken(Collections.singleton(token));
        if (user.size() == 0) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        List<ShopEntity> shop = (List<ShopEntity>) shopRepository.findAllByIdUser(Collections.singleton(user.get(0).getIdUser()));
        if (shop.size() == 0) {
            response.setStatus(404);
            response.setMsg("Shop not found");
            return response;
        }
        List<ShopHasProductEntity> shopHasProductList = shopHasProductRepository.findAllByIdShop(shop.get(0).getIdShop());
        boolean foundVariation = false;
        boolean foundProduct = false;
        if (restRequest.getBody().getId_product() != null) {
            for (int i = 0; i < shopHasProductList.size(); i++) {
                for (int j = 0; j < restRequest.getBody().getId_product().length; j++) {
                    if (shopHasProductList.get(i).getIdProduct() == restRequest.getBody().getId_product()[j]) {
                        foundProduct = true;
                        for (int ll = 0; ll < restRequest.getBody().getId_product().length; ll++) {
                            List<ProductEntity> product = (List<ProductEntity>) productRepository.findAllById(Collections.singleton(restRequest.getBody().getId_product()[ll]));
                            if (product.size() == 0) {
                                response.setStatus(404);
                                response.setMsg("Product not found");
                                return response;
                            }

                            List<ProductPicEntity> productPic = productPicRepository.findAllByIdProduct(product.get(0).getIdProduct());

                            for (int k = 0; k < productPic.size(); k++) { // Delete File in Drive
                                File file = new File(UPLOAD_FOLDER + "//pic_product//" + product.get(ll).getIdProduct() + "//"+ productPic.get(k).getPicProduct());
                                if (file.exists()) {
                                    if (file.delete()) {
                                        Common.LoggerInfo("File deleted successfully");
                                    } else {
                                        Common.LoggerInfo("Fail to delete file");
                                    }
                                }
                                productPicRepository.delete(productPic.get(k));
                            }

                            ShopHasProductEntity shopHasProduct = new ShopHasProductEntity();
                            shopHasProduct.setIdShop(shop.get(0).getIdShop());
                            shopHasProduct.setIdProduct(restRequest.getBody().getId_product()[ll]);
                            shopHasProductRepository.delete(shopHasProduct);

                            productRepository.delete(product.get(0));
                        }
                    }
                }
            }
            if (!foundProduct) {
                response.setStatus(404);
                response.setMsg("Product not found");
                return response;
            }

        }
        else if (restRequest.getBody().getId_variation() != null) {
            List<ProductVariationEntity> productVariationList = new ArrayList<>();
            for (int i = 0; i < shopHasProductList.size(); i++) {
                List<ProductVariationEntity> productVariationEntityList = productVariationRepository.findAllByIdProduct(shopHasProductList.get(i).getIdProduct());
                productVariationList.addAll(productVariationEntityList);
            }
            int countFound = 0;
            for (int i = 0; i < restRequest.getBody().getId_variation().length; i++) {
                for (int j = 0; j < productVariationList.size(); j++) {
                    if (restRequest.getBody().getId_variation()[i].equals(productVariationList.get(j).getIdVariation())) {
                        countFound++;
                        break;
                    }
                }
            }
            if (countFound == restRequest.getBody().getId_variation().length) {
                foundVariation = true;
            }
            if (foundVariation) {
                for (int i = 0; i < restRequest.getBody().getId_variation().length; i++) {
                    try {
                        productVariationRepository.deleteById(restRequest.getBody().getId_variation()[i]);
                        Common.LoggerInfo(restRequest.getBody().getId_variation());
                    } catch (Exception e) {
                        response.setStatus(404);
                        response.setMsg("variation not found");
                        return response;
                    }
                }
            }
            else {
                response.setStatus(404);
                response.setMsg("variation not found");
                return response;
            }
        }
        response.setStatus(200);
        response.setMsg("Delete Successfully");
        return response;
    }

    @Override
    public ProductDeliveryReadResponse productDeliveryReadByIdProduct(String token,Integer id_product) {

        UserEntity user = userRepository.findByToken(token);
        ProductDeliveryReadResponse response = new ProductDeliveryReadResponse();
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }

        List<ProductDeliveryEntity> productDeliveryList = productDeliveryRepository.findAllByIdProduct(id_product);

        ProductDeliveryReadBodyResponse bodyResponse = new ProductDeliveryReadBodyResponse();
        List<ProductDeliveryReadDataBodyResponse> dataList = new ArrayList<>();
        for (ProductDeliveryEntity aProductDelivery : productDeliveryList) {
            ProductDeliveryReadDataBodyResponse data = new ProductDeliveryReadDataBodyResponse();
            data.setId_ship(aProductDelivery.getIdShip());
            data.setId_type(aProductDelivery.getIdType());
            TypeShippingEntity typeShipping = typeShippingRepository.findByIdType(aProductDelivery.getIdType());
            data.setName_ship(typeShipping.getNameShip());
            data.setPrice(aProductDelivery.getPrice());
            data.setTime_ship(aProductDelivery.getTimeShip());
            dataList.add(data);
        }
        bodyResponse.setProduct_delivery(dataList);
        response.setBody(bodyResponse);
        response.setStatus(200);
        response.setMsg("successful");
        return response;
    }

    @Override
    public ProductDeliveryCreateResponse productDeliveryCreate(String token, ProductDeliveryCreateRequest restRequest){
        UserEntity user = userRepository.findByToken(token);
        ProductDeliveryCreateResponse response = new ProductDeliveryCreateResponse();
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        ShopEntity my_shop = shopRepository.findByIdUser(user.getIdUser());
        if (my_shop == null) {
            response.setStatus(404);
            response.setMsg("Shop not open or shop invalid!");
            return response;
        }
        ShopHasProductEntity shopHasProduct = shopHasProductRepository.findByIdProduct(restRequest.getBody().getId_product());
        if (shopHasProduct == null || my_shop.getIdShop() != shopHasProduct.getIdShop()) {
            response.setStatus(403);
            response.setMsg("Product isn't yours.");
            return response;
        }

        ProductDeliveryEntity productDelivery = new ProductDeliveryEntity();
        productDelivery.setIdProduct(restRequest.getBody().getId_product());
        productDelivery.setIdType(restRequest.getBody().getId_type());
        productDelivery.setPrice(restRequest.getBody().getPrice());
        productDelivery.setTimeShip(restRequest.getBody().getTime_ship());
        try {
            productDeliveryRepository.save(productDelivery);
            response.setStatus(201);
            response.setMsg("Created");
        } catch (Exception e) {
            response.setStatus(406);
            response.setMsg("Can't create product delivery. Please check your input!");
        }
        return response;
    }

    @Override
    public ProductDeliveryUpdateResponse productDeliveryUpdate(String token, ProductDeliveryUpdateRequest restRequest) {
        UserEntity user = userRepository.findByToken(token);
        ProductDeliveryUpdateResponse response = new ProductDeliveryUpdateResponse();
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        ShopEntity my_shop = shopRepository.findByIdUser(user.getIdUser());
        if (my_shop == null) {
            response.setStatus(404);
            response.setMsg("Shop not open or shop invalid!");
            return response;
        }

        ProductDeliveryEntity productDeliveryEntity = productDeliveryRepository.findByIdShip(restRequest.getBody().getId_ship());
        if (productDeliveryEntity == null) {
            response.setStatus(404);
            response.setMsg("id_ship not found!");
            return response;
        }
        ShopHasProductEntity shopHasProduct = shopHasProductRepository.findByIdProduct(productDeliveryEntity.getIdProduct());
        if (my_shop.getIdShop() != shopHasProduct.getIdShop()) {
            response.setStatus(404);
            response.setMsg("id_ship isn't your!");
            return response;
        }

        if(restRequest.getBody().getId_product() != 0)
            productDeliveryEntity.setIdProduct(restRequest.getBody().getId_product());
        if(restRequest.getBody().getId_type() != 0)
            productDeliveryEntity.setIdType(restRequest.getBody().getId_type());
        if(restRequest.getBody().getPrice() != 0)
            productDeliveryEntity.setPrice(restRequest.getBody().getPrice());
        if(restRequest.getBody().getTime_ship() != null)
            productDeliveryEntity.setTimeShip(restRequest.getBody().getTime_ship());

        try {
            productDeliveryRepository.save(productDeliveryEntity);
            response.setStatus(200);
            response.setMsg("Update Successful");
        }catch (Exception e) {
            response.setStatus(406);
            response.setMsg("Have some error.");
        }
        return response;
    }

    @Override
    public ProductDeliveryDeleteResponse productDeliveryDelete(String token, ProductDeliveryDeleteRequest restRequest) {
        UserEntity user = userRepository.findByToken(token);
        ProductDeliveryDeleteResponse response = new ProductDeliveryDeleteResponse();
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        ShopEntity shop = shopRepository.findByIdUser(user.getIdUser());
        if (shop == null) {
            response.setStatus(404);
            response.setMsg("Shop not open or shop invalid!");
            return response;
        }


        ProductDeliveryEntity productDeliveryEntity = productDeliveryRepository.findByIdShip(restRequest.getBody().getId_ship());

        try {
            productDeliveryRepository.delete(productDeliveryEntity);
            response.setStatus(200);
            response.setMsg("Delete Success");
        }catch (Exception e) {
            response.setStatus(204);
            response.setMsg("Error. Exception : " + e.toString());
        }

        return response;
    }

    @Override
    public OrderForSellerReadResponse readAllOrderForSellerResponse(String token) {

        List<OrderEntity> order = orderRepository.findAllByOrderStatusOrOrderStatusOrOrderStatus(OrderStatus.PAID,OrderStatus.ORDERED,OrderStatus.CANCEL);
        List<OrderItemEntity> orderItem = new ArrayList<>();
        for (int i = 0; i < order.size(); i++) {
            orderItem.addAll(orderItemRepository.findAllByIdOrder(order.get(i).getIdOrder()));
        }
        List<ProductVariationEntity> productVariation = new ArrayList<>();
        for (int i = 0; i < orderItem.size(); i++) {
            productVariation.add(productVariationRepository.findByIdVariation(orderItem.get(i).getIdVariation()));
        }

        List<ProductEntity> product = new ArrayList<>();
        for (int i = 0; i < productVariation.size(); i++) {

            product.add(productRepository.findByIdProduct(productVariation.get(i).getIdProduct()));
        }
        List<ShopHasProductEntity> shopHasProduct = new ArrayList<>();
        for (int i = 0; i < product.size(); i++) {
            shopHasProduct.add(shopHasProductRepository.findByIdProduct(product.get(i).getIdProduct()));
        }
        List<ShopEntity> shop = new ArrayList<>();
        for (int i = 0; i < shopHasProduct.size(); i++) {
            shop.add(shopRepository.findByIdShop(shopHasProduct.get(i).getIdShop()));
        }
        List<UserEntity> user = new ArrayList<>();
        for (int i = 0; i < shop.size(); i++) {
            if (userRepository.findByIdUser(shop.get(i).getIdUser()).getToken().equals(token)) {
                user.add(userRepository.findByIdUser(shop.get(i).getIdUser()));
            }
        }
        OrderForSellerReadResponse response = new OrderForSellerReadResponse();
        OrderForSellerReadBodyResponse body = new OrderForSellerReadBodyResponse();
        List<OrderForSellerReadOrderItemBodyResponse> orderItemResponseList = new ArrayList<>();
        if (user.size() == 0) {
            response.setStatus(404);
            response.setMsg("User doesn't open shop or no order!");
            return response;
        }
        ShopEntity shopFound = shopRepository.findByIdUser(user.get(0).getIdUser());

        List<ShopHasProductEntity> shopHasProductFound = shopHasProductRepository.findAllByIdShop(shopFound.getIdShop());


        ReadOrderForSeller(orderItem, orderItemResponseList, shopHasProductFound);
        body.setOrder_item(orderItemResponseList);
        response.setBody(body);

        response.setStatus(200);
        response.setMsg("Success");
        return response;
    }

    @Override
    public OrderForSellerReadResponse readOrderForSellerResponse(String token, int id_item) {
        List<OrderEntity> order = orderRepository.findAllByOrderStatusOrOrderStatusOrOrderStatus(OrderStatus.PAID,OrderStatus.ORDERED,OrderStatus.CANCEL);
        List<OrderItemEntity> orderItem = new ArrayList<>();
        for (int i = 0; i < order.size(); i++) {
            orderItem.addAll(orderItemRepository.findAllByIdOrderAndIdItem(order.get(i).getIdOrder(),id_item));
        }
        Common.LoggerInfo(orderItem);
        List<ProductVariationEntity> productVariation = new ArrayList<>();
        for (int i = 0; i < orderItem.size(); i++) {
            productVariation.add(productVariationRepository.findByIdVariation(orderItem.get(i).getIdVariation()));
        }


        List<ProductEntity> product = new ArrayList<>();
        for (int i = 0; i < productVariation.size(); i++) {
            product.add(productRepository.findByIdProduct(productVariation.get(i).getIdProduct()));
        }
        List<ShopHasProductEntity> shopHasProduct = new ArrayList<>();
        for (int i = 0; i < product.size(); i++) {
            shopHasProduct.add(shopHasProductRepository.findByIdProduct(product.get(i).getIdProduct()));
        }
        List<ShopEntity> shop = new ArrayList<>();
        for (int i = 0; i < shopHasProduct.size(); i++) {
            shop.add(shopRepository.findByIdShop(shopHasProduct.get(i).getIdShop()));
        }
        List<UserEntity> user = new ArrayList<>();
        for (int i = 0; i < shop.size(); i++) {
            if (userRepository.findByIdUser(shop.get(i).getIdUser()).getToken().equals(token)) {
                user.add(userRepository.findByIdUser(shop.get(i).getIdUser()));
            }
        }
        OrderForSellerReadResponse response = new OrderForSellerReadResponse();
        OrderForSellerReadBodyResponse body = new OrderForSellerReadBodyResponse();
        List<OrderForSellerReadOrderItemBodyResponse> orderItemResponseList = new ArrayList<>();
        if (user.size() == 0) {
            response.setStatus(404);
            response.setMsg("User doesn't open shop or no order!");
            return response;
        }
        ShopEntity shopFound = shopRepository.findByIdUser(user.get(0).getIdUser());

        List<ShopHasProductEntity> shopHasProductFound = shopHasProductRepository.findAllByIdShop(shopFound.getIdShop());


        ReadOrderForSeller(orderItem, orderItemResponseList, shopHasProductFound);
        body.setOrder_item(orderItemResponseList);
        response.setBody(body);

        response.setStatus(200);
        response.setMsg("Success");
        return response;
    }

    private void ReadOrderForSeller(List<OrderItemEntity> orderItem, List<OrderForSellerReadOrderItemBodyResponse> orderItemResponseList, List<ShopHasProductEntity> shopHasProductFound) {
        for (int j = 0; j < shopHasProductFound.size(); j++) { // [{"idShop":1,"idProduct":1},{"idShop":1,"idProduct":2}]
            List<ProductVariationEntity> productVariationFound = productVariationRepository.findAllByIdProduct(shopHasProductFound.get(j).getIdProduct()); // see in id 1, 2

            for (int k = 0; k < productVariationFound.size(); k++) { // search same idVariation 1
                for (int l = 0; l < orderItem.size(); l++) {// search same idVariation 2
                    if (productVariationFound.get(k).getIdVariation() == orderItem.get(l).getIdVariation()) {
                        OrderForSellerReadOrderItemBodyResponse orderItemResponse = new OrderForSellerReadOrderItemBodyResponse();
                        orderItemResponse.setId_item(orderItem.get(l).getIdItem());
                        OrderForSellerReadVariationBodyResponse productVariationResponse = new OrderForSellerReadVariationBodyResponse();

                        productVariationResponse.setId_product(productVariationFound.get(k).getIdProduct());
                        ProductEntity product = productRepository.findByIdProduct(productVariationFound.get(k).getIdProduct());
                        productVariationResponse.setName_product(product.getNameProduct());
                        productVariationResponse.setId_variation(productVariationFound.get(k).getIdVariation());
                        productVariationResponse.setName_variation(productVariationFound.get(k).getName());
                        List<ProductPicEntity> productPic = productPicRepository.findAllByIdProduct(product.getIdProduct());
                        productVariationResponse.setPic_product(productPic.get(0).getPicProduct());
                        orderItemResponse.setProduct_variation(productVariationResponse);

                        orderItemResponse.setPrice(productVariationFound.get(k).getPrice() * orderItem.get(l).getQuantity());
                        orderItemResponse.setQuantity(orderItem.get(l).getQuantity());

                        OrderForSellerReadProductDeliveryBodyResponse shipOfShopResponse = new OrderForSellerReadProductDeliveryBodyResponse();

                        ProductDeliveryEntity productDeliveryEntity = productDeliveryRepository.findByIdShip(orderItem.get(l).getIdShipOfShop());
                        shipOfShopResponse.setId_ship(productDeliveryEntity.getIdShip());
                        shipOfShopResponse.setPrice_ship(productDeliveryEntity.getPrice());
                        TypeShippingEntity typeShippingEntity = typeShippingRepository.findByIdType(productDeliveryEntity.getIdType());
                        shipOfShopResponse.setType(typeShippingEntity.getNameShip());
                        shipOfShopResponse.setTime_ship(productDeliveryEntity.getTimeShip());
                        orderItemResponse.setProduct_delivery(shipOfShopResponse);
                        orderItemResponse.setTracking_number(orderItem.get(l).getTrackingNumber());
                        // Tracking
                        if (orderItem.get(l).getTrackingNumber() != null) {
                            TrackingServiceImpl trackingService = new TrackingServiceImpl();
                            TrackingReadResponseParam trackingResponseParam = trackingService.trackingReadAllResponse(typeShippingEntity.getNameShip(), orderItem.get(l).getTrackingNumber());

                            List<OrderForSellerCheckPointBodyResponse> checkpointList = new ArrayList<>();
                            if (trackingResponseParam.getData().getTracking() != null) {
                                for (int i = 0; i < trackingResponseParam.getData().getTracking().getCheckpoints().size(); i++) {
                                    if (trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getTag().equals("InTransit") && orderItem.get(l).getOrderItemStatus() == OrderItemStatus.NOT_SHIP) {
                                        orderItem.get(l).setOrderItemStatus(OrderItemStatus.SHIPPED);
                                    } else if (trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getTag().equals("Delivered") && (orderItem.get(l).getOrderItemStatus() == OrderItemStatus.NOT_SHIP || orderItem.get(l).getOrderItemStatus() == OrderItemStatus.SHIPPED)) {
                                        orderItem.get(l).setOrderItemStatus(OrderItemStatus.DELIVERED);
                                        if (orderItem.get(l).getExpiredBuyerConfirm() == null) {
                                            Date dt = new Date();
                                            Calendar c = Calendar.getInstance();
                                            c.setTime(dt);
                                            c.add(Calendar.HOUR, Integer.parseInt(configRepository.findByName("expired_buyer_confirm").getValue()));
                                            dt = c.getTime();
                                            Timestamp expired_buyer_confirm = new Timestamp(dt.getTime());
                                            orderItem.get(l).setExpiredBuyerConfirm(expired_buyer_confirm);
                                        }
                                    }
                                    OrderForSellerCheckPointBodyResponse checkpoint = new OrderForSellerCheckPointBodyResponse();
                                    checkpoint.setCheckpoint_time(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getCheckpoint_time());
                                    checkpoint.setCountry_iso3(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getCountry_iso3());
                                    checkpoint.setCountry_name(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getCountry_name());
                                    checkpoint.setCreated_at(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getCreated_at());
                                    checkpoint.setLocation(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getLocation());
                                    checkpoint.setMessage(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getMessage());
                                    checkpoint.setSlug(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getSlug());
                                    checkpoint.setSubtag(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getSubtag());
                                    checkpoint.setSubtag_message(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getSubtag_message());
                                    checkpoint.setTag(trackingResponseParam.getData().getTracking().getCheckpoints().get(i).getTag());
                                    checkpointList.add(checkpoint);
                                }
                                orderItemRepository.save(orderItem.get(l));
                            }
                            orderItemResponse.setCheckpoint(checkpointList);
                        }


                        orderItemResponseList.add(orderItemResponse);

                        OrderEntity orderEntity = orderRepository.findByIdOrder(orderItem.get(l).getIdOrder());
                        OrderForSellerReadOrderBodyResponse orderResponse = new OrderForSellerReadOrderBodyResponse();
                        orderResponse.setId_order(orderEntity.getIdOrder());
                        orderResponse.setId_buyer(orderEntity.getIdBuyer());
                        orderResponse.setOrder_created_at(orderEntity.getOrderCreatedAt());
                        orderResponse.setOrder_status(orderEntity.getOrderStatus());

                        DeliveryAddressEntity deliveryAddressEntity = deliveryAddressRepository.findByIdAddress(orderEntity.getIdAddress());
                        OrderForSellerDeliveryAddressOrderReadResponse deliveryResponse = new OrderForSellerDeliveryAddressOrderReadResponse();
                        deliveryResponse.setId_address(deliveryAddressEntity.getIdAddress());
                        deliveryResponse.setAddress(deliveryAddressEntity.getAddress());
                        deliveryResponse.setDistrict(deliveryAddressEntity.getDistrict());
                        deliveryResponse.setReceiver(deliveryAddressEntity.getReceiver());
                        deliveryResponse.setPhone_receiver(deliveryAddressEntity.getPhoneReceiver());
                        deliveryResponse.setPostal_code(deliveryAddressEntity.getPostalCode());
                        deliveryResponse.setProvince(deliveryAddressEntity.getProvince());
                        deliveryResponse.setSub_district(deliveryAddressEntity.getSubDistrict());

                        orderResponse.setDelivery_address(deliveryResponse);
                        orderItemResponse.setOrder(orderResponse);
                    }
                }
            }
        }
    }

    @Override
    public OrderSellerUpdateResponse updateOrderForSellerResponse(String token, OrderSellerUpdateRequest restRequest) {
        OrderSellerUpdateResponse response = new OrderSellerUpdateResponse();
        OrderItemEntity orderItem = orderItemRepository.findByIdItem(restRequest.getBody().getId_item());
        orderItem.setTrackingNumber(restRequest.getBody().getTracking_number());

        TrackingRestRequest trackingRequest = new TrackingRestRequest();
        TrackingRestRequestBody trackingBody = new TrackingRestRequestBody();

        ProductDeliveryEntity productDelivery = productDeliveryRepository.findByIdShip(orderItem.getIdShipOfShop());
        TypeShippingEntity typeShipping = typeShippingRepository.findByIdType(productDelivery.getIdType());

        trackingBody.setTracking_number(restRequest.getBody().getTracking_number());
        trackingBody.setSlug(typeShipping.getNameShip());
        trackingRequest.setTracking(trackingBody);


        TrackingServiceImpl tracking = new TrackingServiceImpl();

        try {
            TrackingCreateResponse trackingResponse = tracking.trackingPostResponse(trackingRequest);
            if (trackingResponse.getStatus() == 201) {
                orderItemRepository.save(orderItem);
                response.setStatus(trackingResponse.getStatus());
                response.setMsg("Updated! Tracking number");
            }
            else {
                response.setStatus(trackingResponse.getStatus());
                response.setMsg(trackingResponse.getMsg());
            }
        } catch (Exception e) {
            response.setStatus(204);
            response.setMsg("Error, Exception : " + e.toString());
        }
        return response;
    }

    @Override
    public PromotionReadResponse readPromotion(String token) {
        PromotionReadResponse response = new PromotionReadResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        Date date = new Date();
        Timestamp timeNow = new Timestamp(date.getTime());
        productHasPromoRepository.deleteAllByTimeEndBefore(timeNow);

        ShopEntity shop = shopRepository.findByIdUser(user.getIdUser());
        if (shop == null) {
            response.setStatus(404);
            response.setMsg("Shop not open");
            return response;
        }

        List<ProductHasPromoEntity> productHasPromo = productHasPromoRepository.findAll();
        List<ProductVariationEntity> productVariationList = new ArrayList<>();
        for (ProductHasPromoEntity aProductHasPromo : productHasPromo) {
            ProductVariationEntity productVariation = productVariationRepository.findByIdVariation(aProductHasPromo.getIdProductVariation());
            productVariationList.add(productVariation);
        }
        List<ProductEntity> allProductInMyPromotion = new ArrayList<>();
        for (int i = 0; i < productVariationList.size(); i++) {
            ProductEntity productInPromotion = productRepository.findByIdProduct(productVariationList.get(i).getIdProduct());
            if (shopHasProductRepository.findByIdProduct(productInPromotion.getIdProduct()).getIdShop() == shop.getIdShop()) {
                boolean flagHave = false;
                for (int j = 0; j < allProductInMyPromotion.size(); j++) {
                    if (allProductInMyPromotion.get(j).getIdProduct().equals(productInPromotion.getIdProduct())) {
                        flagHave = true;
                    }
                }
                if (!flagHave)
                    allProductInMyPromotion.add(productInPromotion);
            }
        }

        PromotionReadBodyResponse bodyResponse = new PromotionReadBodyResponse();
        List<PromotionProductReadBodyResponse> promotionProductList = new ArrayList<>();
        for (int i = 0; i < allProductInMyPromotion.size(); i++) {
            PromotionProductReadBodyResponse promotionProduct = new PromotionProductReadBodyResponse();
            promotionProduct.setId_product(allProductInMyPromotion.get(i).getIdProduct());
            promotionProduct.setName_product(allProductInMyPromotion.get(i).getNameProduct());
            List<ProductPicEntity> productPicEntity = productPicRepository.findAllByIdProduct(allProductInMyPromotion.get(i).getIdProduct());
            promotionProduct.setPic_product(productPicEntity.get(0).getPicProduct());

            List<PromotionProductVariationReadBodyResponse> promotionVariationResponseList = new ArrayList<>();
            List<ProductVariationEntity> productVariationEntityList = productVariationRepository.findAllByIdProduct(allProductInMyPromotion.get(i).getIdProduct());
            for (int j = 0; j < productVariationEntityList.size(); j++) {
                if (productHasPromoRepository.findByIdProductVariation(productVariationEntityList.get(j).getIdVariation()) != null) {
                    PromotionProductVariationReadBodyResponse promotionVariationResponse = new PromotionProductVariationReadBodyResponse();
                    promotionVariationResponse.setId_product_has_promo(productHasPromoRepository.findByIdProductVariation(productVariationEntityList.get(j).getIdVariation()).getIdProductHasPromo());
                    promotionVariationResponse.setId_variation(productVariationEntityList.get(j).getIdVariation());
                    promotionVariationResponse.setName(productVariationEntityList.get(j).getName());
                    promotionVariationResponse.setPrice(productVariationEntityList.get(j).getPrice());
                    promotionVariationResponse.setNew_price(productHasPromoRepository.findByIdProductVariation(productVariationEntityList.get(j).getIdVariation()).getNewPrice());
                    promotionVariationResponse.setTime_start(productHasPromoRepository.findByIdProductVariation(productVariationEntityList.get(j).getIdVariation()).getTimeStart());
                    promotionVariationResponse.setTime_end(productHasPromoRepository.findByIdProductVariation(productVariationEntityList.get(j).getIdVariation()).getTimeEnd());
                    promotionVariationResponseList.add(promotionVariationResponse);
                }
            }
            promotionProduct.setProduct_variation(promotionVariationResponseList);
            promotionProductList.add(promotionProduct);
        }
        bodyResponse.setPromotion_product(promotionProductList);
        response.setBody(bodyResponse);
        response.setStatus(200);
        response.setMsg("Successful");
        return response;
    }

    @Override
    public PromotionCreateResponse createPromotion(String token, PromotionCreateRequest restRequest) {
        PromotionCreateResponse response = new PromotionCreateResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        ProductHasPromoEntity productHasPromo = new ProductHasPromoEntity();
        if (restRequest.getId_product_variation() == null) {
            response.setStatus(400);
            response.setMsg("id_product_variation required");
            return response;
        }
        if (restRequest.getId_promo_type() == null) {
            response.setStatus(400);
            response.setMsg("id_promo_type required");
            return response;
        }
        if (restRequest.getNew_price() == null) {
            response.setStatus(400);
            response.setMsg("new_price required");
            return response;
        }
        if (restRequest.getTime_start() == null) {
            response.setStatus(400);
            response.setMsg("time_start required");
            return response;
        }
        Date date = new Date();
        Timestamp timeNow = new Timestamp(date.getTime());
        if (restRequest.getTime_start().before(timeNow)) {
            response.setStatus(400);
            response.setMsg("Can't create the past time");
            return response;
        }
        if (restRequest.getTime_end() == null) {
            response.setStatus(400);
            response.setMsg("time_end required");
            return response;
        }
        if (restRequest.getTime_start().after(restRequest.getTime_end())) {
            response.setStatus(400);
            response.setMsg("Cannot set the time end before the start time");
            return response;
        }
        ProductVariationEntity productVariationCheck = productVariationRepository.findByIdVariation(restRequest.getId_product_variation());
        if (productVariationCheck == null) {
            response.setStatus(404);
            response.setMsg("Product variaton not found !");
            return response;
        }
        ProductEntity productCheck = productRepository.findByIdProduct(productVariationCheck.getIdProduct());
        ShopHasProductEntity shopHasProductCheck = shopHasProductRepository.findByIdProduct(productCheck.getIdProduct());
        ShopEntity shopCheck = shopRepository.findByIdShop(shopHasProductCheck.getIdShop());
        if (user.getIdUser() != shopCheck.getIdUser()) {
            response.setStatus(406);
            response.setMsg("Not found product in shop");
            return response;
        }

        productHasPromoRepository.deleteAllByTimeEndBefore(timeNow);

        ProductHasPromoEntity productHasPromoCheck = productHasPromoRepository.findByIdProductVariation(restRequest.getId_product_variation());
        Common.LoggerInfo(productHasPromoCheck);
        if (productHasPromoCheck != null) {
            response.setStatus(406);
            response.setMsg("This promotion is already available.");
            return response;
        }
        productHasPromo.setIdPromoType(restRequest.getId_promo_type());
        productHasPromo.setIdProductVariation(restRequest.getId_product_variation());
        productHasPromo.setNewPrice(restRequest.getNew_price());
        productHasPromo.setTimeStart(restRequest.getTime_start());
        productHasPromo.setTimeEnd(restRequest.getTime_end());
        productHasPromoRepository.save(productHasPromo);
        response.setStatus(200);
        response.setMsg("Created Promotion!");
        return response;
    }

    @Override
    public PromotionUpdateResponse updatePromotion(String token, PromotionUpdateRequest restRequest) {
        PromotionUpdateResponse response = new PromotionUpdateResponse();
        Date date = new Date();
        Timestamp timeNow = new Timestamp(date.getTime());
        productHasPromoRepository.deleteAllByTimeEndBefore(timeNow);
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        if (restRequest.getId_product_has_promo() == null) {
            response.setStatus(400);
            response.setMsg("Id_product_has_promo is required");
            return response;
        }
        ProductHasPromoEntity productHasPromoCheck = productHasPromoRepository.findByIdProductHasPromo(restRequest.getId_product_has_promo());
        if (productHasPromoCheck == null) {
            response.setStatus(404);
            response.setMsg("Product has promo not found!");
            return response;
        }
        ProductVariationEntity productVariationCheck = productVariationRepository.findByIdVariation(productHasPromoCheck.getIdProductVariation());
        ProductEntity productCheck = productRepository.findByIdProduct(productVariationCheck.getIdProduct());
        ShopHasProductEntity shopHasProductCheck = shopHasProductRepository.findByIdProduct(productCheck.getIdProduct());
        ShopEntity shopCheck = shopRepository.findByIdShop(shopHasProductCheck.getIdShop());
        if (user.getIdUser() != shopCheck.getIdUser()) {
            response.setStatus(406);
            response.setMsg("Product has promo not found in your shop!");
            return response;
        }

        if (restRequest.getId_promo_type() != null)
            productHasPromoCheck.setIdPromoType(restRequest.getId_promo_type());
        if (restRequest.getNew_price() != null) {
            if (productHasPromoCheck.getTimeStart().before(timeNow)) {
                response.setStatus(406);
                response.setMsg("Cannot update new price. In the promotion period");
                return response;
            }
            productHasPromoCheck.setNewPrice(restRequest.getNew_price());
        }
        if (restRequest.getTime_start() != null) {
            if (productHasPromoCheck.getTimeStart().before(timeNow)) {
                response.setStatus(406);
                response.setMsg("Cannot update time start. In the promotion period");
                return response;
            }
            if (restRequest.getTime_start().before(timeNow)) {
                response.setStatus(406);
                response.setMsg("Can't update the past time");
                return response;
            }
            if (restRequest.getTime_start().after(productHasPromoCheck.getTimeEnd())) {
                response.setStatus(400);
                response.setMsg("Cannot set the time start after the start end");
                return response;
            }
            productHasPromoCheck.setTimeStart(restRequest.getTime_start());
        }
        if (restRequest.getTime_end() != null) {
            if (productHasPromoCheck.getTimeStart().after(restRequest.getTime_end())) {
                response.setStatus(400);
                response.setMsg("Cannot set the time end before the start time");
                return response;
            }
            productHasPromoCheck.setTimeEnd(restRequest.getTime_end());
        }
        productHasPromoRepository.save(productHasPromoCheck);
        response.setStatus(200);
        response.setMsg("Update Successful");
        return response;
    }

    @Override
    public PromotionDeleteResponse deletePromotion(String token, PromotionDeleteRequest restRequest) {
        PromotionDeleteResponse response = new PromotionDeleteResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        if (restRequest.getId_product_has_promo() == null) {
            response.setStatus(400);
            response.setMsg("Id_product_has_promo is required");
            return response;
        }
        ProductHasPromoEntity productHasPromoCheck = productHasPromoRepository.findByIdProductHasPromo(restRequest.getId_product_has_promo());
        if (productHasPromoCheck == null) {
            response.setStatus(404);
            response.setMsg("Product has promo not found!");
            return response;
        }
        ProductVariationEntity productVariationCheck = productVariationRepository.findByIdVariation(productHasPromoCheck.getIdProductVariation());
        ProductEntity productCheck = productRepository.findByIdProduct(productVariationCheck.getIdProduct());
        ShopHasProductEntity shopHasProductCheck = shopHasProductRepository.findByIdProduct(productCheck.getIdProduct());
        ShopEntity shopCheck = shopRepository.findByIdShop(shopHasProductCheck.getIdShop());
        if (user.getIdUser() != shopCheck.getIdUser()) {
            response.setStatus(406);
            response.setMsg("Product has promo not found in your shop!");
            return response;
        }
        Date date = new Date();
        Timestamp timeNow = new Timestamp(date.getTime());
        productHasPromoRepository.deleteAllByTimeEndBefore(timeNow);

        if (productHasPromoCheck.getTimeStart().before(timeNow)) {
            response.setStatus(406);
            response.setMsg("Cannot delete. In the promotion period");
            return response;
        }

        productHasPromoRepository.delete(productHasPromoCheck);
        response.setStatus(200);
        response.setMsg("Delete Successful");
        return response;
    }

    @Override
    public StatisticsResponse readStatistics(String token, Integer day_1, Integer month_1, Integer year_1, Integer day_2, Integer month_2, Integer year_2) {
        StatisticsResponse response = new StatisticsResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        if (!isValidDate(year_1 + "-" + month_1 + "-" + day_1)) {
            response.setStatus(406);
            response.setMsg("Invalid initial date!");
            return response;
        }
        if (!isValidDate(year_2 + "-" + month_2 + "-" + day_2)) {
            response.setStatus(406);
            response.setMsg("Invalid final date!");
            return response;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date_1;
        Date date_2;
        try {
            date_1 = dateFormat.parse(year_1 + "-" + month_1 + "-" + day_1);
            date_2 = dateFormat.parse(year_2 + "-" + month_2 + "-" + day_2);
        } catch (Exception e) {
            response.setStatus(406);
            response.setMsg("Invalid date!");
            return response;
        }
        // pass
        ShopEntity shop = shopRepository.findByIdUser(user.getIdUser());
        List<OrderHistoryEntity> orderHistoryList = orderHistoryRepository.findAllBySuccessfulDateGreaterThanEqualAndSuccessfulDateLessThanEqualAndIdShop(date_1, date_2, shop.getIdShop());

        StatisticsBodyResponse body = new StatisticsBodyResponse();
        List<StatisticsOrderHistoryBodyResponse> orderHistoryListResponse = new ArrayList<>();
        Double total_income = 0.0;
        for (int i = 0; i < orderHistoryList.size(); i++) {
            StatisticsOrderHistoryBodyResponse orderHistoryResponse = new StatisticsOrderHistoryBodyResponse();
            orderHistoryResponse.setId_order_history(orderHistoryList.get(i).getIdOrderHistory());
            orderHistoryResponse.setId_buyer(orderHistoryList.get(i).getIdBuyer());
            orderHistoryResponse.setUsername_buyer(orderHistoryList.get(i).getUsernameBuyer());
            orderHistoryResponse.setId_item(orderHistoryList.get(i).getIdItem());
            orderHistoryResponse.setId_product(orderHistoryList.get(i).getIdProduct());
            orderHistoryResponse.setName_product(orderHistoryList.get(i).getNameProduct());
            orderHistoryResponse.setId_variation(orderHistoryList.get(i).getIdVariation());
            orderHistoryResponse.setName_variation(orderHistoryList.get(i).getNameVariation());
            orderHistoryResponse.setQuantity(orderHistoryList.get(i).getQuantity());
            orderHistoryResponse.setPrice(orderHistoryList.get(i).getPrice());
            orderHistoryResponse.setStatus(orderHistoryList.get(i).getStatus());
            orderHistoryResponse.setSuccessful_date(orderHistoryList.get(i).getSuccessfulDate());
            orderHistoryResponse.setIncome(orderHistoryList.get(i).getQuantity()*orderHistoryList.get(i).getPrice());
            total_income += orderHistoryList.get(i).getQuantity()*orderHistoryList.get(i).getPrice();
            orderHistoryListResponse.add(orderHistoryResponse);
        }
        body.setOrder_history(orderHistoryListResponse);
        body.setTotal_income(total_income);
        response.setBody(body);
        response.setStatus(200);
        response.setMsg("Successful");
        return response;
    }

    @Override
    public ResponseEntity<?> readStatistics(String token, Integer id_product) {
        StatisticsResponse response = new StatisticsResponse();
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        ShopEntity shop = shopRepository.findByIdUser(user.getIdUser());
        if (shop == null) {
            response.setStatus(404);
            response.setMsg("Shop doesn't open!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        ShopHasProductEntity shopHasProduct = shopHasProductRepository.findByIdProduct(id_product);
        if (shopHasProduct == null || shop.getIdShop() != shopHasProduct.getIdShop()) {
            response.setStatus(403);
            response.setMsg("This product isn't your");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

        List<OrderHistoryEntity> orderHistoryList = orderHistoryRepository.findAllByIdProduct(id_product);
        StatisticsBodyResponse body = new StatisticsBodyResponse();
        double total_income = 0.0;
        List<StatisticsOrderHistoryBodyResponse> orderHistoryResponseList = new ArrayList<>();
        for (OrderHistoryEntity anOrderHistory : orderHistoryList) {
            StatisticsOrderHistoryBodyResponse orderHistoryResponse = new StatisticsOrderHistoryBodyResponse();
            orderHistoryResponse.setId_buyer(anOrderHistory.getIdBuyer());
            orderHistoryResponse.setId_item(anOrderHistory.getIdItem());
            orderHistoryResponse.setId_order_history(anOrderHistory.getIdOrderHistory());
            orderHistoryResponse.setUsername_buyer(anOrderHistory.getUsernameBuyer());
            orderHistoryResponse.setId_product(anOrderHistory.getIdProduct());
            orderHistoryResponse.setName_product(anOrderHistory.getNameProduct());
            orderHistoryResponse.setId_variation(anOrderHistory.getIdVariation());
            orderHistoryResponse.setName_variation(anOrderHistory.getNameVariation());
            orderHistoryResponse.setType_shipping(anOrderHistory.getTypeShipping());
            orderHistoryResponse.setQuantity(anOrderHistory.getQuantity());
            orderHistoryResponse.setPrice(anOrderHistory.getPrice());
            orderHistoryResponse.setShipping_price(anOrderHistory.getShippingPrice());
            orderHistoryResponse.setIncome(anOrderHistory.getPrice()+anOrderHistory.getShippingPrice());
            total_income += (anOrderHistory.getPrice() + anOrderHistory.getShippingPrice());
            orderHistoryResponse.setReceiver(anOrderHistory.getReceiver());
            orderHistoryResponse.setAddress(anOrderHistory.getAddress());
            orderHistoryResponse.setSub_district(anOrderHistory.getSubDistrict());
            orderHistoryResponse.setDistrict(anOrderHistory.getDistrict());
            orderHistoryResponse.setProvince(anOrderHistory.getProvince());
            orderHistoryResponse.setPostal_code(anOrderHistory.getPostalCode());
            orderHistoryResponse.setName_type_payment(anOrderHistory.getNameTypePayment());
            orderHistoryResponse.setStatus(anOrderHistory.getStatus());
            orderHistoryResponse.setSuccessful_date(anOrderHistory.getSuccessfulDate());
            orderHistoryResponseList.add(orderHistoryResponse);
        }
        body.setOrder_history(orderHistoryResponseList);
        body.setTotal_income(total_income);
        body.setTotal_sold(orderHistoryList.size());
        response.setBody(body);
        response.setStatus(200);
        response.setMsg("Successful");

        return ResponseEntity.ok(response);
    }

    private static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
