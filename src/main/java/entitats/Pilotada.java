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
import java.util.stream.Collectors;

/**
 *
 * @author Aitor
 */
@Entity
@Table(name = "Pilotada")
public abstract class Pilotada extends Aeronau implements TesteableEntity, Serializable {

    private static final long serialVersionUID = 1L;
    //Relacions
    @OneToOne(cascade = CascadeType.ALL)
    private Pilot pilot;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Mecanic> mecanic = new ArrayList<>();
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

    public Pilotada(Pilot pilot, List<Mecanic> mecanic, Integer aeronauMatricula, String aeronauNom, Float aeronauRitmePujada, Integer aeronauVelocitatMaxima, boolean aeronauAutopilotada, Date aeronauDataFabricacio) {
        super(aeronauNom, aeronauRitmePujada, aeronauVelocitatMaxima, aeronauAutopilotada, aeronauDataFabricacio);
        this.pilot = pilot;
        this.mecanic = mecanic;
        this.pilot = null;
    }

    public Pilot getPilotAeronau() {
        return pilot;
    }

    public List<Mecanic> getMecanics() {
        return mecanic;
    }

    public void setPilot(Pilot p) {
        this.pilot = p;

    }

    public void setMecanic(Mecanic mecanic) {
        this.mecanic.add(mecanic);
    }

    public List<Mecanic> getMecanic() {
        return mecanic;
    }

    public void setMecanic(List<Mecanic> mecanic) {
        this.mecanic = mecanic;
    }

    public List<Aeronau> getAeronaus() {
        return aeronaus;
    }

    public void setAeronaus(List<Aeronau> aeronaus) {
        this.aeronaus = aeronaus;
    }

    @Override
    public String toString() {
        String pilotString = pilot == null ? "\nSense pilot assignat" : pilot.toString();
        String mecanicString = mecanic == null ? "\nSense mecànic assignat" : mecanic.toString();
        return "La classe Pilotada conte la següent informació:\n"
                + pilotString
                + mecanicString
                + super.toString();
    }
}
