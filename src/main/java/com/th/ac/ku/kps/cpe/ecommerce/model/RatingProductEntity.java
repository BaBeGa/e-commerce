package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rating_product", schema = "e-commerce_01")
public class RatingProductEntity {
    private int idRatingProduct;
    private int idOrderHistory;
    private int rating;
    private String content;
    private Timestamp ratedDate;

    @Id
    @Column(name = "id_rating_product")
    public int getIdRatingProduct() {
        return idRatingProduct;
    }

    public void setIdRatingProduct(int idRatingProduct) {
        this.idRatingProduct = idRatingProduct;
    }

    @Basic
    @Column(name = "id_order_history")
    public int getIdOrderHistory() {
        return idOrderHistory;
    }

    public void setIdOrderHistory(int idOrderHistory) {
        this.idOrderHistory = idOrderHistory;
    }

    @Basic
    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "rated_date")
    public Timestamp getRatedDate() {
        return ratedDate;
    }

    public void setRatedDate(Timestamp ratedDate) {
        this.ratedDate = ratedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingProductEntity that = (RatingProductEntity) o;
        return idRatingProduct == that.idRatingProduct &&
                idOrderHistory == that.idOrderHistory &&
                rating == that.rating &&
                Objects.equals(content, that.content) &&
                Objects.equals(ratedDate, that.ratedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRatingProduct, idOrderHistory, rating, content, ratedDate);
    }
}
