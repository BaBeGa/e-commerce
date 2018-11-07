package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.th.ac.ku.kps.cpe.ecommerce.model.CatagoryEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "`product`", schema = "e-commerce_01")
public class ProductEntity {
    private Integer idProduct;
//    private CatagoryEntity catagorySet;
    private Integer catagory;
    private String nameProduct;
    private String description;
    private String condition;
    private Timestamp createdAt;
    private Integer count;
    private Double mean;
//    private Set<ProductPicEntity> productPicEntitySet;
//    private Set<ProductVariationEntity> productVariationEntitySet;


    @Id
    @Column(name = "`id_product`")
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "`catagory`" , insertable = false,updatable = false)
//    public CatagoryEntity getCatagorySet() {
//        return catagorySet;
//    }
//
//    public void setCatagorySet(CatagoryEntity catagory) {
//        this.catagorySet = catagory;
//    }

    @Basic
    @Column(name = "`catagory`")
    public Integer getCatagory() {
        return catagory;
    }

    public void setCatagory(Integer catagory) {
        this.catagory = catagory;
    }

    @Basic
    @Column(name = "`name_product`")
    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Basic
    @Column(name = "`description`")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "`condition`")
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "`created_at`")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "`count`")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "`mean`")
    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

//    @OneToMany(mappedBy = "productEntitySet", fetch = FetchType.LAZY)
//    public Set<ProductPicEntity> getProductPicEntitySet() {
//        return productPicEntitySet;
//    }
//
//    public void setProductPicEntitySet(Set<ProductPicEntity> productPicEntitySet) {
//        this.productPicEntitySet = productPicEntitySet;
//    }
//
//    @OneToMany(mappedBy = "productEntityOfVariationSet", fetch = FetchType.LAZY)
//    public Set<ProductVariationEntity> getProductVariationEntitySet() {
//        return productVariationEntitySet;
//    }
//
//    public void setProductVariationEntitySet(Set<ProductVariationEntity> productVariationEntitySet) {
//        this.productVariationEntitySet = productVariationEntitySet;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(idProduct, that.idProduct) &&
                Objects.equals(catagory, that.catagory) &&
                Objects.equals(nameProduct, that.nameProduct) &&
                Objects.equals(description, that.description) &&
                Objects.equals(condition, that.condition) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(count, that.count) &&
                Objects.equals(mean, that.mean);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, catagory, nameProduct, description, condition, createdAt, count, mean);
    }
}
