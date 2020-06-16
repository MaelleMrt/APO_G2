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
    private int tel; 

    public Medecin(String nom, String prenom, String specialite, String identifiant, String mdp, int tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.mdp = mdp;
        this.identifiant = identifiant;
        this.tel = tel; 
        this.patients = new ArrayList<Patient>();
    }

    public void ajouterPatient(Patient p) {
        this.patients.add(p);
    }

    public String getSpecialite() {
        return this.specialite;
    }

    public String getIdentifiant() {
        return this.identifiant;
    }
    
    public List<Patient> getListPatient(){
        return this.patients;
    }

    public String getNomComplet() {
        return "DR. " + this.nom + " " + this.prenom;
    }
    
    public String getNom(){
        return this.nom; 
    }

    public String getPrenom(){
        return this.prenom;
    }
   
    public String getMdp() {
        return this.mdp;
    }
    
    public int getNumeroTel(){
        return this.tel;
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
    public void completerFicheDeSoin(Patient patient, Date date, Acte acte) {

    }

    //liste de ses patients uniquement

    public void afficherListePatients() {

    }

    public void imprimerListePatient() {

    }

    public void imprimerFicheDeSoin() { //déjà dans secretaire_med

    }
}
