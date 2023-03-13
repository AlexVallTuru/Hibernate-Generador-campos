/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import Interficies.TesteableEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "Missio")
public class Missio implements TesteableEntity, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codiMissio", nullable = false, unique = true)
    int codiMissio;
    @Column(name = "nom")
    String nom;
    @Column(name = "durada")
    float durada;

    @Column(name="dateInici",unique=true)

    Date dateInici;
    @Column(name="completada")
    @Convert(converter=org.hibernate.type.YesNoConverter.class)
    Boolean completada;
    @Column(name = "ubicacio")
    String ubicacio;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Aeronau")
    private List<Aeronau> aeronau = new ArrayList<>();

    public Missio() {
        super();
    }

    public int getCodiMissio() {
        return codiMissio;
    }

    public void setCodiMissio(int codiMissio) {
        this.codiMissio = codiMissio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getDurada() {
        return durada;
    }

    public void setDurada(float durada) {
        this.durada = durada;
    }

    public Date getDateInici() {
        return dateInici;
    }

    public void setDateInici(Date dateInici) {
        this.dateInici = dateInici;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    public List<Aeronau> getAeronau() {
        return aeronau;
    }

    public void setAeronau(List<Aeronau> aeronau) {
        this.aeronau = aeronau;
    }

    public Missio(String nom, float durada, Date dateInici, Boolean completada, String ubicacio,
            List<Aeronau> aeronau) {
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributFloat(Float f) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributDate(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributBoolean(Boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    @Override
    public String toString() {
        String aeronauStr = "";
        if (aeronau.size() == 0) {
            aeronauStr = "\nNo conte ninguna AERONAU";
        } else {
            aeronauStr =" (\nConte un total de " + getAeronaus().size() +" AERONAUS:"+ getAeronaus().stream()
                    .map(a ->"\nNom: " + a.getAeronauNom().toString() + "\t\t\t---\t\t\tMatricula: " + a.getAeronauMatricula() + "\t\t\t---\t\t\tData de fabricació: "+ a.getAeronauDataFabricacio())
                    .collect(Collectors.joining(", "));

        }
        return "\nLa classe Missio conte la següent informació: "
                + "\nCodi Missio: " + codiMissio
                + "\nNom: " + nom
                + "\nDurada: " + durada
                + "\nData de inici: " + dateInici
                + "\nEstà completada: " + completada
                + "\nHubicacio: " + ubicacio
                + aeronauStr;
    }

}
