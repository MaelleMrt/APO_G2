package princetonPlainsboro;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DossierMedical {

    private List<FicheDeSoins> fiches;     // contient des objets de classe 'FicheDeSoins'

    public DossierMedical() {
        fiches = new Vector<FicheDeSoins>();  // liste vide
    }

    public void ajouterFiche(FicheDeSoins fiche) {
        fiches.add(fiche);
    }

    public void afficher() {
        System.out.println("Dossier medical informatise :");
        System.out.println("-----------------------------");
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            f.afficher();
            // pour separer les fiches de soins :
            System.out.println("--------------------------------------");
        }
    }

    public double coutPatient(Patient p) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (p.equals(f.getPatient())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public double coutMedecin(Medecin m) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public double coutSpecialite(String specialite) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (specialite.equals(f.getService())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public void afficherListePatients(Medecin m) {
        System.out.println("> liste des patients du " + m.toString() + " :");
        Vector<Patient> liste = new Vector<Patient>();
        // 'liste' contient tous les patients deja affiches
        // --> ceci permet de ne pas reafficher un patient deja affiche
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                Patient p = f.getPatient();
                if (!liste.contains(p)) {
                    System.out.println(" - " + p.toString());
                    liste.add(p);
                }
            }
        }
    }

    public int nombreFichesIntervalle(Date d1, Date d2) {
        int n = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Date d = f.getDate();
            if (d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0) {
                n++;
            }
        }
        return n;
    }

    public static List<FicheDeSoins> SelectionnerDate(Date d1, Date d2, List<FicheDeSoins> fiches) {
        List<FicheDeSoins> fichesD = new ArrayList<FicheDeSoins>();
        for (FicheDeSoins fs : fiches) {
            System.out.println("annee fiche analyse   " + fs.getDate().getAnnee());
            System.out.println("annee d1    " + d1.getAnnee());
            System.out.println("annee d2    " + d2.getAnnee());
            if (fs.getDate().compareTo(d1) >= 0 && fs.getDate().compareTo(d2) <= 0) {
                fichesD.add(fs);
                System.out.println("fs ajouté");
            }
        }
        return fichesD;
    }

    public static List<FicheDeSoins> trierDates(List<FicheDeSoins> fiches) {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);
        List<FicheDeSoins> fichesT = new ArrayList<FicheDeSoins>();
        int j = 1;
        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins de date minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (f2.getDate().compareTo(f1.getDate()) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }

            fichesT.add(f1);
            copieFiches.remove(imin);
        }
        return fichesT;
    }

    // tri generique :
    public static List<FicheDeSoins> trierCout(List<FicheDeSoins> fichesNT) {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fichesNT);
        ComparaisonFichesCouts c=new ComparaisonFichesCouts();
        List<FicheDeSoins> fichesT = new ArrayList<FicheDeSoins>();
        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (c.comparer(f2, f1) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            fichesT.add(f1);
            copieFiches.remove(imin);

        }
        return fichesT;
    }
}
