/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import gui.dialogos.JDInventarioTienda;
import gui.ventanas.JFInicioSecionMiyake;
import util.JavaUtil;
import hibernate.DAO.ObjectModelDAO;
import java.awt.Dialog;
import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelos.mapeos.Almacen;
import modelos.mapeos.InventarioTienda;
import modelos.mapeos.Usuario;
import modelos.tablas.TableModelReport;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pablo
 */
public class JPConsultaInventario extends javax.swing.JPanel {

    Usuario user = JFInicioSecionMiyake.us1;
    Almacen almacenHasta = null;
    Almacen almacenDesde = null;
    List resultListAlmacen = null;
    List resultListInventarioTienda = null;
    int posTi2 = -1;
    /**
     * Creates new form NewJPanel
     */
    public JPConsultaInventario() {
        initComponents();
        //ComboBoxAlmacenes

        String sql = "FROM Almacen a order by a.idAlmacen asc";
        resultListAlmacen = ObjectModelDAO.getResultQuery(sql);

        comboBoxAlmacenDesde.removeAllItems();

        for (Object object : resultListAlmacen) {
            Almacen a = (Almacen) object;

            comboBoxAlmacenDesde.addItem(a.getNombre() + " TLF:" + a.getTelefono1());
        }
//        posTi = this.comboBoxAlmacen.getSelectedIndex();
//        almacenHasta = (Almacen) resultListAlmacen.get(posTi);
//        System.err.println("Index Sleccion podTi, lod  dstpd Son : " + almacenHasta.getNombre() );
//        Almacen al = (Almacen) this.comboBoxAlmacen.getSelectedItem();
//        System.err.println("Almacen Seleccionado Objeto : " + al.getNombre()+al.getIdAlmacen() );
//        
        //Usuarios
        //  List<List> resultListUsuarios = FventanaIncial.listaUsuarioMain;
        this.comboBoxAlmacenDesde.setSelectedIndex(-1);
        this.busy.setVisible(false);
        this.jXTablaConsultarMercanciaInventarios.setAutoCreateRowSorter(true);
        this.jXTablaConsultarMercanciaInventarios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.jXTablaConsultarMercanciaInventarios.setColumnControlVisible(true);
        //TableRowFilterSupport.forTable(jXTable1).searchable(true).apply();

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new JPConsultaInventario().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(JPConsultaInventario.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jLayeredPanePrincipal = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLayeredPaneTienda = new javax.swing.JLayeredPane();
        jXButtonConfirmar = new org.jdesktop.swingx.JXButton();
        jXButtonReiniciar = new org.jdesktop.swingx.JXButton();
        comboBoxAlmacenDesde = new javax.swing.JComboBox();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLayeredPaneProductos = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTablaConsultarMercanciaInventarios = new org.jdesktop.swingx.JXTable();
        barraBusquedaExistencia = new org.jdesktop.swingx.JXFindBar(jXTablaConsultarMercanciaInventarios.getSearchable());
        jXButtonImprimir = new org.jdesktop.swingx.JXButton();
        busy = new org.jdesktop.swingx.JXBusyLabel();

        setAutoscrolls(true);
        setLayout(new java.awt.BorderLayout());

        jScrollPane2.setAutoscrolls(true);

        jLayeredPaneTienda.setBorder(javax.swing.BorderFactory.createTitledBorder("SeleccionarTienda Para Consultar Existencia Física de Mercancia"));
        jLayeredPaneTienda.setToolTipText("Seleciones Una Tienda y Presione Confirmar");
        jLayeredPaneTienda.setPreferredSize(new java.awt.Dimension(610, 80));
        jLayeredPaneTienda.setRequestFocusEnabled(false);
        jLayeredPaneTienda.setVerifyInputWhenFocusTarget(false);

        jXButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/conect.png"))); // NOI18N
        jXButtonConfirmar.setText("Confirmar");
        jXButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonConfirmarActionPerformed(evt);
            }
        });

        jXButtonReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/reiniciar.png"))); // NOI18N
        jXButtonReiniciar.setText("Reiniciar");
        jXButtonReiniciar.setEnabled(false);
        jXButtonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonReiniciarActionPerformed(evt);
            }
        });

        comboBoxAlmacenDesde.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxAlmacenDesde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxAlmacenDesdeMouseClicked(evt);
            }
        });

        jXLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417636333_store.png"))); // NOI18N
        jXLabel10.setText("Tienda");

        javax.swing.GroupLayout jLayeredPaneTiendaLayout = new javax.swing.GroupLayout(jLayeredPaneTienda);
        jLayeredPaneTienda.setLayout(jLayeredPaneTiendaLayout);
        jLayeredPaneTiendaLayout.setHorizontalGroup(
            jLayeredPaneTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneTiendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPaneTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPaneTiendaLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jXButtonConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addComponent(jXButtonReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPaneTiendaLayout.createSequentialGroup()
                        .addComponent(comboBoxAlmacenDesde, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27))))
        );
        jLayeredPaneTiendaLayout.setVerticalGroup(
            jLayeredPaneTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneTiendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPaneTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxAlmacenDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPaneTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButtonReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jLayeredPaneTienda.setLayer(jXButtonConfirmar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneTienda.setLayer(jXButtonReiniciar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneTienda.setLayer(comboBoxAlmacenDesde, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneTienda.setLayer(jXLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane3.setViewportView(jLayeredPaneTienda);

        jLayeredPaneProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles De Productos"));
        jLayeredPaneProductos.setToolTipText("Presione (Ctrl+F) Para Busqueda Avanzada");
        jLayeredPaneProductos.setAutoscrolls(true);

        jXTablaConsultarMercanciaInventarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jXTablaConsultarMercanciaInventarios.setToolTipText("Presione (Ctrl + F) Para Buscar.");
        jXTablaConsultarMercanciaInventarios.setSortable(false);
        jScrollPane1.setViewportView(jXTablaConsultarMercanciaInventarios);

        javax.swing.GroupLayout jLayeredPaneProductosLayout = new javax.swing.GroupLayout(jLayeredPaneProductos);
        jLayeredPaneProductos.setLayout(jLayeredPaneProductosLayout);
        jLayeredPaneProductosLayout.setHorizontalGroup(
            jLayeredPaneProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPaneProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraBusquedaExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPaneProductosLayout.setVerticalGroup(
            jLayeredPaneProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneProductosLayout.createSequentialGroup()
                .addComponent(barraBusquedaExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jLayeredPaneProductos.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneProductos.setLayer(barraBusquedaExistencia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane4.setViewportView(jLayeredPaneProductos);

        jXButtonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1418331399_Print.png"))); // NOI18N
        jXButtonImprimir.setText("Imprimir");
        jXButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonImprimirActionPerformed(evt);
            }
        });

        busy.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        busy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        busy.setText("CARGANDO...!!!");
        busy.setToolTipText("");

        javax.swing.GroupLayout jLayeredPanePrincipalLayout = new javax.swing.GroupLayout(jLayeredPanePrincipal);
        jLayeredPanePrincipal.setLayout(jLayeredPanePrincipalLayout);
        jLayeredPanePrincipalLayout.setHorizontalGroup(
            jLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPanePrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPanePrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jLayeredPanePrincipalLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPanePrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jXButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jLayeredPanePrincipalLayout.setVerticalGroup(
            jLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPanePrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPanePrincipal.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePrincipal.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePrincipal.setLayer(jXButtonImprimir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePrincipal.setLayer(busy, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane2.setViewportView(jLayeredPanePrincipal);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jXButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonConfirmarActionPerformed

        Thread hilo = new Thread() {

            @Override
            public void run() {
                busy.setEnabled(true);
                busy.setVisible(true);
                busy.setBusy(true);
                try {
                    posTi2 = comboBoxAlmacenDesde.getSelectedIndex();

                    if (posTi2 != -1) {
//                        ususrioActual = (Usuario) resultListUsuarios.get(posUs);
                        almacenDesde = (Almacen) resultListAlmacen.get(posTi2);
//                        almacenHasta = (Almacen) resultListAlmacen.get(posTi);
                        //COnstruir Consulta
                        String sql = "SELECT i FROM InventarioTienda i WHERE i.cantidad > 0 and i.inventarioTiendaPK.idAlmacen =" + almacenDesde.getIdAlmacen() + "and i.asignado is true";
                        resultListInventarioTienda = ObjectModelDAO.getResultQuery(sql);

                        JavaUtil.displayResult(resultListInventarioTienda, jXTablaConsultarMercanciaInventarios);
                        jXTablaConsultarMercanciaInventarios.setEditable(false);

                        for (Object listaInventarioTienda : resultListInventarioTienda) {
                            System.err.println("Los datos son : " + ((InventarioTienda) listaInventarioTienda).getProducto());
                        }
                        //Controles ComboBox comboBoxAlmacenDesde.setEnabled(false);

                        // jXButtonConfirmar.setEnabled(false);
                        jXButtonReiniciar.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe Selecionar Todos Los Datos");
                    }
                    busy.setEnabled(false);
                    busy.setVisible(false);
                    busy.setBusy(false);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Excepcion AL Confirmar Factura : " + e);
                    System.err.println("ERROR en EVENTO BOTON CONFIRMAR FACTURA : " + e);
                    Logger.getLogger(JPConsultaInventario.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        };
        hilo.start();


    }//GEN-LAST:event_jXButtonConfirmarActionPerformed


    private void jXButtonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonReiniciarActionPerformed

        try {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro Desea Cancelar?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
 
                resultListInventarioTienda=null; 
                //OBjetos 
                this.almacenDesde = null;
                this.almacenHasta = null;
                //Controles ComboBox
                this.comboBoxAlmacenDesde.setSelectedIndex(-1);

            }
        } catch (Exception e) {
            Logger.getLogger(JPConsultaInventario.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Por Favor, Seleccione Un Pedido Valido Para Continuar.!!!");
            System.err.println("ERROR ó Excepcion Boton Reiniciar Todo Desde Pedido : " + e);
        }


    }//GEN-LAST:event_jXButtonReiniciarActionPerformed

    private void comboBoxAlmacenDesdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxAlmacenDesdeMouseClicked

        this.jXButtonConfirmar.setEnabled(true);

    }//GEN-LAST:event_comboBoxAlmacenDesdeMouseClicked

    private void jXButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonImprimirActionPerformed
         Thread hilo = new Thread() {

            @Override
            public void run() {
                busy.setText("Generando Archivo...!!!");
                busy.setEnabled(true);
                busy.setVisible(true);
                busy.setBusy(true);
                try {

                    JasperPrint jasperPrint = null;

                    Map<String, Object> parametro = new HashMap<>();
                    String s = "";                                      //jtableListaProductosInventarioTienda
                    TableModelReport dataSourse = new TableModelReport(jXTablaConsultarMercanciaInventarios.getModel());
                    parametro.put("tienda", almacenDesde.getDescripcion());
                    parametro.put("REPORT_DATA_SOURSE", dataSourse); 
                    //JasperCompileManager.compileReport(rutaJrxml);
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/reportes/ListadoInventarioTienda.jasper"));

                    jasperPrint = JasperFillManager.fillReport(reporte, parametro, dataSourse);
                    JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                    jasperViewer.setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
                    jasperViewer.setTitle("Listado de Productos Disponible en Inventario.");
                    jasperViewer.setVisible(true);
//                    int respuesta = JOptionPane.showConfirmDialog(null, "El Archivo fue Generado con Exito,"
//                            + "¿Desea Continuar Selecionando Una Factura Pendiente?");
//
//                    if (respuesta == JOptionPane.YES_OPTION) {
//
//                    }
//                    if (respuesta == JOptionPane.NO_OPTION) {
//
//                        jasperViewer.requestFocus();
//                    }

                } catch (JRException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Se a Dectectado Un Proble Con Proceso de Seleccion de Productos Disponible en Inventario,"
                            + "Por Favor Vuelva a Intentarlo.");
                    Logger.getLogger(JDInventarioTienda.class.getName()).log(Level.SEVERE, null, e);
                    System.err.println("Seleccionando Productos Disponible en Inventario" + e);

                }
                //busy
                busy.setEnabled(false);
                busy.setVisible(false);
                busy.setBusy(false);

            }
        };
        hilo.start();
    }//GEN-LAST:event_jXButtonImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXFindBar barraBusquedaExistencia;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JComboBox comboBoxAlmacenDesde;
    private javax.swing.JLayeredPane jLayeredPanePrincipal;
    private javax.swing.JLayeredPane jLayeredPaneProductos;
    private javax.swing.JLayeredPane jLayeredPaneTienda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private org.jdesktop.swingx.JXButton jXButtonConfirmar;
    private org.jdesktop.swingx.JXButton jXButtonImprimir;
    private org.jdesktop.swingx.JXButton jXButtonReiniciar;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXTable jXTablaConsultarMercanciaInventarios;
    // End of variables declaration//GEN-END:variables

}
