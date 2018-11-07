package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.th.ac.ku.kps.cpe.ecommerce.model.ProductHasPromoEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "product_variation", schema = "e-commerce_01")
public class ProductVariationEntity {
//    private ProductEntity productEntityOfVariationSet;
    private Integer idVariation;
    private Integer idProduct;
    private String name;
    private Double price;
    private Integer stock;
//    private ProductHasPromoEntity productHasPromoEntitySet;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY, cascade = {PERSIST, MERGE} )
//    @JoinColumn(name = "`id_product`")
//    public ProductEntity getProductEntityOfVariationSet() {
//        return productEntityOfVariationSet;
//    }
//
//    public void setProductEntityOfVariationSet(ProductEntity productEntitySet) {
//        this.productEntityOfVariationSet = productEntitySet;
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variation")
    public Integer getIdVariation() {
        return idVariation;
    }

    public void setIdVariation(Integer idVariation) {
        this.idVariation = idVariation;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "stock")
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

//    @OneToOne(mappedBy = "productPromoSet", fetch = FetchType.LAZY)
//    public ProductHasPromoEntity getProductHasPromoEntitySet() {
//        return productHasPromoEntitySet;
//    }
//
//    public void setProductHasPromoEntitySet(ProductHasPromoEntity productHasPromoEntitySet) {
//        this.productHasPromoEntitySet = productHasPromoEntitySet;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductVariationEntity that = (ProductVariationEntity) o;
        return idVariation == that.idVariation &&
                Double.compare(that.price, price) == 0 &&
                stock == that.stock &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVariation, name, price, stock);
    }
}
