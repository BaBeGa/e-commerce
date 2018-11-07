package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shop_has_product", schema = "e-commerce_01")
@IdClass(ShopHasProductEntityPK.class)
public class ShopHasProductEntity {
    private Integer idShop;
    private Integer idProduct;

    @Id
    @Column(name = "id_shop")
    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    @Id
    @Column(name = "id_product")
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopHasProductEntity that = (ShopHasProductEntity) o;
        return idShop == that.idShop &&
                idProduct == that.idProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idShop, idProduct);
    }



}
