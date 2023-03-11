/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entitats.Missio;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import main.SingleSession;

/**
 *
 * @author Alex
 */
public class ConsultasHql {

    private static Session session;
    private SingleSession singl;

    public static void ConsultasHql(Session a) {
        TypedQuery<Missio> hqlQuery1 = a.createQuery("SELECT m FROM Missio m JOIN FETCH m.aeronau", Missio.class);
        List<Missio> missions = hqlQuery1.getResultList();
        for (Missio m : missions) {
            System.out.println(m.toString());
        }
    }

}
