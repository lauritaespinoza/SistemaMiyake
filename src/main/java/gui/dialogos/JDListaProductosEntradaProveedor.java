/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dialogos;

import gui.paneles.Distribuidora1;
import util.JavaUtil;
import hibernate.DAO.ObjectModelDAO;
import java.awt.Dialog;
import java.awt.HeadlessException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import modelos.mapeos.Producto;
import javax.help.*;
//import almacen.DAO.DAOProductoMiyake;
//import almacen.Modelos.ModeloTablaProductosEntradaProveedor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelos.mapeos.EntradaProveedor;
import modelos.tablas.TableModelReport;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Miyake
 */
public class JDListaProductosEntradaProveedor extends javax.swing.JDialog {

    List lista_proEP = null;
    public EntradaProveedor proEP = null;
    int pos = -1;
    List resultList = null;

    /**
     * Creates new form JDLista-Productos-Miyake
     *
     * @param parent
     * @param modal
     * @param listaEP
     */
    public JDListaProductosEntradaProveedor(java.awt.Frame parent, boolean modal,
            final List listaEP) {
        super(parent, modal);
        initComponents();
        resultList = listaEP;
        //busy
        busy.setVisible(false);
//        ayudaActionPerformed(null);
//        jtListaProductos.setModel(mtp);
        this.jtListaEntradaProveedor.setAutoCreateRowSorter(true);
        this.jtListaEntradaProveedor.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.jtListaEntradaProveedor.setColumnControlVisible(true);

        this.setLocationRelativeTo(null);

        jtListaEntradaProveedor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                try {

                    if (!lse.getValueIsAdjusting()) {

                        pos = jtListaEntradaProveedor.getSelectedRow();
                        if (pos == -1) {
                            proEP = null;
                            return;
                        }
                        proEP = (EntradaProveedor) listaEP.get(pos);
                        // resultList = listaEP;
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error de Events valueChanged :" + e);
                    Logger.getLogger(JDListaProductosEntradaProveedor.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        });

        ListarProductos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListaEntradaProveedor = new org.jdesktop.swingx.JXTable();
        jXFindBar1 = new org.jdesktop.swingx.JXFindBar(jtListaEntradaProveedor.getSearchable());
        jButton3 = new javax.swing.JButton();
        txtTitulo = new javax.swing.JLabel();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        ayuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtListaEntradaProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListaEntradaProveedor.setSortable(false);
        jtListaEntradaProveedor.getTableHeader().setReorderingAllowed(false);
        jtListaEntradaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaEntradaProveedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtListaEntradaProveedor);

        jButton3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtTitulo.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415416322_list-accept.png"))); // NOI18N
        txtTitulo.setText("Producto Disponibles Para Toma Fisica Distribuidora");
        txtTitulo.setForeground(new java.awt.Color(102, 102, 102));

        busy.setText("Generando Archivo...!!!");

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
                    .addComponent(jXFindBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtTitulo)
                            .addGap(50, 50, 50)
                            .addComponent(ayuda)
                            .addGap(28, 28, 28))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ayuda)
                    .addComponent(txtTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXFindBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        seleccionarProducto();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtListaEntradaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaEntradaProveedorMouseClicked
        if (evt.getClickCount() == 2) {
            seleccionarProducto();
        }
    }//GEN-LAST:event_jtListaEntradaProveedorMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:    resultList
        Thread hilo = new Thread() {
           
            @Override
            public void run() {

                busy.setEnabled(true);
                busy.setVisible(true);
                busy.setBusy(true);
                try {
                    JasperPrint jasperPrint = null;

                    java.util.Map<String, Object> parametro = new HashMap<>();
                    String s = "";
                    TableModelReport dataSourse = new TableModelReport(jtListaEntradaProveedor.getModel());
                    parametro.put("REPORT_DATA_SOURSE", dataSourse);
                    //JasperCompileManager.compileReport(rutaJrxml);
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/reportes/ListaProdTomaFisicaDistribuidor.jasper"));

                    jasperPrint = JasperFillManager.fillReport(reporte, null, dataSourse);
                    JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                     jasperViewer.setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
                    jasperViewer.setTitle("Producto Disponibles Para Toma Fisica Distribuidora.");
                    jasperViewer.setVisible(true);
                    //busy
                    busy.setEnabled(false);
                    busy.setVisible(false);
                    busy.setBusy(false);
//                    int respuesta = JOptionPane.showConfirmDialog(null, "El Archivo fue Generado con Exito,"
//                            + "¿Desea Continuar Selecionando Una Factura Pendiente?");
//
//                    if (respuesta == JOptionPane.YES_OPTION) {
//
//                    }
//                    if (respuesta == JOptionPane.NO_OPTION) {
//                        dispose();
//                        setVisible(false);
//                        
//                    }
//                    dispose();
//                    setVisible(false);

                } catch (JRException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Se a Dectectado Un Proble Con Proceso de Seleccion de Facturas,"
                            + "Por Favor Vuelva a Intentarlo.");
                    Logger.getLogger(Distribuidora1.class.getName()).log(Level.SEVERE, null, e);
                    System.err.println("Seleccionando Facturas" + e);

                }

            }
        };
        hilo.start();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
//
//        try {
//            File  archivo = new File(this.getClass().getResource("/JavaHelp/JavaHelp/ejemplo.hs").getFile());
//            URL hsURL = archivo.toURI().toURL();
//
//            HelpSet helpset = null;
//            helpset = new HelpSet(null, hsURL);
//
//            HelpSet.Presentation hsp;
//            hsp = helpset.getPresentation("MainWin");
//
//            HelpBroker help_browser = helpset.createHelpBroker();
//            help_browser.setHelpSetPresentation(hsp);
//
//            // Cuando pulsemos F1 se mostrará la ayuda de la página de introducion
//            help_browser.enableHelpOnButton(this.ayuda, "introduction", helpset);
//            help_browser.enableHelpKey(getContentPane(), "introduction", helpset);
//
//        } catch (HelpSetException | MalformedURLException ex) {
//            Logger.getLogger(JDFacturasPendientes.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(this, "Excepcion Ayuda Factura " + ex);
//            System.err.println("Excepcion Ayuda Factura " + ex);
//        }
    }//GEN-LAST:event_ayudaActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayuda;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXFindBar jXFindBar1;
    private org.jdesktop.swingx.JXTable jtListaEntradaProveedor;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables


    private void ListarProductos() {
        try {
//        String sql = "from EntradaProveedor ep where ep.estatus='Pendiente' group by ep.idEntradaProveedor ";
            // String sql = "";
//        resultList = ObjectModelDAO.getResultQuery(sql);
            JavaUtil.displayResult(resultList, jtListaEntradaProveedor);
            jtListaEntradaProveedor.setEditable(false);
            pos = -1;
            proEP = null;
            //   mtp.setListaProductos(daoProducto.listarProductosVigentesEP());
            //  mtp.fireTableDataChanged();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error de ListarProductos :" + ex);
            Logger.getLogger(JDListaProductosEntradaProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void seleccionarProducto() {
        try {
            if (proEP != null) {
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una Producto");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error de seleccionarProducto :" + e);
            Logger.getLogger(JDListaProductosEntradaProveedor.class.getName()).log(Level.SEVERE, null, e);

        }

    }
}
