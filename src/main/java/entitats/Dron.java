/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import jakarta.persistence.*;
import java.sql.Date;
import Interficies.TesteableEntity;
import java.io.Serializable;
import java.util.List;
import Utils.Utils;
import Utils.Utils;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "Dron")
public class Dron extends Autonoma implements TesteableEntity, Serializable {

    @Column(name = "numHelices")
    int numHelices;

    public Dron() {
        super();

    }

    public Dron(int numHelices, int tempsMaximDeVol, float pes, int sensors, Integer aeronauMatricula, String aeronauNom, float aeronauRitmePujada, Integer aeronauVelocitatMaxima, boolean aeronauAutopilotada, java.util.Date aeronauDataFabricacio) {
        super(tempsMaximDeVol, pes, sensors, aeronauMatricula, aeronauNom, aeronauRitmePujada, aeronauVelocitatMaxima, aeronauAutopilotada, aeronauDataFabricacio);
        this.numHelices = numHelices;
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
        return super.pes;
    }

    @Override
    public Date getAtributDate() {
        return Utils.localDateToSQLDate(super.aeronauDataFabricacio);
    }

    @Override
    public Boolean getAtributBoolean() {
        return super.aeronauAutopilotada;
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

    public List<Missio> getMissions() {
        return super.missio;
    }

    @Override
    public String toString() {
        return "\nLa classe Dron conte la següent informació:"
                + "\nNumero d'helices : " + numHelices
                + super.toString();
    }
}
