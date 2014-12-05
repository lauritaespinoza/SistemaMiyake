/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

import modelos.mapeos.Almacen;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "inventario_diario", catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioDiario.findAll", query = "SELECT i FROM InventarioDiario i"),
    @NamedQuery(name = "InventarioDiario.findByIdInventarioDiario", query = "SELECT i FROM InventarioDiario i WHERE i.idInventarioDiario = :idInventarioDiario"),
    @NamedQuery(name = "InventarioDiario.findBySaldoFinal", query = "SELECT i FROM InventarioDiario i WHERE i.saldoFinal = :saldoFinal"),
    @NamedQuery(name = "InventarioDiario.findByFecha", query = "SELECT i FROM InventarioDiario i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "InventarioDiario.findBySaldoInicial", query = "SELECT i FROM InventarioDiario i WHERE i.saldoInicial = :saldoInicial")})
public class InventarioDiario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inventario_diario", nullable = false)
    private Integer idInventarioDiario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo_final", precision = 8, scale = 8)
    private Float saldoFinal;
    @Temporal(TemporalType.DATE)
    private Date fecha = Calendar.getInstance().getTime();
    @Column(name = "saldo_inicial", precision = 8, scale = 8)
    private Float saldoInicial;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "idInventarioDiario")
    private Collection<InventarioDiarioDetalle> inventarioDiarioDetalleCollection;
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen")
    @ManyToOne
    private Almacen idAlmacen;

    public InventarioDiario() {
    }

    public InventarioDiario(Integer idInventarioDiario) {
        this.idInventarioDiario = idInventarioDiario;
    }

    public Integer getIdInventarioDiario() {
        return idInventarioDiario;
    }

    public void setIdInventarioDiario(Integer idInventarioDiario) {
        this.idInventarioDiario = idInventarioDiario;
    }

    public Float getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Float saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    @XmlTransient
    public Collection<InventarioDiarioDetalle> getInventarioDiarioDetalleCollection() {
        return inventarioDiarioDetalleCollection;
    }

    public void setInventarioDiarioDetalleCollection(Collection<InventarioDiarioDetalle> inventarioDiarioDetalleCollection) {
        this.inventarioDiarioDetalleCollection = inventarioDiarioDetalleCollection;
    }

    public Almacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Almacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventarioDiario != null ? idInventarioDiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioDiario)) {
            return false;
        }
        InventarioDiario other = (InventarioDiario) object;
        if ((this.idInventarioDiario == null && other.idInventarioDiario != null) || (this.idInventarioDiario != null && !this.idInventarioDiario.equals(other.idInventarioDiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.mapeos.nev.InventarioDiario[ idInventarioDiario=" + idInventarioDiario + " ]";
    }

}
