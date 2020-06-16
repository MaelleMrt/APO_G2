/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 *
 * @author sixtine
 */
public enum Service {

    MEDECINE("Medecine"),
    CHIRURGIE("Chirurgie"),
    GYNECOLOGIE_OBSTERIQUE("gynecologie Obsterique");

    private String service;

    //Constructeur
    Service(String service) {
        this.service = service;
    }

    //obtenir le service
    public String getService() {
        return service;

    }

}
