/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ventanas;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import hibernate.DAO.DaoQuery;
import util.JavaUtil;
import modelos.tablas.TableModelReport;
import hibernate.DAO.ObjectModelDAO;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.mapeos.Producto;
import modelos.mapeos.SalidaParaTienda;
import modelos.mapeos.SalidaParaTiendaDetalle;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

public class Fsalida_p_tienda extends javax.swing.JFrame {

    private List resultListProductoSalida;//detalle
    private boolean revisado = false;
    private int pos;
    private SalidaParaTienda cabecera = null;
    DefaultTableModel tableModel;
    private Object model;
    private String ruta;
    public static final String rutaJasper = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\modulofacturacion2\\src\\main\\java\\reportes\\ReporteMercanciaAsignada.jasper";
    public static final String rutaJrxml = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\modulofacturacion2\\src\\main\\java\\reportes\\ReporteMercanciaAsignada.jrxml";

    public Fsalida_p_tienda() {
        initComponents();
        setCB();
        checkboxRevisado.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCabezera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldfecha = new javax.swing.JTextField();
        fieldtipo = new javax.swing.JTextField();
        cb_Salidas = new javax.swing.JComboBox();
        fieldAyudante = new javax.swing.JTextField();
        fieldPersonalDep = new javax.swing.JTextField();
        fieldTienda = new javax.swing.JTextField();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadoMercancia = new org.jdesktop.swingx.JXTable();
        paneFinal = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        fieldTotal = new javax.swing.JTextField();
        bGenerarReporte = new javax.swing.JButton();
        bImprimirEtiquetas = new javax.swing.JButton();
        fieldnumFact = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        checkboxRevisado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mercancía Asignada a Tienda");

        jLabel2.setText("Fecha:");

        jLabel3.setText("Tienda:");

        jLabel4.setText("Facturadora:");

        jLabel5.setText("Tipo de Mercancía:");

        jLabel6.setText("Ayudante de Facturadora:");

        fieldfecha.setEditable(false);

        fieldtipo.setEditable(false);

        cb_Salidas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_SalidasItemStateChanged(evt);
            }
        });
        cb_Salidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_SalidasActionPerformed(evt);
            }
        });

        fieldAyudante.setEditable(false);

        fieldPersonalDep.setEditable(false);

        fieldTienda.setEditable(false);

        javax.swing.GroupLayout panelCabezeraLayout = new javax.swing.GroupLayout(panelCabezera);
        panelCabezera.setLayout(panelCabezeraLayout);
        panelCabezeraLayout.setHorizontalGroup(
            panelCabezeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabezeraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabezeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCabezeraLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_Salidas, 0, 255, Short.MAX_VALUE))
                    .addGroup(panelCabezeraLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldtipo))
                    .addGroup(panelCabezeraLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldfecha))
                    .addGroup(panelCabezeraLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldTienda))
                    .addGroup(panelCabezeraLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldPersonalDep))
                    .addGroup(panelCabezeraLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldAyudante)))
                .addContainerGap())
        );
        panelCabezeraLayout.setVerticalGroup(
            panelCabezeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabezeraLayout.createSequentialGroup()
                .addGroup(panelCabezeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_Salidas, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCabezeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelCabezeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCabezeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldPersonalDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCabezeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldAyudante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCabezeraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        listadoMercancia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Referencia", "Descripción", "Cantidad", "Precio", "Bulto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listadoMercancia);
        if (listadoMercancia.getColumnModel().getColumnCount() > 0) {
            listadoMercancia.getColumnModel().getColumn(2).setPreferredWidth(180);
            listadoMercancia.getColumnModel().getColumn(3).setPreferredWidth(50);
            listadoMercancia.getColumnModel().getColumn(5).setPreferredWidth(25);
        }

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
        );

        jLabel10.setText("Total:");

        fieldTotal.setEditable(false);

        bGenerarReporte.setText("Generar Reporte");
        bGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarReporteActionPerformed(evt);
            }
        });

        bImprimirEtiquetas.setText("Imprimir Etiquetas");
        bImprimirEtiquetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bImprimirEtiquetasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneFinalLayout = new javax.swing.GroupLayout(paneFinal);
        paneFinal.setLayout(paneFinalLayout);
        paneFinalLayout.setHorizontalGroup(
            paneFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneFinalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bImprimirEtiquetas)
                .addGap(78, 78, 78)
                .addGroup(paneFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneFinalLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(37, 37, 37)
                        .addComponent(fieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneFinalLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(bGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        paneFinalLayout.setVerticalGroup(
            paneFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFinalLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(paneFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(paneFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bImprimirEtiquetas, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(bGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        fieldnumFact.setEditable(false);

        jLabel7.setText("N°");

        checkboxRevisado.setText("Revisado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCabezera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldnumFact, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxRevisado)))
            .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(paneFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCabezera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldnumFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addComponent(checkboxRevisado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setCB() {
        String hql = "FROM SalidaParaTienda s WHERE s.revisado =:revisado order by s.idSalida asc";
        DaoQuery q = ObjectModelDAO.createQueryDAO(hql);
        q.getQuery().setParameter("revisado", false);
        List resultList_sw = ObjectModelDAO.getResultQuery(q);

        cb_Salidas.removeAllItems();
        for (Object object : resultList_sw) {
            SalidaParaTienda c = (SalidaParaTienda) object;
            cb_Salidas.addItem(c.getIdSalida());
        }
    }

    private void TableModelData() {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Codigo");
        columnNames.add("Referencia");
        columnNames.add("Descripcion");
        columnNames.add("Cantidad");
        columnNames.add("Precio");
        columnNames.add("Bulto");

        Vector<Object> data = new Vector<>();
        for (int i = 0; i < 100; i++) {
            Vector<Object> subdata = new Vector<>();
            for (int j = 0; j < 6; j++) {
                if (j == 2) {
                    subdata.add("fgdretttttetrrrrrrrrrrrrrrrrrrerererererererererererererertygfhfd");
                } else {
                    if (j == 4) {
                        subdata.add((float) i * 400);
                    } else {
                        subdata.add(i * 850);
                    }
                }

            }
            data.add(subdata);
        }

        tableModel = new DefaultTableModel(data, columnNames);
    }

    private void generarReporte() {
        try {
            JasperPrint jasperPrint = null;
            JasperPrint jasperPrint2 = null;
            TableModelData();
            Map<String, Object> parametro = new HashMap<>();
            Map hm = new HashMap();
            //listadoMercancia.setModel(tableModel);
            String s = "";
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                s += tableModel.getColumnName(i) + "\t" + Integer.valueOf(i) + "\n";
            }

            //JOptionPane.showMessageDialog(null, s); //listadoMercancia.getModel()
            TableModelReport dataSourse = new TableModelReport(tableModel);
            // dataSourse.next();

            parametro.put("Fecha", fieldfecha.getText());
            parametro.put("Tienda", fieldTienda.getText());
            parametro.put("Facturadora", fieldPersonalDep.getText());
            parametro.put("Ayudante", fieldAyudante.getText());
            parametro.put("Salida", cb_Salidas.getSelectedItem().toString());
            //parametro.put("codigobarras", "200003");
            parametro.put("REPORT_DATA_SOURSE", dataSourse);
            //parametro.put("TableDataSource", dataSourse);
           
            JasperCompileManager.compileReportToFile(rutaJrxml, rutaJasper);
            jasperPrint = JasperFillManager.fillReport(rutaJasper, parametro, dataSourse);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setTitle("Reporte de Salida de Mercancía");
            jasperViewer.setVisible(true);

//            jasperPrint = JasperFillManager.fillReport(
//                    rutaJasper, parametro, new JREmptyDataSource());
//            Map<String, Object> paramsMM = new HashMap<String, Object>();
            //listadoMercancia.setModel(tableModel);
//            String s = "";
//            for (int i = 0; i < listadoMercancia.getModel().getColumnCount(); i++) {
//                s += listadoMercancia.getTableHeader().getColumnModel().getColumn(i).getHeaderValue() + "\n";
//            }
//            JOptionPane.showMessageDialog(null, s);
//
////            paramsMM.put("TableDataSource", new JREmptyDataSource(10));
//            paramsMM.put("TableDataSource", dataSourse);
//            String rutax = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\"
//                    + "modulofacturacion2\\src\\main\\java\\reportes\\REPORTEFACTURA.jrxml";
//            String rutaj = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\"
//                    + "modulofacturacion2\\src\\main\\java\\reportes\\table\\reports\\REPORTEFACTURA.jasper";
//
//            JasperCompileManager.compileReportToFile(rutax, rutaj);
//            jasperPrint2 = JasperFillManager.fillReport(
//                    rutaJasper, parametro, dataSourse);
//            jasperPrint2 = JasperFillManager.fillReport(
//                    "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\modulofacturacion2\\src\\main\\java\\reportes\\REPORTEFACTURA.jasper", new HashMap(),
//                    new JRTableModelDataSource(tableModel));
            //  JasperViewer.viewReport(jasperPrint2);
            /*TableModel model = new TableModelImp(); // TableModel implementation here
             JTable table = new JTable(model);    
             ...
             Map params = new HashMap();
             ...
             JRDataSource dataSource = new JRTableModelDataSource(table.getModel());
             JasperPrint print = JasperFillManager.fillReport("pathToYourReport.jasper", params, dataSource);
             JasperViewer.viewReport(print, true);*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error" + e);
        }
    }

    public void fill() throws JRException {
        long start = System.currentTimeMillis();
        String rutaJasper = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\modulofacturacion2\\src\\main\\java\\reportes\\Barcode4JReport.jasper";
        String rutaJrxml = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\modulofacturacion2\\src\\main\\java\\reportes\\Barcode4JReport.jrxml";
        JasperCompileManager.compileReportToFile(rutaJrxml, rutaJasper);
        JasperPrint jasperPrint = JasperFillManager.fillReport(rutaJasper, null, new JREmptyDataSource());
        JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
        jasperViewer.setTitle("jwjejeje1");
        jasperViewer.setVisible(true);
        System.err.println("Filling time : " + (System.currentTimeMillis() - start));
    }

    private void bGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerarReporteActionPerformed

//        if (checkboxRevisado.isSelected()) {
//
//            if (JOptionPane.showConfirmDialog(rootPane, "¿Esta Seguro que desea marcar como revisado este Formulario de Mercancía Asignada a Tienda?", "Información", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                cabecera.setRevisado(true);
//                ObjectModelDAO.updateObject(cabecera);
//                // cb_Salidas.removeItemAt (cb_Salidas.getSelectedIndex());
//                // sw = true;
//                // pos = cb_Salidas.getSelectedIndex();
//                generarReporte();
//                setCB();
//            } else {
//                checkboxRevisado.setSelected(false);
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Deben Marcar que ha revisado este Formulario de Mercancía Asignada a Tienda");
//        }
        generarReporte();
    }//GEN-LAST:event_bGenerarReporteActionPerformed

    private void cb_SalidasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_SalidasItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {

            String sql = "";

            cabecera = ObjectModelDAO.getObject((Integer) cb_Salidas.getSelectedItem(), SalidaParaTienda.class);
            sql = "FROM SalidaParaTiendaDetalle s WHERE s.salidaParaTiendaDetallePK.idSalida = "
                    + cb_Salidas.getSelectedItem();
            resultListProductoSalida = ObjectModelDAO.getResultQuery(sql);

            if (resultListProductoSalida.isEmpty()) {
                return;
            }

            //SalidaParaTienda cabecera = ((SalidaParaTiendaDetalle) resultListProductoSalida.get(0)).getSalidaParaTienda();
            if (cabecera.getFechaAsignacion()!= null) {
                fieldfecha.setText(cabecera.getFechaAsignacion().toString());
            } else {
                fieldfecha.setText("");
            }
            if (cabecera.getIdAlmacenHasta()!= null) {
                fieldTienda.setText(cabecera.getIdAlmacenHasta().getDescripcion());
            } else {
                fieldTienda.setText("");
            }
            if (cabecera.getIdUsuario1() != null) {
                fieldPersonalDep.setText(cabecera.getIdUsuario1().getNombre());
            } else {
                fieldPersonalDep.setText("");
            }
            if (cabecera.getIdUsuario2() != null) {
                fieldAyudante.setText(cabecera.getIdUsuario2().getNombre());
            } else {
                fieldAyudante.setText("");
            }            
            if (cabecera.getTotal() != null) {
                fieldTotal.setText(cabecera.getTotal() + "");
            } else {
                fieldTotal.setText("");
            }

            JavaUtil.displayResult(resultListProductoSalida, listadoMercancia);
            listadoMercancia.setEditable(false);
            checkboxRevisado.setSelected(false);
            pos = cb_Salidas.getSelectedIndex();
        }
    }//GEN-LAST:event_cb_SalidasItemStateChanged

    private void cb_SalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_SalidasActionPerformed
//       cb_Salidas.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//
//                    String sql = "";
//
//                    cabecera = ObjectModelDAO.getObject((Integer) cb_Salidas.getSelectedItem(), SalidaParaTienda.class);
//                    sql = "FROM SalidaParaTiendaDetalle s WHERE s.salidaParaTiendaDetallePK.idSalida = "
//                            + cb_Salidas.getSelectedItem();
//                    resultListProductoSalida = ObjectModelDAO.getResultQuery(sql);
//
//                    if (resultListProductoSalida.isEmpty()) {
//                        return;
//                    }
//
//                    //SalidaParaTienda cabecera = ((SalidaParaTiendaDetalle) resultListProductoSalida.get(0)).getSalidaParaTienda();
//                    if (cabecera.getFecha() != null) {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        fieldfecha.setText(DATE_FORMAT.format(cabecera.getFechaAsignacion()));
//                    } else {
//                        fieldfecha.setText("");
//                    }
//                    if (cabecera.getIdAlmacen() != null) {
//                        fieldTienda.setText(cabecera.getIdAlmacen().getDescripcion());
//                    } else {
//                        fieldTienda.setText("");
//                    }
//                    if (cabecera.getIdUsuario1() != null) {
//                        fieldPersonalDep.setText(cabecera.getIdUsuario1().getNombre());
//                    } else {
//                        fieldPersonalDep.setText("");
//                    }
//                    if (cabecera.getIdUsuario2() != null) {
//                        fieldAyudante.setText(cabecera.getIdUsuario2().getNombre());
//                    } else {
//                        fieldAyudante.setText("");
//                    }
//                    if (cabecera.getTipoMercancia() != null) {
//                        fieldtipo.setText(cabecera.getTipoMercancia());
//                    } else {
//                        fieldtipo.setText("");
//                    }
//                    if (cabecera.getTotal() != null) {
//                        fieldTotal.setText(cabecera.getTotal() + "");
//                    } else {
//                        fieldTotal.setText("");
//                    }
//
//                    JavaUtil.displayResult(resultListProductoSalida, listadoMercancia);
//                    listadoMercancia.setEditable(false);
//                    checkboxRevisado.setSelected(false);
//                    pos = cb_Salidas.getSelectedIndex();
//                }
//            }
//        });

    }//GEN-LAST:event_cb_SalidasActionPerformed
    private String obtenerRuta() {

        JFileChooser dialogo = new JFileChooser();
        int opcion = dialogo.showSaveDialog(this);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            File f = dialogo.getSelectedFile();
            ruta = f.toString();
        }
        return (ruta);
    }

    public static void codigoBarra(int codigo) throws FileNotFoundException, IOException {
        //Create the barcode bean

        Code128Bean bean = new Code128Bean();

        final int dpi = 150;

//Configure the barcode generator
        bean.setModuleWidth(UnitConv.in2mm(2.0f / dpi)); //makes the narrow bar
        //width exactly one pixel
//        bean.setWideFactor(3);
        bean.doQuietZone(false);

//Open output file
        File outputFile = new File("out.png");
        OutputStream out = new FileOutputStream(outputFile);
        try {
            //Set up the canvas provider for monochrome PNG output
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

            //Generate the barcode
            bean.generateBarcode(canvas, String.valueOf(codigo));

            //Signal end of generation
            canvas.finish();
        } finally {
            out.close();
        }

    }
    
    private void createMDB() throws IOException, SQLException {
        File archivo = new File("Etiquetas.mdb");
        archivo.createNewFile();
        Database db = DatabaseBuilder.create(Database.FileFormat.V2000, archivo);
        Table newTable = new TableBuilder("Tbl_Etiquetas")
                .addColumn(new ColumnBuilder("CodigoProducto")
                        .setSQLType(Types.NUMERIC))
                .addColumn(new ColumnBuilder("Referencia")
                        .setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("DescripcionProducto")
                        .setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("PrecioVenta")
                        .setSQLType(Types.FLOAT))
                .addColumn(new ColumnBuilder("CostoDolar")//siempre 0
                        .setSQLType(Types.NUMERIC))
                .addColumn(new ColumnBuilder("CodigoProveedor")
                        .setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Mes")
                        .setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Anno")
                        .setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("TextoZona")//siempre vacio
                        .setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Cantidad")//siempre 1
                        .setSQLType(Types.NUMERIC))
                .addColumn(new ColumnBuilder("Adicional")//siempre vacio
                        .setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Marca")
                        .setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("PrecioVentasi")
                        .setSQLType(Types.FLOAT))
                .toTable(db);

        Calendar now = Calendar.getInstance();

        for (Object rslDetalle : resultListProductoSalida) {
            SalidaParaTiendaDetalle detalle = (SalidaParaTiendaDetalle) rslDetalle;
//            for (int i = 0; i < detalle.getCantidadProducto(); i++) {
//                Producto produc = detalle.getProducto();
//                newTable.addRow(
//                        produc.getIdProducto(),
//                        produc.getReferenciaProducto(),
//                        produc.getDescripcion(),
//                        (produc.getPrecioVenta() + (produc.getPrecioVenta() * JavaUtil.iva)),
//                        0,
//                        produc.getIdProveedor().getIdProveedor() + "",
//                        now.get(Calendar.MONTH) + 1,
//                        now.get(Calendar.YEAR),
//                        "",
//                        1,
//                        "",
//                        produc.getIdMarca().getNombre(),
//                        produc.getPrecioVenta()
//                );
//            }
        }

        //se llama al metodo para imprimir ( .bat )
    }


    private void bImprimirEtiquetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bImprimirEtiquetasActionPerformed
        String filePath = "C:/Etiquetado Bulto Miyake/Imprime.bat";
        try {
            createMDB();
            Process p = Runtime.getRuntime().exec(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bImprimirEtiquetasActionPerformed

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
            java.util.logging.Logger.getLogger(Fsalida_p_tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fsalida_p_tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fsalida_p_tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fsalida_p_tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fsalida_p_tienda().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGenerarReporte;
    private javax.swing.JButton bImprimirEtiquetas;
    private javax.swing.JComboBox cb_Salidas;
    private javax.swing.JCheckBox checkboxRevisado;
    private javax.swing.JTextField fieldAyudante;
    private javax.swing.JTextField fieldPersonalDep;
    private javax.swing.JTextField fieldTienda;
    private javax.swing.JTextField fieldTotal;
    private javax.swing.JTextField fieldfecha;
    private javax.swing.JTextField fieldnumFact;
    private javax.swing.JTextField fieldtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable listadoMercancia;
    private javax.swing.JPanel paneFinal;
    private javax.swing.JPanel panelCabezera;
    private javax.swing.JPanel panelTabla;
    // End of variables declaration//GEN-END:variables
}
