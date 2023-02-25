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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "Pilotada")
public abstract class Pilotada extends Aeronau implements TesteableEntity, Serializable {

    //Atributs
    @Column(name = "Pilot")
    private Integer aeronauPilot;
    @Column(name = "Mecanics")
    private ArrayList<Integer> aeronauMecanics;

    //Relacions
    @OneToOne(cascade = CascadeType.ALL)
    private Pilot pilot;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Mecanic> mecanic;

    public Pilotada() {
        super();
    }

    public Pilotada(Integer aeronauPilot, ArrayList<Integer> aeronauMecanics, Pilot pilot, List<Mecanic> mecanic, Integer aeronauMatricula, String aeronauNom, Float aeronauRitmePujada, Integer aeronauVelocitatMaxima, boolean aeronauAutopilotada, Date aeronauDataFabricacio) {
        super(aeronauMatricula, aeronauNom, aeronauRitmePujada, aeronauVelocitatMaxima, aeronauAutopilotada, aeronauDataFabricacio);
        this.aeronauPilot = aeronauPilot;
        this.aeronauMecanics = aeronauMecanics;
        this.pilot = pilot;
        this.mecanic = mecanic;
    }
}
