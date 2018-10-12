package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.CatagoryEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.ShopHasProductEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.core.UserEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductPicEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read.*;
import com.th.ac.ku.kps.cpe.ecommerce.repository.*;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductVariationEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.*;
import com.th.ac.ku.kps.cpe.ecommerce.unity.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
@Configurable
public class SellerServiceImpl implements SellerService{
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ShopHasProductRepository shopHasProductRepository;
    private final CatagoryRepository catagoryRepository;

    @Autowired
    public SellerServiceImpl(ShopRepository shopRepository,
                             ProductRepository productRepository,
                             UserRepository userRepository,
                             ShopHasProductRepository shopHasProductRepository,
                             CatagoryRepository catagoryRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.shopHasProductRepository = shopHasProductRepository;
        this.catagoryRepository = catagoryRepository;
    }

    @Override
    public ShopCreateResponse shopCreateResponse(ShopCreateRequest restRequest) {

        ShopCreateResponse response = new ShopCreateResponse();
        ShopCreateResponseBody responseBody = new ShopCreateResponseBody();
        ShopEntity shop = new ShopEntity();

        shop.setIdUser(restRequest.getHeader().getId_user());
        shop.setNameShop(restRequest.getRequest().getName_shop());
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        shop.setCreatedAt(timestamp);

        try {
            shopRepository.save(shop);
            responseBody.setResult_code(201);
            responseBody.setResult_description("สร้างร้านค้าสำเร็จ");
            response.setResult(responseBody);
        }
        catch (Exception ex) {
            responseBody.setResult_code(406);
            responseBody.setResult_description("ไม่สามารถสร้างได้ เนื่องจากเกิดข้อผิดพลาดบางอย่าง");
            response.setResult(responseBody);
        }
        return response;
    }

    @Override
    public ShopUpdateResponse shopUpdateResponse(ShopUpdateRequest restRequest) {
        Optional<ShopEntity> shopEntity = shopRepository.findById(restRequest.getHeader().getId_user());
        Common.LoggerInfo(shopEntity);
        return null;
    }

    @Override
    public ProductCreateResponse productCreateResponse(ProductCreateRequest restRequest) {
        ProductEntity productEntity = new ProductEntity();
//        productEntity.setCatagory(restRequest.getBody().getCatagory());
        productEntity.setNameProduct(restRequest.getBody().getName_product());
        productEntity.setDescription(restRequest.getBody().getDescription());
        productEntity.setCondition(restRequest.getBody().getCondition());
        Date date = new Date();
        Timestamp timeNow = new Timestamp(date.getTime());
        productEntity.setCreatedAt(timeNow);

        ProductPicEntity productPicEntity = new ProductPicEntity();
        productPicEntity.setPicProduct(restRequest.getBody().getProduct_pic().getPic_product());

        ProductVariationEntity productVariationEntity = new ProductVariationEntity();
        productVariationEntity.setName(restRequest.getBody().getProduct_variation().getName());
        productVariationEntity.setPrice(restRequest.getBody().getProduct_variation().getPrice());
//        try {
//            productRepository.save(productEntity);
//        }

        return null;
    }

