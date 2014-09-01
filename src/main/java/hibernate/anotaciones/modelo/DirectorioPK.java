/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.anotaciones.modelo;

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
public class DirectorioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contacto1")
    private int idContacto1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contacto2")
    private int idContacto2;

    public DirectorioPK() {
    }

    public DirectorioPK(int idContacto1, int idContacto2) {
        this.idContacto1 = idContacto1;
        this.idContacto2 = idContacto2;
    }

    public int getIdContacto1() {
        return idContacto1;
    }

    public void setIdContacto1(int idContacto1) {
        this.idContacto1 = idContacto1;
    }

    public int getIdContacto2() {
        return idContacto2;
    }

    public void setIdContacto2(int idContacto2) {
        this.idContacto2 = idContacto2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idContacto1;
        hash += (int) idContacto2;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DirectorioPK)) {
            return false;
        }
        DirectorioPK other = (DirectorioPK) object;
        if (this.idContacto1 != other.idContacto1) {
            return false;
        }
        if (this.idContacto2 != other.idContacto2) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.anotaciones.modelo.DirectorioPK[ idContacto1=" + idContacto1 + ", idContacto2=" + idContacto2 + " ]";
    }
    
}
