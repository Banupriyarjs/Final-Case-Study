package com.perscholas.twistntreatsproject.formbean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryFormBean {

    private Integer id;
    private String categoryName;
    private String categoryDescription;
   private Integer createdBy;
    //private Date createdDate;
    private String status;

}
