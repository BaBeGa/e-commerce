package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
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
                Objects.equals(trackingNumber, that.trackingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItem, idOrder, idVariation, quantity, idShipOfShop, trackingNumber);
    }
}
