package com.perscholas.twistntreats.formbean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CategoryFormBean {

    private Integer id;
    private String categoryName;
    private String categoryDescription;
   private Integer createdBy;
    private Date createdOn;

}
