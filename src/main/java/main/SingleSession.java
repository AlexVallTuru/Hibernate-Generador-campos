/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author carlo
 */
public class SingleSession {
    private static final Logger logger = LogManager.getLogger(SingleSession.class);
    private static SingleSession session;
    private final SessionFactory sessionFactory;
    private Session ses;

    private SingleSession() {
        Configuration config = new Configuration().configure("hibernateConfig/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
        ses = sessionFactory.openSession();
    }

    private SingleSession(String user, String password, String database) {
        logger.info("Connectant com a usuari: "+user);
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
            logger.info("Conexió establerta");

        }
        return session;
    }

    public static SingleSession getInstance(String user, String password, String database) {
        if (session == null) {
            session = new SingleSession(user, password, database);
            logger.info("Conexio establerta com a "+user+" a la base de dades: "+database);

        }
        return session;
    }

    public Session getSessio() {

        if (ses.isOpen()) {
            logger.info("Generant una nova sessió");
            ses.close();
            logger.info("Sessió tancada");
            ses = sessionFactory.openSession();
            logger.info("Nova sessió generada");

        }

        return ses;

    }

    public void closeConnection() {
        sessionFactory.close();
        ses.close();
        logger.info("Sessio finalitzada");
    }

}
