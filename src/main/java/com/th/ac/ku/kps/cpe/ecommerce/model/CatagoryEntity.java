package com.th.ac.ku.kps.cpe.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "catagory", schema = "e-commerce_01")
public class CatagoryEntity {
    private int idCatagory;
    private String nameCatagory;
    private Set<ProductEntity> productEntitySet;

    @Id
    @Column(name = "id_catagory")
    public int getIdCatagory() {
        return idCatagory;
    }

    public void setIdCatagory(int idCatagory) {
        this.idCatagory = idCatagory;
    }

    @Basic
    @Column(name = "name_catagory")
    public String getNameCatagory() {
        return nameCatagory;
    }

    public void setNameCatagory(String nameCatagory) {
        this.nameCatagory = nameCatagory;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "catagorySet", fetch = FetchType.LAZY)
    public Set<ProductEntity> getProductEntitySet() {
        return productEntitySet;
    }

    public void setProductEntitySet(Set<ProductEntity> productEntitySet) {
        this.productEntitySet = productEntitySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatagoryEntity that = (CatagoryEntity) o;
        return idCatagory == that.idCatagory &&
                Objects.equals(nameCatagory, that.nameCatagory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCatagory, nameCatagory);
    }
}
