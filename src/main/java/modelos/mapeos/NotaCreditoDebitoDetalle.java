/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "nota_credito_debito_detalle", catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaCreditoDebitoDetalle.findAll", query = "SELECT n FROM NotaCreditoDebitoDetalle n"),
    @NamedQuery(name = "NotaCreditoDebitoDetalle.findByCantidadProducto", query = "SELECT n FROM NotaCreditoDebitoDetalle n WHERE n.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "NotaCreditoDebitoDetalle.findByIdNotaCreditoDebitoDetalle", query = "SELECT n FROM NotaCreditoDebitoDetalle n WHERE n.idNotaCreditoDebitoDetalle = :idNotaCreditoDebitoDetalle"),
    @NamedQuery(name = "NotaCreditoDebitoDetalle.findByNroRenglon", query = "SELECT n FROM NotaCreditoDebitoDetalle n WHERE n.nroRenglon = :nroRenglon"),
 @NamedQuery(name = "NotaCreditoDebitoDetalle.findByObservacion", query = "SELECT n FROM NotaCreditoDebitoDetalle n WHERE n.observacion = :observacion")})
public class NotaCreditoDebitoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "cantidad_producto")
    private Integer cantidadProducto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota_credito_debito_detalle", nullable = false)
    private Integer idNotaCreditoDebitoDetalle;
    @Column(name = "nro_renglon")
    private Integer nroRenglon;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String observacion;
    @JoinColumn(name = "id_nota_credito_debito", referencedColumnName = "id_nota_credito_debito")
    @ManyToOne
    private NotaCreditoDebito idNotaCreditoDebito;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto idProducto;

    public NotaCreditoDebitoDetalle() {
    }

    public NotaCreditoDebitoDetalle(Integer idNotaCreditoDebitoDetalle) {
        this.idNotaCreditoDebitoDetalle = idNotaCreditoDebitoDetalle;
    }

    public NotaCreditoDebitoDetalle(Integer nroRenglon, NotaCreditoDebito idNotaCreditoDebito, Producto idProducto) {
        this.nroRenglon = nroRenglon;
        this.idNotaCreditoDebito = idNotaCreditoDebito;
        this.idProducto = idProducto;
    }

    public NotaCreditoDebitoDetalle(Integer cantidadProducto, Integer nroRenglon, NotaCreditoDebito idNotaCreditoDebito, Producto idProducto) {
        this.cantidadProducto = cantidadProducto;
        this.nroRenglon = nroRenglon;
        this.idNotaCreditoDebito = idNotaCreditoDebito;
        this.idProducto = idProducto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Integer getIdNotaCreditoDebitoDetalle() {
        return idNotaCreditoDebitoDetalle;
    }

    public void setIdNotaCreditoDebitoDetalle(Integer idNotaCreditoDebitoDetalle) {
        this.idNotaCreditoDebitoDetalle = idNotaCreditoDebitoDetalle;
    }

    public Integer getNroRenglon() {
        return nroRenglon;
    }

    public void setNroRenglon(Integer nroRenglon) {
        this.nroRenglon = nroRenglon;
    }

    public NotaCreditoDebito getIdNotaCreditoDebito() {
        return idNotaCreditoDebito;
    }

    public void setIdNotaCreditoDebito(NotaCreditoDebito idNotaCreditoDebito) {
        this.idNotaCreditoDebito = idNotaCreditoDebito;
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
        hash += (idNotaCreditoDebitoDetalle != null ? idNotaCreditoDebitoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCreditoDebitoDetalle)) {
            return false;
        }
        NotaCreditoDebitoDetalle other = (NotaCreditoDebitoDetalle) object;
        if ((this.idNotaCreditoDebitoDetalle == null && other.idNotaCreditoDebitoDetalle != null) || (this.idNotaCreditoDebitoDetalle != null && !this.idNotaCreditoDebitoDetalle.equals(other.idNotaCreditoDebitoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.mapeos.nev.NotaCreditoDebitoDetalle[ idNotaCreditoDebitoDetalle=" + idNotaCreditoDebitoDetalle + " ]";
    }

}
