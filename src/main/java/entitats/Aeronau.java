/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aitor
 */
public abstract class Aeronau {

    private Integer aeronauMatricula;
    private String aeronauNom;
    private Float aeronauRitmePujada;
    private Integer aeronauVelocitatMaxima;
    private boolean aeronauAutopilotada;
    private Date aeronauDataFabricacio;

    @ManyToMany(mappedBy = "aeronaus")
    private List<Pilotada> pilotades = new ArrayList<>();
}
