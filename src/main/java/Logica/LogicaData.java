/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Carlos
 */
import Interficies.InterfaceLogica;
import entitats.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.App;
import main.ClassFactory;
import main.SingleSession;
import menus.Menus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase Logica
 *
 * @author Carlos
 */
public class LogicaData implements InterfaceLogica {

    private static final Logger logger = LogManager.getLogger(App.class);
    private static ClassFactory generador = new ClassFactory();
    private static Scanner in = new Scanner(System.in);

    /**
     * Generador d'elements
     */
    @Override
    public void generaClasse() {
        //Variables
        int segonaOpcio, terceraOpcio, quantitat, opc;

        //Indicar la quantitat d'elements
        System.out.print("Quantitat: ");
        quantitat = in.nextInt();
        logger.info("Es generaran " + quantitat + " entitats");
        try {

            opc = Menus.menuSeleccio();
            logger.info("Opcio seleccionada: " + opc);
            //Generar Soldats
            if (opc == 1) {

                logger.info("Generant Soldats");
                segonaOpcio = Menus.menuSoldats();
                //Generar Mecanic
                if (segonaOpcio == 1) {
                    logger.info("Generant Mecanics");
                    generador.generadorRegistres(Mecanic.class, quantitat);
                    //Generar Pilot
                } else if (segonaOpcio == 2) {
                    logger.info("Generant Pilots");
                    generador.generadorRegistres(Pilot.class, quantitat);
                }

            }

            //Generar Aeronaus
            if (opc == 2) {

                logger.info("Generant Aeronaus");
                segonaOpcio = Menus.menuAeronaus();
                //Generar Aeronau Autonoma
                if (segonaOpcio == 1) {
                    logger.info("Generant Drons");
                    generador.generadorRegistres(Dron.class, quantitat);

                    //Generar Aeronau Pilotada
                } else if (segonaOpcio == 2) {
                    terceraOpcio = Menus.tipusAeronau();

                    //Generar Aeronau de Combat
                    if (terceraOpcio == 1) {
                        logger.info("Generant Aeronaus de Combat");
                        generador.generadorRegistres(Combat.class, quantitat);

                        //Generar Aeronau de Transport
                    } else if (terceraOpcio == 2) {
                        logger.info("Generant Aeronaus de Transport");
                        generador.generadorRegistres(Transport.class, quantitat);
                    }
                }
            }

            //Generar Missions
            if (opc == 3) {
                logger.info("Generant Missions");
                generador.generadorRegistres(Missio.class, quantitat);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Llistar elements
     *
     * @return
     */
    @Override
    public String llistar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Esborrar elements
     *
     * @author Aitor
     */
    @Override
    public void esborra() {
        Boolean exit = false;
        do {
            logger.info("Mostrando menu de borrado de entidades...");
            drawMenu();
            //Comproba que l'opció introduida per l'usuari es correcte
            Integer finalOption = checkOption();
            Scanner in = new Scanner(System.in);
            //Crida a funcions
            switch (finalOption) {
                //Elimina aeronau
                case 1:
                    deleteEntries(Aeronau.class);
                    break;
                //Elimina soldat
                case 2:
                    deleteEntries(Soldat.class);
                    break;
                //Elimina missio
                case 3:
                    deleteEntries(Missio.class);
                    break;
                //Sortida del menu
                case 4:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    /**
     * Metode que elimina un rang d'entitats indicades d'una classe 
     * proporcionada.
     * 
     * @param classe 
     * @author Aitor
     */
    private static void deleteEntries(Class classe) {
        //Recoleccio de parametres
        boolean exit = false;
        Integer first = null;
        Integer last = null;
        while (!exit) { //Si l'usuari introdueix un valor no numeric, el programa ho detecta
                try { 
                System.out.println("Indica el rang de IDs per eliminar.");
                System.out.print("Inici del rang: ");
                first = in.nextInt();
                do {
                    System.out.print("Final del rang: ");
                    last = in.nextInt();
                    if (last < first) {
                        System.out.println("El final del rang no pot ser menor que"
                                + " l'inici.");
                    }
                } while (last < first);
                exit = true;
            } catch (NumberFormatException e) {
                logger.error("Opció no valida");
                System.out.println("L'opció introduida no es vàlida o no es un nombre, introdueix-ho de nou.");
            }
        }
        
        //Creacio de la sessió
        Session sessio = SingleSession.getInstance().getSessio();
        Transaction transaccio = sessio.beginTransaction();
        
        //Loop per eliminar les entitats demanades
        try {
            for (int i = first; i <= last; i++) {
                Object deletedEntity = sessio.get(classe, i);
                if (deletedEntity != null) {
                    logger.info("Entitat " + i + " eliminada.");
                    System.out.println("\nEntitat eliminada: ");
                    System.out.println(deletedEntity.toString());
                    sessio.delete(deletedEntity);
                } else { //Si l'entitat no existeix, s'informa a l'usuari
                    System.out.println("\nL'entitat " + i + " no existeix.");
                    logger.warn("Entitat no trobada");
                }
            }
            transaccio.commit();
        } catch (Exception e) {
            if (transaccio != null) {
                transaccio.rollback();
            }
            logger.error(e);
        }
    }

    /**
     * Mostra una "interficie" per les opcions disponibles
     *
     * @author Aitor
     */
    private static void drawMenu() {
        System.out.println("""
        1. <Eliminar aeronau>
        2. <Eliminar soldat>
        3. <Eliminar missio>
        4. <Tornar al menú principal>
                           
        Introdueix un nombre per seleccionar una opció.
        """);
                                                            

    }

    /**
     * Comprova que l'opcio introduïda per l'usuari es valida i la retorna al
     * programa.
     *
     * @return finalOption
     * @author Aitor
     */
    private static Integer checkOption() {
        Scanner in = new Scanner(System.in);
        Boolean valid = false;
        Integer finalOption = null;
        while (!valid) {
            try {
                String inOption = in.next();
                finalOption = Integer.parseInt(inOption);
                if (finalOption < 1 || finalOption > 4) {
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
