package com.BackendShop.repositoty;
import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
