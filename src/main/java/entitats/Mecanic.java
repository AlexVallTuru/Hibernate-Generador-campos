/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import Interficies.TesteableEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "Mecanic")
public class Mecanic extends Soldat implements TesteableEntity, Serializable {


    @Column(name = "VEHICULOS_DESTRUIDOS")
    private int vehiculosDestruidos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pilotada")    
    @OneToMany(mappedBy = "mecanic", cascade = CascadeType.ALL)
    private Pilotada pilotada;

    public Mecanic() {
        super();
    }

    public Mecanic(int vehiculosDestruidos, Pilotada pilotada, float vida, int proteccion, int numeroDerrotas, int numeroVictorias, String armaPrincipal, String armaSegundaria, String prestigio, String armaCQC, Boolean enExpedicion, Date nacimiento) {
        super(vida, proteccion, numeroDerrotas, numeroVictorias, armaPrincipal, armaSegundaria, prestigio, armaCQC, enExpedicion, nacimiento);
        this.vehiculosDestruidos = vehiculosDestruidos;
        this.pilotada = pilotada;
    }



    
    @Override
    public Integer getAtributIdentificador() {
        return super.idUsuario;
    }

    @Override
    public String getAtributString() {

        return super.armaPrincipal;
    }

    @Override
    public Float getAtributFloat() {
        return super.vida;
    }

    @Override
    public Date getAtributDate() {
        return super.nacimiento;
    }

    @Override
    public Boolean getAtributBoolean() {
        return super.enExpedicion;
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

    @Override
    public String toString() {
        return "\nLa classe Mecanic conte la següent informació: "
                + "\nvehiculosDestruidos: " + vehiculosDestruidos
                + "\nPilotada: " + "Work in progress"
                +super.toString();
    }        
}
