/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

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
@Table(name = "conteo_mercancia_entrada_detalles", catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConteoMercanciaEntradaDetalles.findAll", query = "SELECT c FROM ConteoMercanciaEntradaDetalles c"),
    @NamedQuery(name = "ConteoMercanciaEntradaDetalles.findByConteoFaltante", query = "SELECT c FROM ConteoMercanciaEntradaDetalles c WHERE c.conteoFaltante = :conteoFaltante"),
    @NamedQuery(name = "ConteoMercanciaEntradaDetalles.findByTotalFaltante", query = "SELECT c FROM ConteoMercanciaEntradaDetalles c WHERE c.totalFaltante = :totalFaltante"),
    @NamedQuery(name = "ConteoMercanciaEntradaDetalles.findByIdProducto", query = "SELECT c FROM ConteoMercanciaEntradaDetalles c WHERE c.conteoMercanciaEntradaDetallesPK.idProducto = :idProducto"),
    @NamedQuery(name = "ConteoMercanciaEntradaDetalles.findByNroBulto", query = "SELECT c FROM ConteoMercanciaEntradaDetalles c WHERE c.nroBulto = :nroBulto"),
    @NamedQuery(name = "ConteoMercanciaEntradaDetalles.findByCantidad", query = "SELECT c FROM ConteoMercanciaEntradaDetalles c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "ConteoMercanciaEntradaDetalles.findByIdConteoMercanciaEntrada", query = "SELECT c FROM ConteoMercanciaEntradaDetalles c WHERE c.conteoMercanciaEntradaDetallesPK.idConteoMercanciaEntrada = :idConteoMercanciaEntrada")})
public class ConteoMercanciaEntradaDetalles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConteoMercanciaEntradaDetallesPK conteoMercanciaEntradaDetallesPK;
    @Column(name = "conteo_faltante")
    private Integer conteoFaltante;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_faltante", precision = 8, scale = 8)
    private Float totalFaltante;
    @Column(name = "nro_bulto")
    private Integer nroBulto;
    private Integer cantidad;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "id_conteo_mercancia_entrada", referencedColumnName = "id_conteo_mercancia_entrada", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ConteoMercanciaEntrada conteoMercanciaEntrada;

    public ConteoMercanciaEntradaDetalles() {
    }

    public ConteoMercanciaEntradaDetalles(ConteoMercanciaEntradaDetallesPK conteoMercanciaEntradaDetallesPK, Integer nroBulto, Integer cantidad, ConteoMercanciaEntrada conteoMercanciaEntrada, Producto producto) {
        this.conteoMercanciaEntradaDetallesPK = conteoMercanciaEntradaDetallesPK;
        this.nroBulto = nroBulto;
        this.cantidad = cantidad;
        this.conteoMercanciaEntrada = conteoMercanciaEntrada;
        this.producto = producto;
    }

    public ConteoMercanciaEntradaDetalles(ConteoMercanciaEntradaDetallesPK conteoMercanciaEntradaDetallesPK, int conteoFaltante, Float totalFaltante, Integer nroBulto, Integer cantidad, ConteoMercanciaEntrada conteoMercanciaEntrada, Producto producto) {
        this.conteoMercanciaEntradaDetallesPK = conteoMercanciaEntradaDetallesPK;
        this.conteoFaltante = conteoFaltante;
        this.totalFaltante = totalFaltante;
        this.nroBulto = nroBulto;
        this.cantidad = cantidad;
        this.conteoMercanciaEntrada = conteoMercanciaEntrada;
        this.producto = producto;
    }

    public ConteoMercanciaEntradaDetalles(ConteoMercanciaEntradaDetallesPK conteoMercanciaEntradaDetallesPK) {
        this.conteoMercanciaEntradaDetallesPK = conteoMercanciaEntradaDetallesPK;
    }

    public ConteoMercanciaEntradaDetalles(int idProducto, int idConteoMercanciaEntrada) {
        this.conteoMercanciaEntradaDetallesPK = new ConteoMercanciaEntradaDetallesPK(idProducto, idConteoMercanciaEntrada);
    }

    public ConteoMercanciaEntradaDetallesPK getConteoMercanciaEntradaDetallesPK() {
        return conteoMercanciaEntradaDetallesPK;
    }

    public void setConteoMercanciaEntradaDetallesPK(ConteoMercanciaEntradaDetallesPK conteoMercanciaEntradaDetallesPK) {
        this.conteoMercanciaEntradaDetallesPK = conteoMercanciaEntradaDetallesPK;
    }

    public Integer getConteoFaltante() {
        return conteoFaltante;
    }

    public void setConteoFaltante(Integer conteoFaltante) {
        this.conteoFaltante = conteoFaltante;
    }

    public Float getTotalFaltante() {
        return totalFaltante;
    }

    public void setTotalFaltante(Float totalFaltante) {
        this.totalFaltante = totalFaltante;
    }

    public Integer getNroBulto() {
        return nroBulto;
    }

    public void setNroBulto(Integer nroBulto) {
        this.nroBulto = nroBulto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ConteoMercanciaEntrada getConteoMercanciaEntrada() {
        return conteoMercanciaEntrada;
    }

    public void setConteoMercanciaEntrada(ConteoMercanciaEntrada conteoMercanciaEntrada) {
        this.conteoMercanciaEntrada = conteoMercanciaEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conteoMercanciaEntradaDetallesPK != null ? conteoMercanciaEntradaDetallesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConteoMercanciaEntradaDetalles)) {
            return false;
        }
        ConteoMercanciaEntradaDetalles other = (ConteoMercanciaEntradaDetalles) object;
        if ((this.conteoMercanciaEntradaDetallesPK == null && other.conteoMercanciaEntradaDetallesPK != null) || (this.conteoMercanciaEntradaDetallesPK != null && !this.conteoMercanciaEntradaDetallesPK.equals(other.conteoMercanciaEntradaDetallesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.ConteoMercanciaEntradaDetalles[ conteoMercanciaEntradaDetallesPK=" + conteoMercanciaEntradaDetallesPK + " ]";
    }

}
