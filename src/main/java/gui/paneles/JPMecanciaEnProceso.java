/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import gui.ventanas.JFInicioSecionMiyake;
import util.almacen.DetalleRegistro;
import modelos.tablas.ModeloTablaDetalleRegistroAsignacion;
//import com.ezware.dialog.task.CommandLink;
//import com.ezware.dialog.task.TaskDialogs;
import util.JavaUtil;
import hibernate.DAO.ObjectModelDAO;
import java.awt.Window;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelos.mapeos.Almacen;
import modelos.mapeos.InventarioTienda;
import modelos.mapeos.InventarioTiendaPK;
import modelos.mapeos.SalidaParaTienda;
import modelos.mapeos.SalidaParaTiendaDetalle;
import modelos.mapeos.SalidaParaTiendaDetallePK;
import modelos.mapeos.Usuario;
import static gui.ventanas.JFInicioSecionMiyake.resultListUsuarios;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class JPMecanciaEnProceso extends javax.swing.JPanel {

    Usuario ususrioActual = null;
    Usuario user = JFInicioSecionMiyake.us1;

    Almacen almacenDesde = null;
    List resultListAlmacen = null;
    List resultListInventarioTienda = null;

    int posUs = -1;
    int posTi = -1;
    int posTi2 = -1;
    // private DetalleRegistro deReg;
    List<DetalleRegistro> listaDetalle = new ArrayList<>();

    /**
     * Creates new form NewJPanel
     */
    public JPMecanciaEnProceso() {
        initComponents();
        //ComboBoxAlmacenes

        String sql = "FROM Almacen a order by a.idAlmacen asc";
        resultListAlmacen = ObjectModelDAO.getResultQuery(sql);

        comboBoxAlmacenDesde.removeAllItems();

        // this.comboBoxAlmacenDesde.addItem("Selecionar");
        for (Object object : resultListAlmacen) {
            Almacen a = (Almacen) object;

            comboBoxAlmacenDesde.addItem(a.getNombre() + " TLF:" + a.getTelefono1());
        }

        this.comboBoxAlmacenDesde.setSelectedIndex(-1);

        this.jXTableMercanciaEnProceso.setAutoCreateRowSorter(true);
        this.jXTableMercanciaEnProceso.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.jXTableMercanciaEnProceso.setColumnControlVisible(true);
        //  TableRowFilterSupport.forTable(jXTable1).searchable(true).apply();
        this.busy.setVisible(false);

    }

     
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
        txtAlmacenSelecion = new org.jdesktop.swingx.JXLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLayeredPaneProductos = new javax.swing.JLayeredPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jXTableMercanciaEnProceso = new org.jdesktop.swingx.JXTable();
        barraBusquedaMercanciaProceso = new org.jdesktop.swingx.JXFindBar(jXTableMercanciaEnProceso.getSearchable());
        busy = new org.jdesktop.swingx.JXBusyLabel();
        jXButtonImprimir = new org.jdesktop.swingx.JXButton();
        jXButtonCancelar = new org.jdesktop.swingx.JXButton();

        setAutoscrolls(true);
        setLayout(new java.awt.BorderLayout());

        jScrollPane2.setAutoscrolls(true);

        jLayeredPaneTienda.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar Tienda Para Consultar Mercancia en Proceso"));
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

        txtAlmacenSelecion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/hasta.png"))); // NOI18N
        txtAlmacenSelecion.setText("Desde Tienda");

        javax.swing.GroupLayout jLayeredPaneTiendaLayout = new javax.swing.GroupLayout(jLayeredPaneTienda);
        jLayeredPaneTienda.setLayout(jLayeredPaneTiendaLayout);
        jLayeredPaneTiendaLayout.setHorizontalGroup(
            jLayeredPaneTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneTiendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAlmacenSelecion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPaneTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPaneTiendaLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jXButtonConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addComponent(jXButtonReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPaneTiendaLayout.createSequentialGroup()
                        .addComponent(comboBoxAlmacenDesde, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)))
                .addGap(40, 40, 40))
        );
        jLayeredPaneTiendaLayout.setVerticalGroup(
            jLayeredPaneTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneTiendaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jLayeredPaneTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxAlmacenDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlmacenSelecion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPaneTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButtonReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jLayeredPaneTienda.setLayer(jXButtonConfirmar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneTienda.setLayer(jXButtonReiniciar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneTienda.setLayer(comboBoxAlmacenDesde, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneTienda.setLayer(txtAlmacenSelecion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane3.setViewportView(jLayeredPaneTienda);

        jLayeredPaneProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles De Productos"));
        jLayeredPaneProductos.setToolTipText("Presione (Ctrl+F) Para Busqueda Avanzada");
        jLayeredPaneProductos.setAutoscrolls(true);

        jXTableMercanciaEnProceso.setModel(new javax.swing.table.DefaultTableModel(
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
        jXTableMercanciaEnProceso.setSortable(false);
        jScrollPane5.setViewportView(jXTableMercanciaEnProceso);

        javax.swing.GroupLayout jLayeredPaneProductosLayout = new javax.swing.GroupLayout(jLayeredPaneProductos);
        jLayeredPaneProductos.setLayout(jLayeredPaneProductosLayout);
        jLayeredPaneProductosLayout.setHorizontalGroup(
            jLayeredPaneProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPaneProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(jLayeredPaneProductosLayout.createSequentialGroup()
                        .addComponent(barraBusquedaMercanciaProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPaneProductosLayout.setVerticalGroup(
            jLayeredPaneProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraBusquedaMercanciaProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPaneProductos.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneProductos.setLayer(barraBusquedaMercanciaProceso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane4.setViewportView(jLayeredPaneProductos);

        busy.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        busy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        busy.setText("CARGANDO...!!!");
        busy.setToolTipText("");

        jXButtonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1418331399_Print.png"))); // NOI18N
        jXButtonImprimir.setText("Imprimir");

        jXButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416789274_clear_left.png"))); // NOI18N
        jXButtonCancelar.setText("Cancelar");
        jXButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPanePrincipalLayout = new javax.swing.GroupLayout(jLayeredPanePrincipal);
        jLayeredPanePrincipal.setLayout(jLayeredPanePrincipalLayout);
        jLayeredPanePrincipalLayout.setHorizontalGroup(
            jLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPanePrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(jLayeredPanePrincipalLayout.createSequentialGroup()
                        .addComponent(jXButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jXButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPanePrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPanePrincipalLayout.setVerticalGroup(
            jLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPanePrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jLayeredPanePrincipal.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePrincipal.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePrincipal.setLayer(busy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePrincipal.setLayer(jXButtonImprimir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePrincipal.setLayer(jXButtonCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
                        String sql = "SELECT i FROM InventarioTienda i WHERE i.inventarioTiendaPK.idAlmacen =" + almacenDesde.getIdAlmacen() + "and i.asignado is false";
                        resultListInventarioTienda = ObjectModelDAO.getResultQuery(sql);

                        JavaUtil.displayResult(resultListInventarioTienda, jXTableMercanciaEnProceso);
                        if (jXTableMercanciaEnProceso.getRowCount() == 0) {
                            jXTableMercanciaEnProceso.setModel(new DefaultTableModel());
                        }

//                        jXTableMercanciaEnProceso.setEditable(false);
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
                    Logger.getLogger(JPMecanciaEnProceso.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        };
        hilo.start();


    }//GEN-LAST:event_jXButtonConfirmarActionPerformed


    private void jXButtonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonReiniciarActionPerformed

        try {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro Desea Cancelar?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                // this.jXButtonConfirmar.setEnabled(true);
                //Limpiar Lista y Tabla

                jXTableMercanciaEnProceso.removeAll();
                listaDetalle.clear();
                //OBjetos
                ususrioActual = null;
                almacenDesde = null;

                //Controles ComboBox
                this.comboBoxAlmacenDesde.setSelectedIndex(-1);

            }
        } catch (Exception e) {
            Logger.getLogger(JPMecanciaEnProceso.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Por Favor, Seleccione Un Pedido Valido Para Continuar.!!!");
            System.err.println("ERROR ó Excepcion Boton Reiniciar Todo Desde Pedido : " + e);
        }


    }//GEN-LAST:event_jXButtonReiniciarActionPerformed

    private void comboBoxAlmacenDesdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxAlmacenDesdeMouseClicked

        this.jXButtonConfirmar.setEnabled(true);

    }//GEN-LAST:event_comboBoxAlmacenDesdeMouseClicked

    private void jXButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButtonCancelarActionPerformed
//        String SQL = "COPY (select 0 as a,1 as b,replicate(' ', 7) || id_producto As id_producto, \n"
//                + "		LTRIM(replace((RTRIM(descripcion)),',',' ')) as descripcion, \n"
//                + "		(REPLICATE(' ', 3)||Cast(id_clasificacion as varchar)) As id_clasificacion,\n"
//                + "		0 as a1,0 as a2,0 as a3,0 as a4,65 as excento,\n"
//                + "		\n"
//                + "		' ' as i, ' ' as j, 0 as k, 0 as l,0 as m, 0 as n, 0 as p, 0 as q,0 as r,0 as s,\n"
//                + "		' ' as t,0 as u,1 as v,0 as w,0 as x,0 as y,0 as z,0 as ab \n"
//                + "		\n"
//                + "From producto  \n"
//                + "where precio_original>0.05 and descripcion not like ' '  and id_producto>=100000\n"
//                + "Order By id_producto) TO 'C:/Users/Pablo/export/prueba.txt' WITH DELIMITER AS ',' ";
        //     String SQL="select now() as laHora";

        String SQL = "COPY (select * from usuario) TO "
                + "'C:/Users/Pablo/export/prueba.txt' WITH DELIMITER AS ','";
        ObjectModelDAO.getResultQueryString(SQL);

    }//GEN-LAST:event_jXButtonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXFindBar barraBusquedaMercanciaProceso;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JComboBox comboBoxAlmacenDesde;
    private javax.swing.JLayeredPane jLayeredPanePrincipal;
    private javax.swing.JLayeredPane jLayeredPaneProductos;
    private javax.swing.JLayeredPane jLayeredPaneTienda;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private org.jdesktop.swingx.JXButton jXButtonCancelar;
    private org.jdesktop.swingx.JXButton jXButtonConfirmar;
    private org.jdesktop.swingx.JXButton jXButtonImprimir;
    private org.jdesktop.swingx.JXButton jXButtonReiniciar;
    private org.jdesktop.swingx.JXTable jXTableMercanciaEnProceso;
    private org.jdesktop.swingx.JXLabel txtAlmacenSelecion;
    // End of variables declaration//GEN-END:variables

}
