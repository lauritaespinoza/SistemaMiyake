/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

import modelos.mapeos.Departamento;
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
    @NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d"),
    @NamedQuery(name = "Division.findByNombre", query = "SELECT d FROM Division d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Division.findByIdDivision", query = "SELECT d FROM Division d WHERE d.idDivision = :idDivision")})
public class Division implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String nombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_division", nullable = false)
    private Integer idDivision;
    @OneToMany(mappedBy = "idDivision")
    private Collection<Departamento> departamentoCollection;

   public Division() {
    }

    public Division(Integer idDivision) {
        this.idDivision = idDivision;
    }

    public Division(String nombre) {
        this.nombre = nombre;
    }

    
    public Division(Integer idDivision, String nombre) {
        this.idDivision = idDivision;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Integer idDivision) {
        this.idDivision = idDivision;
    }

    @XmlTransient
    public Collection<Departamento> getDepartamentoCollection() {
        return departamentoCollection;
    }

    public void setDepartamentoCollection(Collection<Departamento> departamentoCollection) {
        this.departamentoCollection = departamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDivision != null ? idDivision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Division)) {
            return false;
        }
        Division other = (Division) object;
        if ((this.idDivision == null && other.idDivision != null) || (this.idDivision != null && !this.idDivision.equals(other.idDivision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.mapeos.nev.Division[ idDivision=" + idDivision + " ]";
    }
    
}
