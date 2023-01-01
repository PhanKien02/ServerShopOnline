package com.BackendShop.user;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendShop.service.UserService;
import com.BackendShop.user.res.request.SignInReq;
import com.BackendShop.user.res.request.SignUpRq;
import com.BackendShop.user.res.response.SignInRes;
import com.BackendShop.user.res.response.SignUpRes;

@RestController
@RequestMapping("api/auth")
public class UserResource {
    
    
	private final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public SignUpRes SingUp(@Valid @RequestBody SignUpRq signUpRq){
        logger.debug("REST request to sign in: {}", signUpRq);

        return userService.signUp(signUpRq);
    }
    @PostMapping("/sign-in")
    public SignInRes SingIn(@Valid @RequestBody SignInReq signInReq){
        logger.debug("REST request to sign in: {}", signInReq);

        return userService.signIn(signInReq);
    }
}
