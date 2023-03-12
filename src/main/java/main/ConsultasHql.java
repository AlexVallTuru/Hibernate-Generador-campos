/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entitats.Aeronau;
import entitats.Autonoma;
import entitats.Combat;
import entitats.Dron;
import entitats.Mecanic;
import entitats.Missio;
import entitats.Pilot;
import entitats.Pilotada;
import entitats.Soldat;
import entitats.Transport;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Alex
 */
public class ConsultasHql {

    public static void ConsultasHqlMissio(Session a, int idInicial, int idFinal) {
//      TypedQuery<Missio> hqlQueryMissio = a.createQuery("SELECT m FROM Missio m JOIN FETCH m.aeronau WHERE m.codiMissio BETWEEN :idInicial AND :idFinal", Missio.class);
        TypedQuery<Missio> hqlQueryMissio = a.createQuery("SELECT m FROM Missio m WHERE m.codiMissio BETWEEN :idInicial AND :idFinal", Missio.class);
        hqlQueryMissio.setParameter("idInicial", idInicial);
        hqlQueryMissio.setParameter("idFinal", idFinal);
        List<Missio> missions = hqlQueryMissio.getResultList();
        int count = 0;
        for (Missio m : missions) {
            count++;
            System.out.println("\n#-----------------------Missio-nº" + count + "-------------------------#\n");
            System.out.println(m.toString());
        }
        System.out.println("\n#-------------------------------------------------------------------------#\n");
    }

    public static void ConsultasHqlAeronau(Session a, int idInicial, int idFinal) {
        TypedQuery<Aeronau> hqlQueryAeronau = a.createQuery("SELECT m FROM Aeronau m WHERE m.aeronauMatricula BETWEEN :idInicial AND :idFinal", Aeronau.class);
        hqlQueryAeronau.setParameter("idInicial", idInicial);
        hqlQueryAeronau.setParameter("idFinal", idFinal);
        List<Aeronau> aeronaus = hqlQueryAeronau.getResultList();
        int count = 0;
        for (Aeronau d : aeronaus) {
            count++;
            System.out.println("\n#-----------------------AERONAU-nº" + count + "-------------------------#\n");
            System.out.println(d.toString());
        }
        System.out.println("\n#-------------------------------------------------------------------------#\n");
    }

    public static void ConsultasHqlDron(Session a, int idInicial, int idFinal) {
        TypedQuery<Dron> hqlQueryDron = a.createQuery("SELECT m FROM Dron m WHERE m.aeronauMatricula BETWEEN :idInicial AND :idFinal", Dron.class);
        hqlQueryDron.setParameter("idInicial", idInicial);
        hqlQueryDron.setParameter("idFinal", idFinal);
        List<Dron> drons = hqlQueryDron.getResultList();
        int count = 0;
        for (Dron d : drons) {
            count++;
            System.out.println("\n#-----------------------DRON-nº" + count + "-------------------------#\n");
            System.out.println(d.toString());
        }
        System.out.println("\n#-------------------------------------------------------------------------#\n");
    }

    public static void ConsultasHqlAutonoma(Session a, int idInicial, int idFinal) {
        TypedQuery<Autonoma> hqlQueryAutonoma = a.createQuery("SELECT m FROM Autonoma m WHERE m.aeronauMatricula BETWEEN :idInicial AND :idFinal", Autonoma.class);
        hqlQueryAutonoma.setParameter("idInicial", idInicial);
        hqlQueryAutonoma.setParameter("idFinal", idFinal);
        List<Autonoma> autonomas = hqlQueryAutonoma.getResultList();
        int count = 0;
        for (Autonoma d : autonomas) {
            count++;
            System.out.println("\n#-----------------------AUTONOMA-nº" + count + "-------------------------#\n");
            System.out.println(d.toString());
        }
        System.out.println("\n#-------------------------------------------------------------------------#\n");
    }

    public static void ConsultasHqlSoldat(Session a, int idInicial, int idFinal) {
        TypedQuery<Soldat> hqlQuerySoldat = a.createQuery("SELECT m FROM Soldat m WHERE m.idUsuario BETWEEN :idInicial AND :idFinal", Soldat.class);
        hqlQuerySoldat.setParameter("idInicial", idInicial);
        hqlQuerySoldat.setParameter("idFinal", idFinal);
        List<Soldat> soldats = hqlQuerySoldat.getResultList();
        int count = 0;
        for (Soldat s : soldats) {
            count++;
            System.out.println("\n#-----------------------SOLDAT-nº" + count + "-------------------------#\n");
            System.out.println(s.toString());
        }
        System.out.println("\n#-------------------------------------------------------------------------#\n");
    }

