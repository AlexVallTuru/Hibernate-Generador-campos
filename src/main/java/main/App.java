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
                    // Define el rango de IDs que deseas buscar
                    int idInicio = 1;
                    int idFin = 205;
                    int limiteRegistros = 1000;
                    int count = 0;
                    switch (finalOptionShowClass) {
                        case 1:
                            //Opció per mostrar la classe Aeronau
                            // Crea un ArrayList para almacenar los objetos de Autonoma
                            List<Aeronau> aeronauss = new ArrayList<>();
                            // Itera a través de todos los objetos de Aeronau, y agrega solo aquellos dentro del rango especificado que sean instancias de Autonoma
                            for (int i = 1; i <= limiteRegistros; i++) {
                                Aeronau aeronau = a.get(Aeronau.class, i);
                                if ((aeronau instanceof Pilotada || aeronau instanceof Autonoma) && aeronau.getAeronauMatricula() >= idInicio && aeronau.getAeronauMatricula() <= idFin) {
                                    aeronauss.add(aeronau);

                                }
                            }
                            // Utiliza los objetos de Autonoma que se encuentran dentro del rango especificado
                            for (Aeronau aeronaus : aeronauss) {
                                count++;
                                System.out.println("\n#-----------------------AERONAU-nº" + count + "-------------------------#\n"
                                        + aeronaus.toString());
                            }
                            System.out.println("\n#-------------------------------------------------------------------------#\n");
                            break;
                        case 2:
                            //Opció per mostrar la classe Autonoma
                            // Crea un ArrayList para almacenar los objetos de Autonoma
                            List<Autonoma> autonomas = new ArrayList<>();
                            // Itera a través de todos los objetos de Aeronau, y agrega solo aquellos dentro del rango especificado que sean instancias de Autonoma
                            for (int i = 1; i <= limiteRegistros; i++) {
                                Aeronau aeronau = a.get(Aeronau.class, i);
                                if (aeronau instanceof Autonoma && aeronau.getAeronauMatricula() >= idInicio && aeronau.getAeronauMatricula() <= idFin) {
                                    autonomas.add((Autonoma) aeronau);
                                }
                            }
                            // Utiliza los objetos de Autonoma que se encuentran dentro del rango especificado
                            for (Autonoma autonoma : autonomas) {
                                count++;
                                System.out.println("\n#-----------------------AUTONOMA-nº" + count + "-------------------------#\n"
                                        + autonoma.toString());
                            }
                            System.out.println("\n#-------------------------------------------------------------------------#\n");
                            break;
                        case 3:
                            //Opción para mostrar la clase Dron
                            List<Dron> drones = new ArrayList<>();
                            // Itera a través de todos los objetos de Aeronau, y agrega solo aquellos dentro del rango especificado que sean instancias de Dron
                            for (int i = 1; i <= limiteRegistros; i++) {
                                Aeronau aeronau = a.get(Aeronau.class, i);
                                if (aeronau instanceof Dron && aeronau.getAeronauMatricula() >= idInicio && aeronau.getAeronauMatricula() <= idFin) {
                                    drones.add((Dron) aeronau);
                                }
                            }
                            // Utiliza los objetos de Dron que se encuentran dentro del rango especificado
                            for (Dron dron : drones) {
                                count++;
                                System.out.println("\n#-----------------------DRON-nº" + count + "-------------------------#\n"
                                        + dron.toString());
                            }
                            System.out.println("\n#-------------------------------------------------------------------------#\n");
                            break;
                        case 4:
                            //Opción para mostrar la clase Pilotada
                            List<Pilotada> pilotadas = new ArrayList<>();
                            // Itera a través de todos los objetos de Aeronau, y agrega solo aquellos dentro del rango especificado que sean instancias de Pilotada
                            for (int i = 1; i <= limiteRegistros; i++) {
                                Aeronau aeronau = a.get(Aeronau.class, i);
                                if (aeronau instanceof Pilotada && aeronau.getAeronauMatricula() >= idInicio && aeronau.getAeronauMatricula() <= idFin) {
                                    pilotadas.add((Pilotada) aeronau);
                                }
                            }
                            for (Pilotada pilotada : pilotadas) {
                                count++;
                                System.out.println("\n#-----------------------PILOTADA-nº" + count + "-------------------------#\n");
                                if (pilotada instanceof Transport) {
                                    System.out.println(((Transport) pilotada).toString());
                                } else if (pilotada instanceof Combat) {
                                    System.out.println(((Combat) pilotada).toString());
                                }
                            }
                            System.out.println("\n#-------------------------------------------------------------------------#\n");
                            break;
                        case 5:
                            //Opció per mostrar la classe Combat
                            List<Combat> Combats = new ArrayList<>();
                            for (int i = 1; i <= limiteRegistros; i++) {
                                Aeronau aeronau = a.get(Aeronau.class, i);
                                if (aeronau instanceof Combat && aeronau.getAeronauMatricula() >= idInicio && aeronau.getAeronauMatricula() <= idFin) {
                                    Combats.add((Combat) aeronau);
                                }
                            }
                            for (Combat Combat : Combats) {
                                count++;
                                System.out.println("\n#-----------------------COMBAT-nº" + count + "-------------------------#\n"
                                        + Combat.toString());
                            }
                            System.out.println("\n#-------------------------------------------------------------------------#\n");
                            break;
                        case 6:
                            //Opció per mostrar la classe Transport
                            // Crea un ArrayList para almacenar los objetos de Transport
                            List<Transport> transportes = new ArrayList<>();
                            // Itera a través de todos los objetos de Aeronau, y agrega solo aquellos dentro del rango especificado que sean instancias de Transport
                            for (int i = 1; i <= limiteRegistros; i++) {
                                Aeronau aeronau = a.get(Aeronau.class, i);
                                if (aeronau instanceof Transport && aeronau.getAeronauMatricula() >= idInicio && aeronau.getAeronauMatricula() <= idFin) {
                                    transportes.add((Transport) aeronau);
                                }
                            }
                            // Utiliza los objetos de Transport que se encuentran dentro del rango especificado
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
                            List<Mecanic> mecanics = new ArrayList<>();
                            // Itera a través de todos los objetos de Aeronau, y agrega solo aquellos dentro del rango especificado que sean instancias de Transport
                            for (int i = 1; i <= limiteRegistros; i++) {
                                Soldat soldat = a.get(Soldat.class, i);
                                if (soldat instanceof Mecanic && soldat.getIdUsuario() >= idInicio && soldat.getIdUsuario() <= idFin) {
                                    mecanics.add((Mecanic) soldat);
                                }
                            }
                            // Utiliza los objetos de Transport que se encuentran dentro del rango especificado
                            for (Mecanic mecanicss : mecanics) {
                                count++;
                                System.out.println("\n#-----------------------MECANIC-nº" + count + "-------------------------#\n"
                                        + mecanicss.toString());
                            }
                            System.out.println("\n#-------------------------------------------------------------------------#\n");
                            break;
                        case 9:
                            //Opció per mostrar la classe Pilot
                            List<Pilot> pilots = new ArrayList<>();
                            // Itera a través de todos los objetos de Aeronau, y agrega solo aquellos dentro del rango especificado que sean instancias de Transport
                            for (int i = 1; i <= limiteRegistros; i++) {
                                Soldat soldat = a.get(Soldat.class, i);
                                if (soldat instanceof Pilot && soldat.getIdUsuario() >= idInicio && soldat.getIdUsuario() <= idFin) {
                                    pilots.add((Pilot) soldat);
                                }
                            }
                            // Utiliza los objetos de Transport que se encuentran dentro del rango especificado
                            for (Pilot pilotss : pilots) {
                                count++;
                                System.out.println("\n#-----------------------MECANIC-nº" + count + "-------------------------#\n"
                                        + pilotss.toString());
                            }
                            System.out.println("\n#-------------------------------------------------------------------------#\n");
                            break;
                        case 10:
                            //Opció per mostrar la classe Missio
                            a = singl.getSessio();
                            TypedQuery<Missio> hqlQuery1 = a.createQuery("FROM Missio", Missio.class);
                            List<Missio> missions = hqlQuery1.getResultList();
                            for (Missio m : missions) {
                                System.err.println(m.toString());
                                break;
                            }
                            break;
                    }
                //Sortida del programa
                case 5:
                    System.out.println("Fins aviat!");
                    singl.closeConnection();
                    exit = true;
            }
        } while (!exit);
    }

    private static <T extends Aeronau> List<T> getAeronauByTypeAndRange(Class<T> clazz, int idInicio, int idFin, int limiteRegistros, Session a) {
        List<T> aeronaus = new ArrayList<>();
        for (int i = 1; i <= limiteRegistros; i++) {
            Aeronau aeronau = a.get(Aeronau.class, i);
            if (clazz.isInstance(aeronau) && aeronau.getAeronauMatricula() >= idInicio && aeronau.getAeronauMatricula() <= idFin) {
                aeronaus.add(clazz.cast(aeronau));
            }
        }
        return aeronaus;
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
