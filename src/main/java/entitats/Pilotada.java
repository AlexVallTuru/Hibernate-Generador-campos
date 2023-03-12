/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

import Interficies.TesteableEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;

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

    public Pilotada(Pilot pilot, String aeronauMatricula, String aeronauNom, float aeronauRitmePujada, Integer aeronauVelocitatMaxima, boolean aeronauAutopilotada, Date aeronauDataFabricacio) {
        super(aeronauMatricula, aeronauNom, aeronauRitmePujada, aeronauVelocitatMaxima, aeronauAutopilotada, aeronauDataFabricacio);
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
        String pilotString = pilot == null ? "\nSense PILOT assignat" : "Conte el seguent PILOT:\nNomb del vehicle: " + pilot.getVehiculo() + "\t\t\t---\t\t\tId Pilot: " + pilot.getIdUsuario() + "\t\t\t---\t\t\tArma principal: " + pilot.getArmaPrincipal();
        String mecanicString = mecanic.size() == 0 ? "\nSense MECANIC assignat" : "\nConte un total de: " + mecanic.size() + "MECANICS:" + getMecanic().stream().map(a -> "\nVehicle destruit: " + a.getVehiculosDestruidos());
        return "\nLa classe Pilotada conte la següent informació:"
                + pilotString
                + mecanicString
                + super.toString();
    }
}
