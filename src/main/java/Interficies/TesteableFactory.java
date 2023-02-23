/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

import entitats.AeronauTest;
import entitats.MissioTest;
import entitats.Pilot;
import entitats.PilotadaTest;
import entitats.Soldat;
import java.util.List;

/**
 *
 * @author manel
 * 
 * versió 22_23 1.0
 */
public interface TesteableFactory {

    /**
     * Afegeix mecanics a aeronau pilotada
     * @param lo LLista dels mecanics
     * @param p Aeronau
     * @return
     * @throws java.lang.Exception
     */
    AeronauTest addMecanicsToPilotada(List<Soldat> lo, PilotadaTest p) throws Exception;

    /**
     * Afegeix missions a Aeronau
     * @param lm
     * @param a Aeronau
     * @return
     * @throws java.lang.Exception
     */
    AeronauTest addMissionsToAeronau(List<MissioTest> lm, AeronauTest a) throws Exception;
    
    
    /***
     * Afegeix aeronaus a la missió
     * @param la
     * @param m
     * @return 
     * @throws java.lang.Exception 
     */
    MissioTest addAeronausToMissio(List<AeronauTest> la, MissioTest m) throws Exception;

    /**
     * Afegeix pilot a aeronau pilotada
     * @param p aeronau
     * @param a
     * @return
     * @throws java.lang.Exception
     */
    AeronauTest addPilotToAeronauPilotada(Pilot p, PilotadaTest a) throws Exception;

    /**
     * Retorna una instancia del tipus demanat amb dades ficticies
     * Veure
     * @param tipus (Dron, Transport, Combat)
     * @return
     */
    AeronauTest aeronauFactory(Class<?> tipus);

    /**
     * REtorna una llista de l'entitat demanada amb dades ficticies
     * @param elements quantitat d'elements a retornar
     * @return
     */
    List<Soldat> mecanicsFactory(int elements);

    /**
     * Retorna una instancia de missio amb dades ficticies
     * @return
     */
    MissioTest missioFactory();

    /**
     * Retorna una llista de missions amb dades ficticies
     * @param elements quantitat d'elements a retornar
     * @return
     */
    List<MissioTest> missionsFactory(int elements);

    /**
     * Retorna una llista de pilots amb dades ficticies
     * @param elements quantitat d'elements a retornar
     * @return
     */
    List<Soldat> pilotsFactory(int elements);

    /**
     * Crea una instancia de Mecanic o Pilot segons el paràmetre subministrat
     * @param tipus (macanic o pilot)
     * @return
     */
    Soldat soldatFactory(Class<?> tipus);
    
}
