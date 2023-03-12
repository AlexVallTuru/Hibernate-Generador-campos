/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Interficies.TesteableFactory;
import com.github.javafaker.Faker;

import entitats.*;
import java.util.*;
import Utils.Utils;
import entitats.Autonoma;
import org.apache.logging.log4j.*;
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

            if (obj instanceof Mecanic) {

                p.setMecanic((Mecanic) obj);
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
            if (obj instanceof Missio) {

                a.setMissio((Missio) obj);
            }
        }

        return a;
    }

    @Override
    public Missio addAeronausToMissio(List<Aeronau> la, Missio m) throws Exception {
        if (la.size() > 8) {
            throw new Exception();
        }

        for (Object obj : la) {
            if (obj instanceof Aeronau) {

                m.setAeronau((Aeronau) obj);
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
                    Integer.toString(fake.number().numberBetween(1000, 9999)),
                    fake.aviation().airport(),
                    (float) fake.number().randomDouble(2, 100, 251),
                    fake.number().numberBetween(180, 921),
                    fake.bool().bool(),
                    Utils.localDateToSQLDate(fake.date().birthday())
            );
        } else if (tipus == Combat.class) {

            aeronau = new Combat(
                    fake.number().numberBetween(8, 13),
                    fake.number().numberBetween(0, 2),
                    null,
                    Integer.toString(fake.number().numberBetween(1000, 9999)),
                    fake.aviation().aircraft(),
                    (float) fake.number().randomDouble(2, 100, 250),
                    fake.number().numberBetween(180, 3000),
                    fake.bool().bool(),
                    Utils.localDateToSQLDate(fake.date().birthday()));

        } else if (tipus == Dron.class) {
            aeronau = new Dron(
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    fake.number().randomDigit(),
                    Integer.toString(fake.number().numberBetween(1000, 9999)),
                    fake.aviation().aircraft(),
                    (float) fake.number().randomDouble(2, 100, 251),
                    fake.number().numberBetween(2, 415),
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
        return new Missio(
                Utils.missions[fake.number().numberBetween(0, Utils.missions.length + 1)],
                fake.number().numberBetween(1, 15),
                Utils.localDateToSQLDate(fake.date().birthday()),
                fake.bool().bool(),
                fake.address().city(),
                new ArrayList());
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
                    fake.number().numberBetween(0, 101),
                    fake.number().numberBetween(0, 101),
                    fake.number().numberBetween(0, 1000),
                    fake.number().numberBetween(0, 1000),
                    Utils.armesPrincipals[fake.number().numberBetween(0, principals)],
                    Utils.armasSecundarias[fake.number().numberBetween(0, secundaries)],
                    Utils.prestigis[fake.number().numberBetween(0, prestigis)],
                    Utils.armesCQC[fake.number().numberBetween(0, armesCQC)],
                    fake.bool().bool(),
                    Utils.localDateToSQLDate(fake.date().birthday()));

        } else if (tipus == Pilot.class) {

            soldat = new Pilot(
                    fake.aviation().airport(),
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
        }
        return soldat;
    }

    /**
     * Funcio per generar nous registres
     *
     * @param tipusClase
     * @param elements
     */
    public void generadorRegistres(Class<?> tipusClase, int elements) throws Exception {

        //Obtenir la sessio
        Session sessio = SingleSession.getInstance().getSessio();

        //Obtenir la clase pare
        Class<?> parent = tipusClase.getSuperclass();
        logger.info("La super clase de " + tipusClase + " es " + parent);
        logger.info("Iniciant transaccio");
        //Començar la transaccio
        sessio.beginTransaction();

        logger.info("Generant entitats");
        for (int i = 0; i < elements; i++) {
            //Generar Soldats
            if (parent == Soldat.class) {
                int random = fake.number().numberBetween(0, 2);
                Soldat soldat = soldatFactory(tipusClase);
                Aeronau aeronau = aeronauFactory(Utils.pilotades.get(random));

                if (soldat instanceof Mecanic) {
                    ((Mecanic) soldat).setPilotada((Pilotada) aeronau);
                } else if (soldat instanceof Pilot) {
                    ((Pilot) soldat).setPilotada((Pilotada) aeronau);
                }
                sessio.persist(soldat);
                logger.info("S'ha generat soldat nº : " + i);

            }

            //Generar Aeronaus
            if (parent == Pilotada.class || parent == Autonoma.class) {
                Aeronau aeronau = aeronauFactory(tipusClase);
                if (aeronau instanceof Pilotada) {
                    Soldat soldatPilot = soldatFactory(Pilot.class);
                    List<Missio> missions = missionsFactory(fake.number().numberBetween(0, 3));
                    List<Soldat> mecanic = mecanicsFactory(fake.number().numberBetween(0, 3));
                    addMissionsToAeronau(missions, aeronau);
                    addMecanicsToPilotada(mecanic, (Pilotada) aeronau);
                    addPilotToAeronauPilotada((Pilot) soldatPilot, (Pilotada) aeronau);

                }
                sessio.persist(aeronau);

                logger.info("S'ha generat aeronau nº : " + i);

            }

            //Generar Missions
            if (tipusClase == Missio.class) {
                List<Aeronau> aeronau = aeronausFactory(fake.number().numberBetween(0, 9));
                Missio missio = missioFactory();
                missio.setAeronaus(aeronau);
                sessio.persist(missio);
                logger.info("S'ha generat missio nº : " + i);
            }

        }
        sessio.getTransaction().commit();
        logger.info("S'han guardat els registres");

    }

    public List<Aeronau> aeronausFactory(int elements) {
        List<Aeronau> aeronau = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            int random = fake.number().numberBetween(0, 2);
            aeronau.add(aeronauFactory(Utils.pilotades.get(random)));
        }
        return aeronau;
    }

}
