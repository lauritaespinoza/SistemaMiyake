/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

import modelos.mapeos.SalidaParaTienda;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 8, scale = 8)
    private Float total;
    private Boolean tipo;
    @OneToMany(mappedBy = "idNotaCreditoDebito")
    private Collection<NotaCreditoDebitoDetalle> notaCreditoDebitoDetalleCollection;
    @JoinColumn(name = "id_salida", referencedColumnName = "id_salida")
    @ManyToOne
    private SalidaParaTienda idSalida;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario ;

    public NotaCreditoDebito() {
    }

    public NotaCreditoDebito(Integer idNotaCreditoDebito) {
        this.idNotaCreditoDebito = idNotaCreditoDebito;
    }

    public NotaCreditoDebito(Boolean tipo, SalidaParaTienda idSalida, Usuario idUsuario) {
        this.tipo = tipo;
        this.idSalida = idSalida;
        this.idUsuario = idUsuario;
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
        return "modelos.mapeos.nev.NotaCreditoDebito[ idNotaCreditoDebito=" + idNotaCreditoDebito + " ]";
    }

}
