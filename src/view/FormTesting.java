/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.Testing;
import javax.swing.JOptionPane;

/**
 *
 * @author jodarove
 */
public class FormTesting extends javax.swing.JFrame {
    /**
     * Creates new form FormTesting
     */
    public FormTesting(){
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigoBarra = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnGetKilo = new javax.swing.JButton();
        btnConexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCodigoBarra.setText("Codigo:");

        btnGetKilo.setText("Mostrame el Kilo.");
        btnGetKilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetKiloActionPerformed(evt);
            }
        });

        btnConexion.setText("probar Conexion");
        btnConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConexion)
                    .addComponent(btnGetKilo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigoBarra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoBarra)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGetKilo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConexion)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetKiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetKiloActionPerformed
        String codigo = txtCodigo.getText();
        if (codigo.isEmpty()) {
            txtCodigo.requestFocus();
            JOptionPane.showMessageDialog(rootPane,"Por favor ingrese el codigo.", "Ingrese el codigo!", 0);
        }else{
            Testing test = new Testing();
            double kilo = test.getKilo(codigo);
            JOptionPane.showMessageDialog(rootPane, "El peso de su producto es: " + kilo + " kgs.", "El peso", 1);
        }
    }//GEN-LAST:event_btnGetKiloActionPerformed

    private void btnConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConexionActionPerformed

    }//GEN-LAST:event_btnConexionActionPerformed

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
            java.util.logging.Logger.getLogger(FormTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTesting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConexion;
    private javax.swing.JButton btnGetKilo;
    private javax.swing.JLabel lblCodigoBarra;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
