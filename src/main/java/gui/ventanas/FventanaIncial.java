package gui.ventanas;

import gui.dialogos.ClockTest;
import gui.paneles.Asignar1;
import gui.paneles.Distribuidora1;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import static java.awt.PageAttributes.MediaType.C1;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.plaf.TaskPaneUI;
import org.pushingpixels.substance.api.skin.SubstanceAutumnLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceCeruleanLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceCremeCoffeeLookAndFeel;
import org.pushingpixels.substance.internal.ui.SubstancePanelUI;
import org.pushingpixels.substance.internal.utils.SubstanceTextUtilities;
import gui.paneles.JPAsignarMercancia;
import gui.paneles.JPConsultaInventario;
import gui.paneles.JPMecanciaEnProceso;
import gui.paneles.JPNewJPanel;
import gui.paneles.JPalmacen;
import gui.paneles.JPclasificacion;
import gui.paneles.JPcontacto;
import gui.paneles.JPdepartamento;
import gui.paneles.JPdivision;
import gui.paneles.JPentradaproveedor;
import gui.paneles.JPinventarioDiario;
import gui.paneles.JPmarca;
import gui.paneles.JPprecio_productos;
import gui.paneles.JPproducto;
import gui.paneles.JPproveedor;
import gui.paneles.JPsalida_p_tienda;
import gui.paneles.JPubicacion;
import gui.paneles.JPTomaFisicaInventarioDistribuidora;
import gui.paneles.JPTomaFisicaInventarioTiendas;
import gui.paneles.JPexportData;
import gui.paneles.JPnotaCreditoDebito;
import gui.paneles.JPusuario;
import gui.paneles.Tiendas1;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import javax.swing.JLabel;
import net.sf.jasperreports.engine.JRException;
import javax.swing.Timer;

public class FventanaIncial extends javax.swing.JFrame {

    private static final String tabConsultarMerca = "Consultar Mecancia. ";
    private static final String tabMecanciaEnProceso = "Mecancia En Proceso. ";
    private static final String tabTomaFisicaTiendas = "Toma Fisica Tiendas. ";
    private static final String tabUsuarios = "Gestion De Usuarios. ";
    private static final String tabAsignarMercancia = "Asignar Mercancia. ";
    private static final String tabTomaFisica = "Inventario Distribuidora. ";
    private static final String tabExportData = "Exportacion de Datos. ";
    private static final String tabProducto = "Producto";
    private static final String tabSalida = "Mercancía Asignada a Tienda";
    private static final String tabFactura = "Registrar Container";
    private static final String tabClasificacion = "Clasificación";
    private static final String tabDepartamento = "Departamento";
    private static final String tabDivision = "División";
    private static final String tabMarca = "Marca";
    private static final String tabUbicacion = "Ubicación";
    private static final String tabProveedor = "Proveedor";
    private static final String tabContacto = "Contacto";
    private static final String tabPrecio = "Actualización de Precios";
    private static final String tabInventarioDiario = "Inventario Diario en Tienda";
    private static final String tabAlmacen = "Almacen";
    private static final String tabNotaCredito = "Notas de Crédito en Tienda";
    private static final String tabNotaDebito = "Notas de Débito en Tienda";

    private BufferedImage bg;

    public static List<List> listaUsuarioMain;

    public FventanaIncial() {
        initComponents();
    }

    public FventanaIncial(List<List> user) {
        FventanaIncial.listaUsuarioMain = user;

        initComponents();
        
        ClockLabel clock = new ClockLabel();
        getContentPane().add(clock, BorderLayout.PAGE_END);
    }

