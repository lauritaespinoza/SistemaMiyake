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
import java.io.File;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import util.JavaUtil;

/**
 *
 * @author Usuario
 */
public class JDfaturasCSV extends javax.swing.JDialog {

    private InventarioDiario ivtDiario = null;

    public InventarioDiario getIvtDiario() {
        return ivtDiario;
    }

    public JDfaturasCSV(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        transaccion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        numero = new javax.swing.JLabel();
        lbusuario = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        impresoralb = new javax.swing.JLabel();
        impresora = new javax.swing.JLabel();
        lbestado = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla = new org.jdesktop.swingx.JXTable();
        lbusuariomodif = new javax.swing.JLabel();
        modificado = new javax.swing.JLabel();
        lbusuariomodif1 = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        lbusuariomodif2 = new javax.swing.JLabel();
        facToSinIva = new javax.swing.JLabel();
        lbusuariomodif3 = new javax.swing.JLabel();
        facToConIva = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalSinIva = new javax.swing.JLabel();
        totalConIva = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        actualizar = new javax.swing.JButton();
        imprimirInv = new javax.swing.JButton();
        imprimirFac = new javax.swing.JButton();
        seleccionar = new javax.swing.JButton();
        ruta = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();

        filesc.setCurrentDirectory(new java.io.File("C:\\Users\\Usuario\\Documents\\PASANTIA\\prueba"));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de Facturas");

        tabpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane1.setViewportView(texto);

        tabpanel.addTab("Texto", null, jScrollPane1, "");

        listaFacturas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listaFacturas);

        jLabel4.setText("Facturas");

        jLabel5.setText("Transacción");

        transaccion.setText(" ");
        transaccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Número");

        numero.setText(" ");
        numero.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbusuario.setText("Usuario");

        usuario.setText(" ");
        usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        impresoralb.setText("Impresora");

        impresora.setText(" ");
        impresora.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbestado.setText("Estado");

        estado.setText(" ");
        estado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        tabla.setSortable(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabla);

        lbusuariomodif.setText("Modificación por");

        modificado.setText(" ");
        modificado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbusuariomodif1.setText("Cédula");

        cedula.setText(" ");
        cedula.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbusuariomodif2.setText("Total sin IVA");

        facToSinIva.setText(" ");
        facToSinIva.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbusuariomodif3.setText("Total con IVA");

        facToConIva.setText(" ");
        facToConIva.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbusuario)
                                            .addComponent(lbusuariomodif)
                                            .addComponent(jLabel5)
                                            .addComponent(lbusuariomodif2)
                                            .addComponent(lbestado))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(facToSinIva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(modificado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 87, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(transaccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(impresoralb)
                                            .addComponent(jLabel6)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbusuariomodif1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbusuariomodif3)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(numero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(impresora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(facToConIva, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(numero)
                            .addComponent(transaccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbusuario)
                            .addComponent(usuario)
                            .addComponent(impresoralb)
                            .addComponent(impresora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbusuariomodif)
                            .addComponent(modificado)
                            .addComponent(lbusuariomodif1)
                            .addComponent(cedula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbusuariomodif2)
                            .addComponent(facToSinIva)
                            .addComponent(lbusuariomodif3)
                            .addComponent(facToConIva))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbestado)
                            .addComponent(estado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabpanel.addTab("Lista", jPanel1);

        jLabel1.setText("Fecha");

        fecha.setText(" ");
        fecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Total sin IVA");

        totalSinIva.setText(" ");
        totalSinIva.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        totalConIva.setText(" ");
        totalConIva.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Total con IVA");

        actualizar.setText("Actualizar Inventario");
        actualizar.setToolTipText("Actualiza el Inventario de la Tienda");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        imprimirInv.setText("Imprimir Inventario Diario");
        imprimirInv.setToolTipText("Actualiza el Inventario de la Tienda");
        imprimirInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirInvActionPerformed(evt);
            }
        });

        imprimirFac.setText("Imprimir Factura");
        imprimirFac.setToolTipText("Actualiza el Inventario de la Tienda");
        imprimirFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirFacActionPerformed(evt);
            }
        });

        seleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_almacen/1417901536_internt_web_technology-02-16.png"))); // NOI18N
        seleccionar.setText("Cargar Archivo de Factura");
        seleccionar.setToolTipText("Para cálculo de factura");
        seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarActionPerformed(evt);
            }
        });

        ruta.setText(" ");

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(totalConIva, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(26, 26, 26)
                                        .addComponent(totalSinIva, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tabpanel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imprimirInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imprimirFac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seleccionar)
                        .addGap(18, 18, 18)
                        .addComponent(ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionar)
                    .addComponent(ruta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fecha)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalSinIva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(totalConIva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(imprimirFac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imprimirInv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aceptar)
                        .addGap(113, 113, 113)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        actualizar.setEnabled(false);
    }//GEN-LAST:event_actualizarActionPerformed

    private void imprimirInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirInvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imprimirInvActionPerformed

    private void imprimirFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imprimirFacActionPerformed

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
        }
    }//GEN-LAST:event_seleccionarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        dispose();
    }//GEN-LAST:event_aceptarActionPerformed

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
    private javax.swing.JButton aceptar;
    private javax.swing.JButton actualizar;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables

}
