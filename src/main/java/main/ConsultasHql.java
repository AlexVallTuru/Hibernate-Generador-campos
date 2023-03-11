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

    public ConsultasHql() {
        SingleSession singl = SingleSession.getInstance("root", "123456", "Aeroport");
        Session a = singl.getSessio();
        TypedQuery<Missio> hqlQuery1 = a.createQuery("FROM Missio", Missio.class);
        List<Missio> missions = hqlQuery1.getResultList();
        for(Missio m:missions){
            System.err.println(m.toString());
        }
    }


}
