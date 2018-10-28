package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ship_of_shop", schema = "e-commerce_01")
public class ShipOfShopEntity {
    private int idShip;
    private int idShop;
    private int idProduct;
    private int idType;
    private double price;

    @Id
    @Column(name = "id_ship")
    public int getIdShip() {
        return idShip;
    }

    public void setIdShip(int idShip) {
        this.idShip = idShip;
    }

    @Basic
    @Column(name = "id_shop")
    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipOfShopEntity that = (ShipOfShopEntity) o;
        return idShip == that.idShip &&
                idShop == that.idShop &&
                idProduct == that.idProduct &&
                idType == that.idType &&
                Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idShip, idShop, idProduct, idType, price);
    }
}
