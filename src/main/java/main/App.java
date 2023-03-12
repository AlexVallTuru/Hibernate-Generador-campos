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
import main.ConsultasHql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author Aitor, Carlos
 */
public class App {

    private static SingleSession singleSession = null;
    private static Session sessio = null;
    private static final Logger logger = LogManager.getLogger(App.class);
    private static final LogicaData logic = new LogicaData();

    private static Session session;

    public static void main(String[] args) {

        session = SingleSession.getInstance().getSessio();

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
                    logic.esborra();
                    break;

                case 3:
                    System.out.println("Introdueix la classe que vol llistar:\n4");
                    drawMenuShowClass();
                    Integer finalOptionShowClass = null;
                    Boolean validOption = false;
                    while (!validOption) {
                        finalOptionShowClass = checkOptionShowClass();
                        if (finalOptionShowClass < 1 || finalOptionShowClass > 10) {
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
                            ConsultasHqlAeronau(a, 1, 200);
                            break;
                        case 2:
                            //Opció per mostrar la classe Autonoma
                            ConsultasHqlAutonoma(a, 1, 200);
                            break;
                        case 3:
                            //Opción para mostrar la clase Dron
                            ConsultasHqlDron(a, 1, 200);
                            break;
                        case 4:
                            //Opción para mostrar la clase Pilotada
                            ConsultasHqlPilotada(a, 1, 200);
                            break;
                        case 5:
                            //Opció per mostrar la classe Combat
                            ConsultasHqlCombat(a, 1, 200);
                            break;
                        case 6:
                            //Opció per mostrar la classe Transport
                            ConsultasHqlTransport(a, 1, 200);
                            break;
                        case 7:
                            //Opció per mostrar la classe Soldat
                            ConsultasHqlSoldat(a, 1, 200);
                            break;
                        case 8:
                            //Opció per mostrar la classe Mecanic
                            ConsultasHqlMecanic(a, 1, 200);
                            break;
                        case 9:
                            //Opció per mostrar la classe Pilot
                            ConsultasHqlPilot(a, 1, 200);
                            break;
                        case 10:
                            //Opció per mostrar la classe Missio
                            ConsultasHqlMissio(a, 1, 200);
                            
                    }
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

}
