package gui.dialogos;

import gui.paneles.Distribuidora1;
import util.JavaUtil;
import hibernate.DAO.ObjectModelDAO;
import java.awt.Dialog;
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
import modelos.mapeos.Factura;
import modelos.tablas.TableModelReport;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JDFacturasPendientes extends javax.swing.JDialog {

    public Factura factura = null;
    private List resultList = null;
    private int pos = -1;
   


    public JDFacturasPendientes(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
         
        //jtListaEntradaProveedor.setModel(resulList);
        //this.setLocationRelativeTo(null);

        this.jtListaFactura.setAutoCreateRowSorter(true);
        this.jtListaFactura.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.jtListaFactura.setColumnControlVisible(true);
     
        //activar JavaHelp
        ayudaActionPerformed(null);
        //busy
        busy.setVisible(false);
    
        jtListaFactura.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {

                    pos = jtListaFactura.getSelectedRow();
                    if (pos == -1) {
                        factura = null;
                        return;
                    }
                    factura = ((Factura) resultList.get(pos));

                }
            }
        });

        listarFacturas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameImprimir = new javax.swing.JFrame();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaFactura = new org.jdesktop.swingx.JXTable();
        jXFindBar1 = new org.jdesktop.swingx.JXFindBar(jtListaFactura.getSearchable());
        ayuda = new javax.swing.JButton();
        txtTitulo = new javax.swing.JLabel();
        botonImprimir = new javax.swing.JButton();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        jMenuBarDialogoFac = new javax.swing.JMenuBar();
        jMenuOpciones = new javax.swing.JMenu();
        jMenu_Ayuda_ = new javax.swing.JMenu();

        jFrameImprimir.setName("jFrameImprimir"); // NOI18N

        javax.swing.GroupLayout jFrameImprimirLayout = new javax.swing.GroupLayout(jFrameImprimir.getContentPane());
        jFrameImprimir.getContentPane().setLayout(jFrameImprimirLayout);
        jFrameImprimirLayout.setHorizontalGroup(
            jFrameImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrameImprimirLayout.setVerticalGroup(
            jFrameImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtListaFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListaFactura.setToolTipText("Presione Doble Click Para Selecionar y Aceptar!");
        jtListaFactura.setName("jtListaFactura"); // NOI18N
        jtListaFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListaFactura);

        jXFindBar1.setName("jXFindBar1"); // NOI18N

        ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416510931_Help.png"))); // NOI18N
        ayuda.setBorder(null);
        ayuda.setBorderPainted(false);
        ayuda.setContentAreaFilled(false);
        ayuda.setDefaultCapable(false);
        ayuda.setFocusPainted(false);
        ayuda.setFocusable(false);
        ayuda.setName("ayuda"); // NOI18N
        ayuda.setRequestFocusEnabled(false);
        ayuda.setVerifyInputWhenFocusTarget(false);
        ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaActionPerformed(evt);
            }
        });

        txtTitulo.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415416322_list-accept.png"))); // NOI18N
        txtTitulo.setText("LISTADO DE FACTURAS PENDIENTES");
        txtTitulo.setForeground(new java.awt.Color(102, 102, 102));
        txtTitulo.setName("txtTitulo"); // NOI18N

        botonImprimir.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botonImprimir.setText("Imprimir");
        botonImprimir.setName("botonImprimir"); // NOI18N
        botonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirActionPerformed(evt);
            }
        });

        busy.setText("Procesando...!!!");
        busy.setName("busy"); // NOI18N

        jMenuBarDialogoFac.setName("jMenuBarDialogoFac"); // NOI18N

        jMenuOpciones.setText("Opciones");
        jMenuOpciones.setName("jMenuOpciones"); // NOI18N
        jMenuBarDialogoFac.add(jMenuOpciones);

        jMenu_Ayuda_.setText("Ayuda");
        jMenu_Ayuda_.setName("jMenu_Ayuda_"); // NOI18N
        jMenuBarDialogoFac.add(jMenu_Ayuda_);

        setJMenuBar(jMenuBarDialogoFac);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXFindBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addGap(121, 121, 121)
                                .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(botonImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addGap(8, 8, 8)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ayuda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ayuda)
                    .addComponent(txtTitulo))
                .addGap(18, 18, 18)
                .addComponent(jXFindBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(botonImprimir)
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

    private void jtListaFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaFacturaMouseClicked

        if (evt.getClickCount() == 2) {
            SeleccionarFactura();
        }

    }//GEN-LAST:event_jtListaFacturaMouseClicked

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed

        try {
            File  archivo = new File(this.getClass().getResource("/JavaHelp/JavaHelp/ejemplo.hs").getFile());
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

    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
        // TODO add your handling code here:    resultList
        Thread hilo = new Thread() {
           
            @Override
            public void run() {

                busy.setEnabled(true);
                busy.setVisible(true);
                busy.setBusy(true);
                try {
                    JasperPrint jasperPrint = null;

                    Map<String, Object> parametro = new HashMap<>();
                    String s = "";
                    TableModelReport dataSourse = new TableModelReport(jtListaFactura.getModel());
                    parametro.put("REPORT_DATA_SOURSE", dataSourse);
                    //JasperCompileManager.compileReport(rutaJrxml);
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/reportes/ListadoFacturas.jasper"));

                    jasperPrint = JasperFillManager.fillReport(reporte, null, dataSourse);
                    JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                    jasperViewer.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
                    jasperViewer.setTitle("Reporte de Toma Fisica Distribuidoras.");
                    jasperViewer.setVisible(true);
                     
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
    }//GEN-LAST:event_botonImprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayuda;
    private javax.swing.JButton botonImprimir;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrameImprimir;
    private javax.swing.JMenuBar jMenuBarDialogoFac;
    private javax.swing.JMenu jMenuOpciones;
    private javax.swing.JMenu jMenu_Ayuda_;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXFindBar jXFindBar1;
    private org.jdesktop.swingx.JXTable jtListaFactura;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables

    private void SeleccionarFactura() {

        try {
            if (factura != null) {
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una Factura");
            }
        } catch (Exception e) {
            Logger.getLogger(JDFacturasPendientes.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Excepcion Seleccionando Factura :" + e);
        }

    }

    private void listarFacturas() {
        try {
            String hql = "select f  FROM Factura f INNER JOIN "
                    + "f.entradaProveedorCollection ep WHERE ep.estatus='Pendiente' "
                    + "GROUP BY f.idFactura ORDER BY f.idFactura ";
            resultList = ObjectModelDAO.getResultQuery(hql);
            JavaUtil.displayResult(resultList, jtListaFactura);
            jtListaFactura.setEditable(false);
            pos = -1;
            factura = null;
        } catch (Exception ex) {
            Logger.getLogger(JDFacturasPendientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Excepcion Listando Factura " + ex);
        }

    }
}
