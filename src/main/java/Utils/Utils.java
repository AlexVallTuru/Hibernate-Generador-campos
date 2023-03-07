/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.Date;
import main.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Carlos
 */
public class Utils {

    public static final String[] armesPrincipals = {
        "ACE 23",
        "AK-12",
        "AN-94",
        "AEK-971",
        "FAMAS",
        "SCAR-H",
        "M16A4",
        "M4A1",
        "CZ-805",
        "QBZ-95-1",
        "SAR-21",
        "AUG A3",
        "L85A2",
        "MTAR-21",
        "G36C",
        "AK-5C",
        "SG553",
        "M27 IAR",
        "RPK-74M",
        "PKP Pecheneg",
        "M240B",
        "M60-E4",
        "U-100 MK5",
        "Type 88 LMG",
        "M249",
        "AWS",
        "L96A1",
        "CS-LR4",
        "JNG-90",
        "SRR-61"};

    public static final String[] armasSecundarias = {
        "M1911",
        "P38",
        "M9",
        "MP443",
        "CZ-75",
        "QSZ-92",
        "93R",
        "G18",
        "M93R",
        "TEC-9",
        "Skorpion",
        "MP7",
        "Uzi",
        "PP-19",
        "P90",
        "CBJ-MS",
        "MPX",
        "M12",
        ".44 Magnum",
        "Desert Eagle"
    };

    public static final String[] armesCQC = {
        "Ganivet de combat",
        "Ganivet de supervivència",
        "Baioneta de ganivet",
        "Pala plegable",
        "Destral tàctica",
        "Pic de muntanya",
        "Martell de demolició",
        "Bat de beisbol",
        "Garrot",
        "Ganivet de fulla ampla"
    };

    public static final String[] prestigis = {
        "Medalla al valor",
        "Medalla al servei meritori",
        "Medalla per ferides rebudes en combat",
        "Medalla per servei en combat",
        "Medalla de la campanya", 
        "Creu de la Victòria",
        "Ordre del mèrit militar",
        "Medalla per lideratge destacat",
        "Medalla per servei distingit",
        "Medalla per servei a l'estranger"};

    private static final Logger logger = LogManager.getLogger(App.class);

    /**
     * Convertir la data a SQLDate
     *
     * @param date
     * @return
     */
    public static java.sql.Date localDateToSQLDate(Date date) {
        logger.info("Conversio " + date + " a SQLDate");
        java.sql.Date sd = new java.sql.Date(date.getTime());
        logger.info("SQLDate: " + sd);
        return sd;
    }

}
