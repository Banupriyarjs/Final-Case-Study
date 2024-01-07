package com.perscholas.twistntreats.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_description")
    private String categoryDescription;

    @Column(name = "created_by")
    private Integer createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", columnDefinition = "DATE")
    private Date createdDate;

    @Column(name = "status")
    private String status;

   //Added constructor to iterate through a list using Java Streams
    public Category(Integer id, String categoryName, String categoryDescription) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    @PrePersist
    private void onCreate() {
        createdDate = new Date();
        //createdBy=1;
        //  createdBy= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
