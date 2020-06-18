/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import org.jdom2.*;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.*;

/**
 *
 * @author kalma
 */
public class EcritureXMLMedecin {

    static org.jdom2.Document document;
    static Element racine;

//    public static void main(String[] args) {
//        try {
//            lireFichier("src/donnees/hopital_1.xml");
//            //System.out.println("lecture fichier");
//            Medecin med = new Medecin("Mama", "Mia", "cardiologie", "med8", "motdepasse", 12);
//            System.out.println("creation element");
//            ajouterMedecin(med);
//            //System.out.println("ajout de l element ");
//            enregistreFichier("src/donnees/hopital_1.xml");
//            //System.out.println("enregistrement des donnees");
//        } catch (Exception e) {
//            System.out.println("erreur (catch)");
//            System.out.println(e);
//        }
//    }
    //On parse le fichier et on initialise la racine de notre arborescence
    public static void lireFichier(String fichier) throws Exception {
        SAXBuilder sxb = new SAXBuilder();
        document = sxb.build(new File(fichier));
        racine = document.getRootElement();
    }
    //On fait des modifications sur un Element

    public static void ajouterMedecinXML(Medecin med) {
        //creer element medeicn
        Element newMedecin = new Element("medecin");

        //creation numero tel, identifiant, mot de passe, nom, prenom 
        Element numero = new Element("num");
        numero.setText(String.valueOf(med.getNumeroTel()));   //recuperation donnee
        newMedecin.addContent(numero);      // ajout du numero au medecin 

        Element identifiant = new Element("identifiant");
        identifiant.setText(med.getIdentifiant());
        newMedecin.addContent(identifiant);

        Element mdp = new Element("mdp");
        mdp.setText(med.getMdp());
        newMedecin.addContent(mdp);

        Element nomM = new Element("nomM");
        nomM.setText(med.getNom());
        newMedecin.addContent(nomM);

        Element prenomM = new Element("prenomM");
        prenomM.setText(med.getPrenom());
        newMedecin.addContent(prenomM);

        //Dans un premier temps on liste toutes les fiches de soins
        List listFiches = racine.getChildren("specialite");
        Iterator i = listFiches.iterator();
        //On parcourt la liste grace a un iterator
        while (i.hasNext()) {
            Element courant = (Element) i.next();
            if (courant.getChildText("nomS").equals(med.getSpecialite())) {
                //ajouter medecin 
                courant.addContent(newMedecin);
                System.out.println("medecin ajoute a la base");

            }

        }
    }

    //On enregistre notre nouvelle arborescence dans le fichier
    //d'origine dans un format classique.
    public static void enregistreFichier(String fichier) throws Exception {
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream(fichier));
    }
}
