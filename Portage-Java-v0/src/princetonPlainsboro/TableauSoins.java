/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kalma
 */
public class TableauSoins extends AbstractTableModel {
    //  private FicheDeSoins ficheSoins;

    private Vector<Acte> actes;

    private final String[] entetes = {"Nom de l'acte", "Code", "Coefficient", "Cout"};

    public TableauSoins(FicheDeSoins fiche) {
        super();
        // this.ficheSoins= fiche; 
        this.actes = fiche.getActes();
        //  this.ficheSoins.afficher();
        //  System.out.println(actes.size());
    }

    public int getRowCount() {
        return actes.size();
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                System.out.println(actes.get(rowIndex).getCode().afficherLibelle());
                return actes.get(rowIndex).getCode().afficherLibelle();
            case 1:
                System.out.println(actes.get(rowIndex).getCode().toString());
                return actes.get(rowIndex).getCode().afficherCode();
            case 2:
                return actes.get(rowIndex).getCoef();
            case 3:
                return actes.get(rowIndex).cout() + " euros";
            default:
                return null; //Ne devrait jamais arriver
        }

    }

    public void addActe(Acte acte) {
        actes.add(acte);

        fireTableRowsInserted(actes.size() - 1, actes.size() - 1);
    }

    public void removeActe(int rowIndex) {
        actes.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
