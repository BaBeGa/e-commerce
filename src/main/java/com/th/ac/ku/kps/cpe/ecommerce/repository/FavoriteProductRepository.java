package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.FavoriteProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FavoriteProductRepository extends CrudRepository<FavoriteProductEntity, Integer> {
    FavoriteProductEntity findByIdFavoriteAndIdUser(Integer id_favorite, Integer id_user);
    List<FavoriteProductEntity> findAllByIdUser(Integer id_user);
    FavoriteProductEntity findByIdUserAndIdProduct(Integer id_user, Integer id_product);
}
