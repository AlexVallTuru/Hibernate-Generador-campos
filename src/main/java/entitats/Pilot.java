/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import Interficies.TesteableEntity;
import Utils.Utils;
import jakarta.persistence.*;
import java.sql.Date;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "Pilot")
public class Pilot extends Soldat implements TesteableEntity {

    @Column(name = "Vehicle")
    private String vehiculo;
    @OneToOne(cascade = CascadeType.ALL)
    private Pilotada pilotada;

    public Pilot() {
        super();
    }

    public Pilot(String vehiculo, Pilotada pilotada, float vida, int proteccion, int numeroDerrotas, int numeroVictorias, String armaPrincipal, String armaSegundaria, String prestigio, String armaCQC, Boolean enExpedicion, Date nacimiento) {
        super(vida, proteccion, numeroDerrotas, numeroVictorias, armaPrincipal, armaSegundaria, prestigio, armaCQC, enExpedicion, nacimiento);
        this.vehiculo = vehiculo;
        this.pilotada = pilotada;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public int getProteccion() {
        return proteccion;
    }

    public void setProteccion(int proteccion) {
        this.proteccion = proteccion;
    }

    public int getNumeroDerrotas() {
        return numeroDerrotas;
    }

    public void setNumeroDerrotas(int numeroDerrotas) {
        this.numeroDerrotas = numeroDerrotas;
    }

    public int getNumeroVictorias() {
        return numeroVictorias;
    }

    public void setNumeroVictorias(int numeroVictorias) {
        this.numeroVictorias = numeroVictorias;
    }

    public String getArmaPrincipal() {
        return armaPrincipal;
    }

    public void setArmaPrincipal(String armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }

    public String getArmaSegundaria() {
        return armaSegundaria;
    }

    public void setArmaSegundaria(String armaSegundaria) {
        this.armaSegundaria = armaSegundaria;
    }

    public String getPrestigio() {
        return prestigio;
    }

    public void setPrestigio(String prestigio) {
        this.prestigio = prestigio;
    }

    public String getArmaCQC() {
        return armaCQC;
    }

    public void setArmaCQC(String armaCQC) {
        this.armaCQC = armaCQC;
    }

    public Boolean getEnExpedicion() {
        return enExpedicion;
    }

    public void setEnExpedicion(Boolean enExpedicion) {
        this.enExpedicion = enExpedicion;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Pilotada getPilotada() {
        return pilotada;
    }

    public void setPilotada(Pilotada pilotada) {
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

    @Override
    public String toString() {
        String pilotadaString;
        if (pilotada == null) {
            pilotadaString = "\nSense pilotada assignada";
        } else {
            pilotadaString = pilotada.toString();
        }
        return "\nLa classe Pilot conte la següent informació:"
                + "\nNombre vehicule: " + vehiculo
                + "\n" + pilotadaString
                + super.toString();
    }


}
