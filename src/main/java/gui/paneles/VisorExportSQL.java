/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import clases.csv.CSVreader;
import hibernate.DAO.ObjectModelDAO;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelos.mapeos.Almacen;
import static util.JavaUtil.cons_seleccionar;


/**
 *
 * @author Pablo
 */
public class VisorExportSQL extends javax.swing.JFrame {

    private CSVreader csvReader;
     
   private int pos_tienda ;
   // private int pos_proveedor;
    private List tiendas;

    public VisorExportSQL() {
        initComponents();
        cargarCB();
        busy.setEnabled(false);
        busy.setVisible(false);
        busy.setBusy(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filesc = new javax.swing.JFileChooser();
        filesc.setCurrentDirectory(new java.io.File("C:\\Users\\Usuario\\Documents\\PASANTIA"));

        filesc.setDialogTitle("Seleccione un archivo");
        jPanel3 = new javax.swing.JPanel();
        archivo = new javax.swing.JLabel();
        tabpanel = new javax.swing.JTabbedPane();
        panel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        lt1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ta2 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        codigoP = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        tipoP = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        precioP = new javax.swing.JLabel();
        totalSi = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        totalCi = new javax.swing.JLabel();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        AbrirArchivoBoton_ = new javax.swing.JButton();
        jXButton2 = new org.jdesktop.swingx.JXButton();
        GenerarArchivoBoton = new org.jdesktop.swingx.JXButton();
        jComboBox1 = new javax.swing.JComboBox();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        cb_tienda = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jXButton1 = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Componente"));

        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane6.setViewportView(ta1);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Vizualizar", jPanel12);

        lt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lt1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(lt1);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Seleccionar", jPanel13);

        ta2.setColumns(20);
        ta2.setRows(5);
        jScrollPane8.setViewportView(ta2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Datos", jPanel1);

        jLabel23.setText("Detalle");

        jLabel24.setText("Código Producto");

        codigoP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel25.setText("Tipo Producto");

        tipoP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel26.setText("Precio Producto");

        precioP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        totalSi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel27.setText("Total sin IVA");

        jLabel28.setText("Total con IVA");

        totalCi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(4, 4, 4))
                            .addComponent(jLabel24)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addGap(11, 11, 11)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precioP, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(totalCi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalSi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tipoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codigoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel23)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(codigoP, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(tipoP, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(precioP, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(totalSi, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalCi, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(73, 73, 73))
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabpanel.addTab("CSV", panel1);

        busy.setText("CARGANDO...!!!");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Exportacion de Datos. "));

        AbrirArchivoBoton_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/ayuda.png"))); // NOI18N
        AbrirArchivoBoton_.setText("Abrir Archivo");
        AbrirArchivoBoton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirArchivoBoton_ActionPerformed(evt);
            }
        });

        jXButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417212535_Forward.png"))); // NOI18N
        jXButton2.setText("Enviar Por Email");
        jXButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton2ActionPerformed(evt);
            }
        });

        GenerarArchivoBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1416789780_database_gear.png"))); // NOI18N
        GenerarArchivoBoton.setText("Generar Archivo");
        GenerarArchivoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarArchivoBotonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Generar Por BarCode", "Generar Por Descuento", "Generar Por Producto" }));

        jXLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/tipo.png"))); // NOI18N
        jXLabel1.setText("Tipo de Exportacion");

        cb_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tiendaActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/desde.png"))); // NOI18N
        jLabel9.setText("Seleccione Tienda");

        jXButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/reiniciar.png"))); // NOI18N
        jXButton1.setText("Reiniciar");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_tienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GenerarArchivoBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AbrirArchivoBoton_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AbrirArchivoBoton_)
                    .addComponent(cb_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jXButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenerarArchivoBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(AbrirArchivoBoton_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jXButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(GenerarArchivoBoton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jXLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cb_tienda, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jXButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addComponent(tabpanel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(busy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(archivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarCB() {
        try {
            tiendas = ObjectModelDAO.getResultQuery("from Almacen a order by a.idAlmacen asc");
        cb_tienda.removeAllItems();
        cb_tienda.addItem(cons_seleccionar);
        for (Object object : tiendas) {
            Almacen a = (Almacen) object;
            cb_tienda.addItem(a.getNombre());
        }
        pos_tienda = -1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR ComBox : "+e);
            System.err.println("ERROR AL CARGAR ComBox : "+e);
        }
       
    }

    private void AbrirArchivoBoton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirArchivoBoton_ActionPerformed
        int index = tabpanel.getSelectedIndex();

        if (filesc.getChoosableFileFilters().length > 1) {
            filesc.removeChoosableFileFilter(filesc.getChoosableFileFilters()[1]);
        }
        switch (index) {
            case 0:
                filesc.setFileFilter(new FileNameExtensionFilter("Archivos txt ", "txt"));

                break;
        }
        int returnVal = filesc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = filesc.getSelectedFile();
                archivo.setText(file.getAbsolutePath());

                switch (tabpanel.getSelectedIndex()) {
                    case 0:
                        csvReader = new CSVreader(file.getAbsolutePath());
                        lt1.setModel(csvReader.getListModel());
                        ta1.read(new FileReader(file.getAbsolutePath()), null);
                        break;

                }
            } catch (IOException ex) {
                Logger.getLogger(VisorExportSQL.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            archivo.setText("");
        }
    }//GEN-LAST:event_AbrirArchivoBoton_ActionPerformed

    private void GenerarArchivoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarArchivoBotonActionPerformed

        Thread hilo = new Thread() {

            @Override
            public void run() {
               

                try {
                    String nombreFile = JOptionPane.showInputDialog(null, "Introduc Nombre del Archivo");
                    
                    String SQL = "COPY (  SELECT E'\\r' as zx, "
                            + "  0 as a,1 as b, "
                            + "  REPLICATE(' ', 7)||inventario_tienda.id_producto AS codigo,  "
                            + "  LTRIM(replace(producto.descripcion,',',' '))  AS descr,  "
                            + "  REPLICATE(' ', 3)||producto.id_clasificacion  AS depart,   "
                            + "  round( CAST(producto.precio_original as numeric), 0) As precio, "
                            + "  1312173000 as Desde,  "
                            + "  round( CAST(inventario_tienda.precio_con_descuento as numeric), 0) As descuento, "
                            + "  13200035400 as Hasta, "
                            + "  8 as d,4 as e,0 as f,0 as g,65 as h,' ' as i, ' ' as j,  "
                            + "  0 as a1,  0 as a2, 0 as a3, 0 as a4, 0 as a5, 0 as a6, 0 as a7, 0 as a8,  "
                            + "  ' ' as b1,0 as b2, 3 as b3, 0 as c1, 0 as c2, 0 as c3, 0 as c4, 0 as c5 "
                            + "FROM  "
                            + "  public.inventario_tienda,  "
                            + "  public.producto,  "
                            + "  public.clasificacion,  "
                            + "  public.division,  "
                            + "  public.departamento "
                            + "WHERE  "
                            + "  inventario_tienda.id_producto = producto.id_producto AND "
                            + "  producto.id_clasificacion = clasificacion.id_clasificacion AND "
                            + "  clasificacion.id_departamento = departamento.id_departamento AND "
                            + "  departamento.id_division = division.id_division AND "
                            + "  inventario_tienda.precio_con_descuento>0.05 and public.division.id_division<>9 and producto.descripcion not like ' ' and "
                            + "  inventario_tienda.id_almacen = 2 "
                            //+ "  Order by producto.id_producto ) TO '"+System.getProperty("user.home", "C:\\")+"\\"+nombreFile+"' WITH DELIMITER AS ',' ";
                            + "  Order by producto.id_producto ) TO '"+ System.getProperty("user.home")+"\\Documents\\"+nombreFile+"' WITH DELIMITER AS ',' ";

                    //List l= 
                     busy.setEnabled(true);
                busy.setVisible(true);
                busy.setBusy(true);
                
                    ObjectModelDAO.executeQueryString(SQL);
//           if(l==null){
//               JOptionPane.showInputDialog("Mensaje");
//           }else{
//               JOptionPane.showInputDialog("Mensaje2");
//           }
                    busy.setEnabled(false);
                    busy.setVisible(false);
                    busy.setBusy(false);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR Asignando Mercancia :" + e);
                    System.err.println("ERROR Asignando Mercancia :" + e);
                    Logger.getLogger(VisorExportSQL.class.getName()).log(Level.SEVERE, null, e);
                }

            }
        };
        hilo.start();


    }//GEN-LAST:event_GenerarArchivoBotonActionPerformed

    private void cb_tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tiendaActionPerformed
//        if (!((String) cb_tienda.getSelectedItem()).equals(cons_seleccionar)) {
//            pos_tienda = cb_tienda.getSelectedIndex() - 1;
//        } else {
//            pos_tienda = -1;
//        }
    }//GEN-LAST:event_cb_tiendaActionPerformed

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
//        if (jTabbedPane2.getSelectedIndex() == 2) {
//            ta2.setText(csvReader.procesCSV().toString());
//        }
    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void lt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt1MouseClicked
//        if (lt1.getSelectedIndex() == -1) {
//            return;
//        }
//        codigoP.setText(csvReader.getCSVat(lt1.getSelectedIndex(), CSVreader.csv_codigoProducto));
//        tipoP.setText(csvReader.getCSVat(lt1.getSelectedIndex(), CSVreader.csv_tipoProducto));
//        precioP.setText("" + JavaUtil.prepareStrDoubleCSV(csvReader.getCSVat(lt1.getSelectedIndex(), CSVreader.csv_precioProducto)));
//        totalSi.setText("" + JavaUtil.prepareStrDoubleCSV(csvReader.getCSVat(lt1.getSelectedIndex(), CSVreader.csv_totalSinIva)));
//        totalCi.setText("" + JavaUtil.prepareStrDoubleCSV(csvReader.getCSVat(lt1.getSelectedIndex(), CSVreader.csv_totalConIva)));

        //        Producto p = ObjectModelDAO.getObject(Integer.parseInt(codigoP.getText()), Producto.class);
        //        JOptionPane.showMessageDialog(rootPane, p == null ? "No existe el producto" : p.toString());
        // System.out.println(csvReader.getListaCSV().get(lt1.getSelectedIndex()).length);
    }//GEN-LAST:event_lt1MouseClicked

    private void jXButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton2ActionPerformed

        EnviosEmail e = new EnviosEmail();
        e.setVisible(true);


    }//GEN-LAST:event_jXButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(VisorExportSQL.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisorExportSQL.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisorExportSQL.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisorExportSQL.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VisorExportSQL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbrirArchivoBoton_;
    private org.jdesktop.swingx.JXButton GenerarArchivoBoton;
    private javax.swing.JLabel archivo;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JComboBox cb_tienda;
    private javax.swing.JLabel codigoP;
    private javax.swing.JFileChooser filesc;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane2;
    private org.jdesktop.swingx.JXButton jXButton1;
    private org.jdesktop.swingx.JXButton jXButton2;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JList lt1;
    private javax.swing.JPanel panel1;
    private javax.swing.JLabel precioP;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTextArea ta2;
    private javax.swing.JTabbedPane tabpanel;
    private javax.swing.JLabel tipoP;
    private javax.swing.JLabel totalCi;
    private javax.swing.JLabel totalSi;
    // End of variables declaration//GEN-END:variables
}
