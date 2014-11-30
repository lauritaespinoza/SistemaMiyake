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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "conteo_mercancia_entrada", catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConteoMercanciaEntrada.findAll", query = "SELECT c FROM ConteoMercanciaEntrada c"),
    @NamedQuery(name = "ConteoMercanciaEntrada.findByFecharegistro", query = "SELECT c FROM ConteoMercanciaEntrada c WHERE c.fecharegistro = :fecharegistro"),
    @NamedQuery(name = "ConteoMercanciaEntrada.findByTotalConteo", query = "SELECT c FROM ConteoMercanciaEntrada c WHERE c.totalConteo = :totalConteo"),
    @NamedQuery(name = "ConteoMercanciaEntrada.findByIdConteoMercanciaEntrada", query = "SELECT c FROM ConteoMercanciaEntrada c WHERE c.idConteoMercanciaEntrada = :idConteoMercanciaEntrada")})
public class ConteoMercanciaEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_conteo", precision = 8, scale = 8)
    private Float totalConteo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conteo_mercancia_entrada", nullable = false)
    private Integer idConteoMercanciaEntrada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conteoMercanciaEntrada")
    private Collection<ConteoMercanciaEntradaDetalles> conteoMercanciaEntradaDetallesCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    @ManyToOne
    private Factura idFactura;
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen")
    @ManyToOne
    private Almacen idAlmacen;
    @JoinColumn(name = "id_salida", referencedColumnName = "id_salida")
    @ManyToOne
    private SalidaParaTienda idSalida;

    public ConteoMercanciaEntrada() {
    }

    public ConteoMercanciaEntrada(Almacen idAlmacen, Factura idFactura, Usuario idUsuario) {
        this.idAlmacen = idAlmacen;
        this.idFactura = idFactura;
        this.idUsuario = idUsuario;
    }

    public ConteoMercanciaEntrada(Almacen idAlmacen, Usuario idUsuario, SalidaParaTienda idSalida) {
        this.idAlmacen = idAlmacen;
        this.idUsuario = idUsuario;
        this.idSalida = idSalida;
    }

    public ConteoMercanciaEntrada(Integer idConteoMercanciaEntrada) {
        this.idConteoMercanciaEntrada = idConteoMercanciaEntrada;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Float getTotalConteo() {
        return totalConteo;
    }

    public void setTotalConteo(Float totalConteo) {
        this.totalConteo = totalConteo;
    }

    public Integer getIdConteoMercanciaEntrada() {
        return idConteoMercanciaEntrada;
    }

    public void setIdConteoMercanciaEntrada(Integer idConteoMercanciaEntrada) {
        this.idConteoMercanciaEntrada = idConteoMercanciaEntrada;
    }

    @XmlTransient
    public Collection<ConteoMercanciaEntradaDetalles> getConteoMercanciaEntradaDetallesCollection() {
        return conteoMercanciaEntradaDetallesCollection;
    }

    public void setConteoMercanciaEntradaDetallesCollection(Collection<ConteoMercanciaEntradaDetalles> conteoMercanciaEntradaDetallesCollection) {
        this.conteoMercanciaEntradaDetallesCollection = conteoMercanciaEntradaDetallesCollection;
    }

    public SalidaParaTienda getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(SalidaParaTienda idSalida) {
        this.idSalida = idSalida;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
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
        hash += (idConteoMercanciaEntrada != null ? idConteoMercanciaEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConteoMercanciaEntrada)) {
            return false;
        }
        ConteoMercanciaEntrada other = (ConteoMercanciaEntrada) object;
        if ((this.idConteoMercanciaEntrada == null && other.idConteoMercanciaEntrada != null) || (this.idConteoMercanciaEntrada != null && !this.idConteoMercanciaEntrada.equals(other.idConteoMercanciaEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.ConteoMercanciaEntrada[ idConteoMercanciaEntrada=" + idConteoMercanciaEntrada + " ]";
    }

}
