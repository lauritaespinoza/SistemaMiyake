/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "precio_producto_tienda", catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrecioProductoTienda.findAll", query = "SELECT p FROM PrecioProductoTienda p"),
    @NamedQuery(name = "PrecioProductoTienda.findByIdPrecioProductoTienda", query = "SELECT p FROM PrecioProductoTienda p WHERE p.idPrecioProductoTienda = :idPrecioProductoTienda"),
    @NamedQuery(name = "PrecioProductoTienda.findByPrecio", query = "SELECT p FROM PrecioProductoTienda p WHERE p.precio = :precio"),
    @NamedQuery(name = "PrecioProductoTienda.findByDescuento", query = "SELECT p FROM PrecioProductoTienda p WHERE p.descuento = :descuento")})
public class PrecioProductoTienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_precio_producto_tienda", nullable = false)
    private Integer idPrecioProductoTienda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 8, scale = 8)
    private Float precio;
    @Column(precision = 8, scale = 8)
    private Float descuento;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen")
    @ManyToOne
    private Almacen idAlmacen;

    public PrecioProductoTienda() {
    }

    public PrecioProductoTienda(Integer idPrecioProductoTienda) {
        this.idPrecioProductoTienda = idPrecioProductoTienda;
    }

    public Integer getIdPrecioProductoTienda() {
        return idPrecioProductoTienda;
    }

    public void setIdPrecioProductoTienda(Integer idPrecioProductoTienda) {
        this.idPrecioProductoTienda = idPrecioProductoTienda;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Almacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Almacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecioProductoTienda != null ? idPrecioProductoTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioProductoTienda)) {
            return false;
        }
        PrecioProductoTienda other = (PrecioProductoTienda) object;
        if ((this.idPrecioProductoTienda == null && other.idPrecioProductoTienda != null) || (this.idPrecioProductoTienda != null && !this.idPrecioProductoTienda.equals(other.idPrecioProductoTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.PrecioProductoTienda[ idPrecioProductoTienda=" + idPrecioProductoTienda + " ]";
    }
    
}
