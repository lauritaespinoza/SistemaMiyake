/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import gui.dialogos.JDentradaproveedor;
import gui.dialogos.JDproducto;
import clases.excel.EXCELreader;
import util.JavaUtil;
import static util.JavaUtil.cons_seleccionar;
import hibernate.DAO.ObjectModelDAO;
import java.util.List;
import modelos.mapeos.Almacen;
import modelos.mapeos.Proveedor;
import hibernate.DAO.DaoQuery;
import clases.excel.EXCELreader;
import util.JavaUtil;
import static util.JavaUtil.cons_rutaFacturasDigitales;
import static util.JavaUtil.cons_seleccionar;
import static util.JavaUtil.copyFile;
import hibernate.DAO.ObjectModelDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import modelos.mapeos.Almacen;
import modelos.mapeos.Factura;
import modelos.mapeos.InventarioTienda;
import modelos.mapeos.Producto;
import modelos.mapeos.Proveedor;
import org.hibernate.Query;

/**
 *
 * @author Usuario
 */
public class JPentradaproveedor extends javax.swing.JPanel {

    private EXCELreader excelReader;
    private List tiendas;
    private List proveedores;
    private int pos_tienda;
    private int pos_proveedor;

    public JPentradaproveedor() {
        initComponents();

        cargarCB();
    }

