/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
    @NamedQuery(name = "Almacen.findAll", query = "SELECT a FROM Almacen a"),
    @NamedQuery(name = "Almacen.findByNombre", query = "SELECT a FROM Almacen a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Almacen.findByTelefono1", query = "SELECT a FROM Almacen a WHERE a.telefono1 = :telefono1"),
    @NamedQuery(name = "Almacen.findByTelefono2", query = "SELECT a FROM Almacen a WHERE a.telefono2 = :telefono2"),
    @NamedQuery(name = "Almacen.findByFax", query = "SELECT a FROM Almacen a WHERE a.fax = :fax"),
    @NamedQuery(name = "Almacen.findByCodPostal", query = "SELECT a FROM Almacen a WHERE a.codPostal = :codPostal"),
    @NamedQuery(name = "Almacen.findByEmail", query = "SELECT a FROM Almacen a WHERE a.email = :email"),
    @NamedQuery(name = "Almacen.findByDescripcion", query = "SELECT a FROM Almacen a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Almacen.findByRif", query = "SELECT a FROM Almacen a WHERE a.rif = :rif"),
    @NamedQuery(name = "Almacen.findByIdAlmacen", query = "SELECT a FROM Almacen a WHERE a.idAlmacen = :idAlmacen"),
    @NamedQuery(name = "Almacen.findByLogo", query = "SELECT a FROM Almacen a WHERE a.logo = :logo")})
public class Almacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String telefono1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String telefono2;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String fax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cod_postal", nullable = false, length = 2147483647)
    private String codPostal;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String descripcion;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String rif;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_almacen", nullable = false)
    private Integer idAlmacen;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String logo;
    @OneToMany(mappedBy = "idAlmacen")
    private Collection<Factura> facturaCollection;
    @OneToMany(mappedBy = "idAlmacen")
    private Collection<InventarioDiario> inventarioDiarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacen")
    private Collection<InventarioTienda> inventarioTiendaCollection;
    @OneToMany(mappedBy = "idAlmacen")
    private Collection<ConteoMercanciaEntrada> conteoMercanciaEntradaCollection;
    @OneToMany(mappedBy = "idAlmacen")
    private Collection<NotaCreditoDebito> notaCreditoDebitoCollection;
    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion")
    @ManyToOne
    private Ubicacion idUbicacion;
    @JoinColumn(name = "id_contacto_gerente", referencedColumnName = "id_contacto")
    @ManyToOne
    private Contacto idContactoGerente;
    @OneToMany(mappedBy = "idAlmacenHasta")
    private Collection<SalidaParaTienda> salidaParaTiendaCollection;
    @OneToMany(mappedBy = "idAlmacenDesde")
    private Collection<SalidaParaTienda> salidaParaTiendaCollection1;

    public Almacen() {
    }

    public Almacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public Almacen(Integer idAlmacen, String nombre, String telefono1, String telefono2, String fax, String codPostal, String email, String descripcion) {
        this.idAlmacen = idAlmacen;
        this.nombre = nombre;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.fax = fax;
        this.codPostal = codPostal;
        this.email = email;
        this.descripcion = descripcion;
    }
    
      public Almacen(String nombre, String telefono1, String telefono2, String fax, String codPostal, String email, String descripcion, String rif, String logo, Contacto idContactoGerente, Ubicacion idUbicacion) {
        this.nombre = nombre;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.fax = fax;
        this.codPostal = codPostal;
        this.email = email;
        this.descripcion = descripcion;
        this.rif = rif;
        this.logo = logo;
        this.idContactoGerente = idContactoGerente;
        this.idUbicacion = idUbicacion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @XmlTransient
    public Collection<InventarioDiario> getInventarioDiarioCollection() {
        return inventarioDiarioCollection;
    }

    public void setInventarioDiarioCollection(Collection<InventarioDiario> inventarioDiarioCollection) {
        this.inventarioDiarioCollection = inventarioDiarioCollection;
    }

    @XmlTransient
    public Collection<InventarioTienda> getInventarioTiendaCollection() {
        return inventarioTiendaCollection;
    }

    public void setInventarioTiendaCollection(Collection<InventarioTienda> inventarioTiendaCollection) {
        this.inventarioTiendaCollection = inventarioTiendaCollection;
    }

    @XmlTransient
    public Collection<ConteoMercanciaEntrada> getConteoMercanciaEntradaCollection() {
        return conteoMercanciaEntradaCollection;
    }

    public void setConteoMercanciaEntradaCollection(Collection<ConteoMercanciaEntrada> conteoMercanciaEntradaCollection) {
        this.conteoMercanciaEntradaCollection = conteoMercanciaEntradaCollection;
    }

    @XmlTransient
    public Collection<NotaCreditoDebito> getNotaCreditoDebitoCollection() {
        return notaCreditoDebitoCollection;
    }

    public void setNotaCreditoDebitoCollection(Collection<NotaCreditoDebito> notaCreditoDebitoCollection) {
        this.notaCreditoDebitoCollection = notaCreditoDebitoCollection;
    }

    public Ubicacion getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Ubicacion idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Contacto getIdContactoGerente() {
        return idContactoGerente;
    }

    public void setIdContactoGerente(Contacto idContactoGerente) {
        this.idContactoGerente = idContactoGerente;
    }

    @XmlTransient
    public Collection<SalidaParaTienda> getSalidaParaTiendaCollection() {
        return salidaParaTiendaCollection;
    }

    public void setSalidaParaTiendaCollection(Collection<SalidaParaTienda> salidaParaTiendaCollection) {
        this.salidaParaTiendaCollection = salidaParaTiendaCollection;
    }

    @XmlTransient
    public Collection<SalidaParaTienda> getSalidaParaTiendaCollection1() {
        return salidaParaTiendaCollection1;
    }

    public void setSalidaParaTiendaCollection1(Collection<SalidaParaTienda> salidaParaTiendaCollection1) {
        this.salidaParaTiendaCollection1 = salidaParaTiendaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlmacen != null ? idAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacen)) {
            return false;
        }
        Almacen other = (Almacen) object;
        if ((this.idAlmacen == null && other.idAlmacen != null) || (this.idAlmacen != null && !this.idAlmacen.equals(other.idAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Almacen[ idAlmacen=" + idAlmacen + " ]";
    }
    
}
