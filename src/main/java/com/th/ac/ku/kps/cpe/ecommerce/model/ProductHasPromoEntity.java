package com.th.ac.ku.kps.cpe.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "product_has_promo", schema = "mydb")
public class ProductHasPromoEntity {
    private ProductEntity productPromoSet;
    private int idProductHasPromo;
    private int idPromoType;
    private double newPrice;
    private Timestamp timeStart;
    private Timestamp timeEnd;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product_variation")
    public ProductEntity getProductPromoSet() {
        return productPromoSet;
    }

    public void setProductPromoSet(ProductEntity productPromoSet) {
        this.productPromoSet = productPromoSet;
    }

    @Id
    @Column(name = "id_product_has_promo")
    public int getIdProductHasPromo() {
        return idProductHasPromo;
    }

    public void setIdProductHasPromo(int idProductHasPromo) {
        this.idProductHasPromo = idProductHasPromo;
    }

    @Basic
    @Column(name = "id_promo_type")
    public int getIdPromoType() {
        return idPromoType;
    }

    public void setIdPromoType(int idPromoType) {
        this.idPromoType = idPromoType;
    }

    @Basic
    @Column(name = "new_price")
    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    @Basic
    @Column(name = "time_start")
    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    @Basic
    @Column(name = "time_end")
    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductHasPromoEntity that = (ProductHasPromoEntity) o;
        return idProductHasPromo == that.idProductHasPromo &&
                idPromoType == that.idPromoType &&
                Double.compare(that.newPrice, newPrice) == 0 &&
                Objects.equals(timeStart, that.timeStart) &&
                Objects.equals(timeEnd, that.timeEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductHasPromo, idPromoType, newPrice, timeStart, timeEnd);
    }
}
