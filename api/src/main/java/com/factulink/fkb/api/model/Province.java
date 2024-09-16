package com.factulink.fkb.api.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "provinces")
@Data
@Getter
@Setter
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_province", length = 100)
    private String nameProvince;

    @Column(name = "code_province", length = 15)
    private String codeProvince;

    @ManyToOne
    @JoinColumn(name = "id_region", referencedColumnName = "id")
    private Region idRegion;
}
