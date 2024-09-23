package com.factulink.fkb.api.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    private Region region;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<District> districts = new ArrayList<>();
}
