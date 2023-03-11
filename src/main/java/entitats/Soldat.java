/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "Soldat")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Soldat implements Serializable {

    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idUsuario;
    @Column(name = "VIDA", nullable = false)
    protected float vida;
    @Column(name = "PROTECCION")
    protected int proteccion;
    @Column(name = "DERROTAS", nullable = false)
    protected int numeroDerrotas;
    @Column(name = "VICTORIAS", nullable = false)
    protected int numeroVictorias;
    @Column(name = "ARMA_PRINCIPAL", nullable = false)
    protected String armaPrincipal;
    @Column(name = "ARMA_SEGUNDARIA", nullable = false)
    protected String armaSegundaria;
    @Column(name = "PRESTIGIO", nullable = false)
    protected String prestigio;
    @Column(name = "ARMA_CQC")
    protected String armaCQC;
    @Column(name = "EXPEDICION", nullable = false)
    protected Boolean enExpedicion;
    @Column(name = "NACIMIENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    protected Date nacimiento;

    public Soldat() {
    }

    public Soldat(float vida, int proteccion, int numeroDerrotas, int numeroVictorias, String armaPrincipal, String armaSegundaria, String prestigio, String armaCQC, Boolean enExpedicion, Date nacimiento) {
        this.vida = vida;
        this.proteccion = proteccion;
        this.numeroDerrotas = numeroDerrotas;
        this.numeroVictorias = numeroVictorias;
        this.armaPrincipal = armaPrincipal;
        this.armaSegundaria = armaSegundaria;
        this.prestigio = prestigio;
        this.armaCQC = armaCQC;
        this.enExpedicion = enExpedicion;
        this.nacimiento = nacimiento;
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

    @Override
    public String toString() {
        return "\nLa classe Soldat conte la següent informació:\n"
                + "Id usuari: " + idUsuario +
                "Vidda: " + vida
                + "\nProteccions: " + proteccion + 
                "\nNumero de derrotas: " + numeroDerrotas
                + "\nNumero de victorias: " + numeroVictorias
                + "\nArma principal: " + armaPrincipal +
                "\nArma segundaria: " + armaSegundaria +
                "\nPrestigui: " + prestigio +
                "\nArma cos a cos: " + armaCQC +
                "\nEn expedició: " + enExpedicion
                + "\nData de neixament: " + nacimiento;
    }

}
