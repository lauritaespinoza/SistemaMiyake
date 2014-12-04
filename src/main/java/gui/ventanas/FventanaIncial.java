package gui.ventanas;

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
import gui.paneles.VisorExportSQL;
import java.lang.reflect.InvocationTargetException;
import net.sf.jasperreports.engine.JRException;

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
    private static final String tabNotaCredito = "Notas de Crédito en Tienda";
    private static final String tabNotaDebito = "Notas de Débito en Tienda";
    private static final String tabAlmacen = "Almacen";

    private BufferedImage bg;

    public static List<List> listaUsuarioMain;

    public FventanaIncial() {
        initComponents();
    }

    public FventanaIncial(List<List> user) {
        FventanaIncial.listaUsuarioMain = user;

        initComponents();
    }

    //el tipo se usa en nota de credito debito
    private void addPaneles(String titulo, Class panelNuevo, Boolean tipo) {
        try {

            int pos = isContained(titulo);
            if (pos == -1) {
                if (panelNuevo.equals(JPnotaCreditoDebito.class)) {//si es una nota de credito/debito
                    panel.addTab(titulo, (JPanel) panelNuevo.getConstructor(Boolean.class).newInstance(tipo));
                } else {
                    panel.addTab(titulo, (JPanel) panelNuevo.newInstance());
                }
                panel.setSelectedIndex(panel.getTabCount() - 1);
            } else {
                panel.setSelectedIndex(pos);
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
        for (int i = 0; i < panel.getTabCount(); i++) {

            if (panel.getTabTitleAt(i).equals(titulo)) {
                return i;//si encontro, retorna la posicion

            }
        }

        return -1;//si nunca lo encontro
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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
        jXButton3 = new org.jdesktop.swingx.JXButton();
        jXButton4 = new org.jdesktop.swingx.JXButton();
        taskPaneModuloDeposito = new org.jdesktop.swingx.JXTaskPane();
        ExportData_boton_ = new javax.swing.JButton();
        TomaFisicaDistribuidora_boton_ = new javax.swing.JButton();
        AsignarMercancia_boton_ = new org.jdesktop.swingx.JXButton();
        TomaFisicaTiendas_boton_ = new org.jdesktop.swingx.JXButton();
        ConsultaExistencia_boton_ = new org.jdesktop.swingx.JXButton();
        UbicacionProducto_boton_ = new org.jdesktop.swingx.JXButton();
        jXButton1 = new org.jdesktop.swingx.JXButton();
        jXButton2 = new org.jdesktop.swingx.JXButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        button1 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        try {
            bg = ImageIO.read(getClass().getResource("/iconos/logomiyake.png"));

        } catch (IOException ex) {
            Logger.getLogger(FventanaIncial.class

                .getName()).log(Level.SEVERE, null, ex);

        }
        panel = new com.ClosableTabbedPane(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 50, getWidth(), getHeight()-50, this);
            }

        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Administrativo Miyake.");
        setBackground(new java.awt.Color(9, 182, 201));

        jPanel1.setBackground(new java.awt.Color(107, 181, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        jPanel1.setForeground(new java.awt.Color(0, 73, 146));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415656208_Home.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415663705_reload_all_tabs.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415663403_010.png"))); // NOI18N
        jLabel4.setToolTipText("");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415656313_Exit.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);

        jPanel2.setAlignmentX(0.0F);

        jXCollapsiblePane1.setOpaque(false);
        jXCollapsiblePane1.setAlignmentX(0.0F);

        taskPaneModuloFacturacion.setCollapsed(true);
        taskPaneModuloFacturacion.setTitle("Facturación");

        taskPaneProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415658077_database.png"))); // NOI18N
        taskPaneProducto.setSpecial(true);
        taskPaneProducto.setTitle("Productos");

        btnCrudProducto.setText("Producto");
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

        taskPaneModuloTienda.setTitle("Tienda");

        jButton6.setText("Almacen");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText("Inventario Diario");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btNC.setText("Notas de Crédito");
        btNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNCActionPerformed(evt);
            }
        });

        btND.setText("Notas de Débito");
        btND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNDActionPerformed(evt);
            }
        });

        jXButton3.setText("modificado jose");
        jXButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton3ActionPerformed(evt);
            }
        });

        jXButton4.setText("modificado joseasdasdd jose");
        jXButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout taskPaneModuloTiendaLayout = new javax.swing.GroupLayout(taskPaneModuloTienda.getContentPane());
        taskPaneModuloTienda.getContentPane().setLayout(taskPaneModuloTiendaLayout);
        taskPaneModuloTiendaLayout.setHorizontalGroup(
            taskPaneModuloTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
            .addComponent(btNC, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
            .addComponent(btND, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
            .addComponent(jXButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        taskPaneModuloTiendaLayout.setVerticalGroup(
            taskPaneModuloTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskPaneModuloTiendaLayout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btNC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btND)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jXButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jXButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        taskPaneModuloDeposito.setTitle("Depósito");

        ExportData_boton_.setText("Export Datos");
        ExportData_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportData_boton_ActionPerformed(evt);
            }
        });
        taskPaneModuloDeposito.getContentPane().add(ExportData_boton_);

        TomaFisicaDistribuidora_boton_.setText("Toma Fisica Distribuidora");
        TomaFisicaDistribuidora_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomaFisicaDistribuidora_boton_ActionPerformed(evt);
            }
        });
        taskPaneModuloDeposito.getContentPane().add(TomaFisicaDistribuidora_boton_);

        AsignarMercancia_boton_.setText("Gestion Mercancia ");
        AsignarMercancia_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarMercancia_boton_ActionPerformed(evt);
            }
        });
        taskPaneModuloDeposito.getContentPane().add(AsignarMercancia_boton_);

        TomaFisicaTiendas_boton_.setText("Toma Fisica Tiendas");
        TomaFisicaTiendas_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomaFisicaTiendas_boton_ActionPerformed(evt);
            }
        });
        taskPaneModuloDeposito.getContentPane().add(TomaFisicaTiendas_boton_);

        ConsultaExistencia_boton_.setText("Consultar Existencia");
        ConsultaExistencia_boton_.setActionCommand("Consultar Inventario ");
        ConsultaExistencia_boton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaExistencia_boton_ActionPerformed(evt);
            }
        });
        taskPaneModuloDeposito.getContentPane().add(ConsultaExistencia_boton_);

        UbicacionProducto_boton_.setText("Ubicacion Producto");
        taskPaneModuloDeposito.getContentPane().add(UbicacionProducto_boton_);

        jXButton1.setText("Usuarios");
        jXButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton1ActionPerformed(evt);
            }
        });
        taskPaneModuloDeposito.getContentPane().add(jXButton1);

        jXButton2.setText("Mercancia en Proceso");
        jXButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton2ActionPerformed(evt);
            }
        });
        taskPaneModuloDeposito.getContentPane().add(jXButton2);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        button1.setLabel("button1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXCollapsiblePane1Layout = new javax.swing.GroupLayout(jXCollapsiblePane1.getContentPane());
        jXCollapsiblePane1.getContentPane().setLayout(jXCollapsiblePane1Layout);
        jXCollapsiblePane1Layout.setHorizontalGroup(
            jXCollapsiblePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(taskPaneModuloFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(taskPaneModuloTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(taskPaneModuloDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jXCollapsiblePane1Layout.setVerticalGroup(
            jXCollapsiblePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXCollapsiblePane1Layout.createSequentialGroup()
                .addComponent(taskPaneModuloFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(taskPaneModuloTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(taskPaneModuloDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXCollapsiblePane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXCollapsiblePane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel.setAlignmentX(0.0F);
        panel.setAutoscrolls(true);
        panel.setMinimumSize(new java.awt.Dimension(100, 100));
        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane2.setViewportView(jLayeredPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );

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


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String rutaJasper = "src/main/resources/reportes/imagenparametro.jasper";
        String rutaJrxml = "src/main/resources/reportes/imagenparametro.jrxml";
        String rutaImagen = "src/main/resources/imagenes/Salir.png";
        try {
            JasperPrint jasperPrint = null;

            Map<String, Object> parametro = new HashMap<>();

            BufferedImage imagen = ImageIO.read(getClass().getResource("/imagenes/Salir.png"));

            parametro.put("imagen", imagen);

            JasperCompileManager.compileReportToFile(rutaJrxml, rutaJasper);
            jasperPrint = JasperFillManager.fillReport(rutaJasper, parametro, new JREmptyDataSource());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setTitle("Imagen");
            jasperViewer.setVisible(true);
        } catch (IOException | JRException e) {
            JOptionPane.showMessageDialog(this, "error" + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        panel.removeAll();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String rutaJasper = "src/main/resources/reportes/ReporteConteoMercancia.jasper";
        String rutaJrxml = "src/main/resources/reportes/ReporteConteoMercancia.jrxml";

        try {
            JasperPrint jasperPrint = null;
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://192.2.1.70:5432/miyake_pasantia", "postgres", "admin");
            JasperCompileManager.compileReportToFile(rutaJrxml, rutaJasper);
            jasperPrint = JasperFillManager.fillReport(rutaJasper, null, conexion);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setTitle("Reporte Conteo de Mercancía");
            jasperViewer.setVisible(true);

//            
//            JasperReport reporte = (JasperReport) JRLoader.loadObject("report2.jasper");
//            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
//            JRExporter exporter = new JRPdfExporter();
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reportePDF.pdf"));
//            exporter.exportReport();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        addPaneles(tabPrecio, JPprecio_productos.class, null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        addPaneles(tabInventarioDiario, JPinventarioDiario.class, null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        addPaneles(tabAlmacen, JPalmacen.class, null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        addPaneles(tabAlmacen, JPNewJPanel.class, null);// TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void ExportData_boton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportData_boton_ActionPerformed

        addPaneles(tabExportData, JPexportData.class, null);

    }//GEN-LAST:event_ExportData_boton_ActionPerformed

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

    private void jXButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton1ActionPerformed

        addPaneles(tabUsuarios, JPusuario.class, null);
    }//GEN-LAST:event_jXButton1ActionPerformed

    private void jXButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton2ActionPerformed
       
        addPaneles(tabMecanciaEnProceso, JPMecanciaEnProceso.class, null);
        
    }//GEN-LAST:event_jXButton2ActionPerformed

    private void btNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNCActionPerformed
       addPaneles(tabNotaCredito, JPnotaCreditoDebito.class, true);
    }//GEN-LAST:event_btNCActionPerformed

    private void btNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNDActionPerformed
       addPaneles(tabNotaDebito, JPnotaCreditoDebito.class, false);
    }//GEN-LAST:event_btNDActionPerformed

    private void jXButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton3ActionPerformed
        // accion1
    }//GEN-LAST:event_jXButton3ActionPerformed

    private void jXButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton4ActionPerformed
        // accion 3 jose
    }//GEN-LAST:event_jXButton4ActionPerformed

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
    private java.awt.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXButton jXButton1;
    private org.jdesktop.swingx.JXButton jXButton2;
    private org.jdesktop.swingx.JXButton jXButton3;
    private org.jdesktop.swingx.JXButton jXButton4;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane1;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private com.ClosableTabbedPane panel;
    private org.jdesktop.swingx.JXTaskPane taskPaneEtiquetas;
    private org.jdesktop.swingx.JXTaskPane taskPaneModuloDeposito;
    private org.jdesktop.swingx.JXTaskPane taskPaneModuloFacturacion;
    private org.jdesktop.swingx.JXTaskPane taskPaneModuloTienda;
    private org.jdesktop.swingx.JXTaskPane taskPaneProducto;
    private org.jdesktop.swingx.JXTaskPane taskPaneProveedores;
    // End of variables declaration//GEN-END:variables
}
