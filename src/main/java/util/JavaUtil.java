/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelos.mapeos.Almacen;
import modelos.mapeos.Clasificacion;
import modelos.mapeos.Contacto;
import modelos.mapeos.Departamento;
import modelos.mapeos.Division;
import modelos.mapeos.InventarioDiarioDetalle;
import modelos.mapeos.InventarioTienda;
import modelos.mapeos.Marca;
import modelos.mapeos.Producto;
import modelos.mapeos.Proveedor;
import modelos.mapeos.SalidaParaTiendaDetalle;
import modelos.mapeos.Ubicacion;
import modelos.mapeos.Usuario;

public abstract class JavaUtil {

    public static final String cons_seleccionar = "Seleccionar";
    public static final String cons_rutaFacturasDigitales = "\\\\192.2.1.99\\datos_usuarios en D\\PASANTIA2014\\ARCHIVOS FACTURAS DIGITALES\\";
    public static final double iva = 0.12;
    public static final DecimalFormat dosDecimales = new DecimalFormat("#.##");

    public static final String cons_rutaServidor = "\\\\192.2.1.99\\datos_usuarios en D\\PASANTIA2014\\";
//    public static final String cons_rutaServidor = "";
    public static final String cons_rutaImgs = "\\\\192.2.1.99\\datos_usuarios en D\\PASANTIA2014\\imgs\\";
//    public static final String cons_rutaImgs = "";
    public static final String cons_rutaImgsAlmacen = "\\\\192.2.1.99\\datos_usuarios en D\\PASANTIA2014\\IMAGENES\\ALMACENES\\";
//    public static final String cons_rutaImgsAlmacen = "";

    //validacion de tipos de datos
    public static final int csv_valid_integer = 1;
    public static final int csv_valid_double = 2;
    public static final int csv_valid_string = 3;

