package com.th.ac.ku.kps.cpe.ecommerce.model.seller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity , Integer> {

}
