package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.User;

@Repository
public interface UserRepositoty extends JpaRepository<User, Long> {

}
