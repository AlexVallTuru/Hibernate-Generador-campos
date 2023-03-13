/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Carlos
 */
public class Menus {
     private static final Logger logger = LogManager.getLogger(Menus.class);
    private static Scanner in = new Scanner(System.in);

    public static int menuSoldats() {
        
        logger.info("========================\n");
        logger.info("\tSoldats");
        logger.info("=========================\n");
        logger.info("1.Mecanic\n2.Pilot");
        return in.nextInt();

    }

    public static int menuAeronaus() {
        System.out.println("========================");
        System.out.println("Aeronaus\n");
        System.out.println("=========================");
        System.out.println("1.Autonoma\n2.Pilotada");
        return in.nextInt();

    }

    public static int menuSeleccio() {
        System.out.println("========================");
        System.out.println("Entitats");
        System.out.println("=========================\n");
        System.out.println("1.Soldat\n2.Aeronau\n3.Missio");

        return in.nextInt();

    }

    public static int tipusAeronau() {
        System.out.println("========================\n");
        System.out.println("\nTipus Aeronaus Pilotades\n");
        System.out.println("=========================\n");
        System.out.println("1.Combat\n2.Transport");
        return in.nextInt();
    }
}
