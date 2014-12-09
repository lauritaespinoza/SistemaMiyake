/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import util.JavaUtil;
import static util.JavaUtil.setTableCellAlignment;
import hibernate.DAO.ObjectModelDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelos.mapeos.Division;
import modelos.tablas.TableModelReport;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JPdivision extends javax.swing.JPanel {

    private List resultList;
    private int pos;
    public final String rutaJasper = "/reportes/ReporteDivision.jasper";

    public JPdivision() {
        this(0);
    }
    
    public void posicionar(int tabCrud){
        panelScrudDiv.setSelectedIndex(tabCrud);
    }

    public JPdivision(int tabCrud) {
        initComponents();

        setTableCellAlignment(JLabel.CENTER, tablaConsultaDivision);
        setTableCellAlignment(JLabel.CENTER, tablaModificarDivision);
        setTableCellAlignment(JLabel.CENTER, tablaEliminarDivision);
        tablaConsultaDivision.getTableHeader().setReorderingAllowed(false);
        tablaModificarDivision.getTableHeader().setReorderingAllowed(false);
        tablaEliminarDivision.getTableHeader().setReorderingAllowed(false);

        panelScrudDiv.setSelectedIndex(tabCrud);

        tablaModificarDivision.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {

                    pos = tablaModificarDivision.getSelectedRow();
                    if (pos == -1) {
                        return;
                    }
                    Division d = (Division) resultList.get(pos);
                    lb_numero.setText(d.getIdDivision().toString());
                    tf_nombre1.setText(d.getNombre());

                }
            }
        });

        tablaEliminarDivision.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {

                    if (tablaEliminarDivision.getSelectedRow() == -1) {
                        return;
                    }
                    pos = tablaEliminarDivision.getSelectedRow();

                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelScrudDiv = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultaDivision = new org.jdesktop.swingx.JXTable();
        jLabel15 = new javax.swing.JLabel();
        bt_GenerarReporte = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaModificarDivision = new org.jdesktop.swingx.JXTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lb_numero = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_nombre1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEliminarDivision = new org.jdesktop.swingx.JXTable();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        panelScrudDiv.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panelScrudDivStateChanged(evt);
            }
        });

        tablaConsultaDivision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID División", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaConsultaDivision);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1416622346_xmag.png"))); // NOI18N
        jLabel15.setText("Para realizar Busqueda: Haga Click en la tabla + CTRL F");

        bt_GenerarReporte.setText("Generar Reporte");
        bt_GenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_GenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(42, 42, 42)
                .addComponent(bt_GenerarReporte)
                .addContainerGap(146, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(bt_GenerarReporte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        jScrollPane4.setViewportView(jPanel2);

        panelScrudDiv.addTab("Consultar", jScrollPane4);

        jLabel3.setText("Nombre de Division :");

        tf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombreActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415656550_Add.png"))); // NOI18N
        jButton1.setText("Crear División");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jButton1)))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel1);

        panelScrudDiv.addTab("Crear", jScrollPane5);

        jPanel3.setLayout(new java.awt.BorderLayout());

        tablaModificarDivision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID División", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaModificarDivision.setEditable(false);
        tablaModificarDivision.setHorizontalScrollEnabled(true);
        jScrollPane2.setViewportView(tablaModificarDivision);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jLabel5.setText("Número:");

        lb_numero.setText("numero");

        jLabel4.setText("Nombre:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415416498_Circulation.png"))); // NOI18N
        jButton2.setText("Modificar División");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lb_numero))
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tf_nombre1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(8, 8, 8))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lb_numero))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton2)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.EAST);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1416622346_xmag.png"))); // NOI18N
        jLabel17.setText("Para realizar Busqueda: Haga Click en la tabla + CTRL F");
        jPanel3.add(jLabel17, java.awt.BorderLayout.PAGE_START);

        jScrollPane6.setViewportView(jPanel3);

        panelScrudDiv.addTab("Modificar", jScrollPane6);

        tablaEliminarDivision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID División", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEliminarDivision.setHorizontalScrollEnabled(true);
        jScrollPane3.setViewportView(tablaEliminarDivision);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415657185_remove-sign-32.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1416622346_xmag.png"))); // NOI18N
        jLabel16.setText("Para realizar Busqueda: Haga Click en la tabla + CTRL F");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton3)
                .addContainerGap(341, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel4);

        panelScrudDiv.addTab("Eliminar", jScrollPane7);

        add(panelScrudDiv);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!tf_nombre.getText().equals("")) {
            if (JOptionPane.showConfirmDialog(this, "¿Está seguro de crear la"
                    + " nueva división con nombre : " + tf_nombre.getText() + "?",
                    "Información", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                ObjectModelDAO.saveObject(new Division(tf_nombre.getText()));

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (pos == -1 || tf_nombre1.getText().equals("")) {
            return;
        }

        String valor = tablaModificarDivision.getValueAt(tablaModificarDivision.getSelectedRow(), 1).toString();//1 por el nombre
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro de modificar la"
                + " división " + valor + "?",
                "Información", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            try {
                int pos = this.pos;
                Division d = (Division) resultList.get(pos);
                d.setNombre(tf_nombre1.getText());
                ObjectModelDAO.updateObject(d);

                String sql = "FROM Division d order by d.idDivision asc";
                resultList = ObjectModelDAO.getResultQuery(sql);
                JavaUtil.displayResult(resultList, tablaModificarDivision);
                tablaModificarDivision.setEditable(false);
                tablaModificarDivision.setRowSelectionInterval(pos, pos);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Mensaje:\n\t" + e.getMessage(),
                        "Error Update",
                        JOptionPane.ERROR_MESSAGE
                );
                Logger.getLogger(JPdivision.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (pos == -1) {
            return;
        }

        String valor = tablaEliminarDivision.getValueAt(tablaEliminarDivision.
                getSelectedRow(), 1).toString();//1 por el nombre
        if (JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la"
                + " Division " + valor + "?", "Información", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {

            ObjectModelDAO.deleteObject(resultList.get(pos));
            String sql = "FROM Division d order by d.idDivision asc";
            resultList = ObjectModelDAO.getResultQuery(sql);
            JavaUtil.displayResult(resultList, tablaEliminarDivision);
            pos = -1;
            tablaEliminarDivision.setEditable(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void panelScrudDivStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panelScrudDivStateChanged

        if (panelScrudDiv.getSelectedIndex() == 0) {
            String sql = "FROM Division d order by d.idDivision asc";
            List resultList = ObjectModelDAO.getResultQuery(sql);

            JavaUtil.displayResult(resultList, tablaConsultaDivision);
            tablaConsultaDivision.setEditable(false);
        }

        if (panelScrudDiv.getSelectedIndex() == 1) {
            tf_nombre.setText("");
        }

        if (panelScrudDiv.getSelectedIndex() == 2) {
            tf_nombre1.setText("");
            lb_numero.setText("");
            String sql = "FROM Division d order by d.idDivision asc";
            resultList = ObjectModelDAO.getResultQuery(sql);
            JavaUtil.displayResult(resultList, tablaModificarDivision);
            pos = -1;
            tablaModificarDivision.setEditable(false);

        }

        if (panelScrudDiv.getSelectedIndex() == 3) {
            String sql = "FROM Division d order by d.idDivision asc";
            resultList = ObjectModelDAO.getResultQuery(sql);

            JavaUtil.displayResult(resultList, tablaEliminarDivision);
            pos = -1;
            tablaEliminarDivision.setEditable(false);
        }
    }//GEN-LAST:event_panelScrudDivStateChanged

    private void generarReporte() {
        try {
            JasperPrint jasperPrint = null;
            Map<String, Object> parametro = new HashMap<>();

            TableModelReport dataSourse = new TableModelReport(tablaConsultaDivision.getModel());

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
    private javax.swing.JButton bt_GenerarReporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lb_numero;
    private javax.swing.JTabbedPane panelScrudDiv;
    private org.jdesktop.swingx.JXTable tablaConsultaDivision;
    private org.jdesktop.swingx.JXTable tablaEliminarDivision;
    private org.jdesktop.swingx.JXTable tablaModificarDivision;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_nombre1;
    // End of variables declaration//GEN-END:variables
}
