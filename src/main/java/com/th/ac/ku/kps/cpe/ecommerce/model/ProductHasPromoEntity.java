package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "product_has_promo", schema = "e-commerce_01")
public class ProductHasPromoEntity {
    private Integer idProductHasPromo;
    private Integer idPromoType;
    private Integer idProductVariation;
    private Double newPrice;
    private Timestamp timeStart;
    private Timestamp timeEnd;

    @Id
    @Column(name = "id_product_has_promo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdProductHasPromo() {
        return idProductHasPromo;
    }

    public void setIdProductHasPromo(Integer idProductHasPromo) {
        this.idProductHasPromo = idProductHasPromo;
    }

    @Basic
    @Column(name = "id_promo_type")
    public Integer getIdPromoType() {
        return idPromoType;
    }

    public void setIdPromoType(Integer idPromoType) {
        this.idPromoType = idPromoType;
    }

    @Basic
    @Column(name = "id_product_variation")
    public Integer getIdProductVariation() {
        return idProductVariation;
    }

    public void setIdProductVariation(Integer idProductVariation) {
        this.idProductVariation = idProductVariation;
    }

    @Basic
    @Column(name = "new_price")
    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
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
