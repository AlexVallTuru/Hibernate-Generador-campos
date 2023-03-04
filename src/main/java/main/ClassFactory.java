/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Interficies.TesteableFactory;
import com.github.javafaker.Faker;
import entitats.Aeronau;
import entitats.Combat;
import entitats.Dron;
import entitats.Mecanic;
import entitats.Missio;
import entitats.Pilot;
import entitats.Pilotada;
import entitats.Soldat;
import entitats.Transport;
import java.util.ArrayList;
import java.util.List;
import Utils.Utils;

/**
 *
 * @author carlo
 */
public class ClassFactory implements TesteableFactory {

    private Faker fake = new Faker();

    @Override
    public Aeronau addMecanicsToPilotada(List<Soldat> lo, Pilotada p) throws Exception {
        if(lo.size()>2){
            throw new Exception();
        }
        for (Object obj : lo) {
            if (obj instanceof Mecanic mecanic) {
                
                p.setMecanic(mecanic);
            }
        }

        return p;
    }

    @Override
    public Aeronau addMissionsToAeronau(List<Missio> lm, Aeronau a) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Missio addAeronausToMissio(List<Aeronau> la, Missio m) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Aeronau addPilotToAeronauPilotada(Pilot p, Pilotada a) throws Exception {
        a.setPilot(p);
        return a;

    }

    @Override
    public Aeronau aeronauFactory(Class<?> tipus) {
        Aeronau aeronau = null;

        //Pilot p = (Pilot) this.soldatFactory(Pilot.class);
        //List<Mecanic> m = (List<Mecanic>) (List<?>) this.mecanicsFactory(4);
        if (tipus == Transport.class) {
            //aeronau = new Transport(Integer.MAX_VALUE, Integer.MIN_VALUE, pilot, mecanic, Integer.MIN_VALUE, aeronauNom, Float.MIN_NORMAL, Integer.MIN_VALUE, true, aeronauDataFabricacio)
            aeronau = new Transport(
                    fake.number().randomDigitNotZero(),
                    fake.number().randomDigitNotZero(),
                    null,
                    new ArrayList<>(),
                    fake.number().randomDigitNotZero(),
                    fake.aviation().airport(),
                    fake.number().randomNumber(),
                    fake.number().randomDigit(),
                    fake.bool().bool(), Utils.localDateToSQLDate(fake.date().birthday())
            );
        } else if (tipus == Combat.class) {

            aeronau = new Combat(
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    null,
                    new ArrayList<>(),
                    fake.number().randomDigit(),
                    fake.aviation().aircraft(),
                    fake.number().randomNumber(),
                    fake.number().randomDigit(),
                    fake.bool().bool(),
                    Utils.localDateToSQLDate(fake.date().birthday()));

        } else if (tipus == Dron.class) {
            aeronau = new Dron(
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    0,
                    fake.number().randomDigit(),
                    fake.aviation().aircraft(),
                    fake.number().randomNumber(),
                    fake.number().randomDigit(),
                    fake.bool().bool(),
                    Utils.localDateToSQLDate(fake.date().birthday()));

        }
        return aeronau;
    }

    @Override
    public List<Soldat> mecanicsFactory(int elements
    ) {
        List<Soldat> soldats = new ArrayList<Soldat>();
        for (int i = 0; i < elements; i++) {
            soldats.add(soldatFactory(Mecanic.class));
        }
        return soldats;
    }

    @Override
    public Missio missioFactory() {
        return new Missio(fake.name().username(), fake.number().randomNumber(), Utils.localDateToSQLDate(fake.date().birthday()), fake.bool().bool(), fake.address().city(), null);
    }

    @Override
    public List<Missio> missionsFactory(int elements
    ) {
        List<Missio> missions = new ArrayList<Missio>();
        for (int i = 0; i < elements; i++) {
            missions.add(missioFactory());
        }
        return missions;
    }

    @Override
    public List<Soldat> pilotsFactory(int elements
    ) {
        List<Soldat> soldats = new ArrayList<Soldat>();
        for (int i = 0; i < elements; i++) {
            soldats.add(soldatFactory(Pilot.class));
        }
        return soldats;
    }

    @Override
    public Soldat soldatFactory(Class<?> tipus
    ) {
        Soldat soldat = null;

        if (tipus == Mecanic.class) {
            soldat = new Mecanic(fake.number().randomDigit(),
                    null,
                    fake.number().randomNumber(),
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    fake.name().bloodGroup(),
                    fake.name().firstName(),
                    fake.name().firstName(),
                    fake.name().firstName(),
                    fake.bool().bool(),
                    Utils.localDateToSQLDate(fake.date().birthday()));

        } else if (tipus == Pilot.class) {

            soldat = new Pilot(
                    fake.space().planet(),
                    null,
                    fake.number().randomNumber(),
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    fake.name().bloodGroup(),
                    fake.name().firstName(),
                    fake.name().firstName(),
                    fake.name().firstName(),
                    fake.bool().bool(),
                    Utils.localDateToSQLDate(fake.date().birthday()));
        }
        return soldat;
    }

}
