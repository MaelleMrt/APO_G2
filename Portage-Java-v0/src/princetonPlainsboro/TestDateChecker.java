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
public class TestDateChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String date1 = "2010-12-03-12-04";
        String date2 = "1203/9444-08-13-08";

        //Test 1
        if (DateChecker.isValid(date1)) {
            System.out.println("Le format de " + date1 + " est correcte");
        } else {
            System.out.println(date1 + " n'est pas une date valide");
        }

        //Test2
        if (DateChecker.isValid(date2)) {
            System.out.println("Le format de " + date2 + " est correcte");
        } else {
            System.out.println(date2 + " n'est pas une date valide");
        }
    }
   
}
