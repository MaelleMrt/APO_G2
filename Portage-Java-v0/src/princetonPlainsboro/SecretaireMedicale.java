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
public class SecretaireMedicale {
    private String identifiant;
    private String mdp;
    private Specialite specialite;
      private List<Patient> listeP;
    
    public SecretaireMedicale(String identifiant,String mdp,Specialite specialite){
        this.identifiant=identifiant;
        this.mdp=mdp;
        this.specialite=specialite;
        this.listeP=new ArrayList<Patient>();
        for(Medecin m:specialite.getListeMed()){
            for(Patient p:m.getListPatient()){
                if(!this.listeP.contains(p)){
                    listeP.add(p);
                }
            }
        }
    }
    public String getIdentifiant(){
        return identifiant;
    }
    
    public String getMdp(){
        return mdp;
    }
    
    public Specialite getSpecialite(){
        return this.specialite;
    }
     
    
    public void afficherPatient(){
        for(Patient p:listeP){
            System.out.println(p.getNom()+p.getPrenom());
        }
    }
}
