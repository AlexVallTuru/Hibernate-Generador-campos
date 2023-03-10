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
import menus.Menus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

/**
 * Clase Logica
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
        int segonaOpcio,terceraOpcio,quantitat,opc;
        
        //Indicar la quantitat d'elements
        System.out.print("Quantitat: ");
        quantitat = in.nextInt();
        logger.info("Es generaran "+quantitat+" entitats");
        try {
            
            opc = Menus.menuSeleccio();
            logger.info("Opcio seleccionada: "+opc);
            //Generar Soldats
            if (opc == 1) {
                
                logger.info("Generant Soldats");
                segonaOpcio = Menus.menuSoldats();
                //Generar Mecanic
                if (segonaOpcio == 1) {
                    logger.info("Generant Mecanics");
                    generador.generadorRegistres(Mecanic.class,quantitat);
                //Generar Pilot
                } else if (segonaOpcio == 2) {
                    logger.info("Generant Pilots");
                    generador.generadorRegistres(Pilot.class,quantitat);
                }

            }

            //Generar Aeronaus
            if (opc == 2) {
                
                logger.info("Generant Aeronaus");
                segonaOpcio = Menus.menuAeronaus();
                //Generar Aeronau Autonoma
                if (segonaOpcio == 1) {
                  logger.info("Generant Drons");
                  generador.generadorRegistres(Dron.class,quantitat);
                
                //Generar Aeronau Pilotada
                } else if (segonaOpcio == 2) {
                    terceraOpcio = Menus.tipusAeronau();
                    
                    //Generar Aeronau de Combat
                    if (terceraOpcio == 1) {
                        logger.info("Generant Aeronaus de Combat");
                        generador.generadorRegistres(Combat.class, quantitat);
                        
                    //Generar Aeronau de Transport
                    }else if(terceraOpcio == 2){
                        logger.info("Generant Aeronaus de Transport");
                        generador.generadorRegistres(Transport.class, quantitat);
                    }
                }
            }
            
            //Generar Missions
            if (opc== 3) {
                logger.info("Generant Missions");
                generador.generadorRegistres(Missio.class, quantitat);
            }
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Llistar elements
     * @return 
     */
    @Override
    public String llistar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * Esborrar elements
     */
    @Override
    public void esborra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
