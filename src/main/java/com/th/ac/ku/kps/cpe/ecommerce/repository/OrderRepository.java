package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.OrderEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderStatus;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    @Query(value = "SELECT * FROM `order` ORDER BY `id_order` DESC LIMIT 0, 1",nativeQuery = true)
    OrderEntity getLastId();

    List<OrderEntity> findAllByIdBuyerAndOrderStatus(Integer id_buyer, OrderStatus orderStatus);
    List<OrderEntity> findAllByIdBuyer(Integer id);
    List<OrderEntity> findAllByIdBuyerAndIdOrder(Integer id_buyer, Integer id_order);

    List<OrderEntity> findAllByOrderStatusOrOrderStatusOrOrderStatus(OrderStatus order_status,OrderStatus order_status2,OrderStatus order_status3);
    OrderEntity findByIdBuyerAndIdOrder(Integer id_buyer,Integer id_order);
    OrderEntity findByIdOrder(Integer id_order);
}
