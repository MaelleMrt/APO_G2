/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import princetonPlainsboro.FicheDeSoins;



//calsse pour la liste des patient et leur liste de soins respectives 
public class TableauFichesSoins extends AbstractTableModel {
    private List<FicheDeSoins> ficheSoins;
 
    private final String[] entetes = {"Date","Service", "Cout"};
 
    public TableauFichesSoins(List<FicheDeSoins> fiche) {
      super();
      this.ficheSoins= fiche; 
//      for(FicheDeSoins fsi: ficheSoins){
//          this.addFicheSoins(fsi);
//      }
      
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
            case 2: 
                return ficheSoins.get(rowIndex).coutTotal() + " euros";
            default:
                return null; //Ne devrait jamais arriver
        }

    }
     public void addFicheSoins(FicheDeSoins ficheA) {
        ficheSoins.add(ficheA);
 
        fireTableRowsInserted(ficheSoins.size() -1, ficheSoins.size() -1);
    }
 
    public void removeFicheSoins(int rowIndex) {
        ficheSoins.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}

