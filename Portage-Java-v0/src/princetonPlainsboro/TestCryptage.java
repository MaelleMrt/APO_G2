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
public class TestCryptage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("administrative");
        System.out.println("--------------");
        System.out.println(Cryptage.chiffre(6, "secAA"));
        System.out.println(Cryptage.dechiffre(6,Cryptage.chiffre(6, "secAA")).compareTo("secAA")==0);
        System.out.println("--------------");
        System.out.println("medicale");
        System.out.println("--------------");
        System.out.println(Cryptage.chiffre(6, "secMC"));
        System.out.println(Cryptage.chiffre(6, "secMD"));
        System.out.println(Cryptage.chiffre(6, "secME"));
        System.out.println(Cryptage.chiffre(6, "secMF"));
        System.out.println("--------------");
        System.out.println("medecin");
        System.out.println("--------------");
        System.out.println(Cryptage.chiffre(6, "medA"));
        System.out.println(Cryptage.chiffre(6, "medB"));
        System.out.println(Cryptage.chiffre(6, "medC"));
        System.out.println(Cryptage.chiffre(6, "medD"));
        System.out.println("--------------");
    }
    
}
