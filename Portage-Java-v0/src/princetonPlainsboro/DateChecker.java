/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Maelle
 */
public class DateChecker {
    public static boolean isValid(String strdate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-kk-mm");
        df.setLenient(false);
        try {
            Date date = df.parse(strdate);
            return true;
        } catch (ParseException ex) {
            //Logger.getLogger(DateChecker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     
    public princetonPlainsboro.Date creerDate(String donnees) {
        int annee = Integer.parseInt(donnees.substring(0, donnees.indexOf('-')));
        int mois = Integer.parseInt(donnees.substring(donnees.indexOf('-') + 1, donnees.indexOf('-', donnees.indexOf('-') + 1)));
        int jour = Integer.parseInt(donnees.substring(donnees.indexOf('-', donnees.indexOf('-') + 1) + 1, donnees.indexOf('-', donnees.indexOf('-', donnees.indexOf('-') + 1) + 1)));
        int heure = Integer.parseInt(donnees.substring(donnees.indexOf('-', donnees.indexOf('-', donnees.indexOf('-') + 1) + 1) + 1, donnees.lastIndexOf('-', donnees.indexOf('-', donnees.indexOf('-', donnees.indexOf('-', donnees.indexOf('-') + 1) + 1) + 1))));
        int minutes = Integer.parseInt(donnees.substring(donnees.lastIndexOf('-', donnees.indexOf('-', donnees.indexOf('-', donnees.indexOf('-', donnees.indexOf('-') + 1) + 1) + 1)) + 1, donnees.length()));
        return new princetonPlainsboro.Date(annee,mois,jour,heure,minutes);
    }
}
