package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.Authorization;

@Repository
public interface AuthoriRepository extends JpaRepository<Authorization, Long> {

}
