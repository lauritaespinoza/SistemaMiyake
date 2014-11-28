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
public class InventarioTiendaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto", nullable = false)
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_almacen", nullable = false)
    private int idAlmacen;

    public InventarioTiendaPK() {
    }

    public InventarioTiendaPK(int idProducto, int idAlmacen) {
        this.idProducto = idProducto;
        this.idAlmacen = idAlmacen;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idAlmacen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioTiendaPK)) {
            return false;
        }
        InventarioTiendaPK other = (InventarioTiendaPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idAlmacen != other.idAlmacen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.InventarioTiendaPK[ idProducto=" + idProducto + ", idAlmacen=" + idAlmacen + " ]";
    }
    
}
