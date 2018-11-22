/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "soluciones")
@NamedQueries({
    @NamedQuery(name = "Soluciones.findAll", query = "SELECT s FROM Soluciones s")})
public class Soluciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_soluciones")
    private Integer idSoluciones;
    @Basic(optional = false)
    @Lob
    @Column(name = "documentacion")
    private String documentacion;
    @Basic(optional = false)
    @Column(name = "fecha_envio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @JoinColumn(name = "error_conocido_id", referencedColumnName = "id_error_conocido")
    @ManyToOne(optional = false)
    private Errorconocido errorConocidoId;
    @OneToMany(mappedBy = "solucionesId")
    private List<Atencion> atencionList;

    public Soluciones() {
    }

    public Soluciones(Integer idSoluciones) {
        this.idSoluciones = idSoluciones;
    }

    public Soluciones(Integer idSoluciones, String documentacion, Date fechaEnvio) {
        this.idSoluciones = idSoluciones;
        this.documentacion = documentacion;
        this.fechaEnvio = fechaEnvio;
    }

    public Integer getIdSoluciones() {
        return idSoluciones;
    }

    public void setIdSoluciones(Integer idSoluciones) {
        this.idSoluciones = idSoluciones;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Errorconocido getErrorConocidoId() {
        return errorConocidoId;
    }

    public void setErrorConocidoId(Errorconocido errorConocidoId) {
        this.errorConocidoId = errorConocidoId;
    }

    public List<Atencion> getAtencionList() {
        return atencionList;
    }

    public void setAtencionList(List<Atencion> atencionList) {
        this.atencionList = atencionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoluciones != null ? idSoluciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soluciones)) {
            return false;
        }
        Soluciones other = (Soluciones) object;
        if ((this.idSoluciones == null && other.idSoluciones != null) || (this.idSoluciones != null && !this.idSoluciones.equals(other.idSoluciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Soluciones[ idSoluciones=" + idSoluciones + " ]";
    }
    
}
