package com.perscholas.twistntreats.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="customer_id", nullable=false)
    private User user;

    @Column(name="order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name="status")
    private String status;

}
