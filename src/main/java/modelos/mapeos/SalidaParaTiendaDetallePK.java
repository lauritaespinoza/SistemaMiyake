/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

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
public class SalidaParaTiendaDetallePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto", nullable = false)
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_salida", nullable = false)
    private int idSalida;

    public SalidaParaTiendaDetallePK() {
    }

    public SalidaParaTiendaDetallePK(int idProducto, int idSalida) {
        this.idProducto = idProducto;
        this.idSalida = idSalida;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idSalida;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaParaTiendaDetallePK)) {
            return false;
        }
        SalidaParaTiendaDetallePK other = (SalidaParaTiendaDetallePK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idSalida != other.idSalida) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.mapeos.nev.SalidaParaTiendaDetallePK[ idProducto=" + idProducto + ", idSalida=" + idSalida + " ]";
    }
    
}
