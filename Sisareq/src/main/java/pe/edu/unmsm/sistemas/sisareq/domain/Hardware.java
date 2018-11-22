/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "hardware")
@NamedQueries({
    @NamedQuery(name = "Hardware.findAll", query = "SELECT h FROM Hardware h")})
public class Hardware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hardware")
    private Integer idHardware;
    @Column(name = "numero_serie")
    private String numeroSerie;
    @Column(name = "grupo_red")
    private String grupoRed;
    @Column(name = "direccion_ip")
    private String direccionIp;
    @Lob
    @Column(name = "ubicacion")
    private String ubicacion;
    @Column(name = "fecha_inst")
    private String fechaInst;
    @OneToMany(mappedBy = "hardwareId")
    private List<Software> softwareList;
    @JoinColumn(name = "activos_ti_id", referencedColumnName = "id_activos_ti")
    @ManyToOne(optional = false)
    private Activosti activosTiId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @JoinColumn(name = "tipo_hardware_id", referencedColumnName = "id_tipo_hardware")
    @ManyToOne(optional = false)
    private Tipohardware tipoHardwareId;
    @JoinColumn(name = "licencia_hardware_id", referencedColumnName = "id_licencia_hardware")
    @ManyToOne(optional = false)
    private Licenciahardware licenciaHardwareId;

    public Hardware() {
    }

    public Hardware(Integer idHardware) {
        this.idHardware = idHardware;
    }

    public Integer getIdHardware() {
        return idHardware;
    }

    public void setIdHardware(Integer idHardware) {
        this.idHardware = idHardware;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getGrupoRed() {
        return grupoRed;
    }

    public void setGrupoRed(String grupoRed) {
        this.grupoRed = grupoRed;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFechaInst() {
        return fechaInst;
    }

    public void setFechaInst(String fechaInst) {
        this.fechaInst = fechaInst;
    }

    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public void setSoftwareList(List<Software> softwareList) {
        this.softwareList = softwareList;
    }

    public Activosti getActivosTiId() {
        return activosTiId;
    }

    public void setActivosTiId(Activosti activosTiId) {
        this.activosTiId = activosTiId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Tipohardware getTipoHardwareId() {
        return tipoHardwareId;
    }

    public void setTipoHardwareId(Tipohardware tipoHardwareId) {
        this.tipoHardwareId = tipoHardwareId;
    }

    public Licenciahardware getLicenciaHardwareId() {
        return licenciaHardwareId;
    }

    public void setLicenciaHardwareId(Licenciahardware licenciaHardwareId) {
        this.licenciaHardwareId = licenciaHardwareId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHardware != null ? idHardware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hardware)) {
            return false;
        }
        Hardware other = (Hardware) object;
        if ((this.idHardware == null && other.idHardware != null) || (this.idHardware != null && !this.idHardware.equals(other.idHardware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Hardware[ idHardware=" + idHardware + " ]";
    }
    
}
