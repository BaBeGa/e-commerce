package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ShopHasProductEntityPK implements Serializable {
    private int idShop;
    private int idProduct;

    @Column(name = "id_shop")
    @Id
    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Column(name = "id_product")
    @Id
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
        ShopHasProductEntityPK that = (ShopHasProductEntityPK) o;
        return idShop == that.idShop &&
                idProduct == that.idProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idShop, idProduct);
    }
}
