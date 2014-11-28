/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.anotaciones.util;


import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.EntradaProveedor;
import modelos.Factura;
import modelos.InventarioTienda;
import modelos.Producto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Query;

/**
 *
 * @author Usuario
 */
public class EXCELreader {

    private static final String init_detalle = "BULTO";
    public static final String cons_nuevo = "Nuevo";
    public static final String cons_diferente = "Diferente";
    public static final String cons_correcto = "Correcto";
    public static final String cons_repetidos = "REPETIDO";
    public static final int total_bulto = 0;
    public static final int totalKG_bulto = 1;
    public static final int referencia_producto = 2;
    public static final int descripcion_producto = 3;
    public static final int cantidad_producto = 4;
    public static final int tipoCantidad_producto = 5;
    public static final int precio_producto = 6;
    public static final int precioTotal_producto = 7;
    public static final int codBarras_producto = 8;
    public static final int parametros = 9;

    private String excelString;
    private int np = 0;//nuevos productos
    private int pd = 0;//precio diferente
    private List<String[]> listaEXCEL = null;

    public EXCELreader(String path) {
        prepareList(path);
    }

    public void setNp(int np) {
        this.np = np;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public int getNp() {
        return np;
    }

    public int getPd() {
        return pd;
    }

    public List<String[]> getListaEXCEL() {
        return listaEXCEL;
    }

    public int getListSize() {
        return listaEXCEL.size();
    }

    public void setListaEXCEL(List<String[]> listaEXCEL) {
        this.listaEXCEL = listaEXCEL;
    }

    public void setListAt(int index, int column, String data) {
        listaEXCEL.get(index)[column] = data;
    }

    public String getListAt(int index, int column) {
        return listaEXCEL.get(index)[column];
    }

    private void prepareList(String path) {

        excelString = "";
        listaEXCEL = new ArrayList<>();
        int sw = 0;//0 no,1 si, 2 ready
        XSSFWorkbook workbook;

        try {
            //Create Workbook instance holding reference to .xlsx file
            workbook = new XSSFWorkbook(new FileInputStream(new File(path)));

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                String[] linea = new String[parametros];
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                //  if (rowcont2 ==16) {
//                excelString += ++rowcont + "***";
                int rowcont = 0;
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    //JOptionPane.showMessageDialog(null, "Tipo *" + cell.getCellType() + "*");
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            //leyendo tabla
                            if (sw == 2) {
                                Double d = cell.getNumericCellValue();//String.format("%d", d.intValue())
                                excelString += ((d % 1 != 0) ? d.toString() : d.toString()) + "\t";
                                linea[rowcont++] = ((d % 1 != 0) ? d.toString() : d.toString());
                            }
                            break;

                        case Cell.CELL_TYPE_STRING:
                            // JOptionPane.showMessageDialog(null, "String *" + cell.getStringCellValue().trim() + "*");
                            if (sw == 0) {
                                if (cell.getStringCellValue().trim().equals(init_detalle)) {
                                    sw = 1;
                                }
                            }
                            //leyendo tabla
                            if (sw == 2) {
                                excelString += cell.getStringCellValue() + "\t";
                                linea[rowcont++] = cell.getStringCellValue();
                            }
                            break;

                        case Cell.CELL_TYPE_BLANK:
                            //si estaba leyendo tabla, pero encuentra vacio
                            //  termina de leer la tabla
                            if (rowcont == 0 && sw == 2) {
                                sw = 4;
                            }
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            //leyendo tabla
                            if (sw == 2) {
                                Double d = cell.getNumericCellValue();
                                excelString += ((d % 1 != 0) ? d.toString() : d.toString()) + "\t";
                                linea[rowcont++] = ((d % 1 != 0) ? d.toString() : d.toString());
                            }
                            break;
                    }
                    //si ya es 1 termina el ciclo, para iniciar el detalle
                    //  en la siguiente linea
                    if (sw == 1) {
                        sw = 2;
                        break;
                    }
                    //si ya no leera mas tabla, termina de leer la row
                    if (sw == 4) {
                        break;
                    }
                }
                //guarda si esta leyendo tabla
                if (sw == 2 && linea[0] != null) {
                    listaEXCEL.add(linea);
                    excelString += "\n";
                }
                //termino de leer la tabla, cierra todo
                if (sw == 4) {
                    break;
                }

                //   }
            }
            int as = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private int getTipoCantidad(String tipo) {

        switch (tipo) {

            case "DOC":
                return 12;
            default://SET   UNI PZA
                return 1;
        }
    }

