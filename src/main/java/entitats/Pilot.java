/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import Interficies.TesteableEntity;
import Utils.Utils;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "Pilot")
public class Pilot extends Soldat implements TesteableEntity {

    @Column(name = "VEHICULO")
    private String vehiculo;
    @OneToOne(cascade = CascadeType.ALL)
    private Pilotada pilotada;

    public Pilot() {
        super();

    }

    ;

    public Pilot(String vehiculo, Pilotada pilotada, float vida, int proteccion, int numeroDerrotas, int numeroVictorias, String armaPrincipal, String armaSegundaria, String prestigio, String armaCQC, Boolean enExpedicion, Date nacimiento) {
        super(vida, proteccion, numeroDerrotas, numeroVictorias, armaPrincipal, armaSegundaria, prestigio, armaCQC, enExpedicion, nacimiento);
        this.vehiculo = vehiculo;
        this.pilotada = pilotada;
    }

    @Override
    public Integer getAtributIdentificador() {
        return super.idUsuario;
    }

    @Override
    public String getAtributString() {
        return super.armaCQC;
    }

    @Override
    public Float getAtributFloat() {
        return super.vida;
    }

    @Override
    public Date getAtributDate() {
        return Utils.localDateToSQLDate(super.nacimiento);
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

}
