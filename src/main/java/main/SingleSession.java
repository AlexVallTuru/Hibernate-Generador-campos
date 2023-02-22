/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Properties;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author carlo
 */
public class SingleSession {

    private static SingleSession session;
    private SessionFactory sessionFactory;
    private Session ses;

    private SingleSession() {
        Configuration config = new Configuration().configure("hibernateConfig/hibernate.cfg.xml");
        Scanner in = new Scanner(System.in);
        System.out.println("Usuario: ");
        String user = in.next();
        System.out.println("Password: ");
        String password = in.next();
        System.out.println("Base de Datos: ");
        String database = in.next();

        Properties properties = config.getProperties();

        properties.setProperty("hibernate.connection.username", user);
        properties.setProperty("hibernate.connection.password", password);
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/" + database + "?createDatabaseIfNotExist=true");

        System.out.println(properties.get("hibernate.connection.url"));

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();

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

    public Session getSessio() {
        return ses;
    }

    public void closeConnection() {
        sessionFactory.close();
        ses.close();
    }

}
