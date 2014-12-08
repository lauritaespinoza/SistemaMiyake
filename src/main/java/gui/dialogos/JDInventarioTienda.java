package gui.dialogos;

//import almacen.DAO.DAOFactura;
//import almacen.Modelos.ModeloTablaFacturaPendientes;
import util.JavaUtil;
import hibernate.DAO.ObjectModelDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelos.mapeos.Factura;
import modelos.mapeos.InventarioTienda;

public class JDInventarioTienda extends javax.swing.JDialog {

    // ModeloTablaFacturaPendientes mtf = new ModeloTablaFacturaPendientes();
    // DAOFactura daoFactura = new DAOFactura();
    public InventarioTienda inv = null;
    //public List<List> productosInventario =null;       
   // private List resultList = null;
    private int pos = -1;
    

    public JDInventarioTienda(java.awt.Frame parent, boolean modal, 
            final List<List> inventarioTienda)throws Exception{
         super(parent, modal);
        initComponents();
        //jtListaEntradaProveedor.setModel(resulList);
        this.setLocationRelativeTo(null);
         this.jtableListaProductosInventarioTienda.setAutoCreateRowSorter(true);
        this.jtableListaProductosInventarioTienda.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.jtableListaProductosInventarioTienda.setColumnControlVisible(true);
        
        // this.resultList = inventarioTienda;
        //this.productosInventario = inventarioTienda;
        jtableListaProductosInventarioTienda.getSelectionModel()
                .addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {

                    pos = jtableListaProductosInventarioTienda.getSelectedRow();
                    if (pos == -1) {
                        inv = null;
                        return;
                    }
                    inv =  (InventarioTienda) inventarioTienda.get(pos);

                }
            }
        });

        listarFacturas(inventarioTienda);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAceptarProductoSeleccionado = new javax.swing.JButton();
        botonCancelarExit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableListaProductosInventarioTienda = new org.jdesktop.swingx.JXTable();
        txtTitulo = new javax.swing.JLabel();
        jXBarraBusquedaProductosEntrantes = new org.jdesktop.swingx.JXFindBar(jtableListaProductosInventarioTienda.getSearchable());
        jButton1 = new javax.swing.JButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonAceptarProductoSeleccionado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botonAceptarProductoSeleccionado.setText("Aceptar");
        botonAceptarProductoSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarProductoSeleccionadoActionPerformed(evt);
            }
        });

        botonCancelarExit.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botonCancelarExit.setText("Cancelar");
        botonCancelarExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarExitActionPerformed(evt);
            }
        });

        jtableListaProductosInventarioTienda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtableListaProductosInventarioTienda.setSortable(false);
        jtableListaProductosInventarioTienda.getTableHeader().setReorderingAllowed(false);
        jtableListaProductosInventarioTienda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableListaProductosInventarioTiendaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtableListaProductosInventarioTienda);

        txtTitulo.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(102, 102, 102));
        txtTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415416322_list-accept.png"))); // NOI18N
        txtTitulo.setText("PRODUCTOS EXISTENTES EN INVENTARIO");

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setText("Imprimir");

        jXLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416510931_Help.png"))); // NOI18N
        jXLabel1.setText("Ayuda");
        jXLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXBarraBusquedaProductosEntrantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonCancelarExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(150, 150, 150)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAceptarProductoSeleccionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jXBarraBusquedaProductosEntrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAceptarProductoSeleccionado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonCancelarExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarProductoSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarProductoSeleccionadoActionPerformed
        SeleccionarFactura();
    }//GEN-LAST:event_botonAceptarProductoSeleccionadoActionPerformed

    private void botonCancelarExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarExitActionPerformed
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_botonCancelarExitActionPerformed

    private void jtableListaProductosInventarioTiendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableListaProductosInventarioTiendaMouseClicked
        if (evt.getClickCount() == 2) {
            SeleccionarFactura();
        }
    }//GEN-LAST:event_jtableListaProductosInventarioTiendaMouseClicked

    private void jXLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel1MouseClicked
        if(evt.getClickCount()==1){
            JOptionPane.showMessageDialog(null, "Mensaje");
            System.err.println("Mesaje_Ayuda");
            //  JOptionPane.showInternalMessageDialog(this, evt, null, WIDTH);

        }
    }//GEN-LAST:event_jXLabel1MouseClicked

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
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JDInventarioTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                JDInventarioTienda dialog = null;
//                try {
//               //     dialog = new JDInventarioTienda(new javax.swing.JFrame(), true);
//                } catch (Exception ex) {
//                    Logger.getLogger(JDInventarioTienda.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptarProductoSeleccionado;
    private javax.swing.JButton botonCancelarExit;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXFindBar jXBarraBusquedaProductosEntrantes;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXTable jtableListaProductosInventarioTienda;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables

    private void SeleccionarFactura() {

        try {
            if (inv != null) {
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un Producto Del Inventario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error de Coneccion : " + e);
        }

    }

    private void listarFacturas(List<List> inventarioTienda) {
// try {
//            mtf.setListaFactura(daoFactura.listarFacturaPendientes());
//                     
//            mtf.fireTableDataChanged();
//        } catch (Exception ex) {
//            Logger.getLogger(JDFacturasPendientes.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //String sql = "select ep.idFactura from EntradaProveedor ep where ep.estatus='Pendiente'";
        // String sql = "";
        //resultList = ObjectModelDAO.getResultQuery(sql);
       
        JavaUtil.displayResult(inventarioTienda, jtableListaProductosInventarioTienda);
        jtableListaProductosInventarioTienda.setEditable(false);
        pos = -1;
        inv = null;
    }
}
