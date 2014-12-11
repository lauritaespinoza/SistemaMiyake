/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import clases.IVDDComparator;
import clases.csv.CSVreader;
import modelos.mapeos.Almacen;
import modelos.mapeos.InventarioDiario;
import modelos.mapeos.InventarioDiarioDetalle;
import modelos.mapeos.InventarioTienda;
import modelos.mapeos.InventarioTiendaPK;
import modelos.mapeos.NotaCreditoDebito;
import modelos.mapeos.NotaCreditoDebitoDetalle;
import modelos.mapeos.SalidaParaTienda;
import modelos.mapeos.SalidaParaTiendaDetalle;
import modelos.mapeos.Usuario;
import gui.dialogos.JDasignadaTienda;
import gui.dialogos.JDfaturasCSV;
import gui.ventanas.JFInicioSecionMiyake;
import hibernate.DAO.DaoQuery;
import util.JavaUtil;
import hibernate.DAO.ObjectModelDAO;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelos.tablas.TableModelReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

public class JPnotaCreditoDebito extends javax.swing.JPanel {

    private List resultListNcdDetalle;
    private List resultLisNcd;
    private NotaCreditoDebito ncd;
    private final List resultListAlmacen;
    public static final String encaso_sobrante = "EN CASO DE MERCANCIA SOBRANTE";
    public static final String encaso_faltante = "EN CASO DE MERCANCIA FALTANTE";
    public static final String nota_credito = "NOTA DE CREDITO";
    public static final String nota_debito = "NOTA DE DEBITO";
    private List resultLisSalidas;
    private SalidaParaTienda spt;
    private boolean crear;
    private List<List> resultListSptDetalle;
    private Usuario user = JFInicioSecionMiyake.us1;
    public final InputStream rutaJasper = this.getClass().getResourceAsStream("/reportes/ReporteNotasDebCred.jasper");
    public final InputStream rutaJrxml = this.getClass().getResourceAsStream("/reportes/ReporteNotasDebCred.jrxml");


    public JPnotaCreditoDebito(Boolean tipo) {
        initComponents();
        this.titulo.setText(tipo ? nota_credito : nota_debito);
        this.enCaso.setText(tipo ? encaso_sobrante : encaso_faltante);
        String sql = "FROM Almacen a order by a.idAlmacen asc";
        resultListAlmacen = ObjectModelDAO.getResultQuery(sql);
        cb_tienda.removeAllItems();
        cb_tienda.addItem(JavaUtil.cons_seleccionar);
        for (Object object : resultListAlmacen) {
            Almacen a = (Almacen) object;
            cb_tienda.addItem(a.getNombre());
        }

    }

    private void cargarFacturas() {
//        resultListContacto = ObjectModelDAO.getResultQuery("FROM Contacto c order by c.idContacto asc");
//            cb_ubicacion.removeAllItems();
//            cb_contacto.removeAllItems();
//
//            for (Object object : resultListUbicacion) {
//                Ubicacion u = (Ubicacion) object;
//                cb_ubicacion.addItem(u.toString());
//            }
    }

    private void setNulls() {
        nombreAlmacen.setText("");
        rifAlmacen.setText("");
        direccionAlmacen.setText("");
        logo.setIcon(null);
        ncd = null;
        resultListNcdDetalle = null;
        tabla.setModel(new DefaultTableModel());
    }

