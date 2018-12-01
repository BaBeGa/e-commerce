package com.th.ac.ku.kps.cpe.ecommerce.repository;

import com.th.ac.ku.kps.cpe.ecommerce.model.ConfigEntity;
import org.springframework.data.repository.CrudRepository;

public interface ConfigRepository extends CrudRepository<ConfigEntity, Integer> {
    ConfigEntity findByIdConfig(Integer id_config);
    ConfigEntity findByName(String name);
}
