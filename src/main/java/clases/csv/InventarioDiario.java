/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.csv;

import util.JavaUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InventarioDiario {

    private List<Factura> facturas;
    private HashMap<Integer, Integer> relacion = null;
    private Double totalSinIva = 0d;
    private Double totalConIva = 0d;
    private String fecha;

    public InventarioDiario() {
        this.facturas = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.fecha = dateFormat.format(date);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    //revisa las facturas que tengan Total 0 y las elimina
    public void limpiarFacturas() {
        int i = 0;
        for (Iterator<Factura> it = facturas.iterator(); it.hasNext();) {
            // System.out.println(i++);
            Factura factura = it.next();

            if (factura.getProductos().isEmpty()) {
                it.remove();

            }
        }
        calcularTotales();
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
        calcularTotales();
    }

    private void calcularTotales() {
        totalSinIva = 0d;
        totalConIva = 0d;
        for (Factura factura : facturas) {
            totalSinIva += factura.getTotalSinIva();
            totalConIva += factura.getTotalConIva();
        }
    }

    public void cancelarFactura() {
        if (facturas != null) {
            cancelarFactura(facturas.size() - 1);
        }
    }

    public void cancelarFactura(int f) {

        if (facturas == null || f < 0 || f >= facturas.size()) {
            return;
        }

        facturas.set(f,
                new Factura(facturas.get(f).getUsuario()
                )
        );
        calcularTotales();
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

    public void addFactura(Factura f) {

        if (facturas == null) {
            this.facturas = new ArrayList<>();
        }

        facturas.add(f);
        totalSinIva += f.getTotalSinIva();
        totalConIva += f.getTotalConIva();
    }

    public Factura getLastFactura() {
        return facturas != null && facturas.size() > 0 ? facturas.get(facturas.size() - 1) : null;
    }

    private void generateRelation() {
        relacion = new HashMap<>();
        for (Factura factura : facturas) {
            if (factura.getEstado() != Factura.Estado.cancelada) {
                HashMap<Producto, Integer> productos = factura.getProductos();
                for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
                    Integer value, c = entry.getKey().getCodigo();
                    value = relacion.get(c);

                    if (factura.getEstado() == Factura.Estado.correcta) {
                        if (value != null) {
                            // relacion.replace(c, value + entry.getValue());
                        } else {
                            relacion.put(c, entry.getValue());
                        }
                    }
                    if (factura.getEstado() == Factura.Estado.devuelta) {
                        if (value != null) {
                            //  relacion.replace(c, value - entry.getValue());
                        }
                    }
                }
            }
        }
    }

    public Factura getFacturaByTransaction(Integer trasnsaccion) {

        for (Factura factura : facturas) {
            if (factura.getTransaccion().equals(trasnsaccion)) {
                return factura;
            }
        }
        return null;
    }

    public void prepareAll() {
        limpiarFacturas();
        generateRelation();
    }

//    public void addFactura() {
//        addFactura(new Factura(getLastFactura().getUsuario()));
//    }
    @Override
    public String toString() {
        String rsl = "Inventario Diario\n";
        rsl += "Fecha : " + fecha + "\n";
        for (int i = 0; i < facturas.size(); i++) {
            Factura factura = facturas.get(i);
            rsl += "Factura : " + (i + 1) + "\n";
            rsl += factura.toString() + "\n\n";
        }
        rsl += "Total sin IVA : " + JavaUtil.dosDecimales.format(totalSinIva).replace(",", ".") + "\tTotal con IVA : "
                + JavaUtil.dosDecimales.format(totalConIva).replace(",", ".");

        rsl += "\n\n\n";
        for (Map.Entry<Integer, Integer> entry : relacion.entrySet()) {
            rsl += entry.getKey() + "\t" + entry.getValue() + "\n";
        }
        return rsl;
    }

}