    private void cargarCB() {
        tiendas = ObjectModelDAO.getResultQuery("from Almacen a order by a.idAlmacen asc");
        cb_tienda.removeAllItems();
        cb_tienda.addItem(cons_seleccionar);
        for (Object object : tiendas) {
            Almacen a = (Almacen) object;
            cb_tienda.addItem(a.getNombre());
        }
        pos_tienda = -1;
        proveedores = ObjectModelDAO.getResultQuery("from Proveedor p order by p.idProveedor asc");
        cb_proveedor.removeAllItems();
        cb_proveedor.addItem(cons_seleccionar);
        for (Object object : proveedores) {
            Proveedor p = (Proveedor) object;
            cb_proveedor.addItem(p.getNombre());
        }
        pos_proveedor = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filesc = new javax.swing.JFileChooser();
        filesc.setCurrentDirectory(new java.io.File("C:\\Users\\Usuario\\Documents\\PASANTIA"));

        filesc.setDialogTitle("Seleccione un archivo");
        panel_diferencia = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        precioactual = new javax.swing.JRadioButton();
        precioleido = new javax.swing.JRadioButton();
        precioparticular = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        precioescogido = new javax.swing.JTextField();
        grupoboton = new javax.swing.ButtonGroup();
        factura = new org.jdesktop.swingx.JXTaskPane();
        jButton1 = new javax.swing.JButton();
        nro_factura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        recibido_por = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fecha = new org.jdesktop.swingx.JXDatePicker();
        cb_proveedor = new javax.swing.JComboBox();
        embarcado_via = new javax.swing.JTextField();
        cb_tienda = new javax.swing.JComboBox();
        ruta = new javax.swing.JLabel();
        panel_detalle = new org.jdesktop.swingx.JXTaskPane();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new org.jdesktop.swingx.JXTable();
        procesarEP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_pd = new javax.swing.JLabel();
        lb_np = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lb_renglones = new javax.swing.JLabel();

        jLabel10.setText("Precio Actual");

        jLabel11.setText("Precio Leído");

        jLabel12.setText("Precio Escogido");

        jLabel13.setText("Precio Particular");

        precioactual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioactualActionPerformed(evt);
            }
        });

        precioleido.setSelected(true);
        precioleido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioleidoActionPerformed(evt);
            }
        });

        precioparticular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioparticularActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Escoga un precio para el producto");

        javax.swing.GroupLayout panel_diferenciaLayout = new javax.swing.GroupLayout(panel_diferencia);
        panel_diferencia.setLayout(panel_diferenciaLayout);
        panel_diferenciaLayout.setHorizontalGroup(
            panel_diferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_diferenciaLayout.createSequentialGroup()
                .addGroup(panel_diferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_diferenciaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel14))
                    .addGroup(panel_diferenciaLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panel_diferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_diferenciaLayout.createSequentialGroup()
                                .addGroup(panel_diferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel_diferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(precioleido, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(precioactual, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(panel_diferenciaLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(precioparticular))))
                    .addGroup(panel_diferenciaLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel12))
                    .addGroup(panel_diferenciaLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(precioescogido, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        panel_diferenciaLayout.setVerticalGroup(
            panel_diferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_diferenciaLayout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(13, 13, 13)
                .addGroup(panel_diferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(precioactual))
                .addGap(9, 9, 9)
                .addGroup(panel_diferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(precioleido))
                .addGap(6, 6, 6)
                .addGroup(panel_diferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(precioparticular))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precioescogido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setLayout(new java.awt.BorderLayout());

        factura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416856442_page_white_edit.png"))); // NOI18N
        factura.setScrollOnExpand(true);
        factura.setTitle("Datos de Factura");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415667180_application-vnd.ms-excel.png"))); // NOI18N
        jButton1.setText("Seleccionar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/facturas.png"))); // NOI18N
        jLabel3.setText("N° Factura");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/responsable2.png"))); // NOI18N
        jLabel4.setText("Recibido por");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416789180_Timetable.png"))); // NOI18N
        jLabel5.setText("Fecha emision");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417576112_Order_tracking.png"))); // NOI18N
        jLabel6.setText("Proveedor");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1418331236_doc_pdf.png"))); // NOI18N
        jLabel7.setText("Archivo digital");

        jLabel8.setText("Embarcado via");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417636330_store.png"))); // NOI18N
        jLabel9.setText("Tienda");

        cb_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_proveedorActionPerformed(evt);
            }
        });

        cb_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tiendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout facturaLayout = new javax.swing.GroupLayout(factura.getContentPane());
        factura.getContentPane().setLayout(facturaLayout);
        facturaLayout.setHorizontalGroup(
            facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(facturaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, facturaLayout.createSequentialGroup()
                        .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(facturaLayout.createSequentialGroup()
                                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(29, 29, 29)
                                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(recibido_por, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nro_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(114, 114, 114)
                                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(facturaLayout.createSequentialGroup()
                                        .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6))
                                        .addGap(26, 26, 26)
                                        .addComponent(cb_proveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(facturaLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(64, 64, 64)
                                        .addComponent(cb_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(facturaLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(26, 26, 26)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, facturaLayout.createSequentialGroup()
                        .addComponent(embarcado_via, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(312, 312, 312))))
        );
        facturaLayout.setVerticalGroup(
            facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(facturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(facturaLayout.createSequentialGroup()
                        .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nro_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(recibido_por, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(facturaLayout.createSequentialGroup()
                        .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(cb_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cb_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(embarcado_via, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ruta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        add(factura, java.awt.BorderLayout.NORTH);

        panel_detalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416789183_data-16.png"))); // NOI18N
        panel_detalle.setTitle("Tabla de productos por archivo");
        panel_detalle.setAutoscrolls(true);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Total Bulto", "Total KG", "Referencia", "Descripción", "Cantidad", "UM", "Precio", "Total Precio", "Cod. Barras", "Status"
            }
        ));
        tabla.setToolTipText("Doble Click para acciones");
        tabla.setEditable(false);
        tabla.setHorizontalScrollEnabled(true);
        tabla.setShowGrid(true);
        tabla.setSortable(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        procesarEP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415667649_041.png"))); // NOI18N
        procesarEP.setText("Procesar");
        procesarEP.setToolTipText("Debe Registrar todos los productos nuevos ademas ajustar los precios diferentes");
        procesarEP.setEnabled(false);
        procesarEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarEPActionPerformed(evt);
            }
        });

        jLabel1.setText("° Precio diferente");

        jLabel2.setText("° Nuevos Productos");

        jLabel15.setText("° Renglones");

        javax.swing.GroupLayout panel_detalleLayout = new javax.swing.GroupLayout(panel_detalle.getContentPane());
        panel_detalle.getContentPane().setLayout(panel_detalleLayout);
        panel_detalleLayout.setHorizontalGroup(
            panel_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_detalleLayout.createSequentialGroup()
                .addGroup(panel_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_detalleLayout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_detalleLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panel_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(panel_detalleLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(procesarEP))
                            .addGroup(panel_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lb_renglones, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))))
                    .addGroup(panel_detalleLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lb_np, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_detalleLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lb_pd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panel_detalleLayout.setVerticalGroup(
            panel_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_detalleLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panel_detalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_renglones, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lb_pd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lb_np, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(procesarEP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        busy.setVisible(false);

        add(panel_detalle, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private boolean isComplete() {
        return (excelReader.getNp()
                + excelReader.getPd()) == 0;
    }

    private void setProcess() {
        if (isComplete()) {
            procesarEP.setEnabled(true);
            procesarEP.setToolTipText("Click para procesar todo el listado de productos");
        } else {
            procesarEP.setEnabled(false);
            procesarEP.setToolTipText("Debe Registrar todos los productos nuevos,"
                    + " ademas ajustar los precios diferentes");
        }
    }

    private boolean canProcess() {
        return pos_proveedor != -1
                && JavaUtil.isNumeric(nro_factura.getText())
                && !recibido_por.getText().equals("")
                && fecha.getDate() != null
                && pos_tienda != -1
                && !embarcado_via.getText().equals("")
                && isComplete();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (busy.isBusy()) {
            return;
        }

        filesc.setFileFilter(new FileNameExtensionFilter("Archivoss xlsx ", "xlsx"));

        int returnVal = filesc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            Thread hilo = new Thread() {

                @Override
                public void run() {

                    File file = filesc.getSelectedFile();

                    ruta.setText(file.getAbsolutePath());
                    panel_detalle.setCollapsed(false);
                    lb_np.setText("");
                    lb_pd.setText("");
                    lb_renglones.setText("");
                    busy.setVisible(true);
                    busy.setBusy(true);
                    tabla.setModel(new DefaultTableModel());
                    excelReader = new EXCELreader(file.getAbsolutePath());

                    tabla.setModel(excelReader.toTable());
                    lb_np.setText(excelReader.getNp() + "");
                    lb_pd.setText(excelReader.getPd() + "");
                    lb_renglones.setText(excelReader.getListSize() + "");
                    setProcess();
                    busy.setBusy(false);
                    busy.setVisible(false);

                }
            };
            hilo.start();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_proveedorActionPerformed

        if (!((String) cb_proveedor.getSelectedItem()).equals(cons_seleccionar)) {
            pos_proveedor = cb_proveedor.getSelectedIndex() - 1;
        } else {
            pos_proveedor = -1;
        }
    }//GEN-LAST:event_cb_proveedorActionPerformed

    private void cb_tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tiendaActionPerformed
        if (!((String) cb_tienda.getSelectedItem()).equals(cons_seleccionar)) {
            pos_tienda = cb_tienda.getSelectedIndex() - 1;
        } else {
            pos_tienda = -1;
        }
    }//GEN-LAST:event_cb_tiendaActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getClickCount() == 2 && tabla.getSelectedRow() != -1) {
            String valor = (String) tabla.getValueAt(tabla.getSelectedRow(), tabla.getColumnCount() - 1);
            switch (valor) {
                case EXCELreader.cons_nuevo:
                    if (JOptionPane.showConfirmDialog(this, "El producto no existe, ¿desea crearlo?", "Nuevo Producto",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        Producto productoNuevo = new Producto(
                                excelReader.getListAt(tabla.getSelectedRow(), EXCELreader.descripcion_producto),
                                excelReader.getListAt(tabla.getSelectedRow(), EXCELreader.referencia_producto),
                                Float.parseFloat(excelReader.getListAt(tabla.getSelectedRow(), EXCELreader.precio_producto)),
                                pos_proveedor != -1 ? (Proveedor) proveedores.get(pos_proveedor) : null
                        );

                        JDproducto jdp = new JDproducto(null, true, productoNuevo);
                        jdp.setVisible(true);
                        if (jdp.ultimoCreado != null) {//si creo un nuevo producto
                            Double precioT = jdp.ultimoCreado.getPrecioOriginal()
                                    * Double.parseDouble(excelReader.getListAt(tabla.getSelectedRow(), EXCELreader.cantidad_producto));
                            //cambia el reader
                            excelReader.setListAt(tabla.getSelectedRow(), EXCELreader.descripcion_producto, jdp.ultimoCreado.getDescripcion());
                            excelReader.setListAt(tabla.getSelectedRow(), EXCELreader.precio_producto, (Math.round(jdp.ultimoCreado.getPrecioOriginal() * 100.0) / 100.0) + "");
                            excelReader.setListAt(tabla.getSelectedRow(), EXCELreader.referencia_producto, jdp.ultimoCreado.getReferenciaProducto());
                            excelReader.setListAt(tabla.getSelectedRow(), EXCELreader.precioTotal_producto, (Math.round(precioT * 100.0) / 100.0) + "");
                            excelReader.setNp(excelReader.getNp() - 1);
                            //cambia la tabla y textfield
                            tabla.getModel().setValueAt(jdp.ultimoCreado.getReferenciaProducto(), tabla.getSelectedRow(), EXCELreader.referencia_producto);
                            tabla.getModel().setValueAt(jdp.ultimoCreado.getDescripcion(), tabla.getSelectedRow(), EXCELreader.descripcion_producto);
                            tabla.getModel().setValueAt((Math.round(jdp.ultimoCreado.getPrecioOriginal() * 100.0) / 100.0), tabla.getSelectedRow(), EXCELreader.precio_producto);
                            tabla.getModel().setValueAt((Math.round(precioT * 100.0) / 100.0), tabla.getSelectedRow(), EXCELreader.precioTotal_producto);
                            tabla.getModel().setValueAt(EXCELreader.cons_correcto, tabla.getSelectedRow(), tabla.getColumnCount() - 1);
                            lb_np.setText(excelReader.getNp() + "");
                        }
                    }
                    break;
                case EXCELreader.cons_diferente:

                    if (JOptionPane.showConfirmDialog(this, "El producto actual tiene diferente precio, ¿desea modificarlo?",
                            "Diferencia de Precio", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        //obtiene el precio del producto leido, desde la lista del reader
                        precioleido.setText(excelReader.getListAt(tabla.getSelectedRow(), EXCELreader.precio_producto));
                        precioescogido.setText(precioleido.getText());
                        precioleido.setSelected(true);
                        precioescogido.setEnabled(false);

                        //idAlmacen 1 porque es el DEPOSITO CENTRAL
                        String hql = "FROM InventarioTienda ivt WHERE ivt.almacen.idAlmacen=1 AND ivt.producto.referenciaProducto=:referencia";
                        DaoQuery q = ObjectModelDAO.createQueryDAO(hql);
                        q.getQuery().setParameter("referencia", excelReader.getListAt(tabla.getSelectedRow(), EXCELreader.referencia_producto));
                        List resultList = ObjectModelDAO.getResultQuery(q);
                        if (resultList.size() != 1) {
                            JOptionPane.showMessageDialog(null, "Error, no se encontró el producto");
                            return;
                        }
                        InventarioTienda ppt = (InventarioTienda) resultList.get(0);
                        precioactual.setText(JavaUtil.dosDecimales.format(ppt.getPrecioSinDescuento()).replace(",", "."));
                        boolean sw;
                        do {//repite mientras coloque algo que no es numero
                            sw = false;
                            if (JOptionPane.showConfirmDialog(null, panel_diferencia,
                                    "Elección de Precio", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                try {//si eligio si
                                    Double.parseDouble(precioescogido.getText());
                                    Double precioU = Double.parseDouble(precioescogido.getText());
                                    Double precioT = (Double.parseDouble(precioescogido.getText())
                                            * Double.parseDouble(excelReader.getListAt(tabla.getSelectedRow(), EXCELreader.cantidad_producto)));
                                    //cambia el reader
                                    excelReader.setListAt(tabla.getSelectedRow(), EXCELreader.precio_producto, precioescogido.getText());
                                    excelReader.setListAt(tabla.getSelectedRow(), EXCELreader.precioTotal_producto, precioT + "");
                                    excelReader.setPd(excelReader.getPd() - 1);
                                    //cambia la tabla y textfield
                                    tabla.getModel().setValueAt(precioU, tabla.getSelectedRow(), EXCELreader.precio_producto);
                                    tabla.getModel().setValueAt(precioT, tabla.getSelectedRow(), EXCELreader.precioTotal_producto);
                                    tabla.getModel().setValueAt(EXCELreader.cons_correcto, tabla.getSelectedRow(), tabla.getColumnCount() - 1);

                                    lb_pd.setText(excelReader.getPd() + "");
                                    //cambia la bd
                                    ppt.setPrecioSinDescuento(precioU.floatValue());
                                    ObjectModelDAO.updateObject(ppt);
                                } catch (Exception e) {
                                    sw = true;
                                    JOptionPane.showMessageDialog(this, "Debe ingresar un valor correcto, ejemplo: 1234.56\n" + e.getMessage());
                                }
                            }//sino eligio si entonces termina y no pasa nada
                        } while (sw);
                    }
                    break;
            }
            setProcess();
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void procesarEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarEPActionPerformed
        //MAPEAR ENTRADA PORVEEDOR Y ACTUALIZSAR EL SAVE

        if (!canProcess()) {
            JOptionPane.showMessageDialog(this, "Se deben completar todos los campos, ademas "
                    + "deben estar correctos todos los productos de entrada.");
            return;
        }

        Factura nuevaFactura = new Factura(
                Integer.parseInt(nro_factura.getText()),
                fecha.getDate(),
                0,//inicialmente es 0 lueg de agregar el detalle se modifica por la sumatoria
                recibido_por.getText(),
                "",
                embarcado_via.getText(),
                (Almacen) tiendas.get(pos_tienda),
                (Proveedor) proveedores.get(pos_proveedor)
        );

        Integer id_factura = (Integer) ObjectModelDAO.saveObject(nuevaFactura);
        String rutaFinal = cons_rutaFacturasDigitales + "factura_" + id_factura + ".xlsx";
        //copia el archivo en el servidor
        try {
            copyFile(ruta.getText(), rutaFinal);
        } catch (IOException ex) {
            Logger.getLogger(JDentradaproveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        nuevaFactura.setRutaArchivo(rutaFinal);
        ObjectModelDAO.updateObject(nuevaFactura);
        excelReader.procesarEXCEL(nuevaFactura);

        JOptionPane.showMessageDialog(null, "Se ha registrado la factura");

        //ya se registraron todos, puede cerrar o algo. **PENDIENTE**
    }//GEN-LAST:event_procesarEPActionPerformed

    private void precioactualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioactualActionPerformed
        precioescogido.setText(precioactual.getText());
        precioescogido.setEnabled(false);
    }//GEN-LAST:event_precioactualActionPerformed

    private void precioleidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioleidoActionPerformed
        precioescogido.setText(precioleido.getText());
        precioescogido.setEnabled(false);
    }//GEN-LAST:event_precioleidoActionPerformed

    private void precioparticularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioparticularActionPerformed
        precioescogido.setText("");
        precioescogido.setEnabled(true);
    }//GEN-LAST:event_precioparticularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JComboBox cb_proveedor;
    private javax.swing.JComboBox cb_tienda;
    private javax.swing.JTextField embarcado_via;
    private org.jdesktop.swingx.JXTaskPane factura;
    private org.jdesktop.swingx.JXDatePicker fecha;
    private javax.swing.JFileChooser filesc;
    private javax.swing.ButtonGroup grupoboton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_np;
    private javax.swing.JLabel lb_pd;
    private javax.swing.JLabel lb_renglones;
    private javax.swing.JTextField nro_factura;
    private org.jdesktop.swingx.JXTaskPane panel_detalle;
    private javax.swing.JPanel panel_diferencia;
    private javax.swing.JRadioButton precioactual;
    private javax.swing.JTextField precioescogido;
    private javax.swing.JRadioButton precioleido;
    private javax.swing.JRadioButton precioparticular;
    private javax.swing.JButton procesarEP;
    private javax.swing.JTextField recibido_por;
    private javax.swing.JLabel ruta;
    private org.jdesktop.swingx.JXTable tabla;
    // End of variables declaration//GEN-END:variables
}
