package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shop_has_product", schema = "mydb")
public class ShopHasProductEntity {
    private int idShopHasProduct;
    private int idShop;
    private int idProduct;

    @Id
    @Column(name = "id_shop_has_product")
    public int getIdShopHasProduct() {
        return idShopHasProduct;
    }

    public void setIdShopHasProduct(int idShopHasProduct) {
        this.idShopHasProduct = idShopHasProduct;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopHasProductEntity that = (ShopHasProductEntity) o;
        return idShopHasProduct == that.idShopHasProduct &&
                idShop == that.idShop &&
                idProduct == that.idProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idShopHasProduct, idShop, idProduct);
    }
}
