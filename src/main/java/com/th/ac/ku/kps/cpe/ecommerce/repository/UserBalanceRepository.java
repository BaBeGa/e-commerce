package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.UserBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBalanceRepository extends JpaRepository<UserBalanceEntity,Integer> {
    List<UserBalanceEntity> findByIdUser(Integer id_user);
    UserBalanceEntity findTopByIdUserOrderByIdUserBalanceDesc(Integer id_user);
}
