/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.util.List;

/**
 *
 * @author sixtine
 */
public class Specialite {

    private String nom;
    private SecretaireMedicale secMed;
    private java.util.ArrayList<Medecin> listeMed;

    //constructeur
    public Specialite(String nom, SecretaireMedicale secMed) {
        this.nom = nom;
        this.secMed = secMed;
        this.listeMed = new java.util.ArrayList<Medecin>();
    }

    //ajouter un médecin dans la liste 
    public void ajouterMedecin(Medecin med) {
        this.listeMed.add(med);

    }

    public String getNom() {
        return this.nom;
    }

    public SecretaireMedicale getSecMed() {
        return this.secMed;
    }

    public List<Medecin> getListeMed() {
        return this.listeMed;

    }

    //vérifier que ça marche
    public void afficherInfos() {
        System.out.println("Spécialité = " + nom);
        System.out.println("Secrétaire medicale = " + this.secMed.getIdentifiant());
        System.out.println("Liste des médecins dans le service :");
        for (Medecin elem : listeMed) {
            System.out.println(elem);

        }

    }
}