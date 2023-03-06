package main;

import entitats.Combat;
import entitats.Pilot;
import entitats.Transport;
import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author Aitor
 */
public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        ClassFactory cf = new ClassFactory();

        //Inici de sessio
        logger.info("\nInicio de sesion...");
        SingleSession singl = null;
        Session a = null;
        Boolean valid = false; //Boolean per verificar inici de sessio
        while (!valid) {
            try {
                singl = SingleSession.getInstance();
                a = singl.getSessio();
                valid = true;
                logger.info("\nCredenciales correctas");
            } catch (Exception e) {
                logger.error("\nCredenciales incorrectas");
                System.out.println("Credenciales incorrectas, por favor introducelas de nuevo");
            }
        }

        //Menu principal
        Boolean exit = false;
        do {
            logger.info("\nMostrando menu principal");
            drawMenu();
            //Comprobar que l'opció introduida per l'usuari es correcte
            Integer finalOption = checkOption();

            //Crida a funcions
            switch (finalOption) {
                case 1:
                    System.out.println("Not implemented.");
                    break;

                case 2:
                    System.out.println("Not implemented.");
                    break;

                case 3:
                    System.out.println("Not implemented.");
                    break;
                    
                case 4:
                    System.out.println("Not implemented.");
                    break;
                    
                //Sortida del programa
                case 5:
                    System.out.println("Fins aviat!");
                    singl.closeConnection();
                    exit = true;
            }
        } while (!exit);
    }

    /**
     * Mostra una "interficie" per les opcions disponibles
     *
     * @author Aitor
     */
    private static void drawMenu() {
        //ASCII art per el menu
        System.out.println("\n_ __ ___   ___ _ __  _   _ \r\n| '_ ` _ \\ / _ \\ '_ \\| | | |\r\n| | | | | |  __/ | | | |_| |\r\n|_| |_| |_|\\___|_| |_|\\__,_|\r\n");
        System.out.println("1. <Afegir elements a una classe>");
        System.out.println("2. <Eliminar elements d'una classe>");
        System.out.println("3. <Modificar elements d'una classe>");
        System.out.println("4. <Llistar elements d'una classe>");
        System.out.println("5. <Sortir>");
        System.out.println("\n Introdueix un numero per escogir una opció");
    }

    /**
     * Comprova que l'opcio introduïda per l'usuari es valida i la retorna al
     * programa.
     *
     * @return finalOption
     */
    public static Integer checkOption() {
        Scanner in = new Scanner(System.in);
        Boolean valid = false;
        Integer finalOption = null;
        while (!valid) {
            try {
                String inOption = in.next();
                finalOption = Integer.parseInt(inOption);
                if (finalOption < 1 || finalOption > 5) {
                    throw new NumberFormatException();
                }
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("L'opcio introduida no es valida o no es un nombre, introdueix-ho de nou.");
            }
        }
        return finalOption;
    }

    public static Date convertDate(String dat) {
        return Date.valueOf(dat);

    }

}
