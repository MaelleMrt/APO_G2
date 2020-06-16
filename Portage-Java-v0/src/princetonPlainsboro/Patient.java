/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.util.ArrayList;

/**
 *
 * @author kalma
 */
public class Patient {

    private String nom;
    private String prenom;
    private Date naissance;
    private long numSecu;

    private ArrayList<FicheDeSoins> DossierMedical;

    //, Date naissance, Integer numSecu
    public Patient(String nom, String prenom, long secu, Date dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = dateDeNaissance;
        this.numSecu = secu;
        this.DossierMedical = new ArrayList<FicheDeSoins>();
    }

    public long getSecu() {
        return numSecu;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void ajouterFicheDeSoins(FicheDeSoins fiche) {
        DossierMedical.add(fiche);
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }
    
    public ArrayList<FicheDeSoins> getDossierMed(){
        return DossierMedical; 
    }

    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
        } else {
            return false;
        }
    }

}
