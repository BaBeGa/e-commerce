package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment_product", schema = "e-commerce_01")
public class CommentProductEntity {
    private int idComment;
    private int idUser;
    private int idProduct;
    private String content;
    private String contentPic;

    @Id
    @Column(name = "id_comment")
    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        CommentProductEntity that = (CommentProductEntity) o;
        return idComment == that.idComment &&
                idUser == that.idUser &&
                idProduct == that.idProduct &&
                Objects.equals(content, that.content) &&
                Objects.equals(contentPic, that.contentPic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComment, idUser, idProduct, content, contentPic);
    }
}
