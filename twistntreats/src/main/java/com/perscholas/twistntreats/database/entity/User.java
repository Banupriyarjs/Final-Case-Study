package com.perscholas.twistntreats.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    private List<Order> orders;

   @Column(name="email")
    private String email;

   @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="address")
    private String address;

    @Column(name="area_code")
    private String areaCode;

    @Column(name="city")
    private String City;

    @Column(name="phone")
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date",columnDefinition ="DateTime" )
    private Date createdDate;


}

