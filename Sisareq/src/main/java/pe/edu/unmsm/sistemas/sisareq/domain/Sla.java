/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.domain;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "sla")
@NamedQueries({
    @NamedQuery(name = "Sla.findAll", query = "SELECT s FROM Sla s")})
public class Sla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sla")
    private Integer idSla;
    @Basic(optional = false)
    @Column(name = "nombre_sla")
    private String nombreSla;
    @Column(name = "tresolucion_hh")
    private Integer tresolucionHh;
    @Column(name = "tresolucion_mm")
    private Integer tresolucionMm;
    @Column(name = "tresolucion_dd")
    private Integer tresolucionDd;
    @Column(name = "trespuesta_hh")
    private Integer trespuestaHh;
    @Column(name = "trespuesta_mm")
    private Integer trespuestaMm;
    @Column(name = "trespuesta_dd")
    private Integer trespuestaDd;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "slaId")
    private List<Servicio> servicioList;

    public Sla() {
    }

    public Sla(Integer idSla) {
        this.idSla = idSla;
    }

    public Sla(Integer idSla, String nombreSla, boolean estado) {
        this.idSla = idSla;
        this.nombreSla = nombreSla;
        this.estado = estado;
    }

    public Integer getIdSla() {
        return idSla;
    }

    public void setIdSla(Integer idSla) {
        this.idSla = idSla;
    }

    public String getNombreSla() {
        return nombreSla;
    }

    public void setNombreSla(String nombreSla) {
        this.nombreSla = nombreSla;
    }

    public Integer getTresolucionHh() {
        return tresolucionHh;
    }

    public void setTresolucionHh(Integer tresolucionHh) {
        this.tresolucionHh = tresolucionHh;
    }

    public Integer getTresolucionMm() {
        return tresolucionMm;
    }

    public void setTresolucionMm(Integer tresolucionMm) {
        this.tresolucionMm = tresolucionMm;
    }

    public Integer getTresolucionDd() {
        return tresolucionDd;
    }

    public void setTresolucionDd(Integer tresolucionDd) {
        this.tresolucionDd = tresolucionDd;
    }

    public Integer getTrespuestaHh() {
        return trespuestaHh;
    }

    public void setTrespuestaHh(Integer trespuestaHh) {
        this.trespuestaHh = trespuestaHh;
    }

    public Integer getTrespuestaMm() {
        return trespuestaMm;
    }

    public void setTrespuestaMm(Integer trespuestaMm) {
        this.trespuestaMm = trespuestaMm;
    }

    public Integer getTrespuestaDd() {
        return trespuestaDd;
    }

    public void setTrespuestaDd(Integer trespuestaDd) {
        this.trespuestaDd = trespuestaDd;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSla != null ? idSla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sla)) {
            return false;
        }
        Sla other = (Sla) object;
        if ((this.idSla == null && other.idSla != null) || (this.idSla != null && !this.idSla.equals(other.idSla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Sla[ idSla=" + idSla + " ]";
    }
    
}
