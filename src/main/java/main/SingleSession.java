/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author carlo
 */
public class SingleSession {

    private static SingleSession session;
    private final SessionFactory sessionFactory;
    private Session ses;

    private SingleSession() {
        Configuration config = new Configuration().configure("hibernateConfig/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
        ses = sessionFactory.openSession();
    }

    private SingleSession(String user, String password, String database) {
        Configuration config = new Configuration().configure("hibernateConfig/hibernate.cfg.xml");

        Properties properties = config.getProperties();

        properties.setProperty("hibernate.connection.username", user);
        properties.setProperty("hibernate.connection.password", password);
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/" + database + "?createDatabaseIfNotExist=true");
        sessionFactory = config.buildSessionFactory();
        ses = sessionFactory.openSession();
    }

    public static SingleSession getInstance() {
        if (session == null) {
            session = new SingleSession();
            System.out.println("Conexion establecida");

        }
        return session;
    }

    public static SingleSession getInstance(String user, String password, String database) {
        if (session == null) {
            session = new SingleSession(user, password, database);
            System.out.println("Conexion establecida");

        }
        return session;
    }

    public Session getSessio() {

        if (ses.isOpen()) {
            ses.close();
            ses = sessionFactory.openSession();

        }

        return ses;

    }

    public void closeConnection() {
        sessionFactory.close();
        ses.close();
    }

}
