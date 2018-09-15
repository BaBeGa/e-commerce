package com.th.ac.ku.kps.cpe.ecommerce.model.seller;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product", schema = "mydb")
public class ProductEntity {
    private int idProduct;
    private String nameProduct;
    private String description;
    private String condition;
    private Timestamp createdAt;
    private Set<ProductPicEntity> productPicEntityList;

    @Id
    @Column(name = "id_product")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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
    public Set<ProductPicEntity> getProductPicEntityList() {
        return productPicEntityList;
    }

    public void setProductPicEntityList(Set<ProductPicEntity> productPicEntityList) {
        this.productPicEntityList = productPicEntityList;
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
                Objects.equals(productPicEntityList, that.productPicEntityList);
    }


    @Override
    public int hashCode() {
        return Objects.hash(idProduct, nameProduct, description, condition, createdAt, productPicEntityList);
    }
}
