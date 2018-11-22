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
@Table(name = "licenciahardware")
@NamedQueries({
    @NamedQuery(name = "Licenciahardware.findAll", query = "SELECT l FROM Licenciahardware l")})
public class Licenciahardware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_licencia_hardware")
    private Integer idLicenciaHardware;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "identificador")
    private String identificador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licenciaHardwareId")
    private List<Hardware> hardwareList;

    public Licenciahardware() {
    }

    public Licenciahardware(Integer idLicenciaHardware) {
        this.idLicenciaHardware = idLicenciaHardware;
    }

    public Licenciahardware(Integer idLicenciaHardware, String codigo) {
        this.idLicenciaHardware = idLicenciaHardware;
        this.codigo = codigo;
    }

    public Integer getIdLicenciaHardware() {
        return idLicenciaHardware;
    }

    public void setIdLicenciaHardware(Integer idLicenciaHardware) {
        this.idLicenciaHardware = idLicenciaHardware;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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
        hash += (idLicenciaHardware != null ? idLicenciaHardware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licenciahardware)) {
            return false;
        }
        Licenciahardware other = (Licenciahardware) object;
        if ((this.idLicenciaHardware == null && other.idLicenciaHardware != null) || (this.idLicenciaHardware != null && !this.idLicenciaHardware.equals(other.idLicenciaHardware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Licenciahardware[ idLicenciaHardware=" + idLicenciaHardware + " ]";
    }
    
}
