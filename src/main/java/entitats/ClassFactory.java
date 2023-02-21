/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitats;

import Interficies.TesteableFactory;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo
 */
public class ClassFactory implements TesteableFactory {
    
    private Faker fake = new Faker();

    @Override
    public AeronauTest addMecanicsToPilotada(List<Soldat> lo, PilotadaTest p) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AeronauTest addMissionsToAeronau(List<MissioTest> lm, AeronauTest a) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MissioTest addAeronausToMissio(List<AeronauTest> la, MissioTest m) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AeronauTest addPilotToAeronauPilotada(Pilot p, PilotadaTest a) throws Exception {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AeronauTest aeronauFactory(Class<?> tipus) {
        AeronauTest aeronau = null;
        if (tipus == TransportTest.class) {
            aeronau = new TransportTest();
        } else if (tipus == CombatTest.class) {
            aeronau = new CombatTest();

        } else if (tipus == DronTest.class) {
            aeronau = new DronTest();
        }
        return aeronau;

    }

    @Override
    public List<Soldat> mecanicsFactory(int elements) {
        List<Soldat> soldats = new ArrayList<Soldat>();
        for (int i = 0; i < elements; i++) {
            soldats.add(new Mecanic());
        }
        return soldats;
    }

    @Override
    public MissioTest missioFactory() {
        return new MissioTest();
    }

    @Override
    public List<MissioTest> missionsFactory(int elements) {
        List<MissioTest> missions = new ArrayList<MissioTest>();
        for (int i = 0; i < elements; i++) {
            missions.add(new MissioTest());
        }
        return missions;
    }

    @Override
    public List<Soldat> pilotsFactory(int elements) {
        List<Soldat> soldats = new ArrayList<Soldat>();
        for (int i = 0; i < elements; i++) {
            soldats.add(new Mecanic());
        }
        return soldats;
    }

    @Override
    public Soldat soldatFactory(Class<?> tipus) {
        Soldat soldat = null;

        if (tipus == Mecanic.class) {
            soldat = new Mecanic();
            
            
                    
        } else if (tipus == Pilot.class) {
            soldat = new Pilot();
        }
        return soldat;
    }
    
    public PilotadaTest pilotadaFactory(){
        PilotadaTest pilotada = null;
        return null;
        
    }

}
