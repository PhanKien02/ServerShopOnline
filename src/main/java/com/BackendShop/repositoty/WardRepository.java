package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.Ward;

@Repository
public interface WardRepository extends JpaRepository<Ward,Long> {
    
}