    //el tipo se usa en nota de credito debito
    private void addPaneles(String titulo, Class panelNuevo, Boolean tipo) {
        try {

            int pos = isContained(titulo);
            if (pos == -1) {
                if (panelNuevo.equals(JPnotaCreditoDebito.class)) {//si es una nota de credito/debito
                    panelClosableCentral.addTab(titulo, (JPanel) panelNuevo.getConstructor(Boolean.class).newInstance(tipo));
                } else {
                    panelClosableCentral.addTab(titulo, (JPanel) panelNuevo.newInstance());
                }
                panelClosableCentral.setSelectedIndex(panelClosableCentral.getTabCount() - 1);
            } else {
                panelClosableCentral.setSelectedIndex(pos);
            }

        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FventanaIncial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(FventanaIncial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(FventanaIncial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(FventanaIncial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int isContained(String titulo) {
        for (int i = 0; i < panelClosableCentral.getTabCount(); i++) {

            if (panelClosableCentral.getTabTitleAt(i).equals(titulo)) {
                return i;//si encontro, retorna la posicion

            }
        }

        return -1;//si nunca lo encontro
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        jpMenu = new javax.swing.JPopupMenu();
        jmConsultar = new javax.swing.JMenuItem();
        jmCrear = new javax.swing.JMenuItem();
        jmModificar = new javax.swing.JMenuItem();
        jmEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanelControlesPrincipales = new javax.swing.JPanel();
        jXCollapsiblePane1 = new org.jdesktop.swingx.JXCollapsiblePane();
        taskPaneModuloFacturacion = new org.jdesktop.swingx.JXTaskPane();
        taskPaneProducto = new org.jdesktop.swingx.JXTaskPane();
        btnCrudProducto = new javax.swing.JButton();
        btnCrudClasificacion = new javax.swing.JButton();
        btnCrudDepto = new javax.swing.JButton();
        btnCrudDivision = new javax.swing.JButton();
        btnCrudMarca = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        taskPaneProveedores = new org.jdesktop.swingx.JXTaskPane();
        btnCrudProveedr = new javax.swing.JButton();
        btnCrudUbicacion = new javax.swing.JButton();
        btnCrudContact = new javax.swing.JButton();
        btnContainer = new javax.swing.JButton();
        taskPaneEtiquetas = new org.jdesktop.swingx.JXTaskPane();
        btnSalidaTienda = new javax.swing.JButton();
        taskPaneModuloTienda = new org.jdesktop.swingx.JXTaskPane();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btNC = new javax.swing.JButton();
        btND = new javax.swing.JButton();
        taskPaneModuloDeposito = new org.jdesktop.swingx.JXTaskPane();
        taskPaneGestionMercancia = new org.jdesktop.swingx.JXTaskPane();
        TomaFisicaDistribuidora_boton_ = new javax.swing.JButton();
        AsignarMercancia_boton_ = new org.jdesktop.swingx.JXButton();
        TomaFisicaTiendas_boton_ = new org.jdesktop.swingx.JXButton();
        taskPaneConsultas = new org.jdesktop.swingx.JXTaskPane();
        ConsultaExistencia_boton_ = new org.jdesktop.swingx.JXButton();
        jXButton2 = new org.jdesktop.swingx.JXButton();
        taskPaneUtilidades = new org.jdesktop.swingx.JXTaskPane();
        UbicacionProducto_boton_ = new org.jdesktop.swingx.JXButton();
        ExportData_boton_ = new javax.swing.JButton();
        jXButton1 = new org.jdesktop.swingx.JXButton();
        taskPaneReportes = new org.jdesktop.swingx.JXTaskPane();
        Boton_Inprimir_Reporte_conteo_Distribuidora = new javax.swing.JButton();
        try {
            bg = ImageIO.read(getClass().getResource("/iconos/logomiyake.png"));

        } catch (IOException ex) {
            Logger.getLogger(FventanaIncial.class

                .getName()).log(Level.SEVERE, null, ex);

        }
        panelClosableCentral = new com.ClosableTabbedPane(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 50, getWidth(), getHeight()-50, this);
            }

        };
        jMenuBarSistemaMiyake = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuFacturacion = new javax.swing.JMenu();
        menuProveedor = new javax.swing.JMenu();
        menuUsuario = new javax.swing.JMenu();
        menuTiendas = new javax.swing.JMenu();
        menuInventario = new javax.swing.JMenu();
        menuMercancia = new javax.swing.JMenu();
        menuNotas = new javax.swing.JMenu();
        menuUtilidades = new javax.swing.JMenu();
        menuAyuda = new javax.swing.JMenu();

        jmConsultar.setText("Consultar");
        jpMenu.add(jmConsultar);

        jmCrear.setText("Crear");
        jpMenu.add(jmCrear);

        jmModificar.setText("Modificar");
        jpMenu.add(jmModificar);

        jmEliminar.setText("Eliminar");
        jpMenu.add(jmEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(9, 182, 201));
        setMinimumSize(new java.awt.Dimension(412, 641));

        jPanel1.setBackground(new java.awt.Color(107, 181, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        jPanel1.setForeground(new java.awt.Color(0, 73, 146));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 80, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415656208_Home.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        jPanel1.add(jLabel6);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415663705_reload_all_tabs.png"))); // NOI18N
        jPanel1.add(jLabel7);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415663403_010.png"))); // NOI18N
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415656313_Exit.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanelControlesPrincipales.setAlignmentX(0.0F);
        jPanelControlesPrincipales.setLayout(new javax.swing.BoxLayout(jPanelControlesPrincipales, javax.swing.BoxLayout.Y_AXIS));

        jXCollapsiblePane1.setOpaque(false);
        jXCollapsiblePane1.setAlignmentX(0.0F);

        taskPaneModuloFacturacion.setTitle("Facturación");

        taskPaneProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415658077_database.png"))); // NOI18N
        taskPaneProducto.setSpecial(true);
        taskPaneProducto.setTitle("Productos");

        btnCrudProducto.setText("Producto");
        btnCrudProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrudProductoMouseEntered(evt);
            }
        });
        btnCrudProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudProductoActionPerformed(evt);
            }
        });
        taskPaneProducto.getContentPane().add(btnCrudProducto);

