package com.BackendShop.security;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.BackendShop.domain.User;
import com.BackendShop.repositoty.UserRepositoty;

public class DomainUserDetailsService implements UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final UserRepositoty userRepository;

    public DomainUserDetailsService(UserRepositoty userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("Authenticating {}", email);

        if (new EmailValidator().isValid(email, null)){
            return userRepository
            .findOneWithAuthoritiesByEmail(email)
            .map(user -> createSpringSecurityUser(email, user))
            .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " was not found in the database"));
        }

        String lowercaseLogin = email.toLowerCase(Locale.ENGLISH);
        return userRepository
            .findOneWithAuthoritiesByEmail(lowercaseLogin)
            .map(user -> createSpringSecurityUser(lowercaseLogin, user))
            .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));
    }
    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
        if (!user.isActive()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
        }
        List<GrantedAuthority> grantedAuthorities = user
            .getAuthorization()
            .stream()
            .map(authority -> new SimpleGrantedAuthority(authority.getAuthori()))
            .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }
}
