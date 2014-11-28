/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByReferenciaProducto", query = "SELECT p FROM Producto p WHERE p.referenciaProducto = :referenciaProducto"),
    @NamedQuery(name = "Producto.findByPrecioOriginal", query = "SELECT p FROM Producto p WHERE p.precioOriginal = :precioOriginal"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByPrimeraActividad", query = "SELECT p FROM Producto p WHERE p.primeraActividad = :primeraActividad"),
    @NamedQuery(name = "Producto.findByUltimaActividad", query = "SELECT p FROM Producto p WHERE p.ultimaActividad = :ultimaActividad")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "referencia_producto", length = 2147483647)
    private String referenciaProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_original", precision = 8, scale = 8)
    private Float precioOriginal;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;
    @Column(name = "primera_actividad")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primeraActividad;
    @Column(name = "ultima_actividad")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaActividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<InventarioTienda> inventarioTiendaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<SalidaParaTiendaDetalle> salidaParaTiendaDetalleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<ConteoMercanciaEntradaDetalles> conteoMercanciaEntradaDetallesCollection;
    @OneToMany(mappedBy = "idProducto")
    private Collection<EntradaProveedor> entradaProveedorCollection;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne
    private Proveedor idProveedor;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne
    private Marca idMarca;
    @JoinColumn(name = "id_clasificacion", referencedColumnName = "id_clasificacion")
    @ManyToOne
    private Clasificacion idClasificacion;
    @OneToMany(mappedBy = "idProducto")
    private Collection<NotaCreditoDebitoDetalle> notaCreditoDebitoDetalleCollection;

    public Producto() {
    }
    
    public Producto(String descripcion, String referenciaProducto,  Float precioOriginal, Clasificacion idClasificacion, Marca idMarca, Proveedor idProveedor) {
        this.descripcion = descripcion;
        this.referenciaProducto = referenciaProducto;
        this.precioOriginal = precioOriginal;
        this.idClasificacion = idClasificacion;
        this.idMarca = idMarca;
        this.idProveedor = idProveedor;
        this.primeraActividad = new Date();
    }

    public Producto(String descripcion, String referenciaProducto, Float precioOriginal, Proveedor idProveedor) {
        this.descripcion = descripcion;
        this.referenciaProducto = referenciaProducto;
        this.precioOriginal = precioOriginal;
        this.idProveedor = idProveedor;
    }
    
    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferenciaProducto() {
        return referenciaProducto;
    }

    public void setReferenciaProducto(String referenciaProducto) {
        this.referenciaProducto = referenciaProducto;
    }

    public Float getPrecioOriginal() {
        return precioOriginal;
    }

    public void setPrecioOriginal(Float precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Date getPrimeraActividad() {
        return primeraActividad;
    }

    public void setPrimeraActividad(Date primeraActividad) {
        this.primeraActividad = primeraActividad;
    }

    public Date getUltimaActividad() {
        return ultimaActividad;
    }

    public void setUltimaActividad(Date ultimaActividad) {
        this.ultimaActividad = ultimaActividad;
    }

    @XmlTransient
    public Collection<InventarioTienda> getInventarioTiendaCollection() {
        return inventarioTiendaCollection;
    }

    public void setInventarioTiendaCollection(Collection<InventarioTienda> inventarioTiendaCollection) {
        this.inventarioTiendaCollection = inventarioTiendaCollection;
    }

    @XmlTransient
    public Collection<SalidaParaTiendaDetalle> getSalidaParaTiendaDetalleCollection() {
        return salidaParaTiendaDetalleCollection;
    }

    public void setSalidaParaTiendaDetalleCollection(Collection<SalidaParaTiendaDetalle> salidaParaTiendaDetalleCollection) {
        this.salidaParaTiendaDetalleCollection = salidaParaTiendaDetalleCollection;
    }

    @XmlTransient
    public Collection<ConteoMercanciaEntradaDetalles> getConteoMercanciaEntradaDetallesCollection() {
        return conteoMercanciaEntradaDetallesCollection;
    }

    public void setConteoMercanciaEntradaDetallesCollection(Collection<ConteoMercanciaEntradaDetalles> conteoMercanciaEntradaDetallesCollection) {
        this.conteoMercanciaEntradaDetallesCollection = conteoMercanciaEntradaDetallesCollection;
    }

    @XmlTransient
    public Collection<EntradaProveedor> getEntradaProveedorCollection() {
        return entradaProveedorCollection;
    }

    public void setEntradaProveedorCollection(Collection<EntradaProveedor> entradaProveedorCollection) {
        this.entradaProveedorCollection = entradaProveedorCollection;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public Clasificacion getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Clasificacion idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    @XmlTransient
    public Collection<NotaCreditoDebitoDetalle> getNotaCreditoDebitoDetalleCollection() {
        return notaCreditoDebitoDetalleCollection;
    }

    public void setNotaCreditoDebitoDetalleCollection(Collection<NotaCreditoDebitoDetalle> notaCreditoDebitoDetalleCollection) {
        this.notaCreditoDebitoDetalleCollection = notaCreditoDebitoDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
