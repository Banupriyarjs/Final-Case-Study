package com.perscholas.twistntreats.database.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="order_id",nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name="product_id",nullable=false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name="category_id",nullable=false)
    private Category category;

    @Column(name="quantity")
    private Integer quantity;
    @Column(name="status")
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date")
    private Date createdDate;

}
