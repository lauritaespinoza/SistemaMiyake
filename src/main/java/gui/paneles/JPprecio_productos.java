/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import util.JavaUtil;
import static util.JavaUtil.setTableCellAlignment;
import hibernate.DAO.ObjectModelDAO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelos.mapeos.Almacen;
import modelos.mapeos.InventarioTienda;
import org.hibernate.Query;

/**
 *
 * @author Usuario
 */
public class JPprecio_productos extends javax.swing.JPanel {

    private Almacen cabecera = null;
    private List resultListProducto;
    private List resultListAlmacen = null;
    private int pos;
    private int posi;

    public JPprecio_productos() {
        initComponents();
        setTableCellAlignment(JLabel.CENTER, tablaproductos_con_precios);
        setTableCellAlignment(JLabel.CENTER, tablaproductos_con_precios1);
        tablaproductos_con_precios.getTableHeader().setReorderingAllowed(false);
        tablaproductos_con_precios1.getTableHeader().setReorderingAllowed(false);

        tablaproductos_con_precios1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {

                    if (tablaproductos_con_precios1.getSelectedRow() == -1) {
                        posi = -1;
                        lb_productoSeleccionado.setText("");
                        lb_precioSinDescuento.setText("");
                        lb_preciocondescuento.setText("");
                        field_precio.setText("");
                        lb_idProductoSeleccionado.setText("");
                        return;
                    }
                    posi = tablaproductos_con_precios1.getSelectedRow();
                    InventarioTienda ivt = (InventarioTienda) resultListProducto.get(posi);
                    lb_productoSeleccionado.setText(ivt.getProducto().getDescripcion());
                    lb_idProductoSeleccionado.setText(ivt.getProducto().getIdProducto().toString());
                    lb_precioSinDescuento.setText(ivt.getPrecioSinDescuento().toString());
                    lb_preciocondescuento.setText(ivt.getPrecioConDescuento().toString());
                    field_precio.setText(ivt.getPrecioSinDescuento().toString());
                    cb_descuento.setSelectedItem(ivt.getDescuento().toString());
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ru_precios_productos = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaproductos_con_precios = new org.jdesktop.swingx.JXTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_almacen = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaproductos_con_precios1 = new org.jdesktop.swingx.JXTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cb_almacen_modf = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cb_descuento = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        field_precio = new javax.swing.JTextField();
        bt_actualizarprecio = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lb_idProductoSeleccionado = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_productoSeleccionado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lb_precioSinDescuento = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lb_preciocondescuento = new javax.swing.JLabel();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        ru_precios_productos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ru_precios_productosStateChanged(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        tablaproductos_con_precios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Producto", "Nombre Producto", "Precio", "Descuento", "Fecha de Creación", "Fecha de Modificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaproductos_con_precios);
        if (tablaproductos_con_precios.getColumnModel().getColumnCount() > 0) {
            tablaproductos_con_precios.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaproductos_con_precios.getColumnModel().getColumn(1).setPreferredWidth(150);
            tablaproductos_con_precios.getColumnModel().getColumn(2).setPreferredWidth(50);
            tablaproductos_con_precios.getColumnModel().getColumn(3).setMinWidth(35);
            tablaproductos_con_precios.getColumnModel().getColumn(3).setPreferredWidth(25);
            tablaproductos_con_precios.getColumnModel().getColumn(4).setPreferredWidth(80);
            tablaproductos_con_precios.getColumnModel().getColumn(5).setMinWidth(100);
            tablaproductos_con_precios.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Tienda:");

        cb_almacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_almacenActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1416622346_xmag.png"))); // NOI18N
        jLabel11.setText("Para realizar Busqueda: Haga Click en la tabla + CTRL F");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_almacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jScrollPane2.setViewportView(jPanel1);

        ru_precios_productos.addTab("Consultar", jScrollPane2);

        jPanel2.setLayout(new java.awt.BorderLayout());

        tablaproductos_con_precios1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Producto", "Nombre Producto", "Precio", "Descuento", "Fecha de Creación", "Fecha de Modificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaproductos_con_precios1.setToolTipText("Presione la tecla \"ESC\" para deseleccionar el item");
        tablaproductos_con_precios1.setHorizontalScrollEnabled(true);
        tablaproductos_con_precios1.setSortable(false);
        tablaproductos_con_precios1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaproductos_con_precios1KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tablaproductos_con_precios1);
        if (tablaproductos_con_precios1.getColumnModel().getColumnCount() > 0) {
            tablaproductos_con_precios1.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaproductos_con_precios1.getColumnModel().getColumn(1).setPreferredWidth(150);
            tablaproductos_con_precios1.getColumnModel().getColumn(2).setPreferredWidth(50);
            tablaproductos_con_precios1.getColumnModel().getColumn(3).setMinWidth(35);
            tablaproductos_con_precios1.getColumnModel().getColumn(3).setPreferredWidth(25);
            tablaproductos_con_precios1.getColumnModel().getColumn(4).setPreferredWidth(80);
            tablaproductos_con_precios1.getColumnModel().getColumn(5).setMinWidth(100);
            tablaproductos_con_precios1.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.X_AXIS));

        jLabel2.setText("Tienda:");

        cb_almacen_modf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_almacen_modfActionPerformed(evt);
            }
        });

        jLabel4.setText("% Descuento:");

        cb_descuento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "0", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1416622346_xmag.png"))); // NOI18N
        jLabel3.setText("Para realizar Busqueda: Haga Click en la tabla + CTRL F");

        jLabel5.setText("Precio del Producto:");

        bt_actualizarprecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415656862_Circulation.png"))); // NOI18N
        bt_actualizarprecio.setText("Actualizar Precio");
        bt_actualizarprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_actualizarprecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addComponent(cb_almacen_modf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(22, 22, 22)
                        .addComponent(cb_descuento, 0, 241, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(field_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_actualizarprecio)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_almacen_modf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(field_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bt_actualizarprecio)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel4);

        jLabel10.setText("Id Producto:");

        jLabel7.setText("Producto Seleccionado:");

        jLabel8.setText("Precio sin Descuento:");

        jLabel9.setText("Precio con Descuento:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(lb_preciocondescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_productoSeleccionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_idProductoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 19, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_precioSinDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(158, 158, 158)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(lb_idProductoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(lb_productoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(lb_precioSinDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lb_preciocondescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel5);

        jPanel2.add(jPanel6, java.awt.BorderLayout.NORTH);

        jScrollPane4.setViewportView(jPanel2);

        ru_precios_productos.addTab("Modificar", jScrollPane4);

        add(ru_precios_productos);
    }// </editor-fold>//GEN-END:initComponents

    private void cb_almacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_almacenActionPerformed

        String HQL;

        if (cb_almacen.getSelectedIndex() == -1 || cb_almacen.getSelectedItem().equals(JavaUtil.cons_seleccionar)) {
            tablaproductos_con_precios.setModel(new DefaultTableModel());
            return;
        }
        if (cb_almacen.getSelectedItem().equals("Todas las Tiendas")) {
            HQL = "FROM InventarioTienda ivt ORDER BY ivt.producto.idProducto";

        } else {
            HQL = "FROM InventarioTienda ivt WHERE ivt.almacen.idAlmacen= "
                    + ((Almacen) resultListAlmacen.get(cb_almacen.getSelectedIndex() - 2)).getIdAlmacen()
                    + " ORDER BY ivt.producto.idProducto";
        }        
        resultListProducto = ObjectModelDAO.getResultQuery(HQL);

        if (resultListProducto.isEmpty()) {
            tablaproductos_con_precios.setModel(new DefaultTableModel());
            return;
        }
        JavaUtil.displayResult(resultListProducto, tablaproductos_con_precios);
        tablaproductos_con_precios.setEditable(false);
    }//GEN-LAST:event_cb_almacenActionPerformed

    private boolean busqueda_producto_tiendas(int id_producto) {

        String sql = "FROM Producto p WHERE p.idProducto=" + id_producto;
        resultListProducto = ObjectModelDAO.getResultQuery(sql);
        if (resultListProducto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Este producto no existe, Verifique e inténtelo nuevamente");
            return false;
        }

        for (int j = 0; j < resultListAlmacen.size(); j++) {

            String HQL = "FROM InventarioTienda ivt WHERE ivt.almacen.idAlmacen= "
                    + ((Almacen) resultListAlmacen.get(j)).getIdAlmacen()
                    + " AND ivt.producto.idProducto= " + id_producto;

            resultListProducto = ObjectModelDAO.getResultQuery(HQL);

            if (resultListProducto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Este producto no se encuentra en todas las tiendas"
                        + "\n" + "La modificación de precio no se realizará");
                return false;
            }
        }
        return true;
    }

    private void bt_actualizarprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_actualizarprecioActionPerformed
        int descuento;

        if (cb_almacen_modf.getSelectedItem().equals(JavaUtil.cons_seleccionar)) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una Tienda");
            return;
        }

        if (posi == -1 && !field_precio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar un Producto para cambiar el precio");
            return;
        }

        if (cb_descuento.getSelectedItem().equals(JavaUtil.cons_seleccionar)
                && posi == -1 && field_precio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar opcion a realizar");
            return;
        }

        if (cb_descuento.getSelectedItem().equals("Seleccionar")) {
            descuento = -1;
        } else {
            descuento = Integer.parseInt((String) cb_descuento.getSelectedItem());
        }

        String HQL;
        //guardar el precio que el usuario escribio!
        //todos los productos en inventario
        if (posi == -1 && field_precio.getText().equals("")) {
            //si elige todas las tienda
            if (cb_almacen_modf.getSelectedItem().equals("Todas las Tiendas")) {

                if (JOptionPane.showConfirmDialog(null, "¿Está seguro de modificar el precio de todos los"
                        + "Productos en todas las tiendas?", "Información",
                        JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                    return;
                }
            } else {//si elige una tienda

                if (JOptionPane.showConfirmDialog(null, "¿Está seguro de modificar el precio de todos "
                        + "los Productos en la tienda: " + cb_almacen_modf.getSelectedItem() + "?", 
                        "Información",JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            for (int j = 0; j < resultListProducto.size(); j++) {

                InventarioTienda ivt = (InventarioTienda) resultListProducto.get(j);
                if (descuento == -1) {///el selecciono "Seleccionar", entonces no se modifica el descuento
                    descuento = ivt.getDescuento();
                }
                ivt.setPrecioSinDescuento(ivt.getPrecioSinDescuento());
                float descuentof = (ivt.getPrecioSinDescuento() * descuento) / 100;
                ivt.setDescuento(descuento);
                ivt.setPrecioConDescuento(ivt.getPrecioSinDescuento() - descuentof);
                ivt.setFechaModificacion(Calendar.getInstance().getTime());
                ObjectModelDAO.updateObject(ivt);
            }
            cb_almacen_modfActionPerformed(null);
        }

        //eligio un producto y tiene precio
        if (posi != -1 && !field_precio.getText().equals("")) {
            //si elige todas las tienda
            if (cb_almacen_modf.getSelectedItem().equals("Todas las Tiendas")) {

                if (JOptionPane.showConfirmDialog(null, "¿Está seguro de modificar el precio del Producto: "
                        + lb_productoSeleccionado.getText() + " en todas las tiendas?", "Información",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    HQL = "FROM InventarioTienda ivt WHERE ivt.producto.idProducto= "
                            + Integer.parseInt(lb_idProductoSeleccionado.getText())
                            + "ORDER BY ivt.producto.idProducto";
                } else {
                    return;
                }

            } else {//si elige una tienda

                if (JOptionPane.showConfirmDialog(null, "¿Está seguro de modificar el precio del Producto: "
                        + lb_productoSeleccionado.getText() + "en la tienda: " + cb_almacen_modf.getSelectedItem() + "?", "Información",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    HQL = "FROM InventarioTienda ivt WHERE ivt.almacen.idAlmacen= "
                            + ((Almacen) resultListAlmacen.get(cb_almacen_modf.getSelectedIndex() - 2)).getIdAlmacen()
                            + " AND ivt.producto.idProducto= "
                            + Integer.parseInt(lb_idProductoSeleccionado.getText())
                            + "ORDER BY ivt.producto.idProducto";

                } else {
                    return;
                }
            }

            int posOr = this.posi;
            List resultListProductoInterno = ObjectModelDAO.getResultQuery(HQL);

            for (int j = 0; j < resultListProductoInterno.size(); j++) {

                InventarioTienda ivt = (InventarioTienda) resultListProductoInterno.get(j);
                if (descuento == -1) {///el selecciono "Seleccionar", entonces no se modifica el descuento
                    descuento = ivt.getDescuento();
                }
                ivt.setPrecioSinDescuento(Float.parseFloat(field_precio.getText()));
                float descuentof = (ivt.getPrecioSinDescuento() * descuento) / 100;
                ivt.setDescuento(descuento);
                ivt.setPrecioConDescuento(ivt.getPrecioSinDescuento() - descuentof);
                ivt.setFechaModificacion(Calendar.getInstance().getTime());
                ObjectModelDAO.updateObject(ivt);
            }

            posi = -1;
            cb_almacen_modfActionPerformed(null);
            tablaproductos_con_precios1.setRowSelectionInterval(posOr, posOr);
        }
    }//GEN-LAST:event_bt_actualizarprecioActionPerformed

    private void cb_almacen_modfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_almacen_modfActionPerformed

        String HQL;

        if (cb_almacen_modf.getSelectedIndex() == -1 || cb_almacen_modf.getSelectedItem().equals(JavaUtil.cons_seleccionar)) {
            tablaproductos_con_precios1.setModel(new DefaultTableModel(new Vector(), new Vector()));
            return;
        }
        if (cb_almacen_modf.getSelectedItem().equals("Todas las Tiendas")) {
            HQL = "FROM InventarioTienda ivt ORDER BY ivt.producto.idProducto";

        } else {
            HQL = "FROM InventarioTienda ivt WHERE ivt.almacen.idAlmacen= "
                    + ((Almacen) resultListAlmacen.get(cb_almacen_modf.getSelectedIndex() - 2)).getIdAlmacen()
                    + " ORDER BY ivt.producto.idProducto";
        }
        // System.out.println(HQL);
        resultListProducto = ObjectModelDAO.getResultQuery(HQL);

        if (resultListProducto.isEmpty()) {
            tablaproductos_con_precios1.setModel(new DefaultTableModel());
            return;
        }
        posi = -1;
        JavaUtil.displayResult(resultListProducto, tablaproductos_con_precios1);
        tablaproductos_con_precios1.setEditable(false);

    }//GEN-LAST:event_cb_almacen_modfActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            tablaproductos_con_precios1.getSelectionModel().clearSelection();
        }
    }//GEN-LAST:event_formKeyReleased

    private void tablaproductos_con_precios1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaproductos_con_precios1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            tablaproductos_con_precios1.getSelectionModel().clearSelection();
            cb_descuento.setSelectedIndex(0);//seleccionar
        }
    }//GEN-LAST:event_tablaproductos_con_precios1KeyReleased

    private void ru_precios_productosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ru_precios_productosStateChanged
        if (ru_precios_productos.getSelectedIndex() == 0) {
            
            resultListAlmacen = ObjectModelDAO.getResultQuery("FROM Almacen a order by a.idAlmacen asc");
            cb_almacen.removeAllItems();
            cb_almacen.addItem(JavaUtil.cons_seleccionar);
            cb_almacen.addItem("Todas las Tiendas");
            for (Object object : resultListAlmacen) {
                Almacen a = (Almacen) object;
                cb_almacen.addItem(a.getNombre());
            }
        }
        if (ru_precios_productos.getSelectedIndex() == 1) {

           // fieldBusquedaModif.setText("");
            field_precio.setText("");
            resultListAlmacen = ObjectModelDAO.getResultQuery("FROM Almacen a order by a.idAlmacen asc");
            cb_almacen_modf.removeAllItems();
            cb_almacen_modf.addItem(JavaUtil.cons_seleccionar);
            cb_almacen_modf.addItem("Todas las Tiendas");
            for (Object object : resultListAlmacen) {
                Almacen a = (Almacen) object;
                cb_almacen_modf.addItem(a.getNombre());
            }
        }

    }//GEN-LAST:event_ru_precios_productosStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_actualizarprecio;
    private javax.swing.JComboBox cb_almacen;
    private javax.swing.JComboBox cb_almacen_modf;
    private javax.swing.JComboBox cb_descuento;
    private javax.swing.JTextField field_precio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lb_idProductoSeleccionado;
    private javax.swing.JLabel lb_precioSinDescuento;
    private javax.swing.JLabel lb_preciocondescuento;
    private javax.swing.JLabel lb_productoSeleccionado;
    private javax.swing.JTabbedPane ru_precios_productos;
    private org.jdesktop.swingx.JXTable tablaproductos_con_precios;
    private org.jdesktop.swingx.JXTable tablaproductos_con_precios1;
    // End of variables declaration//GEN-END:variables
}
