/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

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
    private List resultListSptDetalle;//lista de vector de index 3. vease el hql
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

    private void setNulls() {
        nombreAlmacen.setText("");
        rifAlmacen.setText("");
        direccionAlmacen.setText("");
        logo.setIcon(null);
        ncd = null;
        resultListNcdDetalle = null;
        tabla.setModel(new DefaultTableModel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCabecera = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        nombreAlmacen = new javax.swing.JLabel();
        rifAlmacen = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_tienda = new javax.swing.JComboBox();
        titulo = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cb_ncd = new javax.swing.JComboBox();
        nuevo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fecha = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        cb_salida = new javax.swing.JComboBox();
        PanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new org.jdesktop.swingx.JXTable();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        PanelFinal = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        enCaso = new javax.swing.JLabel();
        direccionAlmacen = new javax.swing.JLabel();
        facturado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        realizado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        imprimir = new javax.swing.JButton();
        guardar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        PanelCabecera.setLayout(new javax.swing.BoxLayout(PanelCabecera, javax.swing.BoxLayout.LINE_AXIS));

        logo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nombreAlmacen.setText(" ");

        rifAlmacen.setText(" ");

        jLabel7.setText("Tienda");

        cb_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tiendaActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titulo.setText("NOTA DE DEBITO");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("jCheckBox1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titulo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rifAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1)))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titulo)
                        .addGap(38, 38, 38)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nombreAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rifAlmacen)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, 0))
        );

        PanelCabecera.add(jPanel2);

        jLabel4.setText("Nota pasada");

        cb_ncd.setToolTipText("Debe seleccionar una Tienda");
        cb_ncd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ncdActionPerformed(evt);
            }
        });

        nuevo.setText("+");
        nuevo.setToolTipText("Crear nueva Nota");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        jLabel8.setText("Nueva");

        jLabel1.setText("Fecha:");

        jLabel2.setText("Número de Factura:");

        cb_salida.setToolTipText("Debe crear una nueva Nota");
        cb_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_salidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cb_ncd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(38, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(nuevo)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_ncd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        PanelCabecera.add(jPanel3);

        add(PanelCabecera, java.awt.BorderLayout.NORTH);

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

        busy.setDirection(org.jdesktop.swingx.painter.BusyPainter.Direction.RIGHT);
        busy.setVisible(false);

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTablaLayout.createSequentialGroup()
                    .addContainerGap(386, Short.MAX_VALUE)
                    .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(403, 403, 403)))
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelTablaLayout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        add(PanelTabla, java.awt.BorderLayout.CENTER);

        PanelFinal.setLayout(new javax.swing.BoxLayout(PanelFinal, javax.swing.BoxLayout.LINE_AXIS));

        enCaso.setText("EN CASO DE MERCANCIA FALTANTE");

        direccionAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        direccionAlmacen.setText(" ");

        facturado.setText(" ");
        facturado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Realizado: ");

        realizado.setText(" ");
        realizado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Facturado:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(direccionAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(realizado, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(facturado, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(enCaso)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facturado)
                    .addComponent(jLabel3)
                    .addComponent(enCaso))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realizado)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(direccionAlmacen)
                .addContainerGap())
        );

        PanelFinal.add(jPanel4);

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

        imprimir.setText("Imprimir");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imprimir)
                        .addGap(18, 18, 18)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 133, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(imprimir))
                .addGap(19, 19, 19))
        );

        PanelFinal.add(jPanel5);

        add(PanelFinal, java.awt.BorderLayout.SOUTH);
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
                            JavaUtil.dosDecimales.format(ObjectModelDAO.getObject(new InventarioTiendaPK(
                            ncdd.getIdProducto().getIdProducto(),
                            ncdd.getIdNotaCreditoDebito().getIdSalida().getIdAlmacenHasta().getIdAlmacen()
                            ), InventarioTienda.class
                            ).getPrecioConDescuento()
                            ).replace(",", ".")
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
            JasperPrint jasperPrint2 = null;

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
            parametro.put("Fecha",fecha.getDate());
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

    private boolean isCorrectCantidad(int cantidad, int renglonSPTD) {
        boolean sw = false;
        for (Object resultListNcdDetalle1 : resultListSptDetalle) {
            SalidaParaTiendaDetalle sptd
                    = (SalidaParaTiendaDetalle) ((Object[]) resultListNcdDetalle1)[0];

            //si es el renglon y la cantidad es menor o igual a la de la factura
            if (sptd.getNroRenglon() == renglonSPTD && cantidad <= sptd.getCantidadProducto()) {
                sw = true;
                break;
            }

            //si es el renglon y la cantidad es mayor a la de la factura
            if (sptd.getNroRenglon() == renglonSPTD && cantidad > sptd.getCantidadProducto()) {
                sw = false;
                break;
            }
        }

        return sw;
    }

    private boolean calcularTotal() {

        String filas_incorrectas = "";
        int errores = 0;
        float totalCalculo = 0f;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            Object oCantidad = tabla.getModel().getValueAt(i, 3);//cantidad
            int cantidad = 0;
            String str;
            Object oRenglon = tabla.getModel().getValueAt(i, 0);//renglon
            int renglon = 0;
            try {
                //cantidad
                if (oCantidad instanceof String) {
                    str = (String) oCantidad;
                    cantidad = Integer.parseInt(str);
                }
                if (oCantidad instanceof Integer) {
                    cantidad = (Integer) oCantidad;
                }
                //renglon
                if (oRenglon instanceof String) {
                    str = (String) oRenglon;
                    renglon = Integer.parseInt(str);
                }
                if (oRenglon instanceof Integer) {
                    renglon = (Integer) oRenglon;
                }

                if (cantidad > 0) {
                    //si es debito y la cantidad no es correcta
                    if (!getTipo() && !isCorrectCantidad(cantidad, renglon)) {
                        filas_incorrectas += renglon + "\n";
                        errores++;
                    }

                    if (errores == 0) {//evita calcular cuando ya hay error en otro renglon
                        Object oPrecio = tabla.getModel().getValueAt(i, 4);//precio
                        float precio = 0;
                        //precio
                        if (oPrecio instanceof String) {
                            str = (String) oPrecio;
                            precio = Float.parseFloat(str);
                        }
                        if (oPrecio instanceof Float) {
                            precio = (Float) oPrecio;
                        }
                        totalCalculo += precio * cantidad;
                        ((NotaCreditoDebitoDetalle) resultListNcdDetalle.get(i)).setCantidadProducto(cantidad);
                    }
                } else {
                    filas_incorrectas += renglon + "\n";
                    errores++;
                }

            } catch (Exception e) {
                Logger.getLogger(JPnotaCreditoDebito.class.getName()).log(Level.SEVERE, null, e);
                filas_incorrectas += renglon + "\n";
                errores++;
            }
        }
        if (errores > 0) {
            JOptionPane.showMessageDialog(null, "Existen " + errores
                    + " errore(s) en los siguientes renglones, porfavor revisar:\n" + filas_incorrectas
                    + "\nLa cantidad debe ser positiva y menor o igual a la cantidad en el renglón de "
                    + "la factura.");
            return false;
        } else {
            this.total.setText(JavaUtil.dosDecimales.format(totalCalculo).replace(",", "."));
            ncd.setTotal(totalCalculo);
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
//        InventarioTienda
        if (getTipo()) {

        } else {

        }

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
            String hql = "FROM NotaCreditoDebitoDetalle ncdd WHERE ncdd.idNotaCreditoDebito=:idNcd "
                    + "ORDER BY ncdd.nroRenglon";
            DaoQuery q = ObjectModelDAO.createQueryDAO(hql);
            q.getQuery().setParameter("idNcd", ncd);
            resultListNcdDetalle = ObjectModelDAO.getResultQuery(q);
            if (!resultListNcdDetalle.isEmpty()) {
                cb_salida.setSelectedItem(ncd.getIdSalida().getIdSalida());
                JavaUtil.displayResult(resultListNcdDetalle, tabla);
                fecha.setDate(ncd.getFecha());
                total.setText(JavaUtil.dosDecimales.format(ncd.getTotal()).replace(",", "."));
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
        realizado.setText(user.getNombre() + " : " + user.getDescripcion());
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
                    + " AND ppt.producto=s.producto AND ppt.almacen=spt.idAlmacenHasta "
                    + "ORDER BY s.nroRenglon";
            DaoQuery q = ObjectModelDAO.createQueryDAO(HQL);
            q.getQuery().setParameter("spt", spt);
            resultListSptDetalle = ObjectModelDAO.getResultQuery(q);
            facturado.setText(spt.getIdUsuario1().getNombre() + " : " + spt.getIdUsuario1().getDescripcion());
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
        rifAlmacen.setText("RIF: " + alc.getRif());
        direccionAlmacen.setText(alc.getIdUbicacion() == null
                ? null : alc.getIdUbicacion().toString());
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
        if (evt.getClickCount() == 2 && crear) {
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
    private javax.swing.JPanel PanelCabecera;
    private javax.swing.JPanel PanelFinal;
    private javax.swing.JPanel PanelTabla;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
