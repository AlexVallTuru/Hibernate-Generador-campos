/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public abstract class Aeronau implements Serializable {

    private static final long serialVersionUID = 1L;
    //Atributs
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false, unique = true)
    protected Integer aeronauMatricula;
    @Column(name = "Nom")
    protected String aeronauNom;
    @Column(name = "RitmePujada", nullable = false)
    protected float aeronauRitmePujada;
    @Column(name = "VelocitatMaxima", nullable = false)
    protected Integer aeronauVelocitatMaxima;
    @Column(name = "EsPilotada", nullable = false)
    protected boolean aeronauAutopilotada;
    @Column(name = "DataFabricacio", nullable = false)
    @Temporal(TemporalType.DATE)
    protected Date aeronauDataFabricacio;

    //Relacio
    @ManyToMany(cascade = {CascadeType.ALL},mappedBy = "aeronau")
    protected List<Missio> missio = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "aeronaus")
    private List<Pilotada> pilotades = new ArrayList<>();

    @ManyToMany(mappedBy = "aeronau")
    private List<Missio> missions;

    public Aeronau() {
        super();
    }

    public Aeronau(String aeronauNom, float aeronauRitmePujada, Integer aeronauVelocitatMaxima, boolean aeronauAutopilotada, Date aeronauDataFabricacio) {

        this.aeronauNom = aeronauNom;
        this.aeronauRitmePujada = aeronauRitmePujada;
        this.aeronauVelocitatMaxima = aeronauVelocitatMaxima;
        this.aeronauAutopilotada = aeronauAutopilotada;
        this.aeronauDataFabricacio = aeronauDataFabricacio;
    }

}
