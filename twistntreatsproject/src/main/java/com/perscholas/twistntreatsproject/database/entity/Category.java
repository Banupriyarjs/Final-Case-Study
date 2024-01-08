package com.perscholas.twistntreatsproject.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="category_description")
    private String categoryDescription;

    @Column(name="created_by")
    private Integer createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date",columnDefinition = "DATE")
     private Date createdDate;

    @Column(name="status")
    private String status;
    @PrePersist
    private void onCreate()
    {
        createdDate=new Date();
        //createdBy=1;
      //  createdBy= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
