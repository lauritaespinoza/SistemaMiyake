/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "salida_para_tienda_detalle", catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidaParaTiendaDetalle.findAll", query = "SELECT s FROM SalidaParaTiendaDetalle s"),
    @NamedQuery(name = "SalidaParaTiendaDetalle.findByIdProducto", query = "SELECT s FROM SalidaParaTiendaDetalle s WHERE s.salidaParaTiendaDetallePK.idProducto = :idProducto"),
    @NamedQuery(name = "SalidaParaTiendaDetalle.findByCantidadProducto", query = "SELECT s FROM SalidaParaTiendaDetalle s WHERE s.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "SalidaParaTiendaDetalle.findByNroBulto", query = "SELECT s FROM SalidaParaTiendaDetalle s WHERE s.nroBulto = :nroBulto"),
    @NamedQuery(name = "SalidaParaTiendaDetalle.findByIdSalida", query = "SELECT s FROM SalidaParaTiendaDetalle s WHERE s.salidaParaTiendaDetallePK.idSalida = :idSalida"),
    @NamedQuery(name = "SalidaParaTiendaDetalle.findByNroRenglon", query = "SELECT s FROM SalidaParaTiendaDetalle s WHERE s.nroRenglon = :nroRenglon")})
public class SalidaParaTiendaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalidaParaTiendaDetallePK salidaParaTiendaDetallePK;
    @Column(name = "cantidad_producto")
    private Integer cantidadProducto;
    @Column(name = "nro_bulto")
    private Integer nroBulto;
    @Column(name = "nro_renglon")
    private Integer nroRenglon;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "id_salida", referencedColumnName = "id_salida", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalidaParaTienda salidaParaTienda;

    public SalidaParaTiendaDetalle() {
    }

    public SalidaParaTiendaDetalle(SalidaParaTiendaDetallePK salidaParaTiendaDetallePK) {
        this.salidaParaTiendaDetallePK = salidaParaTiendaDetallePK;
    }

    public SalidaParaTiendaDetalle(SalidaParaTiendaDetallePK salidaParaTiendaDetallePK, Integer cantidadProducto, Integer nroBulto, Integer nroRenglon, Producto producto, SalidaParaTienda salidaParaTienda) {
        this.salidaParaTiendaDetallePK = salidaParaTiendaDetallePK;
        this.cantidadProducto = cantidadProducto;
        this.nroBulto = nroBulto;
        this.nroRenglon = nroRenglon;
        this.producto = producto;
        this.salidaParaTienda = salidaParaTienda;
    }

    public SalidaParaTiendaDetalle(int idProducto, int idSalida) {
        this.salidaParaTiendaDetallePK = new SalidaParaTiendaDetallePK(idProducto, idSalida);
    }

    public SalidaParaTiendaDetallePK getSalidaParaTiendaDetallePK() {
        return salidaParaTiendaDetallePK;
    }

    public void setSalidaParaTiendaDetallePK(SalidaParaTiendaDetallePK salidaParaTiendaDetallePK) {
        this.salidaParaTiendaDetallePK = salidaParaTiendaDetallePK;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Integer getNroBulto() {
        return nroBulto;
    }

    public void setNroBulto(Integer nroBulto) {
        this.nroBulto = nroBulto;
    }

    public Integer getNroRenglon() {
        return nroRenglon;
    }

    public void setNroRenglon(Integer nroRenglon) {
        this.nroRenglon = nroRenglon;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public SalidaParaTienda getSalidaParaTienda() {
        return salidaParaTienda;
    }

    public void setSalidaParaTienda(SalidaParaTienda salidaParaTienda) {
        this.salidaParaTienda = salidaParaTienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salidaParaTiendaDetallePK != null ? salidaParaTiendaDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaParaTiendaDetalle)) {
            return false;
        }
        SalidaParaTiendaDetalle other = (SalidaParaTiendaDetalle) object;
        if ((this.salidaParaTiendaDetallePK == null && other.salidaParaTiendaDetallePK != null) || (this.salidaParaTiendaDetallePK != null && !this.salidaParaTiendaDetallePK.equals(other.salidaParaTiendaDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.mapeos.nev.SalidaParaTiendaDetalle[ salidaParaTiendaDetallePK=" + salidaParaTiendaDetallePK + " ]";
    }

}
