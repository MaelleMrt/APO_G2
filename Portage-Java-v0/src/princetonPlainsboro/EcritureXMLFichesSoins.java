/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author kalma
 */
public class EcritureXMLFichesSoins {

    static org.jdom2.Document document;
    static Element racine;

//    public static void main(String[] args) {
//        try {
//            lireFichier("src/donnees/hopital_1.xml");
//            //System.out.println("lecture fichier : ok ");
//            Date date = new Date(1996, 12, 3, 20, 14);
//            Date dateFS = new Date(17,6,2020,15,27);  
//            Patient p = new Patient("Rico", "Coco", 12, date, 83600);
//            Medecin m = new Medecin("Mama", "Mia", "cardiologie", "med8", "motdepasse", 12);
//            FicheDeSoins fs = new FicheDeSoins(p,m.getNom(),m.getSpecialite(),dateFS ); 
//            ajouterFiche(p, m, fs);
//            enregistreFichier("src/donnees/hopital_1.xml");
//            //System.out.println("enregistrement des donnees : ok ");
//        } catch (Exception e) {
//            System.out.println("erreur (catch) : ");
//            System.out.println(e);
//        }
//    }
    //On parse le fichier et on initialise la racine de notre arborescence
    public static void lireFichier(String fichier) throws Exception {
        SAXBuilder sxb = new SAXBuilder();
        document = sxb.build(new File(fichier));
        racine = document.getRootElement();
        System.out.println("fichier lu");
    }
    //On fait des modifications sur un Element

    public static void ajouterFicheXML(Patient p, Medecin m, FicheDeSoins fs) {
        //creation du nouveau patient : 
        Element newFiche = new Element("ficheDeSoin");

        //creation et ajout de la date de la fiche de soins
        Element rdv = new Element("date");
        String dateRDV = fs.getDate().getAnnee() + "-" + fs.getDate().getMois() + "-" + fs.getDate().getJour() + "-" + fs.getDate().getHeure() + "-" + fs.getDate().getMinutes();
        rdv.setText(dateRDV);
        newFiche.addContent(rdv);

        // On liste toutes les specialites de l'hopital : 
        List listSpecialite = racine.getChildren("specialite");
        //On parcourt la liste grace a un iterator
        Iterator i = listSpecialite.iterator();
        //on cherche la specialite d'interet: 
        while (i.hasNext()) {
            Element courant = (Element) i.next();
            if (courant.getChildText("nomS").equals(m.getSpecialite())) {
                // La <specialite> d'interet devient notre racine: 
                racine = courant.setName("specialite");
                //System.out.println("parcours des specialites");
            }
        }

        //creation liste des medecins de la specialite 
        List listMed = racine.getChildren("medecin");
        //on parcours la liste des medecin 
        Iterator j = listMed.iterator();
        //on cherche le medecin d'interet : 
        while (j.hasNext()) {
            Element courant2 = (Element) j.next();
            if (courant2.getChildText("nomM").equals(m.getNom())) {
                // <medecin> devient racine 
                racine = courant2.setName("medecin");
                //   System.out.println("parcours des medecins : la racine devient medecin");
            }
        }

        //creation list patient du medecin considere :
        List listPatient = racine.getChildren("patient");
        // on parcourt la liste des patients du medecin :
        Iterator k = listPatient.iterator();
        //on cherhce le patient d'interet: 
        while (k.hasNext()) {
            Element courant3 = (Element) k.next();
            if (courant3.getChildText("nom").equals(p.getNom())) {
                //ajout de la fiche de soins au patient 
                courant3.addContent(newFiche);
                System.out.println("fiche de soins ajoutee au patient");
            }
        }
    }

    //On enregistre notre nouvelle arborescence dans le fichier
    //d'origine dans un format classique.
    public static void enregistreFichier(String fichier) throws Exception {
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream(fichier));
        System.out.println("enregistrer");
    }
}
