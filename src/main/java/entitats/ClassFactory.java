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
    public Aeronau addMecanicsToPilotada(List<Soldat> lo, Pilotada p) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Aeronau addMissionsToAeronau(List<MissioTest> lm, Aeronau a) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MissioTest addAeronausToMissio(List<Aeronau> la, MissioTest m) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Aeronau addPilotToAeronauPilotada(Pilot p, Pilotada a) throws Exception {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Aeronau aeronauFactory(Class<?> tipus) {
        Aeronau aeronau = null;
        Autonoma autonoma = new DronTest();
        if (tipus == Transport.class) {
            aeronau = new Transport();
        } else if (tipus == Combat.class) {
            aeronau = new Combat();

        } else if (tipus == DronTest.class) {
            aeronau = new Dron();
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
    
    public Pilotada pilotadaFactory(){
        Pilotada pilotada = null;
        return null;
        
    }

}
