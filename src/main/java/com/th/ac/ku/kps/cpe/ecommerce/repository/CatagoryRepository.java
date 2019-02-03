package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.CatagoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CatagoryRepository extends CrudRepository<CatagoryEntity, Integer> {
    CatagoryEntity findByIdCatagory(Integer id_catagory);
}