    private void cargarHistorial() {
        setNulls();

        Thread hilo = new Thread() {
            @Override
            public void run() {

                int opc;
                busy.setVisible(true);
                busy.setBusy(true);

                Almacen alc = (Almacen) resultListAlmacen.get(cb_tienda.getSelectedIndex() - 1);

                nombreAlmacen.setText(alc.getNombre());
                rifAlmacen.setText("RIF: " + alc.getRif());
                direccionAlmacen.setText(alc.getIdUbicacion() == null
                        ? null : alc.getIdUbicacion().toString());

                JavaUtil.preCambio(alc.getLogo(), logo);

                String hql = "FROM  InventarioDiario ivd WHERE ivd.fecha > :primerof "
                        + "AND ivd.fecha<:ultimof "
                        + "AND ivd.idAlmacen=:alcm";

                DaoQuery q = ObjectModelDAO.createQueryDAO(hql);

                List rsl = ObjectModelDAO.getResultQuery(q);

//                if (rsl.size() == 1) {//hay un inventario diario
//                    ncd = (InventarioDiario) rsl.get(0);
//
//                    resultListNcdDetalle = (List) ncd.getInventarioDiarioDetalleCollection();
//                    Collections.sort(resultListNcdDetalle, comparator_ivdd);
//                    JavaUtil.displayResult(resultListNcdDetalle, tabla);
//                    tabla.packAll();
//
//                } else {
//                    if (rsl.isEmpty()) {//no hay inventario diario, se crea
//                        ncd = new InventarioDiario();
//                    } else {//hay muchos y es un error
//                        JOptionPane.showConfirmDialog(null, "Hay un error, existe mas de "
//                                + "1 inventario diario para este mes");
//                    }
//                }
                imprimir.setEnabled(tabla.getRowCount() > 0);

                busy.setVisible(false);
                busy.setBusy(false);
            }

        };
        hilo.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busy = new org.jdesktop.swingx.JXBusyLabel();
        logo = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        nombreAlmacen = new javax.swing.JLabel();
        rifAlmacen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new org.jdesktop.swingx.JXTable();
        direccionAlmacen = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        imprimir = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        fecha = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_ncd = new javax.swing.JComboBox();
        enCaso = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        facturado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        realizado = new javax.swing.JLabel();
        nuevo = new javax.swing.JButton();
        cb_salida = new javax.swing.JComboBox();
        cb_tienda = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        busy.setDirection(org.jdesktop.swingx.painter.BusyPainter.Direction.RIGHT);
        busy.setVisible(false);

        logo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        titulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titulo.setText("NOTA DE DEBITO");

        nombreAlmacen.setText(" ");

        rifAlmacen.setText(" ");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Renglón", "Referencia", "Descripción", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setToolTipText("Haga doble click en la tabla para seleccionar un renglon de Factura");
        tabla.setSortable(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        }

        direccionAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        direccionAlmacen.setText(" ");

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        imprimir.setText("Imprimir");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("jCheckBox1");

        jLabel1.setText("Fecha:");

        jLabel2.setText("Número de Factura:");

        cb_ncd.setToolTipText("Debe seleccionar una Tienda");
        cb_ncd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ncdActionPerformed(evt);
            }
        });

        enCaso.setText("EN CASO DE MERCANCIA FALTANTE");

        jLabel3.setText("Facturado:");

        jLabel5.setText("Total:");

        total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total.setText(" ");
        total.setToolTipText("Doble click para Recalcular");
        total.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        total.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        total.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalMouseClicked(evt);
            }
        });

        facturado.setText(" ");
        facturado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Realizado: ");

        realizado.setText(" ");
        realizado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nuevo.setText("+");
        nuevo.setToolTipText("Crear nueva Nota");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        cb_salida.setToolTipText("Debe crear una nueva Nota");
        cb_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_salidaActionPerformed(evt);
            }
        });

        cb_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tiendaActionPerformed(evt);
            }
        });

        jLabel4.setText("Nota pasada");

        jLabel7.setText("Tienda");

        jLabel8.setText("Nueva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jCheckBox1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(144, 144, 144)
                                                .addComponent(cb_tienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addGap(87, 87, 87))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(titulo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cb_ncd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel4)
                                                .addGap(35, 35, 35)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(nuevo)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rifAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_salida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(78, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(12, 12, 12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(enCaso)
                                        .addGap(126, 126, 126)))
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(realizado, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(facturado, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(320, 320, 320))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(direccionAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)))
                                .addComponent(imprimir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox1)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(cb_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_ncd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nuevo))
                                .addGap(16, 16, 16)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(nombreAlmacen)
                        .addGap(8, 8, 8)
                        .addComponent(rifAlmacen)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(total))
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imprimir)
                            .addComponent(guardar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(enCaso)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(facturado)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(realizado)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(direccionAlmacen)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private int getPosAt(SalidaParaTiendaDetalle sptdParam) {
        int pos = -1;//suponiendo que no esta
        for (int i = 0; i < resultListNcdDetalle.size(); i++) {
            NotaCreditoDebitoDetalle ncddIte = (NotaCreditoDebitoDetalle) resultListNcdDetalle.get(i);
            if (ncddIte.getNroRenglon().
                    equals(sptdParam.getNroRenglon())) {//es la misma
                return i;
            }
        }
        return pos;
    }

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getClickCount() == 2
                && cb_salida.getSelectedIndex() != -1
                && !cb_salida.getSelectedItem().equals(JavaUtil.cons_seleccionar)
                && cb_ncd.getSelectedIndex() != -1
                && cb_ncd.getSelectedItem().equals(JavaUtil.cons_seleccionar)) {

            JDasignadaTienda jdAT = new JDasignadaTienda(null, true, resultListSptDetalle);
            jdAT.setVisible(true);
            if (jdAT.sptd != null) {
                int pos = getPosAt(jdAT.sptd);
                if (pos == -1) {//si es igual a -1 no lo encontro, por ende puede agregarlo
                    NotaCreditoDebitoDetalle ncdd = new NotaCreditoDebitoDetalle(jdAT.sptd.getNroRenglon(), ncd, jdAT.sptd.getProducto());
                    resultListNcdDetalle.add(ncdd);
                    if (tabla.getRowCount() == 0) {//esta vacia, se crea
                        JavaUtil.displayResult(resultListNcdDetalle, tabla);
                    } else { //agrega
                        ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{
                            ncdd.getNroRenglon(),
                            ncdd.getIdProducto().getReferenciaProducto(),
                            ncdd.getIdProducto().getDescripcion(),
                            0,
                            ObjectModelDAO.getObject(new InventarioTiendaPK(
                            ncdd.getIdProducto().getIdProducto(),
                            ncdd.getIdNotaCreditoDebito().getIdSalida().getIdAlmacenHasta().getIdAlmacen()
                            ), InventarioTienda.class).getPrecioConDescuento()
                        });
                    }
                } else {
                    tabla.setRowSelectionInterval(pos, pos);
                    JOptionPane.showMessageDialog(null, "El renglón seleccionado ya está en la nota");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No seleccionó ningun renglón de la Factura");
            }
        }
    }//GEN-LAST:event_tablaMouseClicked

    private boolean filaCorrecta(int i) {//hacer con for
        Object o0 = tabla.getModel().getValueAt(i, 0);
        Object o1 = tabla.getModel().getValueAt(i, 1);
        Object o2 = tabla.getModel().getValueAt(i, 2);
        Object o3 = tabla.getModel().getValueAt(i, 3);
        Object o4 = tabla.getModel().getValueAt(i, 4);
        if ((o0 != null && !o0.equals(""))//el primero debe estar
                && (o1 != null && !o1.equals(""))//el segundo debe estar
                && ((o2 != null && !o2.equals(""))//el tercero puede estar
                || (o3 != null && !o3.equals(""))//el cuarto puede estar
                || (o4 != null && !o4.equals(""))))//el quinto puede estar
        {
            return true;
        }
        return false;
    }

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
         try {
            JasperPrint jasperPrint = null;

            Map<String, Object> parametro = new HashMap<>();
            String s = "";

            if (getTipo()) {
                parametro.put("Titulo", nota_credito);
                parametro.put("Caso", encaso_sobrante);
            } else {
                parametro.put("Titulo", nota_debito);
                parametro.put("Caso", encaso_faltante);
            }
            parametro.put("NumFactura", cb_salida.getSelectedItem());
            parametro.put("Facturado", facturado.getText());
            parametro.put("Realizado", realizado.getText());
            parametro.put("Fecha",new SimpleDateFormat("dd-MM-yyyy").format(fecha.getDate()));
            parametro.put("Direccion", direccionAlmacen.getText());
            parametro.put("Tienda", nombreAlmacen.getText());
            parametro.put("Rif", rifAlmacen.getText());

            TableModelReport dataSourse = new TableModelReport(tabla.getModel());

            parametro.put("REPORT_DATA_SOURCE", dataSourse);
            //parametro.put("Total", total.getText());
            JasperCompileManager.compileReport(rutaJrxml);
            jasperPrint = JasperFillManager.fillReport(rutaJasper, parametro, dataSourse);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setTitle("Reporte de Nota");
            jasperViewer.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error" + e);
        }

    }//GEN-LAST:event_imprimirActionPerformed

    private boolean calcularTotal() {

        String filas_incorrectas = "";
        int errores = 0;
        float total = 0f;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            Object o = tabla.getModel().getValueAt(i, 3);
            int cantidad = 0;
            String str;

            if (o instanceof String) {
                str = (String) o;
            }
            if (o instanceof Integer) {
                cantidad = (Integer) o;
            }

            if (cantidad > 0) {
                if (errores == 0) {
                    int precio = Integer.parseInt((String) tabla.getModel().getValueAt(i, 4));
                    total += precio * cantidad;
                    ((NotaCreditoDebitoDetalle) resultListNcdDetalle.get(i)).setCantidadProducto(cantidad);
                }
            } else {
                filas_incorrectas += (i + 1) + "\n";
                errores++;
            }
        }
        if (errores > 0) {
            JOptionPane.showMessageDialog(null, "Existen " + errores
                    + " errore(s) en los siguientes renglones, porfavor revisar:\n" + filas_incorrectas);
            return false;
        } else {
            this.total.setText(JavaUtil.dosDecimales.format(total));
            ncd.setTotal(total);
            return true;
        }

    }

