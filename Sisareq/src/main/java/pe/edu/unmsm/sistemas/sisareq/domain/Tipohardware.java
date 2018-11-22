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
@Table(name = "tipohardware")
@NamedQueries({
    @NamedQuery(name = "Tipohardware.findAll", query = "SELECT t FROM Tipohardware t")})
public class Tipohardware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_hardware")
    private Integer idTipoHardware;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoHardwareId")
    private List<Hardware> hardwareList;

    public Tipohardware() {
    }

    public Tipohardware(Integer idTipoHardware) {
        this.idTipoHardware = idTipoHardware;
    }

    public Tipohardware(Integer idTipoHardware, String nombre) {
        this.idTipoHardware = idTipoHardware;
        this.nombre = nombre;
    }

    public Integer getIdTipoHardware() {
        return idTipoHardware;
    }

    public void setIdTipoHardware(Integer idTipoHardware) {
        this.idTipoHardware = idTipoHardware;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Hardware> getHardwareList() {
        return hardwareList;
    }

    public void setHardwareList(List<Hardware> hardwareList) {
        this.hardwareList = hardwareList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoHardware != null ? idTipoHardware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipohardware)) {
            return false;
        }
        Tipohardware other = (Tipohardware) object;
        if ((this.idTipoHardware == null && other.idTipoHardware != null) || (this.idTipoHardware != null && !this.idTipoHardware.equals(other.idTipoHardware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tipohardware[ idTipoHardware=" + idTipoHardware + " ]";
    }
    
}
