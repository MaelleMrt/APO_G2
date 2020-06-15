package princetonPlainsboro;

import java.util.ArrayList;
import java.util.List;

public class Medecin {

    String nom;
    private String prenom;
    private String specialite;
    private List<Patient> patients;
    private String identifiant;
    private String mdp;

    public Medecin(String nom, String prenom,String specialite, String identifiant,String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.mdp=mdp;
        this.identifiant=identifiant;
        this.patients=new ArrayList<Patient>();
    }

    public void ajouterPatient(Patient p){
        this.patients.add(p);
    }
    public String getSpecialite() {
        return specialite;
    }

    public String getIdentifiant(){
        return identifiant;
    }
            
            
    public String toString() {
        return "Dr " + prenom + " " + nom + ", " + specialite;
    }

    public boolean equals(Object o) {
        if (o instanceof Medecin) {
            Medecin p = (Medecin) o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
        } else {
            return false;
        }
    }
    
    
    
//fonctionnalités du médecin
    
    //compléter la fiche patient créée par la cecretaire médicale
    public void completerFicheDeSoin(){
        
    }
    //liste de ses patients uniquement
    public void afficherListePatients(){
        
    }
    
    public void imprimerListePatient(){
        
    }
    
    public void imprimerFicheDeSoin(){ //déjà dans secretaire_med
        
    }
}
