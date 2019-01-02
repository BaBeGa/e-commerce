package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rating_product", schema = "e-commerce_01")
public class RatingProductEntity {
    private int idRatingProduct;
    private int idUser;
    private int idProduct;
    private int rating;

    @Id
    @Column(name = "id_rating_product")
    public int getIdRatingProduct() {
        return idRatingProduct;
    }

    public void setIdRatingProduct(int idRatingProduct) {
        this.idRatingProduct = idRatingProduct;
    }

    @Basic
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "id_product")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingProductEntity that = (RatingProductEntity) o;
        return idRatingProduct == that.idRatingProduct &&
                idUser == that.idUser &&
                idProduct == that.idProduct &&
                rating == that.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRatingProduct, idUser, idProduct, rating);
    }
}
