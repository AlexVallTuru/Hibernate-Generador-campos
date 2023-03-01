/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Utils {
    public static java.sql.Date  localDateToSQLDate(Date date){
        java.sql.Date sd = new java.sql.Date(date.getTime());
        
        return sd;
    }
    
}
