package com.BackendShop.user;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendShop.framwork.http.ApiResult;
import com.BackendShop.framwork.http.ResponseData;
import com.BackendShop.service.UserService;
import com.BackendShop.user.res.request.SignInReq;
import com.BackendShop.user.res.request.SignUpRq;

@RestController
@RequestMapping("api/auth")
public class UserResource {
    
    
	private final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<ResponseData> SingUp(@Valid @RequestBody SignUpRq signUpRq){
        logger.debug("REST request to sign in: {}", signUpRq);

        ResponseData responseData = new ResponseData();
        responseData.addData("sign-up", userService.signUp(signUpRq));
        return ApiResult.success(responseData);
    }
    @PostMapping("/sign-in")
    public ResponseEntity<ResponseData> SingIn(@Valid @RequestBody SignInReq signInReq){
        logger.debug("REST request to sign in: {}", signInReq);
        ResponseData responseData = new ResponseData();
        responseData.addData("sign-in", userService.signIn(signInReq));
        return ApiResult.success(responseData);
    }

    @GetMapping("user")
    public ResponseEntity<ResponseData> getAllUser(){
        logger.debug("REST request to getAll User: {}");
        ResponseData responseData = new ResponseData();
        responseData.addData("user",  userService.getAllUser());
        return ApiResult.success(responseData);
    }
}
