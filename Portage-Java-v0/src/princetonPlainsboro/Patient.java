package princetonPlainsboro;

import java.util.Date;

class Patient {
    private String nom;
    private String prenom;
    private Date naissance;
    private Integer numSecu;
    
    public Patient(String nom, String prenom, Date naissance, Integer numSecu) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance=naissance;
        this.numSecu=numSecu;
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

