/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import jakarta.persistence.*;
import java.sql.Date;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "Autonoma")
public abstract class Autonoma extends AeronauTest {

    @Column(name = "tempsMaximDeVol")
    int tempsMaximDeVol;
    @Column(name = "pes")
    float pes;
    @Column(name = "sensors")
    int sensors;

    public Autonoma() {
        super();
    }

    public Autonoma(int tempsMaximDeVol, float pes, int sensors, int idAeronave, String modelo, float velocidadMaxima, int alcance, Date fechaFabricacion, Boolean enExpedicion) {
        super(idAeronave, modelo, velocidadMaxima, alcance, fechaFabricacion, enExpedicion);
        this.tempsMaximDeVol = tempsMaximDeVol;
        this.pes = pes;
        this.sensors = sensors;
    }        
}
