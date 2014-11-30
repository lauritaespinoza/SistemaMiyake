/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

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
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Factura.findByNroFactura", query = "SELECT f FROM Factura f WHERE f.nroFactura = :nroFactura"),
    @NamedQuery(name = "Factura.findByFechaEmision", query = "SELECT f FROM Factura f WHERE f.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Factura.findByTotalFactura", query = "SELECT f FROM Factura f WHERE f.totalFactura = :totalFactura"),
    @NamedQuery(name = "Factura.findByRecibidoPor", query = "SELECT f FROM Factura f WHERE f.recibidoPor = :recibidoPor"),
    @NamedQuery(name = "Factura.findByRutaArchivo", query = "SELECT f FROM Factura f WHERE f.rutaArchivo = :rutaArchivo"),
    @NamedQuery(name = "Factura.findByEmbarcadoVia", query = "SELECT f FROM Factura f WHERE f.embarcadoVia = :embarcadoVia")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura", nullable = false)
    private Integer idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_factura", nullable = false)
    private int nroFactura;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_factura", nullable = false)
    private float totalFactura;
    @Size(max = 2147483647)
    @Column(name = "recibido_por", length = 2147483647)
    private String recibidoPor;
    @Size(max = 2147483647)
    @Column(name = "ruta_archivo", length = 2147483647)
    private String rutaArchivo;
    @Size(max = 2147483647)
    @Column(name = "embarcado_via", length = 2147483647)
    private String embarcadoVia;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne
    private Proveedor idProveedor;
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen")
    @ManyToOne
    private Almacen idAlmacen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private Collection<EntradaProveedor> entradaProveedorCollection;
    @OneToMany(mappedBy = "idFactura")
    private Collection<ConteoMercanciaEntrada> conteoMercanciaEntradaCollection;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(Integer idFactura, int nroFactura, float totalFactura) {
        this.idFactura = idFactura;
        this.nroFactura = nroFactura;
        this.totalFactura = totalFactura;
    }

     public Factura(int nroFactura, Date fechaEmision, float totalFactura, String recibidoPor, String rutaArchivo, String embarcadoVia, Almacen idAlmacen, Proveedor idProveedor) {
        this.nroFactura = nroFactura;
        this.fechaEmision = fechaEmision;
        this.totalFactura = totalFactura;
        this.recibidoPor = recibidoPor;
        this.rutaArchivo = rutaArchivo;
        this.embarcadoVia = embarcadoVia;
        this.idAlmacen = idAlmacen;
        this.idProveedor = idProveedor;
    }
     
    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public float getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(float totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getRecibidoPor() {
        return recibidoPor;
    }

    public void setRecibidoPor(String recibidoPor) {
        this.recibidoPor = recibidoPor;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getEmbarcadoVia() {
        return embarcadoVia;
    }

    public void setEmbarcadoVia(String embarcadoVia) {
        this.embarcadoVia = embarcadoVia;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Almacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Almacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @XmlTransient
    public Collection<EntradaProveedor> getEntradaProveedorCollection() {
        return entradaProveedorCollection;
    }

    public void setEntradaProveedorCollection(Collection<EntradaProveedor> entradaProveedorCollection) {
        this.entradaProveedorCollection = entradaProveedorCollection;
    }

    @XmlTransient
    public Collection<ConteoMercanciaEntrada> getConteoMercanciaEntradaCollection() {
        return conteoMercanciaEntradaCollection;
    }

    public void setConteoMercanciaEntradaCollection(Collection<ConteoMercanciaEntrada> conteoMercanciaEntradaCollection) {
        this.conteoMercanciaEntradaCollection = conteoMercanciaEntradaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
