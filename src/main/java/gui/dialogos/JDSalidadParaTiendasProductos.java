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
import modelos.mapeos.SalidaParaTienda;
import modelos.mapeos.SalidaParaTiendaDetalle;

public class JDSalidadParaTiendasProductos extends javax.swing.JDialog {

    // ModeloTablaFacturaPendientes mtf = new ModeloTablaFacturaPendientes();
    // DAOFactura daoFactura = new DAOFactura();
    public  SalidaParaTiendaDetalle  sd = null;
    //public List<List> productosInventario =null;       
   // private List resultList = null;
    private int pos = -1;
    

    public JDSalidadParaTiendasProductos(java.awt.Frame parent, boolean modal, 
            final List resultListSalidadParaTienda)throws Exception{
         super(parent, modal);
        initComponents();
        //jtListaEntradaProveedor.setModel(resulList);
        this.setLocationRelativeTo(null);
        // this.resultList = inventarioTienda;
        this.jtableListaProductosInventarioTienda.setAutoCreateRowSorter(true);
        this.jtableListaProductosInventarioTienda.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.jtableListaProductosInventarioTienda.setColumnControlVisible(true);
        //this.productosInventario = inventarioTienda;
        jtableListaProductosInventarioTienda.getSelectionModel()
                .addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {

                    pos = jtableListaProductosInventarioTienda.getSelectedRow();
                    if (pos == -1) {
                        sd = null;
                        return;
                    }
                    sd =  (SalidaParaTiendaDetalle) resultListSalidadParaTienda.get(pos);

                }
            }
        });

        listarFacturas(resultListSalidadParaTienda);
    }

 private void SeleccionarFactura() {

        try {
            if (sd != null) {
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un Producto Del Inventario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error de Coneccion : " + e);
        }

    }

    private void listarFacturas(List  resultListSalidadParaTienda) {
        JavaUtil.displayResult(resultListSalidadParaTienda, jtableListaProductosInventarioTienda);
        jtableListaProductosInventarioTienda.setEditable(false);
        pos = -1;
        sd = null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableListaProductosInventarioTienda = new org.jdesktop.swingx.JXTable();
        jLabel7 = new javax.swing.JLabel();
        jXFindBar1 = new org.jdesktop.swingx.JXFindBar(jtableListaProductosInventarioTienda.getSearchable());
        labelAyuda = new org.jdesktop.swingx.JXLabel();
        txtTitulo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("Productos");

        labelAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416510931_Help.png"))); // NOI18N
        labelAyuda.setText("Ayuda");
        labelAyuda.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelAyuda.setTextAlignment(null);
        labelAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAyudaMouseClicked(evt);
            }
        });

        txtTitulo.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(102, 102, 102));
        txtTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415416322_list-accept.png"))); // NOI18N
        txtTitulo.setText("Producto Salidad Para Tiendas");

        jButton3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton3.setText("Imprimir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(137, 137, 137)
                        .addComponent(txtTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXFindBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(408, 408, 408)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(labelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXFindBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SeleccionarFactura();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtableListaProductosInventarioTiendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableListaProductosInventarioTiendaMouseClicked
        if (evt.getClickCount() == 2) {
            SeleccionarFactura();
        }
    }//GEN-LAST:event_jtableListaProductosInventarioTiendaMouseClicked

    private void labelAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAyudaMouseClicked
        if(evt.getClickCount()==1){
            JOptionPane.showMessageDialog(null, "Mensaje");
            System.err.println("Mesaje_Ayuda");
            //  JOptionPane.showInternalMessageDialog(this, evt, null, WIDTH);

        }

    }//GEN-LAST:event_labelAyudaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXFindBar jXFindBar1;
    private org.jdesktop.swingx.JXTable jtableListaProductosInventarioTienda;
    private org.jdesktop.swingx.JXLabel labelAyuda;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables

   
}
