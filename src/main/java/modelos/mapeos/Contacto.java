/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = "Contacto.findByIdContacto", query = "SELECT c FROM Contacto c WHERE c.idContacto = :idContacto"),
    @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Contacto.findByPuesto", query = "SELECT c FROM Contacto c WHERE c.puesto = :puesto"),
    @NamedQuery(name = "Contacto.findByTelefono1", query = "SELECT c FROM Contacto c WHERE c.telefono1 = :telefono1"),
    @NamedQuery(name = "Contacto.findByTelefono2", query = "SELECT c FROM Contacto c WHERE c.telefono2 = :telefono2"),
    @NamedQuery(name = "Contacto.findByEmail", query = "SELECT c FROM Contacto c WHERE c.email = :email")})
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contacto", nullable = false)
    private Integer idContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String nombre;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String puesto;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String telefono1;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String telefono2;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String email;
    @OneToMany(mappedBy = "idContactoGerente")
    private Collection<Almacen> almacenCollection;
    @OneToMany(mappedBy = "idContacto1")
    private Collection<Proveedor> proveedorCollection;
    @OneToMany(mappedBy = "idContacto2")
    private Collection<Proveedor> proveedorCollection1;
    @OneToMany(mappedBy = "idContactoGerente")
    private Collection<Proveedor> proveedorCollection2;

    public Contacto() {
    }

    public Contacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Contacto(Integer idContacto, String nombre) {
        this.idContacto = idContacto;
        this.nombre = nombre;
    }

    public Contacto(String nombre, String puesto, String telefono1, String telefono2, String email) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email = email;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Almacen> getAlmacenCollection() {
        return almacenCollection;
    }

    public void setAlmacenCollection(Collection<Almacen> almacenCollection) {
        this.almacenCollection = almacenCollection;
    }

    @XmlTransient
    public Collection<Proveedor> getProveedorCollection() {
        return proveedorCollection;
    }

    public void setProveedorCollection(Collection<Proveedor> proveedorCollection) {
        this.proveedorCollection = proveedorCollection;
    }

    @XmlTransient
    public Collection<Proveedor> getProveedorCollection1() {
        return proveedorCollection1;
    }

    public void setProveedorCollection1(Collection<Proveedor> proveedorCollection1) {
        this.proveedorCollection1 = proveedorCollection1;
    }

    @XmlTransient
    public Collection<Proveedor> getProveedorCollection2() {
        return proveedorCollection2;
    }

    public void setProveedorCollection2(Collection<Proveedor> proveedorCollection2) {
        this.proveedorCollection2 = proveedorCollection2;
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

    @Override
    public String toString() {
        return "modelos.mapeos.nev.Contacto[ idContacto=" + idContacto + " ]";
    }
    
}
