/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Maelle
 */
public class LectureXMLHop {
    private String nomFichier;
        private final static String repBase = "src/donnees/";

        // 'nomFichier' est le nom d'un fichier XML se trouvant dans le repertoire 'repBase' a lire :
        public LectureXMLHop(String nomFichier) {
            this.nomFichier = nomFichier;
        }

        public Hospital getHospital() {
            Hospital hospitalCourant = null;
            Date date = null;
            List<Specialite> specialites = new ArrayList<Specialite>();
            List<Acte> actes = new Vector<Acte>();
            List<Medecin> medecins=new ArrayList<Medecin>();
            Patient patientCourant = null;
            Medecin medecinCourant = null;
            Specialite specialiteCourante = null;
            String mdpCourant = null;
            String identifiantCourant = null;
            SecretaireMedicale secretaireMedicaleCourante = null;
            SecretaireAdministrative secretaireAdministrativeCourante = null;
            String donneesCourantes = "";
            String nomCourant = "";
            String prenomCourant = "";
            String nomSpecialiteCourante="";
            String nomMedecinCourant="";
            String prenomMedecinCourant="";
            
            
            long secuCourante = 0;
            Date dateNaissanceCourante = null;
            Code codeCourant = null;
            int coefCourant = 0;

            // analyser le fichier par StAX
            try {
                // instanciation du parser
                InputStream in = new FileInputStream(repBase + nomFichier);
                XMLInputFactory factory = XMLInputFactory.newInstance();
                XMLStreamReader parser = factory.createXMLStreamReader(in);

                // lecture des evenements
                for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                    // traitement selon l'evenement
                    switch (event) {
                        case XMLStreamConstants.START_ELEMENT:
                            if (parser.getLocalName().equals("hopital")) {
                                hospitalCourant = new Hospital(nomCourant);
                            }
                            break;
                        case XMLStreamConstants.END_ELEMENT:
                            if (parser.getLocalName().equals("acte")) {
                                actes.add(new Acte(codeCourant, coefCourant));
                            }
                            if (parser.getLocalName().equals("code")) {
                                codeCourant = getCode(donneesCourantes);
                                if (codeCourant == null) {
                                    throw new XMLStreamException("Impossible de trouver le code d'acte = " + donneesCourantes);
                                }
                            }
                            if (parser.getLocalName().equals("coef")) {
                                coefCourant = Integer.parseInt(donneesCourantes);
                            }
                            if (parser.getLocalName().equals("date")) {
                                int annee = Integer.parseInt(donneesCourantes.substring(0, donneesCourantes.indexOf('-')));
                                int mois = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-') + 1, donneesCourantes.lastIndexOf('-')));
                                int jour = Integer.parseInt(donneesCourantes.substring(donneesCourantes.lastIndexOf('-') + 1, donneesCourantes.length()));

                                date = new Date(jour, mois, annee);
                            }
                            if (parser.getLocalName().equals("ficheDeSoins")) {
                                FicheDeSoins f = new FicheDeSoins(patientCourant, medecinCourant, date);
                                // ajout des actes
                                for (int i = 0; i < actes.size(); i++) {
                                    Acte a = (Acte) actes.get(i);
                                    f.ajouterActe(a);
                                }
                                // effacer tous les actes de la liste
                                actes.clear();
                                // ajouter la fiche de soin au patient
                                patientCourant.ajouterFicheDeSoins(f);
                            }
                            if (parser.getLocalName().equals("medecin")) {
                                //a chaque fois que le tombe sur un medecin on le met dans le courant
                                //on l'ajoute à la liste du serviceCourant et on vérifie si il n'est pas déjà dans la liste des medecins
                                boolean presentM = false;
                                for (Medecin m : hospitalCourant.getListMedecin()) {
                                    if (m.getIdentifiant().equals(identifiantCourant)) {
                                        presentM = true;
                                        medecinCourant = m;
                                    }
                                }
                                if (!presentM){
                                    medecinCourant = new Medecin(nomMedecinCourant, prenomMedecinCourant, nomSpecialiteCourante, identifiantCourant, mdpCourant);
                                    hospitalCourant.ajouterMedecin(medecinCourant);
                                }
                                

                            }
                            if (parser.getLocalName().equals("secretaireMedicale")) {
                                secretaireMedicaleCourante = new SecretaireMedicale(identifiantCourant, mdpCourant, specialiteCourante);
                            }
                            if (parser.getLocalName().equals("secretaireAdministrative")) {
                                secretaireAdministrativeCourante = new SecretaireAdministrative(identifiantCourant, mdpCourant);
                            }
                            if (parser.getLocalName().equals("secu")) {
                                secuCourante = Long.parseLong(donneesCourantes);
                            }
                            if (parser.getLocalName().equals("dateNaissance")) {
                                int annee = Integer.parseInt(donneesCourantes.substring(0, donneesCourantes.indexOf('-')));
                                int mois = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-') + 1, donneesCourantes.lastIndexOf('-')));
                                int jour = Integer.parseInt(donneesCourantes.substring(donneesCourantes.lastIndexOf('-') + 1, donneesCourantes.length()));

                                dateNaissanceCourante = new Date(annee, mois, jour);
                            }
                            if (parser.getLocalName().equals("mdp")) {
                                mdpCourant = donneesCourantes;
                            }
                            if (parser.getLocalName().equals("identifiant")) {
                                identifiantCourant = donneesCourantes;
                            }
                            if (parser.getLocalName().equals("nom")) {
                                nomCourant = donneesCourantes;
                            }
                            if (parser.getLocalName().equals("nomS")) {
                                nomSpecialiteCourante = donneesCourantes;
                            }
                            if(parser.getLocalName().equals("nomM")){
                                nomMedecinCourant = donneesCourantes;
                            }
                            if(parser.getLocalName().equals("prenomM")){
                                prenomMedecinCourant = donneesCourantes;
                            }
                            if (parser.getLocalName().equals("patient")) {
                                //on l'ajoute au medecinCourant et on vérifie si il n'est pas déjà dans la liste des patients
                                boolean present = false;
                                for (Patient p : hospitalCourant.getListPatient()) {
                                    if (p.getSecu() == secuCourante) {
                                        present = true;
                                        patientCourant = p;
                                    }
                                }
                                if (!present) {
                                    patientCourant = new Patient(nomCourant, prenomCourant, secuCourante, dateNaissanceCourante);
                                }
                                hospitalCourant.ajouterPatient(patientCourant);

                            }
                            if (parser.getLocalName().equals("prenom")) {
                                prenomCourant = donneesCourantes;
                            }
                            if (parser.getLocalName().equals("specialite")) {
                                specialiteCourante = new Specialite(nomCourant, secretaireMedicaleCourante);
                                for(Medecin m:medecins){
                                    specialiteCourante.ajouterMedecin(medecinCourant);
                                }
                                medecins.clear();
                            }
                            break;
                        case XMLStreamConstants.CHARACTERS:
                            donneesCourantes = parser.getText();
                            break;
                    } // end switch
                } // end while
                parser.close();
            } catch (XMLStreamException ex) {
                System.out.println("Exception de type 'XMLStreamException' lors de la lecture du fichier : " + nomFichier);
                System.out.println("Details :");
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println("Exception de type 'IOException' lors de la lecture du fichier : " + nomFichier);
                System.out.println("Verifier le chemin.");
                System.out.println(ex.getMessage());
            }

            return hospitalCourant;
        }

    private static Code getCode(String code) {
        if (code.equals("CS")) {
            return Code.CS;
        }
        if (code.equals("CSC")) {
            return Code.CSC;
        }
        if (code.equals("FP")) {
            return Code.FP;
        }
        if (code.equals("KC")) {
            return Code.KC;
        }
        if (code.equals("KE")) {
            return Code.KE;
        }
        if (code.equals("K")) {
            return Code.K;
        }
        if (code.equals("KFA")) {
            return Code.KFA;
        }
        if (code.equals("KFB")) {
            return Code.KFB;
        }
        if (code.equals("ORT")) {
            return Code.ORT;
        }
        if (code.equals("PRO")) {
            return Code.PRO;
        }
        // probleme : code inconnu
        return null;
    }
}
