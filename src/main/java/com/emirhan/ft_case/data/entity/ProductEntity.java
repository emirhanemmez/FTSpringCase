package com.emirhan.ft_case.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ft_product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<CommentEntity> comment;
}
