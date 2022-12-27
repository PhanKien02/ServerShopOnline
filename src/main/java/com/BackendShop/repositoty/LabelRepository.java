package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.Label;

public interface LabelRepository extends JpaRepository<Label,Long> {
    
}
