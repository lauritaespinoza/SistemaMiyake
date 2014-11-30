/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.csv;

import au.com.bytecode.opencsv.CSVReader;
import util.JavaUtil;
import static util.JavaUtil.csv_valid_double;
import static util.JavaUtil.csv_valid_integer;
import static util.JavaUtil.csv_valid_string;
import static util.JavaUtil.isValidValue;
import static util.JavaUtil.prepareStrDoubleCSV;
import static util.JavaUtil.prepareStrInteger;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author Usuario
 */
public class CSVreader {

    //constantes de indices para datos
    public static final int csv_transaccion = 1;
    public static final int csv_totalSinIva = 12;
    public static final int csv_totalConIva = 13;
    public static final int csv_factura = 14;
    public static final int csv_impresora = 12;
    public static final int csv_anuladaOrDevuelta = 13;
    public static final int csv_codigoProducto = 16;
    public static final int csv_tipoProducto = 18;
    public static final int csv_usuario = 18;
    public static final int csv_precioProducto = 20;
    public static final int csv_tipoTransaccion = 25;//devolucion,cancelada, normal
    public static final int csv_cedulaModifi = 15;
    public static final int csv_usuarioModifi = 16;
    public static final int csv_nuevo = 23;
    public static final int csv_tipoCambio = 14;
    public static final int csv_productoAnulado = 176;

    //validacion de tipos de fila
    public static final int csv_row_type_usuario = 23;
    public static final int csv_row_type_impresora = 26;
    public static final int csv_row_type_nuevoOrPagoOrDevolucion = 30;//pago no puede ser 0
    public static final int csv_row_type_producto = 183;
    public static final int csv_row_type_cambio = 15;//si es 0 no hace nada, si es positivo es cambio o anulado, si es negativo es devolucion
    public static final int csv_row_type_devuelta = 24;//preguntar si es numero, 24 igual a tarjetas

    //constantes de csv generado
    public static final int csv_consts_cambio = 38;
    public static final int csv_consts_devolucion = 139;
    public static final int csv_consts_cancelada = 999;//aun no se sabe
    public static final String csv_consts_Scambio = "PRODUCTO ANULADO";
    public static final String csv_consts_Sdevolucion = "DEVOLUCIONES";
    public static final String csv_consts_Scancelada = "TRANSAC. CANCELADA";

    //lista de vectores de string. 
    //  contiene tantos indices de lista como lineas tenga el archivo
    //  contiene tantos indices de vector de strings como campos (,) hayan en la linea
    private List<String[]> listaCSV = null;

    public List<String[]> getListaCSV() {
        return listaCSV;
    }

    public void setListaCSV(List<String[]> listaCSV) {
        this.listaCSV = listaCSV;
    }

    public String getCSVat(int linea, int campo) {
        /*String rsl = "";
         for (int i : campos) {
         rsl += listaCSV.get(linea)[i];
         }
         return rsl;*/
        return listaCSV.get(linea)[campo];
    }

    private void prepareList(String path) {
        try {
            CSVReader reader = new CSVReader(new FileReader(path), ',');
            listaCSV = reader.readAll();
            int i = 1, menor = listaCSV.get(0).length;
            String filas = "";
            for (String[] listaCSV1 : listaCSV) {
                if (listaCSV1.length < menor) {
                    menor = listaCSV1.length;
                }

                System.out.println((i) + " " + listaCSV1.length);
//listaCSV1.length == 18 ||
                if (listaCSV1.length == 24) {
                    System.out.println("********");
                }
                if (listaCSV1.length == 18 || listaCSV1.length == 15 || listaCSV1.length == 24) {
                    //System.out.println("********");
                    filas += (i) + " " + listaCSV1.length + " " + listaCSV1[listaCSV1.length - 1]
                            + " " + listaCSV1[listaCSV1.length - 2] + " " + listaCSV1[listaCSV1.length - 3] + "\n";
                }
                i++;
            }
            System.out.println("\n\n\n" + filas);
            System.out.println("\n\nMENOR: " + menor);
        } catch (IOException ex) {
            System.out.println("problem accessing file" + path);
        }
    }

    public CSVreader(String path) {
        prepareList(path);
    }

    


    public ListModel getListModel() {
        if (listaCSV == null) {
            return null;
        }

        DefaultListModel listModel = new DefaultListModel();
        Set sizes = new HashSet();
//                JOptionPane.showMessageDialog(null, listaCSV.get(2).length + " " + getCSVat(2, csv_precioProducto));
        for (String[] object : listaCSV) {
            sizes.add(object.length);
            String rsl = new String();
            for (String st : object) {
                rsl += st;
            }
            listModel.addElement(rsl);
        }

//        for (Object object : sizes) {
//            System.out.println(object);
//        }
        return listModel;
    }

