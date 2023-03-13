/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "Autonoma")
public abstract class Autonoma extends Aeronau implements Serializable {

    @Column(name = "tempsMaximDeVol")
    int tempsMaximDeVol;
    @Column(name = "pes")
    float pes;
    @Column(name = "sensors")
    int sensors;

    public Autonoma() {
        super();
    }

    public Autonoma(int tempsMaximDeVol, float pes, int sensors, String aeronauMatricula, String aeronauNom, float aeronauRitmePujada, Integer aeronauVelocitatMaxima, boolean aeronauAutopilotada, Date aeronauDataFabricacio) {
        super(aeronauMatricula, aeronauNom, aeronauRitmePujada, aeronauVelocitatMaxima, aeronauAutopilotada, aeronauDataFabricacio);
        this.tempsMaximDeVol = tempsMaximDeVol;
        this.pes = pes;
        this.sensors = sensors;
    }

  

    public int getTempsMaximDeVol() {
        return tempsMaximDeVol;
    }

    public void setTempsMaximDeVol(int tempsMaximDeVol) {
        this.tempsMaximDeVol = tempsMaximDeVol;
    }

    public float getPes() {
        return pes;
    }

    public void setPes(float pes) {
        this.pes = pes;
    }

    public int getSensors() {
        return sensors;
    }

    public void setSensors(int sensors) {
        this.sensors = sensors;
    }

    @Override
    public String toString() {
        return "\nLa classe Autonoma conte la següent informació:"
                +"\nTemps màxim de vol :" + tempsMaximDeVol 
                +"\nPes :" + pes
                +"\nSensors" + sensors
                +super.toString();
    }  
}
