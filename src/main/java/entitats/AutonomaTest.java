/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import jakarta.persistence.*;
import java.sql.Date;

/**
 *
 * @author carlo
 */
@Entity
@Table(name="Autonoma")
abstract class AutonomaTest extends AeronauTest {
    @Column(name="capacidad")
    private int capacidadCarga;
    
    
    public AutonomaTest(){
        super();
    }

    public AutonomaTest(int capacidadCarga, int idAeronave, String modelo, float velocidadMaxima, int alcance, Date fechaFabricacion, Boolean enExpedicion) {
        super(idAeronave, modelo, velocidadMaxima, alcance, fechaFabricacion, enExpedicion);
        this.capacidadCarga = capacidadCarga;
    }
    
   
    
}
