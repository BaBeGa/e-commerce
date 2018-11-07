package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_pic", schema = "e-commerce_01")
public class ProductPicEntity {
    private int idProductPic;
    private Integer idProduct;
    private String picProduct;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_product", insertable = false, updatable = false)
//    public ProductEntity getProductEntitySet() {
//        return productEntitySet;
//    }
//
//    public void setProductEntitySet(ProductEntity productEntitySet) {
//        this.productEntitySet = productEntitySet;
//    }
    @Id
    @Column(name = "id_product_pic")
    public int getIdProductPic() {
        return idProductPic;
    }

    public void setIdProductPic(int idProductPic) {
        this.idProductPic = idProductPic;
    }

    @Basic
    @Column(name = "id_product")
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "pic_product")
    public String getPicProduct() {
        return picProduct;
    }

    public void setPicProduct(String picProduct) {
        this.picProduct = picProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPicEntity that = (ProductPicEntity) o;
        return idProductPic == that.idProductPic &&
                Objects.equals(picProduct, that.picProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductPic, picProduct);
    }
}
