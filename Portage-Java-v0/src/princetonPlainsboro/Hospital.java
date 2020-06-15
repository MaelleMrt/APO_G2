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
    private List<Patient> patientsH;
    private List<Medecin> medecinsH;
    private List<SecretaireMedicale> secretairesM;
    
    
    public Hospital(String nom) {
        nom = this.nom;
        this.listeSpe = Arrays.asList(Service.values());
        this.medecinsH= new ArrayList<Medecin>();
        this.patientsH= new ArrayList<Patient>();
        this.secretairesM=new ArrayList<SecretaireMedicale>();
    }

    public List<Service> getSpecialite() {
        return listeSpe;
    }

    public void ajouterSpecialite(Specialite s) {

    }

    public void ajouterPatient(Patient p) {
        this.patientsH.add(p);
    }
    
    public void ajouterSecretaireM(SecretaireMedicale sm){
        this.secretairesM.add(sm);
    }

    public void ajouterMedecin(Medecin m) {
        this.medecinsH.add(m);
    }
    
    public List<Medecin> getListMedecin(){
        return this.medecinsH;
    }
    
    public List<Patient> getListPatient(){
        return this.patientsH;
    }
    
    public String getNom(){
        return this.nom;
    }
    //vérification bon fonctionnement 
    public void afficherInfos(){
        System.out.println("Nom de l'Hopital = "+this.nom);
        System.out.println("Liste des specialites : ");
        for (Service elem : this.listeSpe){
            System.out.println(elem);
            
        }
        System.out.println("Medecins : ");
        for(Medecin m:this.medecinsH){
            System.out.println(m);
        }
        System.out.println("Patients: ");
        for(Patient p:this.patientsH){
            System.out.println("Monsieur/Madame " +p);
        }
        
        
    }
   
}
