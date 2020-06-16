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
public class TestXMLHopital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LectureXMLHop test = new LectureXMLHop("hopital.xml");
        Hospital hop=test.getHospital();
        hop.afficherInfos();
        System.out.println("fiches de soins premier patient");
        System.out.println(hop.getListPatient().get(0).getNom());
        for(FicheDeSoins fs:hop.getListPatient().get(0).getDossierMed()){
           for(int i=0;i<fs.getActes().size();i++)
                System.out.println(fs.getActes().get(i).toString());        }
        
    }
    
}
