package com.th.ac.ku.kps.cpe.ecommerce.model;

import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderItemStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order_item", schema = "e-commerce_01")
public class OrderItemEntity {
    private Integer idItem;
    private Integer idOrder;
    private Integer idVariation;
    private Integer quantity;
    private Integer idShipOfShop;
    private String trackingNumber;
    private OrderItemStatus orderItemStatus;
    private Timestamp expiredShip;
    private Timestamp expiredBuyerConfirm;
    private Timestamp successfulDate;

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    @Basic
    @Column(name = "id_order")
    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "id_variation")
    public Integer getIdVariation() {
        return idVariation;
    }

    public void setIdVariation(Integer idVariation) {
        this.idVariation = idVariation;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "id_ship_of_shop")
    public Integer getIdShipOfShop() {
        return idShipOfShop;
    }

    public void setIdShipOfShop(Integer idShipOfShop) {
        this.idShipOfShop = idShipOfShop;
    }

    @Basic
    @Column(name = "tracking_number")
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Basic
    @Column(name = "order_item_status")
    @Enumerated(EnumType.STRING)
    public OrderItemStatus getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(OrderItemStatus orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    @Basic
    @Column(name = "expired_ship")
    public Timestamp getExpiredShip() {
        return expiredShip;
    }

    public void setExpiredShip(Timestamp expiredShip) {
        this.expiredShip = expiredShip;
    }

    @Basic
    @Column(name = "expired_buyer_confirm")
    public Timestamp getExpiredBuyerConfirm() {
        return expiredBuyerConfirm;
    }

    public void setExpiredBuyerConfirm(Timestamp expiredBuyerConfirm) {
        this.expiredBuyerConfirm = expiredBuyerConfirm;
    }

    @Basic
    @Column(name = "successful_date")
    public Timestamp getSuccessfulDate() {
        return successfulDate;
    }

    public void setSuccessfulDate(Timestamp successfulDate) {
        this.successfulDate = successfulDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity that = (OrderItemEntity) o;
        return Objects.equals(idItem, that.idItem) &&
                Objects.equals(idOrder, that.idOrder) &&
                Objects.equals(idVariation, that.idVariation) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(idShipOfShop, that.idShipOfShop) &&
                Objects.equals(trackingNumber, that.trackingNumber) &&
                orderItemStatus == that.orderItemStatus &&
                Objects.equals(expiredShip, that.expiredShip) &&
                Objects.equals(expiredBuyerConfirm, that.expiredBuyerConfirm) &&
                Objects.equals(successfulDate, that.successfulDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItem, idOrder, idVariation, quantity, idShipOfShop, trackingNumber, orderItemStatus, expiredShip, expiredBuyerConfirm, successfulDate);
    }
}
