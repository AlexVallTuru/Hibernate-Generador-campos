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
import entitats.Autonoma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author carlo
 */
public class ClassFactory implements TesteableFactory {
    private static final Logger logger = LogManager.getLogger(ClassFactory.class);
    private Faker fake = new Faker();

    @Override
    public Aeronau addMecanicsToPilotada(List<Soldat> lo, Pilotada p) throws Exception {
        if (lo.size() > 2) {
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
        if (lm.size() > 2) {
            throw new Exception();
        }
        for (Object obj : lm) {
            if (obj instanceof Missio missio) {

                a.setMissio(missio);
            }
        }

        return a;
    }

    @Override
    public Missio addAeronausToMissio(List<Aeronau> la, Missio m) throws Exception {
        if (la.size() > 2) {
            throw new Exception();
        }
        for (Object obj : la) {
            if (obj instanceof Aeronau aeronau) {

                m.setAeronau(aeronau);
            }
        }

        return m;
    }

    @Override
    public Aeronau addPilotToAeronauPilotada(Pilot p, Pilotada a) throws Exception {
        a.setPilot(p);
        return a;

    }

    @Override
    public Aeronau aeronauFactory(Class<?> tipus) {
        Aeronau aeronau = null;

        if (tipus == Transport.class) {

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
                    (float) fake.number().randomDouble(2, 0, 90),
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
        int principals = Utils.armesPrincipals.length;
        int secundaries = Utils.armasSecundarias.length;
        int armesCQC = Utils.armesCQC.length;
        int prestigis = Utils.prestigis.length;

        if (tipus == Mecanic.class) {
            soldat = new Mecanic(fake.number().randomDigit(),
                    null,
                    fake.number().numberBetween(0, 100),
                    fake.number().numberBetween(0, 100),
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    Utils.armesPrincipals[fake.number().numberBetween(0, principals)],
                    Utils.armasSecundarias[fake.number().numberBetween(0, secundaries)],
                    Utils.prestigis[fake.number().numberBetween(0, prestigis)],
                    Utils.armesCQC[fake.number().numberBetween(0, armesCQC)],
                    fake.bool().bool(),
                    Utils.localDateToSQLDate(fake.date().birthday()));

        } else if (tipus == Pilot.class) {

            soldat = new Pilot(
                    fake.space().planet(),
                    (Pilotada)new Object(),
                    fake.number().numberBetween(0, 100),
                    fake.number().numberBetween(0, 100),
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    Utils.armesPrincipals[fake.number().numberBetween(0, principals)],
                    Utils.armasSecundarias[fake.number().numberBetween(0, secundaries)],
                    Utils.prestigis[fake.number().numberBetween(0, prestigis)],
                    Utils.armesCQC[fake.number().numberBetween(0, armesCQC)],
                    fake.bool().bool(),
                    Utils.localDateToSQLDate(fake.date().birthday()));
        }
        return soldat;
    }

    /**
     * Funcio per generar nous registres
     * @param tipusClase
     * @param elements 
     */
    public void generadorRegistres(Class<?> tipusClase, int elements) {
        
        //Obtenir la sessio
        Session sessio = SingleSession.getInstance().getSessio();
        
        //Obtenir la clase pare
        Class<?> parent = tipusClase.getSuperclass();
        logger.info("La super clase de "+tipusClase+" es "+parent);
        logger.info("Iniciant trasaccio");
        //Començar la transaccio
        sessio.beginTransaction();
        
        logger.info("Generant entitats");
        for (int i = 0; i < elements; i++) {
            //Generar Soldats
            if (parent == Soldat.class) {
                sessio.persist(this.soldatFactory(tipusClase));
                logger.info("S'ha generat soldat nº : "+i);

            }

            //Generar Aeronaus
            if (parent == Pilotada.class || parent == Autonoma.class) {
                sessio.persist(this.aeronauFactory(tipusClase));
                logger.info("S'ha generat aeronau nº : "+i);

            }
            
            //Generar Missions
            if(tipusClase == Missio.class){
                sessio.persist(this.missioFactory());
                logger.info("S'ha generat missio nº : "+i);
            }
            
           
        }
        sessio.getTransaction().commit();
        logger.info("S'han guardat els registres");
       
    }

}
