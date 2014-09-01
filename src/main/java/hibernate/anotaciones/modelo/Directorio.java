/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.anotaciones.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "directorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Directorio.findAll", query = "SELECT d FROM Directorio d"),
    @NamedQuery(name = "Directorio.findByIdContacto1", query = "SELECT d FROM Directorio d WHERE d.directorioPK.idContacto1 = :idContacto1"),
    @NamedQuery(name = "Directorio.findByIdContacto2", query = "SELECT d FROM Directorio d WHERE d.directorioPK.idContacto2 = :idContacto2"),
    @NamedQuery(name = "Directorio.findByFechaConocido", query = "SELECT d FROM Directorio d WHERE d.fechaConocido = :fechaConocido")})
public class Directorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DirectorioPK directorioPK;
    @Column(name = "fecha_conocido")
    @Temporal(TemporalType.DATE)
    private Date fechaConocido;
    @JoinColumn(name = "id_contacto1", referencedColumnName = "id_contacto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contacto contacto;
    @JoinColumn(name = "id_contacto2", referencedColumnName = "id_contacto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contacto contacto1;

    public Directorio() {
    }

    public Directorio(DirectorioPK directorioPK) {
        this.directorioPK = directorioPK;
    }

    public Directorio(int idContacto1, int idContacto2) {
        this.directorioPK = new DirectorioPK(idContacto1, idContacto2);
    }

    public DirectorioPK getDirectorioPK() {
        return directorioPK;
    }

    public Directorio(Date fechaConocido, Contacto contacto, Contacto contacto1) {
        this.fechaConocido = fechaConocido;
        this.contacto = contacto;
        this.contacto1 = contacto1;
    }

    public void setDirectorioPK(DirectorioPK directorioPK) {
        this.directorioPK = directorioPK;
    }

    public Date getFechaConocido() {
        return fechaConocido;
    }

    public void setFechaConocido(Date fechaConocido) {
        this.fechaConocido = fechaConocido;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Contacto getContacto1() {
        return contacto1;
    }

    public void setContacto1(Contacto contacto1) {
        this.contacto1 = contacto1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (directorioPK != null ? directorioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Directorio)) {
            return false;
        }
        Directorio other = (Directorio) object;
        if ((this.directorioPK == null && other.directorioPK != null) || (this.directorioPK != null && !this.directorioPK.equals(other.directorioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.anotaciones.modelo.Directorio[ directorioPK=" + directorioPK + " ]";
    }
    
}
