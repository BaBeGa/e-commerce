package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.th.ac.ku.kps.cpe.ecommerce.model.ProductHasPromoEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product_variation", schema = "mydb")
public class ProductVariationEntity {
    private ProductEntity productEntityOfVariationSet;
    private int idVariation;
    private String name;
    private double price;
    private int stock;
    private ProductHasPromoEntity productHasPromoEntitySet;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    public ProductEntity getProductEntityOfVariationSet() {
        return productEntityOfVariationSet;
    }

    public void setProductEntityOfVariationSet(ProductEntity productEntitySet) {
        this.productEntityOfVariationSet = productEntitySet;
    }
    @Id
    @Column(name = "id_variation")
    public int getIdVariation() {
        return idVariation;
    }

    public void setIdVariation(int idVariation) {
        this.idVariation = idVariation;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "stock")
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @OneToOne(mappedBy = "productPromoSet", fetch = FetchType.LAZY)
    public ProductHasPromoEntity getProductHasPromoEntitySet() {
        return productHasPromoEntitySet;
    }

    public void setProductHasPromoEntitySet(ProductHasPromoEntity productHasPromoEntitySet) {
        this.productHasPromoEntitySet = productHasPromoEntitySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductVariationEntity that = (ProductVariationEntity) o;
        return idVariation == that.idVariation &&
                Double.compare(that.price, price) == 0 &&
                stock == that.stock &&
                Objects.equals(name, that.name) &&
                Objects.equals(productHasPromoEntitySet, that.productHasPromoEntitySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVariation, name, price, stock, productHasPromoEntitySet);
    }
}
