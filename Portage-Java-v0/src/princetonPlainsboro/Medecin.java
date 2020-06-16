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
        return this.specialite;
    }

    public String getIdentifiant(){
        return this.identifiant;
    }
    
    public String getNom(){
        return "DR. "+this.nom+" "+this.prenom;
    }
     
    public String getMdp(){
        return this.mdp; 
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
    
        public void completerFicheDeSoin(Patient patient, Date date, Acte acte){ 
        for(FicheDeSoins fs : SecretaireMedicale.fiches){
            if (fs.patient==patient && fs.date==date && fs.identifiant == this.identifiant && fs.specialite==this.specialite){
                fs.ajouterActe(acte);
                    }
        }
       
        
        
    }
    //liste de ses patients uniquement
    public void afficherListePatients(){
        System.out.println("Liste des patients du Docteur "+ this.nom);
        for (Patient pat : patients){
            System.out.print(pat.getNom() +" ");
            System.out.println(pat.getPrenom());
        }
        
    }
    
    public void imprimerListePatient(){
        
    }
    
    public void imprimerFicheDeSoin(){ //déjà dans secretaire_med
        
    }
}
