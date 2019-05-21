package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.OrderHistoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderHistoryRepository extends CrudRepository<OrderHistoryEntity, Integer> {
    OrderHistoryEntity findByIdItem(Integer id_item);
    OrderHistoryEntity findByIdOrderHistory(Integer id_order_history);
    OrderHistoryEntity findByIdOrder(Integer id_order);
    OrderHistoryEntity findByTrackingNumber(String tracking_number);
    List<OrderHistoryEntity> findAllByIdBuyer(Integer id_user);
    List<OrderHistoryEntity> findByIdBuyerAndIdOrderHistory(Integer id_user, Integer id_order_history);
    List<OrderHistoryEntity> findAllByIdBuyerAndIdProduct(Integer id_user, Integer id_product);
    List<OrderHistoryEntity> findAllByIdShop(Integer id_shop);
    List<OrderHistoryEntity> findAllByIdShopAndIdItem(Integer id_shop, Integer id_item);
    List<OrderHistoryEntity> findAllByIdOrder(Integer id_order);

    List<OrderHistoryEntity> findAllBySuccessfulDateGreaterThanEqualAndSuccessfulDateLessThanEqualAndIdShop(Date date_1, Date date_2, Integer id_shop);
    List<OrderHistoryEntity> findAllByIdProduct(Integer id_product);
}
