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
import java.util.ArrayList;
import java.util.List;

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

    public Transport() {
        super();
    }

    public Transport(Integer aeronauTransportMaxTripulants, Integer aeronauTransportMaxPes, Integer aeronauPilot, ArrayList<Integer> aeronauMecanics, Pilot pilot, List<Mecanic> mecanic, Integer aeronauMatricula, String aeronauNom, Float aeronauRitmePujada, Integer aeronauVelocitatMaxima, boolean aeronauAutopilotada, java.util.Date aeronauDataFabricacio) {
        super(aeronauPilot, aeronauMecanics, pilot, mecanic, aeronauMatricula, aeronauNom, aeronauRitmePujada, aeronauVelocitatMaxima, aeronauAutopilotada, aeronauDataFabricacio);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAtributString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Float getAtributFloat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getAtributDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getAtributBoolean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