    //tratar de hacerlo con beans o xml para ser generico con proyecto
    //se puede hacer metodo que regrese toda su info con un map o list
    public static Vector<Object> getGenericRowTable(Object o) {
        Vector<Object> oneRow = new Vector<>();

        if (o instanceof Division) {
            Division d = (Division) o;
            oneRow.add(d.getIdDivision());
            oneRow.add(d.getNombre());
        }
        if (o instanceof Departamento) {
            Departamento d = (Departamento) o;
            oneRow.add(d.getIdDepartamento());
            oneRow.add(d.getNombre());
            oneRow.add(d.getIdDivision() == null ? null : d.getIdDivision().getNombre());

        }
        if (o instanceof Clasificacion) {
            Clasificacion c = (Clasificacion) o;
            oneRow.add(c.getIdClasificacion());
            oneRow.add(c.getNombre());
            oneRow.add(c.getIdDepartamento() == null ? null : c.getIdDepartamento().getNombre());
        }

        if (o instanceof Marca) {
            Marca m = (Marca) o;
            oneRow.add(m.getIdMarca());
            oneRow.add(m.getNombre());
        }

        if (o instanceof Ubicacion) {
            Ubicacion u = (Ubicacion) o;
            oneRow.add(u.getIdUbicacion());
            oneRow.add(u.getPais());
            oneRow.add(u.getCiudad());
            oneRow.add(u.getDireccion());
        }

        if (o instanceof Contacto) {
            Contacto c = (Contacto) o;
            oneRow.add(c.getIdContacto());
            oneRow.add(c.getNombre());
            oneRow.add(c.getPuesto());
            oneRow.add(c.getTelefono1());
            oneRow.add(c.getTelefono2());
            oneRow.add(c.getEmail());
        }
        if (o instanceof Usuario) {
            Usuario u = (Usuario) o;
            oneRow.add(u.getNombre());
            oneRow.add(u.getDescripcion());
            oneRow.add(u.getTipoUsuario());
            oneRow.add(u.getTienda());
        }
        if (o instanceof Proveedor) {
            Proveedor p = (Proveedor) o;
            oneRow.add(p.getNombre());
            oneRow.add(p.getTelefono1());
            oneRow.add(p.getTelefono2());
            oneRow.add(p.getFax());
            oneRow.add(p.getCodPostal());
            oneRow.add(p.getEmail());
            oneRow.add(p.getIdContactoGerente() == null ? null : p.getIdContactoGerente().getNombre());
            oneRow.add(p.getIdContacto1() == null ? null : p.getIdContacto1().getNombre());
            oneRow.add(p.getIdContacto2() == null ? null : p.getIdContacto2().getNombre());
            oneRow.add(p.getFechaCreacion());
            oneRow.add(p.getFechaModificacion());
        }
        if (o instanceof Producto) {
            Producto p = (Producto) o;
            oneRow.add(p.getIdProducto());
            oneRow.add(p.getReferenciaProducto());
            oneRow.add(p.getDescripcion());
            oneRow.add(p.getIdClasificacion().getNombre());
            oneRow.add(p.getIdMarca().getNombre());
            oneRow.add(p.getIdProveedor().getNombre());
            oneRow.add(p.getPrecioOriginal());
        }

        //si es un vector, y si el la primera es Salida para tienda detalle entonces es
        //salida para tienda detalle con precios y descuentos
        //salidaparatiendadetale,precio,descuento
        if (o instanceof Object[] && (((Object[]) o)[0]) instanceof SalidaParaTiendaDetalle) {
            Object[] vec = (Object[]) o;
            SalidaParaTiendaDetalle s = (SalidaParaTiendaDetalle) vec[0];
            oneRow.add(s.getNroRenglon());
            oneRow.add(s.getProducto().getIdProducto());
            oneRow.add(s.getProducto().getReferenciaProducto());
            oneRow.add(s.getProducto().getDescripcion());
            oneRow.add(s.getCantidadProducto());
            oneRow.add(vec[1]);//precio
            oneRow.add(vec[2]);//descuento
            oneRow.add(s.getNroBulto());
        }

        if (o instanceof InventarioTienda) {
            InventarioTienda ivt = (InventarioTienda) o;
            oneRow.add(ivt.getAlmacen().getNombre());
            oneRow.add(ivt.getProducto().getIdProducto());
            oneRow.add(ivt.getProducto().getDescripcion());
            oneRow.add(dosDecimales.format(ivt.getPrecioSinDescuento() == null ? 0f : ivt.getPrecioSinDescuento()));
            oneRow.add(ivt.getDescuento().toString() + "%");
            oneRow.add(dosDecimales.format(ivt.getPrecioConDescuento() == null ? 0f : ivt.getPrecioConDescuento()));
            oneRow.add(ivt.getFechaCreacion());
            oneRow.add(ivt.getFechaModificacion());
        }
        
        if (o instanceof Almacen) {
            Almacen a = (Almacen) o;
            oneRow.add(a.getIdAlmacen());
            oneRow.add(a.getNombre());
            oneRow.add(a.getDescripcion());
            oneRow.add(a.getTelefono1());
            oneRow.add(a.getTelefono2());
            oneRow.add(a.getFax());
            oneRow.add(a.getCodPostal());
            oneRow.add(a.getEmail());
            oneRow.add(a.getIdUbicacion() == null ? null : a.getIdUbicacion().getDireccion());
            oneRow.add(a.getIdContactoGerente() == null ? null : a.getIdContactoGerente().getNombre() + "-" + a.getIdContactoGerente().getTelefono1());
        }
        if (o instanceof InventarioDiarioDetalle) {
            InventarioDiarioDetalle ivdDetalle = (InventarioDiarioDetalle) o;
            oneRow.add(ivdDetalle.getFecha() == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(ivdDetalle.getFecha()));
            oneRow.add(ivdDetalle.getConcepto());
            oneRow.add(dosDecimales.format(ivdDetalle.getEntrada() == null ? 0f : ivdDetalle.getEntrada()));
            oneRow.add(dosDecimales.format(ivdDetalle.getSalida() == null ? 0f : ivdDetalle.getSalida()));
            oneRow.add(dosDecimales.format(ivdDetalle.getSaldo() == null ? 0f : ivdDetalle.getSaldo()));
        }

        return oneRow;
    }

