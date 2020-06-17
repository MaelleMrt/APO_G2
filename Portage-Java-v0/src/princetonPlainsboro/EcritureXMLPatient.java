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
import static princetonPlainsboro.EcritureXMLPatient.document;

/**
 *
 * @author kalma
 */
public class EcritureXMLPatient {

    static org.jdom2.Document document;
    static Element racine;

    public static void lireFichier(String fichier) throws Exception {
        SAXBuilder sxb = new SAXBuilder();
        document = sxb.build(new File(fichier));
        racine = document.getRootElement();
    }

    public static void ajouterPatientXML(Patient p, Medecin m) {
        //creation du nouveau patient : 
        Element newPatient = new Element("patient");

        //creation et ajout de ses donnees 
        Element nom = new Element("nom");
        nom.setText(p.getNom());
        newPatient.addContent(nom);

        Element prenom = new Element("prenom");
        prenom.setText(p.getPrenom());
        newPatient.addContent(prenom);

        Element secu = new Element("secu");
        secu.setText(String.valueOf(p.getSecu()));
        newPatient.addContent(secu);

        Element naissance = new Element("dateNaissance");
        String dateN = p.getNaissance().getAnnee() + "-" + p.getNaissance().getMois() + "-" + p.getNaissance().getJour() + "-" + p.getNaissance().getHeure() + "-" + p.getNaissance().getMinutes();
        naissance.setText(dateN);
        newPatient.addContent(naissance);

        Element codeP = new Element("codeP");
        codeP.setText(String.valueOf(p.getCP()));
        newPatient.addContent(codeP);

        //Dans un premier temps on liste toutes les specialites
        List listSpecialite = racine.getChildren("specialite");
        Iterator i = listSpecialite.iterator();

        //On parcourt la liste grâce à un iterator
        //on trouve la specialite qui nous interresse 
        while (i.hasNext()) {
            Element courant = (Element) i.next();
            if (courant.getChildText("nomS").equals(m.getSpecialite())) {
                //changement de l'element racine du code xml 
                racine = courant.setName("specialite");
                //System.out.println("parcours liste specialites : la racine devient specialite ");
            }
        }
        //trouver le bon medecin et lui ajouter le patient 
        List listMed = racine.getChildren("medecin");
        Iterator j = listMed.iterator();
        while (j.hasNext()) {
            Element courant2 = (Element) j.next();
            if (courant2.getChildText("nomM").equals(m.getNom())) {
                courant2.addContent(newPatient); //ajout du patient au dossier 
                System.out.println("Ajout du patient à la liste");
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
