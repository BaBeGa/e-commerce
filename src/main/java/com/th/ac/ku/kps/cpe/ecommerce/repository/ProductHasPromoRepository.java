package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.ProductHasPromoEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

public interface ProductHasPromoRepository extends CrudRepository<ProductHasPromoEntity, Integer> {
    List<ProductHasPromoEntity> findAllByIdProductVariation(Integer id_product_variation);
    ProductHasPromoEntity findByIdProductVariation(Integer id_product_variation);
    ProductHasPromoEntity findByIdProductHasPromo(Integer id_product_has_promo);
    ProductHasPromoEntity findByIdProductVariationAndTimeStartBeforeAndTimeEndAfter(Integer id_variation, Timestamp time_now1, Timestamp time_now2);
    @Modifying
    @Transactional
    void deleteAllByTimeEndBefore(Timestamp time_end);

    @Override
    List<ProductHasPromoEntity> findAll();
}
