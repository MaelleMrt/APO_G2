package princetonPlainsboro;


class Patient {
    private String nom;
    private String prenom;
    private Date naissance;
    private long numSecu;
    
    private java.util.ArrayList<FicheDeSoins> DossierMedical;
    
    //, Date naissance, Integer numSecu
    
    public Patient(String nom, String prenom,long secu,Date dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance=dateDeNaissance;
        this.numSecu=secu;
        this.DossierMedical = new java.util.ArrayList<FicheDeSoins>();
        }
    public long getSecu(){
        return numSecu;
    }
    
    public void ajouterFicheDeSoins(FicheDeSoins fiche){ 
        DossierMedical.add(fiche); 
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

