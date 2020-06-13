/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 *
 * @author Maelle
 */
public class SecretaireMedicale {
    private String identifiant;
    private String mdp;
    private String specialite;
    
    public SecretaireMedicale(String identifiant,String mdp,String specialite){
        this.identifiant=identifiant;
        this.mdp=mdp;
        this.specialite=specialite;
    }
    
}
