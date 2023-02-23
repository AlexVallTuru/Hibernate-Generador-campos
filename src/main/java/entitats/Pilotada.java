/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aitor
 */
public abstract class Pilotada extends Aeronau {

    private Integer aeronauPilot;
    private ArrayList<Integer> aeronauMecanics;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pilotada_aeronau",
            joinColumns = {
                @JoinColumn(name = "pilotada_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "aeronau_id")})
    private List<Aeronau> aeronaus = new ArrayList<>();

}
