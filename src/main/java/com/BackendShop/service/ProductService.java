package com.BackendShop.service;

import java.util.List;

import com.BackendShop.admin.res.request.ProductReq;
import com.BackendShop.admin.res.response.ProductRes;


public interface ProductService {

    
    List<ProductRes> getAllProduct();

    ProductRes addProduct(ProductReq productReq);
    
} 