    public static void ConsultasHqlPilot(Session a, int idInicial, int idFinal) {
        TypedQuery<Pilot> hqlQueryPilot = a.createQuery("SELECT m FROM Pilot m WHERE m.idUsuario BETWEEN :idInicial AND :idFinal", Pilot.class);
        hqlQueryPilot.setParameter("idInicial", idInicial);
        hqlQueryPilot.setParameter("idFinal", idFinal);
        List<Pilot> pilots = hqlQueryPilot.getResultList();
        int count = 0;
        for (Pilot p : pilots) {
            count++;
            System.out.println("\n#-----------------------PILOT-nº" + count + "-------------------------#\n");
            System.out.println(p.toString());
        }
        System.out.println("\n#-------------------------------------------------------------------------#\n");
    }

    public static void ConsultasHqlMecanic(Session a, int idInicial, int idFinal) {
        TypedQuery<Mecanic> hqlQueryMecanic = a.createQuery("SELECT m FROM Mecanic m WHERE m.idUsuario BETWEEN :idInicial AND :idFinal", Mecanic.class);
        hqlQueryMecanic.setParameter("idInicial", idInicial);
        hqlQueryMecanic.setParameter("idFinal", idFinal);
        List<Mecanic> mecanics = hqlQueryMecanic.getResultList();
        int count = 0;
        for (Mecanic d : mecanics) {
            count++;
            System.out.println("\n#-----------------------MECANIC-nº" + count + "-------------------------#\n");
            System.out.println(d.toString());
        }
        System.out.println("\n#-------------------------------------------------------------------------#\n");
    }

    public static void ConsultasHqlPilotada(Session a, int idInicial, int idFinal) {
        TypedQuery<Pilotada> hqlQueryPilotada = a.createQuery("SELECT m FROM Pilotada m WHERE m.aeronauMatricula BETWEEN :idInicial AND :idFinal", Pilotada.class);
        hqlQueryPilotada.setParameter("idInicial", idInicial);
        hqlQueryPilotada.setParameter("idFinal", idFinal);
        List<Pilotada> pilotadas = hqlQueryPilotada.getResultList();
        int count = 0;
        for (Pilotada d : pilotadas) {
            count++;
            System.out.println("\n#-----------------------PILOTADA-nº" + count + "-------------------------#\n");
            System.out.println(d.toString());
        }
        System.out.println("\n#-------------------------------------------------------------------------#\n");
    }

    public static void ConsultasHqlTransport(Session a, int idInicial, int idFinal) {
        TypedQuery<Transport> hqlQueryTransport = a.createQuery("SELECT m FROM Transport m WHERE m.aeronauMatricula BETWEEN :idInicial AND :idFinal", Transport.class);
        hqlQueryTransport.setParameter("idInicial", idInicial);
        hqlQueryTransport.setParameter("idFinal", idFinal);
        List<Transport> aeronaus = hqlQueryTransport.getResultList();
        int count = 0;
        for (Transport d : aeronaus) {
            count++;
            System.out.println("\n#-----------------------TRANSPORT-nº" + count + "-------------------------#\n");
            System.out.println(d.toString());
        }
        System.out.println("\n#-------------------------------------------------------------------------#\n");
    }

    public static void ConsultasHqlCombat(Session a, int idInicial, int idFinal) {
        TypedQuery<Combat> hqlQueryCombat = a.createQuery("SELECT m FROM Combat m WHERE m.aeronauMatricula BETWEEN :idInicial AND :idFinal", Combat.class);
        hqlQueryCombat.setParameter("idInicial", idInicial);
        hqlQueryCombat.setParameter("idFinal", idFinal);
        List<Combat> combats = hqlQueryCombat.getResultList();
        int count = 0;
        for (Combat c : combats) {
            count++;
            System.out.println("\n#-----------------------COMBAT-nº" + count + "-------------------------#\n");
            System.out.println(c.toString());
        }
        System.out.println("\n#-------------------------------------------------------------------------#\n");
    }
}
