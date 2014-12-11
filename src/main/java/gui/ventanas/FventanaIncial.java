package gui.ventanas;

import gui.paneles.Asignar1;
import gui.paneles.Distribuidora1;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel;
import gui.paneles.JPConsultaInventario;
import gui.paneles.JPMecanciaEnProceso;
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
import gui.paneles.JPexportData;
import gui.paneles.JPnotaCreditoDebito;
import gui.paneles.JPusuario;
import gui.paneles.Tiendas1;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private void addPaneles(String titulo, Class panelNuevo, Boolean tipo, Integer tabCrud) {
        try {

            int pos = isContained(titulo);
            if (pos == -1) {
                if (panelNuevo.equals(JPnotaCreditoDebito.class)) {//si es una nota de credito/debito
                    panelClosableCentral.addTab(titulo, (JPanel) panelNuevo.getConstructor(Boolean.class).newInstance(tipo));
                } else {
                    if (tabCrud != null) {//si es un crud
                        Constructor[] ctr = panelNuevo.getConstructors();
                        System.out.println(tabCrud);
                        panelClosableCentral.addTab(titulo, new JPproducto(tabCrud));

//                        panelClosableCentral.addTab(titulo,
//                                (JPanel) panelNuevo.getConstructor(Integer.class).newInstance(tabCrud));
                    } else {
                        panelClosableCentral.addTab(titulo, (JPanel) panelNuevo.newInstance());
                    }
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

        menuCRUDProducto = new javax.swing.JPopupMenu();
        jmConsultarProducto = new javax.swing.JMenuItem();
        jmCrearProducto = new javax.swing.JMenuItem();
        jmModificarProducto = new javax.swing.JMenuItem();
        jmEliminarProducto = new javax.swing.JMenuItem();
        menuCRUDAlmacen = new javax.swing.JPopupMenu();
        jmConsultarAlmacen = new javax.swing.JMenuItem();
        jmCrearAlmacen = new javax.swing.JMenuItem();
        jmModificarAlmacen = new javax.swing.JMenuItem();
        jmEliminarAlmacen = new javax.swing.JMenuItem();
        menuCRUDMarca = new javax.swing.JPopupMenu();
        jmConsultarMarca = new javax.swing.JMenuItem();
        jmCrearMarca = new javax.swing.JMenuItem();
        jmModificarMarca = new javax.swing.JMenuItem();
        jmEliminarMarca = new javax.swing.JMenuItem();
        menuCRUDClasificacion = new javax.swing.JPopupMenu();
        jmConsultarClasificacion = new javax.swing.JMenuItem();
        jmCrearClasificacion = new javax.swing.JMenuItem();
        jmModificarClasificacion = new javax.swing.JMenuItem();
        jmEliminarClasificacion = new javax.swing.JMenuItem();
        menuCRUDDepartamento = new javax.swing.JPopupMenu();
        jmConsultarDepartamento = new javax.swing.JMenuItem();
        jmCrearDepartamento = new javax.swing.JMenuItem();
        jmModificarDepartamento = new javax.swing.JMenuItem();
        jmEliminarDepartamento = new javax.swing.JMenuItem();
        menuCRUDDivision = new javax.swing.JPopupMenu();
        jmConsultarDivision = new javax.swing.JMenuItem();
        jmCrearDivision = new javax.swing.JMenuItem();
        jmModificarDivision = new javax.swing.JMenuItem();
        jmEliminarDivision = new javax.swing.JMenuItem();
        menuNotas = new javax.swing.JMenu();
        jmNotaCredito = new javax.swing.JMenuItem();
        jmNotaDebito = new javax.swing.JMenuItem();
        menuCRUDProveedor = new javax.swing.JPopupMenu();
        jmConsultarProveedor = new javax.swing.JMenuItem();
        jmCrearProveedor = new javax.swing.JMenuItem();
        jmModificarProveedor = new javax.swing.JMenuItem();
        jmEliminarProveedor = new javax.swing.JMenuItem();
        menuGestionPrecio = new javax.swing.JMenu();
        jmImprimirEtiquetas = new javax.swing.JMenuItem();
        jmMenuActualizarPrecio = new javax.swing.JMenu();
        jmConsultarPrecio = new javax.swing.JMenuItem();
        jmModificarPrecio = new javax.swing.JMenuItem();
        panelPrincipal = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        jPanelControlesPrincipales = new javax.swing.JPanel();
        jXCollapsiblePaneIzquierdo = new org.jdesktop.swingx.JXCollapsiblePane();
        jXCollapsiblePaneAbajo = new org.jdesktop.swingx.JXCollapsiblePane();
        taskPaneModuloDistribuidor = new org.jdesktop.swingx.JXTaskPane();
        btnContainer = new javax.swing.JButton();
        btnCrudProveedr = new javax.swing.JButton();
        TomaFisicaDistribuidora_boton_ = new javax.swing.JButton();
        AsignarMercancia_boton_ = new org.jdesktop.swingx.JXButton();
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
        btnCrudUbicacion = new javax.swing.JButton();
        jXButton1 = new org.jdesktop.swingx.JXButton();
        ExportData_boton_ = new javax.swing.JButton();
        btnCrudContact = new javax.swing.JButton();
        ConsultaExistencia_boton_ = new org.jdesktop.swingx.JXButton();
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
        jMenuItemInvDiario = new javax.swing.JMenuItem();
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

        jmConsultarProducto.setText("Consultar");
        jmConsultarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarProductoActionPerformed(evt);
            }
        });
        menuCRUDProducto.add(jmConsultarProducto);

        jmCrearProducto.setText("Crear");
        jmCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearProductoActionPerformed(evt);
            }
        });
        menuCRUDProducto.add(jmCrearProducto);

        jmModificarProducto.setText("Modificar");
        jmModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModificarProductoActionPerformed(evt);
            }
        });
        menuCRUDProducto.add(jmModificarProducto);

        jmEliminarProducto.setText("Eliminar");
        jmEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEliminarProductoActionPerformed(evt);
            }
        });
        menuCRUDProducto.add(jmEliminarProducto);

        jmConsultarAlmacen.setText("Consultar");
        jmConsultarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarAlmacenActionPerformed(evt);
            }
        });
        menuCRUDAlmacen.add(jmConsultarAlmacen);

        jmCrearAlmacen.setText("Crear");
        jmCrearAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearAlmacenActionPerformed(evt);
            }
        });
        menuCRUDAlmacen.add(jmCrearAlmacen);

        jmModificarAlmacen.setText("Modificar");
        jmModificarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModificarAlmacenActionPerformed(evt);
            }
        });
        menuCRUDAlmacen.add(jmModificarAlmacen);

        jmEliminarAlmacen.setText("Eliminar");
        jmEliminarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEliminarAlmacenActionPerformed(evt);
            }
        });
        menuCRUDAlmacen.add(jmEliminarAlmacen);

        jmConsultarMarca.setText("Consultar");
        jmConsultarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarMarcaActionPerformed(evt);
            }
        });
        menuCRUDMarca.add(jmConsultarMarca);

        jmCrearMarca.setText("Crear");
        jmCrearMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearMarcaActionPerformed(evt);
            }
        });
        menuCRUDMarca.add(jmCrearMarca);

        jmModificarMarca.setText("Modificar");
        jmModificarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModificarMarcaActionPerformed(evt);
            }
        });
        menuCRUDMarca.add(jmModificarMarca);

        jmEliminarMarca.setText("Eliminar");
        jmEliminarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEliminarMarcaActionPerformed(evt);
            }
        });
        menuCRUDMarca.add(jmEliminarMarca);

        jmConsultarClasificacion.setText("Consultar");
        jmConsultarClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarClasificacionActionPerformed(evt);
            }
        });
        menuCRUDClasificacion.add(jmConsultarClasificacion);

        jmCrearClasificacion.setText("Crear");
        jmCrearClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearClasificacionActionPerformed(evt);
            }
        });
        menuCRUDClasificacion.add(jmCrearClasificacion);

        jmModificarClasificacion.setText("Modificar");
        jmModificarClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModificarClasificacionActionPerformed(evt);
            }
        });
        menuCRUDClasificacion.add(jmModificarClasificacion);

        jmEliminarClasificacion.setText("Eliminar");
        jmEliminarClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEliminarClasificacionActionPerformed(evt);
            }
        });
        menuCRUDClasificacion.add(jmEliminarClasificacion);

        jmConsultarDepartamento.setText("Consultar");
        jmConsultarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarDepartamentoActionPerformed(evt);
            }
        });
        menuCRUDDepartamento.add(jmConsultarDepartamento);

        jmCrearDepartamento.setText("Crear");
        jmCrearDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearDepartamentoActionPerformed(evt);
            }
        });
        menuCRUDDepartamento.add(jmCrearDepartamento);

        jmModificarDepartamento.setText("Modificar");
        jmModificarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModificarDepartamentoActionPerformed(evt);
            }
        });
        menuCRUDDepartamento.add(jmModificarDepartamento);

        jmEliminarDepartamento.setText("Eliminar");
        jmEliminarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEliminarDepartamentoActionPerformed(evt);
            }
        });
        menuCRUDDepartamento.add(jmEliminarDepartamento);

        jmConsultarDivision.setText("Consultar");
        jmConsultarDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarDivisionActionPerformed(evt);
            }
        });
        menuCRUDDivision.add(jmConsultarDivision);

        jmCrearDivision.setText("Crear");
        jmCrearDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearDivisionActionPerformed(evt);
            }
        });
        menuCRUDDivision.add(jmCrearDivision);

        jmModificarDivision.setText("Modificar");
        jmModificarDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModificarDivisionActionPerformed(evt);
            }
        });
        menuCRUDDivision.add(jmModificarDivision);

        jmEliminarDivision.setText("Eliminar");
        jmEliminarDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEliminarDivisionActionPerformed(evt);
            }
        });
        menuCRUDDivision.add(jmEliminarDivision);

        menuNotas.setText("jMenu1");

        jmNotaCredito.setText("jMenuItem1");
        jmNotaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNotaCreditoActionPerformed(evt);
            }
        });
        menuNotas.add(jmNotaCredito);

        jmNotaDebito.setText("jMenuItem1");
        jmNotaDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNotaDebitoActionPerformed(evt);
            }
        });
        menuNotas.add(jmNotaDebito);

        jmConsultarProveedor.setText("Consultar");
        jmConsultarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarProveedorActionPerformed(evt);
            }
        });
        menuCRUDProveedor.add(jmConsultarProveedor);

        jmCrearProveedor.setText("Crear");
        jmCrearProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearProveedorActionPerformed(evt);
            }
        });
        menuCRUDProveedor.add(jmCrearProveedor);

        jmModificarProveedor.setText("Modificar");
        jmModificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModificarProveedorActionPerformed(evt);
            }
        });
        menuCRUDProveedor.add(jmModificarProveedor);

        jmEliminarProveedor.setText("Eliminar");
        jmEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEliminarProveedorActionPerformed(evt);
            }
        });
        menuCRUDProveedor.add(jmEliminarProveedor);

        menuGestionPrecio.setText("jMenu1");

        jmImprimirEtiquetas.setText("jMenuItem1");
        jmImprimirEtiquetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmImprimirEtiquetasActionPerformed(evt);
            }
        });
        menuGestionPrecio.add(jmImprimirEtiquetas);

        jmMenuActualizarPrecio.setText("jMenu1");

        jmConsultarPrecio.setText("jMenuItem1");
        jmConsultarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarPrecioActionPerformed(evt);
            }
        });
        jmMenuActualizarPrecio.add(jmConsultarPrecio);

        jmModificarPrecio.setText("jMenuItem2");
        jmModificarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModificarPrecioActionPerformed(evt);
            }
        });
        jmMenuActualizarPrecio.add(jmModificarPrecio);

        menuGestionPrecio.add(jmMenuActualizarPrecio);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(9, 182, 201));
        setMinimumSize(new java.awt.Dimension(412, 641));

        panelPrincipal.setAlignmentX(0.0F);
        panelPrincipal.setAlignmentY(0.0F);
        panelPrincipal.setLayout(new java.awt.BorderLayout());

        jScrollPane.setHorizontalScrollBar(null);

        jPanelControlesPrincipales.setAlignmentX(0.0F);
        jPanelControlesPrincipales.setLayout(new javax.swing.BoxLayout(jPanelControlesPrincipales, javax.swing.BoxLayout.Y_AXIS));

        jXCollapsiblePaneIzquierdo.setAnimated(false);
        jXCollapsiblePaneIzquierdo.setDirection(org.jdesktop.swingx.JXCollapsiblePane.Direction.LEFT);
        jXCollapsiblePaneIzquierdo.setToolTipText("Para Abrir/Cerrar (Ctrl+A)");
        org.jdesktop.swingx.VerticalLayout verticalLayout13 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout13.setGap(2);
        jXCollapsiblePaneIzquierdo.getContentPane().setLayout(verticalLayout13);

        jXCollapsiblePaneAbajo.setOpaque(false);
        jXCollapsiblePaneAbajo.setAlignmentX(0.0F);
        jXCollapsiblePaneAbajo.getContentPane().setLayout(new org.jdesktop.swingx.VerticalLayout());

        taskPaneModuloDistribuidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416862043_inventory-maintenance.png"))); // NOI18N
        taskPaneModuloDistribuidor.setTitle("Distribuidora");

        btnContainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417636398_document.png"))); // NOI18N
        btnContainer.setText("Registrar Container        ");
        btnContainer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnContainer.setBorderPainted(false);
        btnContainer.setContentAreaFilled(false);
        btnContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnContainerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnContainerMouseExited(evt);
            }
        });
        btnContainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContainerActionPerformed(evt);
            }
        });
        taskPaneModuloDistribuidor.getContentPane().add(btnContainer);

        btnCrudProveedr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417576112_Order_tracking.png"))); // NOI18N
        btnCrudProveedr.setText("Proveedor                        ");
        btnCrudProveedr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrudProveedr.setBorderPainted(false);
        btnCrudProveedr.setContentAreaFilled(false);
        btnCrudProveedr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrudProveedrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrudProveedrMouseExited(evt);
            }
        });
        taskPaneModuloDistribuidor.getContentPane().add(btnCrudProveedr);

        TomaFisicaDistribuidora_boton_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417901443_Warehouse_icon_3D_rev-16.png"))); // NOI18N
        TomaFisicaDistribuidora_boton_.setText("Toma Fisica                        ");
        TomaFisicaDistribuidora_boton_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TomaFisicaDistribuidora_boton_.setBorderPainted(false);
        TomaFisicaDistribuidora_boton_.setContentAreaFilled(false);
        TomaFisicaDistribuidora_boton_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TomaFisicaDistribuidora_boton_MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TomaFisicaDistribuidora_boton_MouseExited(evt);
            }
        });
        TomaFisicaDistribuidora_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomaFisicaDistribuidora_boton_ActionPerformed(evt);
            }
        });
        taskPaneModuloDistribuidor.getContentPane().add(TomaFisicaDistribuidora_boton_);

        AsignarMercancia_boton_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AsignarMercancia_boton_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416789791_database_add.png"))); // NOI18N
        AsignarMercancia_boton_.setText("Asignar Mercancia            ");
        AsignarMercancia_boton_.setBorderPainted(false);
        AsignarMercancia_boton_.setContentAreaFilled(false);
        AsignarMercancia_boton_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AsignarMercancia_boton_MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AsignarMercancia_boton_MouseExited(evt);
            }
        });
        AsignarMercancia_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarMercancia_boton_ActionPerformed(evt);
            }
        });
        taskPaneModuloDistribuidor.getContentPane().add(AsignarMercancia_boton_);

        botonEnvio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416789780_database_gear.png"))); // NOI18N
        botonEnvio.setText("Control de Envios            ");
        botonEnvio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonEnvio.setBorderPainted(false);
        botonEnvio.setContentAreaFilled(false);
        botonEnvio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonEnvioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEnvioMouseExited(evt);
            }
        });
        taskPaneModuloDistribuidor.getContentPane().add(botonEnvio);

        jXCollapsiblePaneAbajo.getContentPane().add(taskPaneModuloDistribuidor);

        taskPaneModuloTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417636353_shop.png"))); // NOI18N
        taskPaneModuloTienda.setTitle("Tiendas");

        jButtonAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417901443_Warehouse_icon_3D_rev-16.png"))); // NOI18N
        jButtonAlmacen.setText("Almacen");
        jButtonAlmacen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAlmacen.setBorderPainted(false);
        jButtonAlmacen.setContentAreaFilled(false);
        jButtonAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAlmacenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAlmacenMouseExited(evt);
            }
        });
        jButtonAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlmacenActionPerformed(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(jButtonAlmacen);

        TomaFisicaTiendas_boton_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TomaFisicaTiendas_boton_.setText("Toma Fisica");
        TomaFisicaTiendas_boton_.setBorderPainted(false);
        TomaFisicaTiendas_boton_.setContentAreaFilled(false);
        TomaFisicaTiendas_boton_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TomaFisicaTiendas_boton_MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TomaFisicaTiendas_boton_MouseExited(evt);
            }
        });
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
        jButtonControldeInvetario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonControldeInvetarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonControldeInvetarioMouseExited(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(jButtonControldeInvetario);

        jButtonPrecio.setText("Gestion de Precios");
        jButtonPrecio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonPrecio.setBorderPainted(false);
        jButtonPrecio.setContentAreaFilled(false);
        jButtonPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonPrecioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonPrecioMouseExited(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(jButtonPrecio);

        jButtonNotas.setText("Notas");
        jButtonNotas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonNotas.setBorderPainted(false);
        jButtonNotas.setContentAreaFilled(false);
        jButtonNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonNotasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonNotasMouseExited(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(jButtonNotas);

        jButton5Existencias.setText("Existencia");
        jButton5Existencias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5Existencias.setBorderPainted(false);
        jButton5Existencias.setContentAreaFilled(false);
        jButton5Existencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5ExistenciasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5ExistenciasMouseExited(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(jButton5Existencias);

        jButtonFacturas.setText("Facturas de Ventas");
        jButtonFacturas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonFacturas.setBorderPainted(false);
        jButtonFacturas.setContentAreaFilled(false);
        jButtonFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonFacturasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonFacturasMouseExited(evt);
            }
        });
        taskPaneModuloTienda.getContentPane().add(jButtonFacturas);

        jXCollapsiblePaneAbajo.getContentPane().add(taskPaneModuloTienda);

        taskPaneModuloGestionProductos.setCollapsed(true);
        taskPaneModuloGestionProductos.setTitle("Gestión de Productos");

        btnCrudProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415416322_list-accept.png"))); // NOI18N
        btnCrudProducto.setText("Producto       ");
        btnCrudProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrudProducto.setBorderPainted(false);
        btnCrudProducto.setContentAreaFilled(false);
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
        btnCrudMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrudMarcaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrudMarcaMouseExited(evt);
            }
        });
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
        btnCrudClasificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrudClasificacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrudClasificacionMouseExited(evt);
            }
        });
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
        btnCrudDepto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrudDeptoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrudDeptoMouseExited(evt);
            }
        });
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
        btnCrudDivision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrudDivisionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrudDivisionMouseExited(evt);
            }
        });
        btnCrudDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudDivisionActionPerformed(evt);
            }
        });
        taskPaneModuloGestionProductos.getContentPane().add(btnCrudDivision);

        jXCollapsiblePaneAbajo.getContentPane().add(taskPaneModuloGestionProductos);

        jXTaskPaneReportes.setCollapsed(true);
        jXTaskPaneReportes.setTitle("Reportes");
        jXTaskPaneReportes.setToolTipText("");

        jXTaskPaneDistribuidor.setCollapsed(true);
        jXTaskPaneDistribuidor.setTitle("Resportes Distribuidor");

        Boton_Inprimir_Reporte_conteo_Distribuidora.setText("Reporte Conteo Mercancia");
        Boton_Inprimir_Reporte_conteo_Distribuidora.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Boton_Inprimir_Reporte_conteo_Distribuidora.setBorderPainted(false);
        Boton_Inprimir_Reporte_conteo_Distribuidora.setContentAreaFilled(false);
        Boton_Inprimir_Reporte_conteo_Distribuidora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Boton_Inprimir_Reporte_conteo_DistribuidoraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Boton_Inprimir_Reporte_conteo_DistribuidoraMouseExited(evt);
            }
        });
        Boton_Inprimir_Reporte_conteo_Distribuidora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_Inprimir_Reporte_conteo_DistribuidoraActionPerformed(evt);
            }
        });
        jXTaskPaneDistribuidor.getContentPane().add(Boton_Inprimir_Reporte_conteo_Distribuidora);

        jXTaskPaneReportes.getContentPane().add(jXTaskPaneDistribuidor);

        jXTaskPaneTiendas.setTitle("Reportes Tiendas");
        jXTaskPaneReportes.getContentPane().add(jXTaskPaneTiendas);

        jXTaskPaneGestionProductos.setCollapsed(true);
        jXTaskPaneGestionProductos.setTitle("Reportes Productos");

        jButtonInventario.setText("Inventario Diario");
        jButtonInventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonInventario.setBorderPainted(false);
        jButtonInventario.setContentAreaFilled(false);
        jButtonInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonInventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonInventarioMouseExited(evt);
            }
        });
        jButtonInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInventarioActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(jButtonInventario);

        btnCrudUbicacion.setText("Ubicación");
        btnCrudUbicacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrudUbicacion.setBorderPainted(false);
        btnCrudUbicacion.setContentAreaFilled(false);
        btnCrudUbicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrudUbicacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrudUbicacionMouseExited(evt);
            }
        });
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
        jXButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jXButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jXButton1MouseExited(evt);
            }
        });
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
        ExportData_boton_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExportData_boton_MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExportData_boton_MouseExited(evt);
            }
        });
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
        btnCrudContact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrudContactMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrudContactMouseExited(evt);
            }
        });
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
        ConsultaExistencia_boton_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ConsultaExistencia_boton_MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ConsultaExistencia_boton_MouseExited(evt);
            }
        });
        ConsultaExistencia_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaExistencia_boton_ActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(ConsultaExistencia_boton_);

        jXButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXButton2.setText("Mercancia en Proceso");
        jXButton2.setBorderPainted(false);
        jXButton2.setContentAreaFilled(false);
        jXButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jXButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jXButton2MouseExited(evt);
            }
        });
        jXButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton2ActionPerformed(evt);
            }
        });
        jXTaskPaneGestionProductos.getContentPane().add(jXButton2);

        jXTaskPaneReportes.getContentPane().add(jXTaskPaneGestionProductos);

        jXCollapsiblePaneAbajo.getContentPane().add(jXTaskPaneReportes);

        jXCollapsiblePaneIzquierdo.getContentPane().add(jXCollapsiblePaneAbajo);

        jPanelControlesPrincipales.add(jXCollapsiblePaneIzquierdo);

        jScrollPane.setViewportView(jPanelControlesPrincipales);

        panelPrincipal.add(jScrollPane, java.awt.BorderLayout.WEST);

        panelClosableCentral.setAlignmentX(0.0F);
        panelClosableCentral.setAutoscrolls(true);
        panelClosableCentral.setMinimumSize(new java.awt.Dimension(100, 100));
        panelPrincipal.add(panelClosableCentral, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        menuArchivo.setText("Archivos");

        jMenuOpciones.setText("Opciones");

        jMenuPanelAccesoDirect.setText("Panel de Acceso Directo");

        jMenuItemAbrirCerrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
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

        jMenuTomaFisicaDistribuidora.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuTomaFisicaDistribuidora.setText("Toma Fisica Distribuidora");
        jMenuTomaFisicaDistribuidora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTomaFisicaDistribuidoraActionPerformed(evt);
            }
        });
        menuDistribuidor.add(jMenuTomaFisicaDistribuidora);

        jMenuAsignarMercanciaTiendas_.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
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

        jMenuItemTomaFisicaTiendas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemTomaFisicaTiendas.setText("Toma Fisica Tiendas");
        menuTiendas.add(jMenuItemTomaFisicaTiendas);

        jMenuControlInventario_.setText("Gestion Inventario");

        jMenuItemInvDiario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemInvDiario.setText("Inventario Diario");
        jMenuItemInvDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInvDiarioActionPerformed(evt);
            }
        });
        jMenuControlInventario_.add(jMenuItemInvDiario);

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


    private void jmConsultarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarProductoActionPerformed
        addPaneles(tabProducto, JPproducto.class, null, 0);
    }//GEN-LAST:event_jmConsultarProductoActionPerformed

    private void jmCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearProductoActionPerformed
        addPaneles(tabProducto, JPproducto.class, null, 1);
    }//GEN-LAST:event_jmCrearProductoActionPerformed

    private void jMenuItemAbrirCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirCerrarActionPerformed
        jXCollapsiblePaneIzquierdo.setCollapsed(!jXCollapsiblePaneIzquierdo.isCollapsed());
    }//GEN-LAST:event_jMenuItemAbrirCerrarActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuTomaFisicaDistribuidoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTomaFisicaDistribuidoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuTomaFisicaDistribuidoraActionPerformed

    private void jMenuItemImprimirEtiquetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImprimirEtiquetasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemImprimirEtiquetasActionPerformed

    private void btnContainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContainerActionPerformed
        addPaneles(tabFactura, JPentradaproveedor.class, null, null);
    }//GEN-LAST:event_btnContainerActionPerformed

    private void TomaFisicaDistribuidora_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TomaFisicaDistribuidora_boton_ActionPerformed
        addPaneles(tabTomaFisica, Distribuidora1.class, null, null);
    }//GEN-LAST:event_TomaFisicaDistribuidora_boton_ActionPerformed

    private void AsignarMercancia_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarMercancia_boton_ActionPerformed

        addPaneles(tabAsignarMercancia, Asignar1.class, null, null);
    }//GEN-LAST:event_AsignarMercancia_boton_ActionPerformed

    private void jButtonAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlmacenActionPerformed
        addPaneles(tabAlmacen, JPalmacen.class, null, 0);
    }//GEN-LAST:event_jButtonAlmacenActionPerformed

    private void TomaFisicaTiendas_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TomaFisicaTiendas_boton_ActionPerformed

        addPaneles(tabTomaFisicaTiendas, Tiendas1.class, null, 0);
    }//GEN-LAST:event_TomaFisicaTiendas_boton_ActionPerformed

    private void btnCrudProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudProductoMouseEntered
        btnCrudProducto.setBorderPainted(true);
        Component cpm = (Component) evt.getSource();
        menuCRUDProducto.show(cpm,
                cpm.getWidth(),
                0);
    }//GEN-LAST:event_btnCrudProductoMouseEntered

    private void btnCrudProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudProductoMouseExited
        btnCrudProducto.setBorderPainted(false);
    }//GEN-LAST:event_btnCrudProductoMouseExited

    private void btnCrudProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudProductoActionPerformed
        addPaneles(tabProducto, JPproducto.class, null, 0);
    }//GEN-LAST:event_btnCrudProductoActionPerformed

    private void btnCrudMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudMarcaActionPerformed
        addPaneles(tabMarca, JPmarca.class, null, 0);
    }//GEN-LAST:event_btnCrudMarcaActionPerformed

    private void btnCrudClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudClasificacionActionPerformed
        addPaneles(tabClasificacion, JPclasificacion.class, null, 0);
    }//GEN-LAST:event_btnCrudClasificacionActionPerformed

    private void btnCrudDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudDeptoActionPerformed
        addPaneles(tabDepartamento, JPdepartamento.class, null, 0);
    }//GEN-LAST:event_btnCrudDeptoActionPerformed

    private void btnCrudDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudDivisionActionPerformed
        addPaneles(tabDivision, JPdivision.class, null, 0);
    }//GEN-LAST:event_btnCrudDivisionActionPerformed

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

    private void jButtonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInventarioActionPerformed
        addPaneles(tabInventarioDiario, JPinventarioDiario.class, null, null);
    }//GEN-LAST:event_jButtonInventarioActionPerformed

    private void btnCrudUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudUbicacionActionPerformed
        addPaneles(tabUbicacion, JPubicacion.class, null, 0);
    }//GEN-LAST:event_btnCrudUbicacionActionPerformed

    private void jXButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton1ActionPerformed

        addPaneles(tabUsuarios, JPusuario.class, null, 0);
    }//GEN-LAST:event_jXButton1ActionPerformed

    private void ExportData_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportData_boton_ActionPerformed

        addPaneles(tabExportData, JPexportData.class, null, null);
    }//GEN-LAST:event_ExportData_boton_ActionPerformed

    private void btnCrudContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudContactActionPerformed
        addPaneles(tabContacto, JPcontacto.class, null, 0);
    }//GEN-LAST:event_btnCrudContactActionPerformed

    private void ConsultaExistencia_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaExistencia_boton_ActionPerformed

        addPaneles(tabConsultarMerca, JPConsultaInventario.class, null, null);

        // TODO add your handling code here:
    }//GEN-LAST:event_ConsultaExistencia_boton_ActionPerformed

    private void jXButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton2ActionPerformed

        addPaneles(tabMecanciaEnProceso, JPMecanciaEnProceso.class, null, null);
    }//GEN-LAST:event_jXButton2ActionPerformed

    private void btnContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContainerMouseEntered
        btnContainer.setBorderPainted(true);
    }//GEN-LAST:event_btnContainerMouseEntered

    private void btnCrudProveedrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudProveedrMouseEntered
        btnCrudProveedr.setBorderPainted(true);
    }//GEN-LAST:event_btnCrudProveedrMouseEntered

    private void TomaFisicaDistribuidora_boton_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TomaFisicaDistribuidora_boton_MouseEntered
        TomaFisicaDistribuidora_boton_.setBorderPainted(true);
    }//GEN-LAST:event_TomaFisicaDistribuidora_boton_MouseEntered

    private void botonEnvioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEnvioMouseEntered
        botonEnvio.setBorderPainted(true);
    }//GEN-LAST:event_botonEnvioMouseEntered

    private void jButtonAlmacenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAlmacenMouseEntered
        jButtonAlmacen.setBorderPainted(true);
    }//GEN-LAST:event_jButtonAlmacenMouseEntered

    private void jButtonControldeInvetarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonControldeInvetarioMouseEntered
        jButtonControldeInvetario.setBorderPainted(true);
    }//GEN-LAST:event_jButtonControldeInvetarioMouseEntered

    private void jButtonPrecioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPrecioMouseEntered
        jButtonPrecio.setBorderPainted(true);
    }//GEN-LAST:event_jButtonPrecioMouseEntered

    private void jButtonNotasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNotasMouseEntered
        jButtonNotas.setBorderPainted(true);
    }//GEN-LAST:event_jButtonNotasMouseEntered

    private void jButton5ExistenciasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5ExistenciasMouseEntered
        jButton5Existencias.setBorderPainted(true);
    }//GEN-LAST:event_jButton5ExistenciasMouseEntered

    private void jButtonFacturasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonFacturasMouseEntered
        jButtonFacturas.setBorderPainted(true);
    }//GEN-LAST:event_jButtonFacturasMouseEntered

    private void btnCrudMarcaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudMarcaMouseEntered
        btnCrudMarca.setBorderPainted(true);
    }//GEN-LAST:event_btnCrudMarcaMouseEntered

    private void btnCrudClasificacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudClasificacionMouseEntered
        btnCrudClasificacion.setBorderPainted(true);
    }//GEN-LAST:event_btnCrudClasificacionMouseEntered

    private void btnCrudDeptoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudDeptoMouseEntered
        btnCrudDepto.setBorderPainted(true);
    }//GEN-LAST:event_btnCrudDeptoMouseEntered

    private void btnCrudDivisionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudDivisionMouseEntered
        btnCrudDivision.setBorderPainted(true);
    }//GEN-LAST:event_btnCrudDivisionMouseEntered

    private void Boton_Inprimir_Reporte_conteo_DistribuidoraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Boton_Inprimir_Reporte_conteo_DistribuidoraMouseEntered
        Boton_Inprimir_Reporte_conteo_Distribuidora.setBorderPainted(true);
    }//GEN-LAST:event_Boton_Inprimir_Reporte_conteo_DistribuidoraMouseEntered

    private void jButtonInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInventarioMouseEntered
        jButtonInventario.setBorderPainted(true);
    }//GEN-LAST:event_jButtonInventarioMouseEntered

    private void btnCrudUbicacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudUbicacionMouseEntered
        btnCrudUbicacion.setBorderPainted(true);
    }//GEN-LAST:event_btnCrudUbicacionMouseEntered

    private void ExportData_boton_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportData_boton_MouseEntered
        ExportData_boton_.setBorderPainted(true);
    }//GEN-LAST:event_ExportData_boton_MouseEntered

    private void btnCrudContactMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudContactMouseEntered
        btnCrudContact.setBorderPainted(true);
    }//GEN-LAST:event_btnCrudContactMouseEntered

    private void AsignarMercancia_boton_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AsignarMercancia_boton_MouseEntered
        AsignarMercancia_boton_.setBorderPainted(true);
    }//GEN-LAST:event_AsignarMercancia_boton_MouseEntered

    private void TomaFisicaTiendas_boton_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TomaFisicaTiendas_boton_MouseEntered
        TomaFisicaTiendas_boton_.setBorderPainted(true);
    }//GEN-LAST:event_TomaFisicaTiendas_boton_MouseEntered

    private void jXButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXButton1MouseEntered
        jXButton1.setBorderPainted(true);
    }//GEN-LAST:event_jXButton1MouseEntered

    private void ConsultaExistencia_boton_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsultaExistencia_boton_MouseEntered
        ConsultaExistencia_boton_.setBorderPainted(true);
    }//GEN-LAST:event_ConsultaExistencia_boton_MouseEntered

    private void jXButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXButton2MouseEntered
        jXButton2.setBorderPainted(true);
    }//GEN-LAST:event_jXButton2MouseEntered

    private void btnContainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContainerMouseExited
        btnContainer.setBorderPainted(false);
    }//GEN-LAST:event_btnContainerMouseExited

    private void btnCrudProveedrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudProveedrMouseExited
        btnCrudProveedr.setBorderPainted(false);
    }//GEN-LAST:event_btnCrudProveedrMouseExited

    private void TomaFisicaDistribuidora_boton_MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TomaFisicaDistribuidora_boton_MouseExited
        TomaFisicaDistribuidora_boton_.setBorderPainted(false);
    }//GEN-LAST:event_TomaFisicaDistribuidora_boton_MouseExited

    private void AsignarMercancia_boton_MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AsignarMercancia_boton_MouseExited
        AsignarMercancia_boton_.setBorderPainted(false);
    }//GEN-LAST:event_AsignarMercancia_boton_MouseExited

    private void botonEnvioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEnvioMouseExited
        botonEnvio.setBorderPainted(false);
    }//GEN-LAST:event_botonEnvioMouseExited

    private void jButtonAlmacenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAlmacenMouseExited
        jButtonAlmacen.setBorderPainted(false);
    }//GEN-LAST:event_jButtonAlmacenMouseExited

    private void TomaFisicaTiendas_boton_MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TomaFisicaTiendas_boton_MouseExited
        TomaFisicaTiendas_boton_.setBorderPainted(false);
    }//GEN-LAST:event_TomaFisicaTiendas_boton_MouseExited

    private void jButtonControldeInvetarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonControldeInvetarioMouseExited
        jButtonControldeInvetario.setBorderPainted(false);
    }//GEN-LAST:event_jButtonControldeInvetarioMouseExited

    private void jButtonPrecioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPrecioMouseExited
        jButtonPrecio.setBorderPainted(false);
    }//GEN-LAST:event_jButtonPrecioMouseExited

    private void jButtonNotasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNotasMouseExited
        jButtonNotas.setBorderPainted(false);
    }//GEN-LAST:event_jButtonNotasMouseExited

    private void jButton5ExistenciasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5ExistenciasMouseExited
        jButton5Existencias.setBorderPainted(false);
    }//GEN-LAST:event_jButton5ExistenciasMouseExited

    private void jButtonFacturasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonFacturasMouseExited
        jButtonFacturas.setBorderPainted(false);
    }//GEN-LAST:event_jButtonFacturasMouseExited

    private void btnCrudMarcaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudMarcaMouseExited
        btnCrudMarca.setBorderPainted(false);
    }//GEN-LAST:event_btnCrudMarcaMouseExited

    private void btnCrudClasificacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudClasificacionMouseExited
        btnCrudClasificacion.setBorderPainted(false);
    }//GEN-LAST:event_btnCrudClasificacionMouseExited

    private void btnCrudDeptoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudDeptoMouseExited
        btnCrudDepto.setBorderPainted(false);
    }//GEN-LAST:event_btnCrudDeptoMouseExited

    private void btnCrudDivisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudDivisionMouseExited
        btnCrudDivision.setBorderPainted(false);
    }//GEN-LAST:event_btnCrudDivisionMouseExited

    private void Boton_Inprimir_Reporte_conteo_DistribuidoraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Boton_Inprimir_Reporte_conteo_DistribuidoraMouseExited
        Boton_Inprimir_Reporte_conteo_Distribuidora.setBorderPainted(false);
    }//GEN-LAST:event_Boton_Inprimir_Reporte_conteo_DistribuidoraMouseExited

    private void jButtonInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInventarioMouseExited
        jButtonInventario.setBorderPainted(false);
    }//GEN-LAST:event_jButtonInventarioMouseExited

    private void btnCrudUbicacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudUbicacionMouseExited
        btnCrudUbicacion.setBorderPainted(false);
    }//GEN-LAST:event_btnCrudUbicacionMouseExited

    private void jXButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXButton1MouseExited
        jXButton1.setBorderPainted(false);
    }//GEN-LAST:event_jXButton1MouseExited

    private void ExportData_boton_MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportData_boton_MouseExited
        ExportData_boton_.setBorderPainted(false);
    }//GEN-LAST:event_ExportData_boton_MouseExited

    private void btnCrudContactMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudContactMouseExited
        btnCrudContact.setBorderPainted(false);
    }//GEN-LAST:event_btnCrudContactMouseExited

    private void ConsultaExistencia_boton_MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsultaExistencia_boton_MouseExited
        ConsultaExistencia_boton_.setBorderPainted(false);
    }//GEN-LAST:event_ConsultaExistencia_boton_MouseExited

    private void jXButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXButton2MouseExited
        jXButton2.setBorderPainted(false);
    }//GEN-LAST:event_jXButton2MouseExited

    private void jmModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModificarProductoActionPerformed
        addPaneles(tabProducto, JPproducto.class, null, 2);
    }//GEN-LAST:event_jmModificarProductoActionPerformed

    private void jmEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEliminarProductoActionPerformed
        addPaneles(tabProducto, JPproducto.class, null, 3);
    }//GEN-LAST:event_jmEliminarProductoActionPerformed

    private void jMenuItemInvDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInvDiarioActionPerformed
        addPaneles(tabInventarioDiario, JPinventarioDiario.class, null, null);
    }//GEN-LAST:event_jMenuItemInvDiarioActionPerformed

    private void jmConsultarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarAlmacenActionPerformed
        addPaneles(tabAlmacen, JPalmacen.class, null, 0);
    }//GEN-LAST:event_jmConsultarAlmacenActionPerformed

    private void jmCrearAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearAlmacenActionPerformed
        addPaneles(tabAlmacen, JPalmacen.class, null, 1);
    }//GEN-LAST:event_jmCrearAlmacenActionPerformed

    private void jmModificarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModificarAlmacenActionPerformed
        addPaneles(tabAlmacen, JPalmacen.class, null, 2);
    }//GEN-LAST:event_jmModificarAlmacenActionPerformed

    private void jmEliminarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEliminarAlmacenActionPerformed
        addPaneles(tabAlmacen, JPalmacen.class, null, 3);
    }//GEN-LAST:event_jmEliminarAlmacenActionPerformed

    private void jmConsultarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarMarcaActionPerformed
        addPaneles(tabMarca, JPmarca.class, null, 0);
    }//GEN-LAST:event_jmConsultarMarcaActionPerformed

    private void jmCrearMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearMarcaActionPerformed
        addPaneles(tabMarca, JPmarca.class, null, 1);
    }//GEN-LAST:event_jmCrearMarcaActionPerformed

    private void jmModificarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModificarMarcaActionPerformed
        addPaneles(tabMarca, JPmarca.class, null, 2);
    }//GEN-LAST:event_jmModificarMarcaActionPerformed

    private void jmEliminarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEliminarMarcaActionPerformed
        addPaneles(tabMarca, JPmarca.class, null, 3);
    }//GEN-LAST:event_jmEliminarMarcaActionPerformed

    private void jmConsultarClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarClasificacionActionPerformed
        addPaneles(tabClasificacion, JPclasificacion.class, null, 0);
    }//GEN-LAST:event_jmConsultarClasificacionActionPerformed

    private void jmCrearClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearClasificacionActionPerformed
        addPaneles(tabClasificacion, JPclasificacion.class, null, 1);
    }//GEN-LAST:event_jmCrearClasificacionActionPerformed

    private void jmModificarClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModificarClasificacionActionPerformed
        addPaneles(tabClasificacion, JPclasificacion.class, null, 2);
    }//GEN-LAST:event_jmModificarClasificacionActionPerformed

    private void jmEliminarClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEliminarClasificacionActionPerformed
        addPaneles(tabClasificacion, JPclasificacion.class, null, 3);
    }//GEN-LAST:event_jmEliminarClasificacionActionPerformed

    private void jmConsultarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarDepartamentoActionPerformed
        addPaneles(tabDepartamento, JPdepartamento.class, null, 0);
    }//GEN-LAST:event_jmConsultarDepartamentoActionPerformed

    private void jmCrearDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearDepartamentoActionPerformed
        addPaneles(tabDepartamento, JPdepartamento.class, null, 1);
    }//GEN-LAST:event_jmCrearDepartamentoActionPerformed

    private void jmModificarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModificarDepartamentoActionPerformed
        addPaneles(tabDepartamento, JPdepartamento.class, null, 2);
    }//GEN-LAST:event_jmModificarDepartamentoActionPerformed

    private void jmEliminarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEliminarDepartamentoActionPerformed
        addPaneles(tabDepartamento, JPdepartamento.class, null, 3);
    }//GEN-LAST:event_jmEliminarDepartamentoActionPerformed

    private void jmConsultarDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarDivisionActionPerformed
        addPaneles(tabDivision, JPdivision.class, null, 0);
    }//GEN-LAST:event_jmConsultarDivisionActionPerformed

    private void jmCrearDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearDivisionActionPerformed
        addPaneles(tabDivision, JPdivision.class, null, 1);
    }//GEN-LAST:event_jmCrearDivisionActionPerformed

    private void jmModificarDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModificarDivisionActionPerformed
        addPaneles(tabDivision, JPdivision.class, null, 2);
    }//GEN-LAST:event_jmModificarDivisionActionPerformed

    private void jmEliminarDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEliminarDivisionActionPerformed
        addPaneles(tabDivision, JPdivision.class, null, 3);
    }//GEN-LAST:event_jmEliminarDivisionActionPerformed

    private void jmNotaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNotaCreditoActionPerformed
        addPaneles(tabNotaCredito, JPnotaCreditoDebito.class, true, null);
    }//GEN-LAST:event_jmNotaCreditoActionPerformed

    private void jmNotaDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNotaDebitoActionPerformed
        addPaneles(tabNotaCredito, JPnotaCreditoDebito.class, false, null);
    }//GEN-LAST:event_jmNotaDebitoActionPerformed

    private void jmConsultarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarProveedorActionPerformed
        addPaneles(tabProveedor, JPproveedor.class, null, 0);
    }//GEN-LAST:event_jmConsultarProveedorActionPerformed

    private void jmCrearProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearProveedorActionPerformed
        addPaneles(tabProveedor, JPproveedor.class, null, 1);
    }//GEN-LAST:event_jmCrearProveedorActionPerformed

    private void jmModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModificarProveedorActionPerformed
        addPaneles(tabProveedor, JPproveedor.class, null, 2);
    }//GEN-LAST:event_jmModificarProveedorActionPerformed

    private void jmEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEliminarProveedorActionPerformed
        addPaneles(tabProveedor, JPproveedor.class, null, 3);
    }//GEN-LAST:event_jmEliminarProveedorActionPerformed

    private void jmImprimirEtiquetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmImprimirEtiquetasActionPerformed
        addPaneles(tabSalida, JPsalida_p_tienda.class, null, null);
    }//GEN-LAST:event_jmImprimirEtiquetasActionPerformed

    private void jmConsultarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarPrecioActionPerformed
        addPaneles(tabPrecio, JPprecio_productos.class, null, 0);
    }//GEN-LAST:event_jmConsultarPrecioActionPerformed

    private void jmModificarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModificarPrecioActionPerformed
        addPaneles(tabPrecio, JPprecio_productos.class, null, 1);
    }//GEN-LAST:event_jmModificarPrecioActionPerformed

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
    private javax.swing.JButton TomaFisicaDistribuidora_boton_;
    private org.jdesktop.swingx.JXButton TomaFisicaTiendas_boton_;
    private javax.swing.JButton botonEnvio;
    private javax.swing.JButton btnContainer;
    private javax.swing.JButton btnCrudClasificacion;
    private javax.swing.JButton btnCrudContact;
    private javax.swing.JButton btnCrudDepto;
    private javax.swing.JButton btnCrudDivision;
    private javax.swing.JButton btnCrudMarca;
    private javax.swing.JButton btnCrudProducto;
    private javax.swing.JButton btnCrudProveedr;
    private javax.swing.JButton btnCrudUbicacion;
    private javax.swing.JButton jButton5Existencias;
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
    private javax.swing.JMenuItem jMenuItemInvDiario;
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
    private javax.swing.JPanel jPanelControlesPrincipales;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXButton jXButton1;
    private org.jdesktop.swingx.JXButton jXButton2;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePaneAbajo;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePaneIzquierdo;
    private org.jdesktop.swingx.JXTaskPane jXTaskPaneDistribuidor;
    private org.jdesktop.swingx.JXTaskPane jXTaskPaneGestionProductos;
    private org.jdesktop.swingx.JXTaskPane jXTaskPaneReportes;
    private org.jdesktop.swingx.JXTaskPane jXTaskPaneTiendas;
    private javax.swing.JMenuItem jmConsultarAlmacen;
    private javax.swing.JMenuItem jmConsultarClasificacion;
    private javax.swing.JMenuItem jmConsultarDepartamento;
    private javax.swing.JMenuItem jmConsultarDivision;
    private javax.swing.JMenuItem jmConsultarMarca;
    private javax.swing.JMenuItem jmConsultarPrecio;
    private javax.swing.JMenuItem jmConsultarProducto;
    private javax.swing.JMenuItem jmConsultarProveedor;
    private javax.swing.JMenuItem jmCrearAlmacen;
    private javax.swing.JMenuItem jmCrearClasificacion;
    private javax.swing.JMenuItem jmCrearDepartamento;
    private javax.swing.JMenuItem jmCrearDivision;
    private javax.swing.JMenuItem jmCrearMarca;
    private javax.swing.JMenuItem jmCrearProducto;
    private javax.swing.JMenuItem jmCrearProveedor;
    private javax.swing.JMenuItem jmEliminarAlmacen;
    private javax.swing.JMenuItem jmEliminarClasificacion;
    private javax.swing.JMenuItem jmEliminarDepartamento;
    private javax.swing.JMenuItem jmEliminarDivision;
    private javax.swing.JMenuItem jmEliminarMarca;
    private javax.swing.JMenuItem jmEliminarProducto;
    private javax.swing.JMenuItem jmEliminarProveedor;
    private javax.swing.JMenuItem jmImprimirEtiquetas;
    private javax.swing.JMenu jmMenuActualizarPrecio;
    private javax.swing.JMenuItem jmModificarAlmacen;
    private javax.swing.JMenuItem jmModificarClasificacion;
    private javax.swing.JMenuItem jmModificarDepartamento;
    private javax.swing.JMenuItem jmModificarDivision;
    private javax.swing.JMenuItem jmModificarMarca;
    private javax.swing.JMenuItem jmModificarPrecio;
    private javax.swing.JMenuItem jmModificarProducto;
    private javax.swing.JMenuItem jmModificarProveedor;
    private javax.swing.JMenuItem jmNotaCredito;
    private javax.swing.JMenuItem jmNotaDebito;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JPopupMenu menuCRUDAlmacen;
    private javax.swing.JPopupMenu menuCRUDClasificacion;
    private javax.swing.JPopupMenu menuCRUDDepartamento;
    private javax.swing.JPopupMenu menuCRUDDivision;
    private javax.swing.JPopupMenu menuCRUDMarca;
    private javax.swing.JPopupMenu menuCRUDProducto;
    private javax.swing.JPopupMenu menuCRUDProveedor;
    private javax.swing.JMenu menuDetalles;
    private javax.swing.JMenu menuDistribuidor;
    private javax.swing.JMenu menuGestionPrecio;
    private javax.swing.JMenu menuNotas;
    private javax.swing.JMenu menuProducto;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuTiendas;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenu menuUtilidades;
    private com.ClosableTabbedPane panelClosableCentral;
    private javax.swing.JPanel panelPrincipal;
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