    public static Vector<String> getGenericHeaderTable(Object o) {
        Vector<String> header = new Vector<>();

        if (o instanceof Division) {
            header.add("ID Division");
            header.add("Nombre");
        }
        if (o instanceof Departamento) {
            header.add("ID Departamento");
            header.add("Nombre");
            header.add("Division");
        }
        if (o instanceof Clasificacion) {
            header.add("ID Clasificación");
            header.add("Nombre Clasificación");
            header.add("Departamento");
        }
        if (o instanceof Marca) {
            header.add("ID Marca");
            header.add("Nombre Marca");
        }
        if (o instanceof Ubicacion) {
            header.add("ID Ubicación");
            header.add("Pais");
            header.add("Ciudad");
            header.add("Dirección");
        }
        if (o instanceof Contacto) {
            header.add("Id Contacto");
            header.add("Nombre");
            header.add("Puesto");
            header.add("Telefono 1");
            header.add("Telefono 2");
            header.add("Correo");
        }
        if (o instanceof Usuario) {
            header.add("Nombre");
            header.add("Descripción");
            header.add("Tipo de Usuario");
            header.add("Tienda");
        }
        if (o instanceof Proveedor) {
            header.add("Nombre");
            header.add("Telefono 1");
            header.add("Telefono 2");
            header.add("Fax");
            header.add("Código Postal");
            header.add("Correo");
            header.add("Gerente");
            header.add("Contacto");
            header.add("Otro Contacto");
            header.add("Fecha de Creación");
            header.add("Fecha de Modificación");
        }
        if (o instanceof Producto) {
            header.add("Código Producto");
            header.add("Referencia");
            header.add("Descripción");
            header.add("Clasificación");
            header.add("Marca");
            header.add("Proveedor");
            header.add("Precio Original");
        }
        //si es un vector, y si el la primera es Salida para tienda detalle entonces es
        //salida para tienda detalle con precios y descuentos
        if (o instanceof Object[] && (((Object[]) o)[0]) instanceof SalidaParaTiendaDetalle) {
            header.add("N°");
            header.add("Codigo");
            header.add("Referencia");
            header.add("Descripcion");
            header.add("Cantidad");
            header.add("Precio");
            header.add("Descuento");
            header.add("Bulto");
        }
        if (o instanceof InventarioTienda) {
            header.add("Tienda");
            header.add("Código Producto");
            header.add("Nombre Producto");
            header.add("Precio sin Descuento");
            header.add("Descuento");
            header.add("Precio con Descuento");
            header.add("Fecha de Creación");
            header.add("Fecha de Modificación");
        }
        
          if (o instanceof Almacen) {
            header.add("ID");
            header.add("Nombre");
            header.add("Descripción");
            header.add("Tlf 1");
            header.add("Tlf 2");
            header.add("Fax");
            header.add("Cod. Postal");
            header.add("Email");
            header.add("Ubicación");
            header.add("Contacto");
        }
        if (o instanceof InventarioDiarioDetalle) {
            header.add("Fecha");
            header.add("Concepto");
            header.add("Entrada");
            header.add("Salida");
            header.add("Saldo");
        }

        return header;
    }

