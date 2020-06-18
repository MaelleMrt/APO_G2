/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import princetonPlainsboro.Hospital;
import princetonPlainsboro.LectureXMLHop;
import princetonPlainsboro.Medecin;
import princetonPlainsboro.Patient;
import princetonPlainsboro.SecretaireAdministrative;
import princetonPlainsboro.SecretaireMedicale;

/**
 *
 * @author marin
 */
public class Secretaire_Medicale extends javax.swing.JFrame implements ListSelectionListener, ActionListener {

    //Hopital pour les tests
    LectureXMLHop test = new LectureXMLHop("hopital_1.xml");
    Hospital h = test.getHospital();
    
    //Attributs de la classe Secretaire_Medicale
    SecretaireAdministrative sa;      
    SecretaireMedicale secretaire;

    public Secretaire_Medicale(SecretaireAdministrative sa, SecretaireMedicale secretaire) {
        //Relecture de l'hopital.xml pour possible mise a jour de la base 
        LectureXMLHop test = new LectureXMLHop("hopital_1.xml");
        this.h = test.getHospital();
        
        //Initialisation des attributs de la classe Secretaire_Medicale
        this.sa = sa;
        this.secretaire = secretaire;
        
        initComponents();
              
        //Initialisation de la liste patient (jlist1)
        DefaultListModel ModeleTest2 = new DefaultListModel();
        for (Patient p : secretaire.getListP()) {
            ModeleTest2.addElement(p.getNom());
        }
        jList1.setModel(ModeleTest2);

        //Initialisation de la liste m�decin (jlist2)
        DefaultListModel ModeleTest1 = new DefaultListModel();
        for (Medecin m : h.getListMedecin()) {
            ModeleTest1.addElement(m.getNomComplet());
        }
        jList2.setModel(ModeleTest1);
        
        //Initialisation de la JComboBox des patients
        jComboBox1.addItem(" ");
        for(Patient p : secretaire.getListP()){
            jComboBox1.addItem(p.getNom());
        }
        
        //Initialisation de la JComboBox des m�decins
        jComboBox2.addItem(" ");
        for(Medecin m : h.getListMedecin()){
            jComboBox2.addItem(m.getNomComplet());
        }

        //Commandes pour les actions li�es aux listes, aux JComboBox et aux boutons
        jList2.addListSelectionListener(this);
        jComboBox1.addActionListener(this);
        jComboBox2.addActionListener(this);
        jToggleButton1.addActionListener(this);
        jToggleButton2.addActionListener(this);
        jToggleButton3.addActionListener(this);
        jToggleButton4.addActionListener(this);
        jToggleButton5.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jToggleButton4 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jToggleButton5 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 235, 186));

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(222, 31, 31));
        jLabel1.setText("Centre Hospitalier de Princeton Plainshoro");

        jList1.setFont(new java.awt.Font("Bell MT", 0, 12)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setFont(new java.awt.Font("Bell MT", 0, 12)); // NOI18N
        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel2.setFont(new java.awt.Font("Bell MT", 0, 13)); // NOI18N
        jLabel2.setText("Secr�taire m�dicale");

        jLabel3.setFont(new java.awt.Font("Bell MT", 0, 13)); // NOI18N
        jLabel3.setText(secretaire.getSpecialite().getNom());

        jToggleButton1.setFont(new java.awt.Font("Bell MT", 0, 13)); // NOI18N
        jToggleButton1.setText("Nouveau patient");
        jToggleButton1.setToolTipText("");
        jToggleButton1.setFocusable(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Bell MT", 0, 13)); // NOI18N
        jToggleButton2.setText("S�lectionner un patient et cliquer ici pour remplir une nouvelle fiche de soin");

        jToggleButton3.setFont(new java.awt.Font("Bell MT", 0, 13)); // NOI18N
        jToggleButton3.setText("Nouveau m�decin");
        jToggleButton3.setActionCommand("");

        jToggleButton4.setFont(new java.awt.Font("Bell MT", 0, 11)); // NOI18N
        jToggleButton4.setText("Deconnexion");

        jToggleButton5.setFont(new java.awt.Font("Bell MT", 0, 13)); // NOI18N
        jToggleButton5.setText("S�lectionner un patient et cliquer ici pour acc�der � sa fiche");

        jLabel5.setIcon(new javax.swing.ImageIcon("src/images/logo_petit.png"));
        jLabel5.setText("    ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToggleButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jToggleButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(138, 138, 138)
                                        .addComponent(jToggleButton4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3))))
                            .addComponent(jLabel2))))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToggleButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton1)
                        .addComponent(jToggleButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //methode permettant de definir l'action pour un element de la liste selectionnee
    public void valueChanged(ListSelectionEvent e){
        //Relecture de l'hopital.xml pour possible mise a jour de la base 
        LectureXMLHop test = new LectureXMLHop("hopital_1.xml");
        this.h = test.getHospital();
        
        //Code permettant l'affichage de la fiche du medecin selectionne dans la JList
        int k = jList2.getSelectedIndex(); //Donne l'indice de la ligne selectionnee
        if(k != -1){
            Medecin m = new Medecin(h.getListMedecin().get(k).getNom(),h.getListMedecin().get(k).getPrenom(),h.getListMedecin().get(k).getSpecialite(),h.getListMedecin().get(k).getIdentifiant(),h.getListMedecin().get(k).getMdp(),h.getListMedecin().get(k).getNumeroTel());
            FicheMedecin fm = new FicheMedecin(m); //Cr�ation de la ficheMedecin associee au medecin selectionne
            fm.setVisible(true); //Affichage de la ficheMedecin
            jList2.clearSelection();
        }    
    }
        
    
    
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

    }//GEN-LAST:event_jToggleButton1ActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SecretaireMedicale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SecretaireMedicale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SecretaireMedicale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SecretaireMedicale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                LectureXMLHop test = new LectureXMLHop("hopital_1.xml");
