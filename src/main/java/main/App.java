package main;

import entitats.Combat;
import entitats.Pilot;
import entitats.Transport;
import java.sql.Date;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author Aitor
 */
/*public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        ClassFactory cf = new ClassFactory();
        
        logger.info("\nInicio de sesion...");


        SingleSession singl = SingleSession.getInstance();
        Session a = singl.getSessio();
        
/*
        a.getTransaction().begin();
        Pilot q = new Pilot("root",
        null,
        5, 100,
        50,
        2,
        2,
        "AK47",
        "Galil",
        "Sargento",
        "chuchillo",
        Arrays.asList("ataque aereo"),
        Boolean.FALSE,
        convertDate("1993-02-01"));
        
        Transport l = (Transport) cf.aeronauFactory(Transport.class);
        //Combat x = (Combat) cf.aeronauFactory(Combat.class);
        

        

    
        a.persist(l);
        
        a.getTransaction().commit();

        // recuperem tots els pilots
        List<Pilot> llista = a.createQuery("from Pilot", Pilot.class).list();
        System.out.println("EL PILOTO TIENE UNA HUMILDE INFORMACION DE" + llista.toString());
        singl.closeConnection();

        singl.closeConnection();

    }

    public static Date convertDate(String dat) {
        return Date.valueOf(dat);

    }

}*/
