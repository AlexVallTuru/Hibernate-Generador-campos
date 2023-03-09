package main;

import entitats.Aeronau;
import entitats.Combat;
import entitats.Pilot;
import entitats.Pilotada;
import entitats.Transport;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private static Session session;

    public static void main(String[] args) {
        ClassFactory cf = new ClassFactory();

        session = SingleSession.getInstance().getSessio();

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
                    switch (finalOptionShowClass) {
                        case 1:
                            //Opció per mostrar la classe Aeronau
                            break;
                        case 2:
                            //Opció per mostrar la classe Autonoma
                            break;
                        case 3:
                            //Opció per mostrar la classe Dron
                            break;
                        case 4:
                            //Opció per mostrar la classe Pilotada
                            break;
                        case 5:
                            //Opció per mostrar la classe Combat
                            break;
                        case 6:
                            //Opció per mostrar la classe Transport
                            // Crea un ArrayList para almacenar los objetos de Transport
                            List<Transport> transportes = new ArrayList<>();

                            // Define el rango de IDs que deseas buscar
                            int idInicio = 1;
                            int idFin = 130;
                            int limiteRegistros = 200;
                            // Itera a través de todos los objetos de Aeronau, y agrega solo aquellos dentro del rango especificado que sean instancias de Transport
                            for (int i = 1; i <= limiteRegistros; i++) {
                                Aeronau aeronau = a.get(Aeronau.class, i);
                                if (aeronau instanceof Transport && aeronau.getAeronauMatricula() >= idInicio && aeronau.getAeronauMatricula() <= idFin) {
                                    transportes.add((Transport) aeronau);
                                }
                            }
                            // Utiliza los objetos de Transport que se encuentran dentro del rango especificado
                            int count = 0;
                            for (Transport transporte : transportes) {
                                count++;
                                System.out.println("\n#-----------------------TRANSPORT-nº" + count + "-------------------------#\n"
                                        + transporte.toString());
                            }
                            System.out.println("\n#-------------------------------------------------------------------------#\n");
                            /**
                             * Aeronau aeronau = null; aeronau =
                             * a.get(Transport.class, 1);
                             * System.out.println(aeronau.toString());*
                             */
                            break;
                        case 7:
                            //Opció per mostrar la classe Soldat
                            break;
                        case 8:
                            //Opció per mostrar la classe Mecanic
                            break;
                        case 9:
                            //Opció per mostrar la classe Pilot
                            break;
                        case 10:
                            //Opció per mostrar la classe Missio
                            break;
                    }
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
    }

    public static Integer checkOptionShowClass() {
        Scanner in = new Scanner(System.in);
        Boolean valid = false;
        Integer finalOption = null;
        while (!valid) {
            try {
                String inOption = in.next();
                finalOption = Integer.parseInt(inOption);
                if (finalOption < 1 || finalOption > 10) {
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
