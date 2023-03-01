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
import Utils.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aitor
 */
@Entity
@Table(name = "Combat")
public class Combat extends Pilotada implements TesteableEntity, Serializable {
    private static final long serialVersionUID = 1L;
    //Atributs
    @Column(name = "MaxMissils")
    private Integer aeronauCombatMaxMissils;
    @Column(name = "MaxCano")
    private Integer aeronauCombatMaxMunicioCano;

    public Combat() {
        super();
    }

    public Combat(Integer aeronauCombatMaxMissils, Integer aeronauCombatMaxMunicioCano, Pilot pilot, List<Mecanic> mecanic, Integer aeronauMatricula, String aeronauNom, Float aeronauRitmePujada, Integer aeronauVelocitatMaxima, boolean aeronauAutopilotada, java.util.Date aeronauDataFabricacio) {
        super(pilot, mecanic, aeronauMatricula, aeronauNom, aeronauRitmePujada, aeronauVelocitatMaxima, aeronauAutopilotada, aeronauDataFabricacio);
        this.aeronauCombatMaxMissils = aeronauCombatMaxMissils;
        this.aeronauCombatMaxMunicioCano = aeronauCombatMaxMunicioCano;
    }



    /**
     * @return the aeronauCombatMaxMissils
     */
    public Integer getAeronauCombatMaxMissils() {
        return aeronauCombatMaxMissils;
    }

    /**
     * @param aeronauCombatMaxMissils the aeronauCombatMaxMissils to set
     */
    public void setAeronauCombatMaxMissils(Integer aeronauCombatMaxMissils) {
        this.aeronauCombatMaxMissils = aeronauCombatMaxMissils;
    }

    /**
     * @return the aeronauCombatMaxMunicioCano
     */
    public Integer getAeronauCombatMaxMunicioCano() {
        return aeronauCombatMaxMunicioCano;
    }

    /**
     * @param aeronauCombatMaxMunicioCano the aeronauCombatMaxMunicioCano to set
     */
    public void setAeronauCombatMaxMunicioCano(Integer aeronauCombatMaxMunicioCano) {
        this.aeronauCombatMaxMunicioCano = aeronauCombatMaxMunicioCano;
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
        return super.aeronauRitmePujada;
    }

    @Override
    public Date getAtributDate() {
        return Utils.localDateToSQLDate(this.aeronauDataFabricacio);
    }

    @Override
    public Boolean getAtributBoolean() {
        return super.aeronauAutopilotada;
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