//
    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

        if (fecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha");
            return;
        }
        if (cb_salida.getSelectedIndex() == -1
                || cb_salida.getSelectedItem().equals(JavaUtil.cons_seleccionar)) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una factura");
            return;
        }
        if (tabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un reglón de la factura");
            return;
        }

        if (JOptionPane.showConfirmDialog(null, "¿Desea Guardar?, no habrá posibilidad de cambio.", "Sugerencia", JOptionPane.YES_NO_OPTION)
                == JOptionPane.NO_OPTION) {
            return;//sino quiere
        }

        if (!calcularTotal()) {
            return;
        }

        ncd.setFecha(fecha.getDate());
        ObjectModelDAO.saveObject(ncd);

        for (Object o : resultListNcdDetalle) {
            ObjectModelDAO.saveObject((NotaCreditoDebitoDetalle) o);
        }

        //si es debito suma IVT en desde: suma porque falta en hasta
        //si es credito resta en IVT en desde: resta porque sobra en hasta
//        String hql="FROM";
//        List resultListIVT=
//        if (getTipo()) {
//            
//        } else {
//
//        }

        cb_tiendaActionPerformed(null);
    }//GEN-LAST:event_guardarActionPerformed

    private void cb_ncdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ncdActionPerformed

        if (cb_ncd.getSelectedIndex() != -1
                && cb_ncd.getSelectedItem().equals(JavaUtil.cons_seleccionar)
                && !crear) {

            cb_salida.setSelectedItem(JavaUtil.cons_seleccionar);
            spt = null;
            facturado.setText(" ");
            total.setText(" ");
            imprimir.setEnabled(false);
            guardar.setEnabled(false);
            fecha.setEnabled(false);
            fecha.setDate(null);
            tabla.setModel(new DefaultTableModel());
            ncd = null;
            resultListNcdDetalle = null;
            cb_salida.setEnabled(false);
            return;
        }

        if (cb_ncd.getSelectedIndex() != -1 && cb_tienda.getSelectedIndex() != -1
                && !cb_tienda.getSelectedItem().equals(JavaUtil.cons_seleccionar)
                && !cb_ncd.getSelectedItem().equals(JavaUtil.cons_seleccionar)) {

            // llena todos los campos con la consulta
            crear = false;
            resultListSptDetalle = null;
            ncd = (NotaCreditoDebito) resultLisNcd.get(cb_ncd.getSelectedIndex() - 1);
            String hql = "FROM NotaCreditoDebitoDetalle ncdd WHERE ncdd.idNotaCreditoDebito=:idNcd";
            DaoQuery q = ObjectModelDAO.createQueryDAO(hql);
            q.getQuery().setParameter("idNcd", ncd);
            resultListNcdDetalle = ObjectModelDAO.getResultQuery(q);
            if (!resultListNcdDetalle.isEmpty()) {
                cb_salida.setSelectedItem(ncd.getIdSalida().getIdSalida());
                JavaUtil.displayResult(resultListNcdDetalle, tabla);
                fecha.setDate(ncd.getFecha());
                total.setText(JavaUtil.dosDecimales.format(ncd.getTotal()));
                facturado.setText(ncd.getIdUsuario().getNombre() + " : " + ncd.getIdUsuario().getDescripcion());
                realizado.setText(user.getNombre() + " : " + user.getDescripcion());
                fecha.setEnabled(false);
                cb_salida.setEnabled(false);
                tabla.setEditable(false);
                JOptionPane.showMessageDialog(null, "No es posible MODIFICAR una nota PASADA");
            } else {
                JOptionPane.showMessageDialog(null, "La nota no tiene detalle");
            }

        }
    }//GEN-LAST:event_cb_ncdActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        crear = true;
        cb_ncd.setSelectedItem(JavaUtil.cons_seleccionar);
        imprimir.setEnabled(true);
        guardar.setEnabled(true);
        fecha.setEnabled(true);
        fecha.setDate(null);
        tabla.setModel(new DefaultTableModel());
        cb_salida.setSelectedItem(JavaUtil.cons_seleccionar);
        cb_salida.setEnabled(true);
        cb_salida.requestFocus();
        total.setText(" ");
        facturado.setText(" ");
        tabla.setEditable(true);
        ncd = null;
    }//GEN-LAST:event_nuevoActionPerformed

    private void cb_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_salidaActionPerformed
        if (cb_salida.getSelectedIndex() == -1 || cb_salida.getSelectedItem().equals(JavaUtil.cons_seleccionar)) {
            spt = null;
            return;
        }
        imprimir.setEnabled(true);
        guardar.setEnabled(crear);//si esta creando sino no
        resultListSptDetalle = null;
        tabla.setModel(new DefaultTableModel());
        if (crear) {
            resultListNcdDetalle = new ArrayList();
            spt = (SalidaParaTienda) resultLisSalidas.get(cb_salida.getSelectedIndex() - 1);
            String HQL = "SELECT s,ppt.precioConDescuento,ppt.descuento "
                    + "FROM SalidaParaTiendaDetalle s,InventarioTienda ppt INNER JOIN  s.salidaParaTienda spt"
                    + " WHERE spt =:spt"
                    + " AND ppt.producto=s.producto AND ppt.almacen=spt.idAlmacenHasta";
            DaoQuery q = ObjectModelDAO.createQueryDAO(HQL);
            q.getQuery().setParameter("spt", spt);
            resultListSptDetalle = ObjectModelDAO.getResultQuery(q);

            if (ncd == null) {
                ncd = new NotaCreditoDebito(getTipo(), spt, user);
            }

            JOptionPane.showMessageDialog(null, "Haga doble click en la tabla"
                    + " para seleccionar algún renglón de la factura");
        }
    }//GEN-LAST:event_cb_salidaActionPerformed

    private void cb_tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tiendaActionPerformed

        imprimir.setEnabled(false);
        guardar.setEnabled(false);
        fecha.setEnabled(false);
        fecha.setDate(null);
        tabla.setModel(new DefaultTableModel());

        cb_ncd.removeAllItems();
        cb_salida.removeAllItems();
        cb_salida.setEnabled(false);
        ncd = null;
        spt = null;
        cb_ncd.setEnabled(false);
        resultListNcdDetalle = null;
        resultLisNcd = null;
        resultLisSalidas = null;
        facturado.setText(" ");
        total.setText(" ");
        nuevo.setEnabled(false);
        nombreAlmacen.setText(" ");
        rifAlmacen.setText(" ");
        direccionAlmacen.setText(" ");
        logo.setIcon(null);
        crear = false;
        if (cb_tienda.getSelectedItem().equals(JavaUtil.cons_seleccionar)
                || cb_tienda.getSelectedIndex() == -1) {
            return;
        }

        Almacen alc = (Almacen) resultListAlmacen.get(cb_tienda.getSelectedIndex() - 1);
        JavaUtil.preCambio(alc.getLogo(), logo);
        nombreAlmacen.setText(alc.getNombre());
        rifAlmacen.setText("RIF: " + alc.getRif()== null? "" :alc.getRif());
        direccionAlmacen.setText(alc.getIdUbicacion() == null
                ? "" : alc.getIdUbicacion().toString());
        String hql = "FROM NotaCreditoDebito ncd WHERE ncd.tipo=:tipo AND ncd.idSalida.revisado=:revisado "
                + "AND ncd.idSalida.idAlmacenHasta=:almacen ORDER BY ncd.idNotaCreditoDebito asc";
