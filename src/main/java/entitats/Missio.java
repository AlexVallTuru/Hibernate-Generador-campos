/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import Interficies.TesteableEntity;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "Missio")
public class Missio implements TesteableEntity {

    @Id
    @Column(name = "codiMissio", nullable = false)
    int codiMissio;
    @Column(name = "nom")
    String nom;
    @Column(name = "durada")
    Float durada;
    @Column(name = "dateInici")
    Date dateInici;
    @Column(name = "completada")
    Boolean completada;
    @Column(name = "ubicacio")
    String ubicacio;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Aeronau")
    private List<Aeronau> aeronau;

    @ManyToMany
    @JoinTable(
            name = "missio_aeronau",
            joinColumns = @JoinColumn(name = "missio_id"),
            inverseJoinColumns = @JoinColumn(name = "aeronau_id"))
    private List<Aeronau> aeronaus;

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
