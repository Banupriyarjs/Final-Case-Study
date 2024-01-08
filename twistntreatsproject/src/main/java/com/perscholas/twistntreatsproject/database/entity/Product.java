package com.perscholas.twistntreatsproject.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @OneToMany(mappedBy="product",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_description")
    private String productDescription;

    @Column(name="category_id")
    private Integer categoryId;

    @Column(name="price",columnDefinition = "decimal")
    private Double price;

    @Column(name="created_by")
    private Integer createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date")
    private Date createdDate;

    @Column(name="product_url")
    private String productUrl;
    
    @Column(name="status")
    private String status;

}
