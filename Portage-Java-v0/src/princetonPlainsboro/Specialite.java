/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 *
 * @author sixtine
 */
public class Specialite {

    private Service nom;
    private Secretaire_medicale secMed;
    private java.util.ArrayList<Medecin> listeMed;

    //constructeur
    public void Specialite(Service nom, Secretaire_medicale secMed) {
        this.nom = nom;
        this.secMed = secMed;
        this.listeMed = new java.util.ArrayList<Medecin>();
    }

    //ajouter un médecin dans la liste 
    public void ajouterMedecin() {
        this.listeMed.add(Medecin.nom);

    }

    public void getNom() {

    }

    public void getSecMed() {

    }

    public void getListeMed() {

    }

    //vérifier que ça marche
    public void afficherInfos() {
        System.out.println("Spécialité = " + nom);
        System.out.println("Secrétaire medicale = " + this.secMed.identifiant);
        System.out.println("Liste des médecins dans le service :");
        for (Medecin elem : listeMed) {
            System.out.println(elem);

        }

    }
}