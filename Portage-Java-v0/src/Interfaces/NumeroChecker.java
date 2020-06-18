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
public class NumeroChecker {

    public static boolean chekerNumero(String numero) {
        for (int i = 0; i < numero.length(); i++) {
            if (Character.toUpperCase(numero.charAt(i)) >= 'A' && Character.toUpperCase(numero.charAt(i)) <= 'Z') {
                return false;
            }
        }
        return true;
    }
}
