/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dialogos;

import clases.csv.CSVreader;
import clases.csv.Factura;
import clases.csv.InventarioDiario;
import clases.csv.Producto;
import hibernate.DAO.ObjectModelDAO;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelos.mapeos.Almacen;
import modelos.mapeos.InventarioTienda;
import modelos.mapeos.InventarioTiendaPK;
import util.JavaUtil;

/**
 *
 * @author Usuario
 */
public class JDfaturasCSV extends javax.swing.JDialog {

    private InventarioDiario ivtDiario = null;
    private List resultListAlmacen = null;

    public InventarioDiario getIvtDiario() {
        return ivtDiario;
    }

    public JDfaturasCSV(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        String sql = "FROM Almacen a order by a.idAlmacen asc";
        resultListAlmacen = ObjectModelDAO.getResultQuery(sql);
        cb_tiendas.removeAllItems();
        cb_tiendas.addItem(JavaUtil.cons_seleccionar);
        for (Object object : resultListAlmacen) {
            Almacen a = (Almacen) object;
            cb_tiendas.addItem(a.getNombre());
        }

        ayudaActionPerformed(null);
        this.setLocationRelativeTo(null);
        listaFacturas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    int i = listaFacturas.getSelectedIndex();
                    Vector<String> header = new Vector<>();
                    header.add("Código");
                    header.add("Tipo");
                    header.add("Precio");
                    header.add("Cantidad");
                    Vector<Object> data = new Vector<>();
                    if (i != -1 && ivtDiario != null) {
                        transaccion.setText(String.valueOf(ivtDiario.getFacturas().get(i).getTransaccion()));
                        usuario.setText(ivtDiario.getFacturas().get(i).getUsuario());
                        estado.setText(String.valueOf(ivtDiario.getFacturas().get(i).getEstado()));
                        numero.setText(String.valueOf(ivtDiario.getFacturas().get(i).getNumero()));
                        impresora.setText(String.valueOf(ivtDiario.getFacturas().get(i).getImpresora()));
                        modificado.setText(ivtDiario.getFacturas().get(i).getUsuarioModif());
                        cedula.setText(ivtDiario.getFacturas().get(i).getCedulaModif());
                        facToConIva.setText(JavaUtil.dosDecimales.format(ivtDiario.getFacturas().get(i).getTotalConIva()).replace(",", "."));
                        facToSinIva.setText(JavaUtil.dosDecimales.format(ivtDiario.getFacturas().get(i).getTotalSinIva()).replace(",", "."));
                        for (Map.Entry<Producto, Integer> entry : ivtDiario.getFacturas().get(i).getProductos().entrySet()) {
                            Producto p = entry.getKey();
                            Vector<Object> subdata = new Vector<>();
                            subdata.add(p.getCodigo());
                            subdata.add(p.getTipo());
                            subdata.add(JavaUtil.dosDecimales.format(p.getPrecio()).replace(",", "."));
                            subdata.add(entry.getValue());
                            data.add(subdata);
                        }
                    } else {
                        transaccion.setText("");
                        usuario.setText("");
                        estado.setText("");
                        numero.setText("");
                        impresora.setText("");
                        modificado.setText("");
                        cedula.setText("");
                        facToConIva.setText("");
                        facToSinIva.setText("");
                    }
                    tabla.setModel(new DefaultTableModel(data, header));
                }
            }
        });

    }

    private void cargarInformacion() {
        this.texto.setText(ivtDiario.toString());
        fecha.setText(ivtDiario.getFecha());
        totalConIva.setText(JavaUtil.dosDecimales.format(ivtDiario.getTotalConIva()));
        totalSinIva.setText(JavaUtil.dosDecimales.format(ivtDiario.getTotalSinIva()));
        DefaultListModel dlm = new DefaultListModel();
        for (Factura fa : ivtDiario.getFacturas()) {
            dlm.addElement(fa.getNumero());
        }
        listaFacturas.setModel(dlm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filesc = new javax.swing.JFileChooser();
        filesc.setCurrentDirectory(new java.io.File("C:\\Users\\Usuario\\Documents\\PASANTIA"));

        filesc.setDialogTitle("Seleccione un archivo");
        tabpanel = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaFacturas = new org.jdesktop.swingx.JXList();
        jPanel2 = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        transaccion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        numero = new javax.swing.JLabel();
        lbusuario = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        lbusuariomodif = new javax.swing.JLabel();
        modificado = new javax.swing.JLabel();
        lbusuariomodif2 = new javax.swing.JLabel();
        facToSinIva = new javax.swing.JLabel();
        lbestado = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        impresoralb = new javax.swing.JLabel();
        impresora = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        lbusuariomodif1 = new javax.swing.JLabel();
        lbusuariomodif3 = new javax.swing.JLabel();
        facToConIva = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla = new org.jdesktop.swingx.JXTable();
        PanelCab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalSinIva = new javax.swing.JLabel();
        totalConIva = new javax.swing.JLabel();
        seleccionar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ruta = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JLabel();
        ayuda = new javax.swing.JButton();
        cb_tiendas = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        PanelLado = new javax.swing.JPanel();
        imprimirFac = new javax.swing.JButton();
        imprimirInv = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        jMenuBarDialogoInV = new javax.swing.JMenuBar();
        jMenuOpciones = new javax.swing.JMenu();
        jMenu_Ayuda_ = new javax.swing.JMenu();

        filesc.setCurrentDirectory(new java.io.File("C:\\Users\\Usuario\\Documents\\PASANTIA\\prueba"));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de Facturas");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(50, 60));

        tabpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane1.setViewportView(texto);

        tabpanel.addTab("Texto", null, jScrollPane1, "");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Facturas"));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 150));

        listaFacturas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listaFacturas);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel5.setText("Transacción");

        transaccion.setText(" ");
        transaccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Número");

        numero.setText(" ");
        numero.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbusuario.setText("Usuario");

        usuario.setText(" ");
        usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbusuariomodif.setText("Modificación por");

        modificado.setText(" ");
        modificado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbusuariomodif2.setText("Total sin IVA");

        facToSinIva.setText(" ");
        facToSinIva.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbestado.setText("Estado");

        estado.setText(" ");
        estado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        impresoralb.setText("Impresora");

        impresora.setText(" ");
        impresora.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cedula.setText(" ");
        cedula.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbusuariomodif1.setText("Cédula");

        lbusuariomodif3.setText("Total con IVA");

        facToConIva.setText(" ");
        facToConIva.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbusuariomodif2)
                            .addComponent(lbestado))
                        .addGap(27, 27, 27)
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estado, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(facToSinIva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbusuariomodif)
                            .addComponent(lbusuario)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbusuariomodif1))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbusuariomodif3))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(impresoralb)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(facToConIva, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(cedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(impresora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(transaccion)
                    .addComponent(numero)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(impresoralb)
                        .addComponent(impresora)
                        .addComponent(usuario))
                    .addComponent(lbusuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbusuariomodif1)
                        .addComponent(cedula))
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbusuariomodif)
                        .addComponent(modificado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbusuariomodif3)
                        .addComponent(facToConIva))
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbusuariomodif2)
                        .addComponent(facToSinIva)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbestado)
                    .addComponent(estado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(PanelDatos);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setToolTipText("Flecha hacia abajo para agregar renglón. Doble click en Fecha para agregar fecha");
        tabla.setEditable(false);
        tabla.setHorizontalScrollEnabled(true);
        tabla.setSortable(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabla);

        jPanel2.add(jScrollPane4);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        tabpanel.addTab("Lista", jPanel1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416789180_Timetable.png"))); // NOI18N
        jLabel1.setText("Fecha");

        fecha.setText(" ");
        fecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1418331222_coins.png"))); // NOI18N
        jLabel2.setText("Total sin IVA");

        totalSinIva.setText(" ");
        totalSinIva.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        totalConIva.setText(" ");
        totalConIva.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        seleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417901536_internt_web_technology-02-16.png"))); // NOI18N
        seleccionar.setText("Cargar Archivo de Factura");
        seleccionar.setToolTipText("Para cálculo de factura");
        seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1418331222_coins.png"))); // NOI18N
        jLabel3.setText("Total con IVA");

        ruta.setText(" ");

        txtTitulo.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(102, 102, 102));
        txtTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415416322_list-accept.png"))); // NOI18N
        txtTitulo.setText("DETALLES DE FACTURA DIARIA");

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

        cb_tiendas.setMaximumSize(new java.awt.Dimension(300, 300));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417636330_store.png"))); // NOI18N
        jLabel7.setText("Tienda");

        javax.swing.GroupLayout PanelCabLayout = new javax.swing.GroupLayout(PanelCab);
        PanelCab.setLayout(PanelCabLayout);
        PanelCabLayout.setHorizontalGroup(
            PanelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCabLayout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(72, 72, 72))
            .addGroup(PanelCabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCabLayout.createSequentialGroup()
                        .addComponent(seleccionar)
                        .addGap(18, 18, 18)
                        .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCabLayout.createSequentialGroup()
                        .addGroup(PanelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(PanelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalConIva, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalSinIva, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_tiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCabLayout.setVerticalGroup(
            PanelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCabLayout.createSequentialGroup()
                .addGroup(PanelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCabLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelCabLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ayuda)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(seleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalSinIva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(totalConIva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_tiendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(10, 10, 10))
        );

        imprimirFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1418331399_Print.png"))); // NOI18N
        imprimirFac.setText("Imprimir Factura");
        imprimirFac.setToolTipText("Actualiza el Inventario de la Tienda");
        imprimirFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirFacActionPerformed(evt);
            }
        });

        imprimirInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1418331399_Print.png"))); // NOI18N
        imprimirInv.setText("Imprimir Inventario Diario");
        imprimirInv.setToolTipText("Actualiza el Inventario de la Tienda");
        imprimirInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirInvActionPerformed(evt);
            }
        });

        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416789278_history_clear.png"))); // NOI18N
        actualizar.setText("Actualizar Inventario");
        actualizar.setToolTipText("Actualiza el Inventario de la Tienda");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416789267_clean.png"))); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLadoLayout = new javax.swing.GroupLayout(PanelLado);
        PanelLado.setLayout(PanelLadoLayout);
        PanelLadoLayout.setHorizontalGroup(
            PanelLadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imprimirInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imprimirFac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelLadoLayout.setVerticalGroup(
            PanelLadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLadoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imprimirFac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imprimirInv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuOpciones.setText("Opciones");
        jMenuBarDialogoInV.add(jMenuOpciones);

        jMenu_Ayuda_.setText("Ayuda");
        jMenuBarDialogoInV.add(jMenu_Ayuda_);

        setJMenuBar(jMenuBarDialogoInV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelCab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabpanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelLado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelCab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelLado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        if (listaFacturas.getElementCount() <= 0) {
            JOptionPane.showMessageDialog(null, "Debe selecionar un archivo de facturas CSV");
            return;
        }
        if (cb_tiendas.getSelectedIndex() <= 0) {//toma en cuenta el seleccionar que es 0
            JOptionPane.showMessageDialog(null, "Debe selecionar una tienda para actualizar su inventario");
            return;
        }

        Almacen alm = (Almacen) resultListAlmacen.get(cb_tiendas.getSelectedIndex() - 1);
        //aca recorre la lista y actualiza el inventario tienda
        String errores = "";
        for (Factura factura : ivtDiario.getFacturas()) {
            for (Map.Entry<Producto, Integer> entry : factura.getProductos().entrySet()) {
                Producto p = entry.getKey();
                InventarioTiendaPK id = new InventarioTiendaPK(p.getCodigo(), alm.getIdAlmacen());
                InventarioTienda ivt = ObjectModelDAO.getObject(id, InventarioTienda.class);

                if (ivt == null) {
                    errores += p.getCodigo() + "\n";
                } else {

                    if (factura.getEstado() == Factura.Estado.devuelta) {//debe sumar al inventario
                        ivt.setCantidad(ivt.getCantidad() + entry.getValue());
                    }

                    if (factura.getEstado() == Factura.Estado.correcta) {//debe restar al inventario
                        ivt.setCantidad(ivt.getCantidad() - entry.getValue());
                    }
                    ObjectModelDAO.updateObject(ivt);
                }
            }
        }

        if (!errores.equals("")) {
            JOptionPane.showMessageDialog(null, "Los siguientes productos no se encontraron en la tienda, presione Enter para aceptar\n\n" + errores);
        }
        actualizar.setEnabled(false);

    }//GEN-LAST:event_actualizarActionPerformed

    private void imprimirInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirInvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imprimirInvActionPerformed

    private void imprimirFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imprimirFacActionPerformed

    private void generarReporte() {
//        try {
//            JasperPrint jasperPrint = null;
//            Map<String, Object> parametro = new HashMap<>();
////            String s = "";
////
////            for (int i = 0; i < tableModel.getColumnCount(); i++) {
////                s += tableModel.getColumnName(i) + "\t" + Integer.valueOf(i) + "\n";
////            }
//            TableModelReport dataSourse = new TableModelReport(listadoMercancia.getModel());
//
//            parametro.put("Fecha", fieldfecha.getText());
//            parametro.put("Tienda", cb_tienda1.getSelectedItem().equals("Todas las Tiendas") ? "" : cb_tienda1.getSelectedItem().toString());
//            parametro.put("Tienda2", cb_tienda2.getSelectedItem().toString());
//            parametro.put("Facturadora", fieldPersonalDep.getText());
//            parametro.put("Ayudante", fieldAyudante.getText());
//            parametro.put("Salida", cb_salidasregistradas.getSelectedItem().toString());
//            parametro.put("REPORT_DATA_SOURSE", dataSourse);
//            JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream(rutaJasper));
//            jasperPrint = JasperFillManager.fillReport(reporte, parametro, dataSourse);
//            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
//            jasperViewer.setTitle("Reporte de Salida de Mercancía");
//            jasperViewer.setVisible(true);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "error" + e);
//        }
    }


    private void seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarActionPerformed

        if (filesc.getChoosableFileFilters().length > 1) {
            filesc.removeChoosableFileFilter(filesc.getChoosableFileFilters()[1]);
        }

        filesc.setFileFilter(new FileNameExtensionFilter("Archivos csv! ", "csv"));

        int returnVal = filesc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = filesc.getSelectedFile();
            CSVreader csvReader = new CSVreader(file.getAbsolutePath());
            ruta.setText(file.getAbsolutePath());
            ivtDiario = csvReader.procesCSV();
            cargarInformacion();
            actualizar.setEnabled(true);
        }
    }//GEN-LAST:event_seleccionarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        dispose();
    }//GEN-LAST:event_aceptarActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
