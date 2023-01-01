package com.BackendShop.admin.res;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendShop.admin.res.request.ProductReq;
import com.BackendShop.framwork.http.ApiResult;
import com.BackendShop.framwork.http.ResponseData;
import com.BackendShop.service.ProductService;

@RestController
@RequestMapping("api/admin")
public class ProductRecource {
    
    @Autowired
    ProductService productService;

    @GetMapping("product")
    public ResponseEntity<ResponseData> getAllProduct() {
		
    	ResponseData responseData = new ResponseData();
    	responseData.addData("product", productService.getAllProduct());
    	
    	return ApiResult.success(responseData);
	}
    
    @PostMapping("/product")
    public ResponseEntity<ResponseData> addProduct(@Valid @RequestBody ProductReq productReq){

        ResponseData responseData = new ResponseData();

        responseData.addData("product", productService.addProduct(productReq));

        return ApiResult.success(responseData);
    }
}
