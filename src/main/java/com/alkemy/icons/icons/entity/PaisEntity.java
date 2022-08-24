package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "pais")
@Getter
@Setter
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "cant_habitantes") //base de datos sin camelcase
    private Long cantidadHabitantes; //entidad java con camelcase

    private Long superficies; //m2

    /* DEFINIR RELACION
    // FETCH ES DE TIPO TEMPRANA, AL PEDIR UN DATO DE TIPO PAIS SI O SI VIENE CON SUS CONTINENTES
    //CASCADE ES PARA QUE TODAS LAS OPERACIONES SEAN CONSECUENTES Y SE APLIQUEN AL CONTINENTE TAMBIEN
    //JOIN ES COMO SE VA A JOINEAR ESTA TABLA CON EL CONTINENTE Y LE DIGO QUE ES POR EL ID
    //ES INSERTABLE Y UPDATABLE FALSE PORQUE lo uso solamente para obtener informacion */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    private ContinenteEntity continente;

    @Column(name = "continente_id", nullable = false)
    private Long continenteId;

    //Many to many esta aca y en iconos
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )

    @JoinTable(
            name = "icon_pais", //tabla intermedia de join
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id")) //del otro lado hacia aca
    private Set<IconEntity> icons = new HashSet<>(); //aca le digo con que entidad se relaciona

   /* @Override
    public boolean equals(Object obj) {
        if
    } */
}