//
//        try {
//            File archivo = new File(this.getClass().getResource("/JavaHelp/JavaHelp/ejemplo.hs").getFile());
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDfaturasCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDfaturasCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDfaturasCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDfaturasCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDfaturasCSV dialog = new JDfaturasCSV(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel PanelCab;
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelLado;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton actualizar;
    private javax.swing.JButton ayuda;
    public javax.swing.JComboBox cb_tiendas;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel facToConIva;
    private javax.swing.JLabel facToSinIva;
    private javax.swing.JLabel fecha;
    private javax.swing.JFileChooser filesc;
    private javax.swing.JLabel impresora;
    private javax.swing.JLabel impresoralb;
    private javax.swing.JButton imprimirFac;
    private javax.swing.JButton imprimirInv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBarDialogoInV;
    private javax.swing.JMenu jMenuOpciones;
    private javax.swing.JMenu jMenu_Ayuda_;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbestado;
    private javax.swing.JLabel lbusuario;
    private javax.swing.JLabel lbusuariomodif;
    private javax.swing.JLabel lbusuariomodif1;
    private javax.swing.JLabel lbusuariomodif2;
    private javax.swing.JLabel lbusuariomodif3;
    private org.jdesktop.swingx.JXList listaFacturas;
    private javax.swing.JLabel modificado;
    private javax.swing.JLabel numero;
    private javax.swing.JLabel ruta;
    private javax.swing.JButton seleccionar;
    private org.jdesktop.swingx.JXTable tabla;
    private javax.swing.JTabbedPane tabpanel;
    private javax.swing.JTextArea texto;
    private javax.swing.JLabel totalConIva;
    private javax.swing.JLabel totalSinIva;
    private javax.swing.JLabel transaccion;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables

}
