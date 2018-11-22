/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.domain;

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

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "software")
@NamedQueries({
    @NamedQuery(name = "Software.findAll", query = "SELECT s FROM Software s")})
public class Software implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_software")
    private Integer idSoftware;
    @Basic(optional = false)
    @Column(name = "licencia")
    private String licencia;
    @Basic(optional = false)
    @Column(name = "fecha_instalado")
    @Temporal(TemporalType.DATE)
    private Date fechaInstalado;
    @JoinColumn(name = "hardware_id", referencedColumnName = "id_hardware")
    @ManyToOne
    private Hardware hardwareId;
    @JoinColumn(name = "activos_ti_id", referencedColumnName = "id_activos_ti")
    @ManyToOne(optional = false)
    private Activosti activosTiId;
    @JoinColumn(name = "tipo_software_id", referencedColumnName = "id_tipo_software")
    @ManyToOne(optional = false)
    private Tiposoftware tipoSoftwareId;

    public Software() {
    }

    public Software(Integer idSoftware) {
        this.idSoftware = idSoftware;
    }

    public Software(Integer idSoftware, String licencia, Date fechaInstalado) {
        this.idSoftware = idSoftware;
        this.licencia = licencia;
        this.fechaInstalado = fechaInstalado;
    }

    public Integer getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Integer idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public Date getFechaInstalado() {
        return fechaInstalado;
    }

    public void setFechaInstalado(Date fechaInstalado) {
        this.fechaInstalado = fechaInstalado;
    }

    public Hardware getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(Hardware hardwareId) {
        this.hardwareId = hardwareId;
    }

    public Activosti getActivosTiId() {
        return activosTiId;
    }

    public void setActivosTiId(Activosti activosTiId) {
        this.activosTiId = activosTiId;
    }

    public Tiposoftware getTipoSoftwareId() {
        return tipoSoftwareId;
    }

    public void setTipoSoftwareId(Tiposoftware tipoSoftwareId) {
        this.tipoSoftwareId = tipoSoftwareId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoftware != null ? idSoftware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Software)) {
            return false;
        }
        Software other = (Software) object;
        if ((this.idSoftware == null && other.idSoftware != null) || (this.idSoftware != null && !this.idSoftware.equals(other.idSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Software[ idSoftware=" + idSoftware + " ]";
    }
    
}
