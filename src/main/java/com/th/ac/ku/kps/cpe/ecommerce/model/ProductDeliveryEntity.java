package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_delivery", schema = "e-commerce_01")
public class ProductDeliveryEntity {
    private int idShip;
    private int idProduct;
    private int idType;
    private double price;
    private int timeShip;

    @Id
    @Column(name = "id_ship")
    public int getIdShip() {
        return idShip;
    }

    public void setIdShip(int idShip) {
        this.idShip = idShip;
    }

    @Basic
    @Column(name = "id_product")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "id_type")
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "time_ship")
    public int getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(int timeShip) {
        this.timeShip = timeShip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDeliveryEntity that = (ProductDeliveryEntity) o;
        return idShip == that.idShip &&
                idProduct == that.idProduct &&
                idType == that.idType &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(timeShip, that.timeShip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idShip, idProduct, idType, price, timeShip);
    }
}
