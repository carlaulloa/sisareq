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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "per")
@NamedQueries({
    @NamedQuery(name = "Per.findAll", query = "SELECT p FROM Per p")})
public class Per implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_per")
    private Integer idPer;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "resultados")
    private String resultados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perId")
    private List<Historialper> historialperList;
    @JoinColumn(name = "rfc_id", referencedColumnName = "id_rfc")
    @ManyToOne(optional = false)
    private Rfc rfcId;

    public Per() {
    }

    public Per(Integer idPer) {
        this.idPer = idPer;
    }

    public Per(Integer idPer, String estado, String resultados) {
        this.idPer = idPer;
        this.estado = estado;
        this.resultados = resultados;
    }

    public Integer getIdPer() {
        return idPer;
    }

    public void setIdPer(Integer idPer) {
        this.idPer = idPer;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public List<Historialper> getHistorialperList() {
        return historialperList;
    }

    public void setHistorialperList(List<Historialper> historialperList) {
        this.historialperList = historialperList;
    }

    public Rfc getRfcId() {
        return rfcId;
    }

    public void setRfcId(Rfc rfcId) {
        this.rfcId = rfcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPer != null ? idPer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Per)) {
            return false;
        }
        Per other = (Per) object;
        if ((this.idPer == null && other.idPer != null) || (this.idPer != null && !this.idPer.equals(other.idPer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Per[ idPer=" + idPer + " ]";
    }
    
}
