/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

import modelos.mapeos.NotaCreditoDebito;
import modelos.mapeos.SalidaParaTienda;
import modelos.mapeos.ConteoMercanciaEntrada;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByDescripcion", query = "SELECT u FROM Usuario u WHERE u.descripcion = :descripcion"),
    @NamedQuery(name = "Usuario.findByFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Usuario.findByActivo", query = "SELECT u FROM Usuario u WHERE u.activo = :activo"),
    @NamedQuery(name = "Usuario.findByTipoUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "Usuario.findByTienda", query = "SELECT u FROM Usuario u WHERE u.tienda = :tienda"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String nombre;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String descripcion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_usuario", nullable = false)
    private short tipoUsuario;
    private Integer tienda;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String contrasena;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<ConteoMercanciaEntrada> conteoMercanciaEntradaCollection;
    @OneToMany(mappedBy = "idUsuario2")
    private Collection<NotaCreditoDebito> notaCreditoDebitoCollection;
    @OneToMany(mappedBy = "idUsuario1")
    private Collection<NotaCreditoDebito> notaCreditoDebitoCollection1;
    @OneToMany(mappedBy = "idUsuario2")
    private Collection<SalidaParaTienda> salidaParaTiendaCollection;
    @OneToMany(mappedBy = "idUsuario1")
    private Collection<SalidaParaTienda> salidaParaTiendaCollection1;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombre, boolean activo, short tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.activo = activo;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public short getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(short tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getTienda() {
        return tienda;
    }

    public void setTienda(Integer tienda) {
        this.tienda = tienda;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.mapeos.nev.Usuario[ idUsuario=" + idUsuario + " ]";
    }

}
