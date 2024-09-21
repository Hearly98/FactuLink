package com.factulink.fkb.api.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "workers")
@Data
@Getter
@Setter
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User idUser;

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    private Roles idRol;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "email", length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_state", referencedColumnName = "id")
    private State idState;

    @ManyToOne
    @JoinColumn(name = "id_document", referencedColumnName = "id")
    private Document idDocument;

    @Column(name = "document", length = 50)
    private String document;
    public Integer getId() {
        return id;
    }
}
