package com.BackendShop.admin.res.request;

import com.BackendShop.domain.enumeration.Color;
import com.BackendShop.domain.enumeration.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductReq {
    
    String name;
    double price;
    Boolean active;
    String description;
    int amount;
    Color color;
    Size size;
    Long trademarkId;
    Long categoryId;
}
