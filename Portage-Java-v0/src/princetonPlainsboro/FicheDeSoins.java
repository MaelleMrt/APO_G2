package princetonPlainsboro;

import java.util.Vector;

public class FicheDeSoins {

    private Patient patient;
    private String medecin;
    private String specialite;
    private Date date;
    private Vector<Acte> actes;       // contient des objets de classe 'Acte'

    public FicheDeSoins(Patient patient,String IdentifiantMedecin,String specialite, Date date) {
        this.patient = patient;
        this.medecin = IdentifiantMedecin;
        this.specialite=specialite;
        this.date = date;
        actes = new Vector<Acte>();   // liste vide
    }

    public Patient getPatient() {
        return patient;
    }

    public String getMedecin() {
        return medecin;
    }

    public Date getDate() {
        return date;
    }
    
    public String getService(){
        return this.specialite;
    }

    public void ajouterActe(Acte acte) {
        actes.add(acte);
    }
    

    public void ajouterActe(Code code, int coefficient) {
        Acte acte = new Acte(code, coefficient);
        actes.add(acte);
    }

    public void afficher() {
        System.out.println("Fiche de soins du " + date.toString());
        System.out.println("- medecin : " + medecin.toString());
        System.out.println("- patient : " + patient.toString());
        System.out.println("- actes medicaux :");
        for (int i = 0; i < actes.size(); i++) {
            Acte a = actes.get(i);
            System.out.println("    > " + a.toString());
        }
    }

    public double coutTotal() {
        double total = 0;
        for (int i = 0; i < actes.size(); i++) {
            Acte a = actes.get(i);
            total += a.cout();
        }
        return total;
    }
    
     //completer la fiche de soin du patient cree par la secretaire medicale
    public void completerFicheDeSoin(Patient patient, Date date, Acte acte){ 
        for(FicheDeSoins fs : SecretaireMedicale.fiches){
            if (fs.patient==patient && fs.date==date && fs.identifiant == this.identifiant && fs.specialite==this.specialite){
                fs.ajouterActe(acte);
                    }
        }
       
        
        
    }
    
    public void imprimerFicheDeSoin(FicheDeSoins fs){ //dÃ©jÃ  dans secretaire_med
        fs.imprimerFiche();
    }
    
    //pouur imprimer, il faut créer un pdf. (apres une fois qu'on a téléchargé le pdf, l'ordi propose d'imprimer)
    public void imprimerListePatient(){
        
    }


    
}
