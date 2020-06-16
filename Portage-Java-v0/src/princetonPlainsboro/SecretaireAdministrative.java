/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Maelle
 */
public class SecretaireAdministrative {
    private String identifiant;
    private String mdp;
    private Hospital hospital;
    
    public SecretaireAdministrative(String identifiant,String mdp,Hospital hospital){
        this.identifiant = identifiant;
        this.mdp = mdp;
        this.hospital=hospital;
    }
    public void ajouterPatient(Patient p){
        this.hospital.ajouterPatient(p);
    }
    public void ajouterMedecin(Medecin m){
        this.hospital.ajouterMedecin(m);
    }
    
    public String getMdp(){
        return this.mdp;
    }
    
    public String getIdentifiant(){
        return this.identifiant;
    }
    public Hospital getHospital(){
        return this.hospital;
    }
    
    public List<FicheDeSoins> getFiches(){
        List<FicheDeSoins> fiche = new ArrayList<FicheDeSoins>(); 
        for ( Patient p : this.getHospital().getListPatient()){
            for(FicheDeSoins fs : p.getDossierMed()){
                fs.afficher();
                fiche.add(fs);
            }
        }
        return fiche;
    }
}
