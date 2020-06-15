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
    private Specialite specialite;
    
    public SecretaireMedicale(String identifiant,String mdp,Specialite specialite){
        this.identifiant=identifiant;
        this.mdp=mdp;
        this.specialite=specialite;
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
    public void ajouterFicheDeSoins(Patient patient,String IdentifiantMedecin,String specialite, Date date){     
        FicheDeSoins fds =new FicheDeSoins(patient,IdentifiantMedecin,specialite,date);
        patient.ajouterFicheDeSoins(fds);
        fiches.add(fds);
        
}
