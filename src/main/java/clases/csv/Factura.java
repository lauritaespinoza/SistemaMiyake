/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.csv;

import util.JavaUtil;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Factura {

    //producto,cantidad
    private HashMap<Producto, Integer> productos;

    public enum Estado {

        correcta,//suma monto
        cancelada,//no suma ni resta, solo se guarda
        devuelta//resta monto
    }

    private Double totalSinIva = 0d;
    private Double totalConIva = 0d;
    private Double totalSinIvaLEIDO = 0d;
    private Double totalConIvaLEIDO = 0d;
    private Integer transaccion = null;
    private Integer numero = 0;
    private Integer facturaRef = 0;
    private String impresora = "";
    private Estado estado;
    private String usuario = "";
    private String usuarioModif = "";
    private String cedulaModif = "";

    public Factura(String usuario) {
        this(usuario, Estado.correcta);
    }

    public Factura(String usuario, Estado estado) {
        this.productos = new HashMap<>();
        this.usuario = usuario;
        this.estado = estado;
    }

    public Integer getFacturaRef() {
        return facturaRef;
    }

    public void setFacturaRef(Integer facturaRef) {
        this.facturaRef = facturaRef;
    }

    public String getCedulaModif() {
        return cedulaModif;
    }

    public void setCedulaModif(String cedulaModif) {
        this.cedulaModif = cedulaModif;
    }

    public String getUsuarioModif() {
        return usuarioModif;
    }

    public void setUsuarioModif(String usuarioModif) {
        this.usuarioModif = usuarioModif;
    }

    public Double getTotalSinIvaLEIDO() {
        return totalSinIvaLEIDO;
    }

    public void setTotalSinIvaLEIDO(Double totalSinIvaLEIDO) {
        this.totalSinIvaLEIDO = totalSinIvaLEIDO;
    }

    public Double getTotalConIvaLEIDO() {
        return totalConIvaLEIDO;
    }

    public void setTotalConIvaLEIDO(Double totalConIvaLEIDO) {
        this.totalConIvaLEIDO = totalConIvaLEIDO;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Integer transaccion) {
        if (transaccion != null) {
            this.transaccion = transaccion;
        }
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        if (numero != null) {
            this.numero = numero;
        }
    }

    public String getImpresora() {
        return impresora;
    }

    public void setImpresora(String impresora) {
        if (impresora != null) {
            this.impresora = impresora;
        }
    }

    public HashMap<Producto, Integer> getProductos() {
        return productos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setProductos(HashMap<Producto, Integer> productos) {
        this.productos = productos;
        totalSinIva = 0d;
        totalConIva = 0d;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto producto = entry.getKey();
            totalSinIva += producto.getPrecio();
        }
        totalConIva = totalSinIva + (totalSinIva * JavaUtil.iva);
    }

    public Double getTotalSinIva() {
        return totalSinIva;
    }

    public void setTotalSinIva(Double totalSinIva) {
        this.totalSinIva = totalSinIva;
    }

    public Double getTotalConIva() {
        return totalConIva;
    }

    public void setTotalConIva(Double totalConIva) {
        this.totalConIva = totalConIva;
    }

    private Map.Entry<Producto, Integer> getValue(Producto p) {
        for (Map.Entry<Producto, Integer> entrySet : productos.entrySet()) {
            Producto key = entrySet.getKey();
            if (key.getCodigo().equals(p.getCodigo())) {
                return entrySet;
            }
        }
        return null;
    }

    public void addProducto(Producto p) {
        Map.Entry<Producto, Integer> value;
        value = getValue(p);
        if (value != null) {
            productos.replace(value.getKey(), value.getValue() + 1);
        } else {
            productos.put(p, 1);
        }

        totalSinIva = estado != Estado.devuelta
                ? totalSinIva + p.getPrecio()
                : totalSinIva - p.getPrecio();
        totalConIva = totalSinIva + (totalSinIva * JavaUtil.iva);
    }

    @Override
    public String toString() {
//        if (estado != Estado.cancelada) {
//            return "";
//        }
        String rsl = "  Transaccion : " + transaccion
                + "\n  Numero : " + numero
                + "\n  Usuario : " + usuario
                + "\n  Impresora : " + impresora
                + "\n  **ESTADO** : " + estado + "\n";
        if (facturaRef != 0) {
            rsl += "\n  Factura Devuelta : " + facturaRef + "\n";
        }
        if (!usuarioModif.equals("") && !cedulaModif.equals("")) {
            rsl += "  Usuario Modificacíon : " + usuarioModif
                    + "\n  Cédula Usuario Modificacíon : " + cedulaModif + "\n";
        }
        rsl += "\tCodigo\tTipo\tPrecio\tCantidad\n\n";
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto p = entry.getKey();
            rsl += "\t" + p.getCodigo() + "\t" + p.getTipo() + "\t"
                    + JavaUtil.dosDecimales.format(p.getPrecio()).replace(",", ".") + "\t" + entry.getValue() + "\n";
        }
        String tsi, tci, trsi, trci;
        tsi = JavaUtil.dosDecimales.format(totalSinIva).replace(",", ".");
        tci = JavaUtil.dosDecimales.format(totalConIva).replace(",", ".");
        trsi = JavaUtil.dosDecimales.format(totalSinIvaLEIDO).replace(",", ".");
        trci = JavaUtil.dosDecimales.format(totalConIvaLEIDO).replace(",", ".");
        rsl += "\n\t" + "Total sin IVA : " + tsi
                + "\tTotal con IVA : " + tci
                + "\n\tTotalReal sin IVA : " + trsi
                + "\tTotalReal con IVA : " + trci;
        if (!trci.equals(tci)) {
            rsl += "\n****************************";
        }
        return rsl;
    }

    public void removeProducto(Producto p) {
        Map.Entry<Producto, Integer> value;
        value = getValue(p);
        if (value != null) {
            if (value.getValue() > 1) {
               productos.replace(value.getKey(), value.getValue() - 1);
            } else {
                productos.remove(p);
            }
            totalSinIva -= p.getPrecio();
            totalConIva = totalSinIva + (totalSinIva * JavaUtil.iva);
//            estado = totalConIva == 0 ? cancelada : estado;
        }
    }

}
