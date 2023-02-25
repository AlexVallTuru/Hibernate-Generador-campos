/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

import Interficies.TesteableEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aitor
 */
@Entity
@Table(name = "Aeronau")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Aeronau implements TesteableEntity, Serializable {

    //Atributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer aeronauMatricula;
    @Column(name = "Nom")
    private String aeronauNom;
    @Column(name = "RitmePujada", nullable = false)
    private Float aeronauRitmePujada;
    @Column(name = "VelocitatMaxima", nullable = false)
    private Integer aeronauVelocitatMaxima;
    @Column(name = "EsPilotada", nullable = false)
    private boolean aeronauAutopilotada;
    @Column(name = "DataFabricacio", nullable = false)
    private Date aeronauDataFabricacio;

    //Relacio
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "aeronau")
    private List<Missio> missio = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "aeronaus")
    private List<Pilotada> pilotades = new ArrayList<>();

    @ManyToMany(mappedBy = "aeronaus")
    private List<Missio> missions;

    public Aeronau() {
        super();
    }

    public Aeronau(Integer aeronauMatricula, String aeronauNom, Float aeronauRitmePujada, Integer aeronauVelocitatMaxima, boolean aeronauAutopilotada, Date aeronauDataFabricacio) {
        this.aeronauMatricula = aeronauMatricula;
        this.aeronauNom = aeronauNom;
        this.aeronauRitmePujada = aeronauRitmePujada;
        this.aeronauVelocitatMaxima = aeronauVelocitatMaxima;
        this.aeronauAutopilotada = aeronauAutopilotada;
        this.aeronauDataFabricacio = aeronauDataFabricacio;
    }
}
