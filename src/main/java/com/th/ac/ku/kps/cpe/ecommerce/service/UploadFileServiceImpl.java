package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.ShopHasProductEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.UserEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductPicEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.ShopEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.upload.UploadFileResponse;
import com.th.ac.ku.kps.cpe.ecommerce.repository.ProductPicRepository;
import com.th.ac.ku.kps.cpe.ecommerce.repository.ShopHasProductRepository;
import com.th.ac.ku.kps.cpe.ecommerce.repository.ShopRepository;
import com.th.ac.ku.kps.cpe.ecommerce.repository.UserRepository;
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
    public UploadFileServiceImpl(ProductPicRepository productPicRepository, UserRepository userRepository, ShopRepository shopRepository, ShopHasProductRepository shopHasProductRepository) {
        this.productPicRepository = productPicRepository;
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
        this.shopHasProductRepository = shopHasProductRepository;
    }

    @Override
    public UploadFileResponse uploadResponse(String token, Integer id_product, MultipartFile file, String UPLOAD_FOLDER) {

        UserEntity user = userRepository.findByToken(token);
        UploadFileResponse response = new UploadFileResponse();
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
        List<ShopHasProductEntity> shopHasProduct = shopHasProductRepository.findAllByIdShop(shop.getIdShop());
        boolean foundProduct = false;
        for (ShopHasProductEntity aShopHasProduct : shopHasProduct) {
            if (aShopHasProduct.getIdProduct().equals(id_product)) {
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
        File targetFile = new File(UPLOAD_FOLDER + "//" + Integer.toString(id_product) + "//" + filename + fileExtension);
        try {
            File tmpDir = new File(UPLOAD_FOLDER + "//" + Integer.toString(id_product));
            boolean exists = tmpDir.exists();
            Common.LoggerInfo(exists);
            if(!exists)
            {
                new File(UPLOAD_FOLDER + "//" + Integer.toString(id_product)).mkdir();
            }
            file.transferTo(targetFile);
            Common.LoggerInfo(UPLOAD_FOLDER + filename + fileExtension);
            productPicEntity.setIdProduct(id_product);
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


}