    public InventarioDiario procesCSV() {
        int i = 0;
        boolean anulado = false;
        InventarioDiario inventarioDiario = new InventarioDiario();
        String usuario_actual = "", s;
        //lista de vectores de string
        for (String[] str : listaCSV) {
            //System.out.println(i++);
            i++;
            int tipo = -1;
            if (i == 3) {
                tipo = -1;
            }
            switch (str.length) {
                case csv_row_type_cambio:
                    tipo = csv_row_type_cambio;
                    s = str[csv_tipoCambio];
                    if (isValidValue(csv_valid_integer, s)) {
                        //inventarioDiario.cancelarFactura();
                        Integer tipoC = Integer.parseInt(s);
                        switch (tipoC) {
                            case csv_consts_cambio:
                                anulado = true;
                                break;
                            case csv_consts_devolucion://****
                                break;
                        }
                    }
                    break;

                case csv_row_type_producto:
                    tipo = csv_row_type_producto;
                    Producto p = new Producto(
                            prepareStrInteger(str[csv_codigoProducto]),
                            str[csv_tipoProducto],
                            prepareStrDoubleCSV(str[csv_precioProducto])
                    );
                    if (str[csv_productoAnulado].equals(csv_consts_Scambio)
                            && anulado) {
                        inventarioDiario.getLastFactura().removeProducto(p);
                    } else {
                        Factura lf = inventarioDiario.getLastFactura();
                        if (lf != null) {
                            lf.addProducto(p);
                        }
                    }
                    break;

                case csv_row_type_nuevoOrPagoOrDevolucion:
                    tipo = csv_row_type_nuevoOrPagoOrDevolucion;
                    //si es una nueva
                    if (isValidValue(csv_valid_string, str[csv_nuevo])) {
                        if (str[csv_tipoTransaccion].equals(csv_consts_Sdevolucion)) {
                            inventarioDiario.addFactura(new Factura(usuario_actual, Factura.Estado.devuelta));
                        }
                        if (str[csv_tipoTransaccion].equals(csv_consts_Scancelada)) {
                            inventarioDiario.addFactura(new Factura(usuario_actual, Factura.Estado.cancelada));
                        }
                        if (str[csv_tipoTransaccion].equals("")) {
                            inventarioDiario.addFactura(new Factura(usuario_actual));
                        }
                        anulado = false;
                    } else {
                        if (isValidValue(csv_valid_double, str[csv_totalSinIva])
                                && isValidValue(csv_valid_double, str[csv_totalConIva])) {
                            inventarioDiario.getLastFactura().setTotalSinIvaLEIDO(prepareStrDoubleCSV(str[csv_totalSinIva]));
                            inventarioDiario.getLastFactura().setTotalConIvaLEIDO(prepareStrDoubleCSV(str[csv_totalConIva]));
                        }
                    }

                    break;

                case csv_row_type_usuario:
                    tipo = csv_row_type_usuario;
                    if (isValidValue(csv_valid_string, str[csv_usuario])) {
                        usuario_actual = str[csv_usuario];
                    }
                    break;

                case csv_row_type_impresora:
                    tipo = csv_row_type_impresora;
                    if (isValidValue(csv_valid_string, str[csv_impresora])) {
                        inventarioDiario.getLastFactura().setImpresora(str[csv_impresora]);
                        inventarioDiario.getLastFactura().setNumero(prepareStrInteger(str[csv_factura]));
                        inventarioDiario.getLastFactura().setTransaccion(prepareStrInteger(str[csv_transaccion]));
                    }
                    break;

                case csv_row_type_devuelta:
                    tipo = csv_row_type_devuelta;
                    if (str[csv_anuladaOrDevuelta].length() >= 5 && isValidValue(csv_valid_double,
                            s = str[csv_anuladaOrDevuelta].substring(str[csv_anuladaOrDevuelta].length() - 5))) {

                        inventarioDiario.getLastFactura().setUsuarioModif(str[csv_usuarioModifi]);
                        inventarioDiario.getLastFactura().setCedulaModif(str[csv_cedulaModifi]);
                        Integer c = Integer.parseInt(s);
                        inventarioDiario.getLastFactura().setFacturaRef(c);
//                            Factura ft = inventarioDiario.getFacturaByTransaction(c);
//                            if (ft != null) {
//                                ft.setEstado(Factura.devuelta);
//                            }
                    }
                    break;

            }
        }
        inventarioDiario.prepareAll();
        return inventarioDiario;
    }
    //no suma total inventario***
//3890.03
}
