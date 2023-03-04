/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import org.hibernate.annotations.Type;

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

    


    @Override
    public String toString() {
        return "Soldat{" + "idUsuario=" + idUsuario + ", vida=" + vida + ", proteccion=" + proteccion + ", numeroDerrotas=" + numeroDerrotas + ", numeroVictorias=" + numeroVictorias + ", armaPrincipal=" + armaPrincipal + ", armaSegundaria=" + armaSegundaria + ", prestigio=" + prestigio + ", armaCQC=" + armaCQC + ", mejorasCampo=" + ", enExpedicion=" + enExpedicion + ", nacimiento=" + nacimiento + '}';
    }

}
