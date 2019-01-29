package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rating_shop", schema = "e-commerce_01")
public class RatingShopEntity {
    private int idRatingShop;
    private int idOrderHistory;
    private int idUser;
    private int idShop;
    private int rating;
    private String content;
    private Timestamp ratedDate;

    @Id
    @Column(name = "id_rating_shop")
    public int getIdRatingShop() {
        return idRatingShop;
    }

    public void setIdRatingShop(int idRatingShop) {
        this.idRatingShop = idRatingShop;
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
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "id_shop")
    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
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
        RatingShopEntity that = (RatingShopEntity) o;
        return idRatingShop == that.idRatingShop &&
                idOrderHistory == that.idOrderHistory &&
                idUser == that.idUser &&
                idShop == that.idShop &&
                rating == that.rating &&
                Objects.equals(content, that.content) &&
                Objects.equals(ratedDate, that.ratedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRatingShop, idOrderHistory, idUser, idShop, rating, content, ratedDate);
    }
}
