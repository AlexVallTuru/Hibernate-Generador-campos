/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import Interficies.TesteableEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
@Entity
@Table(name="Missio")
public class Missio implements TesteableEntity, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="codiMissio", nullable = false)
    int codiMissio;
    @Column(name="nom")
    String nom;
    @Column(name="durada")
    float durada;
    @Column(name="dateInici")
    Date dateInici;
    @Column(name="completada")
    Boolean completada;
    @Column(name="ubicacio")
    String ubicacio;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Aeronau")
    private List<Aeronau> aeronau = new ArrayList<>();

    public Missio() {
        super();
    }

    public Missio(String nom, float durada, Date dateInici, Boolean completada, String ubicacio, List<Aeronau> aeronau) {
        this.nom = nom;
        this.durada = durada;
        this.dateInici = dateInici;
        this.completada = completada;
        this.ubicacio = ubicacio;
        this.aeronau = aeronau;
    }
    

    public Integer getAtributIdentificador() {
        return codiMissio;
    }

    @Override
    public String getAtributString() {
        return nom;

    }

    @Override
    public Float getAtributFloat() {
        return durada;
    }

    @Override
    public Date getAtributDate() {
        return dateInici;
    }

    @Override
    public Boolean getAtributBoolean() {
        return completada;
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

    public void setAeronaus(List<Aeronau> aeronau) {
        this.aeronau = aeronau;
    }

    public List<Aeronau> getAeronaus() {
        return aeronau;
    }

    public void setAeronau(Aeronau aeronau) {
        this.aeronau.add(aeronau);
    }

}
