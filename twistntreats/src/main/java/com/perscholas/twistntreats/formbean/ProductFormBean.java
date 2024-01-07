package com.perscholas.twistntreats.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFormBean {
    private Integer id;
    @NotEmpty(message = "Name cannot be empty")
    private String productName;

    @NotEmpty(message = "Description cannot be empty")
    private String productDescription;

    @NotEmpty(message = "Category cannot be empty")
    private Integer categoryId;

    private double price;

    private String productUrl;

    private String status;
}
