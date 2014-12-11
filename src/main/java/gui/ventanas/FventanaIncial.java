package gui.ventanas;

import com.l2fprod.util.ImageUtils;
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
import java.awt.Component;
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
                    //panelClosableCentral.addTab(titulo, (JPanel) panelNuevo.getConstructor(Integer.class).newInstance(tabPanel));
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
        PanelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelCollapsible = new javax.swing.JPanel();
        jXCollapsiblePaneIzquierdo = new org.jdesktop.swingx.JXCollapsiblePane();
        jXCollapsiblePaneAbajo = new org.jdesktop.swingx.JXCollapsiblePane();
        taskPaneModuloDistribuidor = new org.jdesktop.swingx.JXTaskPane();
        btnContainer = new javax.swing.JButton();
        btnCrudProveedr = new javax.swing.JButton();
        TomaFisicaDistribuidora_boton_ = new javax.swing.JButton();
        AsignarMercancia_boton_ = new org.jdesktop.swingx.JXButton();
        jButtonActualizarPrecio = new javax.swing.JButton();
        botonEnvio = new javax.swing.JButton();
        taskPaneModuloTienda = new org.jdesktop.swingx.JXTaskPane();
        jButtonAlmacen = new javax.swing.JButton();
        TomaFisicaTiendas_boton_ = new org.jdesktop.swingx.JXButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonControldeInvetario = new javax.swing.JButton();
        jButtonPrecio = new javax.swing.JButton();
        jButtonNotas = new javax.swing.JButton();
        jButton5Existencias = new javax.swing.JButton();
        jButtonFacturas = new javax.swing.JButton();
        taskPaneModuloGestionProductos = new org.jdesktop.swingx.JXTaskPane();
        btnCrudProducto = new javax.swing.JButton();
        btnCrudMarca = new javax.swing.JButton();
        btnCrudClasificacion = new javax.swing.JButton();
        btnCrudDepto = new javax.swing.JButton();
        btnCrudDivision = new javax.swing.JButton();
        jXTaskPaneReportes = new org.jdesktop.swingx.JXTaskPane();
        jXTaskPaneDistribuidor = new org.jdesktop.swingx.JXTaskPane();
        Boton_Inprimir_Reporte_conteo_Distribuidora = new javax.swing.JButton();
        jXTaskPaneTiendas = new org.jdesktop.swingx.JXTaskPane();
        jXTaskPaneGestionProductos = new org.jdesktop.swingx.JXTaskPane();
        jButtonInventario = new javax.swing.JButton();
        btNC = new javax.swing.JButton();
        btND = new javax.swing.JButton();
        btnCrudUbicacion = new javax.swing.JButton();
        jXButton1 = new org.jdesktop.swingx.JXButton();
        ExportData_boton_ = new javax.swing.JButton();
        btnCrudContact = new javax.swing.JButton();
        ConsultaExistencia_boton_ = new org.jdesktop.swingx.JXButton();
        btnSalidaTienda = new javax.swing.JButton();
        jXButton2 = new org.jdesktop.swingx.JXButton();
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
        jMenuOpciones = new javax.swing.JMenu();
        jMenuPanelAccesoDirect = new javax.swing.JMenu();
        jMenuItemAbrirCerrar = new javax.swing.JMenuItem();
        jMenuItemAbrirCerrarInternos = new javax.swing.JMenuItem();
        jMenuPanelOperacionInterno = new javax.swing.JMenu();
        jMenuItemBuscarPanel = new javax.swing.JMenuItem();
        jMenuItemReiniciarPanel = new javax.swing.JMenuItem();
        jMenuItemSalir = new javax.swing.JMenuItem();
        menuDistribuidor = new javax.swing.JMenu();
        jMenuProveedor_ = new javax.swing.JMenu();
        jMenuProveedor_Consultar_ = new javax.swing.JMenuItem();
        jMenuProveedor_Crear_ = new javax.swing.JMenuItem();
        jMenuProveedor__Modificar_ = new javax.swing.JMenuItem();
        jMenuProveedor_Eliminar_ = new javax.swing.JMenuItem();
        jMenuRegistroContainer_ = new javax.swing.JMenuItem();
        jMenuTomaFisicaDistribuidora = new javax.swing.JMenuItem();
        jMenuAsignarMercanciaTiendas_ = new javax.swing.JMenuItem();
        jMenuGestionPrecios_ = new javax.swing.JMenu();
        jMenuItemActualizarPrecios = new javax.swing.JMenuItem();
        jMenuItemImprimirEtiquetas = new javax.swing.JMenuItem();
        jMenuEstadoEnvios_ = new javax.swing.JMenu();
        jMenuMercanciaProceso_ = new javax.swing.JMenuItem();
        jMenuMercanciaFinalizada_ = new javax.swing.JMenuItem();
        menuTiendas = new javax.swing.JMenu();
        jMenuGestionAlmacenes_ = new javax.swing.JMenu();
        jMenuItemTomaFisicaTiendas = new javax.swing.JMenuItem();
        jMenuControlInventario_ = new javax.swing.JMenu();
        jMenuNotasDebitoCredito_ = new javax.swing.JMenu();
        jMenuItemControlExistencia_ = new javax.swing.JMenuItem();
        jMenuItemDetFactura = new javax.swing.JMenuItem();
        menuProducto = new javax.swing.JMenu();
        jMenuProductos = new javax.swing.JMenu();
        jMenuMarcas_ = new javax.swing.JMenu();
        jMenuClasificacion_ = new javax.swing.JMenu();
        jMenuDepartamento = new javax.swing.JMenu();
        jMenuDivision = new javax.swing.JMenu();
        menuUsuario = new javax.swing.JMenu();
        jMenuItemUsuarioConsulta = new javax.swing.JMenuItem();
        jMenuItemUsuarioCrear = new javax.swing.JMenuItem();
        jMenuItemUsuarioModificar = new javax.swing.JMenuItem();
        jMenuItemUsuarioEliminar = new javax.swing.JMenuItem();
        menuDetalles = new javax.swing.JMenu();
        jMenuUbicaciones = new javax.swing.JMenu();
        jMenuItemUbicacionConsultar = new javax.swing.JMenuItem();
        jMenuItemUbicacionCrear = new javax.swing.JMenuItem();
        jMenuItemUbicacionModificar = new javax.swing.JMenuItem();
        jMenuItemUbicacionEliminar = new javax.swing.JMenuItem();
        jMenuGestionContactos = new javax.swing.JMenu();
        jMenuItemContactoConsultar = new javax.swing.JMenuItem();
        jMenuItemContactoCrear = new javax.swing.JMenuItem();
        jMenuItemContactoModificar = new javax.swing.JMenuItem();
        jMenuItemContactoEliminar = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        menuUtilidades = new javax.swing.JMenu();
        jMenuItemRestaurarDatos = new javax.swing.JMenuItem();
        jMenuExportarDatos = new javax.swing.JMenu();
        jMenuItemExportarDatDesc = new javax.swing.JMenuItem();
        jMenuItemExportarBD = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        jMenuItemVerAyuda = new javax.swing.JMenuItem();
        jMenuItemAcercaDe = new javax.swing.JMenuItem();

        jmConsultar.setText("Consultar");
        jmConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarActionPerformed(evt);
            }
        });
        jpMenu.add(jmConsultar);

        jmCrear.setText("Crear");
        jmCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearActionPerformed(evt);
            }
        });
        jpMenu.add(jmCrear);

        jmModificar.setText("Modificar");
        jpMenu.add(jmModificar);

        jmEliminar.setText("Eliminar");
        jpMenu.add(jmEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(9, 182, 201));
        setMinimumSize(new java.awt.Dimension(8, 641));
        setPreferredSize(new java.awt.Dimension(800, 600));

        PanelPrincipal.setAlignmentX(0.0F);
        PanelPrincipal.setAlignmentY(0.0F);
        PanelPrincipal.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBar(null);

        jPanelCollapsible.setAlignmentX(0.0F);

        jXCollapsiblePaneIzquierdo.setAnimated(false);
        jXCollapsiblePaneIzquierdo.setDirection(org.jdesktop.swingx.JXCollapsiblePane.Direction.LEFT);
        org.jdesktop.swingx.VerticalLayout verticalLayout8 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout8.setGap(2);
        jXCollapsiblePaneIzquierdo.getContentPane().setLayout(verticalLayout8);

        taskPaneModuloDistribuidor.setCollapsed(true);
        taskPaneModuloDistribuidor.setTitle("Distribuidora");

        btnContainer.setText("Registrar Container        ");
        btnContainer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnContainer.setBorderPainted(false);
        btnContainer.setContentAreaFilled(false);
        btnContainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContainerActionPerformed(evt);
            }
        });
        taskPaneModuloDistribuidor.getContentPane().add(btnContainer);

        btnCrudProveedr.setText("Proveedor                       ");
        btnCrudProveedr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrudProveedr.setBorderPainted(false);
        btnCrudProveedr.setContentAreaFilled(false);
        btnCrudProveedr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudProveedrActionPerformed(evt);
            }
        });
        taskPaneModuloDistribuidor.getContentPane().add(btnCrudProveedr);

        TomaFisicaDistribuidora_boton_.setText("Toma Fisica Distribuidora");
        TomaFisicaDistribuidora_boton_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TomaFisicaDistribuidora_boton_.setBorderPainted(false);
        TomaFisicaDistribuidora_boton_.setContentAreaFilled(false);
        TomaFisicaDistribuidora_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomaFisicaDistribuidora_boton_ActionPerformed(evt);
            }
        });
        taskPaneModuloDistribuidor.getContentPane().add(TomaFisicaDistribuidora_boton_);

        AsignarMercancia_boton_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AsignarMercancia_boton_.setText("Asignar Mercancia ");
        AsignarMercancia_boton_.setBorderPainted(false);
        AsignarMercancia_boton_.setContentAreaFilled(false);
        AsignarMercancia_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarMercancia_boton_ActionPerformed(evt);
            }
        });
        taskPaneModuloDistribuidor.getContentPane().add(AsignarMercancia_boton_);

        jButtonActualizarPrecio.setText("Actualizar Precio");
        jButtonActualizarPrecio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonActualizarPrecio.setBorderPainted(false);
        jButtonActualizarPrecio.setContentAreaFilled(false);
        jButtonActualizarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarPrecioActionPerformed(evt);
            }
        });
        taskPaneModuloDistribuidor.getContentPane().add(jButtonActualizarPrecio);

        botonEnvio.setText("Control de Envios");
        botonEnvio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonEnvio.setBorderPainted(false);
        botonEnvio.setContentAreaFilled(false);
        botonEnvio.setRolloverEnabled(false);
        taskPaneModuloDistribuidor.getContentPane().add(botonEnvio);

        taskPaneModuloTienda.setCollapsed(true);
        taskPaneModuloTienda.setTitle("Tiendas");

        jButtonAlmacen.setText("Almacen");
        jButtonAlmacen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAlmacen.setBorderPainted(false);
        jButtonAlmacen.setContentAreaFilled(false);
        jButtonAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlmacenActionPerformed(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(jButtonAlmacen);

        TomaFisicaTiendas_boton_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TomaFisicaTiendas_boton_.setText("Toma Fisica Tiendas");
        TomaFisicaTiendas_boton_.setBorderPainted(false);
        TomaFisicaTiendas_boton_.setContentAreaFilled(false);
        TomaFisicaTiendas_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomaFisicaTiendas_boton_ActionPerformed(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(TomaFisicaTiendas_boton_);
        taskPaneModuloTienda.getContentPane().add(jSeparator1);

        jButtonControldeInvetario.setText("Control Inventario");
        jButtonControldeInvetario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonControldeInvetario.setBorderPainted(false);
        jButtonControldeInvetario.setContentAreaFilled(false);
        jButtonControldeInvetario.setRolloverEnabled(false);
        taskPaneModuloTienda.getContentPane().add(jButtonControldeInvetario);

        jButtonPrecio.setText("Gestion de Precios");
        jButtonPrecio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonPrecio.setBorderPainted(false);
        jButtonPrecio.setContentAreaFilled(false);
        jButtonPrecio.setRolloverEnabled(false);
        taskPaneModuloTienda.getContentPane().add(jButtonPrecio);

        jButtonNotas.setText("Notas");
        jButtonNotas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonNotas.setBorderPainted(false);
        jButtonNotas.setContentAreaFilled(false);
        jButtonNotas.setRolloverEnabled(false);
        taskPaneModuloTienda.getContentPane().add(jButtonNotas);

        jButton5Existencias.setText("Existencia");
        jButton5Existencias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5Existencias.setBorderPainted(false);
        jButton5Existencias.setContentAreaFilled(false);
        jButton5Existencias.setRolloverEnabled(false);
        taskPaneModuloTienda.getContentPane().add(jButton5Existencias);

        jButtonFacturas.setText("Facturas de Ventas");
        jButtonFacturas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonFacturas.setBorderPainted(false);
        jButtonFacturas.setContentAreaFilled(false);
        jButtonFacturas.setRolloverEnabled(false);
        taskPaneModuloTienda.getContentPane().add(jButtonFacturas);

        taskPaneModuloGestionProductos.setTitle("Gestión de Productos");

        btnCrudProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415416322_list-accept.png"))); // NOI18N
        btnCrudProducto.setText("Producto       ");
        btnCrudProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrudProducto.setBorderPainted(false);
        btnCrudProducto.setContentAreaFilled(false);
        btnCrudProducto.setRolloverEnabled(false);
        btnCrudProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrudProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrudProductoMouseExited(evt);
            }
        });
        btnCrudProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudProductoActionPerformed(evt);
            }
        });
        taskPaneModuloGestionProductos.getContentPane().add(btnCrudProducto);

        btnCrudMarca.setText("Marca");
        btnCrudMarca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrudMarca.setBorderPainted(false);
        btnCrudMarca.setContentAreaFilled(false);
        btnCrudMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudMarcaActionPerformed(evt);
            }
        });
        taskPaneModuloGestionProductos.getContentPane().add(btnCrudMarca);

        btnCrudClasificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416862043_inventory-maintenance.png"))); // NOI18N
        btnCrudClasificacion.setText("Clasificación    ");
        btnCrudClasificacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrudClasificacion.setBorderPainted(false);
        btnCrudClasificacion.setContentAreaFilled(false);
        btnCrudClasificacion.setRolloverEnabled(false);
        btnCrudClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudClasificacionActionPerformed(evt);
            }
        });
        taskPaneModuloGestionProductos.getContentPane().add(btnCrudClasificacion);

        btnCrudDepto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415667180_application-vnd.ms-excel.png"))); // NOI18N
        btnCrudDepto.setText("Departamento");
        btnCrudDepto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrudDepto.setBorderPainted(false);
        btnCrudDepto.setContentAreaFilled(false);
        btnCrudDepto.setRolloverEnabled(false);
        btnCrudDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudDeptoActionPerformed(evt);
            }
        });
        taskPaneModuloGestionProductos.getContentPane().add(btnCrudDepto);

        btnCrudDivision.setText("División");
        btnCrudDivision.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrudDivision.setBorderPainted(false);
        btnCrudDivision.setContentAreaFilled(false);
        btnCrudDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudDivisionActionPerformed(evt);
            }
        });
        taskPaneModuloGestionProductos.getContentPane().add(btnCrudDivision);

        jXTaskPaneReportes.setTitle("Reportes");
        jXTaskPaneReportes.setToolTipText("");

        jXTaskPaneDistribuidor.setTitle("Resportes Distribuidor");

        Boton_Inprimir_Reporte_conteo_Distribuidora.setText("Reporte Conteo Mercancia");
        Boton_Inprimir_Reporte_conteo_Distribuidora.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Boton_Inprimir_Reporte_conteo_Distribuidora.setBorderPainted(false);
        Boton_Inprimir_Reporte_conteo_Distribuidora.setContentAreaFilled(false);
        Boton_Inprimir_Reporte_conteo_Distribuidora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_Inprimir_Reporte_conteo_DistribuidoraActionPerformed(evt);
            }
        });
        jXTaskPaneDistribuidor.getContentPane().add(Boton_Inprimir_Reporte_conteo_Distribuidora);

        jXTaskPaneReportes.getContentPane().add(jXTaskPaneDistribuidor);

        jXTaskPaneTiendas.setTitle("Reportes Tiendas");
        jXTaskPaneReportes.getContentPane().add(jXTaskPaneTiendas);

        jXTaskPaneGestionProductos.setTitle("Reportes Productos");

        jButtonInventario.setText("Inventario Diario");
        jButtonInventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonInventario.setBorderPainted(false);
        jButtonInventario.setContentAreaFilled(false);
        jButtonInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInventarioActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(jButtonInventario);

        btNC.setText("Notas de Crédito");
        btNC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btNC.setBorderPainted(false);
        btNC.setContentAreaFilled(false);
        btNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNCActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(btNC);

        btND.setText("Notas de Débito");
        btND.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btND.setBorderPainted(false);
        btND.setContentAreaFilled(false);
        btND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNDActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(btND);

        btnCrudUbicacion.setText("Ubicación");
        btnCrudUbicacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrudUbicacion.setBorderPainted(false);
        btnCrudUbicacion.setContentAreaFilled(false);
        btnCrudUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudUbicacionActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(btnCrudUbicacion);

        jXButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXButton1.setText("Usuarios");
        jXButton1.setBorderPainted(false);
        jXButton1.setContentAreaFilled(false);
        jXButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton1ActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(jXButton1);

        ExportData_boton_.setText("Export Datos");
        ExportData_boton_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ExportData_boton_.setBorderPainted(false);
        ExportData_boton_.setContentAreaFilled(false);
        ExportData_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportData_boton_ActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(ExportData_boton_);

        btnCrudContact.setText("Contacto");
        btnCrudContact.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrudContact.setBorderPainted(false);
        btnCrudContact.setContentAreaFilled(false);
        btnCrudContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudContactActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(btnCrudContact);

        ConsultaExistencia_boton_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ConsultaExistencia_boton_.setText("Consultar Existencia");
        ConsultaExistencia_boton_.setActionCommand("Consultar Inventario ");
        ConsultaExistencia_boton_.setBorderPainted(false);
        ConsultaExistencia_boton_.setContentAreaFilled(false);
        ConsultaExistencia_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaExistencia_boton_ActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(ConsultaExistencia_boton_);

        btnSalidaTienda.setText("Mercancía Asignada");
        btnSalidaTienda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalidaTienda.setBorderPainted(false);
        btnSalidaTienda.setContentAreaFilled(false);
        btnSalidaTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaTiendaActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(btnSalidaTienda);

        jXButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXButton2.setText("Mercancia en Proceso");
        jXButton2.setBorderPainted(false);
        jXButton2.setContentAreaFilled(false);
        jXButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton2ActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(jXButton2);

        jXTaskPaneReportes.getContentPane().add(jXTaskPaneGestionProductos);

        javax.swing.GroupLayout jXCollapsiblePaneAbajoLayout = new javax.swing.GroupLayout(jXCollapsiblePaneAbajo.getContentPane());
        jXCollapsiblePaneAbajo.getContentPane().setLayout(jXCollapsiblePaneAbajoLayout);
        jXCollapsiblePaneAbajoLayout.setHorizontalGroup(
            jXCollapsiblePaneAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXCollapsiblePaneAbajoLayout.createSequentialGroup()
                .addGroup(jXCollapsiblePaneAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taskPaneModuloDistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taskPaneModuloTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taskPaneModuloGestionProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXTaskPaneReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXCollapsiblePaneAbajoLayout.setVerticalGroup(
            jXCollapsiblePaneAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXCollapsiblePaneAbajoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(taskPaneModuloDistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(taskPaneModuloTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(taskPaneModuloGestionProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jXTaskPaneReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jXCollapsiblePaneIzquierdo.getContentPane().add(jXCollapsiblePaneAbajo);

        javax.swing.GroupLayout jPanelCollapsibleLayout = new javax.swing.GroupLayout(jPanelCollapsible);
        jPanelCollapsible.setLayout(jPanelCollapsibleLayout);
        jPanelCollapsibleLayout.setHorizontalGroup(
            jPanelCollapsibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCollapsibleLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jXCollapsiblePaneIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanelCollapsibleLayout.setVerticalGroup(
            jPanelCollapsibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCollapsibleLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jXCollapsiblePaneIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setViewportView(jPanelCollapsible);

        PanelPrincipal.add(jScrollPane1, java.awt.BorderLayout.WEST);

        panelClosableCentral.setAlignmentX(0.0F);
        panelClosableCentral.setAutoscrolls(true);
        panelClosableCentral.setMinimumSize(new java.awt.Dimension(100, 100));
        PanelPrincipal.add(panelClosableCentral, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelPrincipal, java.awt.BorderLayout.CENTER);

        menuArchivo.setText("Archivos");

        jMenuOpciones.setText("Opciones");

        jMenuPanelAccesoDirect.setText("Panel de Acceso Directo");

        jMenuItemAbrirCerrar.setText("Abrir/Cerrar Panel de Acceso Directo");
        jMenuItemAbrirCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirCerrarActionPerformed(evt);
            }
        });
        jMenuPanelAccesoDirect.add(jMenuItemAbrirCerrar);

        jMenuItemAbrirCerrarInternos.setText("Abrir/Cerrar Paneles Internos");
        jMenuPanelAccesoDirect.add(jMenuItemAbrirCerrarInternos);

        jMenuOpciones.add(jMenuPanelAccesoDirect);

        jMenuPanelOperacionInterno.setText("Panel de Operaciones");

        jMenuItemBuscarPanel.setText("Buscar Panel");
        jMenuPanelOperacionInterno.add(jMenuItemBuscarPanel);

        jMenuItemReiniciarPanel.setText("Reiniciar Panel");
        jMenuPanelOperacionInterno.add(jMenuItemReiniciarPanel);

        jMenuOpciones.add(jMenuPanelOperacionInterno);

        menuArchivo.add(jMenuOpciones);

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuItemSalir);

        jMenuBarSistemaMiyake.add(menuArchivo);

        menuDistribuidor.setText("Distribuidora");

        jMenuProveedor_.setText("Gestion de Proveedores");

        jMenuProveedor_Consultar_.setText("Consultar");
        jMenuProveedor_.add(jMenuProveedor_Consultar_);

        jMenuProveedor_Crear_.setText("Crear");
        jMenuProveedor_.add(jMenuProveedor_Crear_);

        jMenuProveedor__Modificar_.setText("Modificar");
        jMenuProveedor_.add(jMenuProveedor__Modificar_);

        jMenuProveedor_Eliminar_.setText("Eliminar");
        jMenuProveedor_.add(jMenuProveedor_Eliminar_);

        menuDistribuidor.add(jMenuProveedor_);

        jMenuRegistroContainer_.setText("Registro de Container");
        menuDistribuidor.add(jMenuRegistroContainer_);

        jMenuTomaFisicaDistribuidora.setText("Toma Fisica Distribuidora");
        jMenuTomaFisicaDistribuidora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTomaFisicaDistribuidoraActionPerformed(evt);
            }
        });
        menuDistribuidor.add(jMenuTomaFisicaDistribuidora);

        jMenuAsignarMercanciaTiendas_.setText("Asignar Mercancia Tiendas");
        menuDistribuidor.add(jMenuAsignarMercanciaTiendas_);

        jMenuGestionPrecios_.setText("Control De Precios");

        jMenuItemActualizarPrecios.setText("Actualizar Precios");
        jMenuGestionPrecios_.add(jMenuItemActualizarPrecios);

        jMenuItemImprimirEtiquetas.setText("Imprimir Etiquetas");
        jMenuItemImprimirEtiquetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImprimirEtiquetasActionPerformed(evt);
            }
        });
        jMenuGestionPrecios_.add(jMenuItemImprimirEtiquetas);

        menuDistribuidor.add(jMenuGestionPrecios_);

        jMenuEstadoEnvios_.setText("Estado de Envios Mercancia");

        jMenuMercanciaProceso_.setText("Mercancia en Proceso");
        jMenuEstadoEnvios_.add(jMenuMercanciaProceso_);

        jMenuMercanciaFinalizada_.setText("Mercancia Finalizada");
        jMenuEstadoEnvios_.add(jMenuMercanciaFinalizada_);

        menuDistribuidor.add(jMenuEstadoEnvios_);

        jMenuBarSistemaMiyake.add(menuDistribuidor);

        menuTiendas.setText("Tiendas");

        jMenuGestionAlmacenes_.setText("Gestion Almacenes");
        menuTiendas.add(jMenuGestionAlmacenes_);

        jMenuItemTomaFisicaTiendas.setText("Toma Fisica Tiendas");
        menuTiendas.add(jMenuItemTomaFisicaTiendas);

        jMenuControlInventario_.setText("Gestion Inventario");
        menuTiendas.add(jMenuControlInventario_);

        jMenuNotasDebitoCredito_.setText("Notas Credito/Debito");
        menuTiendas.add(jMenuNotasDebitoCredito_);

        jMenuItemControlExistencia_.setText("Control Existencia");
        menuTiendas.add(jMenuItemControlExistencia_);

        jMenuItemDetFactura.setText("Detalles de Factura de Ventas");
        menuTiendas.add(jMenuItemDetFactura);

        jMenuBarSistemaMiyake.add(menuTiendas);

        menuProducto.setText("Gestion De Productos");

        jMenuProductos.setText("Productos");
        menuProducto.add(jMenuProductos);

        jMenuMarcas_.setText("Marcas");
        menuProducto.add(jMenuMarcas_);

        jMenuClasificacion_.setText("Clasificacion");
        menuProducto.add(jMenuClasificacion_);

        jMenuDepartamento.setText("Departamento");
        menuProducto.add(jMenuDepartamento);

        jMenuDivision.setText("Division");
        menuProducto.add(jMenuDivision);

        jMenuBarSistemaMiyake.add(menuProducto);

        menuUsuario.setText("Usuarios");

        jMenuItemUsuarioConsulta.setText("Consultar");
        menuUsuario.add(jMenuItemUsuarioConsulta);

        jMenuItemUsuarioCrear.setText("Crear");
        menuUsuario.add(jMenuItemUsuarioCrear);

        jMenuItemUsuarioModificar.setText("Modificar");
        menuUsuario.add(jMenuItemUsuarioModificar);

        jMenuItemUsuarioEliminar.setText("Eliminar");
        menuUsuario.add(jMenuItemUsuarioEliminar);

        jMenuBarSistemaMiyake.add(menuUsuario);

        menuDetalles.setText("Detalles");

        jMenuUbicaciones.setText("Ubicaciones Geográficas");

        jMenuItemUbicacionConsultar.setText("Consultar");
        jMenuUbicaciones.add(jMenuItemUbicacionConsultar);

        jMenuItemUbicacionCrear.setText("Crear");
        jMenuUbicaciones.add(jMenuItemUbicacionCrear);

        jMenuItemUbicacionModificar.setText("Modificar");
        jMenuUbicaciones.add(jMenuItemUbicacionModificar);

        jMenuItemUbicacionEliminar.setText("Eliminar");
        jMenuUbicaciones.add(jMenuItemUbicacionEliminar);

        menuDetalles.add(jMenuUbicaciones);

        jMenuGestionContactos.setText("Gestión de Contactos");

        jMenuItemContactoConsultar.setText("Consultar");
        jMenuGestionContactos.add(jMenuItemContactoConsultar);

        jMenuItemContactoCrear.setText("Crear");
        jMenuGestionContactos.add(jMenuItemContactoCrear);

        jMenuItemContactoModificar.setText("Modificar");
        jMenuGestionContactos.add(jMenuItemContactoModificar);

        jMenuItemContactoEliminar.setText("Eliminar");
        jMenuGestionContactos.add(jMenuItemContactoEliminar);

        menuDetalles.add(jMenuGestionContactos);

        jMenuBarSistemaMiyake.add(menuDetalles);

        menuReportes.setText("Reportes");
        jMenuBarSistemaMiyake.add(menuReportes);

        menuUtilidades.setText("Utilidades");

        jMenuItemRestaurarDatos.setText("Restaurar Bases de Datos");
        menuUtilidades.add(jMenuItemRestaurarDatos);

        jMenuExportarDatos.setText("Exportar Datos");

        jMenuItemExportarDatDesc.setText("Exportar Datos de Descuento");
        jMenuExportarDatos.add(jMenuItemExportarDatDesc);

        jMenuItemExportarBD.setText("Exportar Base de Datos");
        jMenuExportarDatos.add(jMenuItemExportarBD);

        menuUtilidades.add(jMenuExportarDatos);

        jMenuBarSistemaMiyake.add(menuUtilidades);

        menuAyuda.setText("Ayuda");

        jMenuItemVerAyuda.setText("Ver Ayuda");
        menuAyuda.add(jMenuItemVerAyuda);

        jMenuItemAcercaDe.setText("Acerca de");
        menuAyuda.add(jMenuItemAcercaDe);

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


    private void jButtonActualizarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarPrecioActionPerformed
        addPaneles(tabPrecio, JPprecio_productos.class, null);
    }//GEN-LAST:event_jButtonActualizarPrecioActionPerformed

    private void jButtonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInventarioActionPerformed
        addPaneles(tabInventarioDiario, JPinventarioDiario.class, null);
    }//GEN-LAST:event_jButtonInventarioActionPerformed

    private void jButtonAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlmacenActionPerformed
        addPaneles(tabAlmacen, JPalmacen.class, null);
    }//GEN-LAST:event_jButtonAlmacenActionPerformed

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
        btnCrudProducto.setBorderPainted(true);
        Component cpm = (Component) evt.getSource();
        jpMenu.show(cpm,
                cpm.getWidth(),
                0);
    }//GEN-LAST:event_btnCrudProductoMouseEntered

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuTomaFisicaDistribuidoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTomaFisicaDistribuidoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuTomaFisicaDistribuidoraActionPerformed

    private void btnCrudProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudProductoMouseExited
        btnCrudProducto.setBorderPainted(false);
    }//GEN-LAST:event_btnCrudProductoMouseExited

    private void jmCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearActionPerformed
        addPaneles(tabProducto, JPproducto.class, null);
    }//GEN-LAST:event_jmCrearActionPerformed

    private void jmConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarActionPerformed
        addPaneles(tabProducto, JPproducto.class, null);
    }//GEN-LAST:event_jmConsultarActionPerformed

    private void jMenuItemAbrirCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirCerrarActionPerformed
        jXCollapsiblePaneIzquierdo.setCollapsed(!jXCollapsiblePaneIzquierdo.isCollapsed());
    }//GEN-LAST:event_jMenuItemAbrirCerrarActionPerformed

    private void jXButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton1ActionPerformed

        addPaneles(tabUsuarios, JPusuario.class, null);
    }//GEN-LAST:event_jXButton1ActionPerformed

    private void ExportData_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportData_boton_ActionPerformed

        addPaneles(tabExportData, JPexportData.class, null);
    }//GEN-LAST:event_ExportData_boton_ActionPerformed

    private void jMenuItemImprimirEtiquetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImprimirEtiquetasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemImprimirEtiquetasActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
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
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton TomaFisicaDistribuidora_boton_;
    private org.jdesktop.swingx.JXButton TomaFisicaTiendas_boton_;
    private javax.swing.JButton botonEnvio;
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
    private javax.swing.JButton jButton5Existencias;
    private javax.swing.JButton jButtonActualizarPrecio;
    private javax.swing.JButton jButtonAlmacen;
    private javax.swing.JButton jButtonControldeInvetario;
    private javax.swing.JButton jButtonFacturas;
    private javax.swing.JButton jButtonInventario;
    private javax.swing.JButton jButtonNotas;
    private javax.swing.JButton jButtonPrecio;
    private javax.swing.JMenuItem jMenuAsignarMercanciaTiendas_;
    private javax.swing.JMenuBar jMenuBarSistemaMiyake;
    private javax.swing.JMenu jMenuClasificacion_;
    private javax.swing.JMenu jMenuControlInventario_;
    private javax.swing.JMenu jMenuDepartamento;
    private javax.swing.JMenu jMenuDivision;
    private javax.swing.JMenu jMenuEstadoEnvios_;
    private javax.swing.JMenu jMenuExportarDatos;
    private javax.swing.JMenu jMenuGestionAlmacenes_;
    private javax.swing.JMenu jMenuGestionContactos;
    private javax.swing.JMenu jMenuGestionPrecios_;
    private javax.swing.JMenuItem jMenuItemAbrirCerrar;
    private javax.swing.JMenuItem jMenuItemAbrirCerrarInternos;
    private javax.swing.JMenuItem jMenuItemAcercaDe;
    private javax.swing.JMenuItem jMenuItemActualizarPrecios;
    private javax.swing.JMenuItem jMenuItemBuscarPanel;
    private javax.swing.JMenuItem jMenuItemContactoConsultar;
    private javax.swing.JMenuItem jMenuItemContactoCrear;
    private javax.swing.JMenuItem jMenuItemContactoEliminar;
    private javax.swing.JMenuItem jMenuItemContactoModificar;
    private javax.swing.JMenuItem jMenuItemControlExistencia_;
    private javax.swing.JMenuItem jMenuItemDetFactura;
    private javax.swing.JMenuItem jMenuItemExportarBD;
    private javax.swing.JMenuItem jMenuItemExportarDatDesc;
    private javax.swing.JMenuItem jMenuItemImprimirEtiquetas;
    private javax.swing.JMenuItem jMenuItemReiniciarPanel;
    private javax.swing.JMenuItem jMenuItemRestaurarDatos;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemTomaFisicaTiendas;
    private javax.swing.JMenuItem jMenuItemUbicacionConsultar;
    private javax.swing.JMenuItem jMenuItemUbicacionCrear;
    private javax.swing.JMenuItem jMenuItemUbicacionEliminar;
    private javax.swing.JMenuItem jMenuItemUbicacionModificar;
    private javax.swing.JMenuItem jMenuItemUsuarioConsulta;
    private javax.swing.JMenuItem jMenuItemUsuarioCrear;
    private javax.swing.JMenuItem jMenuItemUsuarioEliminar;
    private javax.swing.JMenuItem jMenuItemUsuarioModificar;
    private javax.swing.JMenuItem jMenuItemVerAyuda;
    private javax.swing.JMenu jMenuMarcas_;
    private javax.swing.JMenuItem jMenuMercanciaFinalizada_;
    private javax.swing.JMenuItem jMenuMercanciaProceso_;
    private javax.swing.JMenu jMenuNotasDebitoCredito_;
    private javax.swing.JMenu jMenuOpciones;
    private javax.swing.JMenu jMenuPanelAccesoDirect;
    private javax.swing.JMenu jMenuPanelOperacionInterno;
    private javax.swing.JMenu jMenuProductos;
    private javax.swing.JMenu jMenuProveedor_;
    private javax.swing.JMenuItem jMenuProveedor_Consultar_;
    private javax.swing.JMenuItem jMenuProveedor_Crear_;
    private javax.swing.JMenuItem jMenuProveedor_Eliminar_;
    private javax.swing.JMenuItem jMenuProveedor__Modificar_;
    private javax.swing.JMenuItem jMenuRegistroContainer_;
    private javax.swing.JMenuItem jMenuTomaFisicaDistribuidora;
    private javax.swing.JMenu jMenuUbicaciones;
    private javax.swing.JPanel jPanelCollapsible;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXButton jXButton1;
    private org.jdesktop.swingx.JXButton jXButton2;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePaneAbajo;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePaneIzquierdo;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPaneDistribuidor;
    private org.jdesktop.swingx.JXTaskPane jXTaskPaneGestionProductos;
    private org.jdesktop.swingx.JXTaskPane jXTaskPaneReportes;
    private org.jdesktop.swingx.JXTaskPane jXTaskPaneTiendas;
    private javax.swing.JMenuItem jmConsultar;
    private javax.swing.JMenuItem jmCrear;
    private javax.swing.JMenuItem jmEliminar;
    private javax.swing.JMenuItem jmModificar;
    private javax.swing.JPopupMenu jpMenu;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuDetalles;
    private javax.swing.JMenu menuDistribuidor;
    private javax.swing.JMenu menuProducto;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuTiendas;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenu menuUtilidades;
    private com.ClosableTabbedPane panelClosableCentral;
    private org.jdesktop.swingx.JXTaskPane taskPaneModuloDistribuidor;
    private org.jdesktop.swingx.JXTaskPane taskPaneModuloGestionProductos;
    private org.jdesktop.swingx.JXTaskPane taskPaneModuloTienda;
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
