package com.BackendShop.admin.res.response;

import com.BackendShop.domain.Category;
import com.BackendShop.domain.Trademark;
import com.BackendShop.domain.enumeration.Color;
import com.BackendShop.domain.enumeration.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRes {
    String name;
    double price;
    Boolean active;
    String description;
    int amount;
    Color color;
    Size size;
    Trademark trademark;
    Category category;
}
