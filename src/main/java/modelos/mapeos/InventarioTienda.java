/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

import modelos.mapeos.Almacen;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "inventario_tienda", catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioTienda.findAll", query = "SELECT i FROM InventarioTienda i"),
    @NamedQuery(name = "InventarioTienda.findByIdProducto", query = "SELECT i FROM InventarioTienda i WHERE i.inventarioTiendaPK.idProducto = :idProducto"),
    @NamedQuery(name = "InventarioTienda.findByIdAlmacen", query = "SELECT i FROM InventarioTienda i WHERE i.inventarioTiendaPK.idAlmacen = :idAlmacen"),
    @NamedQuery(name = "InventarioTienda.findByCantidad", query = "SELECT i FROM InventarioTienda i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "InventarioTienda.findByPrecioConDescuento", query = "SELECT i FROM InventarioTienda i WHERE i.precioConDescuento = :precioConDescuento"),
    @NamedQuery(name = "InventarioTienda.findByDescuento", query = "SELECT i FROM InventarioTienda i WHERE i.descuento = :descuento"),
    @NamedQuery(name = "InventarioTienda.findByFechaCreacion", query = "SELECT i FROM InventarioTienda i WHERE i.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "InventarioTienda.findByFechaModificacion", query = "SELECT i FROM InventarioTienda i WHERE i.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "InventarioTienda.findByPrecioSinDescuento", query = "SELECT i FROM InventarioTienda i WHERE i.precioSinDescuento = :precioSinDescuento")})
public class InventarioTienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventarioTiendaPK inventarioTiendaPK;
    private Boolean asignado;
    private Integer cantidad;
    private Integer procesado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_con_descuento", precision = 8, scale = 8)
    private Float precioConDescuento;
    private Integer descuento;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion = Calendar.getInstance().getTime();
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "precio_sin_descuento", precision = 8, scale = 8)
    private Float precioSinDescuento;
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Almacen almacen;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public InventarioTienda() {
    }

    public InventarioTienda(InventarioTiendaPK inventarioTiendaPK) {
        this.inventarioTiendaPK = inventarioTiendaPK;
    }

    public InventarioTienda(int idProducto, int idAlmacen) {
        this.inventarioTiendaPK = new InventarioTiendaPK(idProducto, idAlmacen);
    }

    public InventarioTienda(InventarioTiendaPK inventarioTiendaPK, Integer cantidad, Almacen almacen, Producto producto) {
        this.inventarioTiendaPK = inventarioTiendaPK;
        this.cantidad = cantidad;
        this.almacen = almacen;
        this.producto = producto;
    }

    public InventarioTiendaPK getInventarioTiendaPK() {
        return inventarioTiendaPK;
    }

    public void setInventarioTiendaPK(InventarioTiendaPK inventarioTiendaPK) {
        this.inventarioTiendaPK = inventarioTiendaPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecioConDescuento() {
        return precioConDescuento;
    }

    public void setPrecioConDescuento(Float precioConDescuento) {
        this.precioConDescuento = precioConDescuento;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Float getPrecioSinDescuento() {
        return precioSinDescuento;
    }

    public void setPrecioSinDescuento(Float precioSinDescuento) {
        this.precioSinDescuento = precioSinDescuento;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Boolean getAsignado() {
        return asignado;
    }

    public void setAsignado(Boolean asignado) {
        this.asignado = asignado;
    }

    public Integer getProcesado() {
        return procesado;
    }

    public void setProcesado(Integer procesado) {
        this.procesado = procesado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioTiendaPK != null ? inventarioTiendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioTienda)) {
            return false;
        }
        InventarioTienda other = (InventarioTienda) object;
        if ((this.inventarioTiendaPK == null && other.inventarioTiendaPK != null) || (this.inventarioTiendaPK != null && !this.inventarioTiendaPK.equals(other.inventarioTiendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.mapeos.nev.InventarioTienda[ inventarioTiendaPK=" + inventarioTiendaPK + " ]";
    }

}
