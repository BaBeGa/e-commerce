package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.CommentProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentProductRepository extends CrudRepository<CommentProductEntity, Integer> {
    CommentProductEntity findByIdComment(Integer id_comment);
    CommentProductEntity findByIdUserAndIdProduct(Integer id_user, Integer id_product);
}
