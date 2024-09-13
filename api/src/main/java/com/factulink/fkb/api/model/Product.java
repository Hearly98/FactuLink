package com.factulink.fkb.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "products")
@Data
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "price_base")
    private Float priceBase;

    @Column(name = "stock")
    private Integer stock;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "publish_date")
    @Temporal(TemporalType.DATE)
    private Date publishDate;

    @ManyToOne
    @JoinColumn(name= "id_category", referencedColumnName = "id")
    private Category category;

    public Integer getId() {return id;}

}
