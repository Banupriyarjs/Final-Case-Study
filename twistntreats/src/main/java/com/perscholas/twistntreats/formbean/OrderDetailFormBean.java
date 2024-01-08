package com.perscholas.twistntreats.formbean;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailFormBean {

    private Integer id;

    private Integer orderId;

    private Integer productId;

    private Integer categoryId;


    private Integer quantity;

    private String status;





}
