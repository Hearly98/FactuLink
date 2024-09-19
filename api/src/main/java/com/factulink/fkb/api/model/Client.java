package com.factulink.fkb.api.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Data
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "business_name", length = 200)
    private String businessName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id")
    private District district;

    @ManyToOne
    @JoinColumn(name = "id_document", referencedColumnName = "id")
    private Document idDocument;

    @Column(name = "document", length = 50)
    private String document;
}