//        String hql = "FROM NotaCreditoDebito ncd WHERE ncd.tipo=:tipo AND ncd.idSalida.idAlmacenHasta=:almacen order by ncd.idNotaCreditoDebito asc";
        DaoQuery q = ObjectModelDAO.createQueryDAO(hql);
        q.getQuery().setParameter("tipo", getTipo());
        q.getQuery().setParameter("revisado", true);
        q.getQuery().setParameter("almacen", alc);

        resultLisNcd = ObjectModelDAO.getResultQuery(q);
        cb_ncd.addItem(JavaUtil.cons_seleccionar);
        for (Object object : resultLisNcd) {
            NotaCreditoDebito ncd = (NotaCreditoDebito) object;
            cb_ncd.addItem(ncd.getIdNotaCreditoDebito());
        }

        cb_ncd.requestFocus();
        hql = "FROM SalidaParaTienda spt WHERE spt.idAlmacenHasta=:almacen AND spt.revisado=:revisado ORDER BY spt.idSalida asc";
        q = ObjectModelDAO.createQueryDAO(hql);
        q.getQuery().setParameter("almacen", alc);
        q.getQuery().setParameter("revisado", true);
        resultLisSalidas = ObjectModelDAO.getResultQuery(q);
        cb_salida.addItem(JavaUtil.cons_seleccionar);
        for (Object object : resultLisSalidas) {
            SalidaParaTienda spt = (SalidaParaTienda) object;
            cb_salida.addItem(spt.getIdSalida());
        }
        nuevo.setEnabled(true);
        cb_ncd.setEnabled(true);
    }//GEN-LAST:event_cb_tiendaActionPerformed

    private void tablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyReleased
        //si esta creando, y si le da a delete
        if (crear && tabla.getSelectedRow() != -1
                && evt.getKeyCode() == KeyEvent.VK_DELETE
                && JOptionPane.showConfirmDialog(null, "Desea eliminar el renglón del detalle?",
                        "Advertencia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            resultListNcdDetalle.remove(tabla.getSelectedRow());
            ((DefaultTableModel) tabla.getModel()).removeRow(tabla.getSelectedRow());
        }
    }//GEN-LAST:event_tablaKeyReleased

    private void totalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalMouseClicked
        if (evt.getClickCount() == 2 && !crear) {
            calcularTotal();
        }
    }//GEN-LAST:event_totalMouseClicked

    private boolean getTipo() {
        switch (titulo.getText()) {
            case nota_credito:
                return true;
            default://nota de debito
                return false;
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame();
                f.setContentPane(new JPnotaCreditoDebito(true));
                f.pack();
                f.setVisible(true);
                f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JComboBox cb_ncd;
    private javax.swing.JComboBox cb_salida;
    private javax.swing.JComboBox cb_tienda;
    private javax.swing.JLabel direccionAlmacen;
    private javax.swing.JLabel enCaso;
    private javax.swing.JLabel facturado;
    private org.jdesktop.swingx.JXDatePicker fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JButton imprimir;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nombreAlmacen;
    private javax.swing.JButton nuevo;
    private javax.swing.JLabel realizado;
    private javax.swing.JLabel rifAlmacen;
    private org.jdesktop.swingx.JXTable tabla;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

}
