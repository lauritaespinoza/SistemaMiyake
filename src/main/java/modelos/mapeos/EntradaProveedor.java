/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "entrada_proveedor", catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntradaProveedor.findAll", query = "SELECT e FROM EntradaProveedor e"),
    @NamedQuery(name = "EntradaProveedor.findByIdEntradaProveedor", query = "SELECT e FROM EntradaProveedor e WHERE e.idEntradaProveedor = :idEntradaProveedor"),
    @NamedQuery(name = "EntradaProveedor.findByPesoTotalBulto", query = "SELECT e FROM EntradaProveedor e WHERE e.pesoTotalBulto = :pesoTotalBulto"),
    @NamedQuery(name = "EntradaProveedor.findByCantidadSet", query = "SELECT e FROM EntradaProveedor e WHERE e.cantidadSet = :cantidadSet"),
    @NamedQuery(name = "EntradaProveedor.findByCantidadProducto", query = "SELECT e FROM EntradaProveedor e WHERE e.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "EntradaProveedor.findByPrecioTotal", query = "SELECT e FROM EntradaProveedor e WHERE e.precioTotal = :precioTotal"),
    @NamedQuery(name = "EntradaProveedor.findByCodBarras", query = "SELECT e FROM EntradaProveedor e WHERE e.codBarras = :codBarras"),
    @NamedQuery(name = "EntradaProveedor.findByEstatus", query = "SELECT e FROM EntradaProveedor e WHERE e.estatus = :estatus"),
    @NamedQuery(name = "EntradaProveedor.findByFechaRecepcion", query = "SELECT e FROM EntradaProveedor e WHERE e.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "EntradaProveedor.findByNroBulto", query = "SELECT e FROM EntradaProveedor e WHERE e.nroBulto = :nroBulto")})
public class EntradaProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entrada_proveedor", nullable = false)
    private Integer idEntradaProveedor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_total_bulto", precision = 8, scale = 8)
    private Float pesoTotalBulto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_set", nullable = false)
    private int cantidadSet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_producto", nullable = false)
    private int cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_total", nullable = false)
    private float precioTotal;
    @Size(max = 2147483647)
    @Column(name = "cod_barras", length = 2147483647)
    private String codBarras;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String estatus = "Pendiente";
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_recepcion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion = Calendar.getInstance().getTime();
    @Column(name = "nro_bulto")
    private Integer nroBulto;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura", nullable = false)
    @ManyToOne(optional = false)
    private Factura idFactura;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto idProducto;

    public EntradaProveedor() {
    }

    public EntradaProveedor(Integer idEntradaProveedor) {
        this.idEntradaProveedor = idEntradaProveedor;
    }

    public EntradaProveedor(Integer idEntradaProveedor, int cantidadSet, int cantidadProducto, float precioTotal, Date fechaRecepcion) {
        this.idEntradaProveedor = idEntradaProveedor;
        this.cantidadSet = cantidadSet;
        this.cantidadProducto = cantidadProducto;
        this.precioTotal = precioTotal;
        this.fechaRecepcion = fechaRecepcion;
    }

    public EntradaProveedor(Float pesoTotalBulto, int cantidadSet, int cantidadProducto, float precioTotal, String codBarras, Integer nroBulto, Factura idFactura, Producto idProducto) {
        this.pesoTotalBulto = pesoTotalBulto;
        this.cantidadSet = cantidadSet;
        this.cantidadProducto = cantidadProducto;
        this.precioTotal = precioTotal;
        this.codBarras = codBarras;
        this.nroBulto = nroBulto;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
    }

    public Integer getIdEntradaProveedor() {
        return idEntradaProveedor;
    }

    public void setIdEntradaProveedor(Integer idEntradaProveedor) {
        this.idEntradaProveedor = idEntradaProveedor;
    }

    public Float getPesoTotalBulto() {
        return pesoTotalBulto;
    }

    public void setPesoTotalBulto(Float pesoTotalBulto) {
        this.pesoTotalBulto = pesoTotalBulto;
    }

    public int getCantidadSet() {
        return cantidadSet;
    }

    public void setCantidadSet(int cantidadSet) {
        this.cantidadSet = cantidadSet;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Integer getNroBulto() {
        return nroBulto;
    }

    public void setNroBulto(Integer nroBulto) {
        this.nroBulto = nroBulto;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntradaProveedor != null ? idEntradaProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaProveedor)) {
            return false;
        }
        EntradaProveedor other = (EntradaProveedor) object;
        if ((this.idEntradaProveedor == null && other.idEntradaProveedor != null) || (this.idEntradaProveedor != null && !this.idEntradaProveedor.equals(other.idEntradaProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.mapeos.nev.EntradaProveedor[ idEntradaProveedor=" + idEntradaProveedor + " ]";
    }

}
