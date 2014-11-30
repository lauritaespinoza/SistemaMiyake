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
@Table(name = "nota_credito_debito", catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaCreditoDebito.findAll", query = "SELECT n FROM NotaCreditoDebito n"),
    @NamedQuery(name = "NotaCreditoDebito.findByIdNotaCreditoDebito", query = "SELECT n FROM NotaCreditoDebito n WHERE n.idNotaCreditoDebito = :idNotaCreditoDebito"),
    @NamedQuery(name = "NotaCreditoDebito.findByFecha", query = "SELECT n FROM NotaCreditoDebito n WHERE n.fecha = :fecha"),
    @NamedQuery(name = "NotaCreditoDebito.findByNroFactura", query = "SELECT n FROM NotaCreditoDebito n WHERE n.nroFactura = :nroFactura"),
    @NamedQuery(name = "NotaCreditoDebito.findByTotal", query = "SELECT n FROM NotaCreditoDebito n WHERE n.total = :total"),
    @NamedQuery(name = "NotaCreditoDebito.findByTipo", query = "SELECT n FROM NotaCreditoDebito n WHERE n.tipo = :tipo")})
public class NotaCreditoDebito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota_credito_debito", nullable = false)
    private Integer idNotaCreditoDebito;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "nro_factura")
    private Integer nroFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 8, scale = 8)
    private Float total;
    private Boolean tipo;
    @OneToMany(mappedBy = "idNotaCreditoDebito")
    private Collection<NotaCreditoDebitoDetalle> notaCreditoDebitoDetalleCollection;
    @JoinColumn(name = "id_usuario2", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario2;
    @JoinColumn(name = "id_usuario1", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario1;
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen")
    @ManyToOne
    private Almacen idAlmacen;

    public NotaCreditoDebito() {
    }

    public NotaCreditoDebito(Integer idNotaCreditoDebito) {
        this.idNotaCreditoDebito = idNotaCreditoDebito;
    }

    public Integer getIdNotaCreditoDebito() {
        return idNotaCreditoDebito;
    }

    public void setIdNotaCreditoDebito(Integer idNotaCreditoDebito) {
        this.idNotaCreditoDebito = idNotaCreditoDebito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Integer nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<NotaCreditoDebitoDetalle> getNotaCreditoDebitoDetalleCollection() {
        return notaCreditoDebitoDetalleCollection;
    }

    public void setNotaCreditoDebitoDetalleCollection(Collection<NotaCreditoDebitoDetalle> notaCreditoDebitoDetalleCollection) {
        this.notaCreditoDebitoDetalleCollection = notaCreditoDebitoDetalleCollection;
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

    public Almacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Almacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaCreditoDebito != null ? idNotaCreditoDebito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCreditoDebito)) {
            return false;
        }
        NotaCreditoDebito other = (NotaCreditoDebito) object;
        if ((this.idNotaCreditoDebito == null && other.idNotaCreditoDebito != null) || (this.idNotaCreditoDebito != null && !this.idNotaCreditoDebito.equals(other.idNotaCreditoDebito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.NotaCreditoDebito[ idNotaCreditoDebito=" + idNotaCreditoDebito + " ]";
    }
    
}
