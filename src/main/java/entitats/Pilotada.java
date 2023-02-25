/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

import Interficies.TesteableEntity;
import jakarta.persistence.*;
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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pilotada_aeronau",
            joinColumns = {
                @JoinColumn(name = "pilotada_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "aeronau_id")})
    private List<Aeronau> aeronaus = new ArrayList<>();

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
