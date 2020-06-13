/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sixtine
 */
public class Hospital {

    
    

    private final String nom = "PrincetonBoro"; //nom de l'hôpital
    //private java.util.ArrayList<String> listeSpe; // liste des quantites des spécialités/services 
    private List<Service> listeSpe;


    public Hospital(String nom) {
        nom = this.nom;
        //this.listeSpe = new java.util.ArrayList<String>();
        listeSpe = Arrays.asList(Service.values());

    }

    public List<Service> getSpecialite() {
        return listeSpe;
    }

    public void ajouterSpecialité() {

    }

    public void ajouterPatient() {

    }

    public void ajouterMedecin() {

    }
    //vérification bon fonctionnement 
    public void afficherInfos(){
        System.out.println("Nom de l'Hôpital = "+this.nom);
        System.out.println("Liste des spécialités : ");
        for (Service elem : listeSpe){
            System.out.println(elem);
            
        }
        
    }
   
}
