package main;

import Logica.LogicaData;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author Aitor
 */
public class App {

    private static SingleSession singleSession = null;
    private static Session sessio = null;
    private static final Logger logger = LogManager.getLogger(App.class);
    private static final LogicaData logic = new LogicaData();

    public static void main(String[] args) {

        //Inici de sessio
        logger.info("Inici de sessió...");
        Boolean valid = false; //Boolean per verificar inici de sessio
        while (!valid) {
            try {
                login();
                valid = true;
                logger.info("Credencials correctes");
            } catch (Exception e) {
                logger.error("Credencials incorrectes");
                System.out.println("Credencials incorrectes. Si us plau, introdueix-les de nou.");
            }
        }

        //Menu principal
        Boolean exit = false;
        do {
            logger.info("Mostrant el menu principal");
            drawMenu();
            //Comprobar que l'opció introduida per l'usuari es correcte
            Integer finalOption = checkOption();

            //Crida a funcions
            switch (finalOption) {
                case 1:
                    logic.generaClasse();
                    break;

                case 2:
                    System.out.println("Not implemented.");
                    break;

                case 3:
                    logic.esborra();
                    break;
                    
                case 4:
                    System.out.println("Not implemented.");
                    break;

                //Sortida del programa
                case 5:
                    System.out.println("Fins aviat!");
                    singleSession.closeConnection();
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
        System.out.println("""
                   1. <Agregar elementos a una clase>
                   2. <Eliminar elementos de una clase>
                   3. <Modificar elementos de una clase>
                   4. <Listar elementos de una clase>
                   5. <Salir>

                   Introduce un número para elegir una opción.""");

    }

    /**
     * Login i seleccio de base de dades
     *
     * @author Carlos
     */
    public static void login() {
        Scanner in = new Scanner(System.in);

        //Nom usuari DB
        System.out.print("Usuari: ");
        String usuari = in.nextLine();

        //Password DB
        System.out.print("Contrassenya: ");
        String password = in.nextLine();

        //Nom base de dades
        System.out.print("Nom de la DDBB: ");
        String dbName = in.nextLine();

        //Inici de sessio
        logger.info("Iniciant sessió amb usuari: " + usuari + " a la base de dades " + dbName);
        singleSession = SingleSession.getInstance(usuari, password, dbName);
        
        
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
                logger.error("Opció no valida");
                System.out.println("L'opció introduida no es vàlida o no es un nombre, introdueix-ho de nou.");
                drawMenu();
            }
        }
        return finalOption;
    }

}
