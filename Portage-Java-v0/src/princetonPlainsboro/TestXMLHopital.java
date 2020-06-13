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
    }
    
}
