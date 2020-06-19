/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 *
 * @author Maelle
 */
public class TentativeConnexion {

    private Hospital hospital;

    public TentativeConnexion(Hospital hospital) {
        this.hospital = hospital;
    }

    //connexion valide si les mots de passes et l'identifiants se trouvent dans la liste suivant
    //le profil choisit
    public boolean connexionValide(String identifiant, String mdp, String statut) {
        if (statut.equals("Medecin")) {
            for (Medecin m : this.hospital.getListMedecin()) {
                if (m.getIdentifiant().equals(identifiant) && m.getMdp().equals(mdp)) {
                    return true;
                }
            }
        }
        if (statut.equals("Secretaire Medicale")) {
            for (SecretaireMedicale sm : this.hospital.getListSM()) {
                if (sm.getIdentifiant().equals(identifiant) && sm.getMdp().equals(mdp)) {
                    return true;
                }
            }
        }
        if (statut.equals("Secretaire Administrative")) {
            
            if (this.hospital.getSA().getIdentifiant().equals(identifiant) && this.hospital.getSA().getMdp().equals(mdp)) {
                return true;
            }
        } 
        return false;
    }
}