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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "activosti")
@NamedQueries({
    @NamedQuery(name = "Activosti.findAll", query = "SELECT a FROM Activosti a")})
public class Activosti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_activos_ti")
    private Integer idActivosTi;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "marca")
    private String marca;
    @Column(name = "version_activo")
    private String versionActivo;
    @JoinTable(name = "cambio", joinColumns = {
        @JoinColumn(name = "activos_ti_id", referencedColumnName = "id_activos_ti")}, inverseJoinColumns = {
        @JoinColumn(name = "rfc_id", referencedColumnName = "id_rfc")})
    @ManyToMany
    private List<Rfc> rfcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activosTiId")
    private List<Software> softwareList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activosTiId")
    private List<Hardware> hardwareList;

    public Activosti() {
    }

    public Activosti(Integer idActivosTi) {
        this.idActivosTi = idActivosTi;
    }

    public Activosti(Integer idActivosTi, String estado, String nombre, String descripcion) {
        this.idActivosTi = idActivosTi;
        this.estado = estado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdActivosTi() {
        return idActivosTi;
    }

    public void setIdActivosTi(Integer idActivosTi) {
        this.idActivosTi = idActivosTi;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getVersionActivo() {
        return versionActivo;
    }

    public void setVersionActivo(String versionActivo) {
        this.versionActivo = versionActivo;
    }

    public List<Rfc> getRfcList() {
        return rfcList;
    }

    public void setRfcList(List<Rfc> rfcList) {
        this.rfcList = rfcList;
    }

    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public void setSoftwareList(List<Software> softwareList) {
        this.softwareList = softwareList;
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
        hash += (idActivosTi != null ? idActivosTi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activosti)) {
            return false;
        }
        Activosti other = (Activosti) object;
        if ((this.idActivosTi == null && other.idActivosTi != null) || (this.idActivosTi != null && !this.idActivosTi.equals(other.idActivosTi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Activosti[ idActivosTi=" + idActivosTi + " ]";
    }
    
}
