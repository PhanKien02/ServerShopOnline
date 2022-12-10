package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label,Long> {
    
}
