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
import princetonPlainsboro.SecretaireAdministrative;

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

    //Attribut de la classe Secretaire_Administrative
    SecretaireAdministrative sa;

    //creation de l'hopital pour pouvoir faire les tests
    LectureXMLHop test = new LectureXMLHop("hopital_1.xml");
    Hospital h = test.getHospital();

    public Secretaire_Administrative(SecretaireAdministrative sa) {
        //Relecture de l'hopital.xml pour possible mise a jour de la base 
        LectureXMLHop test = new LectureXMLHop("hopital_1.xml");
        this.h = test.getHospital();

        //Initialisation de l'attribut de la classe Secretaire_Medicale
        this.sa = sa;

        initComponents();

        //Initialisation de la liste patient (jlist2)
        DefaultListModel ModeleTest2 = new DefaultListModel();
        for (Patient p : h.getListPatient()) {
            ModeleTest2.addElement(p.getNom());
        }
        jList2.setModel(ModeleTest2);

        //Initialisation de la liste médecin (jlist1)
        DefaultListModel ModeleTest1 = new DefaultListModel();
        for (Medecin m : h.getListMedecin()) {
            ModeleTest1.addElement(m.getNomComplet());
        }
        jList1.setModel(ModeleTest1);

        //Initialisation de la JComboBox des patients
        jComboBox1.addItem(" ");
        for (Patient p : h.getListPatient()) {
            jComboBox1.addItem(p.getNom());
        }

        //Initialisation de la JComboBox des médecins
        jComboBox2.addItem(" ");
        for (Medecin m : h.getListMedecin()) {
            jComboBox2.addItem(m.getNomComplet());
        }

        //Commandes pour les actions liées aux listes, aux JComboBox et aux boutons
        jList1.addListSelectionListener(this);
        jList2.addListSelectionListener(this);
        jComboBox1.addActionListener(this);
        jComboBox2.addActionListener(this);
        jToggleButton1.addActionListener(this);
        jToggleButton2.addActionListener(this);
        jToggleButton3.addActionListener(this);
        jToggleButton4.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToggleButton4 = new javax.swing.JToggleButton();
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
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 235, 186));

        jToggleButton4.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        jToggleButton4.setText("Ajouter medecin ");

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

        jComboBox1.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Noms des patients" }));

        jComboBox2.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Noms des medecins" }));

        jToggleButton3.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        jToggleButton3.setText("Accès à l'ensemble des fiches soins");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("src/images/logo_petit.png"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jToggleButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(jToggleButton3)
                                .addGap(30, 30, 30)
                                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jComboBox1, 0, 281, Short.MAX_VALUE))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jToggleButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
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
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //méthode permettant de définir l'action pour un élément de la liste sélectionnée
    public void valueChanged(ListSelectionEvent e) {
        //Relecture de l'hopital.xml pour possible mise a jour de la base 
        LectureXMLHop test = new LectureXMLHop("hopital_1.xml");
        this.h = test.getHospital();
        
        //Code permettant l'affichage de la fiche du patient sélectionné dans la JList
        int j = jList2.getSelectedIndex(); //Donne l'indice de la ligne sélectionnée
        if (j != -1) {
            Patient p = new Patient(h.getListPatient().get(j).getNom(), h.getListPatient().get(j).getPrenom(), h.getListPatient().get(j).getSecu(), h.getListPatient().get(j).getNaissance(), h.getListPatient().get(j).getCP());
            FichePatient fp = new FichePatient(p, h.getListPatient().get(j).getDossierMed()); //Création de la fichePatient associé au patient sélectionné
            fp.setVisible(true); //Affichage de la fichePatient
            jList2.clearSelection();
        }
        //Code permettant l'affichage de la fiche du médecin sélectionné dans la JList
        int k = jList1.getSelectedIndex(); //Donne l'indice de la ligne sélectionnée
        if (k != -1) {
            Medecin m = new Medecin(h.getListMedecin().get(k).getNom(), h.getListMedecin().get(k).getPrenom(), h.getListMedecin().get(k).getSpecialite(), h.getListMedecin().get(k).getIdentifiant(), h.getListMedecin().get(k).getMdp(), h.getListMedecin().get(k).getNumeroTel());
            FicheMedecin fm = new FicheMedecin(m); //Création de la ficheMedecin associé au médecin sélectionné
            fm.setVisible(true); //Affichage de la ficheMedecin
            jList1.clearSelection();
        }
    }

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton3ActionPerformed

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
//            java.util.logging.Logger.getLogger(Secretaire_Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Secretaire_Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Secretaire_Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Secretaire_Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                //new Secretaire_Administrative(sa).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        //Relecture de l'hopital.xml pour possible mise a jour de la base 
        LectureXMLHop test = new LectureXMLHop("hopital_1.xml");
        this.h = test.getHospital();

        //Code permettant l'affichage de la fiche du patient sélectionné dans la JComboBox
        int j = jComboBox1.getSelectedIndex();
        if (j != 0) {
            j = j - 1;
            Patient p = new Patient(h.getListPatient().get(j).getNom(), h.getListPatient().get(j).getPrenom(), h.getListPatient().get(j).getSecu(), h.getListPatient().get(j).getNaissance(), h.getListPatient().get(j).getCP());
            FichePatient fp = new FichePatient(p, h.getListPatient().get(j).getDossierMed());
            fp.setVisible(true);
            jComboBox1.setSelectedIndex(0);
        }
        //Code permettant l'affichage de la fiche du médecin sélectionné dans la JComboBox
        int k = jComboBox2.getSelectedIndex();
        if (k != 0) {
            k = k - 1;
            Medecin m = new Medecin(h.getListMedecin().get(k).getNom(), h.getListMedecin().get(k).getPrenom(), h.getListMedecin().get(k).getSpecialite(), h.getListMedecin().get(k).getIdentifiant(), h.getListMedecin().get(k).getMdp(), h.getListMedecin().get(k).getNumeroTel());
            FicheMedecin fm = new FicheMedecin(m);
            fm.setVisible(true);
            jComboBox2.setSelectedIndex(0);
        }
        //Action du bouton permettant l'ajout d'un nouveau patient
        if (jToggleButton1.isSelected()) {
            AjouterPatient nouveauPatient = new AjouterPatient(sa);
            nouveauPatient.setVisible(true); //Ouverture de l'interface AjouterPatient pour entrer toutes les infos du patient
            jToggleButton1.setSelected(!jToggleButton1.isSelected());
        }
        //Action du bouton permettant d'afficher toutes les fiches de soins 
        if (jToggleButton3.isSelected()) {
            AfficherFichesSoins listeFiches = new AfficherFichesSoins(sa);
            listeFiches.setVisible(true); //Ouverture de l'interface AjouterPatient pour entrer toutes les infos du médecin
            jToggleButton3.setSelected(!jToggleButton3.isSelected());
        }
        //Action du bouton permettant l'ajout d'un nouveau medecin 
        if(jToggleButton4.isSelected()){
            AjouterMedecin nouveauMedecin = new AjouterMedecin(sa);
            nouveauMedecin.setVisible(true); //Ouverture de l'interface AjouterMedecin pour entrer toutes les infos du médecin
            jToggleButton4.setSelected(!jToggleButton4.isSelected());
        }
        //Action de déconnexion
        if (jToggleButton2.isSelected()) {
            Connexion c = new Connexion(h);
            c.setVisible(true);
            this.dispose();
        }

    }
}
