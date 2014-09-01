/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate.anotaciones.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.jboss.logging.annotations.Param;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = "Contacto.findByIdContacto", query = "SELECT c FROM Contacto c WHERE c.idContacto = :idContacto"),
    @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Contacto.findByCorreo", query = "SELECT c FROM Contacto c WHERE c.correo = :correo"),
    @NamedQuery(name = "Contacto.findByTelefono", query = "SELECT c FROM Contacto c WHERE c.telefono = :telefono")})
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contacto")
    private Integer idContacto;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "correo")
    private String correo;
    @Size(max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "idContacto")
    private Collection<Seguro> seguroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contacto")
    private Collection<Directorio> directorioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contacto1")
    private Collection<Directorio> directorioCollection1;

    public Contacto() {
    }
 
    public Contacto(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Contacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Seguro> getSeguroCollection() {
        return seguroCollection;
    }

    public void setSeguroCollection(Collection<Seguro> seguroCollection) {
        this.seguroCollection = seguroCollection;
    }

    @XmlTransient
    public Collection<Directorio> getDirectorioCollection() {
        return directorioCollection;
    }

    public void setDirectorioCollection(Collection<Directorio> directorioCollection) {
        this.directorioCollection = directorioCollection;
    }

    @XmlTransient
    public Collection<Directorio> getDirectorioCollection1() {
        return directorioCollection1;
    }

    public void setDirectorioCollection1(Collection<Directorio> directorioCollection1) {
        this.directorioCollection1 = directorioCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContacto != null ? idContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.idContacto == null && other.idContacto != null) || (this.idContacto != null && !this.idContacto.equals(other.idContacto))) {
            return false;
        }
        return true;
    }

   /* @Override
    public String toString() {
        return "Id: "+idContacto+" Nombre: "+nombre+" Correo: "+correo+" Telefono: "+telefono;
        //return "hibernate.anotaciones.modelo.Contacto[ idContacto=" + idContacto + " ]";
    }*/
    
}
