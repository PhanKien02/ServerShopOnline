package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long>{

}
