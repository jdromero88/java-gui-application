/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.CiudadController;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Ciudad;

/**
 *
 * @author jodarove
 */
public class CiudadControlForm extends javax.swing.JDialog {
    private static final String CLICK_CAJA_V2 = " | ClickCaja V 2.0";
    private Ciudad ciudad = null;
    private final String[] TITULOS = {"Código", "Nombre"};
    //Para filtrar
    private TableRowSorter<DefaultTableModel> sorter;
    
    private DefaultTableModel modelo;
    /**
     * Creates new form CiudadControlForm
     */
    public CiudadControlForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // centrar el form
        setLocationRelativeTo(null);
        // Desactiva el boton eliminar
        btnEliminar.setEnabled(false);
        //Agrupar botones
        ButtonGroup group = new ButtonGroup();
        group.add(rBtnCodigo);
        group.add(rBtnNombre);
        
        // rBtnNombre seleccionado por defecto y txtBuscar gana el foco
        rBtnNombre.setSelected(true);
        txtBuscar.requestFocus();
        try {
            cargarTabla();
        } catch (Exception e) {
            System.err.println("Algo paso al cargar tabla al iniciar el form: " + e);
        }
    }
    
    private void cargarTabla() throws Exception{
        String[] registro = new String[2];
        // Declaramos un arraylist de tipo Departamento
        ArrayList<Ciudad> ciudades;
        modelo = new DefaultTableModel(TITULOS, 0);
        try {
            // se asigna todas las ciudades a el arraylist ciudades
            ciudades = CiudadController.getAll();
            ciudades.stream().forEach((Ciudad ciu) -> {
                registro[0] = String.valueOf(ciu.getId());
                registro[1] = ciu.getNombre();
                modelo.addRow(registro);
            });
        } catch (Exception e) {
            System.err.println("Error al obtener las ciudades para cargar la tabla: " + e);
        }
        sorter = new TableRowSorter<>(modelo);
        tblCiudades.setRowSorter(sorter);
        tblCiudades.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rBtnCodigo = new javax.swing.JRadioButton();
        rBtnNombre = new javax.swing.JRadioButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCiudades = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(689, 468));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ciudades", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Buscar por:");

        rBtnCodigo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rBtnCodigo.setText("Cod.");
        rBtnCodigo.setToolTipText("Buscar por codigo.");

        rBtnNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rBtnNombre.setText("Nombre");

        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        tblCiudades.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblCiudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(tblCiudades);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBtnCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBtnNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rBtnCodigo)
                    .addComponent(rBtnNombre)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Abre formulario para agregar la ciudad");
        btnAgregar.setMaximumSize(new java.awt.Dimension(120, 32));
        btnAgregar.setMinimumSize(new java.awt.Dimension(120, 32));
        btnAgregar.setPreferredSize(new java.awt.Dimension(120, 32));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Abre formulario para editar la ciudad");
        btnEditar.setMaximumSize(new java.awt.Dimension(120, 32));
        btnEditar.setMinimumSize(new java.awt.Dimension(120, 32));
        btnEditar.setPreferredSize(new java.awt.Dimension(120, 32));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEliminar.setText("Elminar");
        btnEliminar.setToolTipText("Elimina la Ciudad");
        btnEliminar.setMaximumSize(new java.awt.Dimension(120, 32));
        btnEliminar.setMinimumSize(new java.awt.Dimension(120, 32));
        btnEliminar.setPreferredSize(new java.awt.Dimension(120, 32));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setToolTipText("Imprime lista de ciudades");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setToolTipText("Cierra esta ventana.");
        btnCerrar.setMaximumSize(new java.awt.Dimension(120, 32));
        btnCerrar.setMinimumSize(new java.awt.Dimension(120, 32));
        btnCerrar.setPreferredSize(new java.awt.Dimension(120, 32));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        imprimir();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        cerrar();
    }//GEN-LAST:event_btnCerrarActionPerformed
    

    private Boolean seleccionarCiudad() throws Exception{
        int filaSeleccionada = tblCiudades.getSelectedRow();
        if(filaSeleccionada == -1){
            JOptionPane.showMessageDialog(rootPane, "No hay departamento seleccionado", "Informacion", JOptionPane.ERROR_MESSAGE);
            return false;
        } else{
            String valorCelda = (String)tblCiudades.getValueAt(filaSeleccionada, 0);
            int ciudadId = Integer.valueOf(valorCelda);
            ciudad = CiudadController.get(ciudadId);
            return true;
        }
    }
    private void eliminar(){
        try {
            if(seleccionarCiudad()){
                if (JOptionPane.showConfirmDialog(this, "Esta seguro que desea eliminar la ciudad?") == 0) {
                    CiudadController.delete(ciudad);
                    JOptionPane.showMessageDialog(rootPane, "Ciudad eliminada", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                tblCiudades.clearSelection();
                txtBuscar.requestFocus();
            }
        } catch (Exception e) {
            System.err.println("Algo paso al eliminar ciudad " + e);
        }
    }
    private void imprimir(){
        JOptionPane.showMessageDialog(rootPane, "Aqui mostramos reporte lista de ciudades");
    }
    private void cerrar(){
        this.dispose();
    }
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
            java.util.logging.Logger.getLogger(CiudadControlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CiudadControlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CiudadControlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CiudadControlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CiudadControlForm dialog = new CiudadControlForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rBtnCodigo;
    private javax.swing.JRadioButton rBtnNombre;
    private javax.swing.JTable tblCiudades;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
