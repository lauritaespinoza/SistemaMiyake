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
import java.awt.Dialog;
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
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
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
    public String rutaJasper = "/reportes/ReporteNotasDebCred.jasper";
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
    
    public NotaCreditoDebito getNcd() {
        return ncd;
    }
    
    public void setNcd(NotaCreditoDebito ncd) {        
        cb_tienda.setSelectedItem(ncd.getIdSalida().getIdAlmacenHasta().getNombre());
        cb_ncd.setSelectedItem(ncd.getIdNotaCreditoDebito());
        //la asignacion a ncd esta en cb_ncd action performence
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

        PanelCabecera = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_tienda = new javax.swing.JComboBox();
        titulo = new javax.swing.JLabel();
        nombreAlmacen = new javax.swing.JLabel();
        rifAlmacen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_ncd = new javax.swing.JComboBox();
        nuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fecha = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        cb_salida = new javax.swing.JComboBox();
        jPanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new org.jdesktop.swingx.JXTable();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        jPanelPanelFinal = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        facturado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        realizado = new javax.swing.JLabel();
        enCaso = new javax.swing.JLabel();
        direccionAlmacen = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        imprimir = new javax.swing.JButton();
        guardar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        PanelCabecera.setLayout(new javax.swing.BoxLayout(PanelCabecera, javax.swing.BoxLayout.LINE_AXIS));

        logo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417636333_store.png"))); // NOI18N
        jLabel7.setText("Tienda");

        cb_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tiendaActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(102, 102, 102));
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417636449_invoice.png"))); // NOI18N
        titulo.setText("NOTA DE DEBITO");

        nombreAlmacen.setText(" ");

        rifAlmacen.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nombreAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rifAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(titulo)))
                .addContainerGap(14, Short.MAX_VALUE))
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
                        .addGap(23, 23, 23)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)))
                .addComponent(nombreAlmacen)
                .addGap(18, 18, 18)
                .addComponent(rifAlmacen)
                .addGap(10, 10, 10))
        );

        PanelCabecera.add(jPanel2);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416856230_page_white.png"))); // NOI18N
        jLabel4.setText("Nota pasada");

        jLabel8.setText("Nueva");

        cb_ncd.setToolTipText("Debe seleccionar una Tienda");
        cb_ncd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ncdActionPerformed(evt);
            }
        });

        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416792800_040.png"))); // NOI18N
        nuevo.setToolTipText("Crear nueva Nota");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416789180_Timetable.png"))); // NOI18N
        jLabel1.setText("Fecha");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/facturas.png"))); // NOI18N
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
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(cb_ncd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(9, 9, 9)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cb_ncd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cb_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );

        PanelCabecera.add(jPanel3);

        add(PanelCabecera, java.awt.BorderLayout.NORTH);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Renglón", "Referencia", "Descripción", "Observación", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
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

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addGap(384, 384, 384)
                    .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(468, Short.MAX_VALUE)))
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
            .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTablaLayout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        add(jPanelTabla, java.awt.BorderLayout.CENTER);

        jPanelPanelFinal.setLayout(new javax.swing.BoxLayout(jPanelPanelFinal, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416856442_page_white_edit.png"))); // NOI18N
        jLabel3.setText("Facturado:");

        facturado.setText(" ");
        facturado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416818601_description-16.png"))); // NOI18N
        jLabel6.setText("Realizado: ");

        realizado.setText(" ");
        realizado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        enCaso.setText("EN CASO DE MERCANCIA FALTANTE");

        direccionAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        direccionAlmacen.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(direccionAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(facturado, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(realizado, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(enCaso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(facturado))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(realizado)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enCaso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)))
                .addComponent(direccionAlmacen)
                .addGap(16, 16, 16))
        );

        jPanelPanelFinal.add(jPanel4);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1418331222_coins.png"))); // NOI18N
        jLabel5.setText("Total:");

        total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total.setText(" ");
        total.setToolTipText("Doble click para Recalcular");
        total.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        total.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        total.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalMouseClicked(evt);
            }
        });

        imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1418331399_Print.png"))); // NOI18N
        imprimir.setText("Imprimir");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416789181_Noun_Project_100Icon_10px_grid-38-16.png"))); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(imprimir)
                        .addGap(5, 5, 5)
                        .addComponent(guardar))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(total))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imprimir)
                    .addComponent(guardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPanelFinal.add(jPanel5);

        add(jPanelPanelFinal, java.awt.BorderLayout.SOUTH);
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
                            "",
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
            parametro.put("Fecha", new SimpleDateFormat("dd-MM-yyyy").format(fecha.getDate()));
            parametro.put("Direccion", direccionAlmacen.getText());
            parametro.put("Tienda", nombreAlmacen.getText());
            parametro.put("Rif", rifAlmacen.getText());
            
            TableModelReport dataSourse = new TableModelReport(tabla.getModel());
            
            parametro.put("REPORT_DATA_SOURCE", dataSourse);
            //parametro.put("Total", total.getText());
             JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream(rutaJasper));
            jasperPrint = JasperFillManager.fillReport(reporte, parametro, dataSourse);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
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
            //cantidad
            Object o = tabla.getModel().getValueAt(i, 4);
            int cantidad = 0;
            String str;
            
            if (o instanceof String) {
                str = (String) o;
                cantidad=JavaUtil.isNumeric(str)?Integer.parseInt(str):0;
                System.out.println("\t string 1");
            }
            if (o instanceof Integer) {
                cantidad = (Integer) o;
                System.out.println("\t integer 2");
            }
            
            if (cantidad > 0) {
                if (errores == 0) {
                    //precio
                    Object op=tabla.getModel().getValueAt(i, 5);
                    Float precio =(Float) ((op instanceof String )? Float.parseFloat((String) op): op);
                    
                    total += precio * cantidad;
                    ((NotaCreditoDebitoDetalle) resultListNcdDetalle.get(i)).setCantidadProducto(cantidad);
                    //observacion
                    String obs = (String) tabla.getModel().getValueAt(i, 3);
                    ((NotaCreditoDebitoDetalle) resultListNcdDetalle.get(i)).setObservacion(obs);
                }
            } else {
                filas_incorrectas += tabla.getModel().getValueAt(i, 0) + "\n";
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
                realizado.setText(ncd.getIdUsuario().getNombre() + " : " + ncd.getIdUsuario().getDescripcion());
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
        realizado.setText(JFInicioSecionMiyake.us1.getNombre() + " : " + JFInicioSecionMiyake.us1.getDescripcion());
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
             facturado.setText(spt.getIdUsuario1().getNombre() + " : " + spt.getIdUsuario1().getDescripcion());
            if (ncd == null) {
                ncd = new NotaCreditoDebito(getTipo(), spt, JFInicioSecionMiyake.us1);
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
        rifAlmacen.setText("RIF: " + alc.getRif() == null ? "" : alc.getRif());
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
    private javax.swing.JPanel PanelCabecera;
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
    private javax.swing.JPanel jPanelPanelFinal;
    private javax.swing.JPanel jPanelTabla;
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
