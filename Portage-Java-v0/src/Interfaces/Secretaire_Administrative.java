package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import princetonPlainsboro.Hospital;
import princetonPlainsboro.LectureXMLHop;
import princetonPlainsboro.Patient;
import princetonPlainsboro.Medecin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maelle
 */
public class Secretaire_Administrative extends javax.swing.JFrame implements ListSelectionListener, ActionListener {

    /**
     * Creates new form SecrÃ©taire_Administrative
    */
        
    //création de l'hôpital pour pouvoir faire les tests
    LectureXMLHop test = new LectureXMLHop("hopital.xml");
    Hospital h = test.getHospital();
    
    public Secretaire_Administrative() {
        initComponents();      
        
        //initialisation de la liste patient (jlist2)
        DefaultListModel ModeleTest2 = new DefaultListModel();
        for (Patient p : h.getListPatient()) {
            ModeleTest2.addElement(p.getNom());
        }
        jList2.setModel(ModeleTest2);

        //initialisation de la liste médecin (jlist1)
        DefaultListModel ModeleTest1 = new DefaultListModel();
        for (Medecin m : h.getListMedecin()) {
            ModeleTest1.addElement(m.getNomComplet());
        }
        jList1.setModel(ModeleTest1);
        
        //initialisation de la JComboBox des patients
        jComboBox1.addItem(" ");
        for(Patient p : h.getListPatient()){
            jComboBox1.addItem(p.getNom());
        }
        
        //initialisation de la JComboBox des médecins
        jComboBox2.addItem(" ");
        for(Medecin m : h.getListMedecin()){
            jComboBox2.addItem(m.getNomComplet());
        }
        
        //actions associées aux JList
        jList1.addListSelectionListener(this);
        jList2.addListSelectionListener(this);
        
        //actions associées aux JComboBox
        jComboBox1.addActionListener(this);
        jComboBox2.addActionListener(this);
        
        //lecture des boutons
        jToggleButton1.addActionListener(this);
        jToggleButton2.addActionListener(this);
        jToggleButton3.addActionListener(this);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jToggleButton3 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 235, 186));

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(222, 31, 31));
        jLabel1.setText("Centre Hospitalier de Princeton Plainsboro");

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList2);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jToggleButton1.setFont(new java.awt.Font("Bell MT", 1, 13)); // NOI18N
        jToggleButton1.setText("Ajouter un patient");

        jToggleButton2.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        jToggleButton2.setText("Déconnexion");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        jToggleButton3.setText("Accès à l'ensemble des fiches soins");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jComboBox1, 0, 281, Short.MAX_VALUE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jToggleButton3)
                        .addGap(95, 95, 95)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jToggleButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton3))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //méthode permettant de définir l'action pour un élément de la liste sélectionnée
    public void valueChanged(ListSelectionEvent e){
        //affichage de la fiche du patient sélectionné dans la JList
        int j = jList2.getSelectedIndex();
        if(j != -1){
            Patient p = new Patient(h.getListPatient().get(j).getNom(),h.getListPatient().get(j).getPrenom(),h.getListPatient().get(j).getSecu(),h.getListPatient().get(j).getNaissance(),h.getListPatient().get(j).getCP());
            FichePatient fp = new FichePatient(p, h.getListPatient().get(j).getDossierMed());
            fp.setVisible(true);
            jList2.clearSelection();
        }
        //affichage de la fiche du médecin sélectionné dans la JList
        int k = jList1.getSelectedIndex();
        if(k != -1){
            Medecin m = new Medecin(h.getListMedecin().get(k).getNom(),h.getListMedecin().get(k).getPrenom(),h.getListMedecin().get(k).getSpecialite(),h.getListMedecin().get(k).getIdentifiant(),h.getListMedecin().get(k).getMdp(),h.getListMedecin().get(k).getNumeroTel());
            FicheMedecin fm = new FicheMedecin(m);
            fm.setVisible(true);
            jList1.clearSelection();
        }    
    }
    
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Secretaire_Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Secretaire_Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Secretaire_Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Secretaire_Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Hospital h = new Hospital("PrincetonBoro");
                new Secretaire_Administrative().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        //affichage de la fiche du patient sélectionné dans la JComboBox
        int j = jComboBox1.getSelectedIndex();
        if(j != 0){
            j = j - 1;
            Patient p = new Patient(h.getListPatient().get(j).getNom(),h.getListPatient().get(j).getPrenom(),h.getListPatient().get(j).getSecu(),h.getListPatient().get(j).getNaissance(),h.getListPatient().get(j).getCP() );
            FichePatient fp = new FichePatient(p, h.getListPatient().get(j).getDossierMed());
            fp.setVisible(true);
            jComboBox1.setSelectedIndex(0);
        }
        //affichage de la fiche du médecin sélectionné dans la JComboBox
        int k = jComboBox2.getSelectedIndex();
        if(k != 0){
            k = k - 1;
            Medecin m = new Medecin(h.getListMedecin().get(k).getNom(),h.getListMedecin().get(k).getPrenom(),h.getListMedecin().get(k).getSpecialite(),h.getListMedecin().get(k).getIdentifiant(),h.getListMedecin().get(k).getMdp(),h.getListMedecin().get(k).getNumeroTel());
            FicheMedecin fm = new FicheMedecin(m);
            fm.setVisible(true);
            jComboBox2.setSelectedIndex(0);
        }
        //action du bouton ajout d'un nouveau patient
        if(jToggleButton1.isSelected()){ //AjouterPatient prend en parametre une SA
//            AjouterPatient nouveauPatient = new AjouterPatient();
//            nouveauPatient.setVisible(true);
            jToggleButton1.setSelected(!jToggleButton1.isSelected());
        }
        //action d'ouverture de l'ensemble des fiches de soins
        if(jToggleButton3.isSelected()){
            AfficherFichesSoins listeFiches = new AfficherFichesSoins(h.getSA());
            listeFiches.setVisible(true);
             jToggleButton3.setSelected(!jToggleButton3.isSelected());
        }
        //action de déconnexion
        if(jToggleButton2.isSelected()){
            Connexion c = new Connexion(h);
            c.setVisible(true);
            this.setVisible(false);
        }
        

    }
}
