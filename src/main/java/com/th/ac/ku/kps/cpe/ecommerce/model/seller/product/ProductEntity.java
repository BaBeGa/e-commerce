package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.th.ac.ku.kps.cpe.ecommerce.model.CatagoryEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.ProductHasPromoEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product", schema = "e-commerce_01")
public class ProductEntity {
    private int idProduct;
    private CatagoryEntity catagory;
    private String nameProduct;
    private String description;
    private String condition;
    private Timestamp createdAt;
    private Set<ProductPicEntity> productPicEntitySet;
    private Set<ProductVariationEntity> productVariationEntitySet;


    @Id
    @Column(name = "id_product")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catagory")
    public CatagoryEntity getCatagory() {
        return catagory;
    }

    public void setCatagory(CatagoryEntity catagory) {
        this.catagory = catagory;
    }


    @Basic
    @Column(name = "name_product")
    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "condition")
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @OneToMany(mappedBy = "productEntitySet", fetch = FetchType.LAZY)
    public Set<ProductPicEntity> getProductPicEntitySet() {
        return productPicEntitySet;
    }

    public void setProductPicEntitySet(Set<ProductPicEntity> productPicEntitySet) {
        this.productPicEntitySet = productPicEntitySet;
    }

    @OneToMany(mappedBy = "productEntityOfVariationSet", fetch = FetchType.LAZY)
    public Set<ProductVariationEntity> getProductVariationEntitySet() {
        return productVariationEntitySet;
    }

    public void setProductVariationEntitySet(Set<ProductVariationEntity> productVariationEntitySet) {
        this.productVariationEntitySet = productVariationEntitySet;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return idProduct == that.idProduct &&
                Objects.equals(nameProduct, that.nameProduct) &&
                Objects.equals(description, that.description) &&
                Objects.equals(condition, that.condition) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(productPicEntitySet, that.productPicEntitySet) &&
                Objects.equals(productVariationEntitySet, that.productVariationEntitySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, nameProduct, description, condition, createdAt, productPicEntitySet);
    }
}
