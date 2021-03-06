package com.th.ac.ku.kps.cpe.ecommerce.model;

import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "`order`", schema = "e-commerce_01")
public class OrderEntity {
    private int idOrder;
    private int idBuyer;
    private Timestamp orderCreatedAt;
    private OrderStatus orderStatus;
    private Integer idAddress;

    @Id
    @Column(name = "id_order")
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "id_buyer")
    public int getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    @Basic
    @Column(name = "order_created_at")
    public Timestamp getOrderCreatedAt() {
        return orderCreatedAt;
    }

    public void setOrderCreatedAt(Timestamp orderCreatedAt) {
        this.orderCreatedAt = orderCreatedAt;
    }

    @Basic
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "id_address")
    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return idOrder == that.idOrder &&
                idBuyer == that.idBuyer &&
                Objects.equals(orderCreatedAt, that.orderCreatedAt) &&
                orderStatus == that.orderStatus &&
                Objects.equals(idAddress, that.idAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idBuyer, orderCreatedAt, orderStatus, idAddress);
    }
}
