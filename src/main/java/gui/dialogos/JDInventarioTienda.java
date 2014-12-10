package gui.dialogos;

//import almacen.DAO.DAOFactura;
//import almacen.Modelos.ModeloTablaFacturaPendientes;
import gui.paneles.Distribuidora1;
import util.JavaUtil;
import java.awt.HeadlessException;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelos.mapeos.InventarioTienda;
import modelos.tablas.TableModelReport;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JDInventarioTienda extends javax.swing.JDialog {

    public InventarioTienda inv = null;
    private int pos = -1;
     public final File  archivo = new File(this.getClass().getResource("/JavaHelp/JavaHelp/ejemplo.hs").getFile());


    public JDInventarioTienda(java.awt.Frame parent, boolean modal,
            final List<List> inventarioTienda) throws Exception {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        //activar JavaHelp
        ayudaActionPerformed(null);
        //busy
        busy.setVisible(false);
        this.jtableListaProductosInventarioTienda.setAutoCreateRowSorter(true);
        this.jtableListaProductosInventarioTienda.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.jtableListaProductosInventarioTienda.setColumnControlVisible(true);

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
                            inv = (InventarioTienda) inventarioTienda.get(pos);

                        }
                    }
                });

        listarFacturas(inventarioTienda);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_AceptarProductoSeleccionado_ = new javax.swing.JButton();
        botonCancelarExit_ = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableListaProductosInventarioTienda = new org.jdesktop.swingx.JXTable();
        txtTitulo = new javax.swing.JLabel();
        jXBarraBusquedaProductosEntrantes = new org.jdesktop.swingx.JXFindBar(jtableListaProductosInventarioTienda.getSearchable());
        imprimir_InventarioTiendas_ = new javax.swing.JButton();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        ayuda = new javax.swing.JButton();
        jMenuBarDialogoInV = new javax.swing.JMenuBar();
        jMenuOpciones = new javax.swing.JMenu();
        jMenu_Ayuda_ = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        boton_AceptarProductoSeleccionado_.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        boton_AceptarProductoSeleccionado_.setText("Aceptar");
        boton_AceptarProductoSeleccionado_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_AceptarProductoSeleccionado_ActionPerformed(evt);
            }
        });

        botonCancelarExit_.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botonCancelarExit_.setText("Cancelar");
        botonCancelarExit_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarExit_ActionPerformed(evt);
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

        imprimir_InventarioTiendas_.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        imprimir_InventarioTiendas_.setText("Imprimir");
        imprimir_InventarioTiendas_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimir_InventarioTiendas_ActionPerformed(evt);
            }
        });

        busy.setText("Generando Archivo!!!");

        ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416510931_Help.png"))); // NOI18N
        ayuda.setBorder(null);
        ayuda.setBorderPainted(false);
        ayuda.setContentAreaFilled(false);
        ayuda.setDefaultCapable(false);
        ayuda.setFocusPainted(false);
        ayuda.setFocusable(false);
        ayuda.setRequestFocusEnabled(false);
        ayuda.setVerifyInputWhenFocusTarget(false);
        ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaActionPerformed(evt);
            }
        });

        jMenuOpciones.setText("Opciones");
        jMenuBarDialogoInV.add(jMenuOpciones);

        jMenu_Ayuda_.setText("Ayuda");
        jMenuBarDialogoInV.add(jMenu_Ayuda_);

        setJMenuBar(jMenuBarDialogoInV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXBarraBusquedaProductosEntrantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonCancelarExit_, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(imprimir_InventarioTiendas_, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton_AceptarProductoSeleccionado_, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(txtTitulo)
                .addGap(34, 34, 34)
                .addComponent(ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ayuda)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXBarraBusquedaProductosEntrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_AceptarProductoSeleccionado_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonCancelarExit_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imprimir_InventarioTiendas_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_AceptarProductoSeleccionado_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_AceptarProductoSeleccionado_ActionPerformed
        SeleccionarFactura();
    }//GEN-LAST:event_boton_AceptarProductoSeleccionado_ActionPerformed

    private void botonCancelarExit_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarExit_ActionPerformed
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_botonCancelarExit_ActionPerformed

    private void jtableListaProductosInventarioTiendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableListaProductosInventarioTiendaMouseClicked
        if (evt.getClickCount() == 2) {
            SeleccionarFactura();
        }
    }//GEN-LAST:event_jtableListaProductosInventarioTiendaMouseClicked

    private void imprimir_InventarioTiendas_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimir_InventarioTiendas_ActionPerformed

        Thread hilo = new Thread() {

            @Override
            public void run() {

                busy.setEnabled(true);
                busy.setVisible(true);
                busy.setBusy(true);
                try {

                    JasperPrint jasperPrint = null;

                    Map<String, Object> parametro = new HashMap<>();
                    String s = "";                                      //jtableListaProductosInventarioTienda
                    TableModelReport dataSourse = new TableModelReport(jtableListaProductosInventarioTienda.getModel());
                    parametro.put("REPORT_DATA_SOURSE", dataSourse);
                    //JasperCompileManager.compileReport(rutaJrxml);
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/reportes/ListadoInventarioTienda.jasper"));

                    jasperPrint = JasperFillManager.fillReport(reporte, null, dataSourse);
                    JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                    jasperViewer.setTitle("Reporte de Toma Fisica Distribuidoras.");
                    jasperViewer.setVisible(true);
                    int respuesta = JOptionPane.showConfirmDialog(null, "El Archivo fue Generado con Exito,"
                            + "¿Desea Continuar Selecionando Una Factura Pendiente?");

                    if (respuesta == JOptionPane.YES_OPTION) {

                    }
                    if (respuesta == JOptionPane.NO_OPTION) {

                        setVisible(false);
                        jasperViewer.requestFocus();
                    }

                } catch (JRException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Se a Dectectado Un Proble Con Proceso de Seleccion de Facturas,"
                            + "Por Favor Vuelva a Intentarlo.");
                    Logger.getLogger(Distribuidora1.class.getName()).log(Level.SEVERE, null, e);
                    System.err.println("Seleccionando Facturas" + e);

                }
                //busy
                busy.setEnabled(false);
                busy.setVisible(false);
                busy.setBusy(false);

            }
        };
        hilo.start();


    }//GEN-LAST:event_imprimir_InventarioTiendas_ActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed

        try {
            URL hsURL = archivo.toURI().toURL();

            HelpSet helpset = null;
            helpset = new HelpSet(null, hsURL);

            HelpSet.Presentation hsp;
            hsp = helpset.getPresentation("MainWin");

            HelpBroker help_browser = helpset.createHelpBroker();
            help_browser.setHelpSetPresentation(hsp);

            // Cuando pulsemos F1 se mostrará la ayuda de la página de introducion
            help_browser.enableHelpOnButton(this.ayuda, "introduction", helpset);
            help_browser.enableHelpKey(getContentPane(), "introduction", helpset);

        } catch (HelpSetException | MalformedURLException ex) {
            Logger.getLogger(JDFacturasPendientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Excepcion Ayuda Factura " + ex);
            System.err.println("Excepcion Ayuda Factura " + ex);
        }
    }//GEN-LAST:event_ayudaActionPerformed

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
    private javax.swing.JButton ayuda;
    private javax.swing.JButton botonCancelarExit_;
    private javax.swing.JButton boton_AceptarProductoSeleccionado_;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JButton imprimir_InventarioTiendas_;
    private javax.swing.JMenuBar jMenuBarDialogoInV;
    private javax.swing.JMenu jMenuOpciones;
    private javax.swing.JMenu jMenu_Ayuda_;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXFindBar jXBarraBusquedaProductosEntrantes;
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
//       
        JavaUtil.displayResult(inventarioTienda, jtableListaProductosInventarioTienda);
        jtableListaProductosInventarioTienda.setEditable(false);
        pos = -1;
        inv = null;
    }
}
