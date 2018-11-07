package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO product (`catagory`, `name_product`, `description`, `condition`, `created_at`) VALUE (:catagory,:name_product,:description,:condition, :created_at)", nativeQuery = true)
    int save(@Param("catagory") int catagory,
            @Param("name_product") String name_product,
            @Param("description") String description,
            @Param("condition") String condition,
             @Param("created_at") Timestamp created_at);

    @Query(value = "SELECT * FROM product ORDER BY id_product DESC LIMIT 0, 1",nativeQuery = true)
    ProductEntity getLastId();

    @Transactional
    @Modifying
    @Query(value = "UPDATE product SET `catagory` = :catagory, `name_product` = :name_product,`description` = :description,`condition` = :condition WHERE `id_product`=:id_product", nativeQuery = true)
    int update(@Param("id_product") int id_product,
               @Param("catagory") int catagory,
               @Param("name_product") String name_product,
               @Param("description") String description,
               @Param("condition") String condition);

    ProductEntity findByIdProduct(Integer id_product);
}
