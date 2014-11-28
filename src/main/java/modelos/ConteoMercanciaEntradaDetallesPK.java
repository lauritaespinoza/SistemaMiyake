/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
@Embeddable
public class ConteoMercanciaEntradaDetallesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto", nullable = false)
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_conteo_mercancia_entrada", nullable = false)
    private int idConteoMercanciaEntrada;

    public ConteoMercanciaEntradaDetallesPK() {
    }

    public ConteoMercanciaEntradaDetallesPK(int idProducto, int idConteoMercanciaEntrada) {
        this.idProducto = idProducto;
        this.idConteoMercanciaEntrada = idConteoMercanciaEntrada;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdConteoMercanciaEntrada() {
        return idConteoMercanciaEntrada;
    }

    public void setIdConteoMercanciaEntrada(int idConteoMercanciaEntrada) {
        this.idConteoMercanciaEntrada = idConteoMercanciaEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idConteoMercanciaEntrada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConteoMercanciaEntradaDetallesPK)) {
            return false;
        }
        ConteoMercanciaEntradaDetallesPK other = (ConteoMercanciaEntradaDetallesPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idConteoMercanciaEntrada != other.idConteoMercanciaEntrada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.ConteoMercanciaEntradaDetallesPK[ idProducto=" + idProducto + ", idConteoMercanciaEntrada=" + idConteoMercanciaEntrada + " ]";
    }
    
}
