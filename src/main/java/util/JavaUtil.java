/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import hibernate.DAO.ObjectModelDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelos.mapeos.Almacen;
import modelos.mapeos.Clasificacion;
import modelos.mapeos.Contacto;
import modelos.mapeos.Departamento;
import modelos.mapeos.Division;
import modelos.mapeos.EntradaProveedor;
import modelos.mapeos.Factura;
import modelos.mapeos.InventarioDiarioDetalle;
import modelos.mapeos.InventarioTienda;
import modelos.mapeos.InventarioTiendaPK;
import modelos.mapeos.Marca;
import modelos.mapeos.NotaCreditoDebitoDetalle;
import modelos.mapeos.Producto;
import modelos.mapeos.Proveedor;
import modelos.mapeos.SalidaParaTienda;
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
            oneRow.add(p.getFechaCreacion() == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(p.getFechaCreacion()));
            oneRow.add(p.getFechaModificacion() == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(p.getFechaModificacion()));
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
            oneRow.add(p.getPrimeraActividad());
            oneRow.add(p.getUltimaActividad());
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
            oneRow.add(ivt.getProducto().getReferenciaProducto());
            oneRow.add(ivt.getProducto().getDescripcion());
            oneRow.add(dosDecimales.format(ivt.getPrecioSinDescuento() == null ? 0f : ivt.getPrecioSinDescuento()).trim());
            oneRow.add(ivt.getDescuento().toString() + "%");
            oneRow.add(dosDecimales.format(ivt.getPrecioConDescuento() == null ? 0f : ivt.getPrecioConDescuento()).trim());
            oneRow.add(ivt.getFechaCreacion());
            oneRow.add(ivt.getFechaModificacion());
            oneRow.add(ivt.getCantidad());
            oneRow.add(ivt.getProcesado());
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

        if (o instanceof NotaCreditoDebitoDetalle) {
            NotaCreditoDebitoDetalle ntcd = (NotaCreditoDebitoDetalle) o;
            oneRow.add(ntcd.getNroRenglon());
            oneRow.add(ntcd.getIdProducto().getReferenciaProducto());
            oneRow.add(ntcd.getIdProducto().getDescripcion());
            oneRow.add(ntcd.getObservacion());
            oneRow.add(ntcd.getCantidadProducto());
            InventarioTienda ivt = ObjectModelDAO.getObject(new InventarioTiendaPK(ntcd.getIdProducto().getIdProducto(), ntcd.getIdNotaCreditoDebito().getIdSalida().getIdAlmacenHasta().getIdAlmacen()), InventarioTienda.class);
            oneRow.add(ivt.getPrecioConDescuento());
        }
        if (o instanceof Factura) {
            Factura f = (Factura) o;
            oneRow.add(f.getNroFactura());
            oneRow.add(f.getTotalFactura());
            oneRow.add(f.getRecibidoPor());
            oneRow.add(f.getEmbarcadoVia());
            oneRow.add(f.getIdAlmacen().getNombre());
            oneRow.add(f.getIdProveedor().getNombre());

        }
        if (o instanceof SalidaParaTienda) {
            SalidaParaTienda sa = (SalidaParaTienda) o;
            oneRow.add(sa.getIdSalida());
            oneRow.add(sa.getIdAlmacenDesde().getNombre());
            oneRow.add(sa.getIdUsuario2().getNombre() + " : " + sa.getIdUsuario2().getDescripcion());
            oneRow.add(sa.getIdAlmacenHasta().getNombre());
            //oneRow.add(sa.getRevisado());
            if (sa.getRevisado() == false) {
                oneRow.add("Pendiente");
            } else {
                oneRow.add("Procesado");
            }
            oneRow.add(sa.getTotal());
            oneRow.add(sa.getFechaAsignacion());
        }

        if (o instanceof SalidaParaTiendaDetalle) {
            SalidaParaTiendaDetalle s = (SalidaParaTiendaDetalle) o;
            oneRow.add(s.getProducto().getIdProducto());
            oneRow.add(s.getProducto().getReferenciaProducto());
            oneRow.add(s.getProducto().getDescripcion());
            oneRow.add(s.getCantidadProducto());
            oneRow.add(s.getNroBulto());
        }
        if (o instanceof EntradaProveedor) {
            EntradaProveedor ep = (EntradaProveedor) o;
            oneRow.add(ep.getIdProducto().getIdProducto());
            oneRow.add(ep.getIdProducto().getReferenciaProducto());
            oneRow.add(ep.getIdProducto().getDescripcion());
            oneRow.add(ep.getCantidadSet());
            oneRow.add(ep.getCantidadProducto());
            oneRow.add(ep.getCantidadSet() * ep.getCantidadProducto());
            oneRow.add(ep.getNroBulto());
            oneRow.add(ep.getFechaRecepcion());
        }

        return oneRow;
    }

    public static Vector<String> getGenericHeaderTable(Object o) {
        Vector<String> header = new Vector<>();

        if (o instanceof Division) {
            header.add("ID DIVISION");
            header.add("NOMBRE");
        }
        if (o instanceof Departamento) {
            header.add("ID DEPARTAMENTO");
            header.add("NOMBRE DEPARTAMENTO");
            header.add("DIVISION");
        }
        if (o instanceof Clasificacion) {
            header.add("ID CLASIFICACION");
            header.add("NOMBRE CLASIFICACION");
            header.add("DEPARTAMENTO");
        }
        if (o instanceof Marca) {
            header.add("ID MARCA");
            header.add("NOMBRE MARCA");
        }
        if (o instanceof Ubicacion) {
            header.add("ID UBICACION");
            header.add("PAIS");
            header.add("CIUDAD");
            header.add("DIRECCION");
        }
        if (o instanceof Contacto) {
            header.add("ID CONTACTO");
            header.add("NOMBRE");
            header.add("PUESTO");
            header.add("TELEFONO 1");
            header.add("TELEFONO 2");
            header.add("CORREO");
        }
        if (o instanceof Usuario) {
            header.add("NOMBRE");
            header.add("DESCRIPCION");
            header.add("TIPO DE USUARIO");
            header.add("TIENDA");
        }
        if (o instanceof Proveedor) {
            header.add("NOMBRE");
            header.add("TELEFONO 1");
            header.add("TELEFONO 2");
            header.add("FAX");
            header.add("CODIGO POSTAL");
            header.add("CORREO");
            header.add("GERENTE");
            header.add("CONTACTO");
            header.add("OTRO CONTACTO");
            header.add("FECHA DE CREACION");
            header.add("FECHA DE MODIFICACION");
        }
        if (o instanceof Producto) {
            header.add("CODIGO PRODUCTO");
            header.add("REFERENCIA");
            header.add("DESCRIPCION");
            header.add("CLASIFICACION");
            header.add("MARCA");
            header.add("PROVEEDOR");
            header.add("PRECIO ORIGINAL");
            header.add("FECHA CREACION");
            header.add("FECHA MODIFICACION");
        }
        //si es un vector, y si el la primera es Salida para tienda detalle entonces es
        //salida para tienda detalle con precios y descuentos
        if (o instanceof Object[] && (((Object[]) o)[0]) instanceof SalidaParaTiendaDetalle) {
            header.add("N°");
            header.add("CODIGO");
            header.add("REFERENCIA");
            header.add("DESCRIPCION");
            header.add("CANTIDAD");
            header.add("PRECIO");
            header.add("DESCUENTO");
            header.add("BULTO");
        }
        if (o instanceof InventarioTienda) {
            header.add("TIENDA");//
            header.add("CODIGO");
            header.add("REFERENCIA");
            header.add("DESCRIPCION");
            header.add("PRECIO SIN DESCUENTO");//
            header.add("DESCUENTO");
            header.add("PRECIO CON DESCUENTO");
            header.add("CREACION");
            header.add("MODIFICACION");
            header.add("EXISTENCIA");//
            header.add("ASIGNADO");//
        }

        if (o instanceof Almacen) {
            header.add("ID");
            header.add("NOMBRE");
            header.add("DESCRIPCION");
            header.add("TLF 1");
            header.add("TLF 2");
            header.add("FAX");
            header.add("COD. POSTAL");
            header.add("EMAIL");
            header.add("UBICACION");
            header.add("CONTACTO");
        }
        if (o instanceof InventarioDiarioDetalle) {
            header.add("FECHA");
            header.add("CONCEPTO");
            header.add("ENTRADA");
            header.add("SALIDA");
            header.add("SALDO");
        }

        if (o instanceof NotaCreditoDebitoDetalle) {
            header.add("RENGLON");
            header.add("REFERENCIA");
            header.add("DESCRIPCION");
            header.add("OBSERVACION");
            header.add("CANTIDAD");
            header.add("PRECIO");
        }
        if (o instanceof Factura) {

            header.add("NRO FACTURA");
            header.add("TOTAL FACTURA");
            header.add("RECIBIDO POR");
            header.add("EMBARCADO VIA");
            header.add("ALMACEN");
            header.add("PROVEEDOR");
        }

        if (o instanceof SalidaParaTienda) {
            header.add("NRO");
            header.add("ALMACEN DISTRIBUIDOR");
            header.add("ASIGNADO POR");
            header.add("ALMACEN ASIGNADO");
            header.add("ESTATUS DE PEDIDO");
            header.add("TOTAL");
            header.add("FECHA");
        }

        if (o instanceof SalidaParaTiendaDetalle) {
            header.add("CODIGO");
            header.add("REFERENCIA");
            header.add("DESCRIPCION");
            header.add("CANTIDAD");
            header.add("BULTO");
        }

        if (o instanceof EntradaProveedor) {
            header.add("CODIGO");
            header.add("REFERENCIA");
            header.add("DESCRIPCION");
            header.add("UM");
            header.add("CANTIDAD PRODUCTO");
            header.add("TOTAL CONTEO");
            header.add("NRO BULTO");
            header.add("FECHA RECEPCION");
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

        final boolean[] setCanEdit = getCanEdit(resultList.get(0), tableHeaders.size());
        tabla.setModel(new DefaultTableModel(tableData, tableHeaders) {

            boolean[] canEdit = setCanEdit;

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private static boolean[] getCanEdit(Object clase, int indices) {
        boolean[] canEdit = null;
        if (clase instanceof InventarioDiarioDetalle) {
            canEdit = new boolean[]{
                false, true, true, true, true
            };
        }
        if (clase instanceof NotaCreditoDebitoDetalle) {
            canEdit = new boolean[]{
                false, false, false, true, true, false
            };
        }
        if (canEdit == null) {
            canEdit = new boolean[indices];
            for (int i = 0; i < indices; i++) {
                canEdit[i] = true;
            }
        }
        return canEdit;
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

    public static void backupPGSQL(final JTextArea texto) {

        Thread hilo = new Thread() {

            @Override
            public void run() {
                try {
                    //                    try {
                    String rutaCT = "C:\\SistemaMiyake\\"
                            + "respaldosDB\\back_up_miyake"
                            + Calendar.getInstance().getTimeInMillis() + ".backup";
                    //"C:\\Users\\Usuario\\Desktop\\";
                    //"C:\\Users\\Pablo\\Desktop\\BackUpDB";
                    String IP = "localhost";

                    String pgdump = "C:\\postgresql-9.3.5-1-windows-binaries\\pgsql\\bin\\pg_dump.exe";
                    //"C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dump.exe";
                    //"C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dump.exe";
                    Process p;
                    ProcessBuilder pb;
                    java.io.File file = new java.io.File(rutaCT);
                    file.createNewFile();

                    pb = new ProcessBuilder(
                            pgdump,
                            "--host",
                            IP,
                            "--port",
                            "5432",
                            "--username",
                            "postgres",
                            "--no-password",
                            "--format",
                            "tar",
                            "--blobs",
                            "--verbose",
                            "--file",
                            rutaCT,
                            "miyake_pasantia"
                    );
                    pb.environment().put("PGPASSWORD", "admin");
                    pb.redirectErrorStream(true);
                    p = pb.start();
                    InputStream is = p.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String ll;
                    while ((ll = br.readLine()) != null) {

                        texto.append(ll + "\n");
                        texto.repaint();
//                        System.out.println(ll);
                    }

                    texto.append("\n\nBACKUP READY\n\n");
                    texto.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(JavaUtil.class.getName()).log(Level.SEVERE, null, ex);
                    texto.append(ex.getMessage());
                }
            }
        };

        hilo.start();

    }

    public static void restorePGSQL(final JTextArea texto, final String path) {

        Thread hilo = new Thread() {

            @Override
            public void run() {
                try {
                    String IP = "localhost";
                    String pgrestore = "C:\\postgresql-9.3.5-1-windows-binaries\\pgsql\\bin\\pg_restore.exe";
                    Process p;
                    ProcessBuilder pb;
                    pb = new ProcessBuilder(
                            pgrestore,
                            "--host",
                            IP,
                            "--port",
                            "5432",
                            "--username",
                            "postgres",
                            "--dbname",
                            "miyake_pasantia",
                            "--no-password",
                            "--verbose",
                            path
                    );
                    pb.environment().put("PGPASSWORD", "admin");
                    pb.redirectErrorStream(true);
                    p = pb.start();
                    InputStream is = p.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String ll;
                    while ((ll = br.readLine()) != null) {

                        texto.append(ll + "\n");
                        texto.repaint();
                    }

                    texto.append("\n\nRESTORE READY\n\n");
                } catch (Exception ex) {
                    Logger.getLogger(JavaUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        hilo.start();

    }

}
