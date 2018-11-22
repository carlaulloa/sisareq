/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "documentacionproblema")
@NamedQueries({
    @NamedQuery(name = "Documentacionproblema.findAll", query = "SELECT d FROM Documentacionproblema d")})
public class Documentacionproblema implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentacionproblemaPK documentacionproblemaPK;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "documentacion")
    private String documentacion;
    @JoinColumn(name = "operador_id", referencedColumnName = "id_operador")
    @ManyToOne(optional = false)
    private Operador operadorId;
    @JoinColumn(name = "problema_id", referencedColumnName = "id_problema", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Problema problema;

    public Documentacionproblema() {
    }

    public Documentacionproblema(DocumentacionproblemaPK documentacionproblemaPK) {
        this.documentacionproblemaPK = documentacionproblemaPK;
    }

    public Documentacionproblema(DocumentacionproblemaPK documentacionproblemaPK, String estado, String descripcion, String documentacion) {
        this.documentacionproblemaPK = documentacionproblemaPK;
        this.estado = estado;
        this.descripcion = descripcion;
        this.documentacion = documentacion;
    }

    public Documentacionproblema(int problemaId, String idDocumentacionproblema) {
        this.documentacionproblemaPK = new DocumentacionproblemaPK(problemaId, idDocumentacionproblema);
    }

    public DocumentacionproblemaPK getDocumentacionproblemaPK() {
        return documentacionproblemaPK;
    }

    public void setDocumentacionproblemaPK(DocumentacionproblemaPK documentacionproblemaPK) {
        this.documentacionproblemaPK = documentacionproblemaPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    public Operador getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(Operador operadorId) {
        this.operadorId = operadorId;
    }

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentacionproblemaPK != null ? documentacionproblemaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentacionproblema)) {
            return false;
        }
        Documentacionproblema other = (Documentacionproblema) object;
        if ((this.documentacionproblemaPK == null && other.documentacionproblemaPK != null) || (this.documentacionproblemaPK != null && !this.documentacionproblemaPK.equals(other.documentacionproblemaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Documentacionproblema[ documentacionproblemaPK=" + documentacionproblemaPK + " ]";
    }
    
}
