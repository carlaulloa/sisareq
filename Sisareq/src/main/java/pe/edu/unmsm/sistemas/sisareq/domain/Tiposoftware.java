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
@Table(name = "tiposoftware")
@NamedQueries({
    @NamedQuery(name = "Tiposoftware.findAll", query = "SELECT t FROM Tiposoftware t")})
public class Tiposoftware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_software")
    private Integer idTipoSoftware;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoSoftwareId")
    private List<Software> softwareList;

    public Tiposoftware() {
    }

    public Tiposoftware(Integer idTipoSoftware) {
        this.idTipoSoftware = idTipoSoftware;
    }

    public Tiposoftware(Integer idTipoSoftware, String nombre) {
        this.idTipoSoftware = idTipoSoftware;
        this.nombre = nombre;
    }

    public Integer getIdTipoSoftware() {
        return idTipoSoftware;
    }

    public void setIdTipoSoftware(Integer idTipoSoftware) {
        this.idTipoSoftware = idTipoSoftware;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public void setSoftwareList(List<Software> softwareList) {
        this.softwareList = softwareList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSoftware != null ? idTipoSoftware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposoftware)) {
            return false;
        }
        Tiposoftware other = (Tiposoftware) object;
        if ((this.idTipoSoftware == null && other.idTipoSoftware != null) || (this.idTipoSoftware != null && !this.idTipoSoftware.equals(other.idTipoSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tiposoftware[ idTipoSoftware=" + idTipoSoftware + " ]";
    }
    
}
