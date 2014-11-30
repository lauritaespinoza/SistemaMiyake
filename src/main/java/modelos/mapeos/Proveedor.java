/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proveedor.findByTelefono1", query = "SELECT p FROM Proveedor p WHERE p.telefono1 = :telefono1"),
    @NamedQuery(name = "Proveedor.findByTelefono2", query = "SELECT p FROM Proveedor p WHERE p.telefono2 = :telefono2"),
    @NamedQuery(name = "Proveedor.findByFax", query = "SELECT p FROM Proveedor p WHERE p.fax = :fax"),
    @NamedQuery(name = "Proveedor.findByCodPostal", query = "SELECT p FROM Proveedor p WHERE p.codPostal = :codPostal"),
    @NamedQuery(name = "Proveedor.findByEmail", query = "SELECT p FROM Proveedor p WHERE p.email = :email"),
    @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedor.findByFechaModificacion", query = "SELECT p FROM Proveedor p WHERE p.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Proveedor.findByFechaCreacion", query = "SELECT p FROM Proveedor p WHERE p.fechaCreacion = :fechaCreacion")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nombre;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String telefono1;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String telefono2;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String fax;
    @Size(max = 2147483647)
    @Column(name = "cod_postal", length = 2147483647)
    private String codPostal;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proveedor", nullable = false)
    private Integer idProveedor;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @OneToMany(mappedBy = "idProveedor")
    private Collection<Factura> facturaCollection;
    @OneToMany(mappedBy = "idProveedor")
    private Collection<Producto> productoCollection;
    @JoinColumn(name = "id_contacto_gerente", referencedColumnName = "id_contacto")
    @ManyToOne
    private Contacto idContactoGerente;
    @JoinColumn(name = "id_contacto2", referencedColumnName = "id_contacto")
    @ManyToOne
    private Contacto idContacto2;
    @JoinColumn(name = "id_contacto1", referencedColumnName = "id_contacto")
    @ManyToOne
    private Contacto idContacto1;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public Proveedor(String nombre, String telefono1, String telefono2, String fax, String codPostal, String email, Contacto idContactoGerente,Contacto idContacto1, Contacto idContacto2) {
        this.nombre = nombre;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.fax = fax;
        this.codPostal = codPostal;
        this.email = email;
        this.idContactoGerente = idContactoGerente;
        this.idContacto1 = idContacto1;
        this.idContacto2 = idContacto2;
        this.fechaCreacion= new Date();
    }

    public Proveedor(String nombre, String telefono1, String telefono2, String fax, String codPostal, String email, Integer idProveedor, Date fechaModificacion, Contacto idContacto1, Contacto idContactoGerente, Contacto idContacto2) {
        this.nombre = nombre;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.fax = fax;
        this.codPostal = codPostal;
        this.email = email;
        this.idProveedor = idProveedor;
        this.fechaModificacion = fechaModificacion;
        this.idContacto1 = idContacto1;
        this.idContactoGerente = idContactoGerente;
        this.idContacto2 = idContacto2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    public Contacto getIdContactoGerente() {
        return idContactoGerente;
    }

    public void setIdContactoGerente(Contacto idContactoGerente) {
        this.idContactoGerente = idContactoGerente;
    }

    public Contacto getIdContacto2() {
        return idContacto2;
    }

    public void setIdContacto2(Contacto idContacto2) {
        this.idContacto2 = idContacto2;
    }

    public Contacto getIdContacto1() {
        return idContacto1;
    }

    public void setIdContacto1(Contacto idContacto1) {
        this.idContacto1 = idContacto1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Proveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
