package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.RatingProductPicEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.ShopHasProductEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.UserEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductPicEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.ShopEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.upload.UploadFileResponse;
import com.th.ac.ku.kps.cpe.ecommerce.repository.*;
import com.th.ac.ku.kps.cpe.ecommerce.unity.Common;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class UploadFileServiceImpl implements UploadFileService {
    private final ProductPicRepository productPicRepository;
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;
    private final ShopHasProductRepository shopHasProductRepository;
    private final RatingProductPicRepository ratingProductPicRepository;
    public UploadFileServiceImpl(ProductPicRepository productPicRepository, UserRepository userRepository, ShopRepository shopRepository, ShopHasProductRepository shopHasProductRepository, RatingProductPicRepository ratingProductPicRepository) {
        this.productPicRepository = productPicRepository;
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
        this.shopHasProductRepository = shopHasProductRepository;
        this.ratingProductPicRepository = ratingProductPicRepository;
    }

    @Override
    public UploadFileResponse uploadResponse(String token, Integer id, MultipartFile file, String UPLOAD_FOLDER, String type) {

        UserEntity user = userRepository.findByToken(token);
        UploadFileResponse response = new UploadFileResponse();
        if (user == null) {
            response.setStatus(404);
            response.setMsg("User not found. Please check token");
            return response;
        }
        if (type.equals("product")) {
            ShopEntity shop = shopRepository.findByIdUser(user.getIdUser());
            if (shop == null) {
                response.setStatus(404);
                response.setMsg("Shop not open or shop invalid!");
                return response;
            }
            List<ShopHasProductEntity> shopHasProduct = shopHasProductRepository.findAllByIdShop(shop.getIdShop());
            boolean foundProduct = false;
            for (ShopHasProductEntity aShopHasProduct : shopHasProduct) {
                if (aShopHasProduct.getIdProduct().equals(id)) {
                    foundProduct = true;
                    break;
                }
            }
            if (!foundProduct) {
                response.setStatus(404);
                response.setMsg("Product not found!");
            }


            ProductPicEntity productPicEntity = new ProductPicEntity();

            String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            String filename = new Random().nextInt(999999) + "_" + System.currentTimeMillis();
            File targetFile = new File(UPLOAD_FOLDER + "//pic_product//" + Integer.toString(id) + "//" + filename + fileExtension);
            try {
                File tmpDir = new File(UPLOAD_FOLDER + "//pic_product//" + Integer.toString(id));
                boolean exists = tmpDir.exists();
                Common.LoggerInfo(exists);
                if (!exists) {
                    new File(UPLOAD_FOLDER + "//pic_product//" + Integer.toString(id)).mkdir();
                }
                file.transferTo(targetFile);
                productPicEntity.setIdProduct(id);
                productPicEntity.setPicProduct(filename + fileExtension);
                productPicRepository.save(productPicEntity);

                response.setStatus(200);
                response.setMsg("Upload successfully");

            } catch (IOException e) {
                response.setStatus(406);
                response.setMsg("Can't upload. Because have some exception\n Exception : " + e.toString());
            }
            return response;
        }
        else {
            RatingProductPicEntity ratingProductPic = new RatingProductPicEntity();
            ratingProductPic.setIdRatingProduct(id);

            String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            String filename = new Random().nextInt(999999) + "_" + System.currentTimeMillis();
            File targetFile = new File(UPLOAD_FOLDER + "//pic_rating_product//" + Integer.toString(id) + "//" + filename + fileExtension);
            try {
                File tmpDir = new File(UPLOAD_FOLDER + "//pic_rating_product//" + Integer.toString(id));
                boolean exists = tmpDir.exists();
                Common.LoggerInfo(exists);
                if (!exists) {
                    new File(UPLOAD_FOLDER + "//pic_rating_product//" + Integer.toString(id)).mkdir();

                }
                file.transferTo(targetFile);
                ratingProductPic.setContentPic(filename + fileExtension);
                ratingProductPicRepository.save(ratingProductPic);

                response.setStatus(200);
                response.setMsg("Upload successfully");

            } catch (IOException e) {
                response.setStatus(406);
                response.setMsg("Can't upload. Because have some exception\n Exception : " + e.toString());
            }
            return response;
        }
    }
}
