package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_item", schema = "e-commerce_01")
public class OrderItemEntity {
    private int idItem;
    private int idOrder;
    private int idVariation;
    private int quantity;
    private Integer idShipOfShop;

    @Id
    @Column(name = "id_item")
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Basic
    @Column(name = "id_order")
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "id_variation")
    public int getIdVariation() {
        return idVariation;
    }

    public void setIdVariation(int idVariation) {
        this.idVariation = idVariation;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity that = (OrderItemEntity) o;
        return idItem == that.idItem &&
                idOrder == that.idOrder &&
                idVariation == that.idVariation &&
                quantity == that.quantity &&
                Objects.equals(idShipOfShop, that.idShipOfShop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItem, idOrder, idVariation, quantity, idShipOfShop);
    }
}
