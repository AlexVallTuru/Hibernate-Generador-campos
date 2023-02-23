/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

import Interficies.TesteableEntity;
import java.io.Serializable;

/**
 *
 * @author Aitor
 */
public class Transport extends Pilotada implements TesteableEntity, Serializable {
    private Integer aeronauTransportMaxTripulants;
    private Integer aeronauTransportMaxPes;
}
