/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import Interficies.TesteableEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "Mecanic")
public class Mecanic extends Soldat implements TesteableEntity,Serializable {

    @Column(name = "VEHICULOS_DESTRUIDOS")
    private int vehiculosDestruidos;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pilotada")
    private Pilotada pilotada;

    public  Mecanic() {
        super();
    }

    

    public Mecanic(int vehiculosDestruidos, PilotadaTest pilotada, int idUsuario, float vida, int proteccion, int numeroDerrotas, int numeroVictorias, String armaPrincipal, String armaSegundaria, String prestigio, String armaCQC, List<String> mejorasCampo, Boolean enExpedicion, Date nacimiento) {
        super(idUsuario, vida, proteccion, numeroDerrotas, numeroVictorias, armaPrincipal, armaSegundaria, prestigio, armaCQC, mejorasCampo, enExpedicion, nacimiento);
        this.vehiculosDestruidos = vehiculosDestruidos;
        this.pilotada = pilotada;
    }
    
    

    @Override
    public Integer getAtributIdentificador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAtributString() {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Float getAtributFloat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Date getAtributDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean getAtributBoolean() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributString(String s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributFloat(Float f) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributDate(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributBoolean(Boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
