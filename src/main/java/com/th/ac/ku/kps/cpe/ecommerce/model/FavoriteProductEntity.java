package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "favorite_product", schema = "e-commerce_01")
public class FavoriteProductEntity {
    private int idFavorite;
    private int idUser;
    private int idProduct;

    @Id
    @Column(name = "id_favorite")
    public int getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(int idFavorite) {
        this.idFavorite = idFavorite;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteProductEntity that = (FavoriteProductEntity) o;
        return idFavorite == that.idFavorite &&
                idUser == that.idUser &&
                idProduct == that.idProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFavorite, idUser, idProduct);
    }
}