    public static void displayResult(List resultList, JTable tabla) {
        if (resultList == null || resultList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron registros");
            return;
        }

        Vector<String> tableHeaders = getGenericHeaderTable(resultList.get(0));
        Vector tableData = new Vector();

        for (Object o : resultList) {
            tableData.add(getGenericRowTable(o));
        }

        tabla.setModel(new DefaultTableModel(tableData, tableHeaders));
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void createJDialogGeneric(JPanel panelagregar) {
        JDialog dialogo = new JDialog();
        dialogo.getContentPane().setLayout(new BorderLayout());
        dialogo.getContentPane().add(new JScrollPane(panelagregar), BorderLayout.CENTER);
        dialogo.pack();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Point p
                = new Point(
                        (int) ((d.getWidth() - dialogo.getWidth()) / 2),
                        (int) ((d.getHeight() - dialogo.getHeight()) / 2));
        dialogo.setLocation(p);
        dialogo.setModal(true);
        dialogo.setVisible(true);
    }

    public static void setTableCellAlignment(int alignment, JTable table) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(alignment);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.setDefaultRenderer(table.getColumnClass(i), renderer);
        }
        table.updateUI();
    }

    public static void copyFile(String source, String dest) throws FileNotFoundException, IOException {
        if (source == null || dest == null || source.equals("") || dest.equals("")) {
            return;
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
    
    public static Integer prepareStrInteger(String aInteger) {
        return !isValidValue(csv_valid_integer, aInteger.trim()) ? null : Integer.parseInt(aInteger.trim());
    }

    public static Double prepareStrDoubleCSV(String adouble) {
        //JOptionPane.showMessageDialog(null, adouble);
        adouble = adouble.trim();
        Double d;
        if (!isValidValue(csv_valid_double, adouble)) {
            return null;
        }

        if (adouble.length() > 3) {//normal : 1234 -> 12.34  / -1234 -> -12.34
            d = Double.parseDouble(
                    adouble.substring(0, adouble.length() - 2)
                    .concat(".").concat(adouble.substring(adouble.length() - 2))
            );
        } else {//decimales : 1 -> 0.1 / -1 -> -0.1
            if (adouble.contains("-")) {
                d = Double.parseDouble(
                        "-0.0".concat(adouble.replace("-", ""))
                );
            } else {
                d = Double.parseDouble(
                        "0.0".concat(adouble)
                );
            }
        }
        return d;
    }
    
     private static boolean[] getCanEdit(Object clase, int indices) {
        boolean[] canEdit;
        if (clase instanceof InventarioDiarioDetalle) {
            canEdit = new boolean[]{
                false, true, true, true, true
            };
        } else {
            canEdit = new boolean[indices];
            for (int i = 0; i < indices; i++) {
                canEdit[i] = true;
            }
        }
        return canEdit;
    }
     
     public static boolean isValidValue(int tipo, String... values) {
        boolean rsl = true;
        switch (tipo) {
            case csv_valid_integer:
                for (String string : values) {
                    rsl = !string.equals("") && !string.equals("0") && isNumeric(string);
                    if (!rsl) {
                        return false;
                    }
                }
                break;
            case csv_valid_double:
                for (String string : values) {
                    rsl = !string.equals("") && isNumeric(string);
                    if (!rsl) {
                        return false;
                    }
                }
                break;
            case csv_valid_string:
                for (String string : values) {
                    rsl = !isNumeric(string);
                    if (!rsl) {
                        return false;
                    }
                }
                break;
        }
        return rsl;
    }

    public static void preCambio(String ruta, JLabel lbl) {
        try {
            if (ruta == null || ruta.equals("")) {

                cambiarImg(null, lbl);

                return;
            }
            File f = new File(ruta);
            if (f.exists()) {
                cambiarImg(f, lbl);
            } else {
                cambiarImg(null, lbl);
            }
        } catch (IOException ex) {
            Logger.getLogger(JavaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cambiarImg(File imagen, JLabel logoview) throws IOException {
        if (imagen == null) {
            logoview.setIcon(null);
            return;
        }

        BufferedImage img = null;
        img = ImageIO.read(imagen);
        logoview.setIcon(new ImageIcon(img.getScaledInstance(logoview.getWidth(), logoview.getHeight(), Image.SCALE_SMOOTH)));
    }

}
