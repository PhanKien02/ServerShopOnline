package com.BackendShop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BackendShop.admin.res.request.ProductReq;
import com.BackendShop.admin.res.response.ProductRes;
import com.BackendShop.domain.Category;
import com.BackendShop.domain.Product;
import com.BackendShop.domain.Trademark;
import com.BackendShop.exception.BadRequestException;
import com.BackendShop.repositoty.CategoryRepository;
import com.BackendShop.repositoty.ProductRepository;
import com.BackendShop.repositoty.TrademarkRepository;
import com.BackendShop.service.ProductService;

@Service
@Transactional
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TrademarkRepository trademarkRepository;

    @Override
    public List<ProductRes> getAllProduct() {
        
    	List<Product> products = productRepository.findAll();
    	
    	List<ProductRes> productResList = new ArrayList<>();
    	
    	for(Product product : products) {
    		ProductRes productRes = ProductRes.builder()
    				.name(product.getName())
    				.active(product.getActive())
    				.amount(product.getAmount())
    				.category(product.getCategory())
    				.price(product.getPrice())
    				.color(product.getColor())
    				.size(product.getSize())
    				.build();
    		productResList.add(productRes);
    	}
        return productResList;
    }

    @Override
    public ProductRes addProduct(ProductReq productReq) {
        
        Optional<Category> categoryOptional = categoryRepository.findById(productReq.getCategoryId());
        if(!categoryOptional.isPresent()){
            throw new BadRequestException("Category không tồn tại", new Throwable());
        }

        Optional<Trademark> trademarkOptional = trademarkRepository.findById(productReq.getTrademarkId());
        if(!trademarkOptional.isPresent()){
            throw new BadRequestException("Nhà cung cấp không tồn tại", new Throwable());
        }
        Product product = Product.builder()
        .name(productReq.getName())
        .description(productReq.getDescription())
        .amount(productReq.getAmount())
        .color(productReq.getColor())
        .size(productReq.getSize())
        .active(productReq.getActive())
        .category(categoryOptional.get())
        .build();

        product = productRepository.save(product);

        ProductRes productRes = ProductRes.builder()
        .name(product.getName())
        .description(product.getDescription())
        .amount(product.getAmount())
        .color(product.getColor())
        .size(product.getSize())
        .trademark(trademarkOptional.get())
        .category(categoryOptional.get())
        .build();

        return productRes;
    }
    
}
