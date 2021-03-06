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
        
        //declaration de toutes les variables qui vons nous servir a remplir notre hopital
        Hospital hospitalCourant = null;
        Date date = null;
        List<Specialite> specialites = new ArrayList<Specialite>();
        List<Acte> actes = new Vector<Acte>();
        List<Medecin> medecins = new ArrayList<Medecin>();
        List<FicheDeSoins> fiches = new ArrayList<FicheDeSoins>();
        List<Patient> patients = new ArrayList<Patient>();
        Patient patientCourant = null;
        Medecin medecinCourant = null;
        String numeroCourant = "";
        String codePCourant = "";
        Specialite specialiteCourante = null;
        String mdpCourant = null;
        String identifiantCourant = null;
        SecretaireMedicale secretaireMedicaleCourante = null;
        SecretaireAdministrative secretaireAdministrativeCourante = null;
        String donneesCourantes = "";
        String nomCourant = "";
        String prenomCourant = "";
        String nomSpecialiteCourante = "";
        String nomMedecinCourant = "";
        String prenomMedecinCourant = "";
        String mdpCourantSe = "";
        String identifiantCourantMe = " ";
        String identifiantCourantSe = "";
        String mdpCourantMe = " ";
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
                    
                    //creation du nouveau hopital
                    case XMLStreamConstants.START_ELEMENT:
                        if (parser.getLocalName().equals("hopital")) {
                            hospitalCourant = new Hospital(nomCourant);
                        }
                        break;
                        
                    case XMLStreamConstants.END_ELEMENT:
                        
                        //on recupere l'acte
                        if (parser.getLocalName().equals("acte")) {
                            actes.add(new Acte(codeCourant, coefCourant));
                        }
                        
                        //on recupere le code
                        if (parser.getLocalName().equals("code")) {
                            codeCourant = getCode(donneesCourantes);
                            if (codeCourant == null) {
                                throw new XMLStreamException("Impossible de trouver le code d'acte = " + donneesCourantes);
                            }
                        }
                        
                        //on recupere le coef
                        if (parser.getLocalName().equals("coef")) {
                            coefCourant = Integer.parseInt(donneesCourantes);
                        }
                        
                        //on recupere le numero de telephone
                        if (parser.getLocalName().equals("num")) {
                            numeroCourant = donneesCourantes;
                        }
                        
                        //on recupere la date d'une fiche de soins
                        if (parser.getLocalName().equals("date")) {
                            int annee = Integer.parseInt(donneesCourantes.substring(0, donneesCourantes.indexOf('-')));
                            int mois = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-') + 1, donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1)));
                            int jour = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1) + 1, donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1) + 1)));
                            int heure = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1) + 1) + 1, donneesCourantes.lastIndexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1) + 1) + 1))));
                            int minutes = Integer.parseInt(donneesCourantes.substring(donneesCourantes.lastIndexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1) + 1) + 1)) + 1, donneesCourantes.length()));

                            date = new Date(jour, mois, annee, heure, minutes);
                        }
                        
                        //on cree une nouvelle fiche de soin
                        if (parser.getLocalName().equals("ficheDeSoin")) {

                            FicheDeSoins f = new FicheDeSoins(patientCourant, nomMedecinCourant /*+ " " + prenomMedecinCourant*/, nomSpecialiteCourante, date);
                            // ajout des actes
                            for (int i = 0; i < actes.size(); i++) {
                                Acte a = (Acte) actes.get(i);
                                f.ajouterActe(a);
                            }
                            // effacer tous les actes de la liste
                            actes.clear();
                            // ajouter la fiche de soin au patient
                            fiches.add(f);
                        }
                        
                        //on cree le medecin
                        if (parser.getLocalName().equals("medecin")) {

                            //on l'ajoute a  la liste du serviceCourant et on verifie si il n'est pas deja  dans la liste des medecins
                            boolean presentM = false;
                            for (Medecin m : hospitalCourant.getListMedecin()) {
                                if (m.getIdentifiant().equals(identifiantCourant)) {
                                    presentM = true;
                                    medecinCourant = m;

                                }
                            }
                            //si il n'est pas present
                            if (!presentM) {
                                medecinCourant = new Medecin(nomMedecinCourant, prenomMedecinCourant, nomSpecialiteCourante, identifiantCourant, mdpCourant, numeroCourant);
                                hospitalCourant.ajouterMedecin(medecinCourant);
                            }
                            //on lui ajoute ses patients qu'il n'a pas deja
                            for (Patient p : patients) {
                                if (!medecinCourant.getListPatient().contains(p)) {
                                    medecinCourant.ajouterPatient(p);
                                }
                            }
                            patients.clear();

                            medecins.add(medecinCourant);

                        }
                        
                        //on cree la secretaire administrative
                        if (parser.getLocalName().equals("secretaireAdministrative")) {
                            secretaireAdministrativeCourante = new SecretaireAdministrative(identifiantCourantSe, mdpCourantSe, hospitalCourant);
                            hospitalCourant.setSecretaireA(secretaireAdministrativeCourante);
                        }
                        
                        //on recupere le numero de secu 
                        if (parser.getLocalName().equals("secu")) {
                            secuCourante = Long.parseLong(donneesCourantes);
                        }
                        
                        //on recupere la date de naissance
                        if (parser.getLocalName().equals("dateNaissance")) {

                            int annee = Integer.parseInt(donneesCourantes.substring(0, donneesCourantes.indexOf('-')));
                            int mois = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-') + 1, donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1)));
                            int jour = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1) + 1, donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1) + 1)));
                            int heure = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1) + 1) + 1, donneesCourantes.lastIndexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1) + 1) + 1))));
                            int minutes = Integer.parseInt(donneesCourantes.substring(donneesCourantes.lastIndexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-', donneesCourantes.indexOf('-') + 1) + 1) + 1)) + 1, donneesCourantes.length()));

                            dateNaissanceCourante = new Date(annee, mois, jour, heure, minutes);
                        }
                        
                        //recuperation et cryptage du mdp
                        if (parser.getLocalName().equals("mdp")) {
                            
                            mdpCourant = Cryptage.dechiffre(6, donneesCourantes); 
                        }
                        
                        //recuperation des identifiants du medecin
                        if (parser.getLocalName().equals("identifiant")) {
                            identifiantCourant = donneesCourantes;
                        }
                        
                        //recuperation et cryptage du mdp
                        if (parser.getLocalName().equals("mdpSe")) {
                            mdpCourantSe = Cryptage.dechiffre(6, donneesCourantes);
                        }

                        //recuperation des identifiants de la secretaire admin
                        if (parser.getLocalName().equals("identifiantSe")) {
                            identifiantCourantSe = donneesCourantes;
                        }
                        
                        //recuperation des identifiants de la secretaire medicale
                        if (parser.getLocalName().equals("identifiantMe")) {
                            identifiantCourantMe = donneesCourantes;
                        }
                        
                        //recuperation et cryptage du mdp
                        if (parser.getLocalName().equals("mdpMe")) {
                            mdpCourantMe = Cryptage.dechiffre(6, donneesCourantes);
                        }
                        
                        //recuperation code postale
                        if (parser.getLocalName().equals("codeP")) {
                            codePCourant = donneesCourantes;
                        }
                        
                        //recuperation du nom de l'hopital
                        if (parser.getLocalName().equals("nom")) {
                            nomCourant = donneesCourantes;
                        }
                        
                        //recuperation du nom de la specialite
                        if (parser.getLocalName().equals("nomS")) {
                            nomSpecialiteCourante = donneesCourantes;
                        }
                        
                        //recuperation du nom du medecin
                        if (parser.getLocalName().equals("nomM")) {
                            nomMedecinCourant = donneesCourantes;
                        }
                        
                        //recuperation du prenom du medecin
                        if (parser.getLocalName().equals("prenomM")) {
                            prenomMedecinCourant = donneesCourantes;
                        }
                        
                        //ajout du patient
                        if (parser.getLocalName().equals("patient")) {
                            //on l'ajoute au medecinCourant et on verifie si il n'est pas deja  dans la liste des medecins
                            boolean present = false;
                            for (Patient p : hospitalCourant.getListPatient()) {
                                if (p.getSecu() == secuCourante) {
                                    present = true;
                                    patientCourant = p;

                                }
                            }
                            if (!present) {
                                patientCourant = new Patient(nomCourant, prenomCourant, secuCourante, dateNaissanceCourante, codePCourant);
                                //on ajoute a  la liste de patient de l'hopital
                                hospitalCourant.ajouterPatient(patientCourant);
                            }
                            
                            //on ajoute les fiches de soins courantes
                            for (FicheDeSoins fs : fiches) {
                                patientCourant.ajouterFicheDeSoins(fs);
                                fs.setPatient(patientCourant);
                            }
                            //on clear la fiches de soins courantes
                            fiches.clear();

                            //on ajoute a  la liste de patients courants
                            patients.add(patientCourant);

                        }
                        
                        //on recupere le nom du patient
                        if (parser.getLocalName().equals("prenom")) {
                            prenomCourant = donneesCourantes;
                        }
                        
                        //on cree une nouvelle specialite
                        if (parser.getLocalName().equals("specialite")) {
                            specialiteCourante = new Specialite(nomSpecialiteCourante, secretaireMedicaleCourante);
                            for (Medecin m : medecins) {
                                specialiteCourante.ajouterMedecin(m);
                            }
                            //creation de la secretaire avec la specialite courante
                            secretaireMedicaleCourante = new SecretaireMedicale(identifiantCourantMe, mdpCourantMe, specialiteCourante);
                            hospitalCourant.ajouterSecretaireM(secretaireMedicaleCourante);
                            //on set la secretaireMedicale
                            specialiteCourante.setSM(secretaireMedicaleCourante);

                            //on l'ajoute a  l'hopital la secretaire medicale
                            //on ajoute la specialite a  l'hopital
                            hospitalCourant.ajouterSpecialite(specialiteCourante);
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
