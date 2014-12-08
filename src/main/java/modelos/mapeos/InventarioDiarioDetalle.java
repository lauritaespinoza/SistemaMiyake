/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.mapeos;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "inventario_diario_detalle", catalog = "miyake_pasantia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioDiarioDetalle.findAll", query = "SELECT i FROM InventarioDiarioDetalle i"),
    @NamedQuery(name = "InventarioDiarioDetalle.findByFecha", query = "SELECT i FROM InventarioDiarioDetalle i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "InventarioDiarioDetalle.findByConcepto", query = "SELECT i FROM InventarioDiarioDetalle i WHERE i.concepto = :concepto"),
    @NamedQuery(name = "InventarioDiarioDetalle.findByEntrada", query = "SELECT i FROM InventarioDiarioDetalle i WHERE i.entrada = :entrada"),
    @NamedQuery(name = "InventarioDiarioDetalle.findBySalida", query = "SELECT i FROM InventarioDiarioDetalle i WHERE i.salida = :salida"),
    @NamedQuery(name = "InventarioDiarioDetalle.findBySaldo", query = "SELECT i FROM InventarioDiarioDetalle i WHERE i.saldo = :saldo"),
    @NamedQuery(name = "InventarioDiarioDetalle.findByIdInventarioDiarioDetalle", query = "SELECT i FROM InventarioDiarioDetalle i WHERE i.idInventarioDiarioDetalle = :idInventarioDiarioDetalle")})
public class InventarioDiarioDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String concepto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 8, scale = 8)
    private Float entrada;
    @Column(precision = 8, scale = 8)
    private Float salida;
    @Column(precision = 8, scale = 8)
    private Float saldo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inventario_diario_detalle", nullable = false)
    private Integer idInventarioDiarioDetalle;
    @JoinColumn(name = "id_inventario_diario", referencedColumnName = "id_inventario_diario")
    @ManyToOne
    private InventarioDiario idInventarioDiario;

    public InventarioDiarioDetalle() {
    }

    public InventarioDiarioDetalle(Integer idInventarioDiarioDetalle) {
        this.idInventarioDiarioDetalle = idInventarioDiarioDetalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Float getEntrada() {
        return entrada;
    }

    public void setEntrada(Float entrada) {
        this.entrada = entrada;
    }

    public Float getSalida() {
        return salida;
    }

    public void setSalida(Float salida) {
        this.salida = salida;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Integer getIdInventarioDiarioDetalle() {
        return idInventarioDiarioDetalle;
    }

    public void setIdInventarioDiarioDetalle(Integer idInventarioDiarioDetalle) {
        this.idInventarioDiarioDetalle = idInventarioDiarioDetalle;
    }

    public InventarioDiario getIdInventarioDiario() {
        return idInventarioDiario;
    }

    public void setIdInventarioDiario(InventarioDiario idInventarioDiario) {
        this.idInventarioDiario = idInventarioDiario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventarioDiarioDetalle != null ? idInventarioDiarioDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioDiarioDetalle)) {
            return false;
        }
        InventarioDiarioDetalle other = (InventarioDiarioDetalle) object;
        if ((this.idInventarioDiarioDetalle == null && other.idInventarioDiarioDetalle != null) || (this.idInventarioDiarioDetalle != null && !this.idInventarioDiarioDetalle.equals(other.idInventarioDiarioDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.mapeos.nev.InventarioDiarioDetalle[ idInventarioDiarioDetalle=" + idInventarioDiarioDetalle + " ]";
    }
    
}
