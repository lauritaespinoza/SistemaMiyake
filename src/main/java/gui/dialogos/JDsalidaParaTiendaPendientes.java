package gui.dialogos;

//import almacen.DAO.DAOFactura;
//import almacen.Modelos.ModeloTablaFacturaPendientes;
import gui.paneles.Distribuidora1;
import util.JavaUtil;
import hibernate.DAO.ObjectModelDAO;
import java.awt.HeadlessException;
import java.io.File;
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
import modelos.mapeos.Almacen;
import modelos.mapeos.SalidaParaTienda;
import modelos.tablas.TableModelReport;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JDsalidaParaTiendaPendientes extends javax.swing.JDialog {

    // ModeloTablaFacturaPendientes mtf = new ModeloTablaFacturaPendientes();
    // DAOFactura daoFactura = new DAOFactura();
    public SalidaParaTienda sa = null;
    private List resultList = null;
    private int pos = -1;
    private Almacen al_actual = null;
     public final File  archivo = new File(this.getClass().getResource("/JavaHelp/JavaHelp/ejemplo.hs").getFile());

    public JDsalidaParaTiendaPendientes(java.awt.Frame parent, boolean modal, Almacen idAlmacen) throws Exception {
        super(parent, modal);
        initComponents();
        //jtListaEntradaProveedor.setModel(resulList);
        this.setLocationRelativeTo(null);
        
         this.jtListaSalidaPendientes_.setAutoCreateRowSorter(true);
        this.jtListaSalidaPendientes_.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.jtListaSalidaPendientes_.setColumnControlVisible(true);
        
        this.al_actual = idAlmacen;
        jtListaSalidaPendientes_.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {

                    pos = jtListaSalidaPendientes_.getSelectedRow();
                    if (pos == -1) {
                        sa = null;
                        return;
                    }
                    sa = ((SalidaParaTienda) resultList.get(pos));

                }
            }
        });

        listarFacturas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListaSalidaPendientes_ = new org.jdesktop.swingx.JXTable();
        jXFindBar1 = new org.jdesktop.swingx.JXFindBar(jtListaSalidaPendientes_.getSearchable());
        imprimir_InventarioTiendas_ = new javax.swing.JButton();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        txtTitulo = new javax.swing.JLabel();
        ayuda = new javax.swing.JButton();

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

        jtListaSalidaPendientes_.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListaSalidaPendientes_.setSortable(false);
        jtListaSalidaPendientes_.getTableHeader().setReorderingAllowed(false);
        jtListaSalidaPendientes_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaSalidaPendientes_MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtListaSalidaPendientes_);

        imprimir_InventarioTiendas_.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        imprimir_InventarioTiendas_.setText("Imprimir");
        imprimir_InventarioTiendas_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimir_InventarioTiendas_ActionPerformed(evt);
            }
        });

        busy.setText("Generando Archivo!!!");

        txtTitulo.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(102, 102, 102));
        txtTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415416322_list-accept.png"))); // NOI18N
        txtTitulo.setText("MERCANCIA ASIGNADA PARA TIENDA");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                    .addComponent(jXFindBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addGap(141, 141, 141)
                            .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(76, 76, 76)
                            .addComponent(imprimir_InventarioTiendas_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ayuda)))
                .addGap(0, 0, 0)
                .addComponent(jXFindBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addComponent(imprimir_InventarioTiendas_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jtListaSalidaPendientes_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaSalidaPendientes_MouseClicked
        if (evt.getClickCount() == 2) {
            SeleccionarFactura();
        }
    }//GEN-LAST:event_jtListaSalidaPendientes_MouseClicked

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
                    TableModelReport dataSourse = new TableModelReport(jtListaSalidaPendientes_.getModel());
                    parametro.put("REPORT_DATA_SOURSE", dataSourse);
                    //JasperCompileManager.compileReport(rutaJrxml);
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/reportes/ListadoSalidasPendientes.jasper"));

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDsalidaParaTiendaPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDsalidaParaTiendaPendientes dialog = null;
                try {
                    dialog = new JDsalidaParaTiendaPendientes(new javax.swing.JFrame(), true, null);
                } catch (Exception ex) {
                    Logger.getLogger(JDsalidaParaTiendaPendientes.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.JButton ayuda;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JButton imprimir_InventarioTiendas_;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXFindBar jXFindBar1;
    private org.jdesktop.swingx.JXTable jtListaSalidaPendientes_;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables

    private void SeleccionarFactura() {

        try {
            if (sa != null) {
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una Factura");
            }
        } catch (Exception e) {

            Logger.getLogger(JDsalidaParaTiendaPendientes.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Error al Seleccionar Factura");
            System.err.println("ERROR en Catch de Seleccionar Factura ");
        }

    }

    private void listarFacturas() {
        try {
            String sql = "SELECT s FROM SalidaParaTienda s WHERE  s.revisado =false and s.idAlmacenHasta.idAlmacen =" + al_actual.getIdAlmacen();
            // String sql = "SELECT s FROM SalidaParaTienda s WHERE  s.revisado =false and s.idAlmacenHasta.idAlmacen =3";
            resultList = ObjectModelDAO.getResultQuery(sql);
            JavaUtil.displayResult(resultList, jtListaSalidaPendientes_);
            jtListaSalidaPendientes_.setEditable(false);
            pos = -1;
            sa = null;
        } catch (Exception e) {
            Logger.getLogger(JDsalidaParaTiendaPendientes.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "El Almacen Seleccionado No Contiene Asignacion de Mercancia");
            System.err.println("ERROR en Catch de Listar Factura ");
        }
    }
}
