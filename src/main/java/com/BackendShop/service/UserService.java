package com.BackendShop.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BackendShop.domain.Authorization;
import com.BackendShop.domain.User;
import com.BackendShop.domain.enumeration.RoleUser;
import com.BackendShop.exception.AlreadyUserException;
import com.BackendShop.exception.AuthenticationException;
import com.BackendShop.exception.BaseException;
import com.BackendShop.repositoty.AuthoriRepository;
import com.BackendShop.repositoty.UserRepositoty;
import com.BackendShop.security.AuthoritiesConstants;
import com.BackendShop.security.jwt.TokenProvider;
import com.BackendShop.user.res.request.SignInReq;
import com.BackendShop.user.res.request.SignUpRq;
import com.BackendShop.user.res.response.SignInRes;
import com.BackendShop.user.res.response.SignUpRes;
import com.BackendShop.user.res.response.UserRes;

@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private TokenProvider tokenProvider;

    @Autowired
    private final AuthoriRepository authoriRepository;

    @Autowired
    private UserRepositoty userRepositoty;

    UserService(AuthoriRepository authoriRepository) {
        this.authoriRepository = authoriRepository;
    }

   // *Sign up

    public SignUpRes signUp(SignUpRq signUpRq) {
        
        signUpRq.setPhone(signUpRq.getPhone().replaceAll(" ",""));

        userRepositoty.findOneByPhone(signUpRq.getPhone()).ifPresent(
            existUser -> {
                if(!removeUserNotActive(existUser)){
                    throw new BaseException("Số điện thoại đã được sử dụng",new Throwable());
                }
            }
        );
        userRepositoty.findOneByEmail(signUpRq.getEmail()).ifPresent(
            existUser->{
                if(!removeUserNotActive(existUser))
                {
                    throw new AlreadyUserException("Email đã được sử dụng",new Throwable());
                }
            }
            
        );
        userRepositoty.findOneByUserName(signUpRq.getUsername()).ifPresent(
                existUser->{
                    if(!removeUserNotActive(existUser))
                    {
                        throw new AlreadyUserException("userName đã được sử dụng",new Throwable());
                    }
                }
                
            );
        
    String encryptedPassword=  passwordEncoder.encode(signUpRq.getPassword());

            Set<Authorization> authorities = new HashSet<>();
            for(RoleUser roleUser : signUpRq.getRoles()){
                switch (roleUser) {
                    case ADMIN:
                        authoriRepository.findById(AuthoritiesConstants.ADMIN).
                        ifPresent(authorities::add);
                    break;
                    case USER:
                        authoriRepository.findById(AuthoritiesConstants.USER).
                        ifPresent(authorities::add);
                    default:
                        authoriRepository.findById(AuthoritiesConstants.USER).
                        ifPresent(authorities::add);
                        break;
                }
            }
        User newUser = User.builder()
        .userName(signUpRq.getUsername())
        .password(encryptedPassword)
        .authorization(authorities)
        .name(signUpRq.getFullname())
        .email(signUpRq.getEmail())
        .phone(signUpRq.getPhone())
        .active(true)
        .build();
        User user=  userRepositoty.saveAndFlush(newUser);

        UserRes userRes = UserRes.builder()
                .fullname(user.getName())
                .gender(user.getGender())
                .age(user.getAge())
                .activated(user.isActive())
                .avatar(user.getAvatar())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getAuthorization())
                .build();

        SignUpRes signUpRes = SignUpRes.builder()
        .userRes(userRes)
        .build();
        return signUpRes;
    }

    public boolean removeUserNotActive(User existingUser) {
        if (existingUser.isActive()) {
            return false;
        }
        userRepositoty.delete(existingUser);
        userRepositoty.flush();
        return true;

    }

  //  *Sign in
 
    public SignInRes signIn(SignInReq signReq) {

        log.debug("request to login userservice");

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                signReq.getEmail(),
                signReq.getPassword());

        Authentication authentication = null;
        try {
            authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        } catch (Exception e) {
                throw new AuthenticationException("Username or password is invalid", new Throwable());
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // String jwtToken = tokenProvider.createToken(authentication);

        User user = userRepositoty.findOneWithAuthoritiesByEmail(authentication.getName()).get();

        UserRes userRes = UserRes
                .builder()
                .fullname(user.getName())
                .gender(user.getGender())
                .age(user.getAge())
                .activated(user.isActive())
                .avatar(user.getAvatar())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();

        SignInRes signInRes = SignInRes.builder()
                // .tokenString(jwtToken)
                .user(userRes)
                .build();

        return signInRes;
    }
    public List<UserRes> getAllUser(){

        List<User> users = userRepositoty.findAll();
        List<UserRes> userResList = new ArrayList<>();

        for(User user: users){
            UserRes userRes = UserRes.builder()
            .id(user.getId())
            .fullname(user.getName())
            .age(user.getAge())
            .email(user.getEmail())
            .phone(user.getPhone())
            .gender(user.getGender())
            .role(user.getAuthorization())
            .avatar(user.getAvatar())
            .build();
            userResList.add(userRes);
        }
        return userResList;
    }
}
