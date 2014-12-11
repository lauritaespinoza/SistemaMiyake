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
import modelos.mapeos.Marca;
import modelos.tablas.TableModelReport;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class JPmarca extends javax.swing.JPanel {

    private List resultList;
    private int pos;
    public final String rutaJasper = "/reportes/ReporteMarca.jasper";
    private Integer tabCrud;
    
    
    public JPmarca() {
        this(0);
    }
    
    public JPmarca(Integer tabCrud) {
        this.tabCrud = tabCrud;
        initComponents();
        
        setTableCellAlignment(JLabel.CENTER,tablaConsultaMarca);
        setTableCellAlignment(JLabel.CENTER,tablaModifMarca);
        setTableCellAlignment(JLabel.CENTER,tablaDeletMarca);
        tablaConsultaMarca.getTableHeader().setReorderingAllowed(false);
        tablaModifMarca.getTableHeader().setReorderingAllowed(false);
        tablaDeletMarca.getTableHeader().setReorderingAllowed(false);
        
        tablaModifMarca.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    
                    pos = tablaModifMarca.getSelectedRow();
                    if (pos == -1) {
                        return;
                    }
                    Marca m = (Marca) resultList.get(pos);
                    nomb_a_Modf.setText(m.getNombre());
                    idMarca.setText(m.getIdMarca().toString());
                    
                }
            }
        });
        
        tablaDeletMarca.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    
                    if (tablaDeletMarca.getSelectedRow() == -1) {
                        return;
                    }
                    pos = tablaDeletMarca.getSelectedRow();
                    
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

        panelScrudMarca = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultaMarca = new org.jdesktop.swingx.JXTable();
        jLabel15 = new javax.swing.JLabel();
        bt_GenerarReporte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nuevMark = new javax.swing.JTextField();
        bCrear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaModifMarca = new org.jdesktop.swingx.JXTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        idMarca = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomb_a_Modf = new javax.swing.JTextField();
        bModfmark = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDeletMarca = new org.jdesktop.swingx.JXTable();
        deletMark = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        panelScrudMarca.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panelScrudMarcaStateChanged(evt);
            }
        });

        tablaConsultaMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Marca", "Nombre Marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaConsultaMarca);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1416622346_xmag.png"))); // NOI18N
        jLabel15.setText("Para realizar Busqueda: Haga Click en la tabla + CTRL F");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(bt_GenerarReporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(bt_GenerarReporte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelScrudMarca.addTab("Consultar", jPanel1);

        jLabel1.setText("Nombre Marca:");

        bCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415656550_Add.png"))); // NOI18N
        bCrear.setText("Crear Marca");
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addComponent(nuevMark, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(bCrear)))
                .addContainerGap(379, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nuevMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(59, 59, 59)
                .addComponent(bCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        panelScrudMarca.addTab("Crear", jPanel2);

        tablaModifMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Marca", "Nombre Marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaModifMarca);

        jLabel3.setText("ID Marca:");

        jLabel2.setText("Nombre Marca");

        bModfmark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415656862_Circulation.png"))); // NOI18N
        bModfmark.setText("Modificar Marca");
        bModfmark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModfmarkActionPerformed(evt);
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
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomb_a_Modf))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bModfmark))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomb_a_Modf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(bModfmark)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1416622346_xmag.png"))); // NOI18N
        jLabel17.setText("Para realizar Busqueda: Haga Click en la tabla + CTRL F");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelScrudMarca.addTab("Modificar", jPanel3);

        tablaDeletMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Marca", "Nombre Marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaDeletMarca);

        deletMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1415657185_remove-sign-32.png"))); // NOI18N
        deletMark.setText("Eliminar");
        deletMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletMarkActionPerformed(evt);
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
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(244, 244, 244)))
                .addGap(18, 18, 18)
                .addComponent(deletMark)
                .addGap(2, 2, 2))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(deletMark)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelScrudMarca.addTab("Eliminar", jPanel4);

        panelScrudMarca.setSelectedIndex(-1);

        add(panelScrudMarca);
    }// </editor-fold>//GEN-END:initComponents

    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        if (!nuevMark.getText().equals("")) {
            if (JOptionPane.showConfirmDialog(this, "¿Está seguro de crear la"
                + " nueva marca con nombre : " + nuevMark.getText() + "?",
                "Información", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            ObjectModelDAO.saveObject(new Marca(nuevMark.getText()));

        }
        }
    }//GEN-LAST:event_bCrearActionPerformed

    private void bModfmarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModfmarkActionPerformed
        if (pos == -1 || nomb_a_Modf.getText().equals("")) {
            return;
        }

        String valor = tablaModifMarca.getValueAt(tablaModifMarca.getSelectedRow(), 1).toString();//1 por el nombre
        if (JOptionPane.showConfirmDialog(null, "¿Está seguro de modificar la"
            + " Marca " + valor + "?", "Información", JOptionPane.YES_NO_OPTION)
        == JOptionPane.YES_OPTION) {

        int posOr = this.pos;
        Marca m = (Marca) resultList.get(posOr);
        m.setNombre(nomb_a_Modf.getText());
        ObjectModelDAO.updateObject(m);

        String sql = "FROM Marca m order by m.idMarca asc";
        resultList = ObjectModelDAO.getResultQuery(sql);
        JavaUtil.displayResult(resultList, tablaModifMarca);
        tablaModifMarca.setEditable(false);
        tablaModifMarca.setRowSelectionInterval(posOr, posOr);
        }
    }//GEN-LAST:event_bModfmarkActionPerformed

    private void deletMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletMarkActionPerformed
        if (pos == -1) {
            return;
        }

        String valor = tablaDeletMarca.getValueAt(tablaDeletMarca.getSelectedRow(), 1).toString();//1 por el nombre
        if (JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la"
            + " Division " + valor + "?", "Información", JOptionPane.YES_NO_OPTION)
        == JOptionPane.YES_OPTION) {

        ObjectModelDAO.deleteObject(resultList.get(pos));

        String sql = "FROM Marca m order by m.idMarca asc";
        resultList = ObjectModelDAO.getResultQuery(sql);
        JavaUtil.displayResult(resultList, tablaDeletMarca);

        }
    }//GEN-LAST:event_deletMarkActionPerformed

    private void panelScrudMarcaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panelScrudMarcaStateChanged

         if (panelScrudMarca.getTabCount() != 4) {
            return;
        }

        //verifica si debe abrir un panel desde la llamada
        if (this.tabCrud != null) {
            int tabCrud=this.tabCrud.intValue();
            this.tabCrud = null;
            panelScrudMarca.setSelectedIndex(tabCrud);
            return;
        }
        
        
        if (panelScrudMarca.getSelectedIndex() == 0) {
            String sql = "FROM Marca m order by m.idMarca asc";
            List resultList = ObjectModelDAO.getResultQuery(sql);

            JavaUtil.displayResult(resultList, tablaConsultaMarca);
            tablaConsultaMarca.setEditable(false);
        }

        if (panelScrudMarca.getSelectedIndex() == 1) {
            nuevMark.setText("");
        }

        if (panelScrudMarca.getSelectedIndex() == 2) {
            nomb_a_Modf.setText("");
            idMarca.setText("");
            String sql = "FROM Marca m order by m.idMarca asc";
            resultList = ObjectModelDAO.getResultQuery(sql);
            JavaUtil.displayResult(resultList, tablaModifMarca);
            pos = -1;
            tablaModifMarca.setEditable(false);
        }

        if (panelScrudMarca.getSelectedIndex() == 3) {
            String sql = "FROM Marca m order by m.idMarca asc";
            resultList = ObjectModelDAO.getResultQuery(sql);

            JavaUtil.displayResult(resultList, tablaDeletMarca);
            pos = -1;
            tablaDeletMarca.setEditable(false);
        }
    }//GEN-LAST:event_panelScrudMarcaStateChanged
private void generarReporte() {
        try {
            JasperPrint jasperPrint = null;
            Map<String, Object> parametro = new HashMap<>();

            TableModelReport dataSourse = new TableModelReport(tablaConsultaMarca.getModel());
          
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
    private javax.swing.JButton bModfmark;
    private javax.swing.JButton bt_GenerarReporte;
    private javax.swing.JButton deletMark;
    private javax.swing.JLabel idMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nomb_a_Modf;
    private javax.swing.JTextField nuevMark;
    private javax.swing.JTabbedPane panelScrudMarca;
    private org.jdesktop.swingx.JXTable tablaConsultaMarca;
    private org.jdesktop.swingx.JXTable tablaDeletMarca;
    private org.jdesktop.swingx.JXTable tablaModifMarca;
    // End of variables declaration//GEN-END:variables
}