    public void procesarEXCEL(Factura f) {
        Float total_factura = 0f, fCargado;
        for (String[] index : listaEXCEL) {
            String hql = "FROM Producto p WHERE p.referenciaProducto=:referencia ORDER BY p.idProducto ASC";
            DaoQuery q = ObjectModelDAO.createQueryDAO(hql);
            q.getQuery().setParameter("referencia", index[referencia_producto]);
            List resultList = ObjectModelDAO.getResultQuery(q);
            int encontrados = resultList.size();

            if (encontrados == 1) {
                Producto p = (Producto) resultList.get(0);//el unico producto con la referencia actual
                EntradaProveedor ep = new EntradaProveedor(
                        new Float(index[totalKG_bulto]),
                        getTipoCantidad(index[tipoCantidad_producto]),
                        new Float(index[cantidad_producto]).intValue(),//se transforma primero en decimal porque el string contiene .0
                        fCargado = new Float(index[precioTotal_producto]),
                        index[codBarras_producto],
                        new Float(index[total_bulto]).intValue(),//se transforma primero en decimal porque el string contiene .0
                        f,
                        p
                );
                ObjectModelDAO.saveObject(ep);
                total_factura += fCargado;
            } else {
                if (encontrados > 1) {
                    JOptionPane.showMessageDialog(null, "Existe más de un producto con la referencia '" + index[referencia_producto] + "',"
                            + " por la cual éste no se cargará");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un producto con la referencia '" + index[referencia_producto] + "',"
                            + " por la cual éste no se cargará");
                }
            }
        }
        f.setTotalFactura(total_factura);
        ObjectModelDAO.updateObject(f);
    }

    public DefaultTableModel toTable() {
        int i = 1;

        String[] titulos = {"Total Bulto", "Total KG", "Referencia",
            "Descripción", "Cantidad", "UM", "Precio", "Total Precio", "Cod. Barras", "Status"};
        Vector<String> cabecera = new Vector<>(Arrays.asList(titulos));
        Vector data = new Vector();
        for (String[] renglon : listaEXCEL) {
            Vector<Object> data_interno = new Vector<>();
            float precio_leido = new Double(renglon[precio_producto]).floatValue();

            data_interno.add(new Double(renglon[total_bulto]).intValue());
            data_interno.add(new Double(renglon[totalKG_bulto]));
            data_interno.add(renglon[referencia_producto]);
            data_interno.add(renglon[descripcion_producto]);
            data_interno.add(new Double(renglon[cantidad_producto]).intValue());
            data_interno.add(renglon[tipoCantidad_producto]);
            data_interno.add(precio_leido);
            data_interno.add(new Double(renglon[precioTotal_producto]));
            data_interno.add(renglon[codBarras_producto]);
            /*
             aca se verifica si existe, y si tiene datos distintos
             */

            String hqlP = "FROM Producto p WHERE p.referenciaProducto=:referencia ORDER BY p.idProducto ASC";
            DaoQuery qP = ObjectModelDAO.createQueryDAO(hqlP);
            qP.getQuery().setParameter("referencia", renglon[referencia_producto]);
            List resultListP = ObjectModelDAO.getResultQuery(qP);
            int encontradosP = resultListP.size();

            if (encontradosP == 0) {//si el producto no existe en la base de datos
                data_interno.add(cons_nuevo);
                this.np++;
            } else {
                if (encontradosP > 1) {//hay mas de 1 producto con la misma referencia *referencia deberia ser unica*
                    data_interno.add(cons_repetidos+" BD");
                } else {//el producto sí existe en la base de datos, ahora se busca en el inventario del DEPOSITO CENTRAL
                    //idAlmacen 1 porque es el DEPOSITO CENTRAL
                    String hql = "FROM InventarioTienda ivt WHERE ivt.almacen.idAlmacen=1 AND ivt.producto=:producto";
                    DaoQuery q = ObjectModelDAO.createQueryDAO(hql);
                    q.getQuery().setParameter("producto", (Producto) resultListP.get(0));
                    List resultList = ObjectModelDAO.getResultQuery(q);
                    int encontrados = resultList.size();

                    switch (encontrados) {
                        case 0://el producto esta en base de datos pero no en inventario, esta correcto
                            data_interno.add(cons_correcto);
                            break;
                        case 1://siel producto esta
                            InventarioTienda ivt = (InventarioTienda) resultList.get(0);//precio del que ya exsite en EL DEPOSITO CENTRAL
                            if (ivt.getPrecioSinDescuento().equals(precio_leido)) {//si son iguales
                                data_interno.add(cons_correcto);
                            } else {//si son diferentes
                                data_interno.add(cons_diferente);
                                this.pd++;
                            }

                            break;
                        default://no deberia haber mas de 1 encontrado
                            data_interno.add(cons_repetidos+" INV");
                    }
                }
            }

            data.add(data_interno);
        }

        return new DefaultTableModel(data, cabecera);
    }

    public String toEXCELString() {
        return excelString;
    }
}
