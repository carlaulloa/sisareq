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
@Table(name = "historialper")
@NamedQueries({
    @NamedQuery(name = "Historialper.findAll", query = "SELECT h FROM Historialper h")})
public class Historialper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historial_per")
    private Integer idHistorialPer;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "evento")
    private String evento;
    @Basic(optional = false)
    @Column(name = "documentacion")
    private String documentacion;
    @JoinColumn(name = "per_id", referencedColumnName = "id_per")
    @ManyToOne(optional = false)
    private Per perId;

    public Historialper() {
    }

    public Historialper(Integer idHistorialPer) {
        this.idHistorialPer = idHistorialPer;
    }

    public Historialper(Integer idHistorialPer, Date fecha, String evento, String documentacion) {
        this.idHistorialPer = idHistorialPer;
        this.fecha = fecha;
        this.evento = evento;
        this.documentacion = documentacion;
    }

    public Integer getIdHistorialPer() {
        return idHistorialPer;
    }

    public void setIdHistorialPer(Integer idHistorialPer) {
        this.idHistorialPer = idHistorialPer;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    public Per getPerId() {
        return perId;
    }

    public void setPerId(Per perId) {
        this.perId = perId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorialPer != null ? idHistorialPer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historialper)) {
            return false;
        }
        Historialper other = (Historialper) object;
        if ((this.idHistorialPer == null && other.idHistorialPer != null) || (this.idHistorialPer != null && !this.idHistorialPer.equals(other.idHistorialPer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Historialper[ idHistorialPer=" + idHistorialPer + " ]";
    }
    
}
