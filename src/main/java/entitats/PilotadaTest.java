/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "Pilotada")
public abstract class PilotadaTest extends AeronauTest  {

    @Column(name="TRIPULANTES")
    private int tripulantes;
    @Column(name="ARMAMENTO")
    private int armamento;
    
    @OneToOne(cascade=CascadeType.ALL)
    private Pilot pilot;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<Mecanic> mecanic;

    public PilotadaTest() {
        super();
    }

    public PilotadaTest(int tripulantes, int armamento, Pilot pilot, List<Mecanic> mecanic, int idAeronave, String modelo, float velocidadMaxima, int alcance, Date fechaFabricacion, Boolean enExpedicion) {
        super(idAeronave, modelo, velocidadMaxima, alcance, fechaFabricacion, enExpedicion);
        this.tripulantes = tripulantes;
        this.armamento = armamento;
        this.pilot = pilot;
        this.mecanic = mecanic;
    }

    public Pilot getPilotAeronau() {
        return pilot;
    }
    
    

   

}
