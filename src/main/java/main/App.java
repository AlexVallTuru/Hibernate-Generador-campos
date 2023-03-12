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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import Logica.LogicaData;
import java.util.Scanner;
import static main.ConsultasHql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author Aitor, Carlos, Alex
 */
public class App {

    private static SingleSession singleSession = null;
    private static Session session = null;
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
            //session = singleSession.getSessio();
            //Comprobar que l'opció introduida per l'usuari es correcte
            Integer finalOption = checkOption();

            //Crida a funcions
            switch (finalOption) {
                case 1:
                    logic.generaClasse();
                    break;

                case 2:
                    logic.esborra();
                    break;

                case 3:
                    Boolean exitList = false;
                    do {
                        System.out.println("Introdueix la classe que vol llistar:\n");
                        drawMenuShowClass();
                        Integer finalOptionShowClass = null;
                        Boolean validOption = false;
                        while (!validOption) {
                            finalOptionShowClass = checkOptionShowClass();
                            if (finalOptionShowClass < 1 || finalOptionShowClass > 11) {
                                System.out.println("L'opcio introduida no es valida, introdueix-ho de nou.");
                                drawMenuShowClass();
                            } else {
                                validOption = true;
                            }
                        }
                        // Define el rango de IDs que deseas buscar
                        int idInicio = 1;
                        int idFin = 205;
                        int limiteRegistros = 1000;
                        int count = 0;

                        switch (finalOptionShowClass) {
                            case 1:
                                //Opció per mostrar la classe Aeronau
                                ConsultasHqlAeronau(session, idInicio, idFin);
                                break;
                            case 2:
                                //Opció per mostrar la classe Autonoma
                                ConsultasHqlAutonoma(session, idInicio, idFin);
                                break;
                            case 3:
                                //Opción para mostrar la clase Dron
                                ConsultasHqlDron(session, idInicio, idFin);
                                break;
                            case 4:
                                //Opción para mostrar la clase Pilotada
                                ConsultasHqlPilotada(session, idInicio, idFin);
                                break;
                            case 5:
                                //Opció per mostrar la classe Combat
                                ConsultasHqlCombat(session, idInicio, idFin);
                                break;
                            case 6:
                                //Opció per mostrar la classe Transport
                                ConsultasHqlTransport(session, idInicio, idFin);
                                break;
                            case 7:
                                //Opció per mostrar la classe Soldat
                                ConsultasHqlSoldat(session, idInicio, idFin);
                                break;
                            case 8:
                                //Opció per mostrar la classe Mecanic
                                ConsultasHqlMecanic(session, idInicio, idFin);
                                break;
                            case 9:
                                //Opció per mostrar la classe Pilot
                                ConsultasHqlPilot(session, idInicio, idFin);
                                break;
                            case 10:
                                //Opció per mostrar la classe Missio
                                ConsultasHqlMissio(session, idInicio, idFin);
                                break;
                            case 11:
                                //Menu principal                 
                                exitList = true;
                                break;
                        }
                    } while (!exitList);
                    break;
                //Sortida del programa
                case 4:
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
                   1. <Crear entitats>
                   2. <Eliminar entitats>
                   3. <Listar entitats>
                   4. <Sortir>

                   Introdueix un nombre per seleccionar una de les opcions.""");

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
        session = singleSession.getSessio();
    }

    /**
     * Comprova que l'opcio introduïda per l'usuari es valida i la retorna al
     * programa.
     *
     * @return finalOption
     * @author Aitor
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

    private static void drawMenuShowClass() {
        System.out.println("1. <Aeronau>");
        System.out.println("2. <Autonoma>");
        System.out.println("3. <Dron>");
        System.out.println("4. <Pilotada>");
        System.out.println("5. <Combat>");
        System.out.println("6. <Transport>");
        System.out.println("7. <Soldat>");
        System.out.println("8. <Mecanic>");
        System.out.println("9. <Pilot>");
        System.out.println("10. <Missio>");
        System.out.println("11. <Tornar al menu principal>");
    }

    public static Integer checkOptionShowClass() {
        Scanner in = new Scanner(System.in);
        Boolean valid = false;
        Integer finalOption = null;
        while (!valid) {
            try {
                String inOption = in.next();
                finalOption = Integer.parseInt(inOption);
                if (finalOption < 1 || finalOption > 11) {
                    throw new NumberFormatException();
                }
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("L'opcio introduida no es valida o no es un nombre, introdueix-ho de nou.");
            }
        }
        return finalOption;
    }
}
