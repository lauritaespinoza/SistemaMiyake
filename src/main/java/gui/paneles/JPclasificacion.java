/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import util.JavaUtil;
import static util.JavaUtil.createJDialogGeneric;
import static util.JavaUtil.setTableCellAlignment;
import hibernate.DAO.ObjectModelDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelos.mapeos.Clasificacion;
import modelos.mapeos.Departamento;
import gui.ventanas.FventanaIncial;
import java.util.HashMap;
import java.util.Map;
import modelos.tablas.TableModelReport;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JPclasificacion extends javax.swing.JPanel {
    
    private List resultList_clasificacion;
    private List resultList_departamento;
    private int pos;
    public final String rutaJasper = "/reportes/ReporteClasificacion.jasper";
    private Integer tabCrud;
    
    public JPclasificacion() {
        this(0);
    }
    
    public JPclasificacion(Integer tabCrud) {
        this.tabCrud = tabCrud;
        initComponents();
        
        setTableCellAlignment(JLabel.CENTER,listadoClasif);
        setTableCellAlignment(JLabel.CENTER,tablaModfClasif);
        setTableCellAlignment(JLabel.CENTER,tablaDeletClasif);
        listadoClasif.getTableHeader().setReorderingAllowed(false);
        tablaModfClasif.getTableHeader().setReorderingAllowed(false);
        tablaDeletClasif.getTableHeader().setReorderingAllowed(false);
        
        
        tablaDeletClasif.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    
                    if (tablaDeletClasif.getSelectedRow() == -1) {
                        return;
                    }
                    pos = tablaDeletClasif.getSelectedRow();
                    
                }
            }
        });
        
        tablaModfClasif.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    
                    if (tablaModfClasif.getSelectedRow() == -1) {
                        return;
                    }
                    pos = tablaModfClasif.getSelectedRow();
                    Clasificacion c = (Clasificacion) resultList_clasificacion.get(pos);
                    modfNombre.setText(c.getNombre());
                    idClasificacion.setText(c.getIdClasificacion().toString());
                    cb_clasificacionModificar.setSelectedItem(c.getIdDepartamento().getNombre());
                }
            }
        ;
    }
    
    );
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelScrudClasif = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadoClasif = new org.jdesktop.swingx.JXTable();
        jLabel11 = new javax.swing.JLabel();
        bt_GenerarReporte = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nuevClasf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cb_dep = new javax.swing.JComboBox();
        b_CrearDept = new javax.swing.JButton();
        bCrear = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaCrearClasificacion = new org.jdesktop.swingx.JXTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaModfClasif = new org.jdesktop.swingx.JXTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        idClasificacion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        modfNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cb_clasificacionModificar = new javax.swing.JComboBox();
        b_CrearDept1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        bDeletClasif = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDeletClasif = new org.jdesktop.swingx.JXTable();
        jLabel13 = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(700, 403));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        panelScrudClasif.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panelScrudClasifStateChanged(evt);
            }
        });

        listadoClasif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID CLASIFICACION", "NOMBRE CLASIFICACION", "DEPARTAMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listadoClasif.setHorizontalScrollEnabled(true);
        listadoClasif.setSortable(false);
        jScrollPane1.setViewportView(listadoClasif);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1416622346_xmag.png"))); // NOI18N
        jLabel11.setText("Para realizar Busqueda: Haga Click en la tabla + CTRL F");

        bt_GenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Reporte.png"))); // NOI18N
        bt_GenerarReporte.setText("Generar Reporte");
        bt_GenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_GenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(95, 95, 95)
                .addComponent(bt_GenerarReporte)
                .addContainerGap(163, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(bt_GenerarReporte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        panelScrudClasif.addTab("Consultar", jScrollPane2);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clasificacion.png"))); // NOI18N
        jLabel1.setText("Nombre Clasificación:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/departamento.png"))); // NOI18N
        jLabel2.setText("Nombre Departamento");

        b_CrearDept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415656550_Add.png"))); // NOI18N
        b_CrearDept.setText("Crear Departamento");
        b_CrearDept.setMargin(new java.awt.Insets(2, 8, 2, 8));
        b_CrearDept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_CrearDeptActionPerformed(evt);
            }
        });

        bCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415656550_Add.png"))); // NOI18N
        bCrear.setText("Crear Clasificación");
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCrear, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(cb_dep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nuevClasf)
                    .addComponent(b_CrearDept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(nuevClasf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cb_dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(b_CrearDept)
                .addGap(43, 43, 43)
                .addComponent(bCrear)
                .addGap(37, 37, 37))
        );

        jPanel2.add(jPanel6, java.awt.BorderLayout.WEST);

        tablaCrearClasificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID CLASIFICACION", "NOMBRE CLASIFICACION", "DEPARTAMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tablaCrearClasificacion);

        jPanel2.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        jScrollPane5.setViewportView(jPanel2);

        panelScrudClasif.addTab("Crear", jScrollPane5);

        jPanel3.setLayout(new java.awt.BorderLayout());

        tablaModfClasif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID CLASIFICACION", "NOMBRE CLASIFICACION", "DEPARTAMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaModfClasif.setHorizontalScrollEnabled(true);
        tablaModfClasif.setSortable(false);
        jScrollPane4.setViewportView(tablaModfClasif);

        jPanel3.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jLabel7.setText("ID Clasificacion");

        idClasificacion.setText("ID Clasificacion");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clasificacion.png"))); // NOI18N
        jLabel5.setText("Nombre Clasificación");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/departamento.png"))); // NOI18N
        jLabel6.setText("Nombre Departamento");

        b_CrearDept1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415656550_Add.png"))); // NOI18N
        b_CrearDept1.setText("Crear Departamento");
        b_CrearDept1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_CrearDept1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415416498_Circulation.png"))); // NOI18N
        jButton1.setText("Modificar Clasificación");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idClasificacion)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(b_CrearDept1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_clasificacionModificar, javax.swing.GroupLayout.Alignment.LEADING, 0, 182, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(idClasificacion))
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(cb_clasificacionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b_CrearDept1)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(214, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.EAST);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1416622346_xmag.png"))); // NOI18N
        jLabel12.setText("Para realizar Busqueda: Haga Click en la tabla + CTRL F");
        jPanel3.add(jLabel12, java.awt.BorderLayout.PAGE_START);

        jScrollPane6.setViewportView(jPanel3);

        panelScrudClasif.addTab("Modificar", jScrollPane6);

        bDeletClasif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415657185_remove-sign-32.png"))); // NOI18N
        bDeletClasif.setText("Eliminar");
        bDeletClasif.setMargin(new java.awt.Insets(2, 6, 2, 14));
        bDeletClasif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeletClasifActionPerformed(evt);
            }
        });

        tablaDeletClasif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID CLASIFICACION", "NOMBRE CLASIFICACION", "DEPARTAMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDeletClasif.setHorizontalScrollEnabled(true);
        tablaDeletClasif.setSortable(false);
        jScrollPane3.setViewportView(tablaDeletClasif);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1416622346_xmag.png"))); // NOI18N
        jLabel13.setText("Para realizar Busqueda: Haga Click en la tabla + CTRL F");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(bDeletClasif))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(bDeletClasif)
                        .addContainerGap())
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)))
        );

        jScrollPane7.setViewportView(jPanel4);

        panelScrudClasif.addTab("Eliminar", jScrollPane7);

        panelScrudClasif.setSelectedIndex(-1);

        add(panelScrudClasif);
    }// </editor-fold>//GEN-END:initComponents

    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        if (!nuevClasf.getText().equals("")) {
            if (JOptionPane.showConfirmDialog(this, "¿Está seguro de crear "
                    + " una nueva clasificacion : " + nuevClasf.getText() + "?",
                    "Información", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                
                ObjectModelDAO.saveObject(new Clasificacion(
                        nuevClasf.getText(),
                        (Departamento) resultList_departamento.get(cb_dep.getSelectedIndex()))
                );
            String sql = "FROM Clasificacion c order by c.idClasificacion asc";
            resultList_clasificacion = ObjectModelDAO.getResultQuery(sql);
            JavaUtil.displayResult(resultList_clasificacion, tablaCrearClasificacion);
            tablaCrearClasificacion.setEditable(false);
            tablaCrearClasificacion.setRowSelectionInterval(resultList_clasificacion.size()-1, resultList_clasificacion.size()-1);
            }
        }
    }//GEN-LAST:event_bCrearActionPerformed

    private void b_CrearDeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_CrearDeptActionPerformed