    @Override
    public ProductReadResponse productReadAllResponse(String token) {
        List<UserEntity> user = (List<UserEntity>) userRepository.findAllByToken(Collections.singleton(token));
        List<ShopEntity> shop = (List<ShopEntity>) shopRepository.findAllByIdUser(Collections.singleton(user.get(0).getIdUser()));
        List<ShopHasProductEntity> shopHasProduct = (List<ShopHasProductEntity>) shopHasProductRepository.findAllByIdShop(Collections.singleton(shop.get(0).getIdShop()));
        Common.LoggerInfo(shopHasProduct);
        ProductReadResponse response = new ProductReadResponse();
        ProductReadBodyResponse bodyResponse = new ProductReadBodyResponse();
        List<ProductReadProductBodyResponse> productBodyResponseList = new ArrayList<>();
        for (int i = 0; i < shopHasProduct.size(); i++) {
            List<ProductEntity> product = (List<ProductEntity>) productRepository.findAllById(Collections.singleton(shopHasProduct.get(i).getIdProduct()));
            List<CatagoryEntity> catagory = (List<CatagoryEntity>) catagoryRepository.findAllByIdCatagory(Collections.singleton(product.get(0).getCatagory().getIdCatagory()));

            ProductReadProductBodyResponse productBodyResponse = new ProductReadProductBodyResponse();
            productBodyResponse.setId_product(product.get(0).getIdProduct());
            productBodyResponse.setName_product(product.get(0).getNameProduct());
            productBodyResponse.setDescription(product.get(0).getDescription());
            ProductReadCatagoryProductBodyResponse catagoryProductBodyResponse = new ProductReadCatagoryProductBodyResponse();
            catagoryProductBodyResponse.setId_category(catagory.get(0).getIdCatagory());
            catagoryProductBodyResponse.setName_category(catagory.get(0).getNameCatagory());
            productBodyResponse.setCatagory(catagoryProductBodyResponse);
            productBodyResponse.setCondition(product.get(0).getCondition());
            productBodyResponse.setCreated_at(product.get(0).getCreatedAt());

            List<ProductPicEntity> productPicEntityList = new ArrayList<>(product.get(0).getProductPicEntitySet());
            List<ProductReadProductpicProductBodyResponse> productpicProductBodyResponseList = new ArrayList<>();
            for (int j = 0; j < product.get(0).getProductPicEntitySet().size(); j++) {
                ProductReadProductpicProductBodyResponse productpicProductBodyResponse = new ProductReadProductpicProductBodyResponse();
                productpicProductBodyResponse.setPic_product(productPicEntityList.get(j).getPicProduct());
                productpicProductBodyResponseList.add(productpicProductBodyResponse);
            }
            productBodyResponse.setProduct_pic(productpicProductBodyResponseList);

            List<ProductVariationEntity> productVariationEntityList = new ArrayList<>(product.get(0).getProductVariationEntitySet());
            List<ProductReadVariationProductBodyResponse> variationProductBodyResponseList = new ArrayList<>();
            for (int j = 0; j < product.get(0).getProductVariationEntitySet().size(); j++) {
                ProductReadVariationProductBodyResponse variationProductBodyResponse = new ProductReadVariationProductBodyResponse();
                variationProductBodyResponse.setId_variation(productVariationEntityList.get(j).getIdVariation());
                variationProductBodyResponse.setName(productVariationEntityList.get(j).getName());
                variationProductBodyResponse.setPrice(productVariationEntityList.get(j).getPrice());
                variationProductBodyResponse.setStock(productVariationEntityList.get(j).getStock());

                if (productVariationEntityList.get(j).getProductHasPromoEntitySet() != null) {
                    ProductReadPromotionVariationProductBodyResponse promotionVariationProductBodyResponse = new ProductReadPromotionVariationProductBodyResponse();
                    promotionVariationProductBodyResponse.setId_promo_type(productVariationEntityList.get(j).getProductHasPromoEntitySet().getIdPromoType());
                    promotionVariationProductBodyResponse.setNew_price(productVariationEntityList.get(j).getProductHasPromoEntitySet().getNewPrice());
                    promotionVariationProductBodyResponse.setTime_start(productVariationEntityList.get(j).getProductHasPromoEntitySet().getTimeStart());
                    promotionVariationProductBodyResponse.setTime_end(productVariationEntityList.get(j).getProductHasPromoEntitySet().getTimeEnd());
                    variationProductBodyResponse.setPromotion(promotionVariationProductBodyResponse);
                }
                variationProductBodyResponseList.add(variationProductBodyResponse);
            }
            productBodyResponse.setProduct_variation(variationProductBodyResponseList);
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
        List<UserEntity> user = (List<UserEntity>) userRepository.findAllByToken(Collections.singleton(token));
        List<ShopEntity> shop = (List<ShopEntity>) shopRepository.findAllByIdUser(Collections.singleton(user.get(0).getIdUser()));
        List<ShopHasProductEntity> shopHasProduct = (List<ShopHasProductEntity>) shopHasProductRepository.findAllByIdShop(Collections.singleton(shop.get(0).getIdShop()));
        Common.LoggerInfo(shopHasProduct);
        for(int i = 0; i < shopHasProduct.size(); i++) {
            if (shopHasProduct.get(i).getIdProduct() == id_product) {
                List<ProductEntity> product = (List<ProductEntity>) productRepository.findAllById(Collections.singleton(shopHasProduct.get(i).getIdProduct()));
                Common.LoggerInfo(product);
                ProductReadResponse response = new ProductReadResponse();
                ProductReadBodyResponse bodyResponse = new ProductReadBodyResponse();

                List<ProductReadProductBodyResponse> productBodyResponseList = new ArrayList<>();
                List<CatagoryEntity> catagory = (List<CatagoryEntity>) catagoryRepository.findAllByIdCatagory(Collections.singleton(product.get(0).getCatagory().getIdCatagory()));
                ProductReadProductBodyResponse productBodyResponse = new ProductReadProductBodyResponse();
                productBodyResponse.setId_product(product.get(0).getIdProduct());
                productBodyResponse.setName_product(product.get(0).getNameProduct());
                productBodyResponse.setDescription(product.get(0).getDescription());
                ProductReadCatagoryProductBodyResponse catagoryProductBodyResponse = new ProductReadCatagoryProductBodyResponse();
                catagoryProductBodyResponse.setId_category(catagory.get(0).getIdCatagory());
                catagoryProductBodyResponse.setName_category(catagory.get(0).getNameCatagory());
                productBodyResponse.setCatagory(catagoryProductBodyResponse);
                productBodyResponse.setCondition(product.get(0).getCondition());
                productBodyResponse.setCreated_at(product.get(0).getCreatedAt());

                List<ProductPicEntity> productPicEntityList = new ArrayList<>(product.get(0).getProductPicEntitySet());
                List<ProductReadProductpicProductBodyResponse> productpicProductBodyResponseList = new ArrayList<>();
                for (int j = 0; j < product.get(0).getProductPicEntitySet().size(); j++) {
                    ProductReadProductpicProductBodyResponse productpicProductBodyResponse = new ProductReadProductpicProductBodyResponse();
                    productpicProductBodyResponse.setPic_product(productPicEntityList.get(j).getPicProduct());
                    productpicProductBodyResponseList.add(productpicProductBodyResponse);
                }
                productBodyResponse.setProduct_pic(productpicProductBodyResponseList);

                List<ProductVariationEntity> productVariationEntityList = new ArrayList<>(product.get(0).getProductVariationEntitySet());
                List<ProductReadVariationProductBodyResponse> variationProductBodyResponseList = new ArrayList<>();
                for (int j = 0; j < product.get(0).getProductVariationEntitySet().size(); j++) {
                    ProductReadVariationProductBodyResponse variationProductBodyResponse = new ProductReadVariationProductBodyResponse();
                    variationProductBodyResponse.setId_variation(productVariationEntityList.get(j).getIdVariation());
                    variationProductBodyResponse.setName(productVariationEntityList.get(j).getName());
                    variationProductBodyResponse.setPrice(productVariationEntityList.get(j).getPrice());
                    variationProductBodyResponse.setStock(productVariationEntityList.get(j).getStock());

                    if (productVariationEntityList.get(j).getProductHasPromoEntitySet() != null) {
                        ProductReadPromotionVariationProductBodyResponse promotionVariationProductBodyResponse = new ProductReadPromotionVariationProductBodyResponse();
                        promotionVariationProductBodyResponse.setId_promo_type(productVariationEntityList.get(j).getProductHasPromoEntitySet().getIdPromoType());
                        promotionVariationProductBodyResponse.setNew_price(productVariationEntityList.get(j).getProductHasPromoEntitySet().getNewPrice());
                        promotionVariationProductBodyResponse.setTime_start(productVariationEntityList.get(j).getProductHasPromoEntitySet().getTimeStart());
                        promotionVariationProductBodyResponse.setTime_end(productVariationEntityList.get(j).getProductHasPromoEntitySet().getTimeEnd());
                        variationProductBodyResponse.setPromotion(promotionVariationProductBodyResponse);
                    }
                    variationProductBodyResponseList.add(variationProductBodyResponse);
                }
                productBodyResponse.setProduct_variation(variationProductBodyResponseList);
                productBodyResponseList.add(productBodyResponse);
                bodyResponse.setProduct(productBodyResponseList);
                response.setBody(bodyResponse);
                response.setStatus(200);
                response.setMsg("successful");
                return response;
            }
        }
        return null;
    }
}
