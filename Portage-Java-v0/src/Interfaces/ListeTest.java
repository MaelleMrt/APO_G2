/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author kalma
 */


import java.util.List;
import javax.swing.table.AbstractTableModel;
import princetonPlainsboro.FicheDeSoins;

/**
 *
 * @author Maelle
 */
public class ListeTest extends AbstractTableModel {
    private final List<FicheDeSoins> ficheSoins;
 
    private final String[] entetes = {"Date","Servie"};
 
    public ListeTest(List<FicheDeSoins> fiche) {
      super();
      this.ficheSoins= fiche; 
      
    }
 
    public int getRowCount() {
        return ficheSoins.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return ficheSoins.get(rowIndex).getDate();
            case 1:
                return ficheSoins.get(rowIndex).getService();
           
            default:
                return null; //Ne devrait jamais arriver
        }

    }
     public void addConstante(FicheDeSoins ficheA) {
        ficheSoins.add(ficheA);
 
        fireTableRowsInserted(ficheSoins.size() -1, ficheSoins.size() -1);
    }
 
    public void removeConstante(int rowIndex) {
        ficheSoins.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}