//        JDialog dialogo = new JDialog();
//        dialogo.getContentPane().setLayout(new BorderLayout());
//        dialogo.getContentPane().add(new JScrollPane(new JPdepartamento(1)), BorderLayout.CENTER);
//        dialogo.pack();
//        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//        Point p
//                = new Point(
//                        (int) ((d.getWidth() - dialogo.getWidth()) / 2),
//                        (int) ((d.getHeight() - dialogo.getHeight()) / 2));
//        dialogo.setLocation(p);
//        dialogo.setModal(true);
//        dialogo.setVisible(true);
        
        createJDialogGeneric(new JPdepartamento(1));
         resultList_departamento = ObjectModelDAO.getResultQuery("FROM Departamento d order by d.idDepartamento asc");
            cb_dep.removeAllItems();
            for (Object object : resultList_departamento) {
                Departamento d = (Departamento) object;
                cb_dep.addItem(d.getNombre());
            }
    }//GEN-LAST:event_b_CrearDeptActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (pos == -1 || modfNombre.getText().equals("")) {
            return;
        }
        
        String valor = tablaModfClasif.getValueAt(tablaModfClasif.getSelectedRow(), 1).toString();//1 por el nombre
        if (JOptionPane.showConfirmDialog(null, "¿Está seguro de modificar el"
                + " Departamento " + valor + "?", "Información", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            
            int posOr = this.pos;
            Clasificacion c = (Clasificacion) resultList_clasificacion.get(posOr);
            c.setNombre(modfNombre.getText());
            c.setIdDepartamento((Departamento) resultList_departamento.get(cb_clasificacionModificar.getSelectedIndex()));
            ObjectModelDAO.updateObject(c);
            
            resultList_departamento = ObjectModelDAO.getResultQuery("FROM Departamento d order by d.idDepartamento asc");
            cb_clasificacionModificar.removeAllItems();
            for (Object object : resultList_departamento) {
                Departamento d = (Departamento) object;
                cb_clasificacionModificar.addItem(d.getNombre());
            }
            String sql = "FROM Clasificacion c order by c.idClasificacion asc";
            resultList_clasificacion = ObjectModelDAO.getResultQuery(sql);
            JavaUtil.displayResult(resultList_clasificacion, tablaModfClasif);
            tablaModfClasif.setEditable(false);
            tablaModfClasif.setRowSelectionInterval(posOr, posOr);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void b_CrearDept1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_CrearDept1ActionPerformed
         createJDialogGeneric(new JPdepartamento(1));
    }//GEN-LAST:event_b_CrearDept1ActionPerformed

    private void bDeletClasifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletClasifActionPerformed
        if (pos == -1) {
            return;
        }
        
        String valor = tablaDeletClasif.getValueAt(tablaDeletClasif.getSelectedRow(), tablaDeletClasif.getSelectedColumn()).toString();
        if (JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la"
                + " Clasificación " + valor + "?", "Información", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            
            ObjectModelDAO.deleteObject(resultList_clasificacion.get(pos));
            String sql = "FROM Clasificacion c order by c.idClasificacion asc";
            resultList_clasificacion = ObjectModelDAO.getResultQuery(sql);
            JavaUtil.displayResult(resultList_clasificacion, tablaDeletClasif);
            pos = -1;
            tablaDeletClasif.setEditable(false);
        }
    }//GEN-LAST:event_bDeletClasifActionPerformed

    private void panelScrudClasifStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panelScrudClasifStateChanged
         if (panelScrudClasif.getTabCount() != 4) {
            return;
        }

        //verifica si debe abrir un panel desde la llamada
        if (this.tabCrud != null) {
            int tabCrud = this.tabCrud.intValue();
            this.tabCrud = null;
            panelScrudClasif.setSelectedIndex(tabCrud);
            return;
        }       
        
        if (panelScrudClasif.getSelectedIndex() == 0) {
            String sql = "FROM Clasificacion c order by c.idClasificacion asc";
            List resultList = ObjectModelDAO.getResultQuery(sql);            
            JavaUtil.displayResult(resultList, listadoClasif);
            listadoClasif.setEditable(false);
        }
        if (panelScrudClasif.getSelectedIndex() == 1) {
            nuevClasf.setText("");
            resultList_departamento = ObjectModelDAO.getResultQuery("FROM Departamento d order by d.idDepartamento asc");
            cb_dep.removeAllItems();
            for (Object object : resultList_departamento) {
                Departamento d = (Departamento) object;
                cb_dep.addItem(d.getNombre());
            }
            String sql = "FROM Clasificacion c order by c.idClasificacion asc";
            resultList_clasificacion = ObjectModelDAO.getResultQuery(sql);
            JavaUtil.displayResult(resultList_clasificacion, tablaCrearClasificacion);
            tablaCrearClasificacion.setEditable(false);
            
        }
        if (panelScrudClasif.getSelectedIndex() == 2) {
            idClasificacion.setText("");
            modfNombre.setText("");
            resultList_departamento = ObjectModelDAO.getResultQuery("FROM Departamento d order by d.idDepartamento asc");
            cb_clasificacionModificar.removeAllItems();
            for (Object object : resultList_departamento) {
                Departamento d = (Departamento) object;
                cb_clasificacionModificar.addItem(d.getNombre());
            }
            String sql = "FROM Clasificacion c order by c.idClasificacion asc";
            resultList_clasificacion = ObjectModelDAO.getResultQuery(sql);
            JavaUtil.displayResult(resultList_clasificacion, tablaModfClasif);
            tablaModfClasif.setEditable(false);
            pos = -1;
            cb_clasificacionModificar.setSelectedIndex(pos);
            
        }
        
        if (panelScrudClasif.getSelectedIndex() == 3) {
            String sql = "FROM Clasificacion c order by c.idClasificacion asc";
            resultList_clasificacion = ObjectModelDAO.getResultQuery(sql);
            
            JavaUtil.displayResult(resultList_clasificacion, tablaDeletClasif);
            pos = -1;
            tablaDeletClasif.setEditable(false);
        }
    }//GEN-LAST:event_panelScrudClasifStateChanged

    private void generarReporte() {
        try {
            JasperPrint jasperPrint = null;
            Map<String, Object> parametro = new HashMap<>();

            TableModelReport dataSourse = new TableModelReport(listadoClasif.getModel());
          
            parametro.put("REPORT_DATA_SOURSE", dataSourse);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream(rutaJasper));
            jasperPrint = JasperFillManager.fillReport(reporte, parametro, dataSourse);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setTitle("Reporte de Clasificación de Producto");
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error" + e);
        }
    }
    
    private void bt_GenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_GenerarReporteActionPerformed
      generarReporte(); 
    }//GEN-LAST:event_bt_GenerarReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCrear;
    private javax.swing.JButton bDeletClasif;
    private javax.swing.JButton b_CrearDept;
    private javax.swing.JButton b_CrearDept1;
    private javax.swing.JButton bt_GenerarReporte;
    private javax.swing.JComboBox cb_clasificacionModificar;
    private javax.swing.JComboBox cb_dep;
    private javax.swing.JLabel idClasificacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private org.jdesktop.swingx.JXTable listadoClasif;
    private javax.swing.JTextField modfNombre;
    private javax.swing.JTextField nuevClasf;
    private javax.swing.JTabbedPane panelScrudClasif;
    private org.jdesktop.swingx.JXTable tablaCrearClasificacion;
    private org.jdesktop.swingx.JXTable tablaDeletClasif;
    private org.jdesktop.swingx.JXTable tablaModfClasif;
    // End of variables declaration//GEN-END:variables
}
