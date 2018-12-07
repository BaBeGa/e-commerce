package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Iterable<UserEntity> findAllByToken(Iterable<String> iterable);
    UserEntity findByToken(String token);


    UserEntity findByIdUser(Integer id_user);
}
