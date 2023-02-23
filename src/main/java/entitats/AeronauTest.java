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
import org.hibernate.annotations.ColumnDefault;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "Aeronau")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AeronauTest implements TesteableEntity,Serializable {

    @Id
    @Column(name="ID_Nave",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAeronave;
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "Vmax",nullable=false)
    private float velocidadMaxima;
    @Column(name = "Alcance")
    private int alcance;
    @Column(name="Fabricada",nullable = false)
    private Date fechaFabricacion;
    @Column(name="En_Expedicion",nullable = false)
    private Boolean enExpedicion;
    @ManyToMany(cascade={CascadeType.ALL},mappedBy = "aeronau")
    private List<MissioTest> missio = new ArrayList<>();
    
    
    public AeronauTest(){
        
    }

    public AeronauTest(int idAeronave, String modelo, float velocidadMaxima, int alcance, Date fechaFabricacion, Boolean enExpedicion) {
        this.idAeronave = idAeronave;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.alcance = alcance;
        this.fechaFabricacion = fechaFabricacion;
        this.enExpedicion = enExpedicion;
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
