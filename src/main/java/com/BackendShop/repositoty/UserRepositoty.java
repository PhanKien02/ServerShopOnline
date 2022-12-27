package com.BackendShop.repositoty;


import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.User;


public interface UserRepositoty extends JpaRepository<User, Long> {

    String USERS_BY_LOGIN_CACHE = "usersByLogin";

    String USERS_BY_EMAIL_CACHE = "usersByEmail";

    Optional<User> findOneByPhone(String phone);

    Optional<User> findOneByEmail(String email);
    
    @EntityGraph(attributePaths = "authorization")
    @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
    Optional<User> findOneWithAuthoritiesByEmail(String email);

}
