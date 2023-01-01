package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.Authorization;

public interface AuthoriRepository extends JpaRepository<Authorization, String> {

}
