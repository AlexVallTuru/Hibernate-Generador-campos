/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Aitor
 */
@Entity
@Table(name = "Aeronau")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Aeronau implements Serializable {

    private static final long serialVersionUID = 1L;
    //Atributs
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false, unique = true)
    protected Integer id_aeronau;
    @Column(name = "matricula")
    protected String aeronauMatricula;
    @Column(name = "Nom")
    protected String aeronauNom;
    @Column(name = "RitmePujada", nullable = false)
    protected float aeronauRitmePujada;
    @Column(name = "VelocitatMaxima", nullable = false)
    protected Integer aeronauVelocitatMaxima;
    @Column(name = "EsPilotada", nullable = false)
    @Convert(converter=org.hibernate.type.YesNoConverter.class)
    protected boolean aeronauAutopilotada;
    @Column(name = "DataFabricacio", nullable = false)
    @Temporal(TemporalType.DATE)
    protected Date aeronauDataFabricacio;

    //Relacio
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "aeronau")
    protected List<Missio> missio = new ArrayList<>();

    //@ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "aeronaus")
    //private List<Pilotada> pilotades = new ArrayList<>();


    public Aeronau() {
        super();
    }

    public Aeronau(String aeronauMatricula, String aeronauNom, float aeronauRitmePujada, Integer aeronauVelocitatMaxima, boolean aeronauAutopilotada, Date aeronauDataFabricacio) {
        this.aeronauMatricula = aeronauMatricula;
        this.aeronauNom = aeronauNom;
        this.aeronauRitmePujada = aeronauRitmePujada;
        this.aeronauVelocitatMaxima = aeronauVelocitatMaxima;
        this.aeronauAutopilotada = aeronauAutopilotada;
        this.aeronauDataFabricacio = aeronauDataFabricacio;
    }


    




    public String getAeronauMatricula() {
        return aeronauMatricula;
    }

    public void setAeronauMatricula(String aeronauMatricula) {
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

    public Date getAeronauDataFabricacio() {
        return aeronauDataFabricacio;
    }

    public void setAeronauDataFabricacio(Date aeronauDataFabricacio) {
        this.aeronauDataFabricacio = aeronauDataFabricacio;
    }

    public List<Missio> getMissio() {
        return missio;
    }

    public void setMissio(Missio missio) {
        this.missio.add(missio);
    }

    //public List<Pilotada> getPilotades() {
    //    return pilotades;
    //}

    //public void setPilotades(List<Pilotada> pilotades) {
    //    this.pilotades = pilotades;
    //}

    @Override
    public String toString() {

        String missionStr = "";
        if (missio.size() == 0) {
            missionStr = "\nNo conte ninguna MISSION";
        } else {
            missionStr = "\nConte un total de " + getMissio().size() + " MISSIONS:" + getMissio().stream().map(a -> "\nCodi missio: " + a.getCodiMissio() + "\t\t\t---\t\t\tNom: " + a.getNom()+ "\t\t\t---\t\t\tData de fabricació: " + a.getDurada() + "dies")
                    .collect(Collectors.joining(", "));
        }
        return "\nLa classe Aeronau conte la següent informació:"
                + "\nMatricula aeronau: " + aeronauMatricula
                + "\nNom:" + aeronauNom
                + "\nRitme de Pujada: " + aeronauRitmePujada
                + "\nVelocitat Maxima: " + aeronauVelocitatMaxima
                + "\nEs Autopilotada: " + aeronauAutopilotada
                + "\nData de fabricacio: " + aeronauDataFabricacio
                + missionStr;

    }
}
