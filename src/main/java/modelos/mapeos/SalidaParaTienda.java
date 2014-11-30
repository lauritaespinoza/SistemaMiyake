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
@Table(name = "salida_para_tienda", catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidaParaTienda.findAll", query = "SELECT s FROM SalidaParaTienda s"),
    @NamedQuery(name = "SalidaParaTienda.findByIdSalida", query = "SELECT s FROM SalidaParaTienda s WHERE s.idSalida = :idSalida"),
    @NamedQuery(name = "SalidaParaTienda.findByFechaAsignacion", query = "SELECT s FROM SalidaParaTienda s WHERE s.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "SalidaParaTienda.findByTotal", query = "SELECT s FROM SalidaParaTienda s WHERE s.total = :total"),
    @NamedQuery(name = "SalidaParaTienda.findByRevisado", query = "SELECT s FROM SalidaParaTienda s WHERE s.revisado = :revisado")})
public class SalidaParaTienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salida", nullable = false)
    private Integer idSalida;
    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 8, scale = 8)
    private Float total;
    private Boolean revisado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salidaParaTienda")
    private Collection<SalidaParaTiendaDetalle> salidaParaTiendaDetalleCollection;
    @JoinColumn(name = "id_usuario_2", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario2;
    @JoinColumn(name = "id_usuario_1", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario1;
    @JoinColumn(name = "id_almacen_hasta", referencedColumnName = "id_almacen")
    @ManyToOne
    private Almacen idAlmacenHasta;
    @JoinColumn(name = "id_almacen_desde", referencedColumnName = "id_almacen")
    @ManyToOne
    private Almacen idAlmacenDesde;

    public SalidaParaTienda() {
    }

    public SalidaParaTienda(Almacen idAlmacenDesde, Almacen idAlmacenHasta, Usuario idUsuario1, Usuario idUsuario2) {
        this.idAlmacenDesde = idAlmacenDesde;
        this.idAlmacenHasta = idAlmacenHasta;
        this.idUsuario1 = idUsuario1;
        this.idUsuario2 = idUsuario2;
    }

    public SalidaParaTienda(Integer idSalida) {
        this.idSalida = idSalida;
    }

    public Integer getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(Integer idSalida) {
        this.idSalida = idSalida;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Boolean getRevisado() {
        return revisado;
    }

    public void setRevisado(Boolean revisado) {
        this.revisado = revisado;
    }

    @XmlTransient
    public Collection<SalidaParaTiendaDetalle> getSalidaParaTiendaDetalleCollection() {
        return salidaParaTiendaDetalleCollection;
    }

    public void setSalidaParaTiendaDetalleCollection(Collection<SalidaParaTiendaDetalle> salidaParaTiendaDetalleCollection) {
        this.salidaParaTiendaDetalleCollection = salidaParaTiendaDetalleCollection;
    }

    public Usuario getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Usuario idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public Usuario getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Usuario idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Almacen getIdAlmacenHasta() {
        return idAlmacenHasta;
    }

    public void setIdAlmacenHasta(Almacen idAlmacenHasta) {
        this.idAlmacenHasta = idAlmacenHasta;
    }

    public Almacen getIdAlmacenDesde() {
        return idAlmacenDesde;
    }

    public void setIdAlmacenDesde(Almacen idAlmacenDesde) {
        this.idAlmacenDesde = idAlmacenDesde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalida != null ? idSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaParaTienda)) {
            return false;
        }
        SalidaParaTienda other = (SalidaParaTienda) object;
        if ((this.idSalida == null && other.idSalida != null) || (this.idSalida != null && !this.idSalida.equals(other.idSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.SalidaParaTienda[ idSalida=" + idSalida + " ]";
    }

}
