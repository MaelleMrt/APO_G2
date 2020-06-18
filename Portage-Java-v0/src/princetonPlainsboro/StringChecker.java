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
public class StringChecker {
        public static boolean chekerString(String numero) {
        for (int i = 0; i < numero.length(); i++) {
            if (Character.toUpperCase(numero.charAt(i)) >= '!' && Character.toUpperCase(numero.charAt(i)) <= '@') {
                return false;
            }
        }
        return true;
    }
}
