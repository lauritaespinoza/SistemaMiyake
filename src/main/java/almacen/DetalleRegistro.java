/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;

import java.util.ArrayList;
import java.util.List;
import modelos.EntradaProveedor;
import modelos.InventarioTienda;
import modelos.Producto;
import modelos.SalidaParaTiendaDetalle;

/**
 *
 * @author Miyake
 */
public class DetalleRegistro {

    //private boolean bandera;
    private int conteoFaltante = 0;
    private Float totalFaltante = 0f;
    private int bulto = 1;
    //private int codigoProducto;
    private Integer cantidad;
    //private String descripcion;
    private int renglon;

    private EntradaProveedor ep;
    public InventarioTienda inv;
    private SalidaParaTiendaDetalle sd;

    public DetalleRegistro() {
    }

    public SalidaParaTiendaDetalle getSd() {
        return sd;
    }

    public void setSd(SalidaParaTiendaDetalle sd) {
        this.sd = sd;
    }

    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

//    public boolean isBandera() {
//        return bandera;
//    }
//
//    public void setBandera(boolean bandera) {
//        this.bandera = bandera;
//    }

    public int getConteoFaltante() {
        return conteoFaltante;
    }

    public void setConteoFaltante(int conteoFaltante) {
        this.conteoFaltante = conteoFaltante;
    }

    public Float getTotalFaltante() {
        return totalFaltante;
    }

    public void setTotalFaltante(Float totalFaltante) {
        this.totalFaltante = totalFaltante;
    }

    public int getBulto() {
        return bulto;
    }

    public void setBulto(int bulto) {
        this.bulto = bulto;
    }

//    public int getCodigoProducto() {
//        return codigoProducto;
//    }
//
//    public void setCodigoProducto(int codigoProducto) {
//        this.codigoProducto = codigoProducto;
//    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

//    public String getDescripcion() {
//        return descripcion;
//    }
//
//    public void setDescripcion(String descripcion) {
//        this.descripcion = descripcion;
//    }

    public EntradaProveedor getEp() {
        return ep;
    }

    public void setEp(EntradaProveedor ep) {
        this.ep = ep;
    }

    public InventarioTienda getInv() {
        return inv;
    }

    public void setInv(InventarioTienda inv) {
        this.inv = inv;
    }

}
