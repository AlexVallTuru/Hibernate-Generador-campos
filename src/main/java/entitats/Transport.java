/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

import Interficies.TesteableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import Utils.Utils;
import Utils.Utils;
import Utils.Utils;

/**
 *
 * @author Aitor
 */
@Entity
@Table(name="Transport")
public class Transport extends Pilotada implements TesteableEntity, Serializable {
    
    //Atributs
    @Column(name = "MaxTripulants")
    private Integer aeronauTransportMaxTripulants;
    @Column(name = "MaxPes")
    private Integer aeronauTransportMaxPes;

    //Constructor
    public Transport() {
        super();
    }

    //Constructor
    public Transport(Integer aeronauTransportMaxTripulants, Integer aeronauTransportMaxPes, Pilot pilot, List<Mecanic> mecanic, Integer aeronauMatricula, String aeronauNom, float  aeronauRitmePujada, Integer aeronauVelocitatMaxima, boolean aeronauAutopilotada, Date aeronauDataFabricacio) {
        super(pilot, mecanic, aeronauMatricula, aeronauNom, aeronauRitmePujada, aeronauVelocitatMaxima, aeronauAutopilotada, aeronauDataFabricacio);
        this.aeronauTransportMaxTripulants = aeronauTransportMaxTripulants;
        this.aeronauTransportMaxPes = aeronauTransportMaxPes;
    }
    
    /**
     * @return the aeronauTransportMaxTripulants
     */
    public Integer getAeronauTransportMaxTripulants() {
        return aeronauTransportMaxTripulants;
    }

    /**
     * @param aeronauTransportMaxTripulants the aeronauTransportMaxTripulants to set
     */
    public void setAeronauTransportMaxTripulants(Integer aeronauTransportMaxTripulants) {
        this.aeronauTransportMaxTripulants = aeronauTransportMaxTripulants;
    }

    /**
     * @return the aeronauTransportMaxPes
     */
    public Integer getAeronauTransportMaxPes() {
        return aeronauTransportMaxPes;
    }

    /**
     * @param aeronauTransportMaxPes the aeronauTransportMaxPes to set
     */
    public void setAeronauTransportMaxPes(Integer aeronauTransportMaxPes) {
        this.aeronauTransportMaxPes = aeronauTransportMaxPes;
    }

    @Override
    public Integer getAtributIdentificador() {
        return super.aeronauMatricula;
    }

    @Override
    public String getAtributString() {
       return super.aeronauNom;
    }

    @Override
    public Float getAtributFloat() {
        return this.aeronauRitmePujada;
                
    }

    @Override
    public Date getAtributDate() {
        return Utils.localDateToSQLDate(this.aeronauDataFabricacio);
    }

    @Override
    public Boolean getAtributBoolean() {
        return this.aeronauAutopilotada;
    }

    @Override
    public void setAtributString(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAtributFloat(Float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAtributDate(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAtributBoolean(Boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getAeronauMatricula() {
        return aeronauMatricula;
    }

    public void setAeronauMatricula(Integer aeronauMatricula) {
        this.aeronauMatricula = aeronauMatricula;
    }

    public String getAeronauNom() {
        return aeronauNom;
    }

    public void setAeronauNom(String aeronauNom) {
        this.aeronauNom = aeronauNom;
    }

    public float getAeronauRitmePujada() {
        return aeronauRitmePujada;
    }

    public void setAeronauRitmePujada(float aeronauRitmePujada) {
        this.aeronauRitmePujada = aeronauRitmePujada;
    }

    public Integer getAeronauVelocitatMaxima() {
        return aeronauVelocitatMaxima;
    }

    public void setAeronauVelocitatMaxima(Integer aeronauVelocitatMaxima) {
        this.aeronauVelocitatMaxima = aeronauVelocitatMaxima;
    }

    public boolean isAeronauAutopilotada() {
        return aeronauAutopilotada;
    }

    public void setAeronauAutopilotada(boolean aeronauAutopilotada) {
        this.aeronauAutopilotada = aeronauAutopilotada;
    }

    public java.util.Date getAeronauDataFabricacio() {
        return aeronauDataFabricacio;
    }

    public void setAeronauDataFabricacio(java.util.Date aeronauDataFabricacio) {
        this.aeronauDataFabricacio = aeronauDataFabricacio;
    }

    public List<Missio> getMissio() {
        return missio;
    }

    public void setMissio(List<Missio> missio) {
        this.missio = missio;
    }

    @Override
    public String toString() {
        return "\nLa classe Transport conte la següent informació:"
                + "\nMàxim número de tripulants: " + aeronauTransportMaxTripulants
                + "\nMàxim pes de l'aeronau:" + aeronauTransportMaxPes 
                + super.toString();
    }
    
    
    
}
