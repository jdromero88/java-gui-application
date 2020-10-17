package view;

import controller.DepartamentoController;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Departamento;

/**
 *
 * @author jodarove
 */
public class DepartamentoControlForm extends javax.swing.JDialog {
    private static final String CLICK_CAJA_V2 = " | ClickCaja V 2.0";
    private Departamento departamento = null;
    private final String[] TITULOS = {"Código", "Nombre"};
    //Para filtrar
    private TableRowSorter<DefaultTableModel> sorter;
    
    private DefaultTableModel modelo;
    /**
     * Creates new form DepartamentoControlForm
     */
    public DepartamentoControlForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // centrar el form
        setLocationRelativeTo(null);
        
        // Desactivamos boton agregar y eliminar
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(false);
        // Agrupa los botons
        ButtonGroup group = new ButtonGroup();
        group.add(rBtnCodigo);
        group.add(rBtnNombre);
        
        // Al abrir rBtnSeleccionado y txtBuscar gana el foco
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
        ArrayList<Departamento> departamentos;
        modelo = new DefaultTableModel(TITULOS, 0);
        try {
            // asignamos todos los departamentos a el arraylist departamentos
            departamentos = DepartamentoController.getAll();
            departamentos.stream().forEach((Departamento depto) -> {
                registro[0] = String.valueOf(depto.getId());
                registro[1] = depto.getNombre();
                modelo.addRow(registro);
            });
            
        } catch (Exception e) {
            System.err.println("Error al obtener los departamentos para cargar la tabla: " + e);
        }
        sorter = new TableRowSorter<>(modelo);
        tblDepartamentos.setRowSorter(sorter);
        tblDepartamentos.setModel(modelo);
    }
    
    private void filtrarTabla(String textoBuscado){
        RowFilter<DefaultTableModel, Object> rf = null;
        try {
            if(rBtnNombre.isSelected()){
                // (?i) inicia modo case insentivo
                // (?-i) termina modo case sensitivo
                rf = RowFilter.regexFilter("(?i)" + textoBuscado, 1);
            }
            if(rBtnCodigo.isSelected()){
                // (?i) inicia modo case insentivo
                // (?-i) termina modo case sensitivo
                rf = RowFilter.regexFilter(textoBuscado, 0);
            }            
            
        } catch (Exception e) {
            System.err.println("Algo paso en filtrar tabla: " + e);
            return;
        }
        sorter.setRowFilter(rf);
    }
    
    private Boolean seleccionarDepartamento() throws Exception{
        int filaSeleccionada = tblDepartamentos.getSelectedRow();
        if(filaSeleccionada == -1){
            JOptionPane.showMessageDialog(rootPane, "No hay departamento seleccionado", "Informacion", JOptionPane.ERROR_MESSAGE);
            return false;
        } else{
            String valorCelda = (String)tblDepartamentos.getValueAt(filaSeleccionada, 0);
            int departamentoId = Integer.valueOf(valorCelda);
            departamento = DepartamentoController.get(departamentoId);
            return true;
        }
    }
    private void limpiarTxtBuscar(){
        txtBuscar.setText(null);
        txtBuscar.requestFocus();
        try {
            cargarTabla();
        } catch (Exception e) {
            Logger.getLogger(DepartamentoControlForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void agregar(){
        DepartamentoForm abrir = new DepartamentoForm(null, true);
        abrir.setTitle("Agregar Departamento " + CLICK_CAJA_V2);
        abrir.setVisible(true);
        try {
            cargarTabla();
        } catch (Exception e) {
            System.err.println("Algo paso al intentar cargar la tabla despues de agregar: " + e);
        }
    }
    
    private void editar(){
        try {
            if(seleccionarDepartamento()){
                DepartamentoForm abrir = new DepartamentoForm(null, true, departamento);
                abrir.setTitle("Editar Departamento" + CLICK_CAJA_V2);
                abrir.setVisible(true);
                limpiarTxtBuscar();
                cargarTabla();
            }   
        } catch (Exception e) {
            Logger.getLogger(DepartamentoControlForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void eliminar(){
        try {
            if (seleccionarDepartamento()) {
                if (JOptionPane.showConfirmDialog(this, "Esta seguro que desea eliminar el departamento?") == 0) {
                    DepartamentoController.delete(departamento);
                    JOptionPane.showMessageDialog(rootPane, "Departamento eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
                    cargarTabla();
                }
                tblDepartamentos.clearSelection();
                txtBuscar.requestFocus();
            }
        } catch (Exception e) {
            Logger.getLogger(DepartamentoControlForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void cerrar(){
        this.dispose();
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
        tblDepartamentos = // desactivar edicion de celdas
        tblDepartamentos = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Departamentos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Buscar por:");

        rBtnCodigo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rBtnCodigo.setText("Cod.");
        rBtnCodigo.setToolTipText("Codigo");

        rBtnNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rBtnNombre.setText("Nombre");
        rBtnNombre.setToolTipText("Nombre");

        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtBuscar.setToolTipText("Ingrese texto para buscar...");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblDepartamentos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(tblDepartamentos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBtnCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBtnNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Agregar Departamento");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Editar Departamento");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Eliminar Departamento");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnImprimir.setText("Imprimir");

        btnCerrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        cerrar();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String textoBuscado = txtBuscar.getText();
        filtrarTabla(textoBuscado);
    }//GEN-LAST:event_txtBuscarKeyReleased

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
            java.util.logging.Logger.getLogger(DepartamentoControlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartamentoControlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartamentoControlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartamentoControlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DepartamentoControlForm dialog = new DepartamentoControlForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblDepartamentos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
