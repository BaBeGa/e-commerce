package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rating_product_pic", schema = "e-commerce_01")
public class RatingProductPicEntity {
    private int idRatingProductPic;
    private int idRatingProduct;
    private String contentPic;

    @Id
    @Column(name = "id_rating_product_pic")
    public int getIdRatingProductPic() {
        return idRatingProductPic;
    }

    public void setIdRatingProductPic(int idRatingProductPic) {
        this.idRatingProductPic = idRatingProductPic;
    }

    @Basic
    @Column(name = "id_rating_product")
    public int getIdRatingProduct() {
        return idRatingProduct;
    }

    public void setIdRatingProduct(int idRatingProduct) {
        this.idRatingProduct = idRatingProduct;
    }

    @Basic
    @Column(name = "content_pic")
    public String getContentPic() {
        return contentPic;
    }

    public void setContentPic(String contentPic) {
        this.contentPic = contentPic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingProductPicEntity that = (RatingProductPicEntity) o;
        return idRatingProductPic == that.idRatingProductPic &&
                idRatingProduct == that.idRatingProduct &&
                Objects.equals(contentPic, that.contentPic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRatingProductPic, idRatingProduct, contentPic);
    }
}