//                Hospital h = test.getHospital();
//                SecretaireAdministrative sa;
//                sa = h.getSA();
//                SecretaireMedicale s;
//                s = h.getListSM().get(0);
//                new Secretaire_Medicale(sa,s).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        //Relecture de l'hopital.xml pour possible mise a jour de la base 
        LectureXMLHop test = new LectureXMLHop("hopital_1.xml");
        this.h = test.getHospital();
        
        //Code permettant l'affichage de la fiche du patient selectionne dans la JComboBox
        int j = jComboBox1.getSelectedIndex();
        if(j != 0){
            j = j - 1;
            Patient p = new Patient(secretaire.getListP().get(j).getNom(),secretaire.getListP().get(j).getPrenom(),secretaire.getListP().get(j).getSecu(),secretaire.getListP().get(j).getNaissance(),secretaire.getListP().get(j).getCP() );
            FichePatient fp = new FichePatient(p, h.getListPatient().get(j).getDossierMed());
            fp.setVisible(true);
            jComboBox1.setSelectedIndex(0);
        }
        //Code permettant l'affichage de la fiche du medecin selectionne dans la JComboBox
        int k = jComboBox2.getSelectedIndex();
        if(k != 0){
            k = k - 1;
            Medecin m = new Medecin(h.getListMedecin().get(k).getNom(),h.getListMedecin().get(k).getPrenom(),h.getListMedecin().get(k).getSpecialite(),h.getListMedecin().get(k).getIdentifiant(),h.getListMedecin().get(k).getMdp(),h.getListMedecin().get(k).getNumeroTel());
            FicheMedecin fm = new FicheMedecin(m);
            fm.setVisible(true);
            jComboBox2.setSelectedIndex(0);
        }
        //Action du bouton permettant l'ajout d'un nouveau patient
        if(jToggleButton1.isSelected()){
            AjouterPatient nouveauPatient = new AjouterPatient(sa);
            nouveauPatient.setVisible(true); //Ouverture de l'interface AjouterPatient pour entrer toutes les infos du patient
            jToggleButton1.setSelected(!jToggleButton1.isSelected());
        }
        //Action du bouton permettant l'ajout d'un nouveau medecin 
        if(jToggleButton3.isSelected()){
            AjouterMedecin nouveauMedecin = new AjouterMedecin(sa,secretaire);
            nouveauMedecin.setVisible(true); //Ouverture de l'interface AjouterMedecin pour entrer toutes les infos du m�decin
            jToggleButton3.setSelected(!jToggleButton3.isSelected());
        }
        //Action du bouton permettant l'ajout d'une nouvelle fiche de soin
        if(jToggleButton2.isSelected()){
            int z = jList1.getSelectedIndex();
            if(z != -1){
                Patient p = new Patient(secretaire.getListP().get(z).getNom(),secretaire.getListP().get(z).getPrenom(),secretaire.getListP().get(z).getSecu(),secretaire.getListP().get(z).getNaissance(),secretaire.getListP().get(z).getCP() );
                AjouterFicheDeSoins fiche = new AjouterFicheDeSoins(p, secretaire);
                fiche.setVisible(true); //Ouverture de l'interface AjouterFicheDeSoins pour entrer toutes les infos de la nouvelle fiche de soin
                jToggleButton2.setSelected(!jToggleButton2.isSelected());                
            }
        }
        // Code permettant d'ouvrir la fiche du patient s�lectionn�e dans le tableau apr�s avoir cliqu� sur le bouton
        if(jToggleButton5.isSelected()){
            int z = jList1.getSelectedIndex(); //Donne l'indice de la ligne s�lectionn�e
            if(z != -1){
                Patient p = new Patient(secretaire.getListP().get(z).getNom(),secretaire.getListP().get(z).getPrenom(),secretaire.getListP().get(z).getSecu(),secretaire.getListP().get(z).getNaissance(),secretaire.getListP().get(z).getCP() );
                FichePatient fp = new FichePatient(p, secretaire.getListP().get(z).getDossierMed()); //Cr�ation de la fichePatient associ� au patient s�lectionn�
                fp.setVisible(true); //Affichage de la fichePatient
                jList1.clearSelection();
                jToggleButton5.setSelected(!jToggleButton5.isSelected());
            }    
        }
        //Action de deconnexion 
        if(jToggleButton4.isSelected()){
            Connexion c = new Connexion(h);
            c.setVisible(true);
            this.setVisible(false);
        }
    }
}
