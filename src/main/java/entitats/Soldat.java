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
    private int idUsuario;
    @Column(name = "VIDA", nullable = false)
    private float vida;
    @Column(name = "PROTECCION")
    private int proteccion;
    @Column(name = "DERROTAS", nullable = false)
    private int numeroDerrotas;
    @Column(name = "VICTORIAS", nullable = false)
    private int numeroVictorias;
    @Column(name = "ARMA_PRINCIPAL", nullable = false)
    private String armaPrincipal;
    @Column(name = "ARMA_SEGUNDARIA", nullable = false)
    private String armaSegundaria;
    @Column(name = "PRESTIGIO", nullable = false)
    private String prestigio;
    @Column(name = "ARMA_CQC")
    private String armaCQC;
    @Column(name = "MEJORAS")
    private List<String> mejorasCampo;
    @Column(name = "EXPEDICION", nullable = false)
    private Boolean enExpedicion;
    @Column(name = "NACIMIENTO", nullable = false)
    private Date nacimiento;

    public Soldat() {
    }

    public Soldat(int idUsuario, float vida, int proteccion, int numeroDerrotas, int numeroVictorias, String armaPrincipal, String armaSegundaria, String prestigio, String armaCQC, List<String> mejorasCampo, Boolean enExpedicion, Date nacimiento) {
        this.idUsuario = idUsuario;
        this.vida = vida;
        this.proteccion = proteccion;
        this.numeroDerrotas = numeroDerrotas;
        this.numeroVictorias = numeroVictorias;
        this.armaPrincipal = armaPrincipal;
        this.armaSegundaria = armaSegundaria;
        this.prestigio = prestigio;
        this.armaCQC = armaCQC;
        this.mejorasCampo = mejorasCampo;
        this.enExpedicion = enExpedicion;
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return "Soldat{" + "idUsuario=" + idUsuario + ", vida=" + vida + ", proteccion=" + proteccion + ", numeroDerrotas=" + numeroDerrotas + ", numeroVictorias=" + numeroVictorias + ", armaPrincipal=" + armaPrincipal + ", armaSegundaria=" + armaSegundaria + ", prestigio=" + prestigio + ", armaCQC=" + armaCQC + ", mejorasCampo=" + mejorasCampo + ", enExpedicion=" + enExpedicion + ", nacimiento=" + nacimiento + '}';
    }

}
