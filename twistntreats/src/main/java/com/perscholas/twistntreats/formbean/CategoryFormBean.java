package com.perscholas.twistntreats.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CategoryFormBean {

    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    private String categoryName;

    @NotEmpty(message = "Description cannot be empty")
    private String categoryDescription;

    private Integer createdBy;
    //private Date createdDate;

    private String status;

}
