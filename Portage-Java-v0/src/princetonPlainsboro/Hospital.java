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
    private List<Specialite> listeSpe;
    private List<Service> listeSe;
    private List<Patient> patientsH;
    private List<Medecin> medecinsH;
    private List<SecretaireMedicale> secretairesM;
    private SecretaireAdministrative sA;
    
    
    public Hospital(String nom) {
        nom = this.nom;
        this.listeSe = Arrays.asList(Service.values());
        this.listeSpe = new ArrayList<Specialite>();
        this.medecinsH= new ArrayList<Medecin>();
        this.patientsH= new ArrayList<Patient>();
        this.secretairesM=new ArrayList<SecretaireMedicale>();
    }

    public List<Specialite> getSpecialite() {
        return listeSpe;
    }
    
    public SecretaireAdministrative getSA(){
        return this.sA;
    }

    public void ajouterSpecialite(Specialite s) {
        this.listeSpe.add(s);
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
    
    public List<SecretaireMedicale> getListSM(){
        return this.secretairesM;
    }
    
    public String getNom(){
        return this.nom;
    }
    //vérification bon fonctionnement 
    public void afficherInfos(){
        System.out.println("Nom de l'Hopital = "+this.nom);
        System.out.println("Liste des specialites : ");
        for (Specialite elem : this.listeSpe){
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