        btnCrudClasificacion.setText("Clasificación");
        btnCrudClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudClasificacionActionPerformed(evt);
            }
        });
        taskPaneProducto.getContentPane().add(btnCrudClasificacion);

        btnCrudDepto.setText("Departamento");
        btnCrudDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudDeptoActionPerformed(evt);
            }
        });
        taskPaneProducto.getContentPane().add(btnCrudDepto);

        btnCrudDivision.setText("División");
        btnCrudDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudDivisionActionPerformed(evt);
            }
        });
        taskPaneProducto.getContentPane().add(btnCrudDivision);

        btnCrudMarca.setText("Marca");
        btnCrudMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudMarcaActionPerformed(evt);
            }
        });
        taskPaneProducto.getContentPane().add(btnCrudMarca);

        jButton4.setText("Actualizar Precio");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        taskPaneProducto.getContentPane().add(jButton4);

        taskPaneModuloFacturacion.getContentPane().add(taskPaneProducto);

        taskPaneProveedores.setCollapsed(true);
        taskPaneProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415665365_fork1.png"))); // NOI18N
        taskPaneProveedores.setSpecial(true);
        taskPaneProveedores.setTitle("Proveedores");

        btnCrudProveedr.setText("Proveedor");
        btnCrudProveedr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudProveedrActionPerformed(evt);
            }
        });
        taskPaneProveedores.getContentPane().add(btnCrudProveedr);

        btnCrudUbicacion.setText("Ubicación");
        btnCrudUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudUbicacionActionPerformed(evt);
            }
        });
        taskPaneProveedores.getContentPane().add(btnCrudUbicacion);

        btnCrudContact.setText("Contacto");
        btnCrudContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudContactActionPerformed(evt);
            }
        });
        taskPaneProveedores.getContentPane().add(btnCrudContact);

        btnContainer.setText("Registrar Container");
        btnContainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContainerActionPerformed(evt);
            }
        });
        taskPaneProveedores.getContentPane().add(btnContainer);

        taskPaneModuloFacturacion.getContentPane().add(taskPaneProveedores);

        taskPaneEtiquetas.setCollapsed(true);
        taskPaneEtiquetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Barcode.png"))); // NOI18N
        taskPaneEtiquetas.setSpecial(true);
        taskPaneEtiquetas.setTitle("Etiquetas");

        btnSalidaTienda.setText("Mercancía Asignada");
        btnSalidaTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaTiendaActionPerformed(evt);
            }
        });
        taskPaneEtiquetas.getContentPane().add(btnSalidaTienda);

        taskPaneModuloFacturacion.getContentPane().add(taskPaneEtiquetas);

        jXCollapsiblePane1.getContentPane().add(taskPaneModuloFacturacion);

        taskPaneModuloTienda.setCollapsed(true);
        taskPaneModuloTienda.setTitle("Tienda");

        jButton6.setText("Almacen");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(jButton6);

        jButton5.setText("Inventario Diario");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(jButton5);

        btNC.setText("Notas de Crédito");
        btNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNCActionPerformed(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(btNC);

        btND.setText("Notas de Débito");
        btND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNDActionPerformed(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(btND);

        jXCollapsiblePane1.getContentPane().add(taskPaneModuloTienda);

        taskPaneModuloDeposito.setTitle("Depósito");

        taskPaneGestionMercancia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415667180_application-vnd.ms-excel.png"))); // NOI18N
        taskPaneGestionMercancia.setSpecial(true);

        TomaFisicaDistribuidora_boton_.setText("Toma Fisica Distribuidora");
        TomaFisicaDistribuidora_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomaFisicaDistribuidora_boton_ActionPerformed(evt);
            }
        });
        taskPaneGestionMercancia.getContentPane().add(TomaFisicaDistribuidora_boton_);

        AsignarMercancia_boton_.setText("Gestion Mercancia ");
        AsignarMercancia_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarMercancia_boton_ActionPerformed(evt);
            }
        });
        taskPaneGestionMercancia.getContentPane().add(AsignarMercancia_boton_);

        TomaFisicaTiendas_boton_.setText("Toma Fisica Tiendas");
        TomaFisicaTiendas_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomaFisicaTiendas_boton_ActionPerformed(evt);
            }
        });
        taskPaneGestionMercancia.getContentPane().add(TomaFisicaTiendas_boton_);

        taskPaneModuloDeposito.getContentPane().add(taskPaneGestionMercancia);

        ConsultaExistencia_boton_.setText("Consultar Existencia");
        ConsultaExistencia_boton_.setActionCommand("Consultar Inventario ");
        ConsultaExistencia_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaExistencia_boton_ActionPerformed(evt);
            }
        });
        taskPaneConsultas.getContentPane().add(ConsultaExistencia_boton_);

        jXButton2.setText("Mercancia en Proceso");
        jXButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton2ActionPerformed(evt);
            }
        });
        taskPaneConsultas.getContentPane().add(jXButton2);

        taskPaneModuloDeposito.getContentPane().add(taskPaneConsultas);

        taskPaneUtilidades.setCollapsed(true);

        UbicacionProducto_boton_.setText("Ubicacion Producto");
        taskPaneUtilidades.getContentPane().add(UbicacionProducto_boton_);

        ExportData_boton_.setText("Export Datos");
        ExportData_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportData_boton_ActionPerformed(evt);
            }
        });
        taskPaneUtilidades.getContentPane().add(ExportData_boton_);

        jXButton1.setText("Usuarios");
        jXButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton1ActionPerformed(evt);
            }
        });
        taskPaneUtilidades.getContentPane().add(jXButton1);

        taskPaneModuloDeposito.getContentPane().add(taskPaneUtilidades);

        taskPaneReportes.setCollapsed(true);
        taskPaneReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415415980_printer.png"))); // NOI18N
        taskPaneReportes.setTitle("Reportes Almacen");

        Boton_Inprimir_Reporte_conteo_Distribuidora.setText("Reporte Conteo Mercancia");
        Boton_Inprimir_Reporte_conteo_Distribuidora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_Inprimir_Reporte_conteo_DistribuidoraActionPerformed(evt);
            }
        });
        taskPaneReportes.getContentPane().add(Boton_Inprimir_Reporte_conteo_Distribuidora);

        taskPaneModuloDeposito.getContentPane().add(taskPaneReportes);

        jXCollapsiblePane1.getContentPane().add(taskPaneModuloDeposito);

        jPanelControlesPrincipales.add(jXCollapsiblePane1);

        jPanel3.add(jPanelControlesPrincipales, java.awt.BorderLayout.LINE_START);

        panelClosableCentral.setAlignmentX(0.0F);
        panelClosableCentral.setAutoscrolls(true);
        panelClosableCentral.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel3.add(panelClosableCentral, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        menuArchivo.setText("Archivos");
        jMenuBarSistemaMiyake.add(menuArchivo);

        menuFacturacion.setText("Productos");
        jMenuBarSistemaMiyake.add(menuFacturacion);

        menuProveedor.setText("Proveedor");
        jMenuBarSistemaMiyake.add(menuProveedor);

        menuUsuario.setText("Usuarios");
        jMenuBarSistemaMiyake.add(menuUsuario);

        menuTiendas.setText("Tiendas");
        jMenuBarSistemaMiyake.add(menuTiendas);

        menuInventario.setText("Inventario");
        jMenuBarSistemaMiyake.add(menuInventario);

        menuMercancia.setText("Gestion Mercancia");
        jMenuBarSistemaMiyake.add(menuMercancia);

        menuNotas.setText("Notas");
        jMenuBarSistemaMiyake.add(menuNotas);

        menuUtilidades.setText("Utilidades");
        jMenuBarSistemaMiyake.add(menuUtilidades);

        menuAyuda.setText("Ayuda");
        jMenuBarSistemaMiyake.add(menuAyuda);

        setJMenuBar(jMenuBarSistemaMiyake);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrudClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudClasificacionActionPerformed
        addPaneles(tabClasificacion, JPclasificacion.class, null);
    }//GEN-LAST:event_btnCrudClasificacionActionPerformed

    private void btnCrudMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudMarcaActionPerformed
        addPaneles(tabMarca, JPmarca.class, null);
    }//GEN-LAST:event_btnCrudMarcaActionPerformed

    private void btnCrudDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudDeptoActionPerformed
        addPaneles(tabDepartamento, JPdepartamento.class, null);
    }//GEN-LAST:event_btnCrudDeptoActionPerformed

    private void btnCrudContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudContactActionPerformed
        addPaneles(tabContacto, JPcontacto.class, null);
    }//GEN-LAST:event_btnCrudContactActionPerformed

    private void btnCrudDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudDivisionActionPerformed
        addPaneles(tabDivision, JPdivision.class, null);
    }//GEN-LAST:event_btnCrudDivisionActionPerformed

    private void btnCrudProveedrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudProveedrActionPerformed
        addPaneles(tabProveedor, JPproveedor.class, null);
    }//GEN-LAST:event_btnCrudProveedrActionPerformed

    private void btnCrudProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudProductoActionPerformed
        addPaneles(tabProducto, JPproducto.class, null);
    }//GEN-LAST:event_btnCrudProductoActionPerformed

    private void btnCrudUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudUbicacionActionPerformed
        addPaneles(tabUbicacion, JPubicacion.class, null);
    }//GEN-LAST:event_btnCrudUbicacionActionPerformed

    private void btnContainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContainerActionPerformed
        addPaneles(tabFactura, JPentradaproveedor.class, null);
    }//GEN-LAST:event_btnContainerActionPerformed

    private void btnSalidaTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaTiendaActionPerformed
        addPaneles(tabSalida, JPsalida_p_tienda.class, null);
    }//GEN-LAST:event_btnSalidaTiendaActionPerformed


    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        panelClosableCentral.removeAll();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        addPaneles(tabPrecio, JPprecio_productos.class, null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        addPaneles(tabInventarioDiario, JPinventarioDiario.class, null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        addPaneles(tabAlmacen, JPalmacen.class, null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNCActionPerformed
        addPaneles(tabNotaCredito, JPnotaCreditoDebito.class, true);
    }//GEN-LAST:event_btNCActionPerformed

    private void btNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNDActionPerformed
        addPaneles(tabNotaDebito, JPnotaCreditoDebito.class, false);
    }//GEN-LAST:event_btNDActionPerformed

    private void TomaFisicaDistribuidora_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TomaFisicaDistribuidora_boton_ActionPerformed

        addPaneles(tabTomaFisica, Distribuidora1.class, null);
    }//GEN-LAST:event_TomaFisicaDistribuidora_boton_ActionPerformed

    private void AsignarMercancia_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarMercancia_boton_ActionPerformed

        addPaneles(tabAsignarMercancia, Asignar1.class, null);
    }//GEN-LAST:event_AsignarMercancia_boton_ActionPerformed

    private void TomaFisicaTiendas_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TomaFisicaTiendas_boton_ActionPerformed

        addPaneles(tabTomaFisicaTiendas, Tiendas1.class, null);
    }//GEN-LAST:event_TomaFisicaTiendas_boton_ActionPerformed

    private void ConsultaExistencia_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaExistencia_boton_ActionPerformed

        addPaneles(tabConsultarMerca, JPConsultaInventario.class, null);

        // TODO add your handling code here:
    }//GEN-LAST:event_ConsultaExistencia_boton_ActionPerformed

    private void jXButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton2ActionPerformed

        addPaneles(tabMecanciaEnProceso, JPMecanciaEnProceso.class, null);
    }//GEN-LAST:event_jXButton2ActionPerformed

    private void ExportData_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportData_boton_ActionPerformed

        addPaneles(tabExportData, JPexportData.class, null);
    }//GEN-LAST:event_ExportData_boton_ActionPerformed

    private void jXButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton1ActionPerformed

        addPaneles(tabUsuarios, JPusuario.class, null);
    }//GEN-LAST:event_jXButton1ActionPerformed

    private void Boton_Inprimir_Reporte_conteo_DistribuidoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_Inprimir_Reporte_conteo_DistribuidoraActionPerformed

        //        try {
        //            JasperPrint jasperPrint;
        //            Class.forName("org.postgresql.Driver");
        //            Connection conexion = DriverManager.getConnection("jdbc:postgresql://tecnosys.dyndns.tv:5432/miyake_pasantia", "postgres", "admin");
        //            //JasperCompileManager.compileReportToFile(rutaJrxml, rutaJasper);
        //            JasperCompileManager.compileReport(rutaJrxml);
        //            jasperPrint = JasperFillManager.fillReport(rutaJasper, null, conexion);
        //            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
        //            jasperViewer.setTitle("Reporte Conteo de Mercancía");
        //            jasperViewer.setVisible(true);
        //
        //            //
        //            //            JasperReport reporte = (JasperReport) JRLoader.loadObject("report2.jasper");
        //            //            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
        //            //            JRExporter exporter = new JRPdfExporter();
        //            //            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        //            //            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reportePDF.pdf"));
        //            //            exporter.exportReport();
        //        } catch (ClassNotFoundException | SQLException | JRException e) {
        //            JOptionPane.showMessageDialog(null, "error" + e);
        //
        //        }
    }//GEN-LAST:event_Boton_Inprimir_Reporte_conteo_DistribuidoraActionPerformed

    private void btnCrudProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudProductoMouseEntered
        Component cpm = (Component) evt.getSource();
        jpMenu.show(cpm,
                cpm.getWidth(),
                0);
    }//GEN-LAST:event_btnCrudProductoMouseEntered

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new FventanaIncial().setVisible(true);
                try {
                    UIManager.setLookAndFeel(new SubstanceBusinessBlueSteelLookAndFeel());

                    //me gusta    UIManager.setLookAndFeel(new SubstanceCremeCoffeeLookAndFeel());
                    //TaskPaneUI.createUI(new (TaskPaneUI)SubstanceCremeCoffeeLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(FventanaIncial.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton AsignarMercancia_boton_;
    private javax.swing.JButton Boton_Inprimir_Reporte_conteo_Distribuidora;
    private org.jdesktop.swingx.JXButton ConsultaExistencia_boton_;
    private javax.swing.JButton ExportData_boton_;
    private javax.swing.JButton TomaFisicaDistribuidora_boton_;
    private org.jdesktop.swingx.JXButton TomaFisicaTiendas_boton_;
    private org.jdesktop.swingx.JXButton UbicacionProducto_boton_;
    private javax.swing.JButton btNC;
    private javax.swing.JButton btND;
    private javax.swing.JButton btnContainer;
    private javax.swing.JButton btnCrudClasificacion;
    private javax.swing.JButton btnCrudContact;
    private javax.swing.JButton btnCrudDepto;
    private javax.swing.JButton btnCrudDivision;
    private javax.swing.JButton btnCrudMarca;
    private javax.swing.JButton btnCrudProducto;
    private javax.swing.JButton btnCrudProveedr;
    private javax.swing.JButton btnCrudUbicacion;
    private javax.swing.JButton btnSalidaTienda;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBarSistemaMiyake;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelControlesPrincipales;
    private org.jdesktop.swingx.JXButton jXButton1;
    private org.jdesktop.swingx.JXButton jXButton2;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane1;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
<<<<<<< HEAD (e3e2680) - Modificaciones GUI
    private javax.swing.JMenuItem jmConsultar;
    private javax.swing.JMenuItem jmCrear;
    private javax.swing.JMenuItem jmEliminar;
    private javax.swing.JMenuItem jmModificar;
    private javax.swing.JPopupMenu jpMenu;
    private com.ClosableTabbedPane panel;
=======
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuFacturacion;
    private javax.swing.JMenu menuInventario;
    private javax.swing.JMenu menuMercancia;
    private javax.swing.JMenu menuNotas;
    private javax.swing.JMenu menuProveedor;
    private javax.swing.JMenu menuTiendas;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenu menuUtilidades;
    private com.ClosableTabbedPane panelClosableCentral;
    private org.jdesktop.swingx.JXTaskPane taskPaneConsultas;
>>>>>>> origin/master (68d148f) - add menu bar
    private org.jdesktop.swingx.JXTaskPane taskPaneEtiquetas;
    private org.jdesktop.swingx.JXTaskPane taskPaneGestionMercancia;
    private org.jdesktop.swingx.JXTaskPane taskPaneModuloDeposito;
    private org.jdesktop.swingx.JXTaskPane taskPaneModuloFacturacion;
    private org.jdesktop.swingx.JXTaskPane taskPaneModuloTienda;
    private org.jdesktop.swingx.JXTaskPane taskPaneProducto;
    private org.jdesktop.swingx.JXTaskPane taskPaneProveedores;
    private org.jdesktop.swingx.JXTaskPane taskPaneReportes;
    private org.jdesktop.swingx.JXTaskPane taskPaneUtilidades;
    // End of variables declaration//GEN-END:variables
}
 class ClockLabel extends JLabel implements ActionListener {

        public ClockLabel() {
            super("" + new Date());
            Timer t = new Timer(1000, this);
            t.start();
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            setText((new Date()).toString());
        }
    }
