package princetonPlainsboro;

import java.util.Date;

class Patient {
    private String nom;
    private String prenom;
    private Date naissance;
    private Integer numSecu;
    
    private java.util.ArrayList<FicheDeSoins> DossierMedical;
    
    //, Date naissance, Integer numSecu
    
    public Patient(String nom, String prenom, Integer secu,Date dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance=dateDeNaissance;
        this.numSecu=secu;
        this.DossierMedical = new java.util.ArrayList<FicheDeSoins>();
        }
    public Integer getSecu(){
        return numSecu;
    }
    
    public void ajouterFicheDeSoins(Patient patient, Medecin medecin, princetonPlainsboro.Date date){
        FicheDeSoins e = new FicheDeSoins(patient,medecin,date);
        DossierMedical.add(e);
        
    }
    
    public String toString() {
        return prenom + " " + nom;
        }
    
    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient)o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
            }
        else
            return false;
        }    
    }

