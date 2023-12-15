package com.perscholas.twistntreats.formbean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFormBean {
    private Integer id;

    private String productName;

    private String productDescription;

    private Integer categoryId;

    private double price;

    private String productUrl;
}
