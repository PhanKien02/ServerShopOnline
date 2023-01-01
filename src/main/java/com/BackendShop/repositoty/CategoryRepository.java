package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
